package models;

import java.sql.Date;

public class Empleado {
   private long id;
   private String nombe;
   private String domicilio;
   private String telefono;
   private String email;
   private Date fechadeNacimiento;
   private Genero genero;
    public Empleado(long id, String nombe, String domicilio, String telefono, String email, Date fechadeNacimiento,
            Genero genero) {
        this.id = id;
        this.nombe = nombe;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
        this.fechadeNacimiento = fechadeNacimiento;
        this.genero = genero;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombe() {
        return nombe;
    }
    public void setNombe(String nombe) {
        this.nombe = nombe;
    }
    public String getDomicilio() {
        return domicilio;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getFechadeNacimiento() {
        return fechadeNacimiento;
    }
    public void setFechadeNacimiento(Date fechadeNacimiento) {
        this.fechadeNacimiento = fechadeNacimiento;
    }
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
