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

public class TelaCursosRelacionados {

    private static final String FUNDO = "#05090D";
    private static final String AZUL = "#29B6F6";
    private static final String TEXTO = "#EAF4FA";
    private static final String SECUNDARIO = "#A9BAC7";
    private static final String CARTAO = "#101B24";

    public static VBox criar(Runnable voltar) {

        VBox tela = new VBox(20);
        tela.setPadding(new Insets(25));
        tela.setStyle("-fx-background-color: " + FUNDO + ";");

        // BOTÃO VOLTAR

        Button botaoVoltar = new Button("← Voltar ao mapa");

        botaoVoltar.setCursor(Cursor.HAND);

        botaoVoltar.setStyle(
            "-fx-background-color: #142532;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 14px;" +
            "-fx-padding: 10 18;" +
            "-fx-background-radius: 8;"
        );

        botaoVoltar.setOnAction(event -> voltar.run());

        // TÍTULO

        Label titulo = new Label(
            "CURSOS RELACIONADOS À OCEANOGRAFIA NO BRASIL"
        );

        titulo.setWrapText(true);

        titulo.setStyle(
            "-fx-text-fill: " + AZUL + ";" +
            "-fx-font-size: 27px;" +
            "-fx-font-weight: bold;"
        );

        Label subtitulo = new Label(
            "Conheça as principais graduações relacionadas " +
            "ao estudo dos oceanos, ambientes costeiros e " +
            "recursos marinhos, além de exemplos de onde estudar."
        );

        subtitulo.setWrapText(true);

        subtitulo.setStyle(
            "-fx-text-fill: " + SECUNDARIO + ";" +
            "-fx-font-size: 15px;"
        );

        VBox cabecalho = new VBox(
            12,
            botaoVoltar,
            titulo,
            subtitulo
        );

        // LISTA DOS CURSOS

        VBox lista = new VBox(18);

        lista.getChildren().addAll(

            criarCartao(
                "OCEANOGRAFIA",
                "Bacharelado",
                "Curso dedicado ao estudo dos oceanos, " +
                "integrando conhecimentos de física, química, " +
                "biologia e geologia. O profissional pode atuar " +
                "em pesquisa, monitoramento ambiental, " +
                "conservação marinha e gestão costeira.",
                "Onde estudar:\n" +
                "• USP — São Paulo (SP)\n" +
                "• UNIFESP — Santos (SP)\n" +
                "• UFSC — Florianópolis (SC)\n" +
                "• UNIVALI — Itajaí (SC)\n" +
                "• UFPR — Pontal do Paraná (PR)\n" +
                "• UERJ — Rio de Janeiro (RJ)\n" +
                "• UFES — Vitória (ES)\n" +
                "• UFBA — Salvador (BA)\n" +
                "• UFPE — Recife (PE)\n" +
                "• UFC — Fortaleza (CE)\n" +
                "• UFMA — São Luís (MA)\n" +
                "• UFPA — Belém (PA)",
                "https://cienciasdomarbrasil.furg.br/ensino/graduacao/graduacao-oceanografia"
            ),

            criarCartao(
                "OCEANOLOGIA",
                "Bacharelado",
                "Formação equivalente à Oceanografia, " +
                "voltada ao estudo integrado dos processos " +
                "físicos, químicos, geológicos e biológicos " +
                "dos oceanos e ambientes costeiros.",
                "Onde estudar:\n" +
                "• FURG — Rio Grande (RS)\n" +
                "• UFSB — Porto Seguro (BA)",
                "https://www.furg.br/graduacao/oceanologia"
            ),

            criarCartao(
                "CIÊNCIAS BIOLÓGICAS",
                "Bacharelado ou Licenciatura",
                "Estuda os seres vivos e suas relações com " +
                "o ambiente. Na área marinha, permite " +
                "desenvolver pesquisas sobre biodiversidade, " +
                "ecologia, conservação e organismos aquáticos.",
                "Exemplos de onde estudar:\n" +
                "• USP — São Paulo (SP)\n" +
                "• UFRJ — Rio de Janeiro (RJ)\n" +
                "• UFSC — Florianópolis (SC)\n" +
                "• UFPE — Recife (PE)",
                "https://www.gov.br/mec/pt-br"
            ),

            criarCartao(
                "ENGENHARIA DE PESCA",
                "Bacharelado",
                "Forma profissionais para atuar no " +
                "aproveitamento sustentável dos recursos " +
                "pesqueiros, na tecnologia do pescado, " +
                "na gestão da pesca e em atividades " +
                "relacionadas aos ambientes aquáticos.",
                "Exemplos de onde estudar:\n" +
                "• UFC — Fortaleza (CE)\n" +
                "• UFRPE — Recife (PE)\n" +
                "• UFRA — Belém (PA)",
                "https://www.ufrpe.br/"
            ),

            criarCartao(
                "ENGENHARIA DE AQUICULTURA",
                "Bacharelado",
                "Curso voltado à produção e ao cultivo " +
                "de organismos aquáticos, incluindo peixes, " +
                "moluscos, crustáceos e algas. Abrange " +
                "tecnologias de produção, sustentabilidade " +
                "e qualidade da água.",
                "Onde estudar:\n" +
                "• UFSC — Florianópolis (SC)",
                "https://aquicultura.grad.ufsc.br/"
            ),

            criarCartao(
                "GEOLOGIA",
                "Bacharelado",
                "Estuda a estrutura, a composição e " +
                "a evolução da Terra. Pode envolver " +
                "pesquisas sobre sedimentos oceânicos, " +
                "fundos marinhos, erosão costeira " +
                "e recursos geológicos.",
                "Exemplos de onde estudar:\n" +
                "• USP — São Paulo (SP)\n" +
                "• UFRJ — Rio de Janeiro (RJ)\n" +
                "• UFBA — Salvador (BA)\n" +
                "• UFPR — Curitiba (PR)",
                "https://www.gov.br/mec/pt-br"
            ),

            criarCartao(
                "METEOROLOGIA",
                "Bacharelado",
                "Estuda os fenômenos atmosféricos, " +
                "o clima e a previsão do tempo. " +
                "Possui aplicações na interação " +
                "oceano-atmosfera, meteorologia " +
                "marítima e estudos climáticos.",
                "Exemplos de onde estudar:\n" +
                "• USP — São Paulo (SP)\n" +
                "• UFRJ — Rio de Janeiro (RJ)\n" +
                "• UFPA — Belém (PA)",
                "https://www.gov.br/inpe/pt-br"
            ),

            criarCartao(
                "GESTÃO AMBIENTAL",
                "Tecnólogo ou Bacharelado, conforme a instituição",
                "Formação relacionada ao planejamento, " +
                "monitoramento e gestão dos recursos " +
                "naturais. Pode contribuir para projetos " +
                "de conservação de ambientes costeiros " +
                "e proteção de ecossistemas marinhos.",
                "Exemplos de onde estudar:\n" +
                "• USP — São Paulo (SP)\n" +
                "• UFPR — Paraná\n" +
                "• Institutos Federais — diferentes estados",
                "https://emec.mec.gov.br/"
            )
        );

        // ROLAGEM

        ScrollPane rolagem = new ScrollPane(lista);

        rolagem.setFitToWidth(true);
        rolagem.setHbarPolicy(
            ScrollPane.ScrollBarPolicy.NEVER
        );

        rolagem.setStyle(
            "-fx-background: " + FUNDO + ";" +
            "-fx-background-color: " + FUNDO + ";" +
            "-fx-border-color: transparent;"
        );

        VBox.setVgrow(rolagem, Priority.ALWAYS);

        tela.getChildren().addAll(
            cabecalho,
            rolagem
        );

        return tela;
    }

    // ==========================================
    // CRIAR CARTÃO DO CURSO
    // ==========================================

    private static VBox criarCartao(
            String nome,
            String tipo,
            String descricao,
            String universidades,
            String url) {

        VBox cartao = new VBox(12);

        cartao.setPadding(new Insets(22));

        cartao.setStyle(
            "-fx-background-color: " + CARTAO + ";" +
            "-fx-background-radius: 12;" +
            "-fx-border-color: #203746;" +
            "-fx-border-radius: 12;"
        );

        Label titulo = new Label(nome);

        titulo.setStyle(
            "-fx-text-fill: " + AZUL + ";" +
            "-fx-font-size: 21px;" +
            "-fx-font-weight: bold;"
        );

        titulo.setWrapText(true);

        Label modalidade = new Label(tipo);

        modalidade.setStyle(
            "-fx-text-fill: #80CBC4;" +
            "-fx-font-size: 13px;" +
            "-fx-font-weight: bold;"
        );

        Label texto = new Label(descricao);

        texto.setWrapText(true);

        texto.setStyle(
            "-fx-text-fill: " + SECUNDARIO + ";" +
            "-fx-font-size: 14px;"
        );

        Label locais = new Label(universidades);

        locais.setWrapText(true);

        locais.setStyle(
            "-fx-text-fill: " + TEXTO + ";" +
            "-fx-font-size: 14px;" +
            "-fx-line-spacing: 5px;"
        );

        Button botaoSite = new Button(
            "Consultar informações ↗"
        );

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
            titulo,
            modalidade,
            texto,
            locais,
            botaoSite
        );

        return cartao;
    }

    // ==========================================
    // ABRIR SITE
    // ==========================================

    private static void abrirSite(String url) {

        try {

            if (Desktop.isDesktopSupported()) {

                Desktop.getDesktop().browse(
                    new URI(url)
                );
            }

        } catch (Exception e) {

            System.err.println(
                "Erro ao abrir: " + url
            );

            e.printStackTrace();
        }
    }
}