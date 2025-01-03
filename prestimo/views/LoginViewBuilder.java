package prestimo.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.util.Builder;

public class LoginViewBuilder implements  Builder<Region>{

    private final double leftContainerWidth =Screen.getPrimary().getBounds().getWidth()/2.5;
    private final double leftContainerHeight = Screen.getPrimary().getBounds().getHeight();
    private final double rigthContainerWidth =Screen.getPrimary().getBounds().getWidth()/2.5;
    private final double rigthContainerHeight = Screen.getPrimary().getBounds().getHeight();
    
    public LoginViewBuilder(){

    }

    @Override
    public Region build() {
        Pane results = new Pane(createMainCointainer());
       // results.setStyle("-fx-background-color: #3498db;"); 
    
       results.getStylesheets().add("/login.css");

        return results;
    }

    private Node createMainCointainer(){
       HBox container = new HBox(createMainLeftContainer(), createMainRigthContainer());

       return container;
    }

    // LeftSide ----------------------------------
    private Node createMainLeftContainer(){
        Pane container = new Pane(createLogo());
        container.setMaxWidth(this.leftContainerWidth);
        return container;
    }

    private Node createLogo(){
        Pane container = new Pane();
        Image image = new Image("prestimo\\img\\logo.png",
        this.leftContainerWidth, this.leftContainerHeight, false, true);
   // container.setStyle("-fx-background-color:rgb(0, 0, 0);"); 
        container.setMinWidth(this.leftContainerWidth);
        container.setMinHeight(this.leftContainerHeight);
        // Crear un objeto BackgroundImage
        BackgroundImage backgroundImage = new BackgroundImage(
            image,
            BackgroundRepeat.NO_REPEAT, // Repetir en eje X
            BackgroundRepeat.NO_REPEAT, // Repetir en eje Y
            BackgroundPosition.DEFAULT,  // Posicionar en el centro
            new BackgroundSize(
               BackgroundSize.AUTO,     // Ancho automático
               BackgroundSize.AUTO,     // Alto automático
                true,                   // Usar ancho absoluto
                false,                   // Usar alto absoluto
                true,                    // Ajustar para cubrir
                false                    // No recortar
            )
            );
          container.setBackground(new Background(backgroundImage));

        return container;
    }



    //-----------------------------------------------


    //Rigth Container ---------------------------------------------
    private Node createMainRigthContainer(){
        HBox container = new HBox(createFormContainer());
        //container.setStyle("-fx-background-color: #3498db;"); 
        container.setAlignment(Pos.CENTER);
        container.setMinWidth(Screen.getPrimary().getBounds().getWidth()/1.5);
        container.setMaxHeight(this.rigthContainerHeight);
        return container;
    }

    private Node createFormContainer(){
        VBox container = new VBox(createTitle(), createFieldsContainer(),createLoginButton());
     //   container.setStyle("-fx-background-color: #3498db;"); 
        container.setAlignment(Pos.CENTER);
        container.setSpacing(40);
        return container;
    }

    private Node createTitle(){
        Label container = new Label("Ingresa tus credenciales");
        container.setFont(Resources.titleFont);
        container.getStyleClass().add("title-login");
        return container;

    }
    private Node createFieldsContainer(){
        VBox container = new VBox(createMailField(),createPasswordFieldContainer() );
        container.setSpacing(20);
        return container;
    }

    private Node createMailField(){
        TextField textField = new TextField(); 
        textField.setPromptText("email");
        textField.setPrefWidth(300);
        textField.setPrefHeight(40);
        textField.getStyleClass().add("text-field-login");
        return textField;
    }
    private Node createPasswordFieldContainer(){
        VBox container = new VBox(createPasswordField(),createForgotPasswordContainer());
        container.setSpacing(10);
        return container;
    }

    private Node createPasswordField(){
        PasswordField textField = new PasswordField(); 
        textField.setPromptText("password");
        textField.setPrefWidth(300);
        textField.setPrefHeight(40);
        textField.getStyleClass().add("text-field-login");
        return textField;
    }
     private Node createLoginButton(){
        Button btn = new Button(
           "Iniciar Sesion"
        );
        
       
        btn.setPrefWidth(300);
        btn.setPrefHeight(40);
        btn.getStyleClass().add("login-btn");

        return btn;
    }
    private Node createForgotPasswordContainer(){
        HBox container = new HBox(createForgotPasswordLink());
        container.setAlignment(Pos.CENTER_RIGHT);
        return container;
    }
    private Node createForgotPasswordLink(){
        Label label = new Label("Olvidaste tu contraseña?");
        label.getStyleClass().add("forgot-password");
        label.setFont(Resources.text);
        return label;
    }



    //-------------------------------------------------------------

    
}
