package prestimo.interactors;

import java.util.regex.Pattern;
import prestimo.models.database.Encriptar;
import prestimo.models.local.Usuarios;

public class LoginInteractor {

    private Usuarios usuario = new Usuarios();
   
    public LoginInteractor() {
         
    }

    //TODO: Aqui implementar todos los metodos que tienen alguna relacion con el login 

    /*
     * Metodo que verifica si el username o el email son validos
     * @param usernameOrEmail
     */
    public void login(String usernameOrEmail, String password){
        
        password = Encriptar.encriptar(password);
        if (verificarUsername(usernameOrEmail)) {
           System.out.println("Es un username");
           System.out.println(usuario.veficarCredenciales("", usernameOrEmail, password));
        }
        else if (veficarCorreo(usernameOrEmail)) {
            System.out.println("Es un correo");
            System.out.println(usuario.veficarCredenciales(usernameOrEmail, "", password));
        }   
    }
    
    public static boolean veficarCorreo(String input) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(emailRegex, input);
    }

    // Método para validar nombres de usuario
    public static boolean verificarUsername(String input) {
        String usernameRegex = "^[a-zA-Z0-9._-]{3,20}$";
        return Pattern.matches(usernameRegex, input);
    }

    

}
