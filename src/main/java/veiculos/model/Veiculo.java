package veiculos.model;

public class Veiculo {
    private int idVeiculo; // NOT NULL
    private String dataCadastroVeiculo; // NOT NULL
    private String chassi; // NOT NULL, UNIQUE -> pode variar de fabricante para fabricante, ex: 1HGCM82633A123456
    private String placa; // NOT NULL, UNIQUE -> ex: ABC-1234, podem ter formatos diferentes em diferentes países ou regiões
    private String corVeiculo; // NULL
    private String quilometragem; // NULL -> quilometragem atual do veículo, ex: 50.000 km
    private String codigoMarca; // NOT NULL, FK
    private String codigoModelo; // NOT NULL, FK

    public Veiculo() {
    }

    public Veiculo(int idVeiculo, String dataCadastroVeiculo, String chassi, String placa,
                   String corVeiculo, String quilometragem, String codigoMarca, String codigoModelo) {
        this.idVeiculo = idVeiculo;
        this.dataCadastroVeiculo = dataCadastroVeiculo;
        this.chassi = chassi;
        this.placa = placa;
        this.corVeiculo = corVeiculo;
        this.quilometragem = quilometragem;
        this.codigoMarca = codigoMarca;
        this.codigoModelo = codigoModelo;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getDataCadastroVeiculo() {
        return dataCadastroVeiculo;
    }

    public void setDataCadastroVeiculo(String dataCadastroVeiculo) {
        this.dataCadastroVeiculo = dataCadastroVeiculo;
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

    public String getCodigoMarca() {
        return codigoMarca;
    }

    public void setCodigoMarca(String codigoMarca) {
        this.codigoMarca = codigoMarca;
    }

    public String getCodigoModelo() {
        return codigoModelo;
    }

    public void setCodigoModelo(String codigoModelo) {
        this.codigoModelo = codigoModelo;
    }
}
