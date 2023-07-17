package veiculos.service;

import veiculos.db.ConexaoDatabase;
import veiculos.model.Marca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MarcaService {
 private static ConexaoDatabase conexao = new ConexaoDatabase();
    public static List<Marca> carregarMarcas() {
        List<Marca> out = new ArrayList<>();
        try {
            Connection conn = conexao.getConexao();
            Statement sta = conn.createStatement();
            ResultSet resultado = sta.executeQuery("SELECT * FROM marcas");
            while (resultado.next()) {
                Marca marca = new Marca(
                        resultado.getInt("id"),
                        resultado.getString("cnpj"),
                        resultado.getString("razaoSocial"),
                        resultado.getString("cep"),
                        resultado.getString("rua"),
                        resultado.getString("numero"),
                        resultado.getString("bairro"),
                        resultado.getString("cidade"),
                        resultado.getString("uf"),
                        resultado.getString("pais"),
                        resultado.getString("telefone"),
                        resultado.getString("email"),
                        resultado.getString("site"));

                out.add(marca);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

    // Inserir/Adicionar (INSERT)
    public static void inserirMarca(Marca marca) {
        try {
            Connection conn = conexao.getConexao();
            String sql = "INSERT INTO marcas (cnpj, razaoSocial, cep, ruaNumero, bairro, cidade, uf, pais, ) " +
                    "telefone, email, site VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, marca.getCnpj());
            pre.setString(2, marca.getRazaoSocial());
            pre.setString(3, marca.getCep());
            pre.setString(4, marca.getRuaNumero());
            pre.setString(5, marca.getBairro());
            pre.setString(6, marca.getCidade());
            pre.setString(7, marca.getUf());
            pre.setString(8, marca.getPais());
            pre.setString(9, marca.getTelefone());
            pre.setString(10, marca.getEmail());
            pre.setString(11, marca.getSite());

            pre.execute();
            pre.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Atualizar (UPDATE)
    public static boolean atualizarMarca(int codigoModelo, Marca marca) {
        try {
            Connection conn = conexao.getConexao();
            String updateSql = "UPDATE marcas " +
                    "SET cnpj = ?, razaoSocial = ?, cep = ?, rua = ?, numero = ?, bairro = ?, cidade = ?, uf = ?, " +
                    "pais = ?, telefone = ?, email = ?, site = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(updateSql);
            ps.setString(1, marca.getCnpj());
            ps.setString(2, marca.getRazaoSocial());
            ps.setString(3, marca.getCep());
            ps.setString(4, marca.getRua());
            ps.setString(5, marca.getNumero());
            ps.setString(6, marca.getBairro());
            ps.setString(7, marca.getCidade());
            ps.setString(8, marca.getUf());
            ps.setString(9, marca.getPais());
            ps.setString(10, marca.getTelefone());
            ps.setString(11, marca.getEmail());
            ps.setString(12, marca.getSite());
            //ps.setInt(13, idMarca); // Não funciona dessa forma marca.getId();

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

}
