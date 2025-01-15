package prestimo.views;

import java.util.HashMap;
import java.util.function.Consumer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
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
        results.prefHeightProperty().bind(model.height);
        results.prefWidthProperty().bind(model.width);
       results.setStyle("-fx-background-color: #3498db;"); 
       results.setOnMouseClicked(event -> {
        System.out.println("Pane clickeado!");
        System.out.println("Alto: "+results.getHeight()+"\n"+
        "Ancho: "+results.getWidth());
    });
       results.getStylesheets().add("prestimo/views/styles/dashboard.css");
        return results;
    }
   

    private Node createMainCointainer(){
        HBox container = new HBox(createSideBarContainer(), createMainRigthContainer());
        Responsive.bindingToParent(container, 1, 1);
       
        return container;
    }
    //SideBar --------------------------------------

    

    private Node createSideBarContainer(){
        VBox container = new VBox(createLogoContainer(),createOptionsContainer(),createSettingsContainer());
      
        container.getStyleClass().add("sidebar");
        Responsive.bindingToParent(container, 0.15, 1);

        container.setOnMouseClicked(event -> {
            System.out.println("SideBar clickeado!");
            System.out.println("Alto: "+container.getHeight()+"\n"+
            "Ancho: "+container.getWidth());
        });
        return container;
    }
    //Logo Container
    private Node createLogoContainer(){
        VBox container = new VBox();
        Responsive.bindingToParent(container, 1, 0.1);
        container.setStyle("-fx-background-color:rgb(0, 203, 102);"); 
        container.setOnMouseClicked(event -> {
            System.out.println("LOGO clickeado!");
            System.out.println("Alto: "+container.getHeight()+"\n"+
            "Ancho: "+container.getWidth());
        });
        return container;
    }


    //Options Container 
    private Node createOptionsContainer(){
        VBox container = new VBox(createButtonsContainer());
        Responsive.bindingToParent(container, 1, 0.8);
        container.setStyle("-fx-background-color:rgb(28, 61, 95);"); 
        container.setOnMouseClicked(event -> {
            System.out.println("OPTIONS clickeado!");
            System.out.println("Alto: "+container.getHeight()+"\n"+
            "Ancho: "+container.getWidth());
        });
        return container;
    }

    //Setting Container
    private Node createSettingsContainer(){
        VBox container = new VBox();
      Responsive.bindingToParent(container, 1, 0.1);
        container.setStyle("-fx-background-color:rgb(26, 27, 28);"); 
        container.setOnMouseClicked(event -> {
            System.out.println("SETTINGS clickeado!");
            System.out.println("Alto: "+container.getHeight()+"\n"+
            "Ancho: "+container.getWidth());
        });
        return container;
    }







    private Node createButtonsContainer(){
        VBox container = new VBox(
        createBuyButton(),
        createSaleButton(),
        createLoanButton()
        );
        Responsive.bindingToParent(container, 1, 1);
        container.setSpacing(5);

        return container;
    }

    private Node createBuyButton(){
        VBox button = new VBox( 
            innerButtonContainer("Compra","prestimo/img/buy.png")
        );
        button.setAlignment(Pos.CENTER);
        Responsive.bindingToParentWidth(button, 1);
        button.setPrefHeight(40);
       button.getStyleClass().add("sidebar-button");
            // Manejar el evento de clic
        button.setOnMouseClicked(evt -> {
            model.setBuyProperty(true);
            this.buyView().accept(() -> {
                // Acción adicional aquí
            });
        });
        return button;

    }
    private Node createSaleButton(){
        VBox button = new VBox(innerButtonContainer("Venta","prestimo/img/sale.png") );
        button.setAlignment(Pos.CENTER);
        Responsive.bindingToParentWidth(button, 1);
        button.setPrefHeight(40);
        button.getStyleClass().add("sidebar-button");
            // Manejar el evento de clic
        button.setOnMouseClicked(evt -> {
           
        });
        return button;
    }

    private Node createLoanButton(){
        VBox button = new VBox( innerButtonContainer("Prestamo","prestimo/img/loan.png"));
        button.setAlignment(Pos.CENTER);
        Responsive.bindingToParentWidth(button, 1);
        button.setPrefHeight(40);
        button.getStyleClass().add("sidebar-button");
            // Manejar el evento de clic
        button.setOnMouseClicked(evt -> {
          
        });
        return button;

    }
    private Node innerButtonContainer(String text, String url){
        Label title =new Label(text);
        title.getStyleClass().add("sidebar-button-text");
        HBox container = new HBox(createIcon(url), title);
       
        container.setAlignment(Pos.CENTER);
        container.setSpacing(20);
        return container;
    }
    private Node createIcon(String url){
        VBox container = new VBox();
        Image image = new Image(url,
       50, 30, false, true);
       BackgroundImage backgroundImage = new BackgroundImage(
            image,
            BackgroundRepeat.NO_REPEAT, // Repetir en eje X
            BackgroundRepeat.NO_REPEAT, // Repetir en eje Y
            BackgroundPosition.DEFAULT,  // Posicionar en el centro
            new BackgroundSize(
               BackgroundSize.AUTO,     // Ancho automático
               BackgroundSize.AUTO,     // Alto automático
                true,                   // Usar ancho absoluto
                true,                   // Usar alto absoluto
                true,                    // Ajustar para cubrir
                false                    // No recortar
            )
            );
           
        container.setMinWidth(20);
        container.setMinHeight(15);
        container.setBackground(new Background(backgroundImage));
       
        
        return container;
    }
   


    //---------------------------------------------

    //Rigth Content --------------------------------
    private Node createMainRigthContainer(){
        this.buyViewBuilder.visibleProperty().bind(model.getBuyProperty());
        HBox container = new HBox(buyViewBuilder);
         HBox.setHgrow(container, Priority.ALWAYS);
         container.setMaxWidth(Double.MAX_VALUE);
        return container;
    }



    //------------------------------------------------
    
    //Services---------------------------------
    private Consumer<Runnable> buyView (){
        return this.map.get("buyView");
    }
    //-----------------------------------------
}
