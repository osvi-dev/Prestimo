package prestimo.controllers;

import javafx.scene.layout.Region;
import javafx.util.Builder;
import prestimo.views.LoginViewBuilder;
import prestimo.views.MainViewBuilder;

public class MainController {

    Builder<Region> mainViewBuilder;

    public MainController(){
        mainViewBuilder = new MainViewBuilder(new LoginViewBuilder().build());
    }

    public Region getView(){
        return mainViewBuilder.build();
    }
}
