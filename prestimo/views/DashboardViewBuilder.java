package prestimo.views;

import java.util.HashMap;
import java.util.function.Consumer;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.util.Builder;
import prestimo.models.DashboardModel;

public class DashboardViewBuilder implements Builder<Region> {

    private final DashboardModel model;
    private final HashMap<String, Consumer<Runnable>> map;
    private final Region buyViewBuilder;
       private final double leftContainerWidth =Screen.getPrimary().getBounds().getWidth()/2.5;
    private final double leftContainerHeight = Screen.getPrimary().getBounds().getHeight();
    private final double rigthContainerWidth =Screen.getPrimary().getBounds().getWidth()/2.5;
    private final double rigthContainerHeight = Screen.getPrimary().getBounds().getHeight();
    public DashboardViewBuilder(DashboardModel model, Region buyViewBuilder ,HashMap<String, Consumer<Runnable>> map){
        this.model = model;
        this.buyViewBuilder = buyViewBuilder;
        this.map = map;

    }

    @Override
    public Region build() {
        Pane results = new Pane(createMainCointainer());
       results.setStyle("-fx-background-color: #3498db;"); 
      
       results.getStylesheets().add("/dashboard.css");
        return results;
    }

    private Node createMainCointainer(){
        HBox container = new HBox(createSideBarContainer(), createMainRigthContainer());
        container.setMinWidth(this.leftContainerWidth);
        container.setMinHeight(this.leftContainerHeight);
        return container;
    }
    //SideBar --------------------------------------

    private Node createSideBarContainer(){
        VBox container = new VBox(
            createBuyButton(),
            createSaleButton(),
            createLoanButton()
        );
        container.getStyleClass().add("sidebar");

        return container;
    }

    private Node createBuyButton(){
        Button button = new Button("Compra");
        button.getStyleClass().add("sidebar-button");
        button.setOnAction(
            evt -> {
                model.setBuyProperty(true);
                this.buyView().accept(
                    ()-> {

                    }
                );
            }
        );
        return button;

    }
    private Node createSaleButton(){
        Button button = new Button("Venta");
        button.getStyleClass().add("sidebar-button");

        return button;

    }

    private Node createLoanButton(){
        Button button = new Button("Prestamo");
        button.getStyleClass().add("sidebar-button");

        return button;

    }


    //---------------------------------------------

    //Rigth Content --------------------------------
    private Node createMainRigthContainer(){
        this.buyViewBuilder.visibleProperty().bind(model.getBuyProperty());
        HBox container = new HBox(buyViewBuilder);
         
        return container;
    }



    //------------------------------------------------
    
    //Services---------------------------------
    private Consumer<Runnable> buyView (){
        return this.map.get("buyView");
    }
    //-----------------------------------------
}
