<%-- 
    Document   : Reserva
    Created on : 25/02/2026, 9:53:02 p. m.
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
                                <li><a href="Vista/historia">Historia</a></li>
                                <li><a href="Vista/actividades">Actividades</a></li>
                                <li><a href="Vista/menu">Menú</a></li>
                                <li><a href="Vista/Registrarse.jsp">Registrarse</a></li>
                                <li><a href="Vista/Inicio Sesion.jsp">Iniciar Sesion</a></li>
                            </ul>
                    </nav>
                
            <%--Formulario Reserva--%>
                
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
                
                <select id="actividad">
                    <option value="blanco">
                    <option value="totebag">Tote Bag personalizada
                    <option value="kokedama">Kokedama 
                    <option value="ceramicas">Pintar Ceramicas
                    <option value="terrario">Terrario
                </select>
                <br><br>
                
                <select id="actividad">
                    <option value="blancoa">
                    <option value="12-2">12-2
                    <option value="3-5">3-5 
                    <option value="6-8">6-8
                </select>
                <br><br>
         
                <button type="submit"> Realizar Abono</button>
            </div>
            
    </body>
    <footer>
            <p>&copy; 2025 Casa y Jardin - Vivero Café. Todos los derechos reservados.</p>
        </form>
    </footer>
</html>
