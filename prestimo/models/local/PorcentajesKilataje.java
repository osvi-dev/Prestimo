package prestimo.models.local;

import java.sql.Connection;
import java.sql.PreparedStatement;

import prestimo.models.database.DatabaseInit;
import prestimo.models.database.VariablesDatabase;

public class PorcentajesKilataje {
    private int id;
    private double porcentaje_min;
    private double porcentaje_medio;
    private double porcentaje_max;
    private double porcentaje_aplicado;
    private int id_venta;

    private DatabaseInit dbInit = new DatabaseInit(VariablesDatabase.getDATABASE(), VariablesDatabase.getUSER(), VariablesDatabase.getPASSWORD());
    private Connection connection;
    public PorcentajesKilataje(int id, double porcentaje_min, double porcentaje_medio, double porcentaje_max,
        double porcentaje_aplicado, int id_venta) {
        this.id = id;
        this.porcentaje_min = porcentaje_min;
        this.porcentaje_medio = porcentaje_medio;
        this.porcentaje_max = porcentaje_max;
        this.porcentaje_aplicado = porcentaje_aplicado;
        this.id_venta = id_venta;
    }

    public PorcentajesKilataje() {}

    private void setConnection(){
        connection = dbInit.getConnection();
    }
    
    /**
     * Metodo para insertar los porcentajes de compra en la base de datos
     */
    public void insertarPorcentajesKilataje(){
        String sql = "INSERT INTO porcentajes_compra (porcentaje_min, porcentaje_medio, porcentaje_max, porcentaje_aplicado, id_venta) VALUES (?,?,?,?,?)";
        try {
            setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, this.porcentaje_min);
            statement.setDouble(2, this.porcentaje_medio);
            statement.setDouble(3, this.porcentaje_max);
            statement.setDouble(4, this.porcentaje_aplicado);
            statement.setInt(5, this.id_venta);
            statement.executeUpdate();
            dbInit.close();
            statement.close();
            System.out.println("Porcentaje de compra insertado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Setters y Getters
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public double getPorcentaje_min() {return porcentaje_min;}
    public void setPorcentaje_min(double porcentaje_min) {this.porcentaje_min = porcentaje_min;}
    
    public double getPorcentaje_medio() {return porcentaje_medio;}
    public void setPorcentaje_medio(double porcentaje_medio) {this.porcentaje_medio = porcentaje_medio;}
    
    public double getPorcentaje_max() {return porcentaje_max;}
    public void setPorcentaje_max(double porcentaje_max) {this.porcentaje_max = porcentaje_max;}
    
    public double getPorcentaje_aplicado() {return porcentaje_aplicado;}
    public void setPorcentaje_aplicado(double porcentaje_aplicado) {this.porcentaje_aplicado = porcentaje_aplicado;}
    
    public int getId_venta() {return id_venta;}
    public void setId_venta(int id_venta) {this.id_venta = id_venta;}
}
