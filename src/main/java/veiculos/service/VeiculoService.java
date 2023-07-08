package veiculos.service;
import veiculos.db.ConexaoDatabase;
import veiculos.model.Veiculos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoService {
    private static ConexaoDatabase conexao = new ConexaoDatabase();
    // VEÍCULO: idVeiculo, dataCadastroVeiculo, chassi, placa, corVeiculo, quilometragem, codigoMarca, codigoModelo
    public static List<Veiculos> carregarVeiculo() {
        List<Veiculos> out = new ArrayList<>();
        try {
            Connection conn = conexao.getConexao();
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM veiculos");
            while (rs.next()) {
                Veiculos veiculo = new Veiculos(
                        rs.getInt("idVeiculo"),
                        rs.getString("dataCadastroVeiculo"),
                        rs.getString("chassi"),
                        rs.getString("placa"),
                        rs.getString("corVeiculo"),
                        rs.getString("quilometragem"),
                        rs.getString("codigoMarca"),
                        rs.getString("codigoModelo"));

                out.add(veiculo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

    // Inserir (INSERT)
    public static void inserirVeiculo(Veiculos veiculo) {
        try {
            Connection conn = conexao.getConexao();
            String sql = "INSERT INTO veiculo (dataCadastroVeiculo, chassi, placa, cor, quilometragem,  " +
                    "codigoMarca, codigoModelo) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, veiculo.getDataCadastroVeiculo());
            pre.setString(2, veiculo.getChassi());
            pre.setString(3, veiculo.getPlaca());
            pre.setString(4, veiculo.getCorVeiculo());
            pre.setString(5, veiculo.getQuilometragem());
            pre.setString(6, veiculo.getCodigoMarca());
            pre.setString(7, veiculo.getCodigoMarca());

            pre.execute();
            pre.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Atualizar (UPDATE)
    public static boolean atualizarVeiculo(int idVeiculo, Veiculos veiculo) {
        try {
            Connection conn = conexao.getConexao();
            String updateSql = "UPDATE veiculos " +
                    "SET dataCadastroVeiculo = ?, chassi = ?, placa = ?, cor = ?, quilometragem = ? " +
                    "codigoMarca = ?, codigoModelo = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(updateSql);
            ps.setString(1, veiculo.getDataCadastroVeiculo());
            ps.setString(2, veiculo.getChassi());
            ps.setString(3, veiculo.getPlaca());
            ps.setString(4, veiculo.getCorVeiculo());
            ps.setString(5, veiculo.getQuilometragem());
            ps.setString(6, veiculo.getCodigoMarca());
            ps.setString(7, veiculo.getCodigoModelo());
            ps.setInt(8, idVeiculo);

            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Excluir (DELETE)
    public static boolean deletarVeiculo(int idVeiculo) {
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

    // Validar o chassi unico,
    public static boolean buscarVeiculoByChassi(String chassi) {
        try {
            Connection conn = conexao.getConexao();
            String selectSql = "SELECT id FROM veiculos WHERE chassi = '" + chassi + "'"; // precisa colocar entre aspas simples
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(selectSql);
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean buscarVeiculoByPlaca(String placa) {
        try {
            Connection conn = conexao.getConexao();
            String selectSql = "SELECT id FROM veiculos WHERE placa = '" + placa + "'"; // precisa colocar entre aspas simples
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(selectSql);
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
