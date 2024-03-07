package models;


public class Genero {
    private Long id;
    private String nombre;
    public Genero(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return nombre; // Cambia esto para que muestre el nombre en lugar de la dirección
    }
}
