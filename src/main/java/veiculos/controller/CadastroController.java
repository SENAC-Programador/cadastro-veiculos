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

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@Component
@FxmlView("/main.fxml") // para lincar com o arquivo "main.fxml"
public class CadastroController {
    @FXML
    private TextField codigoModelo;
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
    private TableColumn<Veiculo, String> colunaCodigoVeiculo;
    @FXML
    private TableColumn<Veiculo, String> colunaChassi;
    @FXML
    private TableColumn<Veiculo, String> colunaPlaca;
    @FXML
    private TableColumn<Veiculo, String> colunaCorVeiculo;
    @FXML
    private TableColumn<Veiculo, String> colunaQuilometragem;
    @FXML
    private TableColumn<Veiculo, String> colunaCodigoModeloVeiculo;
    @FXML
    private TableColumn<Veiculo, String> colunaModelo;
    @FXML
    private TableColumn<Veiculo, String> colunaMarca;

// MODELO
    @FXML
    private TextField codigoMarcaModelo;
    @FXML
    private TextField nomeModelo;
    @FXML
    private TextField motor;
    @FXML
    private TextField potencia;
    @FXML
    private TextField anoLancamento;
    @FXML
    private TextField tipoCombustivel;
    @FXML
    private TextField numeroPortas;
    @FXML
    private TableView<Modelo> tabelaModelo;
    @FXML
    private TableColumn<Modelo, String> colunaCodigoModelo;
    @FXML
    private TableColumn<Modelo, String> colunaNomeModelo;
    @FXML
    private TableColumn<Modelo, String> colunaMotor;
    @FXML
    private TableColumn<Modelo, String> colunaPotencia;
    @FXML
    private TableColumn<Modelo, String> colunaAnoLancamento;
    @FXML
    private TableColumn<Modelo, String> colunaTipoCombustivel;
    @FXML
    private TableColumn<Modelo, String> colunaNumeroPortas;
    @FXML
    private TableColumn<Modelo, String> colunaCodigoMarcaModelo;

// MARCA
    @FXML
    private TextField codigoMarca;
    @FXML
    private TextField cnpj;
    @FXML
    private TextField razaoSocial;
    @FXML
    private TextField cep;
    @FXML
    private TextField ruaNumero;
    @FXML
    private TextField bairro;
    @FXML
    private TextField cidade;
    @FXML
    private TextField uf;
    @FXML
    private TextField pais;
    @FXML
    private TextField telefone;
    @FXML
    private TextField email;
    @FXML
    private TextField site;
    @FXML
    private TableView<Marca> tabelaMarca;
    @FXML
    private TableColumn<Marca, String> colunaCnpj;
    @FXML
    private TableColumn<Marca, String> colunaRazaoSocial;
    @FXML
    private TableColumn<Marca, String> colunaCep;
    @FXML
    private TableColumn<Marca, String> colunaRuaNumero;
    @FXML
    private TableColumn<Marca, String> colunaBairro;
    @FXML
    private TableColumn<Marca, String> colunaCidade;
    @FXML
    private TableColumn<Marca, String> colunaUf;
    @FXML
    private TableColumn<Marca, String> colunaPais;
    @FXML
    private TableColumn<Marca, String> colunaTelefone;
    @FXML
    private TableColumn<Marca, String> colunaEmail;
    @FXML
    private TableColumn<Marca, String> colunaSite;
    @FXML
    private TableColumn<Marca, String> colunaCodigoMarca;

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
        colunaCodigoModeloVeiculo.setCellValueFactory(new PropertyValueFactory<>("codigoModelo"));
        colunaModelo.setCellValueFactory(new PropertyValueFactory<>("nomeModelo"));
        colunaMarca.setCellValueFactory(new PropertyValueFactory<>("nomeMarca"));

// MODELO:
        colunaCodigoModelo.setCellValueFactory(new PropertyValueFactory<>("idModelo"));
        colunaNomeModelo.setCellValueFactory(new PropertyValueFactory<>("nomeModelo"));
        colunaMotor.setCellValueFactory(new PropertyValueFactory<>("motor"));
        colunaPotencia.setCellValueFactory(new PropertyValueFactory<>("potencia"));
        colunaAnoLancamento.setCellValueFactory(new PropertyValueFactory<>("anoLancamento"));
        colunaTipoCombustivel.setCellValueFactory(new PropertyValueFactory<>("tipoCombustivel"));
        colunaNumeroPortas.setCellValueFactory(new PropertyValueFactory<>("numeroPortas"));
        colunaCodigoMarcaModelo.setCellValueFactory(new PropertyValueFactory<>("codigoMarcaModelo"));

// MARCA:
        colunaCodigoMarca.setCellValueFactory(new PropertyValueFactory<>("idMarca"));
        codigoMarca.setDisable(true); // não habilitar o campo do código da marca para adicionar/edição
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
                    codigoModelo.setText(String.valueOf(veiculo.getCodigoModelo()));
                    codigoModelo.setDisable(true);
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
                    codigoMarcaModelo.setText(modelo.getCodigoMarcaModelo());
                    codigoMarcaModelo.setDisable(true); // Desabilitar o campo Código do Veículo para edição ou exclusão
                    nomeModelo.setText(modelo.getNomeModelo());
                    motor.setText(modelo.getMotor());
                    potencia.setText(modelo.getPotencia());
                    anoLancamento.setText(modelo.getAnoLancamento());
                    anoLancamento.setDisable(true); // Desabilitar o campo Ano do Lançamento para edição ou exclusão
                    tipoCombustivel.setText(modelo.getTipoCombustivel());
                    numeroPortas.setText(modelo.getNumeroPortas());
                    numeroPortas.setDisable(true); // Desabilitar

                    index = modelo.getIdModelo();

                    // Alerta para alterar o modelo
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
                    codigoMarca.setDisable(true);
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

// VEÍCULO: ------------------------------------
    public void executarSalvarNoVeiculo() {
        Alert alertInclusao = new Alert(Alert.AlertType.CONFIRMATION);
        alertInclusao.setTitle("Confirmação de inclusão");
        alertInclusao.setHeaderText("Confirmar inclusão do veículo?");

        Optional<ButtonType> retornoAlerta = alertInclusao.showAndWait();

            try {
                if (retornoAlerta.get() != null && retornoAlerta.get() == ButtonType.OK) {
                    Veiculo veiculo = new Veiculo();
                    veiculo.setCodigoModelo(codigoModelo.getText());
                    veiculo.setChassi(chassi.getText()); // para mostrar as informações que estão na linha que pertecem a coluna documento da tabela
                    veiculo.setPlaca(placa.getText());
                    veiculo.setCorVeiculo(corVeiculo.getText());
                    veiculo.setQuilometragem(quilometragem.getText());

                    if (chassi.getText().isEmpty()) {
                        alertaDeErroOuInvalido
                            ("Campo obrigatório", "É obrigatório informar o chassi!",
                               "");
                    } else if (placa.getText().isEmpty()) {
                        alertaDeErroOuInvalido
                                ("Campo obrigatório", "É obrigatório informar a placa!",
                                        "");
                    } else if (corVeiculo.getText().isEmpty()) {
                        alertaDeErroOuInvalido
                                ("Campo obrigatório", "É obrigatório informar a cor do veículo!", "");
                    } else if (quilometragem.getText().isEmpty()) {
                        alertaDeErroOuInvalido
                                ("Campo obrigatório", "É obrigatório informar a quilometragem!", "");
                    } else if (!veiculo.getPlaca().matches("[a-zA-Z0-9]{7}")) { // Aceita letras e números com 7 dígitos
                        alertaDeErroOuInvalido("Erro", "Placa inválida.",
                           "Confira se colocou letars e números, precisa ter exatamente 7 dígitos");
                    } else if (!veiculo.getQuilometragem().matches("[0-9]{0,10}")) { // expressão regular
                        alertaDeErroOuInvalido
                                ("Erro", "Quilometragem inválida, somente números.",
                                        "Precisa ter no máximo 10 dígitos");
                    } else if (index < 0) {
                        if (VeiculoService.buscarVeiculoPorChassi(veiculo.getChassi())) {
                            alertaRegistroExistenete("Chassi", chassi.getText());
                        } else if (VeiculoService.buscarVeiculoPorPlaca(veiculo.getPlaca())) {
                            alertaRegistroExistenete("Placa", placa.getText());
                        } else if(!ModeloService.saberSeExisteCodigoDoModelo(veiculo.getCodigoModelo())) {
                            alertaDeErroOuInvalido("Erro", "Código do modelo não existe",
                                    "Por favor, usar um código de modelo válido!");
                        } else {
                            VeiculoService.inserirVeiculo(veiculo); // INSERT
                            this.limparCamposDoVeiculo();
                        }
                    } else {
                        VeiculoService.atualizarVeiculo(index, veiculo); // UPDATE
                        index = -1;
                        this.limparCamposDoVeiculo();
                    }
                }
                this.carregarlistaVeiculos();

            } catch (NumberFormatException e) {
                e.printStackTrace();
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
        codigoModelo.setText("");
        chassi.setText(""); // zera o campo
        placa.setText("");
        corVeiculo.setText("");
        quilometragem.setText("");
        codigoModelo.setDisable(false);
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
                modelo.setCodigoMarcaModelo(codigoMarcaModelo.getText()); // coluna código do modelo
                modelo.setNomeModelo(nomeModelo.getText());
                modelo.setMotor(motor.getText());
                modelo.setPotencia(potencia.getText());
                modelo.setAnoLancamento(anoLancamento.getText());
                modelo.setTipoCombustivel(tipoCombustivel.getText());
                modelo.setNumeroPortas(numeroPortas.getText());

                if (!modelo.getCodigoMarcaModelo().matches("[0-9]*")) { // expressão regular: [0-9]*, ela só permite números de 0 a 9
                    alertaDeErroOuInvalido
                            ("Erro", "Código do veículo inválido, somente números", "");
                } else if (!modelo.getAnoLancamento().matches("\\d{4}")) {
                    alertaDeErroOuInvalido("Erro", "Ano de Lançamento inválido",
                            "Confira se colocou apenas números ou somente o ano (4 dígitos)");
                } else if (!modelo.getNumeroPortas().matches("[0-9]{1,2}")) {
                    alertaDeErroOuInvalido
                            ("Erro", "Número de portas inválido, somente números", "");
                } else if (codigoMarcaModelo.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo obrigatório", "É obrigatório informar o código da marca!",
                                    "");
                } else if (nomeModelo.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo obrigatório", "É obrigatório informar o nome do modelo!",
                                    "");
                } else if (motor.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo obrigatório", "É obrigatório informar o motor!",
                                    "");
                } else if (potencia.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo obrigatório", "É obrigatório informar a potência",
                                    "");
                } else if (anoLancamento.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo obrigatório", "É obrigatório informar o ano do lançamento!",
                                    "");
                } else if (tipoCombustivel.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo obrigatório", "É obrigatório informar o tipo do combustivel!", "");
                } else if (numeroPortas.getText().isEmpty()) {
                    alertaDeErroOuInvalido
                            ("Campo obrigatório", "É obrigatório informar o número de portas!", "");
                } else if (index < 0) {
                    // Verificar se o ID da marca existe, é no MarcaService o método
                    if(!MarcaService.saberSeExisteCodigoDaMarca(modelo.getCodigoMarcaModelo())) {
                    alertaDeErroOuInvalido("Erro", "Código da marca não existe",
                            "Por favor, usar um código de marca válido!");
                     }else {
                        ModeloService.inserirModelo(modelo);
                        this.limparCamposModelo();
                    }
                } else {
                    ModeloService.atualizarModelo(index, modelo);
                    index = -1; // precisa resetar o index para poder incluir um registro novo
                    this.limparCamposModelo();
                }
            }

            this.carregarlistaModelos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void executarExcluirNoModelo() {
        Alert alertExclusao = new Alert(Alert.AlertType.CONFIRMATION);
        alertExclusao.setTitle("Confirmação de Exclusão");
        alertExclusao.setHeaderText("Confirmar exclusão do modelo?");

        Optional<ButtonType> retornoAlerta = alertExclusao.showAndWait();

        try{
            if (retornoAlerta.get() != null && retornoAlerta.get() == ButtonType.CANCEL) {
                limparCamposModelo();
            } else if (index > -1) {
                ModeloService.deletarModelo(index);
                this.carregarlistaModelos();
                index = -1;
                this.limparCamposModelo();
            }
        } catch (Exception e) {
           System.out.println("Não foi possivel excluir");
        }






    }
    public void carregarlistaModelos() {
        // Trazer o método da classe ModeloService
        tabelaModelo.getItems().remove(0, tabelaModelo.getItems().size());
        List<Modelo> modeloList = ModeloService.carregarModelos();
        tabelaModelo.getItems().addAll(modeloList);
    }
    public void limparCamposModelo() {
        codigoMarcaModelo.setText("");
        nomeModelo.setText(""); // zera o campo
        potencia.setText("");
        motor.setText("");
        anoLancamento.setText("");
        tipoCombustivel.setText("");
        numeroPortas.setText("");
        codigoMarcaModelo.setDisable(false); // Habilitar novamento o campo
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
                codigoMarca.setDisable(true);
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

                if (cnpj.getText().isEmpty()) {
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
                } else if (index < 0) {
                    // verificar se o ID de modelo existe
                    if (MarcaService.buscarMarcaPorCnpj(marca.getCnpj())) {
                        alertaRegistroExistenete("CNPJ", cnpj.getText());
                    } else {
                        MarcaService.inserirMarca(marca);
                        this.limparCamposMarca();
                    }
                } else {
                    MarcaService.atualizarMarca(index, marca);
                    index = -1; // precisa resetar o index para poder incluir um registro novo
                    this.limparCamposMarca();
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