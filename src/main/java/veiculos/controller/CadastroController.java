package veiculos.controller;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import veiculos.model.Marca;
import veiculos.model.Modelo;
import veiculos.model.Veiculo;
import veiculos.service.MarcaService;
import veiculos.service.ModeloService;
import veiculos.service.VeiculoService;

import java.util.List;
import java.util.Optional;
@Component
@FxmlView("/main.fxml") // para lincar com o arquivo "main.fxml"
public class CadastroController {
    @FXML
    private TextField chassi;
    @FXML
    private TextField placa;
    @FXML
    private TextField corVeiculo;
    @FXML
    private TextField quilometragem;
    @FXML
    private TableView<Veiculo> tabelaVeiculo;
    @FXML
    private TableColumn<Veiculo, Integer> colunaCodigoVeiculo;
    @FXML
    private TableColumn<Veiculo, String> colunaChassi;
    @FXML
    private TableColumn<Veiculo, String> colunaPlaca;
    @FXML
    private TableColumn<Veiculo, String> colunaCorVeiculo;
    @FXML
    private TableColumn<Veiculo, String> colunaQuilometragem;

    // MODELO
    @FXML
    private TextField codigoVeiculo; //  codigoVeiculo/ - id_veiculo INT NOT NULL,
    @FXML
    private TextField nomeModelo; // nomeModelo/colunaNomeModelo - VARCHAR(100) NOT NULL, ex: Parati ou Gol ou Golf
    @FXML
    private TextField motor; // motor/colunaMotor - VARCHAR(50) NOT NULL, 16V
    @FXML
    private TextField potencia; // potencia/colunaPotencia - VARCHAR(50) NOT NULL, ex: 1.8
    @FXML
    private TextField anoLancamento; // anoLancamento/colunaAnoLancamento -  VARCHAR(4) NOT NULL,
    @FXML
    private TextField tipoCombustivel; // tipoCombustivel/colunaTipoCombustivel - VARCHAR(50) NOT NULL, -> ex: gasolina, diesel, elétrico, etc.
    @FXML
    private TextField numeroPortas; // numeroPortas/colunaNumeroPortas -  VARCHAR(2) NOT NULL,
    @FXML
    private TableView<Modelo> tabelaModelo;
    @FXML
    private TableColumn<Modelo, Integer> colunaCodigoModelo; //  codigoVeiculo/ - id_veiculo INT NOT NULL,
    @FXML
    private TableColumn<Modelo, String> colunaNomeModelo; // nomeModelo/colunaNomeModelo - VARCHAR(100) NOT NULL, ex: Parati ou Gol ou Golf
    @FXML
    private TableColumn<Modelo, String> colunaMotor; // motor/colunaMotor - VARCHAR(50) NOT NULL, 16V
    @FXML
    private TableColumn<Modelo, String> colunaPotencia; // potencia/colunaPotencia - VARCHAR(50) NOT NULL, ex: 1.8
    @FXML
    private TableColumn<Modelo, String> colunaAnoLancamento; // anoLancamento/colunaAnoLancamento -  VARCHAR(4) NOT NULL,
    @FXML
    private TableColumn<Modelo, String> colunaTipoCombustivel; // tipoCombustivel/colunaTipoCombustivel - VARCHAR(50) NOT NULL, -> ex: gasolina, diesel, elétrico, etc.
    @FXML
    private TableColumn<Modelo, String> colunaNumeroPortas; // numeroPortas/colunaNumeroPortas -  VARCHAR(2) NOT NULL,

    // MARCA
    @FXML
    private TextField codigoModeloNaMarca; // codigoModelo/colunaCodigoModelo - id_modelo INT NOT NULL,
    @FXML
    private TextField cnpj; // cnpj/colunaCnpj - VARCHAR(14) NOT NULL UNIQUE,
    @FXML
    private TextField razaoSocial; // razaoSocial/colunaRazaoSocial - VARCHAR(100) NOT NULL,
    @FXML
    private TextField cep; // cep/colunaCep -  VARCHAR(8) NOT NULL,
    @FXML
    private TextField ruaNumero; // ruaNumero/colunaRuaNumero - VARCHAR(100) NOT NULL,
    @FXML
    private TextField bairro; // bairro/colunaBairro - VARCHAR(100) NOT NULL,
    @FXML
    private TextField cidade; // cidade/colunaCidade - VARCHAR(100) NOT NULL,
    @FXML
    private TextField uf; // uf/colunaUf  - VARCHAR(2) NOT NULL,
    @FXML
    private TextField pais; // pais/colunaPais - VARCHAR(100) NOT NULL,
    @FXML
    private TextField telefone; // telefone/colunaTelefone - VARCHAR(20) NOT NULL,
    @FXML
    private TextField email; // email/colunaEmail - VARCHAR(100) NOT NULL,
    @FXML
    private TextField site; // site/colunaSite - VARCHAR(100) NOT NULL, -> site oficial da marca
    @FXML
    private TableView<Marca> tabelaMarca;
    @FXML
    private TableColumn<Marca, String> colunaCnpj; // cnpj/colunaCnpj - VARCHAR(14) NOT NULL UNIQUE,
    @FXML
    private TableColumn<Marca, String> colunaRazaoSocial; // razaoSocial/colunaRazaoSocial - VARCHAR(100) NOT NULL,
    @FXML
    private TableColumn<Marca, String> colunaCep; // cep/colunaCep -  VARCHAR(8) NOT NULL,
    @FXML
    private TableColumn<Marca, String> colunaRuaNumero; // ruaNumero/colunaRuaNumero - VARCHAR(100) NOT NULL,
    @FXML
    private TableColumn<Marca, String> colunaBairro; // bairro/colunaBairro - VARCHAR(100) NOT NULL,
    @FXML
    private TableColumn<Marca, String> colunaCidade; // cidade/colunaCidade - VARCHAR(100) NOT NULL,
    @FXML
    private TableColumn<Marca, String> colunaUf; // uf/colunaUf  - VARCHAR(2) NOT NULL,
    @FXML
    private TableColumn<Marca, String> colunaPais; // pais/colunaPais - VARCHAR(100) NOT NULL,
    @FXML
    private TableColumn<Marca, String> colunaTelefone; // telefone/colunaTelefone - VARCHAR(20) NOT NULL,
    @FXML
    private TableColumn<Marca, String> colunaEmail; // email/colunaEmail - VARCHAR(100) NOT NULL,
    @FXML
    private TableColumn<Marca, String> colunaSite; // site/colunaSite - VARCHAR(100) NOT NULL, -> site oficial da marca

    private int index = -1;

    // Método para dizer para o JavaFX ... pesquisar ...
    @FXML
    public void initialize() {
// VEÍCULO:
        colunaCodigoVeiculo.setCellValueFactory(new PropertyValueFactory<>("idVeiculo")); // é o nome da variavel, não do banco de dados
        colunaChassi.setCellValueFactory(new PropertyValueFactory<>("chassi"));
        colunaPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        colunaCorVeiculo.setCellValueFactory(new PropertyValueFactory<>("corVeiculo"));
        colunaQuilometragem.setCellValueFactory(new PropertyValueFactory<>("quilometragem"));

// MODELO:
        colunaCodigoModelo.setCellValueFactory(new PropertyValueFactory<>("idModelo"));
        colunaNomeModelo.setCellValueFactory(new PropertyValueFactory<>("nomeModelo"));
        colunaMotor.setCellValueFactory(new PropertyValueFactory<>("motor"));
        colunaPotencia.setCellValueFactory(new PropertyValueFactory<>("potencia"));
        colunaAnoLancamento.setCellValueFactory(new PropertyValueFactory<>("anoLancamento"));
        colunaTipoCombustivel.setCellValueFactory(new PropertyValueFactory<>("tipoCombustivel"));
        colunaNumeroPortas.setCellValueFactory(new PropertyValueFactory<>("numeroPortas"));

// MARCA:
        colunaCnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
        colunaRazaoSocial.setCellValueFactory(new PropertyValueFactory<>("razaoSocial"));
        colunaCep.setCellValueFactory(new PropertyValueFactory<>("cep"));
        colunaRuaNumero.setCellValueFactory(new PropertyValueFactory<>("ruaNumero"));
        colunaBairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
        colunaCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        colunaUf.setCellValueFactory(new PropertyValueFactory<>("uf"));
        colunaPais.setCellValueFactory(new PropertyValueFactory<>("pais"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colunaSite.setCellValueFactory(new PropertyValueFactory<>("site"));

        // Trazer o método das classes Services
        this.carregarlistaVeiculos();
        this.carregarlistaMarcas();
        this.carregarlistaModelos();

// VEÍCULO:
        tabelaVeiculo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent evt) {
                if (evt.getClickCount() == 2) { // qtde de cliques, dois cliques no evento
                    Veiculo veiculo = tabelaVeiculo.getSelectionModel().getSelectedItem(); // pegar o item que foi selecionado e sua posição
                    chassi.setText(veiculo.getChassi());
                    chassi.setDisable(true); // desabilitar o campo Chassi na alteração
                    placa.setText(veiculo.getPlaca());
                    placa.setDisable(true); // desabilitar o campo Placa na alteração
                    corVeiculo.setText(veiculo.getCorVeiculo());
                    quilometragem.setText(veiculo.getQuilometragem());

                    index = veiculo.getIdVeiculo();

                    // Alerta para alterar
                    Alert alertAlterar = new Alert(Alert.AlertType.CONFIRMATION);
                    alertAlterar.setTitle("Confirmação de alterar");
                    alertAlterar.setHeaderText("Confirmar alteração do veículo?");
                    Optional<ButtonType> retornoAlerta = alertAlterar.showAndWait();
                    if (retornoAlerta.get() != null && retornoAlerta.get() == ButtonType.CANCEL) {
                        limparCamposDoVeiculo();
                    }
                }
            }
        });

// MODELO:
        tabelaModelo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    Modelo modelo = tabelaModelo.getSelectionModel().getSelectedItem();
                    codigoVeiculo.setText(String.valueOf(modelo.getCodigoVeiculo()));
                    codigoVeiculo.setDisable(true); // Desabilitar o campo Código do Veículo para edição ou exclusão
                    nomeModelo.setText(modelo.getNomeModelo());
                    motor.setText(modelo.getMotor());
                    potencia.setText(modelo.getPotencia());
                    anoLancamento.setText(modelo.getAnoLancamento());
                    anoLancamento.setDisable(true); // Desabilitar o campo Ano do Lançamento para edição ou exclusão
                    tipoCombustivel.setText(modelo.getTipoCombustivel());
                    numeroPortas.setText(modelo.getNumeroPortas());
                    numeroPortas.setDisable(true); // Desabilitar

                    index = modelo.getIdModelo();

                    // Alerta para alterar
                    Alert alertAlterar = new Alert(Alert.AlertType.CONFIRMATION);
                    alertAlterar.setTitle("Confirmação de alterar");
                    alertAlterar.setHeaderText("Confirmar alteração do modelo?");
                    Optional<ButtonType> retornoAlerta = alertAlterar.showAndWait();
                    if (retornoAlerta.get() != null && retornoAlerta.get() == ButtonType.CANCEL) {
                        limparCamposModelo();
                    }
                }
            }
        });

// MARCA:
        tabelaMarca.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    Marca marca = tabelaMarca.getSelectionModel().getSelectedItem();
                    codigoModeloNaMarca.setText(String.valueOf(marca.getCodigoModeloNaMarca()));
                    codigoModeloNaMarca.setDisable(true); // Desabilitar
                    cnpj.setText(marca.getCnpj());
                    cnpj.setDisable(true); // Desabilitar
                    razaoSocial.setText(marca.getRazaoSocial());
                    cep.setText(marca.getCep());
                    ruaNumero.setText(marca.getRuaNumero());
                    bairro.setText(marca.getBairro());
                    cidade.setText(marca.getCidade());
                    uf.setText(marca.getUf());
                    pais.setText(marca.getPais());
                    telefone.setText(marca.getTelefone());
                    email.setText(marca.getEmail());
                    site.setText(marca.getSite());

                    index = marca.getIdMarca();

                    // Alerta para alterar
                    Alert alertAlterar = new Alert(Alert.AlertType.CONFIRMATION);
                    alertAlterar.setTitle("Confirmação de alterar");
                    alertAlterar.setHeaderText("Confirmar alteração da marca?");
                    Optional<ButtonType> retornoAlerta = alertAlterar.showAndWait();
                    if (retornoAlerta.get() != null && retornoAlerta.get() == ButtonType.CANCEL) {
                        limparCamposMarca();
                    }
                }
            }
        });
    }
    // Método para fazer funcionar o botão "Salvar" do JavaFX
// VEÍCULO:
    public void executarSalvarNoVeiculo() {
        Alert alertInclusao = new Alert(Alert.AlertType.CONFIRMATION);
        alertInclusao.setTitle("Confirmação de inclusão");
        alertInclusao.setHeaderText("Confirmar inclusão do veículo?");
        Optional<ButtonType> option = alertInclusao.showAndWait();

        if (option.get() != null && option.get() == ButtonType.OK) {
            Veiculo veiculo = new Veiculo();
            veiculo.setChassi(chassi.getText()); // para mostrar as informações que estão na linha que pertecem a coluna documento da tabela
            veiculo.setPlaca(placa.getText());
            veiculo.setCorVeiculo(corVeiculo.getText());
            veiculo.setQuilometragem(quilometragem.getText());

            try {
                if (chassi.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo obrigatório", "É obrigatório informar o chassi!", "");
                } else if (placa.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo obrigatório", "É obrigatório informar a placa!", "");
                } else if (!veiculo.getPlaca().matches("[a-zA-Z0-9]{7}")) { // Aceita letras e números com 7 dígitos
                    alertaDeErroOuInvalido("Erro","Placa inválida.",
                            "Confira se colocou letars e números, precisa ter exatamente 7 dígitos");
                } else if (corVeiculo.getText().isEmpty()) { // [a-zA-Z0-9]{0,7}
                    alertaDeErroOuInvalido
                            ("Campo obrigatório", "É obrigatório informar a cor do veículo!", "");
                } else if (quilometragem.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo obrigatório","É obrigatório informar a quilometragem!", "");
                } else if (!veiculo.getQuilometragem().matches("[0-9]{0,10}")) { // expressão regular
                    alertaDeErroOuInvalido
                            ("Erro", "Quilometragem inválida, somente números.",
                                    "Precisa ter no máximo 10 dígitos");
                } else if (index < 0) {
                    if (VeiculoService.buscarVeiculoPorChassi(veiculo.getChassi())) {
                        alertaRegistroExistenete("Chassi", chassi.getText());
                    } else if (VeiculoService.buscarVeiculoPorPlaca(veiculo.getPlaca())) {
                        alertaRegistroExistenete("Placa", placa.getText());
                    } else {
                        VeiculoService.inserirVeiculo(veiculo); // INSERT
                        this.limparCamposDoVeiculo();
                    }

                } else {
                    VeiculoService.atualizarVeiculo(index, veiculo); // UPDATE
                    index = -1;
                    this.limparCamposDoVeiculo();
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            this.carregarlistaVeiculos();

        }
    }
    public void executarExcluirNoVeiculo() {
        Alert alertExclusao = new Alert(Alert.AlertType.CONFIRMATION);
        alertExclusao.setTitle("Confirmação de Exclusão");
        alertExclusao.setHeaderText("Confirmar exclusão do veículo?");
        Optional<ButtonType> retornoAlerta = alertExclusao.showAndWait();

        if (retornoAlerta.get() != null && retornoAlerta.get() == ButtonType.CANCEL) {
            limparCamposDoVeiculo();
        } else if (index > -1) {
            VeiculoService.deletarVeiculo(index);
            this.carregarlistaVeiculos();
            index = -1;
            this.limparCamposDoVeiculo();
        }
    }

    public void carregarlistaVeiculos() {
        // Trazer o método da classe VeiculoService
        tabelaVeiculo.getItems().remove(0, tabelaVeiculo.getItems().size());
        List<Veiculo> veiculoList = VeiculoService.carregarVeiculo();
        tabelaVeiculo.getItems().addAll(veiculoList);
        this.limparCamposDoVeiculo();
    }
    public void limparCamposDoVeiculo() {
        chassi.setText(""); // zera o campo
        placa.setText("");
        corVeiculo.setText("");
        quilometragem.setText("");
        chassi.setDisable(false); // habilitar documento
        placa.setDisable(false); // habilitar nome
    }

    // MODELO: -------------------
    public void executarSalvarNoModelo() {
        Alert alertInclusao = new Alert(Alert.AlertType.CONFIRMATION);
        alertInclusao.setTitle("Confirmação de Inclusão");
        alertInclusao.setHeaderText("Confirmar inclusão do modelo?");
        Optional<ButtonType> retornoAlerta = alertInclusao.showAndWait();

        try {
            if (retornoAlerta.get() != null && retornoAlerta.get() == ButtonType.OK) {
                Modelo modelo = new Modelo();
                // para mostrar as informações que estão na linha que pertencem às colunas da tabela
                modelo.setCodigoVeiculo(String.valueOf(codigoVeiculo.getText())); // coluna código do modelo
                modelo.setNomeModelo(nomeModelo.getText());
                modelo.setMotor(motor.getText());
                modelo.setPotencia(potencia.getText());
                modelo.setAnoLancamento(anoLancamento.getText());
                modelo.setTipoCombustivel(tipoCombustivel.getText());
                modelo.setNumeroPortas(numeroPortas.getText());

                Alert alertObri = new Alert(Alert.AlertType.ERROR);
                alertObri.setTitle("Campo obrigatório");
                Alert alertInvalido = new Alert(Alert.AlertType.ERROR);
                alertInvalido.setTitle("Erro");

                if (!modelo.getCodigoVeiculo().matches("[0-9]*")) { // expressão regular: [0-9]*, ela só permite números de 0 a 9
                    alertaDeErroOuInvalido
                            ("Erro", "Código do veículo inválido, somente números","");
                } else if (nomeModelo.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo obrigatório", "É obrigatório informar o nome do modelo!", "");
                } else if (motor.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo obrigatório", "É obrigatório informar o motor!", "");
                } else if (potencia.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo obrigatório", "É obrigatório informar a potência", "");
                } else if (anoLancamento.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo obrigatório", "É obrigatório informar o ano do lançamento!",
                                    "");
                } else if (!modelo.getAnoLancamento().matches("\\d{4}")) {
                    alertaDeErroOuInvalido("Erro", "Ano de Lançamento inválido",
                            "Confira se colocou apenas números ou somente o ano (4 dígitos)");
                } else if (tipoCombustivel.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo obrigatório", "É obrigatório informar o tipo do combustivel!", "");
                } else if (numeroPortas.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo obrigatório", "É obrigatório informar o número de portas!", "");
                } else if (!modelo.getNumeroPortas().matches("[0-9]{1,2}")) {
                    alertaDeErroOuInvalido
                            ("Erro", "Número de portas inválido, somente números", "");
                } else {
                    // Verificar se o ID do veículo existe
                    int idVeiculo = Integer.parseInt(modelo.getCodigoVeiculo());
                    if (!VeiculoService.verificarExistenciaVeiculoPorId(idVeiculo)) {
                        alertaDeErroOuInvalido("Erro", "Código do veículo inválido",
                                "O código do veículo fornecido não existe. Verifique o código do veículo e tente novamente.");
                        return; // Precisa ter esse return???
                    }

                    if (index > -1) {
                        ModeloService.atualizarModelo(index, modelo);
                        index = -1; // precisa resetar o index para poder incluir um registro novo
                        this.limparCamposModelo();
                    } else {
                        ModeloService.inserirModelo(modelo);
                        this.limparCamposModelo();
                    }

                    this.carregarlistaModelos();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void executarExcluirNoModelo() {
        Alert alertExclusao = new Alert(Alert.AlertType.CONFIRMATION);
        alertExclusao.setTitle("Confirmação de Exclusão");
        alertExclusao.setHeaderText("Confirmar exclusão do modelo?");
        Optional<ButtonType> retornoAlerta = alertExclusao.showAndWait();

        if (retornoAlerta.get() != null && retornoAlerta.get() == ButtonType.CANCEL) {
            limparCamposModelo();
        } else if (index > -1) {
            ModeloService.deletarModelo(index);
            this.carregarlistaModelos();
            index = -1;
            this.limparCamposModelo();
        }
    }
    public void carregarlistaModelos() {
        // Trazer o método da classe ModeloService
        tabelaModelo.getItems().remove(0, tabelaModelo.getItems().size());
        List<Modelo> modeloList = ModeloService.carregarModelos();
        tabelaModelo.getItems().addAll(modeloList);
    }
    public void limparCamposModelo() {
        codigoVeiculo.setText("");
        nomeModelo.setText(""); // zera o campo
        potencia.setText("");
        motor.setText("");
        anoLancamento.setText("");
        tipoCombustivel.setText("");
        numeroPortas.setText("");
        codigoVeiculo.setDisable(false); // Habilitar novamento o campo
        anoLancamento.setDisable(false);
        numeroPortas.setDisable(false);

    }

    // MARCA: --------------
    public void executarSalvarNaMarca() {
        Alert alertInclusao = new Alert(Alert.AlertType.CONFIRMATION);
        alertInclusao.setTitle("Confirmação de Inclusão");
        alertInclusao.setHeaderText("Confirmar inclusão da marca?");
        Optional<ButtonType> retornoAlerta = alertInclusao.showAndWait();

        try {
            if (retornoAlerta.get() != null && retornoAlerta.get() == ButtonType.OK) {
                Marca marca = new Marca();
                marca.setCodigoModeloNaMarca(String.valueOf(codigoModeloNaMarca.getText()));
                marca.setCnpj(cnpj.getText());
                marca.setRazaoSocial(razaoSocial.getText());
                marca.setCep(cep.getText()); // coluna CEP
                marca.setRuaNumero(ruaNumero.getText()); // coluna Rua
                marca.setBairro(bairro.getText());
                marca.setCidade(cidade.getText());
                marca.setUf(uf.getText());
                marca.setPais(pais.getText());
                marca.setTelefone(telefone.getText());
                marca.setEmail(email.getText());
                marca.setSite(site.getText());

                if (codigoModeloNaMarca.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo Obrigatório", "É obrigatório informar o código do modelo!",
                                    "");
                } else if (cnpj.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo Obrigatório", "É obrigatório informar o CNPJ!",
                                    "");
                } else if (!marca.getCnpj().matches("[0-9]*")) { // expressão regular: [0-9]*,
                    alertaDeErroOuInvalido
                            ("Erro", "CNPJ inválido, somente números", "");
                } else if (!marca.getCnpj().matches("\\d{14}")) { // expressão regular: [0-9]*,
                    alertaDeErroOuInvalido
                            ("Erro", "CNPJ inválido, tamanho incorreto",
                                    "Exatamente 14 dígitos");
                } else if (MarcaService.buscarMarcaPorCnpj(marca.getCnpj())) {
                    alertaRegistroExistenete("CNPJ", cnpj.getText());
                } else if (razaoSocial.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo Obrigatório", "É obrigatório informar a Razão Social!",
                                    "");
                } else if (!marca.getCep().matches("\\d{8}")) { // expressão regular: \d{8} - Exatamente 8 dígitos
                    alertaDeErroOuInvalido
                            ("Erro", "CEP inválido, somente números",
                                    "Exatamente 8 dígitos");
                } else if (cep.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo Obrigatório", "É obrigatório informar o CEP!",
                                    "");
                } else if (ruaNumero.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo Obrigatório", "É obrigatório informar a rua!",
                                    "");
                } else if (bairro.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo Obrigatório", "É obrigatório informar o bairro!",
                                    "");
                } else if (cidade.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo Obrigatório", "É obrigatório informar a cidade!",
                                    "");
                } else if (uf.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo Obrigatório", "É obrigatório informar a sigla do estado!",
                                    "");
                } else if (!marca.getUf().matches("[a-zA-Z]{2}")) { // [a-zA-Z]{2} - Exatamente 2 dígitos e somente letras
                    alertaDeErroOuInvalido
                            ("Erro", "UF inválido", "Confira o tamanho");
                } else if (pais.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo Obrigatório", "É obrigatório informar o país!",
                                    "");
                } else if (telefone.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo Obrigatório", "É obrigatório informar o telefone!",
                                    "");
                } else if(!marca.getTelefone().matches("[0-9]{0,14}")) {
                    alertaDeErroOuInvalido("Erro", "Telefone inválido, somente números",
                            "Verifique se o telefone digitado está correto, digitar apenas números e no máximo 14 dígitos.");

                } else {
                    // verificar se o ID de modelo existe
                    int idModelo = Integer.parseInt(marca.getCodigoModeloNaMarca());
                    if (!ModeloService.verificarExistenciaModeloPorId(idModelo)) {
                        alertaDeErroOuInvalido("Erro", "Código do modelo inválido",
                                "O código do modelo fornecido não existe. Verifique o " +
                                        "código do veículo e tente novamente.");
                    }

                    if (index > -1) {
                        MarcaService.atualizarMarca(index, marca);
                        index = -1; // precisa resetar o index para poder incluir um registro novo

                    }
                }
            }
            this.carregarlistaMarcas();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void executarExcluirNaMarca() {
        Alert alertExclusao = new Alert(Alert.AlertType.CONFIRMATION);
        alertExclusao.setTitle("Confirmação de Exclusão");
        alertExclusao.setHeaderText("Confirmar exclusão da marca?");
        Optional<ButtonType> retornoAlerta = alertExclusao.showAndWait();

        if (retornoAlerta.get() != null && retornoAlerta.get() == ButtonType.CANCEL) {
            limparCamposMarca();
        } else if (index > -1) {
            MarcaService.deletarMarca(index);
            this.carregarlistaMarcas();
            index = -1;
            this.limparCamposMarca();
        }
    }
    public void carregarlistaMarcas() {
        // Trazer o método da classe MarcaService
        tabelaMarca.getItems().remove(0, tabelaMarca.getItems().size());
        List<Marca> marcaList = MarcaService.carregarMarcas();
        tabelaMarca.getItems().addAll(marcaList);
    }
    public void limparCamposMarca() {
        codigoModeloNaMarca.setText("");
        cnpj.setText("");
        razaoSocial.setText("");
        cep.setText(""); // zera o campo
        ruaNumero.setText("");
        bairro.setText("");
        cidade.setText("");
        uf.setText("");
        pais.setText("");
        telefone.setText("");
        email.setText("");
        site.setText("");

        codigoModeloNaMarca.setDisable(false); // Habilitar
        cnpj.setDisable(false); // Habilitar

    }
    private void alertaDeErroOuInvalido(String titulo, String textoDoAlerta, String textoExplicacaoDoPossivelMotivo) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(textoDoAlerta);
        alerta.setContentText(textoExplicacaoDoPossivelMotivo); // Ex: "O código do veículo fornecido não existe. Verifique o código do veículo e tente novamente.");
        alerta.show();
    }
    private void alertaRegistroExistenete(String nomeDoRegistro, String registroExistente) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Alerta");
        alert.setHeaderText(nomeDoRegistro + " " + registroExistente + " já existe.");
        alert.show();
    }
}