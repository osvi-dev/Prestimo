package prestimo.views;

import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Builder;
import prestimo.models.MainModel;

public class MainViewBuilder implements Builder<Region> {
    private final Region loginView;
    private final Region firstTimeView ;
    private final Region dashboardView;
    private final MainModel model;
    //COMENTARI
    public MainViewBuilder(
        MainModel model,Region loginView, Region firstTimeView, Region dashboardView){
        this.model = model;
        this.loginView = loginView;
        this.firstTimeView = firstTimeView;
        this.dashboardView = dashboardView;
    }

     @Override 
    public Region build(){
      
        StackPane results = (StackPane)this.createContent();



       return results;
    }

    private Node createContent(){
        this.firstTimeView.visibleProperty().bind(model.getFirstTimeProperty());
        this.loginView.visibleProperty().bind(model.getLoginProperty());
        this.dashboardView.visibleProperty().bind(model.getDashboardProperty());
       
        return new StackPane(firstTimeView,loginView, dashboardView);
    }
}
