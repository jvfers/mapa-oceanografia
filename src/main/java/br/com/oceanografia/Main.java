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

    private VBox telaMenu;

    @Override
    public void start(Stage stage) {

        // ==========================================
        // BANCO DE DADOS
        // ==========================================

        BancoDados.criarTabela();
        BancoDados.criarTabelaEMEC();
        BancoDados.criarTabelaUNIFESP();

        ImportadorMEC.importar();
        ImportadorINEP2024.importar();
        ImportadorEMEC.importar();
        ImportadorUNIFESP.importar();

        BancoDados.atualizarEstadosEMEC();

        // ==========================================
        // TÍTULO DO MAPA
        // ==========================================

        Label titulo = new Label("OCEANOGRAFIA NO BRASIL");

        titulo.setStyle(
            "-fx-font-size: 30px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #2196F3;"
        );

        Label subtitulo = new Label(
            "Explore os estados e descubra as instituições " +
            "que oferecem o curso de Oceanografia"
        );

        subtitulo.setStyle(
            "-fx-font-size: 16px;" +
            "-fx-text-fill: #B8C7D9;"
        );

        subtitulo.setWrapText(true);

        VBox cabecalho = new VBox(
            5,
            titulo,
            subtitulo
        );

        // ==========================================
        // PAINEL DIREITO
        // ==========================================

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

        // ==========================================
        // MAPA DO BRASIL
        // ==========================================

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

        // ==========================================
        // ÁREA DO MAPA
        // ==========================================

        StackPane areaMapa = new StackPane(mapaBrasil);

        areaMapa.setMinSize(650, 600);

        areaMapa.setStyle(
            "-fx-background-color: #05090D;" +
            "-fx-background-radius: 15px;"
        );

        // ==========================================
        // CONTEÚDO DO MAPA
        // ==========================================

        HBox conteudo = new HBox(
            30,
            areaMapa,
            painelDireito
        );

        conteudo.setAlignment(Pos.CENTER);

        // ==========================================
        // BOTÃO VOLTAR AO OCEANO HUB
        // ==========================================

        Button botaoVoltar =
            new Button("← Voltar ao OCEANO HUB");

        botaoVoltar.setStyle(
            "-fx-background-color: #15232D;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 14px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 8px;" +
            "-fx-padding: 10px 18px;" +
            "-fx-cursor: hand;"
        );

        botaoVoltar.setOnAction(event -> {
            scene.setRoot(telaMenu);
        });

        HBox areaBotaoVoltar = new HBox(botaoVoltar);
        areaBotaoVoltar.setAlignment(Pos.CENTER_LEFT);

        // ==========================================
        // TELA DO MAPA
        // ==========================================

        VBox principal = new VBox(
            15,
            areaBotaoVoltar,
            cabecalho,
            conteudo
        );

        principal.setPadding(new Insets(30));

        principal.setStyle(
            "-fx-background-color: #020609;"
        );

        telaMapa = principal;

        // ==========================================
        // OCEANO HUB - MENU PRINCIPAL
        // ==========================================

        telaMenu = TelaMenu.criar(

            // 1 - CURSOS DE OCEANOGRAFIA (MAPA)

            () -> {
                scene.setRoot(telaMapa);
            },

            // 2 - TRÁFEGO MARÍTIMO

            () -> {

                VBox telaTrafego =
                    TelaTrafegoMaritimo.criar(
                        () -> scene.setRoot(telaMenu)
                    );

                scene.setRoot(telaTrafego);
            },

            // 3 - REVISTAS CIENTÍFICAS

            () -> {

                VBox telaRevistas =
                    TelaRevistas.criar(
                        () -> scene.setRoot(telaMenu)
                    );

                scene.setRoot(telaRevistas);
            },

            // 4 - ESPÉCIES MARINHAS (WoRMS)

            () -> {

                VBox telaEspecies =
                    TelaWoRMS.criar(
                        () -> scene.setRoot(telaMenu)
                    );

                scene.setRoot(telaEspecies);
            },

            // 5 - INSTITUIÇÕES OCEÂNICAS

            () -> {

                VBox telaInstituicoes =
                    TelaInstituicoesOceano.criar(
                        () -> scene.setRoot(telaMenu)
                    );

                scene.setRoot(telaInstituicoes);
            },

            // 6 - CURSOS RELACIONADOS

            () -> {

                VBox telaCursosRelacionados =
                    TelaCursosRelacionados.criar(
                        () -> scene.setRoot(telaMenu)
                    );

                scene.setRoot(telaCursosRelacionados);
            }

        );

        // ==========================================
        // SCENE
        // ==========================================

        scene = new Scene(
            telaMenu,
            1200,
            750
        );

        // ==========================================
        // JANELA
        // ==========================================

        stage.setTitle("Oceano Hub");

        stage.setScene(scene);

        stage.setMinWidth(1100);
        stage.setMinHeight(700);

        stage.show();
    }

    // ==========================================
    // INICIAR PROGRAMA
    // ==========================================

    public static void main(String[] args) {
        launch(args);
    }
}