package prestimo.views;

import javafx.beans.InvalidationListener;
import javafx.scene.Parent;
import javafx.scene.layout.Region;

public class Responsive {
    

    public Responsive(){

    }


    public static void bindingToParent(Region container, double percentageW, double percentageH) {
     
        container.parentProperty().addListener((observable, oldParent, newParent) -> {
            if (newParent != null && newParent instanceof Region) {
                container.prefWidthProperty().bind(((Region) newParent).widthProperty().multiply(percentageW));
                container.prefHeightProperty().bind(((Region) newParent).heightProperty().multiply(percentageH));
          }
         });

    }

    public static void bindingToParentWidth(Region container, double percentageW) {
     
        container.parentProperty().addListener((observable, oldParent, newParent) -> {
            if (newParent != null && newParent instanceof Region) {
                container.prefWidthProperty().bind(((Region) newParent).widthProperty().multiply(percentageW));
                
          }
         });

    }

    public static void bindingToParent(Region container, double percentageH) {
     
        container.parentProperty().addListener((observable, oldParent, newParent) -> {
            if (newParent != null && newParent instanceof Region) {
        
                container.prefHeightProperty().bind(((Region) newParent).heightProperty().multiply(percentageH));
          }
         });

    }

}
