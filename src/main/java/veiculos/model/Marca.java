package veiculos.model;
public class Marca {
    private int idMarca; // tabelaMarca/executarSalvarNaMarca/executarExcluirNaMarca - id SERIAL PRIMARY KEY,
    private String codigoModeloNaMarca; // codigoModelo/codigoModeloNaMarca - id_modelo INT NOT NULL,
    private String cnpj; // cnpj/colunaCnpj - VARCHAR(14) NOT NULL UNIQUE,
    private String razaoSocial; // razaoSocial/colunaRazaoSocial - VARCHAR(100) NOT NULL,
    private String cep; // cep/colunaCep -  VARCHAR(8) NOT NULL,
    private String ruaNumero; // ruaNumero/colunaRuaNumero - VARCHAR(100) NOT NULL,
    private String bairro; // bairro/colunaBairro - VARCHAR(100) NOT NULL,
    private String cidade; // cidade/colunaCidade - VARCHAR(100) NOT NULL,
    private String uf; // uf/colunaUf  - VARCHAR(2) NOT NULL,
    private String pais; // pais/colunaPais - VARCHAR(100) NOT NULL,
    private String telefone; // telefone/colunaTelefone - VARCHAR(20) NOT NULL,
    private String email; // email/colunaEmail - VARCHAR(100) NOT NULL,
    private String site; // site/colunaSite - VARCHAR(100) NOT NULL, -> site oficial da marca
    public Marca() {
    }

    public Marca(int idMarca, String codigoModeloNaMarca, String cnpj, String razaoSocial, String cep, String ruaNumero,
                 String bairro, String cidade, String uf, String pais, String telefone, String email, String site) {
        this.idMarca = idMarca;
        this.codigoModeloNaMarca = codigoModeloNaMarca;
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

    public String getCodigoModeloNaMarca() {
        return codigoModeloNaMarca;
    }

    public void setCodigoModeloNaMarca(String codigoModeloNaMarca) {
        this.codigoModeloNaMarca = codigoModeloNaMarca;
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
