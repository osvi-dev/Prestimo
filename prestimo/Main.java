package prestimo;


import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import prestimo.controllers.MainController;

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
