package br.com.oceanografia;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class ImportadorINEP2024 {

    private static final Charset ENCODING =
        Charset.forName("windows-1252");

    public static void importar() {

        System.out.println("========================================");
        System.out.println("Lendo dados do INEP 2024...");
        System.out.println("========================================");

        try {

            // Guarda CO_IES -> Nome e sigla da instituição
            Map<String, String[]> instituicoes = carregarInstituicoes();

            System.out.println(
                "Instituições carregadas: " + instituicoes.size()
            );

            InputStream arquivoCursos =
                ImportadorINEP2024.class.getResourceAsStream(
                    "/MICRODADOS_CADASTRO_CURSOS_2024.CSV"
                );

            if (arquivoCursos == null) {
                System.out.println(
                    "Arquivo de cursos do INEP não encontrado."
                );
                return;
            }

            BufferedReader leitor = new BufferedReader(
                new InputStreamReader(arquivoCursos, ENCODING)
            );

            String cabecalho = leitor.readLine();

            if (cabecalho == null) {
                System.out.println("Arquivo de cursos está vazio.");
                leitor.close();
                return;
            }

            String[] colunas = cabecalho.split(";", -1);

            Map<String, Integer> indice = criarMapaColunas(colunas);

            int total = 0;

            String linha;

            while ((linha = leitor.readLine()) != null) {

                String[] dados = linha.split(";", -1);

                String curso = pegar(
                    dados,
                    indice,
                    "NO_CURSO"
                );

                if (
                    !curso.equalsIgnoreCase("Oceanografia") &&
                    !curso.equalsIgnoreCase("Oceanologia")
                ) {
                    continue;
                }

                total++;

                String codigoIES = pegar(
                    dados,
                    indice,
                    "CO_IES"
                );

                String codigoCurso = pegar(
                    dados,
                    indice,
                    "CO_CURSO"
                );

                String cidade = pegar(
                    dados,
                    indice,
                    "NO_MUNICIPIO"
                );

                String uf = pegar(
                    dados,
                    indice,
                    "SG_UF"
                );

                String modalidade = pegar(
                    dados,
                    indice,
                    "TP_MODALIDADE_ENSINO"
                );

                String nomeIES = "Instituição não encontrada";
                String siglaIES = "";

                String[] dadosIES = instituicoes.get(codigoIES);

                if (dadosIES != null) {
                    nomeIES = dadosIES[0];
                    siglaIES = dadosIES[1];
                }

                System.out.println();
                System.out.println("----------------------------------------");
                System.out.println("Instituição: " + nomeIES);

                if (!siglaIES.isBlank()) {
                    System.out.println("Sigla: " + siglaIES);
                }

                System.out.println("Curso: " + curso);
                System.out.println("Código do curso: " + codigoCurso);
                System.out.println("Cidade: " + cidade);
                System.out.println("UF: " + uf);
                System.out.println("Modalidade: " + modalidade);
                System.out.println("CO_IES: " + codigoIES);
            }

            leitor.close();

            System.out.println();
            System.out.println("========================================");
            System.out.println(
                "Total Oceanografia/Oceanologia em 2024: " + total
            );
            System.out.println("========================================");

        } catch (Exception erro) {

            System.out.println(
                "Erro ao processar os dados do INEP 2024:"
            );

            erro.printStackTrace();
        }
    }

    private static Map<String, String[]> carregarInstituicoes()
        throws Exception {

        Map<String, String[]> instituicoes = new HashMap<>();

        InputStream arquivo =
            ImportadorINEP2024.class.getResourceAsStream(
                "/MICRODADOS_ED_SUP_IES_2024.CSV"
            );

        if (arquivo == null) {
            throw new Exception(
                "Arquivo MICRODADOS_ED_SUP_IES_2024.CSV não encontrado."
            );
        }

        BufferedReader leitor = new BufferedReader(
            new InputStreamReader(arquivo, ENCODING)
        );

        String cabecalho = leitor.readLine();

        if (cabecalho == null) {
            leitor.close();
            return instituicoes;
        }

        String[] colunas = cabecalho.split(";", -1);

        Map<String, Integer> indice = criarMapaColunas(colunas);

        String linha;

        while ((linha = leitor.readLine()) != null) {

            String[] dados = linha.split(";", -1);

            String codigoIES = pegar(
                dados,
                indice,
                "CO_IES"
            );

            String nomeIES = pegar(
                dados,
                indice,
                "NO_IES"
            );

            String siglaIES = pegar(
                dados,
                indice,
                "SG_IES"
            );

            if (!codigoIES.isBlank()) {

                instituicoes.put(
                    codigoIES,
                    new String[] {
                        nomeIES,
                        siglaIES
                    }
                );
            }
        }

        leitor.close();

        return instituicoes;
    }

    private static Map<String, Integer> criarMapaColunas(
        String[] colunas
    ) {

        Map<String, Integer> mapa = new HashMap<>();

        for (int i = 0; i < colunas.length; i++) {

            String nome = colunas[i]
                .replace("\uFEFF", "")
                .trim();

            mapa.put(nome, i);
        }

        return mapa;
    }

    private static String pegar(
        String[] dados,
        Map<String, Integer> indice,
        String coluna
    ) {

        Integer posicao = indice.get(coluna);

        if (
            posicao == null ||
            posicao < 0 ||
            posicao >= dados.length
        ) {
            return "";
        }

        return dados[posicao]
            .replace("\"", "")
            .trim();
    }
}