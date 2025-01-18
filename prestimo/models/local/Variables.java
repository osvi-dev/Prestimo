package prestimo.models.local;

import java.sql.Connection;
import java.sql.PreparedStatement;

import prestimo.models.database.DatabaseInit;
import prestimo.models.database.VariablesDatabase;

public class Variables {
    private int id;
    private double valor_seguridad;
    private double ganancia_gr;
    private DatabaseInit dbInit = new DatabaseInit(VariablesDatabase.getDATABASE(), VariablesDatabase.getUSER(), VariablesDatabase.getPASSWORD());
    private Connection connection;
    
    public Variables(int id, double valor_seguridad, double ganancia_gr) {
        this.id = id;
        this.valor_seguridad = valor_seguridad;
        this.ganancia_gr = ganancia_gr;
    }

    public Variables() {}

    private void setConnection(){
        connection = dbInit.getConnection();
    }

    /**
     * Metodo para insertar las variables en la base de datos
     * @param valor_seguridad
     * @param ganancia_gr
     */
    public void insertarVariables(){
        String sql = "INSERT INTO variables (valor_seguridad, ganancia_gr) VALUES (?, ?)";
        try {
            setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, this.valor_seguridad);
            statement.setDouble(2, this.ganancia_gr);
            statement.executeUpdate();
            dbInit.close();
            statement.close();
            System.out.println("Variables insertadas correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Setters y Getters
    public void setId(int id) {this.id = id;}
    public int getId() {return id;}
    
    public void setValor_seguridad(double valor_seguridad) {this.valor_seguridad = valor_seguridad;}
    public double getValor_seguridad() {return valor_seguridad;}
    
    public void setGanancia_gr(double ganancia_gr) {this.ganancia_gr = ganancia_gr;}
    public double getGanancia_gr() {return ganancia_gr;}
}
