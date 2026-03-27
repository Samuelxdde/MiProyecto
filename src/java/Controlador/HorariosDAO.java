/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Horarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author USER
 */

public class HorariosDAO {

    Conexion conexion = new Conexion();

   
    public boolean insertarHorarios(Horarios horario) throws SQLException {
        boolean insertado = false;
        Connection con = conexion.getConn();

        
        String sql = "INSERT INTO Horarios (idHorarios, hora_ini, hora_fin) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, horario.getidHorarios());
            ps.setTime(2, horario.gethora_ini());
            ps.setTime(3, horario.gethora_fin());

            if (ps.executeUpdate() > 0) {
                insertado = true;
                System.out.println("Horario insertado con éxito.");
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar horario: " + e.getMessage());
        }
        return insertado;
    }

    


   
    public boolean actualizarHorario(Horarios horario) throws SQLException {
        boolean actualizado = false;
        String sql = "UPDATE Horarios SET hora_ini=?, hora_fin=? WHERE idHorarios=?";
        Connection con = conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setTime(1, horario.gethora_ini());
            ps.setTime(2, horario.gethora_fin());
            ps.setInt(3, horario.getidHorarios());

            if (ps.executeUpdate() > 0) {
                actualizado = true;
                System.out.println("Horario actualizado correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el horario: " + e.getMessage());
        }
        return actualizado;
    }

    
    public boolean eliminarHorario(int id) throws SQLException {
        boolean eliminado = false;
        String sql = "DELETE FROM Horarios WHERE idHorarios = ?";
        Connection con = conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                eliminado = true;
                System.out.println("Horario eliminado exitosamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el horario: " + e.getMessage());
        }
        return eliminado;
    }
}
