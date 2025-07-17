package dao;


import config.ConexaoMySQL;
import model.Relatorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RelatorioDAO {

    private static Connection conn = ConexaoMySQL.getConnection();

    // 1. Listar todos os funcionários de um setor específico
    public ArrayList<Relatorio> listarFuncionariosPorSetor(String nomeSetor) {
        ArrayList<Relatorio> relatorios = new ArrayList<>();
        String sql = "SELECT f.nome, f.sobrenome, s.nome_setor " +
                "FROM funcionario f " +
                "JOIN setor s ON f.id_setor = s.id_setor " +
                "WHERE s.nome_setor = ? " +
                "ORDER BY f.nome;";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nomeSetor);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String nomeFuncionario = rs.getString("nome");
                    String sobrenomeFuncionario = rs.getString("sobrenome");
                    String setor = rs.getString("nome_setor");
                    relatorios.add(new Relatorio(nomeFuncionario, sobrenomeFuncionario, setor, null, null));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar funcionários por setor: " + e.getMessage());
            return null;
        }
        return relatorios;
    }

    // 2. Mostrar todos os produtos produzidos em uma determinada data
    public ArrayList<Relatorio> listarProdutosProduzidosEmData(String dataProducao) {
        ArrayList<Relatorio> relatorios = new ArrayList<>();
        String sql = "SELECT p.nome_produto, pr.quantidade, pr.data_producao " +
                "FROM produtos p " +
                "JOIN producao pr ON p.id_produtos = pr.id_produtos " +
                "WHERE pr.data_producao = ? " +
                "ORDER BY p.nome_produto;";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dataProducao);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String nomeProduto = rs.getString("nome_produto");
                    Integer quantidade = rs.getInt("quantidade");
                    String data = rs.getString("data_producao");
                    relatorios.add(new Relatorio(nomeProduto, data, null, quantidade, null));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos produzidos em data: " + e.getMessage());
            return null;
        }
        return relatorios;
    }

    // 3. Contar quantos produtos cada funcionário já produziu (quantidade total)
    public ArrayList<Relatorio> contarProdutosPorFuncionario() {
        ArrayList<Relatorio> relatorios = new ArrayList<>();
        String sql = "SELECT f.nome, f.sobrenome, SUM(pr.quantidade) AS total_produzido " +
                "FROM funcionario f " +
                "JOIN producao pr ON f.id_funcionario = pr.id_funcionario " +
                "GROUP BY f.id_funcionario, f.nome, f.sobrenome " +
                "ORDER BY total_produzido DESC;";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String nomeFuncionario = rs.getString("nome");
                String sobrenomeFuncionario = rs.getString("sobrenome");
                Integer totalProduzido = rs.getInt("total_produzido");
                relatorios.add(new Relatorio(nomeFuncionario + " " + sobrenomeFuncionario, totalProduzido));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao contar produtos por funcionário: " + e.getMessage());
            return null;
        }
        return relatorios;
    }

    // 4. Listar todos os funcionários, seus setores e produtos produzidos
    public ArrayList<Relatorio> listarFuncionariosSetoresProdutosProduzidos() {
        ArrayList<Relatorio> relatorios = new ArrayList<>();
        String sql = "SELECT f.nome, f.sobrenome, s.nome_setor, p.nome_produto, pr.quantidade, pr.data_producao " +
                "FROM funcionario f " +
                "JOIN setor s ON f.id_setor = s.id_setor " +
                "LEFT JOIN producao pr ON f.id_funcionario = pr.id_funcionario " +
                "LEFT JOIN produtos p ON pr.id_produtos = p.id_produtos " +
                "ORDER BY f.nome, s.nome_setor, pr.data_producao DESC;";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String nomeFuncionario = rs.getString("nome");
                String sobrenomeFuncionario = rs.getString("sobrenome");
                String nomeSetor = rs.getString("nome_setor");
                String nomeProduto = rs.getString("nome_produto"); // Pode ser null se o funcionário não produziu nada
                Integer quantidade = rs.getObject("quantidade") != null ? rs.getInt("quantidade") : null; // Lida com null
                String dataProducao = rs.getString("data_producao"); // Pode ser null

                relatorios.add(new Relatorio(
                        nomeFuncionario + " " + sobrenomeFuncionario, // Campo1: Nome Completo Funcionário
                        nomeSetor,                                   // Campo2: Nome do Setor
                        nomeProduto != null ? nomeProduto : "Nenhum produto", // Campo3: Nome do Produto (ou marcador)
                        quantidade,                                  // CampoNumerico: Quantidade Produzida
                        dataProducao != null ? " em " + dataProducao : "" // Campo4: Data da Produção (ou vazio)
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar funcionários, setores e produtos produzidos: " + e.getMessage());
            return null;
        }
        return relatorios;
    }

    // 5. Listar produtos produzidos em uma data específica, com detalhes do funcionário e setor
    public ArrayList<Relatorio> listarProdutosProduzidosComDetalhes(String dataProducao) {
        ArrayList<Relatorio> relatorios = new ArrayList<>();
        String sql = "SELECT p.nome_produto, pr.quantidade, pr.data_producao, " +
                "f.nome AS funcionario_nome, f.sobrenome AS funcionario_sobrenome, " +
                "s.nome_setor " +
                "FROM producao pr " +
                "JOIN produtos p ON pr.id_produtos = p.id_produtos " +
                "JOIN funcionario f ON pr.id_funcionario = f.id_funcionario " +
                "JOIN setor s ON f.id_setor = s.id_setor " +
                "WHERE pr.data_producao = ? " +
                "ORDER BY p.nome_produto, f.nome;";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dataProducao);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String nomeProduto = rs.getString("nome_produto");
                    Integer quantidade = rs.getInt("quantidade");
                    String data = rs.getString("data_producao");
                    String nomeFuncionario = rs.getString("funcionario_nome");
                    String sobrenomeFuncionario = rs.getString("funcionario_sobrenome");
                    String nomeSetor = rs.getString("nome_setor");

                    relatorios.add(new Relatorio(
                            nomeProduto,                                    // Campo1: Nome do Produto
                            data,                                           // Campo2: Data da Produção
                            nomeFuncionario + " " + sobrenomeFuncionario, // Campo3: Nome Completo Funcionário
                            quantidade,                                     // CampoNumerico: Quantidade
                            nomeSetor                                       // Campo4: Nome do Setor
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos produzidos com detalhes: " + e.getMessage());
            return null;
        }
        return relatorios;
    }
}
