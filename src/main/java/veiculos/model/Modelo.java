package veiculos.model;

public class Modelo {
    // id_marca, nome_modelo, motor, potencia, ano_lancamento, tipo_combustivel, numero_portas
    private int idModelo; // colunaCodigoModelo/tabelaModelo/executarSalvarNoModelo/executarExcluirNoModelo - id SERIAL PRIMARY KEY-
    private String codigoMarcaModelo; //  codigoVeiculo/ - id_veiculo INT NOT NULL,
    private String nomeModelo; // nomeModelo/colunaNomeModelo - VARCHAR(100) NOT NULL, ex: Parati ou Gol ou Golf
    private String motor; // motor/colunaMotor - VARCHAR(50) NOT NULL, 16V
    private String potencia; // potencia/colunaPotencia - VARCHAR(50) NOT NULL, ex: 1.8
    private String anoLancamento; // anoLancamento/colunaAnoLancamento -  VARCHAR(4) NOT NULL,
    private String tipoCombustivel; // tipoCombustivel/colunaTipoCombustivel - VARCHAR(50) NOT NULL, -> ex: gasolina, diesel, elétrico, etc.
    private String numeroPortas;

    public Modelo() {

    }

    public Modelo(int idModelo, String nomeModelo, String motor, String potencia,
                  String anoLancamento, String tipoCombustivel, String numeroPortas, String codigoMarcaModelo) {
        this.idModelo = idModelo;
        this.nomeModelo = nomeModelo;
        this.motor = motor;
        this.potencia = potencia;
        this.anoLancamento = anoLancamento;
        this.tipoCombustivel = tipoCombustivel;
        this.numeroPortas = numeroPortas;
        this.codigoMarcaModelo = codigoMarcaModelo;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getCodigoMarcaModelo() {
        return codigoMarcaModelo;
    }

    public void setCodigoMarcaModelo(String codigoMarcaModelo) {
        this.codigoMarcaModelo = codigoMarcaModelo;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public String getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(String numeroPortas) {
        this.numeroPortas = numeroPortas;
    }


}

