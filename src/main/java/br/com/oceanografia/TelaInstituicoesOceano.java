
package br.com.oceanografia;

import java.awt.Desktop;
import java.net.URI;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TelaInstituicoesOceano {

    private static final String FUNDO = "#05090D";
    private static final String AZUL = "#29B6F6";
    private static final String TEXTO = "#EAF4FA";
    private static final String SECUNDARIO = "#A9BAC7";
    private static final String CARTAO = "#101B24";

    public static VBox criar(Runnable voltar) {

        VBox tela = new VBox(18);
        tela.setPadding(new Insets(24));
        tela.setStyle("-fx-background-color: " + FUNDO + ";");

        // Cabeçalho
        Button botaoVoltar = new Button("← Voltar");
        botaoVoltar.setCursor(Cursor.HAND);
        botaoVoltar.setStyle(
            "-fx-background-color: #142532;" +
            "-fx-text-fill: " + TEXTO + ";" +
            "-fx-font-size: 14px;" +
            "-fx-padding: 10 18;" +
            "-fx-background-radius: 8;"
        );
        botaoVoltar.setOnAction(event -> voltar.run());

        Label titulo = new Label("INSTITUIÇÕES OCEÂNICAS");
        titulo.setStyle(
            "-fx-text-fill: " + AZUL + ";" +
            "-fx-font-size: 27px;" +
            "-fx-font-weight: bold;"
        );
        titulo.setWrapText(true);

        Label subtitulo = new Label(
            "Conheça as organizações brasileiras que pesquisam, " +
            "monitoram e contribuem para a compreensão dos oceanos."
        );
        subtitulo.setWrapText(true);
        subtitulo.setStyle(
            "-fx-text-fill: " + SECUNDARIO + ";" +
            "-fx-font-size: 15px;"
        );

        VBox cabecalho = new VBox(12, botaoVoltar, titulo, subtitulo);
        cabecalho.setPadding(new Insets(0, 0, 8, 0));

        // Cartões das instituições
        VBox lista = new VBox(16);

        lista.getChildren().addAll(
            criarCartao(
                "INPO",
                "Instituto Nacional de Pesquisas Oceânicas",
                "Organização social vinculada ao Ministério da Ciência, " +
                "Tecnologia e Inovação. Atua no apoio à pesquisa oceânica, " +
                "na articulação da comunidade científica e no desenvolvimento " +
                "de iniciativas voltadas ao conhecimento e à sustentabilidade " +
                "dos oceanos.",
                "https://inpo.org.br/"
            ),

            criarCartao(
                "MARINHA DO BRASIL",
                "Diretoria de Hidrografia e Navegação (DHN)",
                "A DHN desenvolve atividades relacionadas à hidrografia, " +
                "à oceanografia, à meteorologia marítima e à segurança da " +
                "navegação. Também coordena atividades e serviços ligados " +
                "ao conhecimento das águas sob jurisdição brasileira.",
                "https://www.marinha.mil.br/dhn/"
            ),

            criarCartao(
                "CHM",
                "Centro de Hidrografia da Marinha",
                "Responsável por serviços e informações como dados " +
                "oceanográficos, previsão de marés, meteorologia marinha, " +
                "cartas náuticas e informações importantes para a navegação. " +
                "Também gerencia o Banco Nacional de Dados Oceanográficos.",
                "https://www.marinha.mil.br/chm/"
            ),

            criarCartao(
                "IEAPM",
                "Instituto de Estudos do Mar Almirante Paulo Moreira",
                "Instituição de pesquisa da Marinha do Brasil que desenvolve " +
                "estudos em áreas como oceanografia física e biológica, " +
                "geologia e geofísica marinha e interação entre oceano e atmosfera.",
                "https://www.marinha.mil.br/ieapm/"
            ),

            criarCartao(
                "INPE",
                "Instituto Nacional de Pesquisas Espaciais",
                "Contribui para o estudo do sistema terrestre por meio de " +
                "pesquisas e tecnologias de observação. Seus grupos científicos " +
                "investigam temas como a interação entre oceano e atmosfera, " +
                "o Atlântico Sul e as regiões polares.",
                "https://www.gov.br/inpe/pt-br"
            ),

            criarCartao(
                "FURG",
                "Universidade Federal do Rio Grande",
                "Universidade com forte atuação nas ciências do mar. Desenvolve " +
                "pesquisas, forma profissionais e promove estudos relacionados " +
                "à oceanografia, aos ecossistemas marinhos e às regiões costeiras.",
                "https://www.furg.br/"
            ),

            criarCartao(
                "IOUSP",
                "Instituto Oceanográfico da Universidade de São Paulo",
                "Instituto universitário dedicado à pesquisa, ao ensino e à " +
                "formação científica em oceanografia, contribuindo para o " +
                "conhecimento dos processos físicos, químicos, geológicos " +
                "e biológicos do oceano.",
                "https://www.io.usp.br/"
            )
        );

        ScrollPane rolagem = new ScrollPane(lista);
        rolagem.setFitToWidth(true);
        rolagem.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        rolagem.setStyle(
            "-fx-background: " + FUNDO + ";" +
            "-fx-background-color: " + FUNDO + ";" +
            "-fx-border-color: transparent;"
        );
        VBox.setVgrow(rolagem, Priority.ALWAYS);

        tela.getChildren().addAll(cabecalho, rolagem);

        return tela;
    }

    private static VBox criarCartao(
            String sigla,
            String nome,
            String descricao,
            String url) {

        VBox cartao = new VBox(10);
        cartao.setPadding(new Insets(20));
        cartao.setStyle(
            "-fx-background-color: " + CARTAO + ";" +
            "-fx-background-radius: 12;" +
            "-fx-border-color: #203746;" +
            "-fx-border-radius: 12;"
        );

        Label identificacao = new Label(sigla);
        identificacao.setStyle(
            "-fx-text-fill: " + AZUL + ";" +
            "-fx-font-size: 12px;" +
            "-fx-font-weight: bold;"
        );

        Label titulo = new Label(nome);
        titulo.setWrapText(true);
        titulo.setStyle(
            "-fx-text-fill: " + TEXTO + ";" +
            "-fx-font-size: 19px;" +
            "-fx-font-weight: bold;"
        );

        Label texto = new Label(descricao);
        texto.setWrapText(true);
        texto.setStyle(
            "-fx-text-fill: " + SECUNDARIO + ";" +
            "-fx-font-size: 14px;" +
            "-fx-line-spacing: 4px;"
        );

        Button botaoSite = new Button("Acessar site oficial ↗");
        botaoSite.setCursor(Cursor.HAND);
        botaoSite.setStyle(
            "-fx-background-color: #12384B;" +
            "-fx-text-fill: " + AZUL + ";" +
            "-fx-font-size: 13px;" +
            "-fx-font-weight: bold;" +
            "-fx-padding: 10 14;" +
            "-fx-background-radius: 7;"
        );
        botaoSite.setOnAction(event -> abrirSite(url));

        cartao.getChildren().addAll(
            identificacao,
            titulo,
            texto,
            botaoSite
        );

        return cartao;
    }

    private static void abrirSite(String url) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            }
        } catch (Exception e) {
            System.err.println(
                "Não foi possível abrir o site: " + url
            );
            e.printStackTrace();
        }
    }
}
