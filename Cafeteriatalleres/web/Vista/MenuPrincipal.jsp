<p>
    <% if(request.getAttribute("mensaje") != null) { %>
        <%= request.getAttribute("mensaje") %>
    <% } %>
</p>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Casa y Jardin - Vivero Café</title>
    <link rel="stylesheet" href="/Cafeteriatalleres/Vista/Css/style.css">
</head>

<body>   
    <form class="inicio">
        <div class="barrainicio">
            <h1>Casa y Jardin</h1>
            <button type="button" class="menu-toggle" aria-label="Abrir menú">&#9776;</button>

            <nav class="navegacion">
                <button type="button" class="menu-close" aria-label="Cerrar menú">&times;</button>
                <ul>
                    <li><a href="/Cafeteriatalleres/Vista/index.jsp">Inicio</a></li>
                    <li><a href="#">Historia</a></li>
                    <li><a href="/Cafeteriatalleres/Vista/GestionarUsuarios.jsp">Reservas</a></li>
                    <li><a href="#">Actividades</a></li>
                    <li><a href="#">Menú</a></li>
                </ul>
            </nav>
        </div>

        <div class="carrusel">
            <div class="imagen-contenedor" id="carrusel">
                <img src="/Cafeteriatalleres/Vista/Imagenes/prueba.jpg" alt="Fachada">
                <img src="/Cafeteriatalleres/Vista/Imagenes/foto.jpg" alt="Entrada">
                <img src="/Cafeteriatalleres/Vista/Imagenes/fotoprueba.jpg" alt="Sillas">
                <img src="/Cafeteriatalleres/Vista/Imagenes/prueba.jpg" alt="Mesas">
            </div>

            <div class="buttons">
                <button type="button" class="btizquierdo" id="left">&#10094;</button>
                <button type="button" class="btderecho" id="right">&#10095;</button>
            </div>
        </div>

        <div class="bienvenida">
            <p>¡Bienvenidos!</p>
            <p>
                Conoce nuestras 
                <button type="button" class="actividad" id="actividad">Actividades</button>
            </p>
        </div>

        <div class="historia">
            <h2>Historia</h2>
            <p>
                Crecimos con la idea de poder enseñarle a las personas un poco de arte, 
                pero también teniendo un rato agradable con familiares y amigos. 
                Inicialmente trabajamos con kokedamas, realizando pequeños talleres para 
                personas interesadas, luego decidimos implementar nuevos talleres por 
                recomendación de nuestros clientes. A partir de ahí tenemos cerámicas 
                para pintar de forma libre, tote bags, materas, terrarios con una zona 
                especial para que cada cliente tenga una experiencia única.
            </p>
        </div>
    </form>

    <script src="/Cafeteriatalleres/Vista/JavaScript/funciones.js"></script>
</body>

<footer>
    <form class="footeri">
        <p>&copy; 2025 Casa y Jardin - Vivero Café. Todos los derechos reservados.</p>
    </form>
</footer>
</html>

