/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Modelo.Usuarios;
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

        String sql = "INSERT INTO usuarios (idUsuarios, nombre, apellido, documento, telefono, correo, clave, Tipo_documento_idTipo_documento, Roles_idRoles) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, usuarios.getidUsuarios());
            ps.setString(2, usuarios.getnombre());
            ps.setString(3, usuarios.getapellido());
            ps.setString(4, usuarios.getdocumento());
            ps.setString(5, usuarios.gettelefono());
            ps.setString(6, usuarios.getcorreo());
            ps.setString(7, usuarios.getclave());
            ps.setInt(8, usuarios.getTipo_documento_idTipo_documento());
            ps.setInt(9, usuarios.getRoles_idRoles());

            ps.executeUpdate();
            insertado = true;

            System.out.println("Usuario insertado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al insertar usuario." + e.getMessage());
        }
        return insertado;
    }

    public Usuarios ConsultaUsuarios(int idUsuario){
            Usuarios usuario = null;
        Conexion conexion =  new Conexion();
        Connection con = conexion.getConn();

        try{
            String querySQL = "SELECT idUsuarios, nombre, apellido, documento, telefono, correo, clave, Tipo_documento_idTipo_documento, Roles_idRoles FROM Usuarios WHERE idUsuarios = ? ";
            PreparedStatement ps = con.prepareStatement(querySQL);
            ps.setInt(1, idUsuario);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                usuario = new Usuarios();

                usuario.setnombre (rs.getString(2));
                usuario.setapellido(rs.getString(3));
                usuario.setdocumento(rs.getString(4));
                usuario.settelefono(rs.getString(5));
                usuario.setcorreo(rs.getString(6));
                usuario.setclave(rs.getString(7));
                usuario.setTipo_documento_idTipo_documento (rs.getInt(8));
                usuario.setRoles_idRoles(rs.getInt(9));

             }

            return usuario;
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
            return usuario;
        }
    }


    public boolean actualizarUsuario(Usuarios usuarios) throws SQLException {
        boolean actualizado = false;
        String sql = "UPDATE usuarios SET nombre=?, apellido=?, documento=?, telefono=?, correo=?, clave=?, Tipo_documento_idTipo_documento=?, Actividad_idActividad=?, Roles_idRoles=? WHERE idUsuarios=?";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuarios.getnombre());
            ps.setString(2, usuarios.getapellido());
            ps.setString(3, usuarios.getdocumento());
            ps.setString(4, usuarios.gettelefono());
            ps.setString(5, usuarios.getcorreo());
            ps.setString(6, usuarios.getclave());
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
