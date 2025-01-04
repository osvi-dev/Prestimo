package prestimo.models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class MainModel {

    private  final BooleanProperty loginProperty = new SimpleBooleanProperty(true);
   public MainModel(){

   }

   public BooleanProperty getLoginProperty(){
    return this.loginProperty;
   }
    
}
