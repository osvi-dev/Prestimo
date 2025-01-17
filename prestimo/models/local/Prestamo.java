package prestimo.models.local;

public class Prestamo {
    private int id;
    private double peso;
    private int kilataje; 
    private double oro_fino_gr;
    private double precio_gr_local;
    private double prestamo_max;
    private double prestamo_final;
    private int id_material;
    
    public Prestamo() {}
    /**
     * Constructor de la clase Prestamo con id
     * @param id
     * @param peso
     * @param kilataje
     * @param oro_fino_gr
     * @param precio_gr_local
     * @param prestamo_max
     * @param prestamo_final
     * @param id_material
     */
    public Prestamo(int id, double peso, int kilataje, double oro_fino_gr, double precio_gr_local, 
                    double prestamo_max, double prestamo_final, int id_material) {
        this.id = id;
        this.peso = peso;
        this.kilataje = kilataje;
        this.oro_fino_gr = oro_fino_gr;
        this.precio_gr_local = precio_gr_local;
        this.prestamo_max = prestamo_max;
        this.prestamo_final = prestamo_final;
        this.id_material = id_material;
    }

    /**
     * Constructor de la clase Prestamo sin id
     * @param peso
     * @param kilataje
     * @param oro_fino_gr
     * @param precio_gr_local
     * @param prestamo_max
     * @param prestamo_final
     * @param id_material
     */
    public Prestamo(double peso, int kilataje, double oro_fino_gr, double precio_gr_local,
                    double prestamo_max, double prestamo_final, int id_material) {
        this.peso = peso;
        this.kilataje = kilataje;
        this.oro_fino_gr = oro_fino_gr;
        this.precio_gr_local = precio_gr_local;
        this.prestamo_max = prestamo_max;
        this.prestamo_final = prestamo_final;
        this.id_material = id_material;
    }

    // Setters y Getters
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    
    public double getPeso() {return peso;}
    public void setPeso(double peso) {this.peso = peso;}
    
    public int getKilataje() {return kilataje;}
    public void setKilataje(int kilataje) {this.kilataje = kilataje;}
    
    public double getOro_fino_gr() {return oro_fino_gr;}
    public void setOro_fino_gr(double oro_fino_gr) {this.oro_fino_gr = oro_fino_gr;}
    
    public double getPrecio_gr_local() {return precio_gr_local;}
    public void setPrecio_gr_local(double precio_gr_local) {this.precio_gr_local = precio_gr_local;}
    
    public double getPrestamo_max() {return prestamo_max;}
    public void setPrestamo_max(double prestamo_max) {this.prestamo_max = prestamo_max;}
    
    public double getPrestamo_final() {return prestamo_final;}
    public void setPrestamo_final(double prestamo_final) {this.prestamo_final = prestamo_final;}
    
    public int getId_material() {return id_material;}
    public void setId_material(int id_material) {this.id_material = id_material;}
}
