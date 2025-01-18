package prestimo.models.local;

import java.sql.Connection;
import java.sql.PreparedStatement;

import prestimo.models.database.DatabaseInit;
import prestimo.models.database.VariablesDatabase;

public class PorcentajesPrestamo {

    private int id;
    private double porcentaje_min;
    private double porcentaje_medio;
    private double porcentaje_max;
    private double porcentaje_aplicado;
    private int id_prestamo;

    private DatabaseInit dbInit = new DatabaseInit(VariablesDatabase.getDATABASE(), VariablesDatabase.getUSER(), VariablesDatabase.getPASSWORD());
    private Connection connection;

    public PorcentajesPrestamo() {}
    
    /**
     *  Constructor de los porcentajes de prestamo con id
     * @param id
     * @param porcentaje_min
     * @param porcentaje_medio
     * @param porcentaje_max
     * @param porcentaje_aplicado
     * @param id_prestamo
     */
    public PorcentajesPrestamo(int id, double porcentaje_min, double porcentaje_medio, double porcentaje_max,
            double porcentaje_aplicado, int id_prestamo) {
        this.id = id;
        this.porcentaje_min = porcentaje_min;
        this.porcentaje_medio = porcentaje_medio;
        this.porcentaje_max = porcentaje_max;
        this.porcentaje_aplicado = porcentaje_aplicado;
        this.id_prestamo = id_prestamo;
    }


    /**
     * Constructor de los porcentajes de prestamo sin id
     * @param porcentaje_min
     * @param porcentaje_medio
     * @param porcentaje_max
     * @param porcentaje_aplicado
     * @param id_prestamo
     */
    public PorcentajesPrestamo(double porcentaje_min, double porcentaje_medio, double porcentaje_max,
            double porcentaje_aplicado, int id_prestamo) {
        this.porcentaje_min = porcentaje_min;
        this.porcentaje_medio = porcentaje_medio;
        this.porcentaje_max = porcentaje_max;
        this.porcentaje_aplicado = porcentaje_aplicado;
        this.id_prestamo = id_prestamo;
    } 

    private void setConnection(){
        connection = dbInit.getConnection();
    }

    public void insertarPorcentajesPrestamo(){
        setConnection();
        try {
            String sql = "INSERT INTO porcentajes_prestamo (porcentaje_min, porcentaje_medio, porcentaje_max, porcentaje_aplicado, id_prestamo) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, porcentaje_min);
            statement.setDouble(2, porcentaje_medio);
            statement.setDouble(3, porcentaje_max);
            statement.setDouble(4, porcentaje_aplicado);
            statement.setInt(5, id_prestamo);
            statement.executeUpdate();
            connection.close();
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

    public int getId_prestamo() {return id_prestamo;}
    public void setId_prestamo(int id_prestamo) {this.id_prestamo = id_prestamo;}
}
