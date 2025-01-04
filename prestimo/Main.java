package prestimo;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import prestimo.controllers.MainController;
import prestimo.instalacion.EnviarToken;

public class Main extends Application {
    public static void main(String[] args) {
        
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(new MainController().getView()));
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}
