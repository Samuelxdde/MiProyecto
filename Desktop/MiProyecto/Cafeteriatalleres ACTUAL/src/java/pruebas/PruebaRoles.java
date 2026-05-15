/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import Controlador.RolesDAO;
import Modelo.Roles;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Aprendiz
 */
public class PruebaRoles {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        Roles rol = new Roles();
        RolesDAO dao = new RolesDAO();

        System.out.print("Ingrese el ID del rol:");
        rol.setidRoles(sc.nextInt());
        sc.nextLine();

        System.out.print("Ingrese la descripción del rol: ");
        rol.setdescripcion_rol(sc.nextLine());

        boolean resultado = dao.insertarRol(rol);

        if (resultado) {
            System.out.println("\nEl rol se guardo correctamente en VIVEROBD.");
        } else {
            System.out.println("\nNo se pudo guardar el rol.");
        }

        System.out.println("\n Listado de roles disponibles");

        List<Roles> lista = dao.consultarRoles();

        if (lista.isEmpty()) {
            System.out.println("No hay roles registrados.");
        } else {
            for (Roles r : lista) {
                System.out.println("ID: " + r.getidRoles() + " | Rol: " + r.getdescripcion_rol());
            }
            
            System.out.println("\nActualizar rol");
            System.out.print("Ingrese ID del rol que va a modificar: ");
            int idMod = sc.nextInt();
            sc.nextLine();

            Roles rolMod = new Roles();
            rolMod.setidRoles(idMod);
            System.out.print("Ingrese la nueva descripcion del rol: ");
            rolMod.setdescripcion_rol(sc.nextLine());

            if (dao.actualizarRol(rolMod)) {
                System.out.println("Cambio realizado");
            }

          
            System.out.println("\nEliminar rol");
            System.out.print("Ingrese ID del rol a eliminar: ");
            int idDel = sc.nextInt();

            if (dao.eliminarRol(idDel)) {
                System.out.println("Rol Eliminado de VIVEROBD.");
            } else {
                System.out.println("No se encontro el ID.");
            }
        }
    }
}
