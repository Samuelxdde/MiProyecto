/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;
import Controlador.Estado_reservaDAO;
import Modelo.Estado_reserva;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;

/**
 *
 * @author USER
 */
public class PruebaEstado_reserva {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Estado_reserva estado = new Estado_reserva();
        Estado_reservaDAO dao = new Estado_reservaDAO(); 
        
        System.out.print("Ingrese el ID del Estado de Reserva: ");
        estado.setidEstado_reserva(sc.nextInt()); 
        sc.nextLine();
        
        System.out.print("Ingrese la descripción del Estado (ej: Pendiente): ");
        estado.setdescripcion_esta(sc.nextLine());

        

        boolean resultado = dao.insertarEstadoReserva(estado);
        if (resultado) {
            System.out.println("\nEl Estado se guardo correctamente en VIVEROBD.");
        } else {
            System.out.println("\nEl estado no se guardo.");
        }

        System.out.println("\nLista completa de estados de reserva");

        List<Estado_reserva> lista = dao.consultarEstadoReserva();

        for (Estado_reserva e : lista) {
            System.out.println("ID: " + e.getidEstado_reserva() + " Descripción: " + e.getdescripcion_esta());
        }

        System.out.println("\nActualizar estado");
        System.out.print("ID del estado a modificar: ");
        int idMod = sc.nextInt();
        sc.nextLine();
        
        Estado_reserva estMod = new Estado_reserva();
        estMod.setidEstado_reserva(idMod);
        
        System.out.print("Nueva Descripción: ");
        estMod.setdescripcion_esta(sc.nextLine());
        
        if (dao.actualizarEstadoReserva(estMod)) {
            System.out.println("Estado actualizado correctamente.");
        }

        System.out.println("\nEliminar Estado");
        System.out.print("ID del estado a eliminar: ");
        int idEstado_reserva = sc.nextInt();

        if (dao.eliminarEstadoReserva(idEstado_reserva)) {
            System.out.println("Estado eliminado con exito.");
        } else {
            System.out.println("No se encontró el estado.");
        }
    }
}