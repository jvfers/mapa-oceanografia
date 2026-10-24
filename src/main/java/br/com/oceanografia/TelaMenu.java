package br.com.oceanografia;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TelaMenu {

    public static VBox criar(
        Runnable abrirCursos,
        Runnable abrirTrafego,
        Runnable abrirRevistas
    ) {

        // TÍTULO CENTRAL

        Label titulo = new Label("OCEANO HUB");

        titulo.setStyle(
            "-fx-font-size: 52px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #29B6F6;"
        );

        Label subtitulo = new Label(
            "Conhecimento e Oceanografia em um só lugar"
        );

        subtitulo.setStyle(
            "-fx-font-size: 18px;" +
            "-fx-text-fill: #B8C7D9;"
        );


        // OPÇÕES DO MENU

        Button especies =
            criarBotao("Espécies Marinhas");

        Button trafego =
            criarBotao("Tráfego Marítimo");

        Button revistas =
            criarBotao("Revistas Científicas");

        Button cursos =
            criarBotao("Cursos de Oceanografia");

        Button curiosidades =
            criarBotao("Curiosidades");

        Button instituicoes =
            criarBotao("Instituições");


        // AÇÕES

        cursos.setOnAction(event -> {
            abrirCursos.run();
        });

        trafego.setOnAction(event -> {
            abrirTrafego.run();
        });

        revistas.setOnAction(event -> {
            abrirRevistas.run();
        });


        // CAIXA DO MENU

        VBox opcoesMenu = new VBox(
            8,
            especies,
            trafego,
            revistas,
            cursos,
            curiosidades,
            instituicoes
        );

        opcoesMenu.setPadding(new Insets(10));

        opcoesMenu.setStyle(
            "-fx-background-color: #101A22;" +
            "-fx-background-radius: 10px;" +
            "-fx-border-color: #263D4A;" +
            "-fx-border-radius: 10px;"
        );

        opcoesMenu.setVisible(false);
        opcoesMenu.setManaged(false);


        // BOTÃO MENU

        Button botaoMenu =
            new Button("☰  MENU");

        botaoMenu.setStyle(
            "-fx-background-color: #15232D;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 16px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 8px;" +
            "-fx-padding: 10px 20px;" +
            "-fx-cursor: hand;"
        );

        botaoMenu.setOnAction(event -> {

            boolean aberto =
                opcoesMenu.isVisible();

            opcoesMenu.setVisible(!aberto);
            opcoesMenu.setManaged(!aberto);
        });


        // PARTE SUPERIOR

        VBox areaMenu = new VBox(
            5,
            botaoMenu,
            opcoesMenu
        );

        areaMenu.setAlignment(Pos.TOP_LEFT);

        HBox topo = new HBox(areaMenu);

        topo.setAlignment(Pos.TOP_LEFT);


        // CENTRO

        VBox centro = new VBox(
            10,
            titulo,
            subtitulo
        );

        centro.setAlignment(Pos.CENTER);


        // TELA COMPLETA

        VBox tela = new VBox(
            30,
            topo,
            centro
        );

        tela.setPadding(new Insets(30));

        tela.setStyle(
            "-fx-background-color: #020609;"
        );

        tela.setAlignment(Pos.TOP_LEFT);

        VBox.setVgrow(
            centro,
            Priority.ALWAYS
        );

        return tela;
    }


    // PADRÃO DOS BOTÕES

    private static Button criarBotao(String texto) {

        Button botao =
            new Button(texto);

        botao.setPrefWidth(230);

        botao.setAlignment(
            Pos.CENTER_LEFT
        );

        botao.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 15px;" +
            "-fx-padding: 12px 15px;" +
            "-fx-cursor: hand;"
        );

        return botao;
    }
}