/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Modelo.Usuarios;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Aprendiz
 */
public class UsuariosDAO {

    Conexion conexion = new Conexion();

    public boolean insertarUsuarios(Usuarios usuarios) throws SQLException {
        boolean insertado = false;
        Connection con = conexion.getConn();

        String sql = "INSERT INTO usuarios (idUsuarios, nombre, apellido, documento, telefono, correo, Tipo_documento_idTipo_documento, Roles_idRoles) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, usuarios.getidUsuarios());
            ps.setString(2, usuarios.getnombre());
            ps.setString(3, usuarios.getapellido());
            ps.setString(4, usuarios.getdocumento());
            ps.setString(5, usuarios.gettelefono());
            ps.setString(6, usuarios.getcorreo());
            ps.setInt(7, usuarios.getTipo_documento_idTipo_documento());
            ps.setInt(8, usuarios.getRoles_idRoles());

            ps.executeUpdate();
            insertado = true;

            System.out.println("Clientes insertado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al insertar usuario." + e.getMessage());
        }
        return insertado;
    }

    public List<Usuarios> consultarUsuarios() throws SQLException {
        List<Usuarios> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        Connection con = conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Usuarios u = new Usuarios();
                    u.setidUsuarios(rs.getInt("idUsuarios"));
                    u.setnombre(rs.getString("nombre"));
                    u.setapellido(rs.getString("apellido"));
                    u.setdocumento(rs.getString("documento"));
                    u.settelefono(rs.getString("telefono"));
                    u.setcorreo(rs.getString("correo"));
                    lista.add(u);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar usuarios: " + e.getMessage());
        }
        return lista;
    }


    public boolean actualizarUsuario(Usuarios usuarios) throws SQLException {
        boolean actualizado = false;
        String sql = "UPDATE usuarios SET nombre=?, apellido=?, documento=?, telefono=?, correo=?, Tipo_documento_id=?, Actividad_idActividad=?, Roles_idRoles=? WHERE idUsuarios=?";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuarios.getnombre());
            ps.setString(2, usuarios.getapellido());
            ps.setString(3, usuarios.getdocumento());
            ps.setString(4, usuarios.gettelefono());
            ps.setString(5, usuarios.getcorreo());
            ps.setInt(6, usuarios.getTipo_documento_idTipo_documento());
            ps.setInt(7, usuarios.getRoles_idRoles());
            

            if (ps.executeUpdate() > 0) {
                actualizado = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el usuario: " + e.getMessage());
        }
        return actualizado;
    }


    public boolean eliminarUsuario(int id) throws SQLException {
        boolean eliminado = false;
        String sql = "DELETE FROM usuarios WHERE idUsuarios = ?";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                eliminado = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }
        return eliminado;
    }
}
