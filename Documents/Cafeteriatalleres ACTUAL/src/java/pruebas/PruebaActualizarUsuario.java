/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import Modelo.Usuarios;
import java.util.Scanner;
import Controlador.UsuariosDAO;
import java.sql.SQLException;

/**
 *
 * @author isabe
 */
public class PruebaActualizarUsuario {

    public static void main(String[] args) throws SQLException {
        
        Scanner sc = new Scanner(System.in);
        UsuariosDAO dao = new UsuariosDAO();
        
        System.out.println("\nActualizar usuario");
        System.out.print("ID del usuario a modificar: ");
        int idMod = sc.nextInt();
        sc.nextLine();
        Usuarios usuMod = new Usuarios();
        usuMod.setidUsuarios(idMod);
        System.out.print("Nuevo Nombre: ");
        usuMod.setnombre(sc.nextLine());
        System.out.print("Nuevo Apellido: ");
        usuMod.setapellido(sc.nextLine());
        System.out.print("Nuevo Numero de Documento: ");
        usuMod.setdocumento(sc.nextLine());
        System.out.print("Nuevo Telefono: ");
        usuMod.settelefono(sc.nextLine());
        System.out.print("Nuevo Correo: ");
        usuMod.setcorreo(sc.nextLine());
        System.out.print("Nuevo ID Tipo Documento: ");
        usuMod.setTipo_documento_idTipo_documento(sc.nextInt());
        System.out.print("Nuevo ID Rol: ");
        usuMod.setRoles_idRoles(sc.nextInt());
        
        if (dao.actualizarUsuario(usuMod)) {
            System.out.println("Usuario actualizado correctamente.");
        }

       
    }
    
}
