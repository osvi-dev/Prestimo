package prestimo.views;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public class BuyViewBuilder implements Builder<Region> {

    public BuyViewBuilder(){

    }

     @Override
    public Region build() {
        Pane results = new Pane(createMainCointainer());
       // results.setStyle("-fx-background-color: #3498db;"); 
    
      // results.getStylesheets().add("/login.css");

        return results;
    }

    private Node createMainCointainer(){
        HBox container = new HBox(createTitle());
        return container;
    }

    private Node createTitle(){
        Label label = new Label("COMPRA");
        return label;
    }

    
}
