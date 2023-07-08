package veiculos.service;

import veiculos.db.ConexaoDatabase;

public class MarcaService {

 private static ConexaoDatabase conexao = new ConexaoDatabase();
 /*
    public static List<Marcas> carregarMarcas() {
        List<Marcas> out = new ArrayList<>();
        try {
            Connection conn = conexao.getConexao();
            Statement sta = conn.createStatement();
            ResultSet resultado = sta.executeQuery("SELECT * FROM marcas");
            while (resultado.next()) {
                Marcas marca = new Marcas(
                        resultado.getInt("id"),
                        //resultado.getString("id_modelo"),
                        resultado.getString("cep"),
                        resultado.getString("rua"),
                        resultado.getString("numero"),
                        resultado.getString("bairro"),
                        resultado.getString("cidade"),
                        resultado.getString("estado"));
                out.add(marca);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

    // Inserir/Adicionar (INSERT)
    public static void inserirMarca(Marcas marca) {
        try {
            Connection conn = conexao.getConexao();
            String sql = "INSERT INTO marcas (id_modelo, cep, rua, numero, bairro, cidade, estado) " +
                    "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, Integer.parseInt(endereco.getCodigoCliente()));
            pre.setString(2, marca.getCep());
            pre.setString(3, marca.getRua());
            pre.setString(4, marca.getNumero());
            pre.setString(5, marca.getBairro());
            pre.setString(6, marca.getCidade());
            pre.setString(7, marca.getUf());

            pre.execute();
            pre.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Atualizar (UPDATE)
    public static boolean atualizarMarca(int codigoModelo, Marcas marca) {
        try {
            Connection conn = conexao.getConexao();
            String updateSql = "UPDATE marcas " +
                    "SET cep = ?, rua = ?, numero = ?, bairro = ?, cidade = ?, estado = ? WHERE id_modelo = ?";
            PreparedStatement ps = conn.prepareStatement(updateSql);
            ps.setString(1, marca.getCep());
            ps.setString(2, marca.getRua());
            ps.setString(3, marca.getNumero());
            ps.setString(4, marca.getBairro());
            ps.setString(5, marca.getCidade());
            ps.setString(6, marca.getEstado());
            ps.setInt(7, codigoModelo); // Não funciona dessa forma marca.getId();

            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Excluir (DELETE)
    public static boolean deletarMarca(int idMarca) {
        try {
            Connection conn = conexao.getConexao();
            String deleteSql = "DELETE FROM marcas WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(deleteSql);
            ps.setInt(1, idMarca);

            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
     */
}
