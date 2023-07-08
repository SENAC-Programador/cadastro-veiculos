package veiculos.service;

import veiculos.db.ConexaoDatabase;

public class ModeloService {

     private static ConexaoDatabase conexao = new ConexaoDatabase();
  /*
    public static List<Modelos> carregarModelos() {
        List<Modelos> out = new ArrayList<>();
        try {
            Connection conn = conexao.getConexao();
            Statement sta = conn.createStatement();
            ResultSet resultado = sta.executeQuery("SELECT * FROM modelos");
            while (resultado.next()) {
                Modelos modelo = new Modelos(
                        resultado.getInt("id"),
                        resultado.getString("id_marca"),
                        resultado.getString("cep"),
                        resultado.getString("rua"),
                        resultado.getString("numero"),
                        resultado.getString("bairro"),
                        resultado.getString("cidade"),
                        resultado.getString("estado"));
                out.add(modelo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

    // Inserir/Adicionar (INSERT)
    public static void inserirModelo(Modelos modelo) {
        try {
            Connection conn = conexao.getConexao();
            String sql = "INSERT INTO modelos (id_marca, cep, rua, numero, bairro, cidade, estado) " +
                    "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, Integer.parseInt(modelo.getCodigoMarca()));
            pre.setString(2, modelo.getCep());
            pre.setString(3, modelo.getRua());
            pre.setString(4, modelo.getNumero());
            pre.setString(5, modelo.getBairro());
            pre.setString(6, modelo.getCidade());
            pre.setString(7, modelo.getEstado());

            pre.execute();
            pre.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Atualizar (UPDATE)
    public static boolean atualizarModelo(int codigoMarca, Modelos modelo) {
        try {
            Connection conn = conexao.getConexao();
            String updateSql = "UPDATE modelos " +
                    "SET cep = ?, rua = ?, numero = ?, bairro = ?, cidade = ?, estado = ? WHERE id_marca = ?";
            PreparedStatement ps = conn.prepareStatement(updateSql);
            ps.setString(1, modelo.getCep());
            ps.setString(2, modelo.getRua());
            ps.setString(3, modelo.getNumero());
            ps.setString(4, modelo.getBairro());
            ps.setString(5, modelo.getCidade());
            ps.setString(6, modelo.getEstado());
            ps.setInt(7, codigoMarca); // Não funciona dessa forma modelo.getIdMarca();

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
     */
}
