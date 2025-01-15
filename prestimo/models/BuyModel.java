package prestimo.models;

import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import prestimo.api_consultas.Oro;

public class BuyModel {

    private final SimpleIntegerProperty kilataje = new SimpleIntegerProperty(0);
    private final SimpleDoubleProperty peso = new SimpleDoubleProperty(0); //Automatico
    private final SimpleDoubleProperty price_onz = new SimpleDoubleProperty(54379.26); // Automatico
    private final SimpleDoubleProperty conversion_factor = new SimpleDoubleProperty(31.1); //Constante
    private final SimpleDoubleProperty price_gr_inter = new SimpleDoubleProperty(0); //Calculado
    private final SimpleDoubleProperty security_value = new SimpleDoubleProperty(100); // Setteable   
    private final SimpleDoubleProperty revenue_extern_sale = new SimpleDoubleProperty(0); //Calculado
    private final SimpleDoubleProperty revenue_gr= new SimpleDoubleProperty(100); //Setteable 
    private final SimpleDoubleProperty price_local_gr = new SimpleDoubleProperty(0); //Calculado 
    private final SimpleDoubleProperty caratage_price = new SimpleDoubleProperty(0); //Calculado 
    private final SimpleDoubleProperty caratage_price_final = new SimpleDoubleProperty(0); //Calculado
    private final SimpleDoubleProperty price_gr_final  =new SimpleDoubleProperty(0); //Calculado
    private final SimpleDoubleProperty max_purchase_amount = new SimpleDoubleProperty(0); //Calculado
    private final PercentagesCaratage percentagesCaratage;
    private final PercentagesPurchase percentagesPurchase;


    //Gui
    private final SimpleBooleanProperty caratage = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty weight = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty caratageSelectors = new SimpleBooleanProperty(true);
    private final SimpleBooleanProperty purchaseSelectors = new SimpleBooleanProperty(true);
    private final SimpleBooleanProperty calculateButton = new SimpleBooleanProperty(true);
    
    public BuyModel(PercentagesCaratage percentagesCaratage, PercentagesPurchase percentagesPurchase){
        this.percentagesCaratage= percentagesCaratage;
        this.percentagesPurchase  =percentagesPurchase;
        this.price_onz.set(Oro.obtenerPrecioOnza());
        System.out.println("Precio oro/onz: "+Oro.obtenerPrecioOnza());
        caratageSelectors.bind(Bindings.createBooleanBinding(
            () -> !(caratage.get() && weight.get()), // Condición: ambos deben ser verdaderos
            caratage, weight // Observa cambios en estas propiedades
        ));
    }

    public IntegerProperty kilatajeProperty(){
        return this.kilataje;
    }
    public DoubleProperty pesoProperty(){
        return this.peso;    
    }
    public DoubleProperty priceOnz(){
        return this.price_onz;    
    }
    public DoubleProperty conversionFactor(){
        return this.conversion_factor;    
    }
    public DoubleProperty priceGrInter(){
        return this.price_gr_inter;    
    }
    public DoubleProperty revenueExSale(){
        return this.revenue_extern_sale;
    }
    public DoubleProperty securityValue(){
        return this.security_value;
    }
    public DoubleProperty revenueGr(){
        return this.revenue_gr;
    }
    public DoubleProperty priceGrLocal(){
        return this.price_local_gr;
    }
    public DoubleProperty caratagePrice(){
        return this.caratage_price;
    }
    
    public PercentagesCaratage percentagesCaratage(){
        return this.percentagesCaratage;
    }
    public PercentagesPurchase percentagesPurchase(){
       return this.percentagesPurchase;
    }

    public DoubleProperty caratagePriceFinal(){
        return this.caratage_price_final;
    }
    public DoubleProperty priceGrFinal(){
        return this.price_gr_final;
    }
    public DoubleProperty maxPurchaseAmount(){
        return this.max_purchase_amount;
    }

    public BooleanProperty carageSelectors(){
        return this.caratageSelectors;
    }
    public BooleanProperty purchaseSelectors(){
        return this.purchaseSelectors;
    }
    public BooleanProperty calculateButton(){
        return this.calculateButton;
    }
    public BooleanProperty caratage(){
        return this.caratage;
    }
    public BooleanProperty weight(){
        return this.weight;
    }
    
}
