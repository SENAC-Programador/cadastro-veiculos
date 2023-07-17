package veiculos;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import java.net.URL;
public class JavaFxApplication extends Application {
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        this.applicationContext = new SpringApplicationBuilder()
                .sources(CadastroVeiculoApp.class).run(args); // Classe Main do projeto
    }

    @Override
    public void start(Stage estagio) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        URL urlDoXml = getClass().getResource("/main.fxml");
        loader.setLocation(urlDoXml);
        Parent root = loader.load();

        estagio.setScene(new Scene(root));
        estagio.setTitle("Cadastro Veículo");
        estagio.show();
    }
}
