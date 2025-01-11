package prestimo.models.local;

import java.sql.Connection;
import java.sql.PreparedStatement;

import prestimo.models.database.DatabaseInit;
import prestimo.models.database.VariablesDatabase;

public class Roles {

    private DatabaseInit dbInit = new DatabaseInit(VariablesDatabase.getDATABASE(), VariablesDatabase.getUSER(), VariablesDatabase.getPASSWORD());
    private Connection connection;
    private String rol; 

    public Roles(){}   

    public String getRol(){ return rol; }

    private void setConnection(){
        connection = dbInit.getConnection();
    }
    /**
     *  Inserta un rol en la base de datos 
     * @param rol
     */
    public void insertarRol(String rol){
        String sql = "INSERT INTO roles (rol) VALUES (?)";
        try {
            setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, rol);
            statement.executeUpdate();
            System.out.println("Rol insertado correctamente");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
