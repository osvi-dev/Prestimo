package prestimo.views;

import java.util.HashMap;
import java.util.function.Consumer;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;
import prestimo.models.BuyModel;

public class BuyViewBuilder implements Builder<Region> {
    private final BuyModel model;
    private final   HashMap<String, Consumer<Runnable>> map;
    public BuyViewBuilder(BuyModel model,  HashMap<String, Consumer<Runnable>> map){
        this.model = model;
        this.map = map;
    }

     @Override
    public Region build() {
        VBox results = new VBox(createMainCointainer());
        results.getStylesheets().add("/compra.css");
        results.getStyleClass().add("build");
        Responsive.bindingToParent(results, 1,1);
       
        return results;
    }

    private Node createMainCointainer(){
        VBox container = new VBox(createTitle(), createKilatajeContainer());
        container.getStyleClass().add("main");
        Responsive.bindingToParent(container, 1,1);
        container.setPadding(new Insets(20,50,20,50));
        return container;
    }

    private Node createTitle(){
        Label label = new Label("COMPRA");
        return label;
    }

    private Node createKilatajeContainer(){
        VBox container = new VBox(createKilatajeTitle(),
        createKilatajeOptions(), 
        createPesoField(), 
        createCaratagePriceSelectorsContainer(),
        createCaratagePurchaseSelectorsContainer(),
        createCalculoButton());
        container.setSpacing(25);
        return container;
    }

    private Node createKilatajeTitle(){
        Label label = new Label("Selecciona el Kilataje");

        return label;
    }

    private Node createKilatajeOptions(){
        ComboBox<String> options = new ComboBox<>();
        options.getItems().addAll("8k","10k","12k","14k","16k","18k","20k","22k","24k");
        options.setMinWidth(100); // Ancho mínimo de 100 píxeles
        options.setMaxWidth(200);
        options.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                model.caratage().set(true);
                switch(newValue){
                    case "8k":
                    model.kilatajeProperty().set(8);
                    System.out.println( model.kilatajeProperty().get());
                    break;
                    case "10k":
                    model.kilatajeProperty().set(10);
                    System.out.println( model.kilatajeProperty().get());
                    break;
                    case "12k":
                    model.kilatajeProperty().set(12);
                    System.out.println( model.kilatajeProperty().get());
                    break;
                    case "14k":
                    model.kilatajeProperty().set(14);
                    System.out.println( model.kilatajeProperty().get());
                    break;
                    case "16k":
                    model.kilatajeProperty().set(16);
                    System.out.println( model.kilatajeProperty().get());
                    break;
                    case "18k":
                    model.kilatajeProperty().set(18);
                    System.out.println( model.kilatajeProperty().get());
                    break;
                    case "20k":
                    model.kilatajeProperty().set(20);
                    System.out.println( model.kilatajeProperty().get());
                    break;
                    case "22k":
                    model.kilatajeProperty().set(22);
                    System.out.println( model.kilatajeProperty().get());
                    break;
                    case "24k":
                    model.kilatajeProperty().set(24);
                    System.out.println( model.kilatajeProperty().get());
                    break;
                    default:
                    model.kilatajeProperty().set(0);
                    break;
                    
                }
                // Aquí puedes añadir lógica adicional según el valor seleccionado
            }
        });
        return options;
    }

    private Node createPesoField(){
        TextField field = new TextField();
            
        field.setMinWidth(100); // Ancho mínimo de 100 píxeles
        field.setMaxWidth(200);
        // Listener para actualizar el valor de pesoProperty() solo con entradas válidas
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                double valor = Double.parseDouble(newValue); // Intenta convertir el texto a un double
                model.pesoProperty().set(valor); // Actualiza la propiedad con el valor válido
                model.weight().set(true);
            } catch (NumberFormatException e) {
                // Si la entrada no es válida (no es un número), simplemente ignora la actualización
                model.pesoProperty().set(0.0); // Opcional: define un valor predeterminado como 0.0
            }
        });
        
    return field;
    }

    private Node createCaratagePriceSelectorsContainer(){

        HBox container = new HBox(
            createCaratagePriceMin(),
            createCaratagePriceInter(),
            createCaratagePriceMax()
            );

            container.setMinWidth(100); // Ancho mínimo de 100 píxeles
            container.setMaxWidth(200);

        return container;

    }
    private Node createCaratagePriceMin(){
        Button button = new Button("Minimo Kilataje");
        button.disableProperty().bind(model.carageSelectors());
        button.setOnAction(
            evt->{
                model.purchaseSelectors().set(false);
                model.percentagesCaratage().applied().set(
                model.percentagesCaratage().min().get()
                );
            });
        return button;
    }
    private Node createCaratagePriceInter(){
        Button button = new Button("Inter");
        button.disableProperty().bind(model.carageSelectors());
        button.setOnAction( 
            evt->{
                model.purchaseSelectors().set(false);
                model.percentagesCaratage().applied().set(
                model.percentagesCaratage().inter().get()
            );
        
        });
        return button;
    }
    private Node createCaratagePriceMax(){
        Button button = new Button("Maximo");
        button.disableProperty().bind(model.carageSelectors());
        button.setOnAction(
            evt->{
                model.purchaseSelectors().set(false);
                model.percentagesCaratage().applied().set(
                    model.percentagesCaratage().max().get()
                );
        });
        return button;
    }

    private Node createCaratagePurchaseSelectorsContainer(){
        HBox container = new HBox(
            createPurchasePriceMin(),
            createPurchasePriceInter(),
            createPurchasePriceMax()
            );
        
            container.setMinWidth(100); // Ancho mínimo de 100 píxeles
            container.setMaxWidth(200);
        return container;

    }
    private Node createPurchasePriceMin(){
        Button button = new Button("Minimo");
        button. disableProperty().bind(model.purchaseSelectors());
        button.setOnAction(
           evt->{
            model.calculateButton().set(false);
            model.percentagesPurchase().applied().set(
                model.percentagesPurchase().min().get()
            );
        });
        return button;
    }
    private Node createPurchasePriceInter(){
        Button button = new Button("Inter");
        button. disableProperty().bind(model.purchaseSelectors());
        button.setOnAction( evt->{
            model.calculateButton().set(false);
            model.percentagesPurchase().applied().set(
                model.percentagesPurchase().inter().get()
            );
        });
        return button;
    }

    private Node createPurchasePriceMax(){
        Button button = new Button("Max");
        button. disableProperty().bind(model.purchaseSelectors());
        button.setOnAction(
            evt->{
                model.calculateButton().set(false);
                model.percentagesPurchase().applied().set(
                model.percentagesPurchase().max().get()
                );
        });
        return button;
    }






    
    private Node createCalculoButton(){
        Button button = new Button("Calcular");
        
        button.setMinWidth(100); // Ancho mínimo de 100 píxeles
        button.setMaxWidth(200);
        button.disableProperty().bind(model.calculateButton());
        button.setOnAction(evt -> {
            calculate().accept(()->{
                System.out.println("precio gramos: "+model.priceGrInter().get());
                System.out.println("ganancia de venta externa: "+model.revenueExSale().get());
                System.out.println("precio gramo local: "+model.priceGrLocal().get());
                System.out.println("precio kilataje: "+model.caratagePrice().get());
                System.out.println("Precio a pagar por kilataje (min,inter,max): "+model.caratagePriceFinal().get());
                System.out.println("Precio a pagar por gramo Final: "+model.priceGrFinal().get());
                System.out.println("Monto maximo a pagar: "+model.maxPurchaseAmount().get());
            
            });
         

        });
        return button;
    }

    
    //Services---------------------------------
    private Consumer<Runnable> calculate (){
        return this.map.get("calculate");
    }
    //-----------------------------------------
}
