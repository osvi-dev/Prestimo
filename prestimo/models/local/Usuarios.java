package prestimo.models.local;

import java.sql.Connection;
import java.sql.PreparedStatement;


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
    private String id_rol;

    public Usuarios(){}

    public Usuarios(String nombre, String apellido_paterno, String apellido_materno, 
                    String username, String correo, String password, String id_rol){
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.username = username;
        this.correo = correo;
        this.password = Encriptar.encriptar(password);
        this.id_rol = id_rol;
    }
    
    public Usuarios(String nombre, String apellido_paterno, String usermane, 
                    String correo, String password, String id_rol){
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

    /*
     * Metodo para insertar un nuevo usuario
     * @param nombre
     * @param apellido_paterno
     * @param apellido_materno
     * @param username
     * @param correo 
     * @param password
     * @param id_rol
     */
    public void insertarUsuario(String nombre, String apellido_paterno, String apellido_materno,
                                String username, String correo, String password, int id_rol){
        String sql = "INSERT INTO usuarios (nombre, apellido_paterno, apellido_materno, username, correo, password, id_rol) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            password = Encriptar.encriptar(password);
            setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setString(2, apellido_paterno);
            statement.setString(3, apellido_materno);
            statement.setString(4, username);
            statement.setString(5, correo);
            statement.setString(6, password);
            statement.setInt(7, id_rol);
            statement.executeUpdate();
            connection.close();
            System.out.println("Usuario insertado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void desabilitarUsuarioPorUsername(String username){
        String sql = "UPDATE usuarios SET disponible = 0 WHERE username = ?";
        try {
            setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.executeUpdate();
            connection.close();
            System.out.println("Usuario desabilitado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void desabilitarUsuarioPorId(int id){
        String sql = "UPDATE usuarios SET disponible = 0 WHERE id = ?";
        try {
            setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.close();
            System.out.println("Usuario desabilitado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void obetenerUsuarios(){
        String sql = "SELECT nombre, apellido_paterno, apellido_materno FROM usuarios";
        try {
            setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeQuery();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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


    
}
