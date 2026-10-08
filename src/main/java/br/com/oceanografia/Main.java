package br.com.oceanografia;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    private Scene scene;
    private VBox telaMapa;

    @Override
    public void start(Stage stage) {

        // BANCO DE DADOS
     
        BancoDados.criarTabela();
        BancoDados.criarTabelaEMEC();
        BancoDados.criarTabelaUNIFESP();

        ImportadorMEC.importar();
        ImportadorINEP2024.importar();
        ImportadorEMEC.importar();
        ImportadorUNIFESP.importar();

        BancoDados.atualizarEstadosEMEC();

        // TÍTULO

        Label titulo = new Label("OCEANOGRAFIA NO BRASIL");

        titulo.setStyle(
            "-fx-font-size: 30px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #2196F3;"
        );

        Label subtitulo = new Label(
            "Explore os estados e descubra as instituições que oferecem o curso de Oceanografia"
        );

        subtitulo.setStyle(
            "-fx-font-size: 16px;" +
            "-fx-text-fill: #B8C7D9;"
        );

        VBox cabecalho = new VBox(
            5,
            titulo,
            subtitulo
        );

        // PAINEL DIREITO

        Label painelTitulo = new Label("Selecione um estado");

        painelTitulo.setStyle(
            "-fx-font-size: 25px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #29B6F6;"
        );

        Label painelTexto = new Label(
            "Clique em um estado no mapa para visualizar\n" +
            "as faculdades que oferecem o curso\n" +
            "de Oceanografia."
        );

        painelTexto.setStyle(
            "-fx-font-size: 16px;" +
            "-fx-text-fill: #B8C7D9;"
        );

        Label sobre = new Label("Sobre o projeto");

        sobre.setStyle(
            "-fx-font-size: 20px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: white;"
        );

        Label descricao = new Label(
            "Este mapa apresenta as instituições públicas\n" +
            "e privadas que oferecem o curso de Oceanografia\n" +
            "no Brasil, organizadas por estado."
        );

        descricao.setStyle(
            "-fx-font-size: 15px;" +
            "-fx-text-fill: #B8C7D9;"
        );

        VBox painelDireito = new VBox(
            25,
            painelTitulo,
            painelTexto,
            sobre,
            descricao
        );

        painelDireito.setPadding(new Insets(30));
        painelDireito.setMinWidth(400);

        painelDireito.setStyle(
            "-fx-background-color: #0D141A;" +
            "-fx-background-radius: 15px;" +
            "-fx-border-color: #263D4A;" +
            "-fx-border-radius: 15px;"
        );

        // MAPA DO BRASIL

        javafx.scene.Group mapaBrasil =
            MapaBrasil.criarMapa(nomeEstado -> {

                VBox telaEstado = TelaEstado.criar(
                    nomeEstado,
                    () -> scene.setRoot(telaMapa)
                );

                scene.setRoot(telaEstado);
            });

        mapaBrasil.setScaleX(1.20);
        mapaBrasil.setScaleY(1.20);

        // ÁREA DO MAPA

        StackPane areaMapa = new StackPane(mapaBrasil);

        areaMapa.setMinSize(650, 600);

        areaMapa.setStyle(
            "-fx-background-color: #05090D;" +
            "-fx-background-radius: 15px;"
        );

        // CONTEÚDO PRINCIPAL

        HBox conteudo = new HBox(
            30,
            areaMapa,
            painelDireito
        );

        conteudo.setAlignment(Pos.CENTER);

        // BOTÃO INFORMAÇÕES

        Button botaoNovaTela = new Button("Informações");

        botaoNovaTela.setStyle(
            "-fx-background-color: #15232D;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 15px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 8px;" +
            "-fx-padding: 10px 22px;" +
            "-fx-cursor: hand;"
        );

        botaoNovaTela.setOnAction(event -> {

            VBox novaTela = criarNovaTela();

            scene.setRoot(novaTela);
        });

        // POSIÇÃO DO BOTÃO

        HBox areaBotao = new HBox(botaoNovaTela);

        areaBotao.setAlignment(Pos.CENTER_LEFT);

        // Move o botão para cima e para a direita
        areaBotao.setPadding(
            new Insets(-80, 0, 0, 40)
        );


        // TELA PRINCIPAL

        VBox principal = new VBox(
            20,
            cabecalho,
            conteudo,
            areaBotao
        );

        principal.setPadding(new Insets(30));

        principal.setStyle(
            "-fx-background-color: #020609;"
        );

        telaMapa = principal;

        // SCENE

        scene = new Scene(
            telaMapa,
            1200,
            750
        );

        // JANELA

        stage.setTitle("Mapa da Oceanografia");

        stage.setScene(scene);

        stage.setMinWidth(1100);
        stage.setMinHeight(700);

        stage.show();
    }

    // TELA DE INFORMAÇÕES

    private VBox criarNovaTela() {

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

        botaoVoltar.setOnAction(
            event -> scene.setRoot(telaMapa)
        );


        // TÍTULO

        Label titulo = new Label("INFORMAÇÕES");

        titulo.setStyle(
            "-fx-font-size: 30px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #29B6F6;"
        );


        // TEXTO

        Label texto = new Label(
            "Esta é a nova tela do sistema.\n\n" +
            "O conteúdo desta página poderá ser " +
            "adicionado posteriormente."
        );

        texto.setWrapText(true);

        texto.setStyle(
            "-fx-font-size: 17px;" +
            "-fx-text-fill: #B8C7D9;"
        );

        // CAIXA DE CONTEÚDO

        VBox caixa = new VBox(
            20,
            titulo,
            texto
        );

        caixa.setPadding(new Insets(30));

        caixa.setStyle(
            "-fx-background-color: #0D141A;" +
            "-fx-background-radius: 15px;" +
            "-fx-border-color: #263D4A;" +
            "-fx-border-radius: 15px;"
        );

        // TELA

        VBox novaTela = new VBox(
            25,
            botaoVoltar,
            caixa
        );

        novaTela.setPadding(new Insets(35));

        novaTela.setStyle(
            "-fx-background-color: #020609;"
        );

        return novaTela;
    }

    // INICIAR PROGRAMA

    public static void main(String[] args) {
        launch(args);
    }
}