package prestimo.controllers;

import javafx.scene.layout.Region;
import javafx.util.Builder;
import prestimo.interactors.BuyInteractor;
import prestimo.models.BuyModel;
import prestimo.views.BuyViewBuilder;

public class BuyController {

    private final Builder<Region> buyViewBuilder;
    private final BuyModel model;
    private final BuyInteractor interactor;
    

    public BuyController(){
        this.model = new BuyModel();
        this.interactor = new BuyInteractor();
        this.buyViewBuilder = new BuyViewBuilder();
        
    }
     public Region getView() {
        return buyViewBuilder.build();

    }
}
