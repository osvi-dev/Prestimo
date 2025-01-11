package prestimo.models.local;

import java.sql.Connection;
import java.sql.PreparedStatement;

import prestimo.models.database.DatabaseInit;
import prestimo.models.database.VariablesDatabase;

public class Materiales {
    private int id;
    private String nombre;
    private DatabaseInit dbInit = new DatabaseInit(VariablesDatabase.getDATABASE(), VariablesDatabase.getUSER(), VariablesDatabase.getPASSWORD());
    private Connection connection;

    public Materiales(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Materiales() {}

    // Conexion a la base de datos
    private void setConnection(){
        connection = dbInit.getConnection();
    }

    public void insertarMaterial(String nombre){
        String sql = "INSERT INTO materiales (nombre) VALUES (?)";
        try {
            setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.executeUpdate();
            connection.close();
            System.out.println("Material insertado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getId(){ return this.id; }
    public void setId(int id){this.id = id;}

    public String getNombre(){ return this.nombre; }
    public void setNombre(String nombre){this.nombre = nombre;}
}
