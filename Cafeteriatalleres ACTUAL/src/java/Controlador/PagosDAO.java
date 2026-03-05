/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Pagos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paula Gisedt
 */
public class PagosDAO {
    
    
    public boolean insertarPago (Pagos pago) throws SQLException {
        boolean insertado = false;
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        String sql = "INSERT INTO pagos (idPagos, estado_pago) VALUES (?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, pago.getidPagos());
            ps.setString(2, pago.getestado_pago());
            ps.executeUpdate();
            insertado = true;
            System.out.println("Estado del pago insertado correctamente en la base de datos viverobd.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el estado del pago:" + e.getMessage());
        }
        return insertado;
    }

    public List<Pagos> consultarPagos() throws SQLException {
        List<Pagos> lista = new ArrayList<>();
        String sql = "SELECT * FROM pagos";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pagos pago = new Pagos();
                pago.setidPagos(rs.getInt("idPagos"));
                pago.setestado_pago(rs.getString("estado_pago"));
                lista.add(pago);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar el estado del pago: " + e.getMessage());
        }
        return lista;
    }


    public boolean actualizarPagos(Pagos pago) throws SQLException {
        boolean actualizado = false;
        String sql = "UPDATE pagos SET estado_pago = ? WHERE idPagos = ?";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, pago.getestado_pago());
            ps.setInt(2, pago.getidPagos());

            if (ps.executeUpdate() > 0) {
                actualizado = true;
                System.out.println("Estado de pago actualizado exitosamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el estado de pago: " + e.getMessage());
        }
        return actualizado;
    }


    public boolean eliminarPagos(int id) throws SQLException {
        boolean eliminado = false;
        String sql = "DELETE FROM pagos WHERE idPagos = ?";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                eliminado = true;
                System.out.println("Estado de pago eliminado de VIVEROBD.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el estado de pago: " + e.getMessage());
        }
        return eliminado;
    }
}
