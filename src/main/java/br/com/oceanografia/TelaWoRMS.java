package br.com.oceanografia;

import java.awt.Desktop;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TelaWoRMS {

    private static final String FUNDO = "#05090D";
    private static final String AZUL = "#29B6F6";
    private static final String CARTAO = "#101A22";

    public static VBox criar(Runnable voltar) {

        // BOTÃO VOLTAR

        Button botaoVoltar = new Button("Voltar");
        estilizarBotao(botaoVoltar);

        botaoVoltar.setOnAction(event -> voltar.run());

        // CABEÇALHO

        Label titulo = new Label("Biodiversidade Marinha");
        titulo.setStyle(
            "-fx-font-size: 32px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: " + AZUL + ";"
        );

        Label subtitulo = new Label(
            "Conheça as espécies marinhas com o WoRMS"
        );
        subtitulo.setStyle(
            "-fx-font-size: 17px;" +
            "-fx-text-fill: #B8C7D9;"
        );

        // PESQUISA DE ESPÉCIES

        Label tituloBusca = criarTituloSecao(
            "Pesquisar espécies"
        );

        Label descricaoBusca = new Label(
            "Digite o nome científico ou um nome de espécie " +
            "para consultar a base World Register of Marine Species."
        );
        descricaoBusca.setWrapText(true);
        descricaoBusca.setStyle(
            "-fx-font-size: 15px;" +
            "-fx-text-fill: #B8C7D9;"
        );

        TextField campoBusca = new TextField();
        campoBusca.setPromptText(
            "Ex.: Octopus vulgaris"
        );
        campoBusca.setStyle(
            "-fx-font-size: 15px;" +
            "-fx-text-fill: white;" +
            "-fx-prompt-text-fill: #8193A5;" +
            "-fx-background-color: #101A22;" +
            "-fx-background-radius: 8px;" +
            "-fx-border-color: #263D4D;" +
            "-fx-border-radius: 8px;" +
            "-fx-padding: 12px;"
        );
        HBox.setHgrow(campoBusca, Priority.ALWAYS);

        Button botaoPesquisar = new Button("Pesquisar");
        estilizarBotao(botaoPesquisar);

        Label mensagem = new Label();
        mensagem.setWrapText(true);
        mensagem.setStyle(
            "-fx-font-size: 14px;" +
            "-fx-text-fill: #B8C7D9;"
        );

        Runnable pesquisar = () -> {
            String nome = campoBusca.getText().trim();

            if (nome.isEmpty()) {
                mensagem.setText(
                    "Digite o nome de uma espécie para pesquisar."
                );
                return;
            }

            try {
                String consulta = URLEncoder.encode(
                    nome,
                    StandardCharsets.UTF_8
                );

                URI endereco = URI.create(
                    "https://www.marinespecies.org/aphia.php"
                    + "?p=taxlist&tName=" + consulta
                );

                if (Desktop.isDesktopSupported()
                        && Desktop.getDesktop().isSupported(
                            Desktop.Action.BROWSE)) {

                    Desktop.getDesktop().browse(endereco);

                    mensagem.setText(
                        "A pesquisa foi aberta no site oficial do WoRMS."
                    );
                } else {
                    mensagem.setText(
                        "Não foi possível abrir o navegador automaticamente. "
                        + "Acesse www.marinespecies.org."
                    );
                }

            } catch (Exception ex) {
                mensagem.setText(
                    "Não foi possível abrir a pesquisa. "
                    + "Verifique sua conexão e tente novamente."
                );
            }
        };

        botaoPesquisar.setOnAction(
            event -> pesquisar.run()
        );

        campoBusca.setOnAction(
            event -> pesquisar.run()
        );

        HBox linhaBusca = new HBox(
            10,
            campoBusca,
            botaoPesquisar
        );
        linhaBusca.setAlignment(Pos.CENTER_LEFT);

        Label caixaBusca = criarCaixa(
            "A busca será realizada na base oficial do WoRMS. " +
            "Os resultados completos serão apresentados no navegador."
        );

        // SEÇÕES INFORMATIVAS

        VBox conteudo = new VBox(12);
        conteudo.setPadding(
            new Insets(10, 15, 35, 0)
        );
        conteudo.setFillWidth(true);

        conteudo.getChildren().addAll(
            tituloBusca,
            descricaoBusca,
            linhaBusca,
            mensagem,
            caixaBusca,

            criarTituloSecao("O que é o WoRMS?"),
            criarCaixa(
                "O World Register of Marine Species (WoRMS) é uma " +
                "base de dados científica que reúne informações " +
                "sobre nomes e classificação de organismos marinhos. " +
                "Seu objetivo é fornecer uma referência taxonômica " +
                "confiável e atualizada para pesquisadores, estudantes " +
                "e profissionais ligados às ciências marinhas."
            ),

            criarTituloSecao("Classificação Taxonômica"),
            criarCaixa(
                "A classificação taxonômica organiza os organismos " +
                "em diferentes níveis, permitindo compreender suas " +
                "relações biológicas.\n\n" +
                "Reino: grupo taxonômico mais abrangente apresentado " +
                "nesta hierarquia.\n" +
                "Filo: reúne organismos com características estruturais " +
                "fundamentais em comum.\n" +
                "Classe: subdivisão de um filo.\n" +
                "Ordem: subdivisão de uma classe.\n" +
                "Família: reúne gêneros relacionados.\n" +
                "Gênero: reúne espécies próximas.\n" +
                "Espécie: unidade básica de classificação biológica.\n\n" +
                "Os níveis disponíveis variam conforme o organismo."
            ),

            criarTituloSecao("Nomes científicos e sinônimos"),
            criarCaixa(
                "Um organismo pode ter nomes científicos históricos " +
                "ou sinônimos registrados na literatura. A consulta " +
                "ao WoRMS ajuda a identificar o nome aceito na base " +
                "e verificar informações taxonômicas associadas. " +
                "A aceitação de um nome deve ser interpretada de " +
                "acordo com o registro consultado."
            ),

            criarTituloSecao("Importância para a Oceanografia"),
            criarCaixa(
                "A identificação correta dos organismos marinhos " +
                "é importante para estudos de biodiversidade, " +
                "monitoramento ambiental, conservação dos oceanos, " +
                "pesquisas ecológicas e padronização de dados científicos."
            ),

            criarTituloSecao("Fonte dos Dados"),
            criarCaixa(
                "WoRMS — World Register of Marine Species\n" +
                "Portal: https://www.marinespecies.org/\n" +
                "Serviço REST: https://www.marinespecies.org/rest/\n\n" +
                "Os dados taxonômicos devem ser consultados diretamente " +
                "na fonte para conferir o nome aceito e as informações " +
                "mais recentes de cada organismo."
            )
        );

        // BOTÃO PARA O SITE OFICIAL

        Button botaoSite = new Button(
            "Acessar o site oficial do WoRMS"
        );
        estilizarBotao(botaoSite);

        botaoSite.setOnAction(event -> {
            try {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().browse(
                        URI.create("https://www.marinespecies.org/")
                    );
                }
            } catch (Exception ex) {
                mensagem.setText(
                    "Não foi possível abrir o site oficial."
                );
            }
        });

        conteudo.getChildren().add(botaoSite);

        // ROLAGEM

        ScrollPane scroll = new ScrollPane(conteudo);
        scroll.setFitToWidth(true);
        scroll.setStyle(
            "-fx-background: " + FUNDO + ";" +
            "-fx-background-color: " + FUNDO + ";" +
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

        tela.setPadding(new Insets(35));
        tela.setStyle(
            "-fx-background-color: " + FUNDO + ";"
        );

        VBox.setVgrow(scroll, Priority.ALWAYS);

        return tela;
    }

    private static Label criarTituloSecao(String texto) {
        Label titulo = new Label(texto);

        titulo.setStyle(
            "-fx-font-size: 22px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: " + AZUL + ";" +
            "-fx-padding: 20px 0 5px 0;"
        );

        return titulo;
    }

    private static Label criarCaixa(String texto) {
        Label caixa = new Label(texto);

        caixa.setWrapText(true);
        caixa.setMaxWidth(Double.MAX_VALUE);

        caixa.setStyle(
            "-fx-font-size: 16px;" +
            "-fx-text-fill: white;" +
            "-fx-background-color: " + CARTAO + ";" +
            "-fx-background-radius: 10px;" +
            "-fx-padding: 20px;"
        );

        return caixa;
    }

    private static void estilizarBotao(Button botao) {
        botao.setStyle(
            "-fx-background-color: #15232D;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 15px;" +
            "-fx-background-radius: 8px;" +
            "-fx-padding: 10px 18px;" +
            "-fx-cursor: hand;"
        );
    }
}