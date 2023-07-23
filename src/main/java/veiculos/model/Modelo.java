package veiculos.model;
public class Modelo {
    private int idModelo;
    private String codigoMarcaModelo;
    private String nomeModelo;
    private String motor;
    private String potencia;
    private String anoLancamento;
    private String tipoCombustivel;
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

