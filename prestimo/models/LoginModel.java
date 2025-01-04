package prestimo.models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableBooleanValue;

public class LoginModel {
    private  final BooleanProperty loginButtonDisabledProperty = new SimpleBooleanProperty(false);
    

    public LoginModel(){

    }

    public ObservableBooleanValue  getloginButtonDisabledProperty(){
        return this.loginButtonDisabledProperty;
    }
    public void setloginButtonDisabledProperty(boolean value){
        this.loginButtonDisabledProperty.set(value);
    }


}
