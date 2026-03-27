/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Modelo.Disponibilidad;

/**
 *
 * @author USER
 */
public class DisponibilidadDAO {
    public boolean insertarDisponibilidad(Disponibilidad disp) throws SQLException {
        boolean insertado = false;
        String sql = "INSERT INTO disponibilidad (idDisponibilidad, fecha, cupo_total, cupo_disponible, Horarios_idHorarios) VALUES (?, ?, ?, ?, ?)";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, disp.getidDisponibilidad());
            // Convertimos java.util.Date a java.sql.Date para la base de datos
            ps.setDate(2, new java.sql.Date(disp.getfecha().getTime()));
            ps.setInt(3, disp.getcupo_total());
            ps.setInt(4, disp.getcupo_disponible());
            ps.setInt(5, disp.getHorarios_idHorarios());

            if (ps.executeUpdate() > 0) insertado = true;
        }
        return insertado;
    }

   

    public boolean actualizarDisponibilidad(Disponibilidad disp) throws SQLException {
        boolean actualizado = false;
        String sql = "UPDATE disponibilidad SET fecha=?, cupo_total=?, cupo_disponible=?, Horarios_idHorarios=? WHERE idDisponibilidad=?";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, new java.sql.Date(disp.getfecha().getTime()));
            ps.setInt(2, disp.getcupo_total());
            ps.setInt(3, disp.getcupo_disponible());
            ps.setInt(4, disp.getHorarios_idHorarios());
            ps.setInt(5, disp.getidDisponibilidad());

            if (ps.executeUpdate() > 0) actualizado = true;
        }
        return actualizado;
    }


    public boolean eliminarDisponibilidad(int id) throws SQLException {
        boolean eliminado = false;
        String sql = "DELETE FROM disponibilidad WHERE idDisponibilidad = ?";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) eliminado = true;
        }
        return eliminado;
    }
}
    

