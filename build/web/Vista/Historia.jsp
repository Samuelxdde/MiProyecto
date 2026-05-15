<%-- 
    Document   : Historia
    Created on : 12/04/2026, 10:41:28 p. m.
    Author     : Paula Gisedt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Casa y Jardin - Vivero Café</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/Vista/Css/style.css">
    </head>
    <body>
        <div class="barrainicio">
            <h1>Casa y Jardin</h1>

            <nav class="navegacion">
                <ul>
                    <li><a href="<%= request.getContextPath() %>/Vista/MenuPrincipal.jsp">Inicio</a></li>
                    <li><a href="<%= request.getContextPath() %>/Vista/Actividad.jsp">Actividad</a></li>
                    <li><a href="<%= request.getContextPath() %>/Vista/Reserva.jsp">Reservas</a></li>
                    <li><a href="<%= request.getContextPath() %>/Vista/Menu.jsp">Menú</a></li>
                    <li><a href="<%= request.getContextPath() %>/index.jsp">Iniciar Sesión</a></li>
                </ul>
            </nav>
        </div>
    </body>
    <footer>
            <p>&copy; 2025 Casa y Jardin - Vivero Café. Todos los derechos reservados.</p>
    </footer>
</html>
