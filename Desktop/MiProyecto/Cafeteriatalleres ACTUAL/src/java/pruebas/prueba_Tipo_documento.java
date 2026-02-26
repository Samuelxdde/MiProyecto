/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import Controlador.Tipo_documentoDAO;
import Modelo.Tipo_documento;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class prueba_Tipo_documento {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Tipo_documento documento = new Tipo_documento();
        Tipo_documentoDAO dao = new Tipo_documentoDAO();

        System.out.print("Ingrese el ID del documento:");
        documento.setid(sc.nextInt());
        sc.nextLine();

        System.out.print("Ingrese la descripción del tipo documento:");
        documento.setdescripcion_doc(sc.nextLine());

        boolean resultado = dao.insertarTipo_documento(documento);

        if (resultado) {
            System.out.println("\nEl Tipo de documento se guardo con exito.");

        } else {
            System.out.println("\nNo se pudo guardar el Tipo de documento.");
        }
        System.out.println("\nListado de tipo de documenos en VIVEROBD");
        List<Tipo_documento> lista = dao.consultarTipo_documento();

        for (Tipo_documento e : lista) {
            System.out.println("ID: " + e.getid() + "Nombre: " + e.getdescripcion_doc());
        }



       
        System.out.println("\nActualizar tipo documento");
        System.out.print("ID del documento a modificar: ");
        int idMod = sc.nextInt();
        sc.nextLine();

        Tipo_documento docMod = new Tipo_documento();
        docMod.setid(idMod);
        System.out.print("Nueva descripción del tipo de documeno: ");
        docMod.setdescripcion_doc(sc.nextLine());

        if (dao.actualizarTipoDocumento(docMod)) {
            System.out.println("Cambio guardado en VIVEROBD.");
        }

     
        System.out.println("\nEliminar Tipo documento");
        System.out.print("ID del documento que va a eliminar: ");
        int idDel = sc.nextInt();

        if (dao.eliminarTipoDocumento(idDel)) {
            System.out.println("Tipo documento eliminado de VIVEROBD.");
        }
    }
}
