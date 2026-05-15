package Servlet;

import Controlador.UsuariosDAO;
import Modelo.Usuarios;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet(name = "Registrarse", urlPatterns = {"/Registrarse"})
public class Registrarse extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // formulario
        String nombre = request.getParameter("nombrep");
        String apellido = request.getParameter("apellidoa");
        String documento = request.getParameter("documentoa");
        String telefono = request.getParameter("telefonoi");
        String correo = request.getParameter("correoz");
        String clave = request.getParameter("clavev");
        int Tipo_documento_idTipo_documento = Integer.parseInt(request.getParameter("tipodocs"));
        int Roles_idRoles = Integer.parseInt(request.getParameter("rola"));

        // Crear objeto 
        Usuarios usuario = new Usuarios();
        usuario.setnombre(nombre);
        usuario.setapellido(apellido);
        usuario.setdocumento(documento);
        usuario.settelefono(telefono);
        usuario.setcorreo(correo);
        usuario.setclave(clave);
        usuario.setTipo_documento_idTipo_documento(Tipo_documento_idTipo_documento);
        usuario.setRoles_idRoles(Roles_idRoles);

        // DAO 
        UsuariosDAO usuariosDao = new UsuariosDAO();
        boolean resultado = usuariosDao.insertarUsuarios(usuario);

        // JSP
        request.setAttribute("usuario", usuario);
        request.setAttribute("resultado", resultado);
        request.getRequestDispatcher("InicioSesion.jsp").forward(request, response);
    }
}
