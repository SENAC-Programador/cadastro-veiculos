package veiculos.model;

public class Marcas {
    private int idMarca;

    //private int codigoVeiculo;
    private String nomeMarca;
    private String paisOrigem;
    private String anoFundacaoMarca; // o ano de fundação da marca do veículo
    private String endereco;
    private String telefone;
    private String email;
    private String site; // site oficial da marca

    public Marcas() {

    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public String getAnoFundacaoMarca() {
        return anoFundacaoMarca;
    }

    public void setAnoFundacaoMarca(String anoFundacaoMarca) {
        this.anoFundacaoMarca = anoFundacaoMarca;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
