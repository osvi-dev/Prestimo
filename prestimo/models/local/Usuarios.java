package prestimo.models.local;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import prestimo.models.database.DatabaseInit;
import prestimo.models.database.VariablesDatabase;
import prestimo.models.database.Encriptar;
public class Usuarios {

    private DatabaseInit dbInit = new DatabaseInit(VariablesDatabase.getDATABASE(), VariablesDatabase.getUSER(), VariablesDatabase.getPASSWORD());
    private Connection connection;
    private int id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String username;
    private String correo;
    private String password;
    private int id_rol;

    public Usuarios(){}

    public Usuarios(String nombre, String apellido_paterno, String apellido_materno, 
                    String username, String correo, String password, int id_rol){
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.username = username;
        this.correo = correo;
        this.password = Encriptar.encriptar(password);
        this.id_rol = id_rol;
    }
    
    public Usuarios(String nombre, String apellido_paterno, String usermane, 
                    String correo, String password, int id_rol){
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.username = usermane;
        this.correo = correo;
        this.password = Encriptar.encriptar(password);
        this.id_rol = id_rol;

    }
    

    private void setConnection(){
        connection = dbInit.getConnection();
    }

    /**
     * Inserta un nuevo usuario
     */
    public void insertarUsuario(){
        String sql = "INSERT INTO usuarios (nombre, apellido_paterno, apellido_materno, username, correo, password, id_rol) VALUES (?, ?, ?, ?, ?, ?, ?)";
        password = Encriptar.encriptar(password);
        try{
            setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, this.nombre);
            statement.setString(2, this.apellido_paterno);
            statement.setString(3, this.apellido_materno);
            statement.setString(4, this.username);
            statement.setString(5, this.correo);
            statement.setString(6, this.password);
            statement.setInt(7, this.id_rol);
            statement.executeUpdate();
            dbInit.close();
            statement.close();
            System.out.println("Usuario insertado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Desabilitar un usuario por su username
     * @param username
     */
    public void desabilitarUsuarioPorUsername(String username){
        String sql = "UPDATE usuarios SET disponible = 0 WHERE username = ?";
        try {
            setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.executeUpdate();
            dbInit.close();
            statement.close();
            System.out.println("Usuario desabilitado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Desabilita un usuario por su id
     * @param id
     */
    public void desabilitarUsuarioPorId(int id){
        String sql = "UPDATE usuarios SET disponible = 0 WHERE id = ?";
        try {
            setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            dbInit.close();
            statement.close();
            System.out.println("Usuario desabilitado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     /**
     * Metodo para obtener todos los usuarios de la base de datos
     */
    public void obtenerUsuarios(){
        String sql = "SELECT nombre, apellido_paterno, apellido_materno FROM usuarios";
        try {
            setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeQuery();
            dbInit.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para verificar las credenciales del usuario
     * @param correo
     * @param username
     * @param password  
     */
    public boolean veficarCredenciales(String correo, String username, String password){
        // Si el correo es vacio, se verifica el username
        if (correo.equals("")){
            return loginUsername(username, password);
        }
        // En dado caso que el correo no este vacio, quiere decir
        // que tenemos correo
        
        return loginCorreo(correo, password);
    }

    /**
     * Metodo para verificar si el username y la contraseña son correctos
     * @param username
     * @param password
     */
    private boolean loginUsername(String username, String password){
        // Preparamos la consulta para craer el username y la contraseña de la db
        String sql = "Select username, password from usuarios where username = ? and password = ?";
        boolean login = false; // flag para ver si las credenciales son correctas
        try {
            setConnection(); 
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
    
            // Si el resultado tiene una fila, las credenciales son válidas
            if (resultSet.next()) {
                login = true;
            }
            dbInit.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return login;
    }

    /**
     * Metodo para verificar si el correo y la contraseña son correctos
     * @param correo
     * @param password
    */

    private boolean loginCorreo(String correo, String password){
        // Preparamos la consulta para traer el correo y la contraseña de la db
        String sql = "Select correo, password from usuarios where correo = ? and password = ?";
        boolean login = false; // flag para ver si las credenciales son correctas
        try {
            setConnection(); 
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, correo);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
    
            // Si el resultado tiene una fila, las credenciales son válidas
            if (resultSet.next()) {
                login = true;
            }
            connection.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return login;
    }

    // Seters y Getters
    public void setId(int id){this.id = id;}
    public int getId(){ return id; }

    public void setNombre(String nombre){this.nombre = nombre;}
    public String getNombre(){ return nombre; }

    public void setApellidoPaterno(String apellido_paterno){this.apellido_paterno = apellido_paterno;}
    public String getApellidoPaterno(){ return apellido_paterno; }

    public void setApellidoMaterno(String apellido_materno){this.apellido_materno = apellido_materno;}
    public String getApellidoMaterno(){ return apellido_materno; }

    public void setUsername(String username){this.username = username;}
    public String getUsername(){ return username; }

    public void setCorreo(String correo){this.correo = correo;}
    public String getCorreo(){ return correo; }
    
    public String getPassword(){ return password; }

    public void setIdRol(int id_rol){this.id_rol = id_rol;}
    public int getIdRol(){ return id_rol; }
    
}
