package beans;



public class Usuario {

    private String contrasena_usuario;
    private String username_usuario;
    private String nombre_usuario;
    private String apellido_usuario;
    private String email_usuario;
    private String telefono_usuario;

    public Usuario(String username_usuario, String contrasena_usuario, String nombre_usuario, String apellido_usuario, String email_usuario, String telefono_usuario) {
        this.contrasena_usuario = contrasena_usuario;
        this.username_usuario = username_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.email_usuario = email_usuario;
        this.telefono_usuario = telefono_usuario;
    }

    public String getUsername_usuario() {
        return username_usuario;
    }

    public void setUsername_usuario(String username_usuario) {
        this.username_usuario = username_usuario;
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
        return "Usuario{" + "username_usuario=" + username_usuario + ", contrasena_usuario=" + contrasena_usuario + ", nombre_usuario=" + nombre_usuario + ", apellido_usuario=" + apellido_usuario +", email_usuario=" + email_usuario + ", telefono_usuario=" + telefono_usuario + "}";
    }
    
    
}
