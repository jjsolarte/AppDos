package co.jeisonsolarte.appdos.modelo;

public class ItemModel {

    private String nombre;
    private String descripcion;
    private int edad;
    private String img;

    public ItemModel() {
    }

    public ItemModel(String nombre, String descripcion, int edad, String img) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.edad = edad;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
