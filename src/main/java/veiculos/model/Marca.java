package veiculos.model;
public class Marca {
    private int idMarca; // NOT NULL
    private String cnpj; // NOT NULL, UNIQUE
    private String razaoSocial; // NOT NULL, UNIQUE
    private String cep; // NOT NULL
    private String rua; // NOT NULL
    private String numero; // NULL
    private String bairro; // NOT NULL
    private String cidade; // NOT NULL
    private String uf; // NOT NULL
    private String pais; // NOT NULL
    private String telefone; // NOT NULL
    private String email; // NULL
    private String site; // NULL -> site oficial da marca

    public Marca() {
    }

    public Marca(int idMarca, String cnpj, String razaoSocial, String cep, String rua, String numero,
                 String bairro, String cidade, String uf, String pais, String telefone, String email,
                 String site) {
        this.idMarca = idMarca;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
