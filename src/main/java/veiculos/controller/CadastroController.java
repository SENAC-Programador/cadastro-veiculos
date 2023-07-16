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
    private TextField idVeiculo; // int, NOT NULL
    @FXML
    private TextField dataCadastroVeiculo;
    @FXML
    private TextField chassi; // NOT NULL, UNIQUE -> ex: 1HGCM82633A123456
    @FXML
    private TextField placa; // NOT NULL, UNIQUE -> ex: ABC-1234
    @FXML
    private TextField corVeiculo; // NULL
    @FXML
    private TextField quilometragem; // NULL -> ex: 50.000 km
    @FXML
    private TextField codigoMarca; // NOT NULL, FK
    @FXML
    private TextField codigoModelo; // NOT NULL, FK
    @FXML
    private TableView<Veiculo> tabelaVeiculos;
    @FXML
    private TableColumn<Veiculo, Integer> colunaIdVeiculo;
    @FXML
    private TableColumn<Veiculo, Integer> colunaDataCadastroVeiculo;
    @FXML
    private TableColumn<Veiculo, String> colunaChassi; // NOT NULL, UNIQUE -> ex: 1HGCM82633A123456
    @FXML
    private TableColumn<Veiculo, String> colunaPlaca; // NOT NULL, UNIQUE -> ex: ABC-1234
    @FXML
    private TableColumn<Veiculo, String> colunaCorVeiculo; // NULL
    @FXML
    private TableColumn<Veiculo, String> colunaQuilometragem; // NULL -> ex: 50.000 km
    @FXML
    private TableColumn<Veiculo, String> colunaCodigoMarca; // NOT NULL, FK
    @FXML
    private TableColumn<Veiculo, String> colunaCodigoModelo; // NOT NULL, FK

    // MARCA
    @FXML
    private TextField idMarca; // int, NOT NULL
    @FXML
    private TextField cnpj; // NOT NULL, UNIQUE
    @FXML
    private TextField razaoSocial; // NOT NULL, UNIQUE
    @FXML
    private TextField cep; // NOT NULL
    @FXML
    private TextField rua; // NOT NULL
    @FXML
    private TextField numero; // NULL
    @FXML
    private TextField bairro; // NOT NULL
    @FXML
    private TextField cidade; // NOT NULL
    @FXML
    private TextField uf; // NOT NULL
    @FXML
    private TextField pais; // NOT NULL
    @FXML
    private TextField telefone; // NOT NULL
    @FXML
    private TextField email; // NULL
    @FXML
    private TextField site; // NULL -> site oficial da marca
    @FXML
    private TableView<Marca> tabelaMarcas;
    @FXML
    private TableColumn<Marca, Integer> colunaIdMarca; // int, NOT NULL
    @FXML
    private TableColumn<Marca, String> colunaCnpj; // NOT NULL, UNIQUE
    @FXML
    private TableColumn<Marca, String> colunaRazaoSocial; // NOT NULL, UNIQUE
    @FXML
    private TableColumn<Marca, String> colunaCep; // NOT NULL
    @FXML
    private TableColumn<Marca, String> colunaRua; // NOT NULL
    @FXML
    private TableColumn<Marca, String> colunaNumero; // NULL
    @FXML
    private TableColumn<Marca, String> colunaBairro; // NOT NULL
    @FXML
    private TableColumn<Marca, String> colunaCidade; // NOT NULL
    @FXML
    private TableColumn<Marca, String> colunaUf; // NOT NULL
    @FXML
    private TableColumn<Marca, String> colunaPais; // NOT NULL
    @FXML
    private TableColumn<Marca, String> colunaTelefone; // NOT NULL
    @FXML
    private TableColumn<Marca, String> colunaEmail; // NULL
    @FXML
    private TableColumn<Marca, String> colunaSite; // NULL -> site oficial da marca

    // MODELO
    @FXML
    private TextField idModelo; // int, NOT NULL
    @FXML
    private TextField codigoMarcaModelo; // NOT NULL
    @FXML
    private TextField nomeModelo; // NOT NULL
    @FXML
    private TextField potencia; // NOT NULL
    @FXML
    private TextField motor; // NOT NULL
    @FXML
    private TextField anoLancamento; // NOT NULL
    @FXML
    private TextField tipoCombustivel; // NOT NULL -> tipo de combustível do veículo (ex: gasolina, diesel, elétrico, etc.).
    @FXML
    private TextField numeroPortas; // NOT NUL
    @FXML
    private TableView<Modelo> tabelaModelos;
    @FXML
    private TableColumn<Modelo, Integer> colunaIdModelo; // int, NOT NULL
    @FXML
    private TableColumn<Modelo, String> colunaCodigoMarcaModelo; // NOT NULL
    @FXML
    private TableColumn<Modelo, String> colunaNomeModelo; // NOT NULL
    @FXML
    private TableColumn<Modelo, String> colunaPotencia; // NOT NULL
    @FXML
    private TableColumn<Modelo, String> colunaMotor; // NOT NULL
    @FXML
    private TableColumn<Modelo, String> colunaAnoLancamento; // NOT NULL
    @FXML
    private TableColumn<Modelo, String> colunaTipoCombustivel; // NOT NULL -> tipo de combustível do veículo (ex: gasolina, diesel, elétrico, etc.).
    @FXML
    private TableColumn<Modelo, String> colunaNumeroPortas; // NOT NULL
    private int index = -1;

    // Método para dizer para o JavaFX ... pesquisar ...
    @FXML
    public void initialize() {

// VEÍCULO: idVeiculo, dataCadastroVeiculo, chassi, placa, corVeiculo, quilometragem, codigoMarca, codigoModelo
        colunaIdVeiculo.setCellValueFactory(new PropertyValueFactory<>("idVeiculo")); // é o nome da variavel, não do banco de dados
        colunaDataCadastroVeiculo.setCellValueFactory(new PropertyValueFactory<>("dataCadastroVeiculo"));
        colunaChassi.setCellValueFactory(new PropertyValueFactory<>("chassi"));
        colunaPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        colunaCorVeiculo.setCellValueFactory(new PropertyValueFactory<>("corVeiculo"));
        colunaQuilometragem.setCellValueFactory(new PropertyValueFactory<>("quilometragem"));
        colunaCodigoMarca.setCellValueFactory(new PropertyValueFactory<>("codigoMarca"));
        colunaCodigoModelo.setCellValueFactory(new PropertyValueFactory<>("codigoModelo"));

// MARCA: idMarca, cnpj, razaoSocial, cep, rua, numero, bairro, cidade, uf, pais, telefone, email, site
        colunaIdMarca.setCellValueFactory(new PropertyValueFactory<>("idMarca"));
        colunaCnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
        colunaRazaoSocial.setCellValueFactory(new PropertyValueFactory<>("razaoSocial"));
        colunaCep.setCellValueFactory(new PropertyValueFactory<>("cep"));
        colunaRua.setCellValueFactory(new PropertyValueFactory<>("rua"));
        colunaNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colunaBairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
        colunaCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        colunaUf.setCellValueFactory(new PropertyValueFactory<>("uf"));
        colunaPais.setCellValueFactory(new PropertyValueFactory<>("pais"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colunaSite.setCellValueFactory(new PropertyValueFactory<>("site"));

// MODELO: idModelo, codigoMarcaModelo, nomeModelo, potencia, motor, anoLancamento, tipoCombustivel, numeroPortas
        colunaIdModelo.setCellValueFactory(new PropertyValueFactory<>("idModelo"));
        colunaCodigoMarcaModelo.setCellValueFactory(new PropertyValueFactory<>("codigoMarcaModelo"));
        colunaNomeModelo.setCellValueFactory(new PropertyValueFactory<>("nomeModelo"));
        colunaPotencia.setCellValueFactory(new PropertyValueFactory<>("potencia"));
        colunaMotor.setCellValueFactory(new PropertyValueFactory<>("motor"));
        colunaAnoLancamento.setCellValueFactory(new PropertyValueFactory<>("anoLancamento"));
        colunaTipoCombustivel.setCellValueFactory(new PropertyValueFactory<>("tipoCombustivel"));
        colunaNumeroPortas.setCellValueFactory(new PropertyValueFactory<>("numeroPortas"));

        // Trazer o método das classes Services
        this.carregarlistaVeiculos();
        this.carregarlistaMarcas();
        this.carregarlistaModelos();

// VEÍCULO: idVeiculo, dataCadastroVeiculo, chassi, placa, corVeiculo, quilometragem, codigoMarca, codigoModelo
        tabelaVeiculos.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent evt) {
                if (evt.getClickCount() == 2) { // qtde de cliques, dois cliques no evento
                    Veiculo veiculo = tabelaVeiculos.getSelectionModel().getSelectedItem(); // pegar o item que foi selecionado e sua posição
                    dataCadastroVeiculo.setText(veiculo.getDataCadastroVeiculo());
                    chassi.setText(veiculo.getChassi());
                    chassi.setDisable(true); // Desabilitar o campo "chassi" para edição ou exclusão
                    placa.setText(veiculo.getPlaca());
                    placa.setDisable(true); // Desabilitar o campo "placa" para edição ou exclusão
                    corVeiculo.setText(veiculo.getCorVeiculo());
                    quilometragem.setText(veiculo.getQuilometragem());
                    codigoMarca.setText(veiculo.getCodigoMarca());
                    codigoModelo.setText(veiculo.getCodigoModelo());

                    index = veiculo.getIdVeiculo();

                    // Alerta para alterar
                    Alert alertAlterar = new Alert(Alert.AlertType.CONFIRMATION);
                    alertAlterar.setTitle("Confirmação de alterar");
                    alertAlterar.setHeaderText("Confirmar alteração do veículo?");
                    Optional<ButtonType> retornoAlerta = alertAlterar.showAndWait();
                }
            }
        });
// MARCA: idMarca, cnpj, razaoSocial, cep, rua, numero, bairro, cidade, uf, pais, telefone, email, site
        tabelaMarcas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    Marca marca = tabelaMarcas.getSelectionModel().getSelectedItem();
                    //codigoVeiculo.setText(String.valueOf(marca.getCodigoVeiculo()));
                    //codigoVeiculo.setDisable(true); // Desabilitar o campo "Código Veículo" para edição ou exclusão
                    cnpj.setText(marca.getCnpj());
                    razaoSocial.setText(marca.getRazaoSocial());
                    cep.setText(marca.getCep());
                    rua.setText(marca.getRua());
                    numero.setText(marca.getNumero());
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
                    alertAlterar.setHeaderText("Confirmar alteração do marca?");
                    Optional<ButtonType> retornoAlerta = alertAlterar.showAndWait();
                }
            }
        });

// MODELO: idModelo, codigoMarcaModelo, nomeModelo, potencia, motor, anoLancamento, tipoCombustivel, numeroPortas
        tabelaModelos.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    Modelo modelo = tabelaModelos.getSelectionModel().getSelectedItem();
                    codigoMarcaModelo.setText(modelo.getCodigoMarcaModelo());
                    nomeModelo.setText(modelo.getNomeModelo());
                    potencia.setText(modelo.getPotencia());
                    motor.setText(modelo.getMotor());
                    anoLancamento.setText(modelo.getAnoLancamento());
                    tipoCombustivel.setText(modelo.getTipoCombustivel());
                    numeroPortas.setText(modelo.getNumeroPortas());

                    index = modelo.getIdModelo();

                    // Alerta para alterar
                    Alert alertAlterar = new Alert(Alert.AlertType.CONFIRMATION);
                    alertAlterar.setTitle("Confirmação de alterar");
                    alertAlterar.setHeaderText("Confirmar alteração do modelo?");
                    Optional<ButtonType> retornoAlerta = alertAlterar.showAndWait();
                }
            }
        });
    }

// VEÍCULO: idVeiculo, dataCadastroVeiculo, chassi, placa, corVeiculo, quilometragem, codigoMarca, codigoModelo
    // Método para fazer funcionar o botão "Salvar" do JavaFX
    public void executarSalvarVeiculo() {
        Alert alertInclusao = new Alert(Alert.AlertType.CONFIRMATION);
        alertInclusao.setTitle("Confirmação de inclusão");
        alertInclusao.setHeaderText("Confirmar inclusão do veículo?");
        Optional<ButtonType> option = alertInclusao.showAndWait();

        if (option.get() != null && option.get() == ButtonType.OK) {
            Veiculo veiculo = new Veiculo();
            veiculo.setDataCadastroVeiculo(dataCadastroVeiculo.getText()); // para mostrar as informações que estão na linha que pertecem a coluna documento da tabela
            veiculo.setChassi(chassi.getText()); // desabilitar o campo chassi
            veiculo.setPlaca(placa.getText());
            veiculo.setCorVeiculo(corVeiculo.getText());
            veiculo.setQuilometragem(quilometragem.getText());
            veiculo.setCodigoMarca(codigoMarca.getText());
            veiculo.setCodigoModelo(codigoModelo.getText());

            try {
                Alert alertaObrig = new Alert(Alert.AlertType.ERROR);
                alertaObrig.setTitle("Campo obrigatório");
                Alert alertaInval = new Alert(Alert.AlertType.ERROR);
                alertaInval.setTitle("Erro");

                if (dataCadastroVeiculo.getText().isEmpty()) {
                    alertaObrig.setHeaderText("É obrigatório informar a data do cadastro!");
                    alertaObrig.show(); // precisa para mostrar a tela do alerta
                }  else if (chassi.getText().isEmpty()) {
                    alertaObrig.setHeaderText("É obrigatório informar o chassi!");
                    alertaObrig.show(); // precisa para mostrar a tela do alerta
                }  else if (placa.getText().isEmpty()) {
                    alertaObrig.setHeaderText("É obrigatório informar a placa!");
                    alertaObrig.show(); // precisa para mostrar a tela do alerta
                } else if (!veiculo.getQuilometragem().matches("[0-9]*")) { // expressão regular: [0-9]*, ela só permite números de 0 a 9
                    alertaInval.setHeaderText("Quilometragem inválida, somente números.");
                    alertaInval.show();
                } else if (index < 0) {
                    if (VeiculoService.buscarVeiculoByChassi(veiculo.getChassi())) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Alerta");
                        alert.setHeaderText("Chassi " + chassi.getText() + " já existe na base.");
                        alert.show(); // precisa para mostrar a tela do alerta
                    } else if (VeiculoService.buscarVeiculoByPlaca(veiculo.getPlaca())) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Alerta");
                        alert.setHeaderText("Placa " + placa.getText() + " já existe na base.");
                        alert.show(); // precisa para mostrar a tela do alerta

                    } else {
                        VeiculoService.inserirVeiculo(veiculo);
                    }
                    // Substituido --> tabelaVeiculos.getItems().add(veiculo);
                } else {
                    VeiculoService.atualizarVeiculo(index, veiculo);
                    index = -1;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            this.carregarlistaVeiculos();
            this.limparCampos();
        }
    }

    public void executarExcluirVeiculo() {
        Alert alertExclusao = new Alert(Alert.AlertType.CONFIRMATION);
        alertExclusao.setTitle("Confirmação de Exclusão");
        alertExclusao.setHeaderText("Confirmar exclusão do veículo?");
        Optional<ButtonType> retornoAlerta = alertExclusao.showAndWait();
        if (index > -1) {
            VeiculoService.deletarVeiculo(index);
            this.carregarlistaVeiculos();
            index = -1;
            this.limparCampos();
        }
    }

    public void carregarlistaVeiculos() {
        // Trazer o método da classe VeiculoService
        tabelaVeiculos.getItems().remove(0, tabelaVeiculos.getItems().size());
        List<Veiculo> veiculoList = VeiculoService.carregarVeiculo();
        tabelaVeiculos.getItems().addAll(veiculoList);
    }
    public void limparCampos() {
        dataCadastroVeiculo.setText("");
        chassi.setText(""); // zera o campo
        placa.setText("");
        corVeiculo.setText("");
        quilometragem.setText("");
        codigoMarca.setText("");
        codigoModelo.setText("");
        chassi.setDisable(false); // habilitar documento
        placa.setDisable(false); // habilitar nome
    }

// MARCA: idMarca, cnpj, razaoSocial, cep, rua, numero, bairro, cidade, uf, pais, telefone, email, site
    public void executarSalvarMarca() {
        Alert alertInclusao = new Alert(Alert.AlertType.CONFIRMATION);
        alertInclusao.setTitle("Confirmação de Inclusão");
        alertInclusao.setHeaderText("Confirmar inclusão da marca?");
        Optional<ButtonType> retornoAlerta = alertInclusao.showAndWait();

        try {
            if (retornoAlerta.get() != null && retornoAlerta.get() == ButtonType.OK) {

                Marca marca = new Marca();
                marca.setCnpj(cnpj.getText());
                marca.setRazaoSocial(razaoSocial.getText());
                marca.setCep(cep.getText()); // coluna CEP
                marca.setRua(rua.getText()); // coluna Rua
                marca.setNumero(numero.getText()); // coluna número
                marca.setBairro(bairro.getText());
                marca.setCidade(cidade.getText());
                marca.setUf(uf.getText());
                marca.setPais(pais.getText());
                marca.setTelefone(telefone.getText());
                marca.setEmail(email.getText());
                marca.setSite(site.getText());

                Alert alertObri = new Alert(Alert.AlertType.ERROR);
                alertObri.setTitle("Campo obrigatório");
                Alert alertInvalido = new Alert(Alert.AlertType.ERROR);
                alertInvalido.setTitle("Erro");

                if (cnpj.getText().isEmpty()) {
                    alertObri.setHeaderText("É obrigatório informar o CNPJ!");
                    alertObri.show(); // precisa para mostrar a tela do alerta
                } else if (razaoSocial.getText().isEmpty()) {
                    alertObri.setHeaderText("É obrigatório informar a Razão Social!");
                    alertObri.show();
                } else if (!marca.getCep().matches("[0-9]*")) { // expressão regular: [0-9]*,
                    alertInvalido.setHeaderText("CEP inválido, somente números");
                    alertInvalido.show();
                } else if (cep.getText().isEmpty()) {
                    alertObri.setHeaderText("É obrigatório informar o CEP!");
                    alertObri.show(); // precisa para mostrar a tela do alerta
                } else if (rua.getText().isEmpty()) {
                    alertObri.setHeaderText("É obrigatório informar a rua!");
                    alertObri.show(); // precisa para mostrar a tela do alerta
                } else if (bairro.getText().isEmpty()) {
                    alertObri.setHeaderText("É obrigatório informar o bairro!");
                    alertObri.show(); // precisa para mostrar a tela do alerta
                } else if (cidade.getText().isEmpty()) {
                    alertObri.setHeaderText("É obrigatório informar a cidade!");
                    alertObri.show();
                } else if (uf.getText().isEmpty()) {
                    alertObri.setHeaderText("É obrigatório informar a sigla do estado!");
                    alertObri.show();
                } else if (pais.getText().isEmpty()) {
                    alertObri.setHeaderText("É obrigatório informar o país!");
                    alertObri.show();
                } else if (telefone.getText().isEmpty()) {
                    alertObri.setHeaderText("É obrigatório informar o telefone!");
                    alertObri.show();
                } else if(!marca.getTelefone().matches("[0-9]*")) {
                    alertInvalido.setHeaderText("Telefone inválido, somente números");
                    alertInvalido.show();
                } else if (index > -1) {
                    MarcaService.atualizarMarca(index, marca);
                    index = -1; // precisa resetar o index, para poder incluir um registro novo
                } else {
                    MarcaService.inserirMarca(marca);
                }
            }
            this.carregarlistaMarcas();
            this.limparCamposMarca();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void executarExcluirMarca() {
        Alert alertExclusao = new Alert(Alert.AlertType.CONFIRMATION);
        alertExclusao.setTitle("Confirmação de Exclusão");
        alertExclusao.setHeaderText("Confirmar exclusão da marca?");
        Optional<ButtonType> retornoAlerta = alertExclusao.showAndWait();
        if (index > -1) {
            MarcaService.deletarMarca(index);
            this.carregarlistaMarcas();
            index = -1;
            this.limparCamposMarca();
        }
    }
    public void carregarlistaMarcas() {
        // Trazer o método da classe MarcaService
        tabelaMarcas.getItems().remove(0, tabelaMarcas.getItems().size());
        List<Marca> marcaList = MarcaService.carregarMarcas();
        tabelaMarcas.getItems().addAll(marcaList);
    }

    public void limparCamposMarca() {
        cnpj.setText("");
        razaoSocial.setText("");
        cep.setText(""); // zera o campo
        rua.setText("");
        numero.setText("");
        bairro.setText("");
        cidade.setText("");
        uf.setText("");
        pais.setText("");
        telefone.setText("");
        email.setText("");
        site.setText("");
        //codigoVeiculo.setDisable(false); // habilitar o campo código veículo
    }

// MODELO: idModelo, codigoMarcaModelo, nomeModelo, potencia, motor, anoLancamento, tipoCombustivel, numeroPortas
    // Método para fazer funcionar o botão "OK" do JavaFX
    public void executarSalvarModelo() {
        Alert alertInclusao = new Alert(Alert.AlertType.CONFIRMATION);
        alertInclusao.setTitle("Confirmação de Inclusão");
        alertInclusao.setHeaderText("Confirmar inclusão do modelo?");
        Optional<ButtonType> retornoAlerta = alertInclusao.showAndWait();

        try {
            if (retornoAlerta.get() != null && retornoAlerta.get() == ButtonType.OK) {

                Modelo modelo = new Modelo();
                // para mostrar as informações que estão na linha que pertecem as colunas da tabela
                modelo.setCodigoMarcaModelo(codigoMarcaModelo.getText()); // coluna código da marca
                modelo.setNomeModelo(nomeModelo.getText());
                modelo.setPotencia(potencia.getText());
                modelo.setMotor(motor.getText());
                modelo.setAnoLancamento(anoLancamento.getText());
                modelo.setTipoCombustivel(tipoCombustivel.getText());
                modelo.setNumeroPortas(numeroPortas.getText());

                Alert alertObri = new Alert(Alert.AlertType.ERROR);
                alertObri.setTitle("Campo obrigatório");
                Alert alertInvalido = new Alert(Alert.AlertType.ERROR);
                alertInvalido.setTitle("Erro");

                if (codigoMarcaModelo.getText().isEmpty()) {
                    alertObri.setHeaderText("É obrigatório informar o código da marca!");
                    alertObri.show();
                } else if (!modelo.getCodigoMarcaModelo().matches("[0-9]*")) { // expressão regular: [0-9]*, ela só permite números de 0 a 9
                    alertInvalido.setHeaderText("Código da marca inválido, somente números");
                    alertInvalido.show();
                } else if (nomeModelo.getText().isEmpty()) {
                    alertObri.setHeaderText("É obrigatório informar o nome do modelo!");
                    alertObri.show();
                } else if (potencia.getText().isEmpty()) {
                    alertObri.setHeaderText("É obrigatório informar a potência");
                    alertObri.show();
                } else if (motor.getText().isEmpty()) {
                    alertObri.setHeaderText("É obrigatório informar o motor!");
                    alertObri.show();
                } else if (anoLancamento.getText().isEmpty()) {
                    alertObri.setHeaderText("É obrigatório informar o ano do lançamento!");
                    alertObri.show();
                } else if (tipoCombustivel.getText().isEmpty()) {
                    alertObri.setHeaderText("É obrigatório informar o tipo do combustivel!");
                    alertObri.show();
                } else if (numeroPortas.getText().isEmpty()) {
                    alertObri.setHeaderText("É obrigatório informar o número de portas!");
                    alertObri.show();
                } else if (!modelo.getNumeroPortas().matches("[0-9]*")) {
                    alertInvalido.setHeaderText("Número de portas inválido, somente números");
                    alertInvalido.show();
                } else if (index > -1) {
                    ModeloService.atualizarModelo(index, modelo);
                    index = -1; // precisa resetar o index, para poder incluir um registro novo
                } else {
                    ModeloService.inserirModelo(modelo);
                }
            }
            this.carregarlistaModelos();
            this.limparCamposModelo();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void executarExcluirModelo() {
        Alert alertExclusao = new Alert(Alert.AlertType.CONFIRMATION);
        alertExclusao.setTitle("Confirmação de Exclusão");
        alertExclusao.setHeaderText("Confirmar exclusão do modelo?");
        Optional<ButtonType> retornoAlerta = alertExclusao.showAndWait();

        if (index > -1) {
            ModeloService.deletarModelo(index);
            this.carregarlistaModelos();
            index = -1;
            this.limparCamposModelo();
        }
    }
    public void carregarlistaModelos() {
        // Trazer o método da classe ModeloService
        tabelaModelos.getItems().remove(0, tabelaModelos.getItems().size());
        List<Modelo> modeloList = ModeloService.carregarModelos();
        tabelaModelos.getItems().addAll(modeloList);
    }

    public void limparCamposModelo() {
        codigoMarcaModelo.setText("");
        nomeModelo.setText(""); // zera o campo
        potencia.setText("");
        motor.setText("");
        anoLancamento.setText("");
        tipoCombustivel.setText("");
        numeroPortas.setText("");
        codigoMarcaModelo.setDisable(false); // habilitar o campo código da marca

    }

}
