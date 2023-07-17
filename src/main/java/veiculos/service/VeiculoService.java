package veiculos.service;
import veiculos.db.ConexaoDatabase;
import veiculos.model.Veiculo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoService {
    private static ConexaoDatabase conexao = new ConexaoDatabase();
    // VEÍCULO: int idVeiculo, String chassi, String placa, String corVeiculo, String quilometragem
    public static List<Veiculo> carregarVeiculo() {
        List<Veiculo> out = new ArrayList<>();
        try {
            Connection conn = conexao.getConexao();
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM veiculos");
            while (rs.next()) {
                Veiculo veiculo = new Veiculo(
                        rs.getInt("idVeiculo"),
                        rs.getString("chassi"),
                        rs.getString("placa"),
                        rs.getString("corVeiculo"),
                        rs.getString("quilometragem"));

                out.add(veiculo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

    // Inserir (INSERT) -> VEÍCULO: chassi, placa, corVeiculo, quilometragem
    public static void inserirVeiculo(Veiculo veiculo) {
        try {
            Connection conexaoInsert = conexao.getConexao();
            String insertSql = "INSERT INTO veiculo (chassi, placa, cor, quilometragem) " +
                    "VALUES ( ?, ?, ?, ?)";
            PreparedStatement preInsert = conexaoInsert.prepareStatement(insertSql);
            preInsert.setString(1, veiculo.getChassi());
            preInsert.setString(2, veiculo.getPlaca());
            preInsert.setString(3, veiculo.getCorVeiculo());
            preInsert.setString(4, veiculo.getQuilometragem());

            preInsert.execute();
            preInsert.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Atualizar (UPDATE) - VEÍCULO: chassi, placa, corVeiculo, quilometragem
    public static boolean atualizarVeiculo(int idVeiculo, Veiculo veiculo) {
        try {
            Connection conexaoUpdate = conexao.getConexao();
            String updateSql = "UPDATE veiculos " +
                    "SET chassi = ?, placa = ?, corVeiculo = ?, quilometragem = ? WHERE id = ?";
            PreparedStatement preUpdate = conexaoUpdate.prepareStatement(updateSql);
            preUpdate.setString(1, veiculo.getChassi());
            preUpdate.setString(2, veiculo.getPlaca());
            preUpdate.setString(3, veiculo.getCorVeiculo());
            preUpdate.setString(4, veiculo.getQuilometragem());
            preUpdate.setInt(5, idVeiculo);

            return preUpdate.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Excluir (DELETE) - VEÍCULO: chassi, placa, corVeiculo, quilometragem
    public static boolean deletarVeiculo(int idVeiculo) {
        try {
            Connection conexaoDelete = conexao.getConexao();
            String deleteSql = "DELETE FROM veiculos WHERE id = ?";
            PreparedStatement prepareStatementDelete = conexaoDelete.prepareStatement(deleteSql);
            prepareStatementDelete.setInt(1, idVeiculo);

            return prepareStatementDelete.execute();
        } catch (Exception e) {
            e.printStackTrace();

        }

        return false;
    }

    // Validar o chassi unico,
    public static boolean buscarVeiculoPorChassi(String chassi) {
        try {
            Connection conexaoBusca = conexao.getConexao();
            String selectSql = "SELECT id FROM veiculos WHERE chassi = '" + chassi + "'"; // precisa colocar entre aspas simples
            Statement buscaChassiStatement = conexaoBusca.createStatement();
            ResultSet buscaChassiResultado = buscaChassiStatement.executeQuery(selectSql);
            return buscaChassiResultado.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean buscarVeiculoPorPlaca(String placa) {
        try {
            Connection conn = conexao.getConexao();
            String selectSql = "SELECT id FROM veiculos WHERE placa = '" + placa + "'"; // precisa colocar entre aspas simples
            Statement buscaPlacaStatement = conn.createStatement();
            ResultSet buscaPlacaResultado = buscaPlacaStatement.executeQuery(selectSql);
            return buscaPlacaResultado.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
