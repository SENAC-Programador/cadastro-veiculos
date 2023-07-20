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
                    ("SELECT vei.id, vei.chassi, vei.placa, vei.corVeiculo, vei.quilometragem, mo.nomeModelo, mar.razaosocial  \n" +
                            "FROM veiculos vei \n" +
                            "Left JOIN modelos mo ON mo.id_veiculo = vei.id\n" +
                            "LEFT JOIN marcas mar ON mar.id_modelo = mo.id; ");
            while (resultadoSelect.next()) {
                Veiculo veiculo = new Veiculo(
                        resultadoSelect.getInt("id"),
                        resultadoSelect.getString("chassi"),
                        resultadoSelect.getString("placa"),
                        resultadoSelect.getString("corVeiculo"),
                        resultadoSelect.getString("quilometragem"),
                        resultadoSelect.getString("nomeModelo"),
                        resultadoSelect.getString("razaosocial"));

                out.add(veiculo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

// Inserir (INSERT)
    public static void inserirVeiculo(Veiculo veiculo) {
        try {
            Connection conexaoInsert = conexao.getConexao();
            String insertSql = "INSERT INTO veiculos (chassi, placa, corVeiculo, quilometragem) " +
                    "VALUES ( ?, ?, ?, ?)";
            PreparedStatement prepareStatementInsert = conexaoInsert.prepareStatement(insertSql);
            prepareStatementInsert.setString(1, veiculo.getChassi());
            prepareStatementInsert.setString(2, veiculo.getPlaca());
            prepareStatementInsert.setString(3, veiculo.getCorVeiculo());
            prepareStatementInsert.setString(4, veiculo.getQuilometragem());

            prepareStatementInsert.execute();
            prepareStatementInsert.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

// Atualizar (UPDATE)
    public static boolean atualizarVeiculo(int idVeiculo, Veiculo veiculo) {
        try {
            Connection conexaoUpdate = conexao.getConexao();
            String updateSql = "UPDATE veiculos " +
                    "SET corVeiculo = ?, quilometragem = ? WHERE id = ?";
            PreparedStatement prepareStatementUpdate = conexaoUpdate.prepareStatement(updateSql);
            prepareStatementUpdate.setString(1, veiculo.getCorVeiculo());
            prepareStatementUpdate.setString(2, veiculo.getQuilometragem());
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

    public static boolean verificarExistenciaVeiculoPorId(int idVeiculo) {
        List<Veiculo> listaVeiculos = VeiculoService.carregarVeiculo(); // Obtenha a lista de veículos existentes
        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.getIdVeiculo() == idVeiculo) {
                return true; // O veículo com o ID especificado existe
            }
        }
        return false; // O veículo com o ID especificado não existe
    }
}
