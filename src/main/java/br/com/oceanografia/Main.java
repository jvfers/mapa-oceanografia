package br.com.oceanografia;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    private Scene scene;
private VBox telaMapa;

    @Override
    public void start(Stage stage) {

        BancoDados.criarTabela();
        
        BancoDados.criarTabelaEMEC();
        BancoDados.criarTabelaUNIFESP();
        ImportadorMEC.importar();
        
        ImportadorINEP2024.importar();

        ImportadorEMEC.importar();

        ImportadorUNIFESP.importar();

        BancoDados.atualizarEstadosEMEC();
        // TÍTULO

        Label titulo = new Label("🌊  OCEANOGRAFIA NO BRASIL");
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

        VBox cabecalho = new VBox(5, titulo, subtitulo);

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


        Label sobre = new Label("🌊  Sobre o projeto");

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
       javafx.scene.Group mapaBrasil = MapaBrasil.criarMapa(nomeEstado -> {

    VBox telaEstado = TelaEstado.criar(
        nomeEstado,
        () -> scene.setRoot(telaMapa)
    );

    scene.setRoot(telaEstado);
});
// Aumenta o mapa
mapaBrasil.setScaleX(1.20);
mapaBrasil.setScaleY(1.20);

// Área onde o mapa será exibido
StackPane areaMapa = new StackPane(mapaBrasil);

areaMapa.setMinSize(650, 600);

areaMapa.setStyle(
    "-fx-background-color: #05090D;" +
    "-fx-background-radius: 15px;"
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

        // CONTEÚDO

        HBox conteudo = new HBox(
            30,
            areaMapa,
            painelDireito
        );

        conteudo.setAlignment(Pos.CENTER);

        // TELA PRINCIPAL

        VBox principal = new VBox(
            25,
            cabecalho,
            conteudo
        );

        principal.setPadding(new Insets(30));

        principal.setStyle(
            "-fx-background-color: #020609;"
        );

 telaMapa = principal;

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


    public static void main(String[] args) {
        launch(args);
    }
}