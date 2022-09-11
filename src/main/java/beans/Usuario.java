package beans;

import java.sql.Date;

public class Usuario {

    private int id_usuario;
    private String contrasena_usuario;
    private String nombre_usuario;
    private String apellido_usuario;
    private Date fecha_nacimiento;
    private String email_usuario;
    private String telefono_usuario;

    public Usuario(int id_usuario, String contrasena_usuario, String nombre_usuario, String apellido_usuario, Date fecha_nacimiento, String email_usuario, String telefono_usuario) {
        this.id_usuario = id_usuario;
        this.contrasena_usuario = contrasena_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.fecha_nacimiento = fecha_nacimiento;
        this.email_usuario = email_usuario;
        this.telefono_usuario = telefono_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getContrasena_usuario() {
        return contrasena_usuario;
    }

    public void setContrasena_usuario(String contrasena_usuario) {
        this.contrasena_usuario = contrasena_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getTelefono_usuario() {
        return telefono_usuario;
    }

    public void setTelefono_usuario(String telefono_usuario) {
        this.telefono_usuario = telefono_usuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", contrasena_usuario=" + contrasena_usuario + ", nombre_usuario=" + nombre_usuario + ", apellido_usuario=" + apellido_usuario + ", fecha_nacimiento=" + fecha_nacimiento + ", email_usuario=" + email_usuario + ", telefono_usuario=" + telefono_usuario + '}';
    }

}
