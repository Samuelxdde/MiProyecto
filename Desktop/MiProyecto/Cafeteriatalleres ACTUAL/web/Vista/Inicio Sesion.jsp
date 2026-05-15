<%-- 
    Document   : Registrarse
    Created on : 25/02/2026, 9:59:29 p. m.
    Author     : Paula Gisedt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Casa y Jardin - Vivero Café</title>
        <link rel="stylesheet" href="Vista/Css/styl.css">
    </head>
    <body>   
        <form class="sesion"
              
            <%--Barra de navegacion--%>
              
            <div class="barrainicio">
                <h1>Casa y Jardin</h1>
                <button class="menu-toggle" aria-label="Abrir menú">&#9776;</button>
                    <nav class="navegacion">
                        <button class="menu-close" aria-label="Cerrar menú">&times;</button>
                            <ul>
                                <li><a href="Web Pages/index.jsp">Inicio</a></li>
                                <li><a href="vista/historia">Historia</a></li>
                                <li><a href="Vista/actividades">Actividades</a></li>
                                <li><a href="Vista/menu">Menú</a></li>
                            </ul>
                    </nav>
                
            <%--Formulario inicio de sesion--%>
                
            <div class="iniciosesion">
                
                <label for="nombre">Ingrese su nombre:</label>
                <input type="text" name="nombre" id="nombre">
                <br><br>
                
                <label for="apellido">Ingrese su apellido:</label>
                <input type="text" name="apellido" id="apellido">
                <br><br>
                
                <label for="telefono">Ingrese su telefono:</label>
                <input type="text" name="telefono" id="telefono">
                <br><br>
                
                <label for="correo">Ingrese su correo:</label>
                <input type="email" name="correo" id="correo">
                <br><br>
            
                <button type="submit"> Inicar Sesion</button>
                <button type="submit"> Registarse</button>
            </div>
            
    </body>
    <footer>
            <p>&copy; 2025 Casa y Jardin - Vivero Café. Todos los derechos reservados.</p>
        </form>
    </footer>
</html>