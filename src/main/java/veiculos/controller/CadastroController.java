package veiculos.controller;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
@Component
@FxmlView("/main.fxml") // para lincar com o arquivo "main.fxml"
public class CadastroController {
    /*
    @FXML
    private TextField documento;
    @FXML
    private TextField nome;
    @FXML
    private TextField rg;
    @FXML
    private TextField email;
    @FXML
    private TextField telefone;
    @FXML
    private TextField codigoCliente;
    @FXML
    private TextField cep;
    @FXML
    private TextField rua;
    @FXML
    private TextField numero;
    @FXML
    private TextField bairro;
    @FXML
    private TextField cidade;
    @FXML
    private TextField estado;
    @FXML
    private TableView<Clientes> tabelaClientes; // <> se usa para definir um tipo
    @FXML
    private TableColumn<Clientes, Integer> colunaIdCliente; // <> se usa para definir um tipo
    @FXML
    private TableColumn<Clientes, String> colunaDocumento; // <> se usa para definir um tipo
    @FXML
    private TableColumn<Clientes, String> colunaNome; // <> se usa para definir um tipo
    @FXML
    private TableColumn<Clientes, String> colunaRg;
    @FXML
    private TableColumn<Clientes, String> colunaEmail; // <> se usa para definir um tipo
    @FXML
    private TableColumn<Clientes, String> colunaTelefone; // <> se usa para definir um tipo
    @FXML
    private TableView<Enderecos> tabelaEnderecos; // <> se usa para definir um tipo
    @FXML
    private TableColumn<Enderecos, String> colunaCodigoCliente; // <> se usa para definir um tipo
    @FXML
    private TableColumn<Enderecos, String> colunaCep; // <> se usa para definir um tipo
    @FXML
    private TableColumn<Enderecos, String> colunaRua; // <> se usa para definir um tipo
    @FXML
    private TableColumn<Enderecos, String> colunaNumero;
    @FXML
    private TableColumn<Enderecos, String> colunaBairro; // <> se usa para definir um tipo
    @FXML
    private TableColumn<Enderecos, String> colunaCidade; // <> se usa para definir um tipo
    @FXML
    private TableColumn<Enderecos, String> colunaEstado; // <> se usa para definir um tipo
    private int index = -1;

    // ======= Cliente ========
    // Método para dizer para o JavaFX ... pesquisar ...
    @FXML
    public void initialize() {
        colunaIdCliente.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaDocumento.setCellValueFactory(new PropertyValueFactory<>("documento"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaRg.setCellValueFactory(new PropertyValueFactory<>("rg"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));

        colunaCodigoCliente.setCellValueFactory(new PropertyValueFactory<>("codigoCliente")); // é o nome da variavel, não do banco de dados
        colunaCep.setCellValueFactory(new PropertyValueFactory<>("cep"));
        colunaRua.setCellValueFactory(new PropertyValueFactory<>("rua"));
        colunaNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colunaBairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
        colunaCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        colunaEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        // Trazer o método da classe ClienteService
        this.carregarlistaClientes();
        this.carregarlistaEnderecos();

        tabelaClientes.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent evt) {
                if (evt.getClickCount() == 2) { // quantidades de cliques para acionar, nesse caso dois cliques no evento
                    Clientes cliente = tabelaClientes.getSelectionModel().getSelectedItem(); // pegar o item que foi selecionado e sua posição
                    documento.setText(cliente.getDocumento());
                    documento.setDisable(true); // Desabilitar o campo documento para edição ou exclusão
                    nome.setText(cliente.getNome());
                    nome.setDisable(true); // Desabilitar o campo nome para edição ou exclusão
                    rg.setText(cliente.getRg());
                    email.setText(cliente.getEmail());
                    telefone.setText(cliente.getTelefone());

                    index = cliente.getId();

                    // Alerta para alterar
                    Alert alertAlterar = new Alert(Alert.AlertType.CONFIRMATION);
                    alertAlterar.setTitle("Confirmação de alterar");
                    alertAlterar.setHeaderText("Confirmar alteração do cliente?");
                    Optional<ButtonType> retornoAlerta = alertAlterar.showAndWait();
                }
            }
        });

        tabelaEnderecos.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent evt) {
                if (evt.getClickCount() == 2) { // quantidades de cliques para acionar, nesse caso dois cliques no evento
                    Enderecos endereco = tabelaEnderecos.getSelectionModel().getSelectedItem(); // pegar o item que foi selecionado e sua posição
                    codigoCliente.setText(String.valueOf(endereco.getCodigoCliente()));
                    codigoCliente.setDisable(true); // Desabilitar o campo Código Cliente para edição ou exclusão
                    cep.setText(endereco.getCep());
                    rua.setText(endereco.getRua());
                    numero.setText(String.valueOf(endereco.getNumero()));
                    bairro.setText(endereco.getBairro());
                    cidade.setText(endereco.getCidade());
                    estado.setText(endereco.getEstado());

                    index = endereco.getIdEndereco();

                    // Alerta para alterar
                    Alert alertAlterar = new Alert(Alert.AlertType.CONFIRMATION);
                    alertAlterar.setTitle("Confirmação de alterar");
                    alertAlterar.setHeaderText("Confirmar alteração do endereço?");
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
