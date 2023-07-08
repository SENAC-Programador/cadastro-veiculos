package veiculos.model;

public class Modelos {
    private int idModelo; // NOT NULL
    private String codigoMarcaModelo; // NOT NULL
    private String nomeModelo; // NOT NULL, ex: Parati ou Gol ou Golf
    private String potencia; // NOT NULL, ex: 1.8
    private String motor; // NOT NULL, 16V
    private String anoLancamento; // NOT NULL
    private String tipoCombustivel; // NOT NULL -> ex: gasolina, diesel, elétrico, etc.
    private String numeroPortas; // NOT NULL

    public Modelos() {
    }

    public Modelos(int idModelo, String codigoMarcaModelo, String nomeModelo, String potencia, String motor,
                   String anoLancamento, String tipoCombustivel, String numeroPortas) {
        this.idModelo = idModelo;
        this.codigoMarcaModelo = codigoMarcaModelo;
        this.nomeModelo = nomeModelo;
        this.potencia = potencia;
        this.motor = motor;
        this.anoLancamento = anoLancamento;
        this.tipoCombustivel = tipoCombustivel;
        this.numeroPortas = numeroPortas;
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

    public void setCodigoMarcaModelo(String codigoMarca) {
        this.codigoMarcaModelo = codigoMarcaModelo;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }
    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
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

