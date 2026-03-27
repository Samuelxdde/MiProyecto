/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Estado_reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author USER
 */
public class Estado_reservaDAO {
    Conexion conexion = new Conexion();
    
    public boolean insertarEstadoReserva(Estado_reserva estado) throws SQLException {
        boolean insertado = false;
        Connection con = conexion.getConn();
       
        String sql = "INSERT INTO Estado_reserva (idEstado_Reserva, descripcion_est) VALUES (?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, estado.getidEstado_reserva());
            ps.setString(2, estado.getdescripcion_esta());

            if (ps.executeUpdate() > 0) {
                insertado = true;
                System.out.println("Estado de reserva insertado con éxito.");
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar estado: " + e.getMessage());
        }
        return insertado;
    }

    
    

   
    public boolean actualizarEstadoReserva(Estado_reserva estado) throws SQLException {
        boolean actualizado = false;
        String sql = "UPDATE Estado_reserva SET descripcion_est=? WHERE idEstado_Reserva=?";
        Connection con = conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, estado.getdescripcion_esta());
            ps.setInt(2, estado.getidEstado_reserva());

            if (ps.executeUpdate() > 0) {
                actualizado = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar estado: " + e.getMessage());
        }
        return actualizado;
    }

  
    public boolean eliminarEstadoReserva(int id) throws SQLException {
        boolean eliminado = false;
        String sql = "DELETE FROM Estado_reserva WHERE idEstado_Reserva = ?";
        Connection con = conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                eliminado = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar estado: " + e.getMessage());
        }
        return eliminado;
    }
}
    

