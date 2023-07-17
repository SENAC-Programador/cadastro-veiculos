package veiculos.service;
import veiculos.db.ConexaoDatabase;
import veiculos.model.Modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModeloService {

     private static ConexaoDatabase conexao = new ConexaoDatabase();

// MODELO: id, id_veiculo, nomeModelo, motor, potencia, anoLancamento, tipoCombustivel, numeroPortas
     public static List<Modelo> carregarModelos() {
        List<Modelo> out = new ArrayList<>();
        try {
            Connection conexaoSelect = conexao.getConexao();
            Statement statementSelect = conexaoSelect.createStatement();
            ResultSet resultadoSelect = statementSelect.executeQuery("SELECT * FROM modelos");
            while (resultadoSelect.next()) {
                Modelo modelo = new Modelo(
                        resultadoSelect.getInt("id"),
                        resultadoSelect.getString("id_veiculo"),
                        resultadoSelect.getString("nomeModelo"),
                        resultadoSelect.getString("motor"),
                        resultadoSelect.getString("potencia"),
                        resultadoSelect.getString("anoLancamento"),
                        resultadoSelect.getString("tipoCombustivel"),
                        resultadoSelect.getString("numeroPortas"));
                out.add(modelo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

    // Inserir/Adicionar (INSERT) -
    // MODELO: id_veiculo, nomeModelo, motor, potencia, anoLancamento, tipoCombustivel, numeroPortas
    public static void inserirModelo(Modelo modelo) {
        try {
            Connection conexaoInsert = conexao.getConexao();
            String insertSql = "INSERT INTO modelos (id_veiculo, nomeModelo, motor, potencia, anoLancamento, " +
                    "tipoCombustivel, numeroPortas) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement prepareStatementInsert = conexaoInsert.prepareStatement(insertSql);
            prepareStatementInsert.setInt(1, Integer.parseInt(modelo.getCodigoVeiculo()));
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

    // Atualizar (UPDATE)
    // MODELO: id_veiculo, nomeModelo, motor, potencia, anoLancamento, tipoCombustivel, numeroPortas
    public static boolean atualizarModelo(int codigoVeiculo, Modelo modelo) {
        try {
            Connection conexaoUpdate = conexao.getConexao();
            String updateSql = "UPDATE modelos " +
                    "SET id_veiculo = ?, nomeModelo = ?, motor = ?, potencia = ?, anoLancamento = ?, " +
                    "tipoCombustivel = ?, numeroPortas = ? WHERE id = ?";
            PreparedStatement prepareStatementUpdate = conexaoUpdate.prepareStatement(updateSql);
            prepareStatementUpdate.setInt(1, Integer.parseInt(modelo.getCodigoVeiculo()));
            prepareStatementUpdate.setString(2, modelo.getNomeModelo());
            prepareStatementUpdate.setString(3, modelo.getPotencia());
            prepareStatementUpdate.setString(4, modelo.getMotor());
            prepareStatementUpdate.setString(5, modelo.getAnoLancamento());
            prepareStatementUpdate.setString(6, modelo.getTipoCombustivel());
            prepareStatementUpdate.setString(7, modelo.getNumeroPortas());
            prepareStatementUpdate.setInt(8, codigoVeiculo); // Não funciona dessa forma modelo.getIdMarca();
            return prepareStatementUpdate.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Excluir (DELETE)
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

}
