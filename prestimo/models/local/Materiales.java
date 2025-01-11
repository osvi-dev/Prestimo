package prestimo.models.local;

public class Materiales {
    private int id;
    private String nombre;

    public Materiales(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Materiales() {}

    public int getId(){ return this.id; }
    public void setId(int id){this.id = id;}

    public String getNombre(){ return this.nombre; }
    public void setNombre(String nombre){this.nombre = nombre;}
}
