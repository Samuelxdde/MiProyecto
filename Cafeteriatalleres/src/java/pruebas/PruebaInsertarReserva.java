/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import Controlador.ReservaDAO;
import Modelo.Reserva;
import java.sql.SQLException;

import java.util.Scanner;
import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author Aprendiz
 */
public class PruebaInsertarReserva {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        Reserva Mireserva = new Reserva();
        ReservaDAO dao = new ReservaDAO();
        System.out.print("Ingrese el ID de la reserva:");
        sc.nextLine();

        System.out.print("Ingrese el numero de personas de la reserva:");
        Mireserva.setNum_personas(sc.nextInt());

        System.out.print("Ingrese la fecha de la reserva (YYYY-MM-DD): "); 
        Mireserva.setFecha(Date.valueOf(sc.nextLine())); 
        
        System.out.print("Ingrese la hora de la reserva (HH:MM): "); 
        Mireserva.setHora(Time.valueOf(sc.nextLine()));
        
        System.out.println("Ingrese el ID del usuario:");
        Mireserva.setUsuarios_idUsuarios(sc.nextInt());
        
        System.out.println("Ingrese el ID de la disponibilidad:");
        Mireserva.setDisponibilidad_idDisponibilidad(sc.nextInt());
        
        System.out.println("Ingrese el ID del estado de la reserva:");
        Mireserva.setEstado_reserva_idEstado_reserva(sc.nextInt());
        
        System.out.println("Ingrese el ID de la actividad:");
        Mireserva.setActividad_idActividad(sc.nextInt());

        System.out.println("Ingrese el ID del estado de pago:");
        Mireserva.setPagos_idPagos(sc.nextInt());

        boolean resultado = dao.insertarReserva(Mireserva);
        if (resultado) {
            System.out.println("\nLa reserva se guardo correctamente en VIVEROBD.");
        } else {
            System.out.println("\nNo se pudo hacer la reserva.");
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
