/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import Controlador.UsuariosDAO;
import Modelo.Usuarios;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;

/**
 *
 * @author USER
 */
public class PruebaUsuario {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Usuarios usuarios = new Usuarios();
        UsuariosDAO dao = new UsuariosDAO();
        System.out.print("Ingrese el ID del Usuario: ");
        sc.nextLine();

        System.out.print("Ingrese el nombre del Usuario:");
        usuarios.setnombre(sc.nextLine());

        System.out.print("Ingrese el apellido del Usuario:");
        usuarios.setapellido(sc.nextLine());

        System.out.print("Ingrese el documento del Usuario:");
        usuarios.setdocumento(sc.nextLine());

        System.out.print("Ingrese el telefono del Usuario:");
        usuarios.settelefono(sc.nextLine());

        System.out.print("Ingrese el correo del Usuario:");
        usuarios.setcorreo(sc.nextLine());

        System.out.print("Ingrese el ID de Tipo documento:");
        usuarios.setTipo_documento_id(sc.nextInt());

        System.out.print("Ingrese el ID de Roles:");
        usuarios.setRoles_idRoles(sc.nextInt());

        boolean resultado = dao.insertarUsuarios(usuarios);
        if (resultado) {
            System.out.println("\nEl Usuario se guardo correctamente en VIVEROBD.");

        } else {
            System.out.println("\nEl usuario no se guardo.");
        }



       


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
        usuMod.setTipo_documento_id(sc.nextInt());
        System.out.print("Nuevo ID Rol: ");
        usuMod.setRoles_idRoles(sc.nextInt());
        
        if (dao.actualizarUsuario(usuMod)) {
            System.out.println("Usuario actualizado correctamente.");
        }


        System.out.println("\nEliminar Usuario");
        System.out.print("ID del usuario a eliminar: ");
        int idDel = sc.nextInt();

        if (dao.eliminarUsuario(idDel)) {
            System.out.println("Usuario eliminado con exito.");
        } else {
            System.out.println("No se encontró el usuario.");
        }
    }
}

