/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;
import Controlador.HorariosDAO;
import Modelo.Horarios;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Scanner;
import java.util.List;

/**
 *
 * @author USER
 */
public class PruebaHorarios {

  public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Horarios horario = new Horarios();
        HorariosDAO dao = new HorariosDAO();

        System.out.print("Ingrese el ID del Horario: ");
        horario.setidHorarios(sc.nextInt());
        sc.nextLine(); 

        System.out.print("Ingrese la hora de inicio (Formato hh:mm:ss): ");
        horario.sethora_ini(Time.valueOf(sc.nextLine()));

        System.out.print("Ingrese la hora de fin (Formato hh:mm:ss): ");
        horario.sethora_fin(Time.valueOf(sc.nextLine()));

        if (dao.insertarHorarios(horario)) {
            System.out.println("\nEl horario se guardó correctamente.");
        } else {
            System.out.println("\nEl horario no se pudo guardar.");
        }

      
        System.out.println("\nLista de horarios");
        List<Horarios> lista = dao.consultarHorarios();
        for (Horarios h : lista) {
            System.out.println("ID: " + h.getidHorarios() + 
                               " Inicio: " + h.gethora_ini() + 
                               " Fin: " + h.gethora_fin());
        }

        
        System.out.println("\nActualización de Horario");
        System.out.print("ID del horario a modificar: ");
        int idMod = sc.nextInt();
        sc.nextLine(); 

        Horarios horMod = new Horarios();
        horMod.setidHorarios(idMod);

        System.out.print("Nueva hora de inicio (hh:mm:ss): ");
        horMod.sethora_ini(Time.valueOf(sc.nextLine()));

        System.out.print("Nueva hora de fin (hh:mm:ss): ");
        horMod.sethora_fin(Time.valueOf(sc.nextLine()));

        if (dao.actualizarHorario(horMod)) {
            System.out.println("Horario actualizado correctamente.");
        }

        
        System.out.println("\nElminar Horario");
        System.out.print("ID del horario a eliminar: ");
        int idDel = sc.nextInt();

        if (dao.eliminarHorario(idDel)) {
            System.out.println("Horario eliminado de viverobd.");
        } else {
            System.out.println("No se encontró el ID del horario.");
        }
    }
}
