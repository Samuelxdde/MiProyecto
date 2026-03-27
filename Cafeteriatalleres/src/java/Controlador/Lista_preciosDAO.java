/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Lista_precios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author USER
 */
public class Lista_preciosDAO {

    public Lista_preciosDAO() {
    }

    Conexion conexion = new Conexion();
    public boolean insertarLista_precios(Lista_precios precio) throws SQLException {
        boolean insertado = false;
        Connection con = conexion.getConn();

       
        String sql = "INSERT INTO Lista_Precios (idLista_Precios, descrip_precio) VALUES (?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, precio.getidLista_Precio());
            ps.setString(2, precio.getdescrip_precio()); 

            if (ps.executeUpdate() > 0) {
                insertado = true;
                System.out.println("Precio insertado con éxito en la lista.");
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar en lista de precios: " + e.getMessage());
        }
        return insertado;
    }

    
    

    
    public boolean actualizarListaPrecios(Lista_precios precio) throws SQLException {
        boolean actualizado = false;
        String sql = "UPDATE Lista_Precios SET descrip_precio=? WHERE idLista_Precios=?";
        Connection con = conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, precio.getidLista_Precio());
            ps.setString(2, precio.getdescrip_precio());

            if (ps.executeUpdate() > 0) {
                actualizado = true;
                System.out.println("Lista de precios actualizada correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar la lista de precios: " + e.getMessage());
        }
        return actualizado;
    }


    public boolean eliminarListaPrecios(int id) throws SQLException {
        boolean eliminado = false;
        String sql = "DELETE FROM Lista_Precios WHERE idLista_Precios = ?";
        Connection con = conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                eliminado = true;
                System.out.println("Registro eliminado de la lista de precios.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar de la lista de precios: " + e.getMessage());
        }
        return eliminado;
    }
}
    

