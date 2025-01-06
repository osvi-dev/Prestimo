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
        // TODO: Avisar si las credenciales son invalidas
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

    /**
     * Verifica si una cadena de texto corresponde a un formato de correo electrónico válido.
     *
     * @param input La cadena de texto a verificar.
     * @return true si la cadena cumple con el formato de correo electrónico, false en caso contrario.
     */
    public static boolean veficarCorreo(String input) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(emailRegex, input);
    }

    /**
     * Verifica si una cadena de texto corresponde a un formato de nombre de usuario válido.
     *
     * El nombre de usuario debe cumplir con las siguientes reglas:
     * 
     * Debe contener entre 3 y 20 caracteres.
     *Solo puede contener letras, números, puntos (.), guiones bajos (_) y guiones (-).
     * 
     *
     * @param input La cadena de texto a verificar.
     * @return true si la cadena cumple con el formato de nombre de usuario, false en caso contrario.
     */
    public static boolean verificarUsername(String input) {
        String usernameRegex = "^[a-zA-Z0-9._-]{3,20}$";
        return Pattern.matches(usernameRegex, input);
    }

    

}
