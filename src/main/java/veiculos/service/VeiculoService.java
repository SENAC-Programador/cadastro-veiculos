package veiculos.service;
import veiculos.db.ConexaoDatabase;
import veiculos.model.Veiculos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoService {
    private static ConexaoDatabase conexao = new ConexaoDatabase();
    public static List<Veiculos> carregarVeiculos() {
        List<Veiculos> out = new ArrayList<>();
        try {
            Connection conn = conexao.getConexao();
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM veiculos");
            while (rs.next()) {
                Veiculos veiculo = new Veiculos(
                        rs.getInt("idVeiculo"),
                        rs.getString("chassi"),
                        rs.getString("placa"),
                        rs.getString("ano"),
                        rs.getString("cor"),
                        rs.getString("quilometragem"));

                out.add(veiculo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

    // Inserir Veiculo (INSERT)
    public static void inserirVeiculo(Veiculos veiculo) {
        try {
            Connection conn = conexao.getConexao();
            String sql = "INSERT INTO veiculo (chassi, placa, ano, cor, quilometragem) VALUES ( ?, ?, ?, ?, ?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, veiculo.getChassi());
            pre.setString(2, veiculo.getPlaca());
            pre.setString(3, veiculo.getAno());
            pre.setString(4, veiculo.getCor());
            pre.setString(5, veiculo.getQuilometragem());

            pre.execute();
            pre.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Atualizar Veículo (UPDATE)
    public static boolean atualizarCliente(int idVeiculo, Veiculos veiculo) {
        try {
            Connection conn = conexao.getConexao();
            String updateSql = "UPDATE veiculos " +
                    "SET chassi = ?, placa = ?, ano = ?, cor = ?, quilometragem = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(updateSql);
            ps.setString(1, veiculo.getChassi());
            ps.setString(2, veiculo.getPlaca());
            ps.setString(3, veiculo.getAno());
            ps.setString(4, veiculo.getCor());
            ps.setString(5, veiculo.getQuilometragem());
            ps.setInt(6, idVeiculo); // Não funciona dessa forma "cli.getId();"

            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Excluir Veiculo (DELETE)
    public static boolean deletarCliente(int idVeiculo) {
        try {
            Connection conn = conexao.getConexao();
            String deleteSql = "DELETE FROM veiculos WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(deleteSql);
            ps.setInt(1, idVeiculo);

            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    //    // Validar o documento unico,
    public static boolean buscarVeiculoByDocumento(String documento) {
        try {
            Connection conn = conexao.getConexao();
            String selectSql = "SELECT id FROM veiculos WHERE documento = '" + documento + "'"; // precisa colocar entre aspas simples
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(selectSql);
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
