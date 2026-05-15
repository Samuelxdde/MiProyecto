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
        <h1 href="<%= request.getContextPath() %>/Vista/index.jsp">Casa y Jardin</h1>
            <nav class="navegacion">
                <ul>
                    <li><a href="<%= request.getContextPath() %>index.jsp">Inicio</a></li>
                    <li><a href="<%= request.getContextPath() %>/Vista/Historia.jsp">Historia</a></li>
                    <li><a href="<%= request.getContextPath() %>/Vista/Actividad.jsp">Actividad</a></li>
                    <li><a href="<%= request.getContextPath() %>/Vista/Reserva.jsp">Reservas</a></li>
                    <li><a href="<%= request.getContextPath() %>/Vista/Menu.jsp">Menú</a></li>
                    <li><a href="<%= request.getContextPath() %>/Vista/InicioSesion.jsp">Iniciar Sesión</a></li>
                 </ul>
            </nav>
    </div>    
            <%--Formulario registro--%>
            <% 
                // Captura el mensaje enviado desde el servlet
                String mensaje = (String) request.getAttribute("resultado");
                if (mensaje != null) { 
            %>
                <p class="resultado"><%= mensaje %></p>
            <% } %>
        <form action="Registrarse" method= "post">
            <div class="Formulario">

                <label for="nombre">Ingrese su nombre:</label>
                <input type="text" name="nombrep" id="nombre"><br><br>

                <label for="apellido">Ingrese su apellido:</label>
                <input type="text" name="apellidoa" id="apellido"><br><br>

                 <label for="tipodoc">Ingrese su tipo de documento:</label>
                <select id="tipodoc" name="tipodocs">
                    <option value="cc">CC</option>
                    <option value="ce">CE</option>
                    <option value="p">P</option>
                    <option value="pep">PEP</option>
                    <option value="dni">DNI</option>
                </select><br><br>

                <label for="documento">Ingrese su número de documento:</label>
                <input type="number" name="documentoa" id="documento"><br><br>

                <label for="telefono">Ingrese su teléfono:</label>
                <input type="text" name="telefonoi" id="telefono"><br><br>

                <label for="correo">Ingrese su correo:</label>
                <input type="email" name="correoz" id="correo"><br><br>

                <label for="rol">Rol:</label><br>
                <select id="rol" name="rola">
                    <option value="admin">Administrador</option>
                    <option value="usuario">Usuario</option>
                </select><br><br>

                <label for="clave">Ingrese su contraseña:</label>
                <input type="password" name="clavev" id="clave"><br><br>

                <button type="submit" formaction="re.jsp">Registrarse</button>
                <button type="submit" formaction="InicioSesion.jsp">Iniciar Sesión</button>
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

 



