package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Modelo.Reserva;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

public class ReservaDAO {

    Conexion conexion = new Conexion();

    public boolean insertarReserva(Reserva Mireserva) {
        boolean insertado = false;
        Connection con = conexion.getConn();

        String sql = "INSERT INTO Reserva (num_personas, hora, fecha, Usuarios_idUsuarios) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, Mireserva.getNum_personas());
            ps.setString(2, Mireserva.getHora());
            ps.setString(3, Mireserva.getFecha());
            ps.setInt(4, Mireserva.getUsuarios_idUsuarios());

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
                    Mireserva.setNum_personas(rs.getString("Num_personas"));
                    Mireserva.setHora(rs.getString("Hora"));
                    Mireserva.setFecha(rs.getString("Fecha"));
                    Mireserva.setUsuarios_idUsuarios(rs.getInt("Usuarios_idUsuarios"));

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
            ps.setString(1, reserva.getNum_personas());
            ps.setString(2, reserva.getHora());
            ps.setString(3, reserva.getFecha());
            ps.setInt(4, reserva.getUsuarios_idUsuarios());
            ps.setInt(5, reserva.getidReserva());

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
