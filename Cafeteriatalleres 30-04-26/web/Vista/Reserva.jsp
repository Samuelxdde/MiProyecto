<%-- 
    Document   : Reserva
    Created on : 25/02/2026, 9:53:02 p. m.
    Author     : Paula Gisedt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Casa y Jardin - Vivero Café</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/Vista/Css/style.css">
       

    </head>
    <body>

            <%--Barra de navegacion--%>
              
            <div class="barrainicio">
                <h1>Casa y Jardin</h1>
                    <nav class="navegacion">
                            <ul>
                                <li><a href="<%= request.getContextPath() %>/Vista/MenuPrincipal.jsp">Inicio</a></li>
                                <li><a href="<%= request.getContextPath() %>/Vista/Historia.jsp">Historia</a></li>
                                <li><a href="<%= request.getContextPath() %>/Vista/Actividad.jsp">Actividad</a></li>
                                <li><a href="<%= request.getContextPath() %>/Vista/Menu.jsp">Menú</a></li>
                                <li><a href="<%= request.getContextPath() %>/index.jsp">Cerrar Sesión</a></li>
                            </ul>
                    </nav>    
            </div>    
            <%--Formulario Reserva--%>
    <form action="Reserva">        
        <div class="Formulario">
            <!-- Título del formulario -->
            <h2 class="titulo-form">Reserva tu actividad</h2>
            <hr>

            <label for="nombre">Ingrese su nombre:</label>
            <input type="text" name="nombre" id="nombre">

            <label for="apellido">Ingrese su apellido:</label>
            <input type="text" name="apellido" id="apellido">

            

            <label for="telefono"><i class="fa fa-phone"></i> Ingrese su teléfono:</label>
            <input type="text" name="telefono" id="telefono">

            <label for="correo"><i class="fa fa-envelope"></i> Ingrese su correo:</label>
            <input type="email" name="correo" id="correo">

            <hr>

            <select id="actividad" name="actividad">
                <option value="blanco">Actividad</option>
                <option value="totebag">Tote Bag personalizada</option>
                <option value="kokedama">Kokedama</option>
                <option value="ceramicas">Pintar Cerámicas</option>
                <option value="terrario">Terrario</option>
            </select>

            <select id="actividad1" name="actividad1">
                <option value="blancoa">Horario</option>
                <option value="12-2">12-2</option>
                <option value="3-5">3-5</option>
                <option value="6-8">6-8</option>
            </select>

            <button type="submit">Realizar Abono</button>

            <%--Captura el mensaje desde el servlet--%>
             
            <% 
                String mensaje = (String) request.getAttribute("mensaje");
                if (mensaje != null) { 
            %>
                <p class="mensaje"><%= mensaje %></p>
            <% } %>
        </div>
    </form>
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




