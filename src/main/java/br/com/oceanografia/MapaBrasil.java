package br.com.oceanografia;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MapaBrasil {

    public static Group criarMapa(java.util.function.Consumer<String> aoClicarEstado) {

        Group mapa = new Group();

        try {

            InputStream arquivo = MapaBrasil.class
                    .getResourceAsStream("/mapa-brasil.svg");

            if (arquivo == null) {
                System.out.println("ERRO: mapa-brasil.svg não encontrado!");
                return mapa;
            }

            DocumentBuilderFactory factory =
        DocumentBuilderFactory.newInstance();

factory.setNamespaceAware(true);

DocumentBuilder builder =
        factory.newDocumentBuilder();
            Document documento =
                    builder.parse(arquivo);

            NodeList links =
                    documento.getElementsByTagName("a");

            for (int i = 0; i < links.getLength(); i++) {

                Node node = links.item(i);

                if (node.getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                Element estado = (Element) node;

                String nome = estado.getAttribute("name");
               

                NodeList filhos = estado.getChildNodes();

                for (int j = 0; j < filhos.getLength(); j++) {

                    Node filho = filhos.item(j);

                    if (filho.getNodeType() != Node.ELEMENT_NODE) {
                        continue;
                    }

                    Element elemento = (Element) filho;
                    
// SIGLA DO ESTADO
if (elemento.getTagName().equals("text")) {

    String sigla = elemento.getTextContent().trim();

    Text texto = new Text(sigla);

    texto.setFill(Color.BLACK);
    texto.setFont(
        Font.font("Arial", FontWeight.BOLD, 12)
    );

    String transform = elemento.getAttribute("transform");

    if (transform.startsWith("matrix(")) {

        String valores = transform
                .replace("matrix(", "")
                .replace(")", "");

        String[] partes = valores.trim().split("\\s+");

        if (partes.length == 6) {

            double x = Double.parseDouble(partes[4]);
            double y = Double.parseDouble(partes[5]);

            texto.setX(x);
            texto.setY(y);

           // Ajusta a posição das siglas dos estados pequenos
switch (sigla) {

    case "RN":
        criarLegendaExterna(mapa, texto, x, y, x + 55, y - 10);
        continue;

    case "PB":
        criarLegendaExterna(mapa, texto, x, y, x + 60, y);
        continue;

    case "PE":
        criarLegendaExterna(mapa, texto, x, y, x + 65, y + 5);
        continue;

    case "AL":
        criarLegendaExterna(mapa, texto, x, y, x + 60, y + 15);
        continue;

    case "SE":
        criarLegendaExterna(mapa, texto, x, y, x + 55, y + 25);
        continue;

   case "DF":
    criarLegendaExterna(mapa, texto, x, y, x + 115, y + 15);
    continue;

    case "ES":
        criarLegendaExterna(mapa, texto, x, y, x + 55, y);
        continue;

    case "RJ":
        criarLegendaExterna(mapa, texto, x, y, x + 55, y + 15);
        continue;
}
        }
    }

    texto.setMouseTransparent(true);

    mapa.getChildren().add(texto);

    continue;
}

                    if (!elemento.getTagName().equals("path")) {
                        continue;
                    }

                    String desenho = elemento.getAttribute("d");

if (desenho == null || desenho.isBlank()) {
    continue;
}

// Ignora as bolinhas do SVG
if (elemento.getAttribute("class").equals("circle")) {
    continue;
}

SVGPath caminho = new SVGPath();

                    caminho.setContent(desenho);

                    caminho.setFill(
                            corDoEstado(nome)
                    );

                    caminho.setStroke(Color.web("#050505"));
                    caminho.setStrokeWidth(1.5);

                    // Quando passa o mouse
                    caminho.setOnMouseEntered(event -> {

                        caminho.setOpacity(0.70);

                        System.out.println(
                                "Estado: " + nome
                        );
                    });

                    // Quando tira o mouse
                    caminho.setOnMouseExited(event -> {
                        caminho.setOpacity(1.0);
                    });

                    // Quando clica
caminho.setOnMouseClicked(event -> {

    System.out.println("Você clicou em: " + nome);

    if (aoClicarEstado != null) {
        aoClicarEstado.accept(nome);
    }

});

                    mapa.getChildren().add(caminho);
                }
            }

        } catch (Exception erro) {

            System.out.println(
                    "Erro ao carregar o mapa:"
            );

            erro.printStackTrace();
        }

        return mapa;
    }

    // CORES POR REGIÃO

     private static Color corDoEstado(String estado) {

    String nome = estado
            .toLowerCase()
            .replace("á", "a")
            .replace("à", "a")
            .replace("ã", "a")
            .replace("â", "a")
            .replace("é", "e")
            .replace("ê", "e")
            .replace("í", "i")
            .replace("ó", "o")
            .replace("ô", "o")
            .replace("õ", "o")
            .replace("ú", "u")
            .replace("ç", "c");

    // NORTE
    if (
        nome.equals("acre") ||
        nome.equals("amapa") ||
        nome.equals("amazonas") ||
        nome.equals("para") ||
        nome.equals("rondonia") ||
        nome.equals("roraima") ||
        nome.equals("tocantins")
    ) {
        return Color.web("#00D94A");
    }

    // NORDESTE
    if (
        nome.equals("alagoas") ||
        nome.equals("bahia") ||
        nome.equals("ceara") ||
        nome.equals("maranhao") ||
        nome.equals("paraiba") ||
        nome.equals("pernambuco") ||
        nome.equals("piaui") ||
        nome.equals("rio grande do norte") ||
        nome.equals("sergipe")
    ) {
        return Color.web("#FFA514");
    }

    // CENTRO-OESTE
    if (
        nome.equals("distrito federal") ||
        nome.equals("goias") ||
        nome.equals("mato grosso") ||
        nome.equals("mato grosso do sul")
    ) {
        return Color.web("#F4E409");
    }

    // SUDESTE
    if (
        nome.equals("espirito santo") ||
        nome.equals("minas gerais") ||
        nome.equals("rio de janeiro") ||
        nome.equals("sao paulo")
    ) {
        return Color.web("#E63817");
    }

    // SUL
    if (
        nome.equals("parana") ||
        nome.equals("rio grande do sul") ||
        nome.equals("santa catarina")
    ) {
        return Color.web("#19B9F1");
    }

    return Color.GRAY;
}
private static void criarLegendaExterna(
        Group mapa,
        Text textoOriginal,
        double origemX,
        double origemY,
        double destinoX,
        double destinoY) {

    // Linha branca saindo do estado
    javafx.scene.shape.Line linha = new javafx.scene.shape.Line(
            origemX,
            origemY,
            destinoX - 5,
            destinoY - 4
    );

    linha.setStroke(Color.WHITE);
    linha.setStrokeWidth(1.5);
    linha.setMouseTransparent(true);

    // Sigla branca fora do mapa
    Text legenda = new Text(textoOriginal.getText());

    legenda.setX(destinoX);
    legenda.setY(destinoY);
    legenda.setFill(Color.WHITE);

    legenda.setFont(
            Font.font("Arial", FontWeight.BOLD, 12)
    );

    legenda.setMouseTransparent(true);

    mapa.getChildren().addAll(linha, legenda);
}
}