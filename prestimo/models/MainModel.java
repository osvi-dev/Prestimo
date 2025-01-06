package prestimo.models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class MainModel {

    private  final BooleanProperty loginProperty = new SimpleBooleanProperty(false);
    private  final BooleanProperty firstTimeProperty = new SimpleBooleanProperty(false);
    private  final BooleanProperty dashBoardProperty = new SimpleBooleanProperty(true);
   public MainModel(){

   }

   public BooleanProperty getLoginProperty(){
    return this.loginProperty;
   }

   public BooleanProperty getFirstTimeProperty(){
    return this.firstTimeProperty;
   }
   public BooleanProperty getDashboardProperty(){
    return this.dashBoardProperty;
   }
    
    
}
