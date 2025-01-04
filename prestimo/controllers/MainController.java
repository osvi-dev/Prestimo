package prestimo.controllers;

import javafx.scene.layout.Region;
import javafx.util.Builder;
import prestimo.models.MainModel;
import prestimo.views.LoginViewBuilder;
import prestimo.views.MainViewBuilder;

public class MainController {

    Builder<Region> mainViewBuilder;

    public MainController(){
        MainModel model  = new MainModel();
        mainViewBuilder = new MainViewBuilder(new LoginController(model).getView());
    }

    public Region getView(){
        return mainViewBuilder.build();
    }
}
