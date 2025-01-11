package prestimo.models.local;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import prestimo.models.database.DatabaseInit;
import prestimo.models.database.VariablesDatabase;

public class Instancia {

    private String token;
    // Se utilizara el instalacion al momento de obtener el valor timstamp 
    Timestamp time;
    private DatabaseInit dbInit = new DatabaseInit(VariablesDatabase.getDATABASE(), VariablesDatabase.getUSER(), VariablesDatabase.getPASSWORD());
    private Connection connection;

    public Instancia(){}
    public Instancia(String token) {
        this.token = token;
    }

    private void setConnection(){
        connection = dbInit.getConnection();
    }
    /**
     * Metodo para insertar el token en la base de datos
     * @param token
     */
    public void insertarInstancia(String token){
        String sql = "INSERT INTO instancia (token) VALUES (?)";
        try {
            setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, token);
            statement.executeUpdate();
            connection.close();
            System.out.println("Instancia insertada correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Setters y getters
    public String getToken() {return token;}
    public void setToken(String token) {this.token = token;}

}
