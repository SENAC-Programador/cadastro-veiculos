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
            Statement selectStatement = conexaoSelect.createStatement();
            ResultSet selectResultado = selectStatement.executeQuery("SELECT * FROM modelos");
            while (selectResultado.next()) {
                Modelo modelo = new Modelo(
                        selectResultado.getInt("id"),
                        selectResultado.getString("id_veiculo"),
                        selectResultado.getString("nomeModelo"),
                        selectResultado.getString("motor"),
                        selectResultado.getString("potencia"),
                        selectResultado.getString("anoLancamento"),
                        selectResultado.getString("tipoCombustivel"),
                        selectResultado.getString("numeroPortas"));
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
            Connection conn = conexao.getConexao();
            String sql = "INSERT INTO modelos (id_veiculo, nomeModelo, motor, potencia, anoLancamento, " +
                    "tipoCombustivel, numeroPortas) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insertPrepareStatement = conn.prepareStatement(sql);
            insertPrepareStatement.setInt(1, Integer.parseInt(modelo.getCodigoVeiculo()));
            insertPrepareStatement.setString(2, modelo.getNomeModelo());
            insertPrepareStatement.setString(3, modelo.getMotor());
            insertPrepareStatement.setString(4, modelo.getPotencia());
            insertPrepareStatement.setString(5, modelo.getAnoLancamento());
            insertPrepareStatement.setString(6, modelo.getTipoCombustivel());
            insertPrepareStatement.setString(7, modelo.getNumeroPortas());

            insertPrepareStatement.execute();
            insertPrepareStatement.close();

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
                    "SET nomeModelo = ?, potencia = ?, motor = ?, anoLancamento = ?, tipoCombustivel = ?, " +
                    "numeroPortas = ? WHERE id_veiculo = ?";
            PreparedStatement updatePrepareStatement = conexaoUpdate.prepareStatement(updateSql);
            updatePrepareStatement.setString(1, modelo.getNomeModelo());
            updatePrepareStatement.setString(2, modelo.getPotencia());
            updatePrepareStatement.setString(3, modelo.getMotor());
            updatePrepareStatement.setString(4, modelo.getAnoLancamento());
            updatePrepareStatement.setString(5, modelo.getTipoCombustivel());
            updatePrepareStatement.setString(6, modelo.getNumeroPortas());
            updatePrepareStatement.setInt(7, codigoVeiculo); // Não funciona dessa forma modelo.getIdMarca();
            return updatePrepareStatement.execute();
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
            PreparedStatement deletePrepareStatement = conexaoDelete.prepareStatement(deleteSql);
            deletePrepareStatement.setInt(1, idModelo);

            return deletePrepareStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
