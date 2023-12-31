package veiculos.model;
public class Veiculo {
    private int idVeiculo;
    private String codigoModelo;
    private String chassi; // ex: 1HGCM82633A123456
    private String placa; // ex: ABC1234
    private String corVeiculo;
    private String quilometragem; //  ex: 50.000 km
    private String nomeModelo;
    private String nomeMarca;
    public Veiculo() {
    }

    public Veiculo(int idVeiculo, String chassi, String placa, String corVeiculo,
                   String quilometragem, String codigoModelo, String nomeModelo, String nomeMarca) {
        this.idVeiculo = idVeiculo;
        this.chassi = chassi;
        this.placa = placa;
        this.corVeiculo = corVeiculo;
        this.quilometragem = quilometragem;
        this.codigoModelo = codigoModelo;
        this.nomeModelo = nomeModelo;
        this.nomeMarca = nomeMarca;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getCodigoModelo() {
        return codigoModelo;
    }

    public void setCodigoModelo(String codigoModelo) {
        this.codigoModelo = codigoModelo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCorVeiculo() {
        return corVeiculo;
    }

    public void setCorVeiculo(String corVeiculo) {
        this.corVeiculo = corVeiculo;
    }

    public String getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(String quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }



}
