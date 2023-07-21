package veiculos.model;
public class Marca {
   // cnpj, razaoSocial, cep, ruaNumero, bairro, cidade, uf, pais, telefone, email, site
    private int idMarca;
    private String cnpj;
    private String razaoSocial;
    private String cep;
    private String ruaNumero;
    private String bairro;
    private String cidade;
    private String uf;
    private String pais;
    private String telefone;
    private String email;
    private String site;
    public Marca() {
    }

    public Marca(int idMarca, String cnpj, String razaoSocial, String cep, String ruaNumero, String bairro,
                 String cidade, String uf, String pais, String telefone, String email, String site) {
        this.idMarca = idMarca;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.cep = cep;
        this.ruaNumero = ruaNumero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.pais = pais;
        this.telefone = telefone;
        this.email = email;
        this.site = site;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRuaNumero() {
        return ruaNumero;
    }

    public void setRuaNumero(String ruaNumero) {
        this.ruaNumero = ruaNumero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
