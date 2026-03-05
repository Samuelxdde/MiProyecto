package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Modelo.Reserva;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Date;

public class ReservaDAO {

    Conexion conexion = new Conexion();

    public boolean insertarReserva(Reserva Mireserva) {
        boolean insertado = false;
        Connection con = conexion.getConn();

        String sql = "INSERT INTO Reserva (num_personas, hora, fecha, Usuarios_idUsuarios) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, Mireserva.getidReserva());
            ps.setInt(2, Mireserva.getNum_personas());
            ps.setTime (3, Mireserva.getHora());
            ps.setDate(4, (java.sql.Date) Mireserva.getFecha());
            ps.setInt(5, Mireserva.getUsuarios_idUsuarios());
            ps.setInt(6, Mireserva.getDisponibilidad_idDisponibilidad());
            ps.setInt(7, Mireserva.getEstado_reserva_idEstado_reserva());
            ps.setInt(8, Mireserva.getActividad_idActividad());
            ps.setInt(9, Mireserva.getPagos_idPagos());
            
            ps.executeUpdate();
            insertado = true;

            System.out.println("Reserva insertada con éxito.");

        } catch (SQLException e) {
            System.out.println("Error al insertar Reserva: " + e.getMessage());
        }

        return insertado;
    }

    public List<Reserva> consultarReserva() throws SQLException {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM Mireserva";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Reserva Mireserva = new Reserva();
                    Mireserva.setNum_personas(rs.getInt("Num_personas"));
                    Mireserva.setHora(rs.getTime("Hora"));
                    Mireserva.setFecha(rs.getDate("Fecha"));
                    Mireserva.setUsuarios_idUsuarios(rs.getInt("Usuarios_idUsuarios"));
                    Mireserva.setDisponibilidad_idDisponibilidad(rs.getInt("Disponibilidad_idDisponibilidad"));
                    Mireserva.setDisponibilidad_idDisponibilidad(rs.getInt("Disponibilidad_idDisponibilidad"));
                    Mireserva.setActividad_idActividad( rs.getInt("Actividad_idActividad"));
                    Mireserva.setPagos_idPagos(rs.getInt("Pagos_idPagos"));
                    
                    lista.add(Mireserva);
                }
            } catch (SQLException e) {
                System.out.println("Error al consultar:" + e.getMessage());
            }
            return lista;
        }
    }

    public boolean actualizarReserva(Reserva reserva) throws SQLException {
        boolean actualizado = false;

        String sql = "UPDATE Mireserva SET Num_personas = ?, Hora = ?, Fecha = ?, Usuarios_idUsuarios = ? WHERE idReserva = ?";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
          
            ps.setInt(1, reserva.getidReserva());
            ps.setInt(2, reserva.getNum_personas());
            ps.setTime(3, reserva.getHora());
            ps.setDate(4, (java.sql.Date) reserva.getFecha());
            ps.setInt(5, reserva.getUsuarios_idUsuarios());
            ps.setInt(6, reserva.getDisponibilidad_idDisponibilidad());
            ps.setInt(7, reserva.getEstado_reserva_idEstado_reserva());
            ps.setInt( 8, reserva.getActividad_idActividad());
            ps.setInt( 8, reserva.getPagos_idPagos());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                actualizado = true;
                System.out.println("Reserva actualizada correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar reserva: " + e.getMessage());
        }
        return actualizado;
    }

    public boolean eliminarReserva(int id) throws SQLException {
        boolean eliminado = false;
        String sql = "DELETE FROM Mireserva WHERE idReserva = ?";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                eliminado = true;
                System.out.println("Reserva eliminada de VIVEROBD.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar reserva: " + e.getMessage());
        }
        return eliminado;
    }
}
