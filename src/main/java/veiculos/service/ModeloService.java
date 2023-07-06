package veiculos.service;

public class ModeloService {
    /*
     private static ConexaoDatabase conexao = new ConexaoDatabase();
    public static List<Enderecos> carregarEnderecos() {
        List<Enderecos> out = new ArrayList<>();
        try {
            Connection conn = conexao.getConexao();
            Statement sta = conn.createStatement();
            ResultSet resultado = sta.executeQuery("SELECT * FROM enderecos");
            while (resultado.next()) {
                Enderecos enderecos = new Enderecos(
                        resultado.getInt("id"),
                        resultado.getString("id_cliente"),
                        resultado.getString("cep"),
                        resultado.getString("rua"),
                        resultado.getString("numero"),
                        resultado.getString("bairro"),
                        resultado.getString("cidade"),
                        resultado.getString("estado"));
                out.add(enderecos);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

    // Inserir/Adicionar Endereço (INSERT)
    public static void inserirEndereco(Enderecos endereco) {
        try {
            Connection conn = conexao.getConexao();
            String sql = "INSERT INTO enderecos (id_cliente, cep, rua, numero, bairro, cidade, estado) " +
                    "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, Integer.parseInt(endereco.getCodigoCliente()));
            pre.setString(2, endereco.getCep());
            pre.setString(3, endereco.getRua());
            pre.setString(4, endereco.getNumero());
            pre.setString(5, endereco.getBairro());
            pre.setString(6, endereco.getCidade());
            pre.setString(7, endereco.getEstado());

            pre.execute();
            pre.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Atualizar Endereço (UPDATE)
    public static boolean atualizarEndereco(int codigoCliente, Enderecos endereco) {
        try {
            Connection conn = conexao.getConexao();
            String updateSql = "UPDATE enderecos " +
                    "SET cep = ?, rua = ?, numero = ?, bairro = ?, cidade = ?, estado = ? WHERE id_cliente = ?";
            PreparedStatement ps = conn.prepareStatement(updateSql);
            ps.setString(1, endereco.getCep());
            ps.setString(2, endereco.getRua());
            ps.setString(3, endereco.getNumero());
            ps.setString(4, endereco.getBairro());
            ps.setString(5, endereco.getCidade());
            ps.setString(6, endereco.getEstado());
            ps.setInt(7, codigoCliente); // Não funciona dessa forma endereco.getId();

            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Excluir Endereço (DELETE)
    public static boolean deletarEndereco(int idEndereco) {
        try {
            Connection conn = conexao.getConexao();
            String deleteSql = "DELETE FROM enderecos WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(deleteSql);
            ps.setInt(1, idEndereco);

            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
     */
}
