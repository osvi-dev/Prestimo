package prestimo.models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;

public class DashboardModel {
    private final BooleanProperty buyProperty = new SimpleBooleanProperty(false);

   public DashboardModel(){

    }

    public ObservableBooleanValue getBuyProperty(){
        return this.buyProperty;
    }
    public void setBuyProperty(boolean value){
        this.buyProperty.set(value);
    }

    

}