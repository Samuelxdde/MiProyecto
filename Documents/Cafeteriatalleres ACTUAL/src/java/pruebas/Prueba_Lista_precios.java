/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;
import Controlador.Lista_preciosDAO;
import Modelo.Lista_precios;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;

/**
 *
 * @author USER
 */
public class Prueba_Lista_precios {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        Lista_precios precio = new Lista_precios();
        Lista_preciosDAO dao = new Lista_preciosDAO();
        System.out.print("Ingrese el ID del precio:");
        sc.nextLine();

        System.out.print("Ingrese la descripcion del precio:");
        precio.setdescrip_precio(sc.nextLine());

        boolean resultado = dao.insertarLista_precios(precio);
        if (resultado) {
            System.out.println("\nEl precio se guardo correctamente en VIVEROBD.");
        } else {
            System.out.println("\nNo se pudo guardar el precio.");
        }
        System.out.println("\nListado de precio");
        List<Lista_precios> lista = dao.consultarListaPrecios();
        
       for (Lista_precios e : lista) {
            System.out.println("ID: " + e.getdescrip_precio()+ "Nombre: " + e.getdescrip_precio());
        }


        System.out.println("\nModificar precio existente");
        System.out.print("Ingrese el ID del precio que desea modificar: ");
        int idMod = sc.nextInt();
        sc.nextLine();

        Lista_precios resAct = new Lista_precios();
        resAct.setidLista_Precios(idMod);

        System.out.print("Ingrese la nueva descripcion de precios: ");
        resAct.setdescrip_precio(sc.nextLine());

        if (dao.actualizarListaPrecios(resAct)) {
            System.out.println(" Los precios ha sido actualizado correctamente.");
        } else {
            System.out.println("Error: No se encontró ningun precio con el ID " + idMod);
        }
       
        
        
        System.out.println("\nEliminar una reserva");
        System.out.print("Ingrese el ID de la reserva que va eliminar: ");
        int idEliminar = sc.nextInt();

        
        if (dao.eliminarListaPrecios(idEliminar)) {
            System.out.println("Precio eliminado de VIVEROBD");
        } else {
            System.out.println("No se encontro ningun precio con el ID: " + idEliminar);
        }

        sc.close(); 
 }
}