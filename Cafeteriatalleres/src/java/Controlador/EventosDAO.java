
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Controlador.Conexion;
import Modelo.Eventos;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author isabe
 */
public class EventosDAO {

    public boolean insertarEventos(Eventos evento) throws SQLException {
        boolean insertado = false;
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        String sql = "INSERT INTO eventos (idEventos, descripevento) VALUES (?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, evento.getidEventos());
            ps.setString(2, evento.getdescripevento());
            ps.executeUpdate();

            insertado = true;
            System.out.println("Evento insertado correctamente en VIVERODB.");

        } catch (SQLException e) {
            System.out.println("Error al insertar el evento." + e.getMessage());
        }
        return insertado;
    }

    public List<Eventos> consultarEventos() throws SQLException {
        List<Eventos> lista = new ArrayList<>();
        String sql = "SELECT * FROM eventos";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Eventos evento = new Eventos();
                    evento.setidEventos(rs.getInt("idEventos"));
                    evento.setdescripevento(rs.getString("descripevento"));

                    lista.add(evento);
                }

            } catch (SQLException e) {
                System.out.println("Error al consultar: " + e.getMessage());
            }
            return lista;
        }
    }

    public boolean actualizarEvento(Eventos evento) throws SQLException {
        boolean actualizado = false;
        String sql = "UPDATE eventos SET descripevento = ? WHERE idEventos = ?";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
         
            ps.setString(1, evento.getdescripevento());
          
            ps.setInt(2, evento.getidEventos());

            if (ps.executeUpdate() > 0) {
                actualizado = true;
                System.out.println("Evento actualizado correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar evento: " + e.getMessage());
        }
        return actualizado;
    }


    public boolean eliminarEvento(int id) throws SQLException {
        boolean eliminado = false;
        String sql = "DELETE FROM eventos WHERE idEventos = ?";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            if (ps.executeUpdate() > 0) {
                eliminado = true;
                System.out.println("Evento eliminado de VIVEROBD.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar evento: " + e.getMessage());
        }
        return eliminado;
    }
}
