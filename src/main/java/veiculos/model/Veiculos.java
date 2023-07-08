package veiculos.model;

import java.util.Date;

public class Veiculos {
    private int idVeiculo;
    // private Date dataCadastroVeiculo;
    private String chassi; // pode variar de fabricante para fabricante, ex: 1HGCM82633A123456
    private String placa; // ex: ABC-1234, podem ter formatos diferentes em diferentes países ou regiões
    private String ano;
    private String cor;
    private String quilometragem; // quilometragem atual do veículo, ex: 50.000 km

    public Veiculos() {

    }
    // Precisa desse construtor para o VeiculoService funcionar
    public Veiculos(int idVeiculo, String chassi, String placa, String ano, String cor, String quilometragem) {
        this.idVeiculo = idVeiculo;
        this.chassi = chassi;
        this.placa = placa;
        this.ano = ano;
        this.cor = cor;
        this.quilometragem = quilometragem;
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

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(String quilometragem) {
        this.quilometragem = quilometragem;
    }
}
