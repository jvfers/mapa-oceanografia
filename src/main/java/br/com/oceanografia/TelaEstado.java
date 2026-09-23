package br.com.oceanografia;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TelaEstado {

    public static VBox criar(String nomeEstado, Runnable voltar) {

        // BOTÃO VOLTAR

        Button botaoVoltar = new Button("Voltar ao mapa");

        botaoVoltar.setStyle(
            "-fx-background-color: #15232D;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 15px;" +
            "-fx-background-radius: 8px;" +
            "-fx-padding: 10px 18px;" +
            "-fx-cursor: hand;"
        );

        botaoVoltar.setOnAction(event -> voltar.run());

        // CABEÇALHO

        Label titulo = new Label(nomeEstado);

        titulo.setStyle(
            "-fx-font-size: 32px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #29B6F6;"
        );

        Label subtitulo = new Label(
            "Informações sobre os cursos de Oceanografia neste estado"
        );

        subtitulo.setStyle(
            "-fx-font-size: 17px;" +
            "-fx-text-fill: #B8C7D9;"
        );

        // CONTEÚDO

        VBox conteudo = new VBox(12);

        conteudo.setPadding(
            new Insets(10, 15, 35, 0)
        );

        conteudo.setFillWidth(true);

        // CURSOS DE GRADUAÇÃO

        Label tituloGraduacao =
            criarTituloSecao("Cursos de Graduação");

        String resultadoGraduacao =
            BancoDados.buscarPorEstado(nomeEstado);

        Label graduacao =
            criarCaixa(resultadoGraduacao);

        conteudo.getChildren().addAll(
            tituloGraduacao,
            graduacao
        );

        // E-MEC

        Label tituloEMEC =
            criarTituloSecao("Informações do e-MEC");

        String resultadoEMEC =
            BancoDados.buscarEMECPorEstado(nomeEstado);

        Label emec =
            criarCaixa(resultadoEMEC);

        conteudo.getChildren().addAll(
            tituloEMEC,
            emec
        );

        // UNIFESP - SOMENTE SÃO PAULO

        if (
            nomeEstado.equalsIgnoreCase("São Paulo") ||
            nomeEstado.equalsIgnoreCase("Sao Paulo")
        ) {

            Label tituloUNIFESP =
                criarTituloSecao(
                    "UNIFESP - Turmas de Oceanografia 2024"
                );

            String resultadoUNIFESP =
                BancoDados.buscarTurmasUNIFESP();

            Label unifesp =
                criarCaixa(resultadoUNIFESP);

            conteudo.getChildren().addAll(
                tituloUNIFESP,
                unifesp
            );
        }

        // FONTES

        Label tituloFontes =
            criarTituloSecao("Fontes dos Dados");

        String textoFontes =
            "MEC - Cursos de Graduação do Brasil\n" +
            "INEP - Censo da Educação Superior 2024\n" +
            "e-MEC - Cadastro Nacional de Cursos e Instituições";

        if (
            nomeEstado.equalsIgnoreCase("São Paulo") ||
            nomeEstado.equalsIgnoreCase("Sao Paulo")
        ) {
            textoFontes +=
                "\nUNIFESP - Turmas de Oceanografia 2024";
        }

        Label fontes =
            criarCaixa(textoFontes);

        conteudo.getChildren().addAll(
            tituloFontes,
            fontes
        );

        // ÁREA DE ROLAGEM

        ScrollPane scroll =
            new ScrollPane(conteudo);

        scroll.setFitToWidth(true);

        scroll.setStyle(
            "-fx-background: #05090D;" +
            "-fx-background-color: #05090D;" +
            "-fx-border-color: transparent;"
        );

        // TELA COMPLETA

        VBox tela = new VBox(
            20,
            botaoVoltar,
            titulo,
            subtitulo,
            scroll
        );

        tela.setPadding(
            new Insets(35)
        );

        tela.setStyle(
            "-fx-background-color: #05090D;"
        );

        VBox.setVgrow(
            scroll,
            Priority.ALWAYS
        );

        return tela;
    }

    // TÍTULO DAS SEÇÕES

    private static Label criarTituloSecao(
        String texto
    ) {

        Label titulo = new Label(texto);

        titulo.setStyle(
            "-fx-font-size: 22px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #29B6F6;" +
            "-fx-padding: 20px 0 5px 0;"
        );

        return titulo;
    }

    // CAIXAS DE INFORMAÇÕES

    private static Label criarCaixa(
        String texto
    ) {

        Label caixa = new Label(texto);

        caixa.setWrapText(true);

        caixa.setMaxWidth(
            Double.MAX_VALUE
        );

        caixa.setStyle(
            "-fx-font-size: 16px;" +
            "-fx-text-fill: white;" +
            "-fx-background-color: #101A22;" +
            "-fx-background-radius: 10px;" +
            "-fx-padding: 20px;"
        );

        return caixa;
    }
}