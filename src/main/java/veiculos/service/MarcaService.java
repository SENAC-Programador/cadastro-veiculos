package veiculos.service;
import veiculos.db.ConexaoDatabase;
import veiculos.model.Marca;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MarcaService {
 private static ConexaoDatabase conexao = new ConexaoDatabase();
//MARCA: id, id_modelo, cnpj, razaoSocial, cep, ruaNumero, bairro, cidade, uf, pais, telefone, email, site
    public static List<Marca> carregarMarcas() {
        List<Marca> out = new ArrayList<>();
        try {
            Connection conexaoSelect = conexao.getConexao();
            Statement statementSelect = conexaoSelect.createStatement();
            ResultSet resultadoSelect = statementSelect.executeQuery("SELECT * FROM marcas");
            while (resultadoSelect.next()) {
                Marca marca = new Marca(
                        resultadoSelect.getInt("id"),
                        resultadoSelect.getString("id_modelo"),
                        resultadoSelect.getString("cnpj"),
                        resultadoSelect.getString("razaoSocial"),
                        resultadoSelect.getString("cep"),
                        resultadoSelect.getString("ruaNumero"),
                        resultadoSelect.getString("bairro"),
                        resultadoSelect.getString("cidade"),
                        resultadoSelect.getString("uf"),
                        resultadoSelect.getString("pais"),
                        resultadoSelect.getString("telefone"),
                        resultadoSelect.getString("email"),
                        resultadoSelect.getString("site"));

                out.add(marca);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

// Inserir/Adicionar (INSERT)
//MARCA: id, id_modelo, cnpj, razaoSocial, cep, ruaNumero, bairro, cidade, uf, pais, telefone, email, site
    public static void inserirMarca(Marca marca) {
        try {
            Connection conexaoInsert = conexao.getConexao();
            String insertSql = "INSERT INTO marcas (id_modelo, cnpj, razaoSocial, cep, ruaNumero, bairro, cidade, " +
                    "uf, pais, telefone, email, site) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement prepareStatementInsert = conexaoInsert.prepareStatement(insertSql);
            prepareStatementInsert.setInt(1, Integer.parseInt(marca.getCodigoModeloNaMarca()));
            prepareStatementInsert.setString(2, marca.getCnpj());
            prepareStatementInsert.setString(3, marca.getRazaoSocial());
            prepareStatementInsert.setString(4, marca.getCep());
            prepareStatementInsert.setString(5, marca.getRuaNumero());
            prepareStatementInsert.setString(6, marca.getBairro());
            prepareStatementInsert.setString(7, marca.getCidade());
            prepareStatementInsert.setString(8, marca.getUf());
            prepareStatementInsert.setString(9, marca.getPais());
            prepareStatementInsert.setString(10, marca.getTelefone());
            prepareStatementInsert.setString(11, marca.getEmail());
            prepareStatementInsert.setString(12, marca.getSite());

            prepareStatementInsert.execute();
            prepareStatementInsert.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

// Atualizar (UPDATE)
//MARCA: id, id_modelo, cnpj, razaoSocial, cep, ruaNumero, bairro, cidade, uf, pais, telefone, email, site
    public static boolean atualizarMarca(int codigoModelo, Marca marca) {
        try {
            Connection conn = conexao.getConexao();
            String updateSql = "UPDATE marcas " +
                    "SET id_modelo = ?, cnpj = ?, razaoSocial = ?, cep = ?, ruaNumero = ?, bairro = ?, " +
                    "cidade = ?, uf = ?, pais = ?, telefone = ?, email = ?, site = ? WHERE id = ?";
            PreparedStatement prepareStatementUpdate = conn.prepareStatement(updateSql);
            prepareStatementUpdate.setInt(1, Integer.parseInt(marca.getCodigoModeloNaMarca()));
            prepareStatementUpdate.setString(2, marca.getCnpj());
            prepareStatementUpdate.setString(3, marca.getRazaoSocial());
            prepareStatementUpdate.setString(4, marca.getCep());
            prepareStatementUpdate.setString(5, marca.getRuaNumero());
            prepareStatementUpdate.setString(6, marca.getBairro());
            prepareStatementUpdate.setString(7, marca.getCidade());
            prepareStatementUpdate.setString(8, marca.getUf());
            prepareStatementUpdate.setString(9, marca.getPais());
            prepareStatementUpdate.setString(10, marca.getTelefone());
            prepareStatementUpdate.setString(11, marca.getEmail());
            prepareStatementUpdate.setString(12, marca.getSite());
            prepareStatementUpdate.setInt(13, codigoModelo); // Não funciona dessa forma marca.getId();

            return prepareStatementUpdate.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Excluir (DELETE)
    public static boolean deletarMarca(int idMarca) {
        try {
            Connection conexaoDelete = conexao.getConexao();
            String deleteSql = "DELETE FROM marcas WHERE id = ?";
            PreparedStatement prepareStatementDelete = conexaoDelete.prepareStatement(deleteSql);
            prepareStatementDelete.setInt(1, idMarca);

            return prepareStatementDelete.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean buscarMarcaPorCnpj(String cnpj) {
        try {
            Connection conexaoBusca = conexao.getConexao();
            String selectSql = "SELECT COUNT(*) FROM marcas WHERE cnpj = ?";
            PreparedStatement buscaCnpjStatement = conexaoBusca.prepareStatement(selectSql);
            buscaCnpjStatement.setString(1, cnpj);
            ResultSet buscaCnpjResultado = buscaCnpjStatement.executeQuery();
            if (buscaCnpjResultado.next()) {
                int count = buscaCnpjResultado.getInt(1);
                return count > 0; // Retorna true se o CNPJ já estiver cadastrado
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
