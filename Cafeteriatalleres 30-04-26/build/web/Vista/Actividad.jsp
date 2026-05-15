<%-- 
    Document   : Actividad
    Created on : 12/04/2026, 10:37:57 p. m.
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
                    <li><a href="<%= request.getContextPath() %>/Vista/Historia.jsp">Historia</a></li>
                    <li><a href="<%= request.getContextPath() %>/Vista/Reserva.jsp">Reservas</a></li>
                    <li><a href="<%= request.getContextPath() %>/Vista/Menu.jsp">Menú</a></li>
                    <li><a href="<%= request.getContextPath() %>/index.jsp">Cerrar Sesión</a></li>
                </ul>
            </nav>
        </div>
        <div class="contenedores">
            <p>
                    <h2>Tote-bag</h2>
                    <p>En esta actividad encontrarás un día muy entetenido pintando 
                       entrentenidos bolsos tipo mercado, tote-bag, como es más conocido. 
                       En esta actividad puedes dejarte llevar pot tu creatividad única, 
                       se te darán los amteriales para que puedas realizar la actividad
                    <h2>Cerámicas</h2>
                    123
                    <h2>Kokedama</h2>
                    123.

                    <h2>Terrario</h2>
                    123.
            </p>
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
