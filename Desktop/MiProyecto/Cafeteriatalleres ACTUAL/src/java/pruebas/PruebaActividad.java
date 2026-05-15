/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import Controlador.ActividadDAO;
import Modelo.Actividad;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class PruebaActividad {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Actividad actividad = new Actividad();
        ActividadDAO dao = new ActividadDAO();

        System.out.print("Ingrese el ID de la Actividad:");
        actividad.setidActividad(sc.nextInt());
        sc.nextLine();

        System.out.print("Ingrese la descripción de la Actividad:");
        actividad.setdescripcion_actividad(sc.nextLine());

        boolean resultado = dao.insertarActividad(actividad);
        if (resultado) {
            System.out.println("\n La actividad se guardo correctamente en VIVEROBD.");
        } else {
            System.out.println("\nNo se pudo guardar correctamente la actividad.");
        }

        System.out.println("\nListado de actividades");

        List<Actividad> lista = dao.consultarActividad();

        if (lista.isEmpty()) {
            System.out.println("No hay actividades registradas.");
        } else {
            for (Actividad a : lista) {
                System.out.println("ID: " + a.getidActividad() + " | Actividad: " + a.getdescripcion_actividad());
            }
        }
            System.out.println("\nActualizar una actividad");
            System.out.print("Ingrese el ID de la actividad que desea modificar: ");
            int idModificar = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Ingrese la NUEVA descripción para esta actividad: ");
            String nuevaDesc = sc.nextLine();

           
            Actividad actEditada = new Actividad();
            actEditada.setidActividad(idModificar);
            actEditada.setdescripcion_actividad(nuevaDesc);

            
            if (dao.actualizarActividad(actEditada)) {
                System.out.println("Actividad actualizada con éxito.");
            } else {
                System.out.println("Error: No se encontró actividad con ID: " + idModificar);
            }
        
    
        System.out.println("\n Eliminar una actividad");
        System.out.print("Ingrese el ID de la actividad que va a eliminar: ");
        int idEliminar = sc.nextInt();
        
        if (dao.eliminarActividad(idEliminar)) {
            System.out.println("Actividad eliminada de VIVEROBD.");
        } else {
            System.out.println("No se encontro ninguna actividad con el ID: " + idEliminar);
        }
        sc.close();
    }
}
