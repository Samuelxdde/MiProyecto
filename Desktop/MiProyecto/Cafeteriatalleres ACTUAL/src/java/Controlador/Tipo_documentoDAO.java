/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Controlador.Conexion;
import Modelo.Tipo_documento;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Aprendiz
 */
public class Tipo_documentoDAO {

    public boolean insertarTipo_documento(Tipo_documento documento) throws SQLException {
        boolean insertado = false;
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        String sql = "INSERT INTO tipo_documento (id, descripcion_doc) VALUES (?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, documento.getid());
            ps.setString(2, documento.getdescripcion_doc());
            ps.executeUpdate();

            insertado = true;

            System.out.println("Tipo de documento insertado correctamente en VIVEROBD.");

        } catch (SQLException e) {
            System.out.println("Error al insertar el Tipo de documento." + e.getMessage());
        }
        return insertado;
    }

    public List<Tipo_documento> consultarTipo_documento() throws SQLException {
        List<Tipo_documento> lista = new ArrayList<>();
        String sql = "SELECT * FROM documento";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Tipo_documento documento = new Tipo_documento();
                    documento.setid(rs.getInt("idTipo_documento"));
                    documento.setdescripcion_doc(rs.getString("descripcion_doc"));

                    lista.add(documento);
                }
            } catch (SQLException e) {
                System.out.println("Error al consultar: " + e.getMessage());
            }
            return lista;
        }
    }


    public boolean actualizarTipoDocumento(Tipo_documento documento) throws SQLException {
        boolean actualizado = false;
        String sql = "UPDATE tipo_documento SET descripcion_doc = ? WHERE id = ?";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, documento.getdescripcion_doc());
            ps.setInt(2, documento.getid());

            if (ps.executeUpdate() > 0) {
                actualizado = true;
                System.out.println("Tipo de documento actualizado correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
        return actualizado;
    }


    public boolean eliminarTipoDocumento(int id) throws SQLException {
        boolean eliminado = false;
        String sql = "DELETE FROM tipo_documento WHERE id = ?";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                eliminado = true;
                System.out.println("Tipo de documento eliminado de VIVEROBD.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
        return eliminado;
    }
}
