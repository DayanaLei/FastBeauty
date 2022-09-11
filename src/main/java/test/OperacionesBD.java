package test;

import beans.Servicio;
import connection.DBConnection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD {

    public static void main(String[] args) {
        actualizarServicio(3, 50000.00);
        listarServicio();
    }

    public static void actualizarServicio(int id_servicio, Double costo_servicio) {
        DBConnection con = new DBConnection();
        String sql = "UPDATE servicio SET costo_servicio = ' " + costo_servicio + " ' WHERE id_servicio = " + id_servicio;
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }

    public static void listarServicio() {
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM servicio";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id_servicio = rs.getInt("id_servicio");
                String nombre_servicio = rs.getString("nombre_servicio");
                Date duracion = rs.getDate("duracion");
                Double costo_servicio = rs.getDouble("costo_servicio");
                String nombre_empleado = rs.getString("nombre_empleado");

                Servicio servicios = new Servicio(id_servicio, nombre_servicio, duracion, costo_servicio, nombre_empleado);
                System.out.println(servicios.toString());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }

}
