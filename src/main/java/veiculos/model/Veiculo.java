package veiculos.model;

import javafx.scene.control.cell.PropertyValueFactory;

public class Veiculo {
    private int idVeiculo; // idVeiculo/ - SERIAL PRIMARY KEY - executarSalvarNoVeiculo/executarExcluirNoVeiculo/tabelaVeiculo
    private String chassi; // chassi/colunaChassi - VARCHAR(17) NOT NULL UNIQUE, -> pode variar de fabricante para fabricante, ex: 1HGCM82633A123456
    private String placa; // placa/colunaPlaca - VARCHAR(7) NOT NULL UNIQUE, -> ex: ABC-1234, podem ter formatos diferentes em diferentes países ou regiões
    private String corVeiculo; // corVeiculo/colunaCorVeiculo - VARCHAR(50) NOT NULL,
    private String quilometragem; // quilometragem/colunaQuilometragem - VARCHAR(20) NOT NULL -> quilometragem atual do veículo, ex: 50.000 km

    private String nomeModelo;
    private String nomeMarca;
    public Veiculo() {
    }

    public Veiculo(int idVeiculo, String chassi, String placa, String corVeiculo, String quilometragem,
                   String nomeModelo, String nomeMarca) {
        this.idVeiculo = idVeiculo;
        this.chassi = chassi;
        this.placa = placa;
        this.corVeiculo = corVeiculo;
        this.quilometragem = quilometragem;
        this.nomeModelo = nomeModelo;
        this.nomeMarca = nomeMarca;
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

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
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
}
