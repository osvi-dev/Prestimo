package prestimo.controllers;

import java.util.HashMap;
import java.util.function.Consumer;

import javafx.concurrent.Task;
import javafx.scene.layout.Region;
import javafx.util.Builder;
import prestimo.interactors.LoginInteractor;
import prestimo.models.LoginModel;
import prestimo.models.MainModel;
import prestimo.views.LoginViewBuilder;

public class LoginController {
    private Builder<Region> loginViewBuilder;
    MainModel mainModel;
    LoginModel loginModel;
    LoginInteractor loginInteractor;
    
    public LoginController(MainModel mainModel){
        this.mainModel = mainModel;
        this.loginModel = new LoginModel();
        this.loginInteractor = new LoginInteractor();
         HashMap<String, Consumer<Runnable>> map =new HashMap<String, Consumer<Runnable>>();
        map.put("login",this::loginUser ); 
        
        loginViewBuilder = new LoginViewBuilder(loginModel,map );

    }
    public Region getView() {
        return loginViewBuilder.build();

    }
    // TODO: hacer el metodo para verificar las crendenciales del login
    public void loginUser(Runnable postAction){
        //Region region = this.getView();
       
        Task<Void> saveTask = new Task<>() {
            @Override
            protected Void call() {
                loginModel.setloginButtonDisabledProperty(true);
                System.out.println("Logeado!");
                loginModel.setloginButtonDisabledProperty(false);
                // Mandamos llamada al interactor de login y le mandamos el email ( o username)
                // y la contraseña, las verifica en la db para ver si son correctas
                loginInteractor.login(loginModel.getEmailProperty().get(), loginModel.getPasswordProperty().get());
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
