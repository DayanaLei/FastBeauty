package test;

import beans.Servicio;
import beans.Usuario;
import connection.DBConnection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesDB {
    
    public static void main(String[] args){
        //insertarServicio(13,"Manicure", "1:00:00" ,130000.00,"Alexander Zapata");
        
        //listarServicio();
        
        //actualizarServicio(8,"Paola Osorio");
        
        //eliminarServicio(12);
        
        agregarFecha("2022-12-10","alex",3);
        
        
    }
    
    
    public static void insertarServicio(int id_servicio, String nombre_servicio, String duracion, double costo_servicio, String nombre_empleado){
    
        DBConnection con = new DBConnection();
        String sql = "INSERT INTO servicio VALUES (" + id_servicio + ",'" + nombre_servicio + "','" + duracion + "'," + costo_servicio + ",'" + nombre_empleado+ "');";
    
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            System.out.println("Se ejecuto correctamente");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

    }
    
    public static void actualizarServicio( int id_servicio, String nombre_empleado){
        DBConnection con = new DBConnection();
        String sql = "UPDATE servicio SET nombre_empleado = '" + nombre_empleado + "' WHERE id_servicio = " + id_servicio + ";";
    
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }
    
    public static void listarServicio(){
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM servicio;";
        
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                int id_servicio = rs.getInt("id_servicio");
                String nombre_servicio = rs.getString("nombre_servicio");
                Date duracion = rs.getDate("duracion");
                double costo_servicio = rs.getDouble("costo_servicio");
                String nombre_empleado = rs.getString("nombre_empleado");
                
                Servicio servicio = new Servicio(id_servicio, nombre_servicio, duracion, costo_servicio, nombre_empleado);
                System.out.println(servicio.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            con.desconectar();
        }
    }
    
    public static void eliminarServicio(int id_servicio){
        DBConnection con = new DBConnection();
        String sql = "DELETE FROM servicio WHERE id_servicio = " + id_servicio + ";";
        
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

    
    }
    
    public static void agregarDatos(String username,String contrasena, String nombre, String apellidos, String email,String telefono) {
        DBConnection con = new DBConnection();
        String sql = "Insert into usuario values('" + username + "','" + contrasena + "', '" + nombre
                + "', '" + apellidos + "', '"  + email + "','" + telefono + "');";
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            Usuario usuario = new Usuario(username,contrasena,nombre, apellidos, email,telefono);
            System.out.println(usuario.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

    }
    
    public static void agregarFecha(String fecha,String username, int id) {
        DBConnection con = new DBConnection();
        String sql = "Insert into fecha values('" + fecha + "','" + username + "'," + id
                + ");";
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            System.out.println("Se ejecuto correctamente");
            //System.out.println(usuario.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

    }
}
