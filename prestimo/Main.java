package prestimo;


import java.util.Map;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import prestimo.controllers.MainController;

public class Main extends Application {
    public static SimpleDoubleProperty height = new SimpleDoubleProperty(); 
    public static SimpleDoubleProperty width  =new SimpleDoubleProperty(); 
    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
      Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();

        // Configurar el tamaño del Stage para ajustarse a los límites visuales
        primaryStage.setMinWidth(1000); // Mínimo ancho permitido
        primaryStage.setMinHeight(568); // Mínimo alto permitido

        primaryStage.setMaximized(true);

        Main.width.bind(primaryStage.widthProperty());
        Main.height.bind(primaryStage.heightProperty());
        primaryStage.setScene(new Scene(new MainController().getView()));
        primaryStage.show();
    }
}
