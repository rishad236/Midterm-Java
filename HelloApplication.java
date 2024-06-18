package mid.app.midterm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Student Records");
        stage.setScene(scene);
        stage.show();

        // Load and populate TableView with 1000 Student objects
        Controller controller = fxmlLoader.getController();
        controller.initializeTableView();
    }

    public static void main(String[] args) {
        launch();
    }
}
