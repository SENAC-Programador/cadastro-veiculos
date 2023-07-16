package veiculos.service;
import veiculos.db.ConexaoDatabase;
import veiculos.model.Modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModeloService {

     private static ConexaoDatabase conexao = new ConexaoDatabase();
     public static List<Modelo> carregarModelos() {
        List<Modelo> out = new ArrayList<>();
        try {
            Connection conn = conexao.getConexao();
            Statement sta = conn.createStatement();
            ResultSet resultado = sta.executeQuery("SELECT * FROM modelos");
            while (resultado.next()) {
                Modelo modelo = new Modelo(
                        resultado.getInt("id"),
                        resultado.getString("id_marca"),
                        resultado.getString("nomeModelo"),
                        resultado.getString("potencia"),
                        resultado.getString("motor"),
                        resultado.getString("anoLancamento"),
                        resultado.getString("tipoCombustivel"),
                        resultado.getString("numeroPortas"));
                out.add(modelo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

    // Inserir/Adicionar (INSERT)
    public static void inserirModelo(Modelo modelo) {
        try {
            Connection conn = conexao.getConexao();
            String sql = "INSERT INTO modelos (id_marca, nomeModelo, potencia, motor, anoLancamento, " +
                    "tipoCombustivel, numeroPortas) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, Integer.parseInt(modelo.getCodigoMarcaModelo()));
            pre.setString(2, modelo.getNomeModelo());
            pre.setString(3, modelo.getPotencia());
            pre.setString(4, modelo.getMotor());
            pre.setString(5, modelo.getAnoLancamento());
            pre.setString(6, modelo.getTipoCombustivel());
            pre.setString(7, modelo.getNumeroPortas());

            pre.execute();
            pre.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Atualizar (UPDATE)
    public static boolean atualizarModelo(int codigoMarcaModelo, Modelo modelo) {
        try {
            Connection conn = conexao.getConexao();
            String updateSql = "UPDATE modelos " +
                    "SET nomeModelo = ?, potencia = ?, motor = ?, anoLancamento = ?, tipoCombustivel = ?, " +
                    "numeroPortas = ? WHERE id_marca = ?";
            PreparedStatement ps = conn.prepareStatement(updateSql);
            ps.setString(1, modelo.getNomeModelo());
            ps.setString(2, modelo.getPotencia());
            ps.setString(3, modelo.getMotor());
            ps.setString(4, modelo.getAnoLancamento());
            ps.setString(5, modelo.getTipoCombustivel());
            ps.setString(6, modelo.getNumeroPortas());
            ps.setInt(7, codigoMarcaModelo); // Não funciona dessa forma modelo.getIdMarca();
            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Excluir (DELETE)
    public static boolean deletarModelo(int idModelo) {
        try {
            Connection conn = conexao.getConexao();
            String deleteSql = "DELETE FROM modelos WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(deleteSql);
            ps.setInt(1, idModelo);

            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
