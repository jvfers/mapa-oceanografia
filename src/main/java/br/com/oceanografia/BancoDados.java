package br.com.oceanografia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoDados {

    private static final String URL = "jdbc:sqlite:oceanografia.db";

    // CONEXÃO COM O BANCO

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // TABELA PRINCIPAL - INSTITUIÇÕES

    public static void criarTabela() {

        String sql =
            "CREATE TABLE IF NOT EXISTS instituicoes (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nome TEXT NOT NULL, " +
            "sigla TEXT, " +
            "estado TEXT NOT NULL, " +
            "cidade TEXT, " +
            "curso TEXT NOT NULL, " +
            "tipo TEXT NOT NULL, " +
            "modalidade TEXT, " +
            "situacao TEXT, " +
            "site TEXT, " +
            "codigo_emec TEXT" +
            ");";

        try (
            Connection conexao = conectar();
            Statement comando = conexao.createStatement()
        ) {

            comando.execute(sql);

            System.out.println(
                "Banco de dados preparado com sucesso!"
            );

        } catch (SQLException erro) {

            System.out.println(
                "Erro ao criar banco de dados: "
                + erro.getMessage()
            );
        }
    }

    // TABELA E-MEC

    public static void criarTabelaEMEC() {

        String sql =
            "CREATE TABLE IF NOT EXISTS dados_emec (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "codigo_curso TEXT, " +
            "instituicao TEXT, " +
            "sigla TEXT, " +
            "estado TEXT, " +
            "categoria TEXT, " +
            "curso TEXT, " +
            "grau TEXT, " +
            "modalidade TEXT, " +
            "vagas TEXT, " +
            "situacao TEXT, " +
            "fonte TEXT" +
            ");";

        try (
            Connection conexao = conectar();
            Statement comando = conexao.createStatement()
        ) {

            comando.execute(sql);

            // Compatibilidade com bancos criados antes
            // da inclusão da coluna estado.
            if (!colunaExiste(conexao, "dados_emec", "estado")) {

                comando.execute(
                    "ALTER TABLE dados_emec ADD COLUMN estado TEXT"
                );

                System.out.println(
                    "Coluna estado adicionada ao e-MEC!"
                );
            }

            System.out.println(
                "Tabela do e-MEC preparada com sucesso!"
            );

        } catch (SQLException erro) {

            System.out.println(
                "Erro ao criar tabela do e-MEC: "
                + erro.getMessage()
            );
        }
    }


    // VERIFICAR SE UMA COLUNA EXISTE

    private static boolean colunaExiste(
        Connection conexao,
        String tabela,
        String coluna
    ) throws SQLException {

        String sql =
            "PRAGMA table_info(" + tabela + ")";

        try (
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(sql)
        ) {

            while (resultado.next()) {

                String nomeColuna =
                    resultado.getString("name");

                if (coluna.equalsIgnoreCase(nomeColuna)) {
                    return true;
                }
            }
        }

        return false;
    }

    // ADICIONAR REGISTRO DO E-MEC

    public static void adicionarEMEC(
        String codigoCurso,
        String instituicao,
        String sigla,
        String estado,
        String categoria,
        String curso,
        String grau,
        String modalidade,
        String vagas,
        String situacao
    ) {

        String verificar =
            "SELECT COUNT(*) FROM dados_emec " +
            "WHERE codigo_curso = ?";

        try (
            Connection conexao = conectar();
            PreparedStatement comando =
                conexao.prepareStatement(verificar)
        ) {

            comando.setString(1, codigoCurso);

            ResultSet resultado =
                comando.executeQuery();

            if (
                resultado.next()
                && resultado.getInt(1) > 0
            ) {
                return;
            }

        } catch (SQLException erro) {

            System.out.println(
                "Erro ao verificar dado do e-MEC: "
                + erro.getMessage()
            );

            return;
        }


        String sql =
            "INSERT INTO dados_emec " +
            "(codigo_curso, instituicao, sigla, estado, " +
            "categoria, curso, grau, modalidade, vagas, " +
            "situacao, fonte) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection conexao = conectar();
            PreparedStatement comando =
                conexao.prepareStatement(sql)
        ) {

            comando.setString(1, codigoCurso);
            comando.setString(2, instituicao);
            comando.setString(3, sigla);
            comando.setString(4, estado);
            comando.setString(5, categoria);
            comando.setString(6, curso);
            comando.setString(7, grau);
            comando.setString(8, modalidade);
            comando.setString(9, vagas);
            comando.setString(10, situacao);
            comando.setString(11, "e-MEC");

            comando.executeUpdate();

            System.out.println(
                "Registro e-MEC salvo: "
                + instituicao
                + " - "
                + curso
            );

        } catch (SQLException erro) {

            System.out.println(
                "Erro ao salvar dado do e-MEC: "
                + erro.getMessage()
            );
        }
    }

    // TABELA UNIFESP

    public static void criarTabelaUNIFESP() {

        String sql =
            "CREATE TABLE IF NOT EXISTS turmas_unifesp (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "curso TEXT, " +
            "ano TEXT, " +
            "disciplina TEXT, " +
            "semestre TEXT, " +
            "data_inicio TEXT, " +
            "data_fim TEXT, " +
            "turno TEXT, " +
            "campus TEXT" +
            ");";

        try (
            Connection conexao = conectar();
            Statement comando = conexao.createStatement()
        ) {

            comando.execute(sql);

            System.out.println(
                "Tabela da UNIFESP preparada com sucesso!"
            );

        } catch (SQLException erro) {

            System.out.println(
                "Erro ao criar tabela da UNIFESP: "
                + erro.getMessage()
            );
        }
    }

    // ADICIONAR TURMA DA UNIFESP

    public static void adicionarTurmaUNIFESP(
        String curso,
        String ano,
        String disciplina,
        String semestre,
        String dataInicio,
        String dataFim,
        String turno,
        String campus
    ) {

        String verificar =
            "SELECT COUNT(*) FROM turmas_unifesp " +
            "WHERE curso = ? " +
            "AND ano = ? " +
            "AND disciplina = ? " +
            "AND semestre = ? " +
            "AND turno = ?";

        try (
            Connection conexao = conectar();
            PreparedStatement comando =
                conexao.prepareStatement(verificar)
        ) {

            comando.setString(1, curso);
            comando.setString(2, ano);
            comando.setString(3, disciplina);
            comando.setString(4, semestre);
            comando.setString(5, turno);

            ResultSet resultado =
                comando.executeQuery();

            if (
                resultado.next()
                && resultado.getInt(1) > 0
            ) {
                return;
            }

        } catch (SQLException erro) {

            System.out.println(
                "Erro ao verificar turma da UNIFESP: "
                + erro.getMessage()
            );

            return;
        }


        String sql =
            "INSERT INTO turmas_unifesp " +
            "(curso, ano, disciplina, semestre, " +
            "data_inicio, data_fim, turno, campus) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection conexao = conectar();
            PreparedStatement comando =
                conexao.prepareStatement(sql)
        ) {

            comando.setString(1, curso);
            comando.setString(2, ano);
            comando.setString(3, disciplina);
            comando.setString(4, semestre);
            comando.setString(5, dataInicio);
            comando.setString(6, dataFim);
            comando.setString(7, turno);
            comando.setString(8, campus);

            comando.executeUpdate();

            System.out.println(
                "Turma UNIFESP salva: "
                + disciplina
            );

        } catch (SQLException erro) {

            System.out.println(
                "Erro ao salvar turma da UNIFESP: "
                + erro.getMessage()
            );
        }
    }

    // BUSCAR ESTADO PELO CÓDIGO DO CURSO

    public static String buscarEstadoPorCodigoCurso(
        String codigoCurso
    ) {

        String sql =
            "SELECT estado FROM instituicoes " +
            "WHERE codigo_emec = ? " +
            "LIMIT 1";

        try (
            Connection conexao = conectar();
            PreparedStatement comando =
                conexao.prepareStatement(sql)
        ) {

            comando.setString(
                1,
                codigoCurso
            );

            ResultSet resultado =
                comando.executeQuery();

            if (resultado.next()) {

                return resultado.getString(
                    "estado"
                );
            }

        } catch (SQLException erro) {

            System.out.println(
                "Erro ao buscar estado do curso: "
                + erro.getMessage()
            );
        }

        return "";
    }

    // ADICIONAR INSTITUIÇÃO

    public static void adicionarInstituicao(
        String nome,
        String sigla,
        String estado,
        String cidade,
        String curso,
        String tipo,
        String modalidade,
        String situacao,
        String site,
        String codigoEmec
    ) {

        String verificar =
            "SELECT COUNT(*) FROM instituicoes " +
            "WHERE codigo_emec = ?";

        try (
            Connection conexao = conectar();
            PreparedStatement comando =
                conexao.prepareStatement(verificar)
        ) {

            comando.setString(
                1,
                codigoEmec
            );

            ResultSet resultado =
                comando.executeQuery();

            if (
                resultado.next()
                && resultado.getInt(1) > 0
            ) {
                return;
            }

        } catch (SQLException erro) {

            System.out.println(
                "Erro ao verificar instituição: "
                + erro.getMessage()
            );

            return;
        }


        String sql =
            "INSERT INTO instituicoes " +
            "(nome, sigla, estado, cidade, curso, tipo, " +
            "modalidade, situacao, site, codigo_emec) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection conexao = conectar();
            PreparedStatement comando =
                conexao.prepareStatement(sql)
        ) {

            comando.setString(1, nome);
            comando.setString(2, sigla);
            comando.setString(3, estado);
            comando.setString(4, cidade);
            comando.setString(5, curso);
            comando.setString(6, tipo);
            comando.setString(7, modalidade);
            comando.setString(8, situacao);
            comando.setString(9, site);
            comando.setString(10, codigoEmec);

            comando.executeUpdate();

            System.out.println(
                "Instituição adicionada: "
                + nome
            );

        } catch (SQLException erro) {

            System.out.println(
                "Erro ao adicionar instituição: "
                + erro.getMessage()
            );
        }
    }

    // BUSCAR INSTITUIÇÕES POR ESTADO

    public static String buscarPorEstado(
        String estado
    ) {

        String sql =
            "SELECT * FROM instituicoes " +
            "WHERE estado = ? " +
            "ORDER BY tipo, nome";

        StringBuilder resultado =
            new StringBuilder();

        try (
            Connection conexao = conectar();
            PreparedStatement comando =
                conexao.prepareStatement(sql)
        ) {

            comando.setString(
                1,
                estado
            );

            ResultSet dados =
                comando.executeQuery();

            while (dados.next()) {

                String nome =
                    dados.getString("nome");

                String sigla =
                    dados.getString("sigla");

                String cidade =
                    dados.getString("cidade");

                String curso =
                    dados.getString("curso");

                String tipo =
                    dados.getString("tipo");

                String modalidade =
                    dados.getString("modalidade");


                resultado.append(nome);

                if (
                    sigla != null
                    && !sigla.isBlank()
                ) {

                    resultado
                        .append(" (")
                        .append(sigla)
                        .append(")");
                }

                resultado.append("\n\n");

                resultado
                    .append("Curso: ")
                    .append(curso)
                    .append("\n");

                resultado
                    .append("Modalidade: ")
                    .append(modalidade)
                    .append("\n");

                resultado
                    .append("Localização: ")
                    .append(cidade)
                    .append(" / ")
                    .append(estado)
                    .append("\n");

                resultado
                    .append("Categoria: ")
                    .append(tipo)
                    .append("\n");

                resultado.append(
                    "----------------------------------------\n\n"
                );
            }

        } catch (SQLException erro) {

            return
                "Erro ao consultar o banco de dados:\n"
                + erro.getMessage();
        }

        if (resultado.length() == 0) {

            return
                "Nenhuma instituição de Oceanografia " +
                "encontrada neste estado.";
        }

        return resultado.toString();
    }


    // ATUALIZAR ESTADOS DOS REGISTROS DO E-MEC

    public static void atualizarEstadosEMEC() {

        String sql =
            "UPDATE dados_emec " +
            "SET estado = (" +
            "SELECT instituicoes.estado " +
            "FROM instituicoes " +
            "WHERE instituicoes.codigo_emec = " +
            "dados_emec.codigo_curso " +
            "LIMIT 1" +
            ") " +
            "WHERE estado IS NULL " +
            "OR TRIM(estado) = ''";

        try (
            Connection conexao = conectar();
            PreparedStatement comando =
                conexao.prepareStatement(sql)
        ) {

            int atualizados =
                comando.executeUpdate();

            System.out.println(
                "Estados do e-MEC atualizados: "
                + atualizados
            );

        } catch (SQLException erro) {

            System.out.println(
                "Erro ao atualizar estados do e-MEC: "
                + erro.getMessage()
            );
        }
    }

    // BUSCAR DADOS DO E-MEC POR ESTADO

    public static String buscarEMECPorEstado(
        String estado
    ) {

        String sql =
            "SELECT * FROM dados_emec " +
            "WHERE estado = ? " +
            "ORDER BY instituicao, curso";

        StringBuilder resultado =
            new StringBuilder();

        try (
            Connection conexao = conectar();
            PreparedStatement comando =
                conexao.prepareStatement(sql)
        ) {

            comando.setString(
                1,
                estado
            );

            ResultSet dados =
                comando.executeQuery();

            while (dados.next()) {

                String instituicao =
                    dados.getString("instituicao");

                String sigla =
                    dados.getString("sigla");

                String curso =
                    dados.getString("curso");

                String categoria =
                    dados.getString("categoria");

                String grau =
                    dados.getString("grau");

                String modalidade =
                    dados.getString("modalidade");

                String vagas =
                    dados.getString("vagas");

                String situacao =
                    dados.getString("situacao");


                resultado.append(instituicao);

                if (
                    sigla != null
                    && !sigla.isBlank()
                ) {

                    resultado
                        .append(" (")
                        .append(sigla)
                        .append(")");
                }

                resultado.append("\n\n");

                resultado
                    .append("Curso: ")
                    .append(curso)
                    .append("\n");

                resultado
                    .append("Grau: ")
                    .append(grau)
                    .append("\n");

                resultado
                    .append("Categoria: ")
                    .append(categoria)
                    .append("\n");

                resultado
                    .append("Modalidade: ")
                    .append(modalidade)
                    .append("\n");

                resultado
                    .append("Vagas: ")
                    .append(vagas)
                    .append("\n");

                resultado
                    .append("Situação: ")
                    .append(situacao)
                    .append("\n");

                resultado.append(
                    "----------------------------------------\n\n"
                );
            }

        } catch (SQLException erro) {

            return
                "Erro ao consultar dados do e-MEC:\n"
                + erro.getMessage();
        }

        if (resultado.length() == 0) {

            return
                "Nenhum registro do e-MEC " +
                "encontrado neste estado.";
        }

        return resultado.toString();
    }


    // BUSCAR TURMAS DA UNIFESP
   
    public static String buscarTurmasUNIFESP() {

        String sql =
            "SELECT * FROM turmas_unifesp " +
            "ORDER BY semestre, disciplina, turno";

        StringBuilder resultado =
            new StringBuilder();

        try (
            Connection conexao = conectar();
            PreparedStatement comando =
                conexao.prepareStatement(sql);
            ResultSet dados =
                comando.executeQuery()
        ) {

            while (dados.next()) {

                String disciplina =
                    dados.getString("disciplina");

                String semestre =
                    dados.getString("semestre");

                String turno =
                    dados.getString("turno");

                String campus =
                    dados.getString("campus");

                String ano =
                    dados.getString("ano");


                resultado
                    .append(disciplina)
                    .append("\n\n");

                resultado
                    .append("Ano: ")
                    .append(ano)
                    .append("\n");

                resultado
                    .append("Semestre: ")
                    .append(semestre)
                    .append("\n");

                resultado
                    .append("Turno: ")
                    .append(
                        traduzirTurno(turno)
                    )
                    .append("\n");

                resultado
                    .append("Campus: ")
                    .append(campus)
                    .append("\n");

                resultado.append(
                    "----------------------------------------\n\n"
                );
            }

        } catch (SQLException erro) {

            return
                "Erro ao consultar turmas da UNIFESP:\n"
                + erro.getMessage();
        }

        if (resultado.length() == 0) {

            return
                "Nenhuma turma da UNIFESP encontrada.";
        }

        return resultado.toString();
    }

    // TRADUZIR CÓDIGO DO TURNO
  
    private static String traduzirTurno(
        String turno
    ) {

        if (turno == null) {
            return "Não informado";
        }

        switch (turno.toUpperCase()) {

            case "M":
                return "Matutino";

            case "V":
                return "Vespertino";

            case "N":
                return "Noturno";

            case "I":
                return "Integral";

            default:
                return turno;
        }
    }
}