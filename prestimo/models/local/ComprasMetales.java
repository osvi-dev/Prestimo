package prestimo.models.local;

import java.sql.Connection;
import java.sql.PreparedStatement;

import prestimo.models.database.DatabaseInit;
import prestimo.models.database.VariablesDatabase;

public class ComprasMetales {
    /* TODO: tienes que hacer un metodo que lleve la cuenta de los ID, para mantener el contorl */
    private int id;
    private int kilataje;
    private double peso;
    private double precio_oz_inter;
    private double precio_gr_inter;
    private double precio_gr_local;
    private double precio_kilataje;
    private double precio_kilataje_total;
    private double precio_gr_final;
    private double monto_max_compra;

    // Foreign Keys
    private int id_materiales;
    private int id_usuario;
    private int id_variables;

    private DatabaseInit dbInit = new DatabaseInit(VariablesDatabase.getDATABASE(), VariablesDatabase.getUSER(), VariablesDatabase.getPASSWORD());
    private Connection connection;
    
    public ComprasMetales() {}

    public ComprasMetales(int id, int kilataje, double peso, double precio_oz_inter, double precio_gr_inter,
            double precio_gr_local, double precio_kilataje, double precio_kilataje_total, double precio_gr_final,
            double monto_max_compra, int id_materiales, int id_usuario, int id_variables) {
        
        this.id = id;
        this.kilataje = kilataje;
        this.peso = peso;
        this.precio_oz_inter = precio_oz_inter;
        this.precio_gr_inter = precio_gr_inter;
        this.precio_gr_local = precio_gr_local;
        this.precio_kilataje = precio_kilataje;
        this.precio_kilataje_total = precio_kilataje_total;
        this.precio_gr_final = precio_gr_final;
        this.monto_max_compra = monto_max_compra;
        this.id_materiales = id_materiales;
        this.id_usuario = id_usuario;
        this.id_variables = id_variables;
    }

    // Metodo para insertarlo en la base de datos
    private void setConnection(){
        connection = dbInit.getConnection();
    }

    /**
     * Metodo para insertar una compra de metales
     * @param kilataje
     * @param peso
     * @param precio_oz_inter
     * @param precio_gr_inter
     * @param precio_gr_local
     * @param precio_kilataje
     * @param precio_kilataje_total
     * @param precio_gr_final
     * @param monto_max_compra
     * @param id_materiales
     * @param id_usuario
     * @param id_variables
     */
    public void insertarCompraMetales(int kilataje, double peso, double precio_oz_inter, double precio_gr_inter,
    double precio_gr_local, double precio_kilataje, double precio_kilataje_total, double precio_gr_final,
    double monto_max_compra, int id_materiales, int id_usuario, int id_variables){
        String sql = "INSERT INTO compras_metales (kilataje, peso, precio_oz_inter, precio_gr_inter,precio_gr_local,"
        + "precio_kilataje, precio_kilataje_total, precio_gr_final, monto_max_compra, id_materiales, id_usuario, id_variables)"
        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, kilataje);
            statement.setDouble(2, peso);
            statement.setDouble(3, precio_oz_inter);
            statement.setDouble(4, precio_gr_inter);
            statement.setDouble(5, precio_gr_local);
            statement.setDouble(6, precio_kilataje);
            statement.setDouble(7, precio_kilataje_total);
            statement.setDouble(8, precio_gr_final);
            statement.setDouble(9, monto_max_compra);
            statement.setInt(10, id_materiales);
            statement.setInt(11, id_usuario);
            statement.setInt(12, id_variables);
            statement.executeUpdate();
            connection.close();
            statement.close();
            System.out.println("Compra insertada correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    // Setters y Getters
    public void setId(int id) {this.id = id;}
    public int getId() {return id;}

    public void setKilataje(int kilataje) {this.kilataje = kilataje;}
    public int getKilataje() {return kilataje;}

    public void setPeso(double peso) {this.peso = peso;}
    public double getPeso() {return peso;}

    public void setPrecio_oz_inter(double precio_oz_inter) {this.precio_oz_inter = precio_oz_inter;}
    public double getPrecio_oz_inter() {return precio_oz_inter;}

    public void setPrecio_gr_inter(double precio_gr_inter) {this.precio_gr_inter = precio_gr_inter;}    
    public double getPrecio_gr_inter() {return precio_gr_inter;}

    public void setPrecio_gr_local(double precio_gr_local) {this.precio_gr_local = precio_gr_local;}
    public double getPrecio_gr_local() {return precio_gr_local;}

    public void setPrecio_kilataje(double precio_kilataje) {this.precio_kilataje = precio_kilataje;}
    public double getPrecio_kilataje() {return precio_kilataje;}

    public void setPrecio_kilataje_total(double precio_kilataje_total) {this.precio_kilataje_total = precio_kilataje_total;}
    public double getPrecio_kilataje_total() {return precio_kilataje_total;}

    public void setPrecio_gr_final(double precio_gr_final) {this.precio_gr_final = precio_gr_final;}    
    public double getPrecio_gr_final() {return precio_gr_final;}

    public void setMonto_max_compra(double monto_max_compra) {this.monto_max_compra = monto_max_compra;}
    public double getMonto_max_compra() {return monto_max_compra;}

    public void setId_materiales(int id_materiales) {this.id_materiales = id_materiales;}
    public int getId_materiales() {return id_materiales;}

    public void setId_usuario(int id_usuario) {this.id_usuario = id_usuario;}
    public int getId_usuario() {return id_usuario;}

    public void setId_variables(int id_variables) {this.id_variables = id_variables;}
    public int getId_variables() {return id_variables;}

}
