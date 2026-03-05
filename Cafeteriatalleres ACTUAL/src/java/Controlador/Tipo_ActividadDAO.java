/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Controlador.Conexion;
import Modelo.Tipo_Actividad;
import Modelo.Tipo_documento;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author USER
 */
public class Tipo_ActividadDAO {
    public boolean insertarTipo_Actividad(Tipo_Actividad Mitipoactividad) throws SQLException {
        boolean insertado = false;
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        String sql = "INSERT INTO Tipo_Actividad (idTipo_Actividad, nombre_activi) VALUES (?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, Mitipoactividad.getidTipo_Actividad());
            ps.setString(2, Mitipoactividad.getnombre_activi());
            ps.executeUpdate();

            insertado = true;

            System.out.println("Tipo de actividad insertado correctamente en VIVEROBD.");

        } catch (SQLException e) {
            System.out.println("Error al insertar el Tipo de actividad." + e.getMessage());
        }
        return insertado;
    }

    public List<Tipo_Actividad> consultarTipo_Actividad() throws SQLException {
        List<Tipo_Actividad> lista = new ArrayList<>();
        String sql = "SELECT * FROM documento";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Tipo_Actividad Mitipoactividad;
                    Mitipoactividad = new Tipo_Actividad();
                    Mitipoactividad.setid(rs.getInt("idTipo_Actividad"));
                    Mitipoactividad.setnombre_activi(rs.getString("nombre_activi"));

                    lista.add(Mitipoactividad);
                }
            } catch (SQLException e) {
                System.out.println("Error al consultar: " + e.getMessage());
            }
            return lista;
        }
    }


    public boolean actualizarTipoActividad(Tipo_Actividad Mitipoactividad) throws SQLException {
        boolean actualizado = false;
        String sql = "UPDATE tipo_actividad SET nombre_activi = ? WHERE id = ?";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, Mitipoactividad.getnombre_activi());
            ps.setInt(2, Mitipoactividad.getidTipo_Actividad());

            if (ps.executeUpdate() > 0) {
                actualizado = true;
                System.out.println("Tipo de actividad actualizado correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
        return actualizado;
    }


    public boolean eliminarTipoActividad (int idTipo_Actividad) throws SQLException {
        boolean eliminado = false;
        String sql = "DELETE FROM tipo_actividad WHERE id = ?";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idTipo_Actividad);
            if (ps.executeUpdate() > 0) {
                eliminado = true;
                System.out.println("Tipo de actividad eliminado de VIVEROBD.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
        return eliminado;
    }

   
}
    

