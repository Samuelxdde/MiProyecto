<%-- 
    Document   : Gestionar Usuarios
    Created on : 12/02/2026, 3:24:32 p. m.
    Author     : Paula Gisedt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Casa y Jardin - Vivero Café</title>
        <link rel="stylesheet" href="Vista/Css/style.css">
    </head>
    <body>   
        <form class="incio"
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
            </div>
            <div class="carrusel">
            <div class="imagen-contenedor" id="carrusel">
                <img src="Vista/Imagenes/prueba.prueba.jpg" alt="Fachada">
                <img src="Vista/Imagenes/foto.jpg" alt="entrada">
                <img src="Vista/Imagenes/fotoprueba.jpg" alt="sillas">
                <img src="Vista/Imagenes/prueba.jpg" alt="mesas">
            </div>
            <div class="buttons">
                <button class="btizquierdo" id="left">&#10094;</button>
                <button class="btderecho" id="right">&#10095;</button>
            </div>
            </div>

                <div class="buttons"> 
                     <button class="btizquierdo" id="left">&#10094;</button>
                     <button class="btderecho" id="right">&#10095;</button>
                </div> 
            </div>
            <div class="bienvenida">
                <p>Bienvenidos!</p>
                <p>Conoce nuestras <butom class="actividad" id="actividad">Actividades</butom></p>
            </div>
            <div class="historia">
                <h2>Historia</h2>
                <p>Crecimos con la idea de poder enseñarle a las personas un poco de arte, pero tambien teniendo
                un rato agradable con familiares y amigos. Inicialmente estuvimos trabajando unicamente con kokedamas,
                realizando pequeños talleres para personas interesadas, luego decidimos implementar nuevos talleres por recomendación de nuestrlos clientes, apartir de ahi tenemos 
                ceramicas para pintar de forma libre, adicional a esto tote bags, materas, terrarios con una zona especial para que
                cada cliente tenga una experiencia única.
                </p>
            </div>
            <script src="Vista/JavaScript/funciones.js"></script>
        </form>
    </body>
    <footer>
        <form class="footeri">
            <p>&copy; 2025 Casa y Jardin - Vivero Café. Todos los derechos reservados.</p>
        </form>
    </footer>
</html>
