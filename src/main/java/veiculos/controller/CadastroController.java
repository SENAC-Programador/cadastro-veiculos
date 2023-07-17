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
    private TextField idVeiculo; // idVeiculo/ - SERIAL PRIMARY KEY - executarSalvarNoVeiculo/executarExcluirNoVeiculo/tabelaVeiculo
    @FXML
    private TextField chassi; // chassi/colunaChassi - VARCHAR(17) NOT NULL UNIQUE, -> pode variar de fabricante para fabricante, ex: 1HGCM82633A123456
    @FXML
    private TextField placa; // placa/colunaPlaca - VARCHAR(7) NOT NULL UNIQUE, -> ex: ABC-1234, podem ter formatos diferentes em diferentes países ou regiões
    @FXML
    private TextField corVeiculo; // corVeiculo/colunaCorVeiculo - VARCHAR(50) NOT NULL,
    @FXML
    private TextField quilometragem; // quilometragem/colunaQuilometragem - VARCHAR(20) NOT NULL -> quilometragem at
    @FXML
    private TableView<Veiculo> tabelaVeiculo;
    @FXML
    private TableColumn<Veiculo, Integer> colunaCodigoVeiculo;
    @FXML
    private TableColumn<Veiculo, String> colunaChassi; // chassi/colunaChassi - VARCHAR(17) NOT NULL UNIQUE, -> pode variar de fabricante para fabricante, ex: 1HGCM82633A123456
    @FXML
    private TableColumn<Veiculo, String> colunaPlaca; // placa/colunaPlaca - VARCHAR(7) NOT NULL UNIQUE, -> ex: ABC-1234, podem ter formatos diferentes em diferentes países ou regiões
    @FXML
    private TableColumn<Veiculo, String> colunaCorVeiculo; // corVeiculo/colunaCorVeiculo - VARCHAR(50) NOT NULL,
    @FXML
    private TableColumn<Veiculo, String> colunaQuilometragem; // quilometragem/colunaQuilometragem - VARCHAR(20) NOT NULL -> quil

// MODELO
    @FXML
    private TextField idModelo; // // colunaCodigoModelo/tabelaModelo/executarSalvarNoModelo/executarExcluirNoModelo - id SERIAL PRIMARY K
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
    private TextField idMarca; // tabelaMarca/executarSalvarNaMarca/executarExcluirNaMarca - id SERIAL PRIMARY KEY,
    @FXML
    private TextField codigoModelo; // codigoModelo/colunaCodigoModelo - id_modelo INT NOT NULL,
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
    private TableColumn<Marca, Integer> codigoModeloNaMarca; // codigoModelo/codigoModeloNaMarca - id_modelo INT NOT NULL,
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

// VEÍCULO: int idVeiculo, String chassi, String placa, String corVeiculo, String quilometragem
        colunaCodigoVeiculo.setCellValueFactory(new PropertyValueFactory<>("idVeiculo")); // é o nome da variavel, não do banco de dados
        colunaChassi.setCellValueFactory(new PropertyValueFactory<>("chassi"));
        colunaPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        colunaCorVeiculo.setCellValueFactory(new PropertyValueFactory<>("corVeiculo"));
        colunaQuilometragem.setCellValueFactory(new PropertyValueFactory<>("quilometragem"));

// MODELO: int idModelo, String nomeModelo, String motor, String potencia, String anoLancamento,
//   String tipoCombustivel, String numeroPortas
        colunaCodigoModelo.setCellValueFactory(new PropertyValueFactory<>("idModelo"));
        colunaNomeModelo.setCellValueFactory(new PropertyValueFactory<>("nomeModelo"));
        colunaMotor.setCellValueFactory(new PropertyValueFactory<>("motor"));
        colunaPotencia.setCellValueFactory(new PropertyValueFactory<>("potencia"));
        colunaAnoLancamento.setCellValueFactory(new PropertyValueFactory<>("anoLancamento"));
        colunaTipoCombustivel.setCellValueFactory(new PropertyValueFactory<>("tipoCombustivel"));
        colunaNumeroPortas.setCellValueFactory(new PropertyValueFactory<>("numeroPortas"));

// MARCA: int idMarca, int codigoModelo, String cnpj, String razaoSocial, String cep, String ruaNumero,
//  String bairro, String cidade, String uf, String pais, String telefone, String email, String site
        codigoModeloNaMarca.setCellValueFactory(new PropertyValueFactory<>("codigoModeloNaMarca"));
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

// // VEÍCULO: int idVeiculo, String chassi, String placa, String corVeiculo, String quilometragem
        tabelaVeiculo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent evt) {
                if (evt.getClickCount() == 2) { // qtde de cliques, dois cliques no evento
                    Veiculo veiculo = tabelaVeiculo.getSelectionModel().getSelectedItem(); // pegar o item que foi selecionado e sua posição
                    idVeiculo.setText(String.valueOf(veiculo.getIdVeiculo()));
                    chassi.setText(veiculo.getChassi());
                    placa.setText(veiculo.getPlaca());
                    corVeiculo.setText(veiculo.getCorVeiculo());
                    quilometragem.setText(veiculo.getQuilometragem());

                    index = veiculo.getIdVeiculo();

                    // Alerta para alterar
                    Alert alertAlterar = new Alert(Alert.AlertType.CONFIRMATION);
                    alertAlterar.setTitle("Confirmação de alterar");
                    alertAlterar.setHeaderText("Confirmar alteração do veículo?");
                    Optional<ButtonType> retornoAlerta = alertAlterar.showAndWait();
                }
            }
        });

// // MODELO: int idModelo, String codigoVeiculo, String nomeModelo, String motor, String potencia,
////  String anoLancamento, String tipoCombustivel, String numeroPortas
        tabelaModelo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    Modelo modelo = tabelaModelo.getSelectionModel().getSelectedItem();
                    codigoVeiculo.setText(String.valueOf(modelo.getCodigoVeiculo()));
                    nomeModelo.setText(modelo.getNomeModelo());
                    motor.setText(modelo.getMotor());
                    potencia.setText(modelo.getPotencia());
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

// MARCA: int idMarca, int codigoModelo, String cnpj, String razaoSocial, String cep, String ruaNumero,
//  String bairro, String cidade, String uf, String pais, String telefone, String email, String site
        tabelaMarca.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    Marca marca = tabelaMarca.getSelectionModel().getSelectedItem();
                    codigoModeloNaMarca.setText(String.valueOf(marca.getCodigoModeloNaMarca()));
                    cnpj.setText(marca.getCnpj());
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
                    alertAlterar.setHeaderText("Confirmar alteração do marca?");
                    Optional<ButtonType> retornoAlerta = alertAlterar.showAndWait();
                }
            }
        });
    }

// // VEÍCULO: int idVeiculo, String chassi, String placa, String corVeiculo, String quilometragem
    // Método para fazer funcionar o botão "Salvar" do JavaFX
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
                Alert alertaObrig = new Alert(Alert.AlertType.ERROR);
                alertaObrig.setTitle("Campo obrigatório");
                Alert alertaInval = new Alert(Alert.AlertType.ERROR);
                alertaInval.setTitle("Erro");

                if (chassi.getText().isEmpty()) {
                    alertaObrig.setHeaderText("É obrigatório informar o chassi!");
                    alertaObrig.show(); // precisa para mostrar a tela do alerta
                }  else if (placa.getText().isEmpty()) {
                    alertaObrig.setHeaderText("É obrigatório informar a placa!");
                    alertaObrig.show(); // precisa para mostrar a tela do alerta
                } else if (!veiculo.getQuilometragem().matches("[0-9]*")) { // expressão regular: [0-9]*, ela só permite números de 0 a 9
                    alertaInval.setHeaderText("Quilometragem inválida, somente números.");
                    alertaInval.show();
                } else if (index < 0) {
                    if (VeiculoService.buscarVeiculoPorChassi(veiculo.getChassi())) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Alerta");
                        alert.setHeaderText("Chassi " + chassi.getText() + " já existe na base.");
                        alert.show(); // precisa para mostrar a tela do alerta
                    } else if (VeiculoService.buscarVeiculoPorPlaca(veiculo.getPlaca())) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Alerta");
                        alert.setHeaderText("Placa " + placa.getText() + " já existe na base.");
                        alert.show(); // precisa para mostrar a tela do alerta

                    } else {
                        VeiculoService.inserirVeiculo(veiculo);
                    }
                    // Substituido --> tabelaVeiculo.getItems().add(veiculo);
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

    public void executarExcluirNoVeiculo() {
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
        tabelaVeiculo.getItems().remove(0, tabelaVeiculo.getItems().size());
        List<Veiculo> veiculoList = VeiculoService.carregarVeiculo();
        tabelaVeiculo.getItems().addAll(veiculoList);
    }
    public void limparCampos() {
        chassi.setText(""); // zera o campo
        placa.setText("");
        corVeiculo.setText("");
        quilometragem.setText("");
        //chassi.setDisable(false); // habilitar documento
        //placa.setDisable(false); // habilitar nome
    }

// MODELO: int idModelo, String codigoVeiculo, String nomeModelo, String motor, String potencia,
//  String anoLancamento, String tipoCombustivel, String numeroPortas
    // Método para fazer funcionar o botão "OK" do JavaFX
    public void executarSalvarNoModelo() {
        Alert alertInclusao = new Alert(Alert.AlertType.CONFIRMATION);
        alertInclusao.setTitle("Confirmação de Inclusão");
        alertInclusao.setHeaderText("Confirmar inclusão do modelo?");
        Optional<ButtonType> retornoAlerta = alertInclusao.showAndWait();

        try {
            if (retornoAlerta.get() != null && retornoAlerta.get() == ButtonType.OK) {

                Modelo modelo = new Modelo();
                // para mostrar as informações que estão na linha que pertecem as colunas da tabela
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
                    alertInvalido.setHeaderText("Código do veículo inválido, somente números");
                    alertInvalido.show();
                } else if (nomeModelo.getText().isEmpty()) {
                    alertObri.setHeaderText("É obrigatório informar o nome do modelo!");
                    alertObri.show();
                } else if (motor.getText().isEmpty()) {
                    alertObri.setHeaderText("É obrigatório informar o motor!");
                    alertObri.show();
                } else if (potencia.getText().isEmpty()) {
                    alertObri.setHeaderText("É obrigatório informar a potência");
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

    public void executarExcluirNoModelo() {
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

    }

// MARCA: int idMarca, int codigoModelo, String cnpj, String razaoSocial, String cep, String ruaNumero,
//  String bairro, String cidade, String uf, String pais, String telefone, String email, String site
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
                } else if (ruaNumero.getText().isEmpty()) {
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
    public void executarExcluirNaMarca() {
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
        tabelaMarca.getItems().remove(0, tabelaMarca.getItems().size());
        List<Marca> marcaList = MarcaService.carregarMarcas();
        tabelaMarca.getItems().addAll(marcaList);
    }

    public void limparCamposMarca() {
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
        //codigoVeiculo.setDisable(false); // habilitar o campo código veículo
    }

}
