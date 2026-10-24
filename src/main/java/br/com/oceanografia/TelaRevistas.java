package br.com.oceanografia;

import java.awt.Desktop;
import java.net.URI;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TelaRevistas {

    // CRIAR TELA

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
            new Label("REVISTAS CIENTÍFICAS");

        titulo.setStyle(
            "-fx-font-size: 36px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #29B6F6;"
        );


        Label subtitulo = new Label(
            "Explore periódicos científicos relacionados à Oceanografia, " +
            "Ciências do Mar, biodiversidade e ecossistemas oceânicos."
        );

        subtitulo.setWrapText(true);

        subtitulo.setStyle(
            "-fx-font-size: 16px;" +
            "-fx-text-fill: #B8C7D9;"
        );


        // CARREGAR REVISTAS DO DadosRevistas.java

        List<DadosRevistas.Revista> revistas =
            DadosRevistas.carregar();


        // PESQUISA

        TextField pesquisa = new TextField();

        pesquisa.setPromptText(
            "Pesquisar revista ou assunto..."
        );

        pesquisa.setPrefHeight(42);

        pesquisa.setStyle(
            "-fx-background-color: #101A22;" +
            "-fx-text-fill: white;" +
            "-fx-prompt-text-fill: #78909C;" +
            "-fx-border-color: #263D4A;" +
            "-fx-border-radius: 8px;" +
            "-fx-background-radius: 8px;" +
            "-fx-font-size: 14px;" +
            "-fx-padding: 0 15px;"
        );

        // FILTROS

        Button filtroTodas =
            criarBotaoFiltro("Todas");

        Button filtroBrasil =
            criarBotaoFiltro("Brasil");

        Button filtroOceanografia =
            criarBotaoFiltro("Oceanografia");

        Button filtroBiologia =
            criarBotaoFiltro("Biologia Marinha");

        Button filtroFisica =
            criarBotaoFiltro("Oceanografia Física");

        Button filtroPesca =
            criarBotaoFiltro("Pesca");

        Button filtroConservacao =
            criarBotaoFiltro("Conservação");

        Button filtroGeologia =
            criarBotaoFiltro("Geologia Marinha");

        Button filtroEngenharia =
            criarBotaoFiltro("Engenharia Oceânica");


        // Primeira linha de filtros

        HBox filtrosLinha1 = new HBox(
            10,
            filtroTodas,
            filtroBrasil,
            filtroOceanografia,
            filtroBiologia,
            filtroFisica
        );

        filtrosLinha1.setAlignment(Pos.CENTER_LEFT);


        // Segunda linha de filtros

        HBox filtrosLinha2 = new HBox(
            10,
            filtroPesca,
            filtroConservacao,
            filtroGeologia,
            filtroEngenharia
        );

        filtrosLinha2.setAlignment(Pos.CENTER_LEFT);


        // CONTADOR

        Label contador =
            new Label();

        contador.setStyle(
            "-fx-font-size: 14px;" +
            "-fx-text-fill: #90A4AE;"
        );


        // ÁREA DOS CARDS

        FlowPane areaCards = new FlowPane();

        areaCards.setHgap(18);
        areaCards.setVgap(18);

        areaCards.setPadding(
            new Insets(10, 5, 30, 5)
        );


        // CATEGORIA SELECIONADA

        final String[] categoriaAtual = {
            "Todas"
        };


        // ATUALIZAR RESULTADOS

        Runnable atualizar = () -> {

            areaCards.getChildren().clear();

            String textoPesquisa =
                pesquisa.getText()
                    .toLowerCase()
                    .trim();

            int encontrados = 0;


            for (DadosRevistas.Revista revista : revistas) {

                String nome =
                    revista.getNome().toLowerCase();

                String descricao =
                    revista.getDescricao().toLowerCase();

                String categoria =
                    revista.getCategoria().toLowerCase();


                // PESQUISA POR NOME, DESCRIÇÃO OU CATEGORIA

                boolean correspondePesquisa =
                    nome.contains(textoPesquisa)
                    ||
                    descricao.contains(textoPesquisa)
                    ||
                    categoria.contains(textoPesquisa);


                // FILTROS

                boolean correspondeCategoria =
                    verificarCategoria(
                        revista,
                        categoriaAtual[0]
                    );


                if (
                    correspondePesquisa &&
                    correspondeCategoria
                ) {

                    areaCards.getChildren().add(
                        criarCard(revista)
                    );

                    encontrados++;
                }
            }


            contador.setText(
                encontrados +
                " periódico(s) encontrado(s)"
            );


            if (encontrados == 0) {

                Label nenhum =
                    new Label(
                        "Nenhuma revista encontrada."
                    );

                nenhum.setStyle(
                    "-fx-font-size: 16px;" +
                    "-fx-text-fill: #B8C7D9;" +
                    "-fx-padding: 30px;"
                );

                areaCards.getChildren().add(
                    nenhum
                );
            }
        };


        // PESQUISA AUTOMÁTICA

        pesquisa.textProperty()
            .addListener(
                (observable, antigo, novo) ->
                    atualizar.run()
            );


        // AÇÕES DOS FILTROS

        filtroTodas.setOnAction(event -> {

            categoriaAtual[0] = "Todas";
            atualizar.run();
        });


        filtroBrasil.setOnAction(event -> {

            categoriaAtual[0] = "Brasil";
            atualizar.run();
        });


        filtroOceanografia.setOnAction(event -> {

            categoriaAtual[0] = "Oceanografia";
            atualizar.run();
        });


        filtroBiologia.setOnAction(event -> {

            categoriaAtual[0] = "Biologia Marinha";
            atualizar.run();
        });


        filtroFisica.setOnAction(event -> {

            categoriaAtual[0] =
                "Oceanografia Física";

            atualizar.run();
        });


        filtroPesca.setOnAction(event -> {

            categoriaAtual[0] = "Pesca";
            atualizar.run();
        });


        filtroConservacao.setOnAction(event -> {

            categoriaAtual[0] = "Conservação";
            atualizar.run();
        });


        filtroGeologia.setOnAction(event -> {

            categoriaAtual[0] =
                "Geologia Marinha";

            atualizar.run();
        });


        filtroEngenharia.setOnAction(event -> {

            categoriaAtual[0] =
                "Engenharia Oceânica";

            atualizar.run();
        });


        // CARREGAR TODAS AS REVISTAS

        atualizar.run();


        // ÁREA DE PESQUISA

        VBox areaPesquisa = new VBox(
            12,
            pesquisa,
            filtrosLinha1,
            filtrosLinha2,
            contador
        );

        areaPesquisa.setPadding(
            new Insets(20)
        );

        areaPesquisa.setStyle(
            "-fx-background-color: #0D141A;" +
            "-fx-background-radius: 12px;" +
            "-fx-border-color: #263D4A;" +
            "-fx-border-radius: 12px;"
        );


        // SCROLL

        ScrollPane scroll =
            new ScrollPane(areaCards);

        scroll.setFitToWidth(true);

        scroll.setStyle(
            "-fx-background: #020609;" +
            "-fx-background-color: #020609;" +
            "-fx-border-color: transparent;"
        );

        VBox.setVgrow(
            scroll,
            Priority.ALWAYS
        );


        // RODAPÉ

        Label rodape = new Label(
            "O OCEANO HUB direciona o usuário aos sites oficiais " +
            "dos periódicos para consulta científica."
        );

        rodape.setWrapText(true);

        rodape.setStyle(
            "-fx-font-size: 12px;" +
            "-fx-text-fill: #78909C;"
        );


        // TELA COMPLETA

        VBox tela = new VBox(
            15,
            botaoVoltar,
            titulo,
            subtitulo,
            areaPesquisa,
            scroll,
            rodape
        );

        tela.setPadding(
            new Insets(30)
        );

        tela.setStyle(
            "-fx-background-color: #020609;"
        );

        return tela;
    }


    // VERIFICAR CATEGORIA

    private static boolean verificarCategoria(
        DadosRevistas.Revista revista,
        String filtro
    ) {

        if (filtro.equals("Todas")) {
            return true;
        }


        String categoria =
            revista.getCategoria()
                .toLowerCase();


        // BRASIL

        if (filtro.equals("Brasil")) {

            return categoria.contains("brasil");
        }


        // OCEANOGRAFIA

        if (filtro.equals("Oceanografia")) {

            return
                categoria.contains("oceanografia")
                ||
                categoria.contains("oceanos")
                ||
                categoria.contains("clima");
        }

        // BIOLOGIA

        if (filtro.equals("Biologia Marinha")) {

            return
                categoria.contains("biologia")
                ||
                categoria.contains("ecologia");
        }


        // OCEANOGRAFIA FÍSICA

        if (filtro.equals("Oceanografia Física")) {

            return
                categoria.contains(
                    "oceanografia física"
                );
        }


        // PESCA

        if (filtro.equals("Pesca")) {

            return
                categoria.contains("pesca")
                ||
                categoria.contains("aquicultura");
        }

        // CONSERVAÇÃO

        if (filtro.equals("Conservação")) {

            return
                categoria.contains("conservação")
                ||
                categoria.contains("poluição");
        }

        // GEOLOGIA

        if (filtro.equals("Geologia Marinha")) {

            return
                categoria.contains("geologia");
        }

        // ENGENHARIA

        if (filtro.equals("Engenharia Oceânica")) {

            return
                categoria.contains("engenharia")
                ||
                categoria.contains("tecnologia");
        }


        return false;
    }


    // CRIAR CARD

    private static VBox criarCard(
        DadosRevistas.Revista revista
    ) {

        Label categoria =
            new Label(
                revista.getCategoria()
            );

        categoria.setStyle(
            "-fx-font-size: 12px;" +
            "-fx-text-fill: #29B6F6;" +
            "-fx-font-weight: bold;"
        );


        Label nome =
            new Label(
                revista.getNome()
            );

        nome.setWrapText(true);

        nome.setStyle(
            "-fx-font-size: 19px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: white;"
        );


        Label descricao =
            new Label(
                revista.getDescricao()
            );

        descricao.setWrapText(true);

        descricao.setStyle(
            "-fx-font-size: 13px;" +
            "-fx-text-fill: #B8C7D9;"
        );


        Label acesso =
            new Label(
                revista.getAcesso()
            );

        acesso.setStyle(
            "-fx-font-size: 12px;" +
            "-fx-text-fill: #81C784;" +
            "-fx-font-weight: bold;"
        );


        Button acessar =
            new Button(
                "Acessar revista"
            );

        acessar.setStyle(
            "-fx-background-color: #0288D1;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 13px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 7px;" +
            "-fx-padding: 9px 16px;" +
            "-fx-cursor: hand;"
        );


        acessar.setOnAction(
            event ->
                abrirLink(
                    revista.getLink()
                )
        );


        VBox card = new VBox(
            10,
            categoria,
            nome,
            descricao,
            acesso,
            acessar
        );

        card.setPadding(
            new Insets(20)
        );

        card.setPrefWidth(335);
        card.setMinHeight(245);

        card.setStyle(
            "-fx-background-color: #101A22;" +
            "-fx-background-radius: 12px;" +
            "-fx-border-color: #263D4A;" +
            "-fx-border-radius: 12px;"
        );

        return card;
    }


    // CRIAR BOTÃO DE FILTRO

    private static Button criarBotaoFiltro(
        String texto
    ) {

        Button botao =
            new Button(texto);

        botao.setStyle(
            "-fx-background-color: #15232D;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 13px;" +
            "-fx-background-radius: 15px;" +
            "-fx-padding: 7px 14px;" +
            "-fx-cursor: hand;"
        );

        return botao;
    }


    // ABRIR SITE


    private static void abrirLink(
        String link
    ) {

        try {

            if (
                Desktop.isDesktopSupported()
            ) {

                Desktop.getDesktop().browse(
                    new URI(link)
                );

            } else {

                System.out.println(
                    "Abertura de navegador não suportada."
                );
            }

        } catch (Exception erro) {

            System.out.println(
                "Não foi possível abrir o site: "
                + link
            );

            erro.printStackTrace();
        }
    }
}
