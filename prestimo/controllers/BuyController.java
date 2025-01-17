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
import prestimo.models.local.ComprasMetales;
import prestimo.views.BuyViewBuilder;

public class BuyController {

    private final Builder<Region> buyViewBuilder;
    private final BuyModel model;
    private final PercentagesCaratage percentagesCaratageModel;
    private final PercentagesPurchase percentagesPurchaseModel;
    private final VariablesModel variablesModel;
    private final BuyInteractor interactor;
    private double caratagePriceFinal;
    

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
                saveBuy();
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
        /*
         * Pienso que sera mejor guardar los datos de la tabla variables en la base de datos
         */
        
        /*
         * TODO: Debemos extraer los datos de seguridad de la base de datos de la tabla variables
         * para poder hacer los calculos, esto se hara una vez dado los valores
         * los traeremos, creo que una opcion sera una vez iniciada la app, aplicar persistencia
         * para los valores y no hacer una consulta diaria.
         */
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
        caratagePriceFinal = model.caratagePrice().get() * model.kilatajeProperty().get() * model.percentagesCaratage().applied().get();
      
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

    /**
     * Vamos a guardar la compra del metal
     * para esto debemos llamar al modelo de la compra
     * y crear un objeto de la compr, despues mandar llamar 
     * su metodo de guardar
     */
    private void saveBuy(){
        /*
         * TODO: Una vez que se haya hecho el login debemos extraer el ID
         * del usuario para guardar la compra, 
         * ademas de hacer una lista para ver los metales disponibles
         * y guardar kas variables.
         * Ademas 
         */
        ComprasMetales compra = new ComprasMetales(
            model.kilatajeProperty().get(), 
            model.pesoProperty().get(),
            model.priceOnz().get(),
            model.priceGrInter().get(),
            model.priceGrLocal().get(),
            caratagePriceFinal,
            model.caratagePriceFinal().get(),
            model.priceGrFinal().get(),
            model.maxPurchaseAmount().get(),
            1,
            1,
            1);

            // Una vez instanciado mi objeto, guardamos la compra
            compra.insertarCompraMetales();
    }
}
