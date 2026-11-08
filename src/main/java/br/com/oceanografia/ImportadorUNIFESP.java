package br.com.oceanografia;

import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportadorUNIFESP {

    public static void importar() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("Lendo dados da UNIFESP 2024...");
        System.out.println("========================================");

        int total = 0;

        try {

            InputStream arquivo =
                ImportadorUNIFESP.class.getResourceAsStream(
                    "/turmas_2024.xlsx"
                );

            if (arquivo == null) {
                System.out.println(
                    "Arquivo turmas_2024.xlsx não encontrado."
                );
                return;
            }

            Workbook workbook = new XSSFWorkbook(arquivo);
            Sheet planilha = workbook.getSheetAt(0);

            DataFormatter formatador = new DataFormatter();

            // Pula a primeira linha, que contém os títulos.
            for (int i = 1; i <= planilha.getLastRowNum(); i++) {

                Row linha = planilha.getRow(i);

                if (linha == null) {
                    continue;
                }

                String curso = valor(
                    linha,
                    0,
                    formatador
                );

                if (!curso.toUpperCase().contains("OCEANOGRAFIA")) {
                    continue;
                }

                total++;

                String ano = valor(linha, 1, formatador);
                String materia = valor(linha, 2, formatador);
                String semestre = valor(linha, 3, formatador);
                String inicio = valor(linha, 4, formatador);
                String fim = valor(linha, 5, formatador);
                String turno = valor(linha, 6, formatador);
                String campus = valor(linha, 7, formatador);

BancoDados.adicionarTurmaUNIFESP(
    curso,
    ano,
    materia,
    semestre,
    inicio,
    fim,
    turno,
    campus
);

                System.out.println();
                System.out.println("----------------------------------------");
                System.out.println("Curso: " + curso);
                System.out.println("Ano: " + ano);
                System.out.println("Disciplina: " + materia);
                System.out.println("Semestre: " + semestre);
                System.out.println("Início: " + inicio);
                System.out.println("Fim: " + fim);
                System.out.println("Turno: " + turno);
                System.out.println("Campus: " + campus);
            }

            workbook.close();
            arquivo.close();

            System.out.println();
            System.out.println("========================================");
            System.out.println(
                "Total de turmas de Oceanografia UNIFESP 2024: "
                + total
            );
            System.out.println("========================================");

        } catch (Exception erro) {

            System.out.println(
                "Erro ao processar dados da UNIFESP:"
            );

            erro.printStackTrace();
        }
    }

    private static String valor(
        Row linha,
        int coluna,
        DataFormatter formatador
    ) {

        Cell celula = linha.getCell(coluna);

        if (celula == null) {
            return "";
        }

        return formatador
            .formatCellValue(celula)
            .trim();
    }
}