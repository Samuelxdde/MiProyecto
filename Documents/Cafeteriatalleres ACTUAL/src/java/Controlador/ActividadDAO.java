/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Controlador.Conexion;
import Modelo.Actividad;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author Aprendiz
 */
public class ActividadDAO {

    public boolean insertarActividad(Actividad actividad) throws SQLException {
        boolean insertado = false;
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        String sql = "INSERT INTO actividad (idActividad, descripcion_actividad ) VALUES (?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, actividad.getidActividad());
            ps.setString(2, actividad.getdescripcion_actividad());
            ps.executeUpdate();
            ps.setInt(1, actividad.getTipo_Actividad_idTipo_Actividad());
            ps.setInt(1, actividad.getLista_Precios_idLista_Precios());
            
            insertado = true;
            System.out.println("Actividad insertado con exito.");

        } catch (SQLException e) {
            System.out.println("Error al insertar actividad:" + e.getMessage());
        }

        return insertado;

    }

    public Actividad ConsultaUsuarios(int idActividad){
        Actividad actividad = null;
    Conexion conexion =  new Conexion();
    Connection con = conexion.getConn();
   
    try{
        String querySQL = "SELECT idActividad, descripcion_actividad, Tipo_Actividad_idTipo_actividad, Lista_precios_idLista_precios) FROM Actividad WHERE idActividad = ?";
        PreparedStatement ps = con.prepareStatement(querySQL);
        ps.setInt(1, idActividad);
       
        ResultSet rs = ps.executeQuery();
       
        if(rs.next()){
            actividad = new Actividad();
            
            actividad.setidActividad(rs.getInt(1));
            actividad.setdescripcion_actividad (rs.getString(2));
            
         }
       
        return actividad;
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
            return actividad;
        }
    }

    

    public boolean actualizarActividad(Actividad actividad) throws SQLException {
        boolean actualizado = false;

        String sql = "UPDATE actividad SET descripcion_actividad = ? WHERE idActividad = ?";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, actividad.getdescripcion_actividad());
            ps.setInt(2, actividad.getidActividad());
            ps.setInt(2, actividad.getTipo_Actividad_idTipo_Actividad());
            ps.setInt(2, actividad.getLista_Precios_idLista_Precios());

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                actualizado = true;
                System.out.println("Actividad actualizada con éxito en la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar actividad: " + e.getMessage());
        }
        return actualizado;
    }

    public boolean eliminarActividad(int id) throws SQLException {
        boolean eliminado = false;
        String sql = "DELETE FROM actividad WHERE idActividad = ?";
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.getConn();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                eliminado = true;
                System.out.println("Actividad eliminada de la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
        return eliminado;
    }
}
