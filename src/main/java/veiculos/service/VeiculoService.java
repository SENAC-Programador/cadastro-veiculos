package veiculos.service;
import veiculos.db.ConexaoDatabase;
import veiculos.model.Veiculo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoService {
    private static ConexaoDatabase conexao = new ConexaoDatabase();

    // VEÍCULO: id, chassi, placa, corVeiculo, quilometragem
    public static List<Veiculo> carregarVeiculo() {
        List<Veiculo> out = new ArrayList<>();
        try {
            Connection conexaoSelect = conexao.getConexao();
            Statement statementSelect = conexaoSelect.createStatement();
            ResultSet resultadoSelect = statementSelect.executeQuery("SELECT * FROM veiculos");
            while (resultadoSelect.next()) {
                Veiculo veiculo = new Veiculo(
                        resultadoSelect.getInt("id"),
                        resultadoSelect.getString("chassi"),
                        resultadoSelect.getString("placa"),
                        resultadoSelect.getString("corVeiculo"),
                        resultadoSelect.getString("quilometragem"));

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

    // Atualizar (UPDATE) - VEÍCULO: chassi, placa, corVeiculo, quilometragem
    public static boolean atualizarVeiculo(int idVeiculo, Veiculo veiculo) {
        try {
            Connection conexaoUpdate = conexao.getConexao();
            String updateSql = "UPDATE veiculos " +
                    "SET chassi = ?, placa = ?, corVeiculo = ?, quilometragem = ? WHERE id = ?";
            PreparedStatement prepareStatementUpdate = conexaoUpdate.prepareStatement(updateSql);
            prepareStatementUpdate.setString(1, veiculo.getChassi());
            prepareStatementUpdate.setString(2, veiculo.getPlaca());
            prepareStatementUpdate.setString(3, veiculo.getCorVeiculo());
            prepareStatementUpdate.setString(4, veiculo.getQuilometragem());
            prepareStatementUpdate.setInt(5, idVeiculo);

            return prepareStatementUpdate.execute();
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

