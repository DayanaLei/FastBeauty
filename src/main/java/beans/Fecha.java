package beans;

import java.sql.Date;

public class Fecha {

    private Date fecha_servicio;
    private int id_servicio;
    private int id_usuario;

    public Fecha(Date fecha_servicio, int id_servicio, int id_usuario) {
        this.fecha_servicio = fecha_servicio;
        this.id_servicio = id_servicio;
        this.id_usuario = id_usuario;
    }

    public Date getFecha_servicio() {
        return fecha_servicio;
    }

    public void setFecha_servicio(Date fecha_servicio) {
        this.fecha_servicio = fecha_servicio;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Fecha{" + "fecha_servicio=" + fecha_servicio + ", id_servicio=" + id_servicio + ", id_usuario=" + id_usuario + '}';
    }

}
