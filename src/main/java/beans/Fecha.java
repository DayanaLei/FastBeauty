package beans;


public class Fecha {
    
    private String fecha_servicio;
    private int id_servicio;
    private String username_usuario;
    private String nombre_servicio;
    
    public Fecha(String fecha_servicio, String username_usuario ,int id_servicio,String nombre_servicio) {
        this.fecha_servicio = fecha_servicio;
        this.id_servicio = id_servicio;
        this.username_usuario = username_usuario;
        this.nombre_servicio = nombre_servicio;
    }

    public String getUsername_usuario() {
        return username_usuario;
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public void setUsername_usuario(String username_usuario) {
        this.username_usuario = username_usuario;
    }

    public String getFecha_servicio() {
        return fecha_servicio;
    }

    public void setFecha_servicio(String  fecha_servicio) {
        this.fecha_servicio = fecha_servicio;
    }

   

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    @Override
    public String toString() {
        return "Fecha{" + "fecha_servicio=" + fecha_servicio + ", id_servicio=" + id_servicio + ", username_usuario=" + username_usuario + ", nombre_servicio=" + nombre_servicio + '}';
    }


}
