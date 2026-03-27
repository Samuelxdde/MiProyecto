/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import Controlador.UsuariosDAO;
import Modelo.Usuarios;

/**
 *
 * @author Aprendiz
 */
public class PruebaConsultarUsuarios {

  

    
    public static void main(String[] args) {
        UsuariosDAO usuariosDao = new UsuariosDAO();
            Usuarios usuario = usuariosDao.ConsultaUsuarios(1);
            
            if (usuario != null){
                System.out.println("Usuario encontrado");
                System.out.println("Nombre: " + usuario.getnombre());
         
            } else  {
                System.out.println("Usuario no encontrado");
            }
        
        // TODO code application logic here
    }
    
}
