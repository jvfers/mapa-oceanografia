package br.com.oceanografia;

import java.awt.Desktop;
import java.net.URI;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TelaTrafegoMaritimo {

    private static final String LINK_MARINE_TRAFFIC =
        "https://www.marinetraffic.com/en/ais/home/centerx:-12.0/centery:25.0/zoom:4";


    public static VBox criar(Runnable voltar) {

        // BOTÃO VOLTAR

        Button botaoVoltar =
            new Button("Voltar ao OCEANO HUB");

        botaoVoltar.setStyle(
            "-fx-background-color: #15232D;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 14px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 8px;" +
            "-fx-padding: 10px 18px;" +
            "-fx-cursor: hand;"
        );

        botaoVoltar.setOnAction(
            event -> voltar.run()
        );


        // TÍTULO

        Label titulo =
            new Label("TRÁFEGO MARÍTIMO");

        titulo.setStyle(
            "-fx-font-size: 36px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #29B6F6;"
        );


        Label subtitulo = new Label(
            "Explore o tráfego de navios e conheça mais sobre a navegação marítima."
        );

        subtitulo.setStyle(
            "-fx-font-size: 17px;" +
            "-fx-text-fill: #B8C7D9;"
        );


        // MAPA DE NAVIOS

        Label tituloMapa =
            new Label("Acompanhar navios");

        tituloMapa.setStyle(
            "-fx-font-size: 23px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: white;"
        );


        Label textoMapa = new Label(
            "Consulte o mapa do MarineTraffic para acompanhar " +
            "a movimentação de embarcações e visualizar " +
            "informações disponíveis sobre o tráfego marítimo."
        );

        textoMapa.setWrapText(true);

        textoMapa.setStyle(
            "-fx-font-size: 15px;" +
            "-fx-text-fill: #B8C7D9;"
        );


        Button botaoMarineTraffic =
            new Button("Abrir mapa de navios");

        botaoMarineTraffic.setStyle(
            "-fx-background-color: #0288D1;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 15px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 8px;" +
            "-fx-padding: 12px 22px;" +
            "-fx-cursor: hand;"
        );

        botaoMarineTraffic.setOnAction(
            event -> abrirMarineTraffic()
        );


        VBox caixaMapa = new VBox(
            15,
            tituloMapa,
            textoMapa,
            botaoMarineTraffic
        );

        caixaMapa.setPadding(
            new Insets(25)
        );

        caixaMapa.setStyle(
            "-fx-background-color: #0D141A;" +
            "-fx-background-radius: 12px;" +
            "-fx-border-color: #263D4A;" +
            "-fx-border-radius: 12px;"
        );


        // INFORMAÇÕES

        VBox caixaAIS = criarCaixa(
            "O que é AIS?",
            "AIS é um sistema utilizado para transmitir e " +
            "receber informações sobre embarcações, auxiliando " +
            "na identificação e no acompanhamento do tráfego marítimo."
        );


        VBox caixaNavios = criarCaixa(
            "Tipos de navios",
            "O tráfego marítimo envolve diferentes tipos de " +
            "embarcações, como navios porta-contêineres, " +
            "petroleiros, graneleiros, navios de passageiros, " +
            "rebocadores e outras embarcações."
        );


        VBox caixaPortos = criarCaixa(
            "Portos",
            "Os portos são pontos importantes para o transporte " +
            "marítimo, permitindo operações de carga, descarga, " +
            "abastecimento e movimentação de passageiros."
        );


        VBox caixaNavegacao = criarCaixa(
            "Navegação marítima",
            "A navegação marítima utiliza sistemas de posicionamento, " +
            "comunicação e monitoramento para auxiliar as embarcações " +
            "durante suas rotas."
        );


        // LINHA 1

        HBox linha1 = new HBox(
            20,
            caixaAIS,
            caixaNavios
        );

        HBox.setHgrow(
            caixaAIS,
            Priority.ALWAYS
        );

        HBox.setHgrow(
            caixaNavios,
            Priority.ALWAYS
        );


        // LINHA 2

        HBox linha2 = new HBox(
            20,
            caixaPortos,
            caixaNavegacao
        );

        HBox.setHgrow(
            caixaPortos,
            Priority.ALWAYS
        );

        HBox.setHgrow(
            caixaNavegacao,
            Priority.ALWAYS
        );


        // FONTE

        Label fonte = new Label(
            "Fonte para consulta de tráfego marítimo: MarineTraffic"
        );

        fonte.setStyle(
            "-fx-font-size: 13px;" +
            "-fx-text-fill: #78909C;"
        );


        // TELA COMPLETA

        VBox tela = new VBox(
            20,
            botaoVoltar,
            titulo,
            subtitulo,
            caixaMapa,
            linha1,
            linha2,
            fonte
        );

        tela.setPadding(
            new Insets(30)
        );

        tela.setStyle(
            "-fx-background-color: #020609;"
        );

        return tela;
    }


    // CRIAR CAIXAS

    private static VBox criarCaixa(
        String tituloTexto,
        String descricaoTexto
    ) {

        Label titulo =
            new Label(tituloTexto);

        titulo.setStyle(
            "-fx-font-size: 19px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #29B6F6;"
        );


        Label descricao =
            new Label(descricaoTexto);

        descricao.setWrapText(true);

        descricao.setStyle(
            "-fx-font-size: 14px;" +
            "-fx-text-fill: #B8C7D9;"
        );


        VBox caixa = new VBox(
            10,
            titulo,
            descricao
        );

        caixa.setPadding(
            new Insets(20)
        );

        caixa.setMaxWidth(
            Double.MAX_VALUE
        );

        caixa.setStyle(
            "-fx-background-color: #101A22;" +
            "-fx-background-radius: 10px;" +
            "-fx-border-color: #263D4A;" +
            "-fx-border-radius: 10px;"
        );

        return caixa;
    }


    // ABRIR MARINETRAFFIC NO NAVEGADOR

    private static void abrirMarineTraffic() {

        try {

            if (Desktop.isDesktopSupported()) {

                Desktop.getDesktop().browse(
                    new URI(LINK_MARINE_TRAFFIC)
                );
            }

        } catch (Exception erro) {

            System.out.println(
                "Não foi possível abrir o MarineTraffic."
            );

            erro.printStackTrace();
        }
    }
}