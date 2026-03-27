/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Modelo.Clientes;


/**
 *
 * @author Aprendiz
 */
public class ClientesDAO {
    Conexion conexion = new Conexion();
    
    public boolean insertarClientes (Clientes Usuarios) throws SQLException {
        boolean insertado = false;
        Connection con = conexion.getConn();
        
        String sql = "INSERT INTO Clientes (nombre, apellido, documento,telefono, correo, Tipo_documento_id, Actividad_idActividad, Roles_idRoles) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = con.prepareStatement (sql)) {
        
            ps.setString (1,Usuarios.getnombre());
            ps.setString (2, Usuarios.getapellido());
            ps.setString (3, Usuarios.getdocumendo());
            ps.setString (4, Usuarios.gettelefono());
            ps.setString (5, Usuarios.getcorreo());
            ps.setInt (6, Usuarios.getTipo_documento_id());
            ps.setInt (7, Usuarios.getActividad_idActividad());
            ps.setInt (8, Usuarios.getRoles_idRoles());
            
            ps.executeUpdate();
            insertado = true;
            
            System.out.println("Clientes insertado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al insertar clientes." + e.getMessage());
        }
         return insertado;
    }
}

         
            
        
    
    
    
    

