<%-- 
    Document   : index
    Created on : 25/03/2026, 8:06:54 p. m.
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Casa y Jardin - Vivero Café</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/Vista/Css/style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&icon" />
</head>
<body>
        
        <div class="barrainicio">
            <h1>Casa y Jardin</h1>
                    <nav class="navegacion">
                            <ul>
                                <li><a href="<%= request.getContextPath() %>/index.jsp">Inicio</a></li>
                                <li><a href="<%= request.getContextPath() %>/Vista/Historia.jsp">Historia</a></li>
                                <li><a href="<%= request.getContextPath() %>/Vista/Actividad.jsp">Actividad</a></li>
                                <li><a href="<%= request.getContextPath() %>/Vista/Reserva.jsp">Reservas</a></li>
                                <li><a href="<%= request.getContextPath() %>/Vista/Registrarse.jsp">Registrarse</a></li>
                            </ul>
                    </nav>
        </div>
         
        <div class="Formulario">
            <h2>Iniciar Sesion</h2>
           
            <% 
                // Captura el mensaje enviado desde el servlet
                String mensaje = (String) request.getAttribute("mensaje");
                if (mensaje != null) { 
            %>
                <p class="mensaje"><%= mensaje %></p>
            <% } %>
            <form action="Iniciar" method= "post">
                <label for="documento"><span class="documento">account_circle</span></label>
                <input type="text" name="usuario" placeholder="Documento" >
                

                <label for="contraseña"><span class="contraseña">lock</span></label>
                <input type="password" name="pass" placeholder="Contraseña">

                <button type="submit" name="IndexAbierto.jsp">Iniciar Sesión</button>
                <button type="submit" formaction="Registrarse.jsp">Registrarse</button>
            </form>
        </div>
</body>

<footer class="footer">
    <div class="footer-contenedor">
        
       
        <div class="footer-info">
            <h3>Casa y Jardín - Vivero Café</h3>
            <p>Dirección: Calle 123 #45-67, Bogotá</p>
            <p>Teléfono: +57 300 123 4567</p>
            <p>Email: contacto@casayjardin.com</p>
        </div>

       
        <div class="logo-footer">
            <img src="<%= request.getContextPath() %>/Vista/Imagenes/loguito.png" alt="Logo Casa y Jardín">
        </div>

     
        <div class="footer-redes">
            <h3>Síguenos</h3>
            <a href="https://www.facebook.com/casayjardincll53/">Facebook</a> |
            <a href="https://www.instagram.com/casayjardinviverocafe/">Instagram</a> |
            <a href="#">WhatsApp</a>
        </div>
    </div>

    <div class="footer-copy">
        <p>&copy; 2025 Casa y Jardín - Vivero Café. Todos los derechos reservados.</p>
    </div>
</footer>
</html>


