/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;
import Controlador.EventosDAO;
import Modelo.Eventos;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;

/**
 *
 * @author isabe
 */
public class PruebaEventos {
    
    public static void main(String[] args) throws SQLException {
    Scanner sc = new Scanner(System.in);
    Eventos evento  = new Eventos();
    EventosDAO dao = new EventosDAO();
    
    System.out.println("Ingrese el ID del evento: ");
    evento.setidEventos(sc.nextInt ());
    sc.nextLine();
    
    System.out.print ("Ingrese la descripción del evento: ");
    evento.setdescripevento(sc.nextLine());
    
    boolean resultado = dao.insertarEventos(evento);
    
    if (resultado) {
        System.out.println("\nEl evento se guardo correctamente.");
      
    } else {
        System.out.println("\nNo se pudo guardar el evento.");
    }
    System.out.println("\nListado de eventos en VIVEROBD");
        List<Eventos> lista = dao.consultarEventos(); 
        
        for (Eventos e : lista) {
            System.out.println("ID: " + e.getidEventos() + " Nombre: " + e.getdescripevento());
        }
 

        
        
        System.out.println("\nActualizar evento");
        System.out.print("Ingrese el ID del evento que va a modificar: ");
        int idMod = sc.nextInt();
        sc.nextLine(); 

        Eventos evMod = new Eventos();
        evMod.setidEventos(idMod);
        System.out.print("Ingrese la NUEVA descripción del evento: ");
        evMod.setdescripevento(sc.nextLine());

        if (dao.actualizarEvento(evMod)) {
            System.out.println("Cambio guardado exitosamente");
        } else {
            System.out.println("No se pudo actualizar.");
        }

        
        System.out.println("\nEliminar evento");
        System.out.print("Ingrese el ID del evento que va a eliminar: ");
        int idDel = sc.nextInt();

        if (dao.eliminarEvento(idDel)) {
            System.out.println("Evento eliminado de VIVEROBD.");
        } else {
            System.out.println("No se encontró el ID del evento.");
        }
    }
}