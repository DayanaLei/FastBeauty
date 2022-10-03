/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;



/**
 *
 * @author JAIDER
 */
public interface IFechaController {
    public String register(String fecha_servicio,String username_usuario, int id_servicio, String nombre_servicio);
    
    public String listarReservas(String username);
}
