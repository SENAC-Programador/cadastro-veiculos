package veiculos.controller;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import veiculos.model.Marcas;
import veiculos.model.Modelos;
import veiculos.model.Veiculos;

import java.util.List;
import java.util.Optional;
@Component
@FxmlView("/main.fxml") // para lincar com o arquivo "main.fxml"
public class CadastroController {
    @FXML
    private TextField idVeiculo;
    // @FXML
    // private TextField dataCadastroVeiculo;
    @FXML
    private TextField chassi;
    @FXML
    private TextField placa;
    @FXML
    private TextField ano;
    @FXML
    private TextField cor;
    @FXML
    private TextField quilometragem;
    @FXML
    private TableView<Veiculos> tabelaVeiculos; // <> se usa para definir um tipo
    @FXML
    private TableColumn<Veiculos, Integer> colunaIdVeiculo; // <> se usa para definir um tipo
    // @FXML
    // private TableColumn<Veiculos, Date> colunaDataCadastroVeiculo;
    @FXML
    private TableColumn<Veiculos, String> colunaChassi;
    @FXML
    private TableColumn<Veiculos, String> colunaPlaca;
    @FXML
    private TableColumn<Veiculos, String> colunaAno;
    @FXML
    private TableColumn<Veiculos, String> colunaCor;
    @FXML
    private TableColumn<Veiculos, String> colunaQuilometragem;

    // MARCA
    @FXML
    private TextField idMarca;
    //private TextField codigoVeiculo;
    @FXML
    private TextField nomeMarca;
    @FXML
    private TextField paisOrigem;
    @FXML
    private TextField anoFundacaoMarca;
    @FXML
    private TextField endereco;
    @FXML
    private TextField telefone;
    @FXML
    private TextField email;
    @FXML
    private TextField site;
    @FXML
    private TableView<Marcas> tabelaMarcas; // <> se usa para definir um tipo
    @FXML
    private TableColumn<Marcas, Integer> colunaIdMarca;
    @FXML
    private TableColumn<Marcas, Integer> colunaCodigoVeiculo; // <> se usa para definir um tipo
    @FXML
    private TableColumn<Marcas, String> colunaNomeMarca;
    @FXML
    private TableColumn<Marcas, String> colunaPaisOrigem;
    @FXML
    private TableColumn<Marcas, String> colunaAnoFundacaoMarca;
    @FXML
    private TableColumn<Marcas, String> colunaEndereco;
    @FXML
    private TableColumn<Marcas, String> colunaTelefone;
    @FXML
    private TableColumn<Marcas, String> colunaEmail;
    @FXML
    private TableColumn<Marcas, String> colunaSite;

    // MODELO
    @FXML
    private TextField idModelo;
    //private TextField codigoMarca;
    //private TextField codigoVeiculo;
    @FXML
    private TextField nomeModelo;
    @FXML
    private TextField anoLancamento;
    @FXML
    private TextField combustivel;
    @FXML
    private TextField numeroPortas;
    @FXML
    private TableView<Modelos> tabelaModelos;
    @FXML
    private TableColumn<Modelos, Integer> colunaIdModelo;
    // @FXML
    // private TableColumn<Modelos, Integer> colunaCodigoMarca;
    // @FXML
    // private TableColumn<Modelos, Integer> colunaCodigoVeiculo;
    @FXML
    private TableColumn<Modelos, String> colunaNomeModelo;
    @FXML
    private TableColumn<Modelos, String> colunaAnoLancamento;
    @FXML
    private TableColumn<Modelos, String> colunaCombustivel;
    @FXML
    private TableColumn<Modelos, Integer> colunaNumeroPortas;

    private int index = -1;

    // ======= Veiculo ========
    // Método para dizer para o JavaFX ... pesquisar ...
    @FXML
    public void initialize() {
        colunaIdVeiculo.setCellValueFactory(new PropertyValueFactory<>("idVeiculo")); // é o nome da variavel, não do banco de dados
        colunaChassi.setCellValueFactory(new PropertyValueFactory<>("chassi"));
        colunaPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        colunaAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
        colunaCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        colunaQuilometragem.setCellValueFactory(new PropertyValueFactory<>("quilometragem"));

        // MARCA
        colunaIdMarca.setCellValueFactory(new PropertyValueFactory<>("idMarca"));
        //colunaCodigoVeiculo.setCellValueFactory(new PropertyValueFactory<>("codigoVeiculo"));
        colunaNomeMarca.setCellValueFactory(new PropertyValueFactory<>("nomeMarca"));
        colunaPaisOrigem.setCellValueFactory(new PropertyValueFactory<>("paisOrigem"));
        colunaAnoFundacaoMarca.setCellValueFactory(new PropertyValueFactory<>("anoFundacaoMarca"));
        colunaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colunaSite.setCellValueFactory(new PropertyValueFactory<>("site"));

        // MODELO
        colunaIdModelo.setCellValueFactory(new PropertyValueFactory<>("idModelo"));
        // colunaCodigoMarca.setCellValueFactory(new PropertyValueFactory<>("codigoMarca"));
        // colunaCodigoVeiculo.setCellValueFactory(new PropertyValueFactory<>("codigoVeiculo"));
        colunaNomeModelo.setCellValueFactory(new PropertyValueFactory<>("nomeModelo"));
        colunaAnoLancamento.setCellValueFactory(new PropertyValueFactory<>("anoLancamento"));
        colunaCombustivel.setCellValueFactory(new PropertyValueFactory<>("combustivel"));
        colunaNumeroPortas.setCellValueFactory(new PropertyValueFactory<>("numeroPortas"));

        // Trazer o método da classe ClienteService
        this.carregarlistaVeiculos();
        this.carregarlistaMarcas();
        this.carregarlistaModelos();

        // VEÍCULO
        tabelaVeiculos.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent evt) {
                if (evt.getClickCount() == 2) { // quantidades de cliques para acionar, nesse caso dois cliques no evento
                    Veiculos veiculo = tabelaVeiculos.getSelectionModel().getSelectedItem(); // pegar o item que foi selecionado e sua posição
                    chassi.setText(veiculo.getChassi());
                    chassi.setDisable(true); // Desabilitar o campo "chassi" para edição ou exclusão
                    placa.setText(veiculo.getPlaca());
                    placa.setDisable(true); // Desabilitar o campo "placa" para edição ou exclusão
                    ano.setText(veiculo.getAno());
                    cor.setText(veiculo.getCor());
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

        // MARCA
        tabelaMarcas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent evt) {
                if (evt.getClickCount() == 2) { // quantidades de cliques para acionar, nesse caso dois cliques no evento
                    Marcas marca = tabelaMarcas.getSelectionModel().getSelectedItem(); // pegar o item que foi selecionado e sua posição
                    //codigoVeiculo.setText(String.valueOf(marca.getCodigoVeiculo()));
                    //codigoVeiculo.setDisable(true); // Desabilitar o campo "Código Veículo" para edição ou exclusão
                    nomeMarca.setText(marca.getNomeMarca());
                    paisOrigem.setText(marca.getPaisOrigem());
                    anoFundacaoMarca.setText(marca.getAnoFundacaoMarca());
                    endereco.setText(marca.getEndereco());
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

        // MODELO
        tabelaModelos.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    Modelos modelo = tabelaModelos.getSelectionModel().getSelectedItem(); // pegar o item que foi selecionado e sua posição
                    idModelo.setText(String.valueOf(modelo.getIdModelo()));
                    //codigoMarca.setText(String.valueOf(modelo.getCodigoMarca()));
                    //codigoVeiculo.setText(String.valueOf(modelo.getCodigoVeiculo()));
                    nomeModelo.setText(modelo.getNomeModelo());
                    anoLancamento.setText(modelo.getAnoLancamento());
                    combustivel.setText(modelo.getCombustivel());
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

    // Método para fazer funcionar o botão "OK" do JavaFX
    public void executarSalvarCliente() {
        Alert alertInclusao = new Alert(Alert.AlertType.CONFIRMATION);
        alertInclusao.setTitle("Confirmação de inclusão");
        alertInclusao.setHeaderText("Confirmar inclusão do cliente?");
        Optional<ButtonType> option = alertInclusao.showAndWait();

        if (option.get() != null && option.get() == ButtonType.OK) {
            Clientes cliente = new Clientes();
            cliente.setDocumento(documento.getText()); // para mostrar as informações que estão na linha que pertecem a coluna documento da tabela
            cliente.setNome(nome.getText()); // nome.setEnabled(false); para desabilitar o campo nome
            cliente.setRg(rg.getText());
            cliente.setEmail(email.getText());
            cliente.setTelefone(telefone.getText());
            try {
                Alert alertaObrig = new Alert(Alert.AlertType.ERROR);
                alertaObrig.setTitle("Campo obrigatório");
                Alert alertaInval = new Alert(Alert.AlertType.ERROR);
                alertaInval.setTitle("Erro");
                // Colocar na classe controller para não aceitar letras no campo documento
                if (documento.getText().isEmpty()) {
                    alertaObrig.setHeaderText("É obrigatório informar o documento!");
                    alertaObrig.show(); // precisa para mostrar a tela do alerta
                } else if (!cliente.getDocumento().matches("[0-9]*")) { // expressão regular: [0-9]*, ela só permite números de 0 a 9
                    alertaInval.setHeaderText("Documento inválido, somente números.");
                    alertaInval.show();
                }  else if (nome.getText().isEmpty()) {
                    alertaObrig.setHeaderText("É obrigatório informar o nome!");
                    alertaObrig.show(); // precisa para mostrar a tela do alerta
                } else if (!cliente.getRg().matches("[0-9]*")) { // expressão regular: [0-9]*, ela só permite números de 0 a 9
                    alertaInval.setHeaderText("RG inválido, somente números.");
                    alertaInval.show();
                } else if (!cliente.getTelefone().matches("[0-9]*")) { // expressão regular: [0-9]*, ela só permite números de 0 a 9
                    alertaInval.setHeaderText("Telefone inválido, somente números");
                    alertaInval.show();
                } else if (index < 0) {
                    if (ClienteService.buscarClienteByDocumento(cliente.getDocumento())) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Alerta");
                        alert.setHeaderText("Documento " + documento.getText() + " já existe na base.");
                        alert.show(); // precisa para mostrar a tela do alerta
                    } else {
                        ClienteService.inserirCliente(cliente);
                    }
                    // Substituido --> tabelaClientes.getItems().add(cliente);
                } else {
                    ClienteService.atualizarCliente(index, cliente); // Substituido --> tabelaClientes.getItems().set(index, cliente); -->
                    index = -1;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            this.carregarlistaClientes();
            this.limparCampos();
        }
    }
    public void executarExcluirCliente() {
        Alert alertExclusao = new Alert(Alert.AlertType.CONFIRMATION);
        alertExclusao.setTitle("Confirmação de Exclusão");
        alertExclusao.setHeaderText("Confirmar exclusão do cliente?");
        Optional<ButtonType> retornoAlerta = alertExclusao.showAndWait();
        if (index > -1) {
            ClienteService.deletarCliente(index);
            this.carregarlistaClientes();
            index = -1;
            this.limparCampos();
        }
    }
    public void carregarlistaClientes() {
        // Trazer o método da classe ClienteService
        tabelaClientes.getItems().remove(0, tabelaClientes.getItems().size());
        List<Clientes> cliList = ClienteService.carregarClientes();
        tabelaClientes.getItems().addAll(cliList);
    }
    public void limparCampos() {
        documento.setText("");
        nome.setText(""); // zera o campo
        rg.setText("");
        email.setText("");
        telefone.setText("");
        documento.setDisable(false); // habilitar documento
        nome.setDisable(false); // habilitar nome
    }

    // ================= Endereco ==============================
    // Método para fazer funcionar o botão "OK" do JavaFX
    public void executarSalvarEndereco() {
        Alert alertInclusao = new Alert(Alert.AlertType.CONFIRMATION);
        alertInclusao.setTitle("Confirmação de Inclusão");
        alertInclusao.setHeaderText("Confirmar inclusão do endereço?");
        Optional<ButtonType> retornoAlerta = alertInclusao.showAndWait();

        try {
            if (retornoAlerta.get() != null && retornoAlerta.get() == ButtonType.OK) {

                Enderecos endereco = new Enderecos();
                // para mostrar as informações que estão na linha que pertecem as colunas da tabela
                endereco.setCodigoCliente(codigoCliente.getText()); // coluna código do cliente
                endereco.setCep(cep.getText()); // coluna CEP
                endereco.setRua(rua.getText()); // coluna Rua
                endereco.setNumero(numero.getText()); // coluna número
                endereco.setBairro(bairro.getText());
                endereco.setCidade(cidade.getText());
                endereco.setEstado(estado.getText());
                Alert alertObri = new Alert(Alert.AlertType.ERROR);
                alertObri.setTitle("Campo obrigatório");
                Alert alertInvalido = new Alert(Alert.AlertType.ERROR);
                alertInvalido.setTitle("Erro");

                if (codigoCliente.getText().isEmpty()) {
                    alertObri.setHeaderText("É obrigatório informar o código do cliente!");
                    alertObri.show(); // precisa para mostrar a tela do alerta
                } else if (!endereco.getCodigoCliente().matches("[0-9]*")) { // expressão regular: [0-9]*, ela só permite números de 0 a 9
                    alertInvalido.setHeaderText("Código do cliente inválido, somente números");
                    alertInvalido.show();
                } else if (!endereco.getCep().matches("[0-9]*")) { // expressão regular: [0-9]*,
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
                    alertObri.show(); // precisa para mostrar a tela do alerta
                } else if (estado.getText().isEmpty()) {
                    alertObri.setHeaderText("É obrigatório informar a sigla do estado!");
                    alertObri.show(); // precisa para mostrar a tela do alerta
                } else if (index > -1) {
                    EndrecoService.atualizarEndereco(index, endereco);
                    index = -1; // precisa resetar o index, para poder incluir um registro novo
                } else {
                    EndrecoService.inserirEndereco(endereco);
                }
            }
            this.carregarlistaEnderecos();
            this.limparCamposEndereco();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void executarExcluirEndereco() {
        Alert alertExclusao = new Alert(Alert.AlertType.CONFIRMATION);
        alertExclusao.setTitle("Confirmação de Exclusão");
        alertExclusao.setHeaderText("Confirmar exclusão do endereço?");
        Optional<ButtonType> retornoAlerta = alertExclusao.showAndWait();
        if (index > -1) {
            EndrecoService.deletarEndereco(index);
            this.carregarlistaEnderecos();
            index = -1;
            this.limparCamposEndereco();
        }
    }
    public void carregarlistaEnderecos() {
        // Trazer o método da classe ClienteService
        tabelaEnderecos.getItems().remove(0, tabelaEnderecos.getItems().size());
        List<Enderecos> enderecoList = EndrecoService.carregarEnderecos();
        tabelaEnderecos.getItems().addAll(enderecoList);
    }
    public void limparCamposEndereco() {
        codigoCliente.setText("");
        cep.setText(""); // zera o campo
        rua.setText("");
        numero.setText("");
        bairro.setText("");
        cidade.setText("");
        estado.setText("");
        codigoCliente.setDisable(false); // habilitar o campo código cliente
    }

     */
}
