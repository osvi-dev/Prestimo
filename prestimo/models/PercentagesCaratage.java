package prestimo.models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class PercentagesCaratage {
    private final SimpleDoubleProperty min_percentage = new SimpleDoubleProperty(0.7); 
    private final SimpleDoubleProperty inter_percentage = new SimpleDoubleProperty(0.8); 
    private final SimpleDoubleProperty max_percentage = new SimpleDoubleProperty(0.9); 
    private final SimpleDoubleProperty applied_percentage = new SimpleDoubleProperty(0); 
    public PercentagesCaratage(){

    }
    public DoubleProperty min(){
        return this.min_percentage;
    }
    public DoubleProperty inter(){
        return this.inter_percentage;
    }
    public DoubleProperty max(){
        return this.max_percentage;
    }
    public DoubleProperty applied(){
        return this.applied_percentage;
    }

}
