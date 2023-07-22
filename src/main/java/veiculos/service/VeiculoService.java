package veiculos.service;
import veiculos.db.ConexaoDatabase;
import veiculos.model.Veiculo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class VeiculoService {
    private static ConexaoDatabase conexao = new ConexaoDatabase();

// Consultar (SELECT)
    public static List<Veiculo> carregarVeiculo() {
        List<Veiculo> out = new ArrayList<>();
        try {
            Connection conexaoSelect = conexao.getConexao();
            Statement statementSelect = conexaoSelect.createStatement();
            ResultSet resultadoSelect = statementSelect.executeQuery
                    ("SELECT vei.id, vei.chassi, vei.placa, vei.cor_veiculo, vei.quilometragem, " +
                            "vei.id_modelo, mo.nome_modelo, mar.razao_social  \n" +
                            "FROM veiculos vei \n" +
                            "INNER JOIN modelos mo ON mo.id = vei.id_modelo\n" +
                            "INNER JOIN marcas mar ON mar.id = mo.id_marca; ");
            while (resultadoSelect.next()) {
                Veiculo veiculo = new Veiculo(
                        resultadoSelect.getInt("id"),
                        resultadoSelect.getString("chassi"),
                        resultadoSelect.getString("placa"),
                        resultadoSelect.getString("cor_veiculo"),
                        resultadoSelect.getString("quilometragem"),
                        resultadoSelect.getString("id_modelo"),
                        resultadoSelect.getString("nome_modelo"),
                        resultadoSelect.getString("razao_social"));

                out.add(veiculo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }
// // id_modelo, chassi, placa, cor_veiculo, quilometragem
// Inserir (INSERT)
    public static void inserirVeiculo(Veiculo veiculo) {
        try {
            Connection conexaoInsert = conexao.getConexao();
            String insertSql = "INSERT INTO veiculos (id_modelo, chassi, placa, cor_veiculo, quilometragem) " +
                    "VALUES ( ?, ?, ?, ?, ?)";
            PreparedStatement prepareStatementInsert = conexaoInsert.prepareStatement(insertSql);
            prepareStatementInsert.setInt(1, Integer.parseInt(veiculo.getCodigoModelo()));
            prepareStatementInsert.setString(2, veiculo.getChassi());
            prepareStatementInsert.setString(3, veiculo.getPlaca());
            prepareStatementInsert.setString(4, veiculo.getCorVeiculo());
            prepareStatementInsert.setInt(5, Integer.parseInt(veiculo.getQuilometragem()));

            prepareStatementInsert.execute();
            prepareStatementInsert.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

// Atualizar (UPDATE) - id_modelo, chassi, placa, cor_veiculo, quilometragem
    public static boolean atualizarVeiculo(int idVeiculo, Veiculo veiculo) {
        try {
            Connection conexaoUpdate = conexao.getConexao();
            String updateSql = "UPDATE veiculos " +
                    "SET cor_veiculo = ?, quilometragem = ? WHERE id = ?";
            PreparedStatement prepareStatementUpdate = conexaoUpdate.prepareStatement(updateSql);
            prepareStatementUpdate.setString(1, veiculo.getCorVeiculo());
            prepareStatementUpdate.setInt(2, Integer.parseInt(veiculo.getQuilometragem()));
            prepareStatementUpdate.setInt(3, idVeiculo);

            return prepareStatementUpdate.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

// Excluir (DELETE)
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
            Connection conexaoBuscaChassi = conexao.getConexao();
            String selectSql = "SELECT id FROM veiculos WHERE chassi = '" + chassi + "'"; // precisa colocar entre aspas simples
            Statement buscaChassiStatement = conexaoBuscaChassi.createStatement();
            ResultSet buscaChassiResultado = buscaChassiStatement.executeQuery(selectSql);
            return buscaChassiResultado.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean buscarVeiculoPorPlaca(String placa) {
        try {
            Connection conexaoBuscaPlaca = conexao.getConexao();
            String selectSql = "SELECT id FROM veiculos WHERE placa = '" + placa + "'"; // precisa colocar entre aspas simples
            Statement buscaPlacaStatement = conexaoBuscaPlaca.createStatement();
            ResultSet buscaPlacaResultado = buscaPlacaStatement.executeQuery(selectSql);
            return buscaPlacaResultado.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
