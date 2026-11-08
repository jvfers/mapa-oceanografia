package br.com.oceanografia;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ImportadorMEC {

    public static void importar() {

        System.out.println("Iniciando importação da base do MEC...");

        try {

            InputStream arquivo = ImportadorMEC.class.getResourceAsStream(
                "/PDA_Dados_Cursos_Graduacao_Brasil.csv"
            );

            if (arquivo == null) {
                System.out.println("Arquivo CSV do MEC não encontrado.");
                return;
            }

            BufferedReader leitor = new BufferedReader(
                new InputStreamReader(arquivo, StandardCharsets.UTF_8)
            );

            // Lê o cabeçalho
            String cabecalho = leitor.readLine();

            if (cabecalho == null) {
                System.out.println("O CSV está vazio.");
                leitor.close();
                return;
            }

            String[] colunas = cabecalho.split(",", -1);

            Map<String, Integer> indices = new HashMap<>();

            for (int i = 0; i < colunas.length; i++) {
                indices.put(
                    colunas[i].trim().toUpperCase(),
                    i
                );
            }

            // Localiza as colunas pelo nome
            Integer iNome = indices.get("NOME_IES");
            Integer iTipo = indices.get("CATEGORIA_ADMINISTRATIVA");
            Integer iCodigoCurso = indices.get("CODIGO_CURSO");
            Integer iCurso = indices.get("NOME_CURSO");
            Integer iModalidade = indices.get("MODALIDADE");
            Integer iSituacao = indices.get("SITUACAO_CURSO");
            Integer iCidade = indices.get("MUNICIPIO");
            Integer iUf = indices.get("UF");

            // Confere se todas foram encontradas
            if (
                iNome == null ||
                iTipo == null ||
                iCodigoCurso == null ||
                iCurso == null ||
                iModalidade == null ||
                iSituacao == null ||
                iCidade == null ||
                iUf == null
            ) {

                System.out.println(
                    "Erro: não foi possível localizar todas as colunas necessárias."
                );

                leitor.close();
                return;
            }

            String linha;

            int encontrados = 0;
            int importados = 0;

            while ((linha = leitor.readLine()) != null) {

                String linhaMinuscula = linha.toLowerCase();

                // Só processa Oceanografia ou Oceanologia
                if (
                    !linhaMinuscula.contains(",oceanografia,") &&
                    !linhaMinuscula.contains(",oceanologia,")
                ) {
                    continue;
                }

                encontrados++;

                String[] dados = linha.split(",", -1);

                // Descobre o maior índice necessário
                int maiorIndice = Math.max(
                    Math.max(iNome, iTipo),
                    Math.max(
                        Math.max(iCodigoCurso, iCurso),
                        Math.max(
                            Math.max(iModalidade, iSituacao),
                            Math.max(iCidade, iUf)
                        )
                    )
                );

                // Evita erro se alguma linha estiver incompleta
                if (dados.length <= maiorIndice) {
                    System.out.println(
                        "Linha ignorada por estar incompleta."
                    );
                    continue;
                }

                String nome = dados[iNome].trim();
                String tipo = dados[iTipo].trim();
                String codigoCurso = dados[iCodigoCurso].trim();
                String curso = dados[iCurso].trim();
                String modalidade = dados[iModalidade].trim();
                String situacao = dados[iSituacao].trim();
                String cidade = dados[iCidade].trim();
                String uf = dados[iUf].trim();

                // Só queremos cursos atualmente em atividade
                if (!situacao.equalsIgnoreCase("Em atividade")) {
                    continue;
                }

                String estado = nomeEstado(uf);

                BancoDados.adicionarInstituicao(
                    nome,
                    "",
                    estado,
                    cidade,
                    curso,
                    tipo,
                    modalidade,
                    situacao,
                    "",
                    codigoCurso
                );

                importados++;
            }

            leitor.close();

            System.out.println(
                "Cursos Oceanografia/Oceanologia encontrados: "
                + encontrados
            );

            System.out.println(
                "Cursos ativos processados: "
                + importados
            );

            System.out.println("Importação concluída!");

        } catch (Exception erro) {

            System.out.println(
                "Erro ao importar dados do MEC:"
            );

            erro.printStackTrace();
        }
    }

    private static String nomeEstado(String uf) {

        return switch (uf.toUpperCase()) {
            case "AC" -> "Acre";
            case "AL" -> "Alagoas";
            case "AP" -> "Amapá";
            case "AM" -> "Amazonas";
            case "BA" -> "Bahia";
            case "CE" -> "Ceará";
            case "DF" -> "Distrito Federal";
            case "ES" -> "Espírito Santo";
            case "GO" -> "Goiás";
            case "MA" -> "Maranhão";
            case "MT" -> "Mato Grosso";
            case "MS" -> "Mato Grosso do Sul";
            case "MG" -> "Minas Gerais";
            case "PA" -> "Pará";
            case "PB" -> "Paraíba";
            case "PR" -> "Paraná";
            case "PE" -> "Pernambuco";
            case "PI" -> "Piauí";
            case "RJ" -> "Rio de Janeiro";
            case "RN" -> "Rio Grande do Norte";
            case "RS" -> "Rio Grande do Sul";
            case "RO" -> "Rondônia";
            case "RR" -> "Roraima";
            case "SC" -> "Santa Catarina";
            case "SP" -> "São Paulo";
            case "SE" -> "Sergipe";
            case "TO" -> "Tocantins";
            default -> uf;
        };
    }
}