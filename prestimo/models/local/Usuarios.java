package prestimo.models.local;

import java.sql.Connection;
import java.sql.PreparedStatement;

import prestimo.models.database.DatabaseInit;
import prestimo.models.database.VariablesDatabase;
public class Usuarios {

    private DatabaseInit dbInit = new DatabaseInit(VariablesDatabase.getDATABASE(), VariablesDatabase.getUSER(), VariablesDatabase.getPASSWORD());
    private Connection connection;
    
    
    public Usuarios(){}
    
    private void setConnection(){
        connection = dbInit.getConnection();
    }

    /*
     * Metodo para insertar un nuevo usuario
     * @param nombre
     * @param apellido_paterno
     * @param username
     * @param correo 
     */
    public void insertarUsuario(String nombre, String apellido_paterno, String apellido_materno, String username, String correo ){
        String sql = "INSERT INTO usuarios (nombre, apellido_paterno, apellido_materno, username, correo) VALUES (?, ?, ?, ?, ?)";
        try {
            setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setString(2, apellido_paterno);
            statement.setString(3, apellido_materno);
            statement.setString(4, username);
            statement.setString(5, correo);
            statement.executeUpdate();
            System.out.println("Usuario insertado correctamente");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * TODO: No creo que sean necesiarios los eliminar
     */
    public void eliminarUsuarioPorUsername(String username){
        String sql = "DELETE FROM usuarios WHERE username = ?";
        try {
            setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.executeUpdate();
            System.out.println("Usuario eliminado correctamente");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarUsuarioPorId(int id){
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try {
            setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void obetenerUsuarios(){
        String sql = "SELECT * FROM usuarios";
        try {
            setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeQuery();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
