package prestimo.controllers;

import java.util.HashMap;
import java.util.function.Consumer;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.concurrent.Task;
import javafx.scene.layout.Region;
import javafx.util.Builder;
import prestimo.interactors.BuyInteractor;
import prestimo.models.BuyModel;
import prestimo.models.PercentagesCaratage;
import prestimo.models.PercentagesPurchase;
import prestimo.models.VariablesModel;
import prestimo.views.BuyViewBuilder;

public class BuyController {

    private final Builder<Region> buyViewBuilder;
    private final BuyModel model;
    private final PercentagesCaratage percentagesCaratageModel;
    private final PercentagesPurchase percentagesPurchaseModel;
    private final VariablesModel variablesModel;
    private final BuyInteractor interactor;
    

    public BuyController(){
        this.percentagesCaratageModel = new PercentagesCaratage();
        this.percentagesPurchaseModel = new PercentagesPurchase();
        this.variablesModel = new VariablesModel();
        this.model = new BuyModel(percentagesCaratageModel, percentagesPurchaseModel);
        this.interactor = new BuyInteractor();
        HashMap<String, Consumer<Runnable>> map =new HashMap<String, Consumer<Runnable>>();
        map.put("calculate",this::calculateValues ); 
        this.buyViewBuilder = new BuyViewBuilder(model,map);
     }
     public Region getView() {
        return buyViewBuilder.build();

    }
    public void calculateValues(Runnable postAction){
        
        Task<Void> saveTask = new Task<>() {
            @Override
            protected Void call() {
                calculate();
                return null;
            }
        };
        saveTask.setOnSucceeded(evt -> {
        
            postAction.run();
        });

        Thread saveThread = new Thread(saveTask);
        saveThread.start();

    }

    private void calculate(){
        model.priceGrInter().set(
            model.priceOnz().divide(model.conversionFactor().get()).get()
        ); // precio x gramos
        model.revenueExSale().set(
            model.priceGrInter().subtract(model.securityValue().get()).get()
        ); // ganancia de venta externa
       model.priceGrLocal().set(
        model.revenueExSale().subtract(model.revenueGr().get()).get()
       ); //precio gramo local

       model.caratagePrice().set(
        model.priceGrLocal().divide(24).get()
       ); // precio kilataje
        double caratagePriceFinal = model.caratagePrice().get() * model.kilatajeProperty().get() * model.percentagesCaratage().applied().get();
      
        // Vincula el resultado al precio final
        model.caratagePriceFinal().set(caratagePriceFinal);// Precio a pagar por kilataje (min,inter,max)


    model.priceGrFinal().set(
        model.pesoProperty().multiply(
            model.caratagePriceFinal().get()
        ).get()

    ); // Precio a pagar por gramo Final

    model.maxPurchaseAmount().set(
        model.priceGrFinal().multiply(
            model.percentagesPurchase().applied().get()
        ).get()
    ); // Monto maximo a pagar por compra


       
    }
}
