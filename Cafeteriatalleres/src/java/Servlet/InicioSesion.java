package Servlet;

import Controlador.UsuariosDAO;
import Modelo.Usuarios;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Iniciar")
public class InicioSesion extends HttpServlet {

    /**
     * Método para procesar el login con POST
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Captura los datos del formulario
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("pass");

        // Consulta el usuario en la base de datos
        UsuariosDAO midao = new UsuariosDAO();
        Usuarios usuarioBD = midao.ConsultaUsuarios(usuario);

        if (usuarioBD == null) {
            // Usuario no existe
            request.setAttribute("mensaje", "El usuario no existe");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else if (!usuarioBD.getclave().equals(password)) {
            // Contraseña incorrecta
            request.setAttribute("mensaje", "Clave incorrecta");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else {
            // Login exitoso, enviamos datos al JSP
            request.setAttribute("mensaje", "Bienvenido: " + usuarioBD.getnombre() + " " + usuarioBD.getapellido());
            request.setAttribute("IdUsuario", usuarioBD.getdocumento());
            request.setAttribute("Perfil", usuarioBD.getRoles_idRoles());

            // Redirecciona al menú principal
            request.getRequestDispatcher("Vista/MenuPrincipal.jsp").forward(request, response);
        }
    }

    /**
     * Método GET (opcional, aquí solo puedes redirigir al login)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirige al login si alguien intenta acceder vía GET
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet para manejar inicio de sesión de usuarios";
    }
}