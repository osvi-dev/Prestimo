package prestimo.models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableStringValue;

public class LoginModel {
    private  final BooleanProperty loginButtonDisabledProperty = new SimpleBooleanProperty(false);
    private final StringProperty emailProperty = new SimpleStringProperty();
    private final StringProperty passwordProperty = new SimpleStringProperty();

    public LoginModel(){

    }

    public ObservableBooleanValue  getloginButtonDisabledProperty(){
        return this.loginButtonDisabledProperty;
    }
    public void setloginButtonDisabledProperty(boolean value){
        this.loginButtonDisabledProperty.set(value);
    }

    public StringProperty getEmailProperty(){
        return this.emailProperty;
    }

    public void setEmailProperty(String text){
        this.emailProperty.set(text);
    }

    
    public StringProperty getPasswordProperty(){
        return this.passwordProperty;
    }

    public void setPasswordProperty(String text){
        this.passwordProperty.set(text);
    }

}
