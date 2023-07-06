package veiculos.service;

public class VeiculoService {
    /*
    private static ConexaoDatabase conexao = new ConexaoDatabase();
    public static List<Clientes> carregarClientes() {
        List<Clientes> out = new ArrayList<>();
        try {
            Connection conn = conexao.getConexao();
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {
                Clientes cli = new Clientes(
                        rs.getInt("id"),
                        rs.getString("documento"),
                        rs.getString("nome"),
                        rs.getString("rg"),
                        rs.getString("email"),
                        rs.getString("telefone"));

                out.add(cli);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

    // Inserir Cliente (INSERT)
    public static void inserirCliente(Clientes cliente) {
        try {
            Connection conn = conexao.getConexao();
            String sql = "INSERT INTO clientes (documento, nome, rg, email, telefone) VALUES ( ?, ?, ?, ?, ?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cliente.getDocumento());
            pre.setString(2, cliente.getNome());
            pre.setString(3, cliente.getRg());
            pre.setString(4, cliente.getEmail());
            pre.setString(5, cliente.getTelefone());

            pre.execute();
            pre.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Atualizar Cliente (UPDATE)
    public static boolean atualizarCliente(int idCliente, Clientes cli) {
        try {
            Connection conn = conexao.getConexao();
            String updateSql = "UPDATE clientes " +
                    "SET documento = ?, nome = ?, rg = ?, email = ?, telefone = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(updateSql);
            ps.setString(1, cli.getDocumento());
            ps.setString(2, cli.getNome());
            ps.setString(3, cli.getRg());
            ps.setString(4, cli.getEmail());
            ps.setString(5, cli.getTelefone());
            ps.setInt(6, idCliente); // Não funciona dessa forma cli.getId();

            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Excluir Cliente (DELETE)
    public static boolean deletarCliente(int idCliente) {
        try {
            Connection conn = conexao.getConexao();
            String deleteSql = "DELETE FROM clientes WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(deleteSql);
            ps.setInt(1, idCliente);

            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    //    // Validar o documento unico
    public static boolean buscarClienteByDocumento(String documento) {
        try {
            Connection conn = conexao.getConexao();
            String selectSql = "SELECT id FROM clientes WHERE documento = '" + documento + "'"; // precisa colocar entre aspas simples
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(selectSql);
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
     */
}
