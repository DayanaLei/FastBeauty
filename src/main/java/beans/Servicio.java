package beans;

import java.sql.Date;


public class Servicio {
    
    private int id_servicio;
    private String nombre_servicio;
    private Date duracion;
    private double costo_servicio;
    private String nombre_empleado;

    public Servicio(int id_servicio, String nombre_servicio, Date duracion, double costo_servicio, String nombre_empleado) {
        this.id_servicio = id_servicio;
        this.nombre_servicio = nombre_servicio;
        this.duracion = duracion;
        this.costo_servicio = costo_servicio;
        this.nombre_empleado = nombre_empleado;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public Date getDuracion() {
        return duracion;
    }

    public void setDuracion(Date duracion) {
        this.duracion = duracion;
    }

    public double getCosto_servicio() {
        return costo_servicio;
    }

    public void setCosto_servicio(double costo_servicio) {
        this.costo_servicio = costo_servicio;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    @Override
    public String toString() {
        return "Servicio{" + "id_servicio=" + id_servicio + ", nombre_servicio=" + nombre_servicio + ", duracion=" + duracion + ", costo_servicio=" + costo_servicio + ", nombre_empleado=" + nombre_empleado + '}';
    }
    
    
}
