<%-- 
    Document   : Gestionar Usuaraios
    Created on : 20/02/2026, 11:49:54 a. m.
    Author     : Aprendiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--Registro--%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Casa y Jardin - Vivero Café</title>
        <link rel="stylesheet" href="Vista/Css/styl.css">
    </head>
    <body>   
        <form class="registro"
              
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
                                <li><a href="Vista/Registrarse.jsp">Registrarse</a></li>
                            </ul>
                    </nav>
                
            <%--Formulario registro--%>
                
            <div class="infusuario">
                
                <label for="nombre">Ingrese su nombre:</label>
                <input type="text" name="nombre" id="nombre">
                <br><br>
                
                <label for="apellido">Ingrese su apellido:</label>
                <input type="text" name="apellido" id="apellido">
                <br><br>
                
                <label for="tipodoc">Ingrese su tipo de documento:</label>
                <select id="tipodoc">
                    <option value="blancoa">
                    <option value="cc">CC
                    <option value="ce">CE
                    <option value="p">P
                    <option value="pep">PEP 
                    <option value="dni">DNI 
                </select>
                <br><br>

                <label for="documento">Ingrese su numero de documento:</label>
                <input type="int" name="documento" id="documento">
                <br><br>
                
                <label for="telefono">Ingrese su telefono:</label>
                <input type="text" name="telefono" id="telefono">
                <br><br>
                
                <label for="correo">Ingrese su correo:</label>
                <input type="email" name="correo" id="correo">
                <br><br>
                
                <select id="rol">
                    <option value="blanco">
                    <option value="admin">Administrador
                    <option value="usuario">Usuario
                </select>
                
                <button type="submit"> Registarse</button>
                <button type="submit"> Inicar Sesion</button>
            </div>
            
    </body>
    <footer>
            <p>&copy; 2025 Casa y Jardin - Vivero Café. Todos los derechos reservados.</p>
        </form>
    </footer>
</html>

 



