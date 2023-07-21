package veiculos.service;
import veiculos.db.ConexaoDatabase;
import veiculos.model.Modelo;
import veiculos.model.Veiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModeloService {
    private static ConexaoDatabase conexao = new ConexaoDatabase();

// Consultar (SELECT)
    public static List<Modelo> carregarModelos() {
        List<Modelo> out = new ArrayList<>();
        try {
            Connection conexaoSelect = conexao.getConexao();
            Statement statementSelect = conexaoSelect.createStatement();
            ResultSet resultadoSelect = statementSelect.executeQuery("SELECT * FROM modelos");
            while (resultadoSelect.next()) {
                Modelo modelo = new Modelo(
                        resultadoSelect.getInt("id"),
                        resultadoSelect.getString("id_marca"),
                        resultadoSelect.getString("nome_modelo"),
                        resultadoSelect.getString("motor"),
                        resultadoSelect.getString("potencia"),
                        resultadoSelect.getString("ano_lancamento"),
                        resultadoSelect.getString("tipo_combustivel"),
                        resultadoSelect.getString("numero_portas"));
                out.add(modelo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }
    // id_marca, nome_modelo, motor, potencia, ano_lancamento, tipo_combustivel, numero_portas
// Inserir/Adicionar (INSERT)
    public static void inserirModelo(Modelo modelo) {
        try {
            Connection conexaoInsert = conexao.getConexao();
            String insertSql = "INSERT INTO modelos (id_marca, nome_modelo, motor, potencia, ano_lancamento, " +
                    "tipo_combustivel, numero_portas) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement prepareStatementInsert = conexaoInsert.prepareStatement(insertSql);
            prepareStatementInsert.setInt(1, Integer.parseInt(modelo.getCodigoMarca()));
            prepareStatementInsert.setString(2, modelo.getNomeModelo());
            prepareStatementInsert.setString(3, modelo.getMotor());
            prepareStatementInsert.setString(4, modelo.getPotencia());
            prepareStatementInsert.setString(5, modelo.getAnoLancamento());
            prepareStatementInsert.setString(6, modelo.getTipoCombustivel());
            prepareStatementInsert.setString(7, modelo.getNumeroPortas());

            prepareStatementInsert.execute();
            prepareStatementInsert.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

// Atualizar (UPDATE) - id_marca, nome_modelo, motor, potencia, ano_lancamento, tipo_combustivel, numero_portas
    public static boolean atualizarModelo(int codigoVeiculo, Modelo modelo) {
        try {
            Connection conexaoUpdate = conexao.getConexao();
            String updateSql = "UPDATE modelos " +
                    "SET nome_modelo = ?, motor = ?, potencia = ?, tipo_combustivel = ? WHERE id = ?";
            PreparedStatement prepareStatementUpdate = conexaoUpdate.prepareStatement(updateSql);
            prepareStatementUpdate.setString(1, modelo.getNomeModelo());
            prepareStatementUpdate.setString(2, modelo.getMotor());
            prepareStatementUpdate.setString(3, modelo.getPotencia());
            prepareStatementUpdate.setString(4, modelo.getTipoCombustivel());
            prepareStatementUpdate.setInt(5, codigoVeiculo); // Não funciona dessa forma modelo.getIdMarca();
            return prepareStatementUpdate.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

// Excluir (DELETE) - id_marca, nome_modelo, motor, potencia, ano_lancamento, tipo_combustivel, numero_portas
    public static boolean deletarModelo(int idModelo) {
        try {
            Connection conexaoDelete = conexao.getConexao();
            String deleteSql = "DELETE FROM modelos WHERE id = ?";
            PreparedStatement prepareStatementDelete = conexaoDelete.prepareStatement(deleteSql);
            prepareStatementDelete.setInt(1, idModelo);

            return prepareStatementDelete.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean verificarExistenciaModeloPorId(String idMarca) {
        try {
            Connection conexaoVerificar = conexao.getConexao();
            String selectSql = "SELECT id FROM modelos WHERE id_marca = '" + idMarca + "'"; // precisa colocar entre aspas simples
            Statement verificarIdModeloStatement = conexaoVerificar.createStatement();
            ResultSet resultado = verificarIdModeloStatement.executeQuery(selectSql);
            return resultado.next();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return false;
    }
}