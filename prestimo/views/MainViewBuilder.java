package prestimo.views;

import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Builder;

public class MainViewBuilder implements Builder<Region> {
    private final Region loginContent ;
    public MainViewBuilder(Region loginContent){
        this.loginContent = loginContent;
    }

     @Override 
    public Region build(){
      
        StackPane results = (StackPane)this.createContent();



       return results;
    }

    private Node createContent(){
       
        return new StackPane(this.loginContent);
    }
}
