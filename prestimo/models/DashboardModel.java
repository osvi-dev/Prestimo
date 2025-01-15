package prestimo.models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Region;
import javafx.stage.Screen;
import prestimo.Main;

public class DashboardModel {
    private final BooleanProperty buyProperty = new SimpleBooleanProperty(false);

    
    public final SimpleDoubleProperty width = new SimpleDoubleProperty(0);
    public final SimpleDoubleProperty height = new SimpleDoubleProperty(0);

    public final SimpleDoubleProperty widthSideBar = new SimpleDoubleProperty(0);
    public final SimpleDoubleProperty heightSideBar = new SimpleDoubleProperty(0);

    // Logo Container
    public final SimpleDoubleProperty logoContainer = new SimpleDoubleProperty(0);

    //Options Container
    public final SimpleDoubleProperty optionsContainer = new SimpleDoubleProperty(0);


    //Settings container
    public final SimpleDoubleProperty settingsContainerH =new SimpleDoubleProperty(0); 

   public DashboardModel(){
       width.bind(Main.width);
       height.bind(Main.height);
        //System.out.println(settingsContainerH.get());
        //setValues(Main.width, Main.height);
        
    }
     

    public ObservableBooleanValue getBuyProperty(){
        return this.buyProperty;
    }
    public void setBuyProperty(boolean value){
        this.buyProperty.set(value);
    }

    

}