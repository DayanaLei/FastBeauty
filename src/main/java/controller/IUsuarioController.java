package controller;

public interface IUsuarioController {
    public String login(String username, String contrasena);
    
    public String register(String username,String contrasena, String nombre, String apellidos, String email,String telefono);
     
    public String pedir(String username);
    
    public String modificar(String username, String nuevaContrasena, String nuevoNombre, String nuevosApellidos,String nuevoEmail, String nuevoTelefono);
    
    public String eliminar(String username);
}
