/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import Controlador.ReservaDAO;
import Modelo.Reserva;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Aprendiz
 */
public class PruebaReserva {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        Reserva Mireserva = new Reserva();
        ReservaDAO dao = new ReservaDAO();
        System.out.print("Ingrese el ID de la reserva:");
        sc.nextLine();

        System.out.print("Ingrese el numero de personas de la reserva:");
        Mireserva.setNum_personas(sc.nextLine());

        System.out.print("Ingrese la fecha de la reserva: ");
        Mireserva.setFecha(sc.nextLine());

        System.out.print("Ingrese la hora de la reserva:");
        Mireserva.setHora(sc.nextLine());

        System.out.println("Ingrese el ID del usuario:");
        Mireserva.setUsuarios_idUsuarios(sc.nextInt());

        boolean resultado = dao.insertarReserva(Mireserva);
        if (resultado) {
            System.out.println("\nLa reserva se guardo correctamente en VIVEROBD.");
        } else {
            System.out.println("\nNo se pudo hacer la reserva.");
        }
        System.out.println("\nListado de reservas");
        List<Reserva> lista = dao.consultarReserva();

        if (lista != null) {
            for (Reserva r : lista) {
                System.out.println("Fecha: " + r.getFecha()
                        + " Hora: " + r.getHora()
                        + " Personas: " + r.getNum_personas());
            }
        }

        System.out.println("\nModificar reserva existente");
        System.out.print("Ingrese el ID de la reserva que desea modificar: ");
        int idMod = sc.nextInt();
        sc.nextLine();

        Reserva resAct = new Reserva();
        resAct.setidReserva(idMod);

        System.out.print("Ingrese la nueva cantidad de personas: ");
        resAct.setNum_personas(sc.nextLine());

        System.out.print("Ingrese la nueva hora: ");
        resAct.setHora(sc.nextLine());

        System.out.print("Ingrese la nueva fecha: ");
        resAct.setFecha(sc.nextLine());

        System.out.print("Ingrese el nuevo ID de Usuario asignado: ");
        resAct.setUsuarios_idUsuarios(sc.nextInt());

        if (dao.actualizarReserva(resAct)) {
            System.out.println(" La reserva ha sido actualizada correctamente.");
        } else {
            System.out.println("Error: No se encontró ninguna reserva con el ID " + idMod);
        }
       
        
        
        System.out.println("\nEliminar una reserva");
        System.out.print("Ingrese el ID de la reserva que va eliminar: ");
        int idEliminar = sc.nextInt();

        
        if (dao.eliminarReserva(idEliminar)) {
            System.out.println("Reserva eliminada de VIVEROBD");
        } else {
            System.out.println("No se encontro ninguna reserva con el ID: " + idEliminar);
        }

        sc.close(); 
    }
}
