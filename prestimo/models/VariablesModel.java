package prestimo.models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class VariablesModel {
    private final SimpleDoubleProperty security_value = new SimpleDoubleProperty(100); // Setteable   
    private final SimpleDoubleProperty revenue_gr = new SimpleDoubleProperty(100); //Setteable 
    public VariablesModel(){

    }
    public DoubleProperty security(){
        return this.security_value;
    }

    public DoubleProperty revenue(){
        return this.revenue_gr;
    }
}
