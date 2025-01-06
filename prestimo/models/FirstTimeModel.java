package prestimo.models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableStringValue;

public class FirstTimeModel {
    private  final BooleanProperty tokenButtonDisabledProperty = new SimpleBooleanProperty(false);
    private final StringProperty tokenProperty = new SimpleStringProperty();
   
    public FirstTimeModel(){

    }

    public ObservableBooleanValue  getTokenButtonDisabledProperty(){
        return this.tokenButtonDisabledProperty;
    }
    public void setTokenButtonDisabledProperty(boolean value){
        this.tokenButtonDisabledProperty.set(value);
    }

    public StringProperty getTokenProperty(){
        return this.tokenProperty;
    }

    public void setTokenProperty(String text){
        this.tokenProperty.set(text);
    }

    
    
}
