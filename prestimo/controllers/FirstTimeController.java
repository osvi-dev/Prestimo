package prestimo.controllers;

import java.util.HashMap;
import java.util.function.Consumer;

import javafx.concurrent.Task;
import javafx.scene.layout.Region;
import javafx.util.Builder;
import prestimo.interactors.FirstTimeInteractor;
import prestimo.models.FirstTimeModel;
import prestimo.models.MainModel;
import prestimo.views.FirstTimeViewBuilder;


public class FirstTimeController {
    private Builder<Region> firstTimeViewBuilder;
    MainModel mainModel;
    FirstTimeModel firstTimeModel;
    FirstTimeInteractor firstTimeInteractor;
    public FirstTimeController(MainModel mainModel){
        this.mainModel = mainModel;
        this.firstTimeModel = new FirstTimeModel();
        this.firstTimeInteractor = new FirstTimeInteractor();
         HashMap<String, Consumer<Runnable>> map =new HashMap<String, Consumer<Runnable>>();
        map.put("login",this::loginUser ); 
        
        firstTimeViewBuilder = new FirstTimeViewBuilder(firstTimeModel,map );

    }
    public Region getView() {
        return firstTimeViewBuilder.build();

    }

    public void loginUser(Runnable postAction){
        //Region region = this.getView();
       
        Task<Void> saveTask = new Task<>() {
            @Override
            protected Void call() {
                firstTimeModel.setTokenButtonDisabledProperty(true);
                System.out.println("Logeado!");
                firstTimeModel.setTokenButtonDisabledProperty(false);
                //TODO: Hacer el metodo en el interactor y llamarlo aqui
               // interactor.loginUser();
                //mainModel.loginSelectedProperty().set(false);
                return null;
            }
        };
        saveTask.setOnSucceeded(evt -> {
        
            postAction.run();
        });

        Thread saveThread = new Thread(saveTask);
        saveThread.start();

    }
}
