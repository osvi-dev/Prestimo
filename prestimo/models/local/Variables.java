package prestimo.models.local;

public class Variables {
    private int id;
    private double valor_seguridad;
    private double ganancia_gr;
    
    public Variables(int id, double valor_seguridad, double ganancia_gr) {
        this.id = id;
        this.valor_seguridad = valor_seguridad;
        this.ganancia_gr = ganancia_gr;
    }

    public Variables() {}

    // Setters y Getters
    public void setId(int id) {this.id = id;}
    public int getId() {return id;}
    
    public void setValor_seguridad(double valor_seguridad) {this.valor_seguridad = valor_seguridad;}
    public double getValor_seguridad() {return valor_seguridad;}
    
    public void setGanancia_gr(double ganancia_gr) {this.ganancia_gr = ganancia_gr;}
    public double getGanancia_gr() {return ganancia_gr;}
}
