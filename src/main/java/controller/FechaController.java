/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import beans.Fecha;
import com.google.gson.Gson;
import connection.DBConnection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class FechaController implements IFechaController{
    
    @Override
    public String register(String fecha_servicio,String username_usuario, int id_servicio,String nombre_servicio) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        
        String sql = "Insert into fecha values('" + fecha_servicio + "','" + username_usuario + "', " + id_servicio+ ");";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Fecha fecha = new Fecha(fecha_servicio, username_usuario,id_servicio,nombre_servicio);

            st.close();

            return gson.toJson(fecha);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }
    
    @Override
    public String listarReservas(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "SELECT l.fecha_servicio, l.username_usuario,a.nombre_servicio,l.id_servicio FROM fecha l INNER JOIN servicio a ON l.id_servicio = a.id_servicio INNER JOIN"
                + " usuario u ON l.username_usuario = u.username_usuario WHERE l.username_usuario ='" + username +"';";

        List<String> reservas = new ArrayList<>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Timestamp fechaTime = rs.getTimestamp("fecha_servicio");
                String fecha_servicio = fechaTime.toString();
                String username_usuario = rs.getString("username_usuario");
                String nombre_servicio = rs.getString("nombre_servicio");
                int id_servicio = rs.getInt("id_servicio");

                Fecha fecha = new Fecha(fecha_servicio,username_usuario,id_servicio,nombre_servicio);

                reservas.add(gson.toJson(fecha));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return gson.toJson(reservas);
    }
}
