package prestimo.models.local;

public class ComprasMetales {
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
