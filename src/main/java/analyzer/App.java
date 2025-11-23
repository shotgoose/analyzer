package analyzer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;

public class App extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		FXMLLoader loader = new FXMLLoader(
			getClass().getResource("/dash.fxml")
		);

		Parent root = loader.load();

		Scene scene = new Scene(root, 1920, 1080);

		// CSS (FXML already references style.css, but you can add more if needed)
		// scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

		stage.setTitle("Data Analyzer");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
    
}
