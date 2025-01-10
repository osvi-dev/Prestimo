package prestimo.controllers;

import java.util.HashMap;
import java.util.function.Consumer;

import javafx.concurrent.Task;
import javafx.scene.layout.Region;
import javafx.util.Builder;
import prestimo.models.DashboardModel;
import prestimo.models.MainModel;
import prestimo.views.BuyViewBuilder;
import prestimo.views.DashboardViewBuilder;

public class DashboardController {

    private final Builder<Region> dashboardViewBuilder;
    private final MainModel mainModel;
    private final DashboardModel dashboardModel;
    private final BuyController buyView;

    public DashboardController(MainModel mainModel){
        this.mainModel = mainModel;
        this.dashboardModel = new DashboardModel();
        HashMap<String, Consumer<Runnable>> map =new HashMap<String, Consumer<Runnable>>();
     
        map.put("buyView", this::buyView);
        this.buyView = new BuyController();
        this.dashboardViewBuilder = new DashboardViewBuilder(dashboardModel,buyView.getView(),map);
    }
    public Region getView() {
        return dashboardViewBuilder.build();

    }
    

    public void buyView(Runnable postAction){
        //Region region = this.getView();
       
        Task<Void> saveTask = new Task<>() {
            @Override
            protected Void call() {
               System.out.println("Vista compra activada");
                return null;
            }
        };
        saveTask.setOnSucceeded(evt -> {
        
            postAction.run();
        });
    
    }

}
