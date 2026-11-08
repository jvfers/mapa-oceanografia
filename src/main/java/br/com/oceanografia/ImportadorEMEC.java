package br.com.oceanografia;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImportadorEMEC {

    private static final String[] ARQUIVOS = {
        "/relatorio_consulta_publica_avancada_curso_20_09_2026_22_28_35.xls",
        "/relatorio_consulta_publica_avancada_curso_20_09_2026_22_31_40.xls"
    };

    public static void importar() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("Lendo dados do e-MEC...");
        System.out.println("========================================");

        int totalGeral = 0;

        for (String arquivo : ARQUIVOS) {
            totalGeral += processarArquivo(arquivo);
        }

        System.out.println();
        System.out.println("========================================");
        System.out.println(
            "Total de registros encontrados no e-MEC: "
            + totalGeral
        );
        System.out.println("========================================");
    }

    private static int processarArquivo(String nomeArquivo) {

        int total = 0;

        try {

            InputStream arquivo =
                ImportadorEMEC.class.getResourceAsStream(nomeArquivo);

            if (arquivo == null) {
                System.out.println(
                    "Arquivo não encontrado: " + nomeArquivo
                );
                return 0;
            }

            BufferedReader leitor = new BufferedReader(
                new InputStreamReader(
                    arquivo,
                    StandardCharsets.UTF_8
                )
            );

            StringBuilder html = new StringBuilder();
            String linha;

            while ((linha = leitor.readLine()) != null) {
                html.append(linha).append("\n");
            }

            leitor.close();

            Pattern linhasTabela = Pattern.compile(
                "<tr[^>]*>(.*?)</tr>",
                Pattern.CASE_INSENSITIVE | Pattern.DOTALL
            );

            Matcher matcherLinha =
                linhasTabela.matcher(html.toString());

            while (matcherLinha.find()) {

                String conteudoLinha = matcherLinha.group(1);

                Pattern celulas = Pattern.compile(
                    "<td[^>]*>(.*?)</td>",
                    Pattern.CASE_INSENSITIVE | Pattern.DOTALL
                );

                Matcher matcherCelula =
                    celulas.matcher(conteudoLinha);

                List<String> dados = new ArrayList<>();

                while (matcherCelula.find()) {

                    String valor = limparHTML(
                        matcherCelula.group(1)
                    );

                    dados.add(valor);
                }

                // O relatório do e-MEC possui 28 colunas.
                if (dados.size() < 28) {
                    continue;
                }

                String codigoCurso = dados.get(4);
                String estado = BancoDados.buscarEstadoPorCodigoCurso(codigoCurso);
                String instituicao = dados.get(1);
                String sigla = dados.get(2);
                String categoria = dados.get(3);
                String curso = dados.get(5);
                String grau = dados.get(6);
                String modalidade = dados.get(7);
                String vagas = dados.get(16);
                String situacao = dados.get(19);

                if (
                    !curso.equalsIgnoreCase("OCEANOGRAFIA") &&
                    !curso.equalsIgnoreCase("OCEANOLOGIA")
                ) {
                    continue;
                }

                total++;

                BancoDados.adicionarEMEC(
                    codigoCurso,
                    instituicao,
                    sigla,
                    estado,
                    categoria,
                    curso,
                    grau,
                    modalidade,
                    vagas,
                    situacao
                );

                System.out.println();
                System.out.println("----------------------------------------");
                System.out.println("Registro e-MEC " + total);
                System.out.println("Instituição: " + instituicao);
                System.out.println("Sigla: " + sigla);
                System.out.println("Curso: " + curso);
                System.out.println("Código: " + codigoCurso);
                System.out.println("Categoria: " + categoria);
                System.out.println("Grau: " + grau);
                System.out.println("Modalidade: " + modalidade);
                System.out.println("Vagas: " + vagas);
                System.out.println("Situação: " + situacao);
            }

        } catch (Exception erro) {

            System.out.println(
                "Erro ao processar arquivo do e-MEC:"
            );

            erro.printStackTrace();
        }

        return total;
    }

    private static String limparHTML(String texto) {

        return texto
            .replaceAll("<[^>]+>", " ")
            .replace("&nbsp;", " ")
            .replace("&amp;", "&")
            .replace("&quot;", "\"")
            .replace("&#39;", "'")
            .replace("&aacute;", "á")
            .replace("&Aacute;", "Á")
            .replace("&atilde;", "ã")
            .replace("&Atilde;", "Ã")
            .replace("&ccedil;", "ç")
            .replace("&Ccedil;", "Ç")
            .replace("&eacute;", "é")
            .replace("&Eacute;", "É")
            .replace("&iacute;", "í")
            .replace("&Iacute;", "Í")
            .replace("&oacute;", "ó")
            .replace("&Oacute;", "Ó")
            .replace("&uacute;", "ú")
            .replace("&Uacute;", "Ú")
            .replaceAll("\\s+", " ")
            .trim();
    }
}