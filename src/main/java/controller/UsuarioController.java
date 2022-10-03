package controller;

import beans.Usuario;
import com.google.gson.Gson;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;


public class UsuarioController implements IUsuarioController{
    
    @Override
    public String login(String username, String contrasena) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select * from usuario where username_usuario = '" + username
                + "' and contrasena_usuario = '" + contrasena + "'";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String nombre = rs.getString("nombre_usuario");
                String apellidos = rs.getString("apellido_usuario");
                String email = rs.getString("email_usuario");
                String telefono = rs.getString("telefono_usuario");

                Usuario usuario
                        = new Usuario(username,contrasena,nombre,apellidos,email,telefono);
                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
    
    @Override
    public String register(String username,String contrasena, String nombre, String apellidos, String email,String telefono) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Insert into usuario values('" + username + "','" + contrasena + "', '" + nombre
                + "', '" + apellidos + "','" + email + "','" + telefono + "');";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Usuario usuario = new Usuario(username,contrasena,nombre,apellidos,email,telefono);

            st.close();

            return gson.toJson(usuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }
    
    @Override
    public String pedir(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from usuario where username_usuario = '" + username + "'";

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String contrasena = rs.getString("contrasena_usuario");
                String nombre = rs.getString("nombre_usuario");
                String apellidos = rs.getString("apellido_usuario");
                String email = rs.getString("email_usuario");
                String telefono = rs.getString("telefono_usuario");


                Usuario usuario = new Usuario(username, contrasena,
                        nombre, apellidos,email, telefono);

                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
    
    @Override
    public String modificar(String username, String nuevaContrasena, 
            String nuevoNombre, String nuevosApellidos,
            String nuevoEmail, String nuevoTelefono) {   

        DBConnection con = new DBConnection();

        String sql = "Update usuario set contrasena_usuario = '" + nuevaContrasena +
                "', nombre_usuario = '" + nuevoNombre + "', "
                + "apellido_usuario = '" + nuevosApellidos +  "', " + " email_usuario = '" 
                + nuevoEmail + "', telefono_usuario = '" + nuevoTelefono;

        sql += "' where username_usuario = '" + username + "'";

        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";

    }
    
    @Override
    public String eliminar(String username) {

        DBConnection con = new DBConnection();

        String sql1 = "Delete from fecha where username_usuario = '" + username + "'";
        String sql2 = "Delete from usuario where username_usuario = '" + username + "'";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql1);
            st.executeUpdate(sql2);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
}
