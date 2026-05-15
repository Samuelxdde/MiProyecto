/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Controlador.Conexion;
import Modelo.Roles;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class RolesDAO {

    public boolean insertarRol(Roles rol) throws SQLException {
        boolean insertado = false;
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        String sql = "INSERT INTO roles (idRoles, descripcion_rol) VALUES (?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, rol.getidRoles());
            ps.setString(2, rol.getdescripcion_rol());
            ps.executeUpdate();
            insertado = true;
            System.out.println("Rol insertado correctamente en la base de datos viverobd.");
        } catch (SQLException e) {
            System.out.println("Error al insertar rol:" + e.getMessage());
        }
        return insertado;
    }

    public List<Roles> consultarRoles() throws SQLException {
        List<Roles> lista = new ArrayList<>();
        String sql = "SELECT * FROM roles";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Roles rol = new Roles();
                rol.setidRoles(rs.getInt("idRoles"));
                rol.setdescripcion_rol(rs.getString("descripcion_rol"));
                lista.add(rol);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar roles: " + e.getMessage());
        }
        return lista;
    }


    public boolean actualizarRol(Roles rol) throws SQLException {
        boolean actualizado = false;
        String sql = "UPDATE roles SET descripcion_rol = ? WHERE idRoles = ?";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, rol.getdescripcion_rol());
            ps.setInt(2, rol.getidRoles());

            if (ps.executeUpdate() > 0) {
                actualizado = true;
                System.out.println("Rol actualizado exitosamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar rol: " + e.getMessage());
        }
        return actualizado;
    }


    public boolean eliminarRol(int id) throws SQLException {
        boolean eliminado = false;
        String sql = "DELETE FROM roles WHERE idRoles = ?";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                eliminado = true;
                System.out.println("Rol eliminado de VIVEROBD.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar rol: " + e.getMessage());
        }
        return eliminado;
    }
}
