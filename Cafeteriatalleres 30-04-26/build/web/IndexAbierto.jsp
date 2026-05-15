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
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Vista/Css/style.css">
</head>

<body>   
    <form class="inicio">
        <div class="barrainicio">
            <h1>Casa y Jardin</h1>

            <nav class="navegacion">
                <ul>
                    <li><a href="<%= request.getContextPath() %>/Vista/IndexAbierto.jsp">Inicio</a></li>
                    <li><a href="<%= request.getContextPath() %>/Vista/Historia.jsp">Historia</a></li>
                    <li><a href="<%= request.getContextPath() %>/Vista/Actividad.jsp">Actividad</a></li>
                    <li><a href="<%= request.getContextPath() %>/Vista/Reserva.jsp">Reservas</a></li>
                    <li><a href="<%= request.getContextPath() %>/Vista/Menu.jsp">Menú</a></li>
                    <li><a href="<%= request.getContextPath() %>/index.jsp">Cerrar Sesión</a></li>
                </ul>
            </nav>
        </div>

        <div class="carrusel">
            <div class="imagen-contenedor" id="carrusel">
                <img src="<%= request.getContextPath() %>/Vista/Imagenes/prueba.jpg" alt="Fachada">
                <img src="<%= request.getContextPath() %>/Vista/Imagenes/foto.jpg" alt="Entrada">
                <img src="<%= request.getContextPath() %>/Vista/Imagenes/fotoprueba.jpg" alt="Sillas">
                <img src="<%= request.getContextPath() %>/Vista/Imagenes/prueba.prueba.jpg" alt="Mesas">
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
                <a href="<%= request.getContextPath() %>/Vista/Actividad.jsp" class="actividad">Actividades</a>
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

    <script src="<%= request.getContextPath() %>/Vista/JavaScript/funciones.js"></script>
</body>

<footer>
    <p> Dirección: 17#52-71, Bogotá – Colombia 111311

        Celular: +57 319 2189853

        Planea tu día

        Consulta de pagos
        
        Horario Atención.
        Lunes a viernes de 08:00 a.m. a 1:00 p.m. y de 2:00 a 5:00 p.m.
        La extensión 1012 es de quejas y reclamos.
        
        &copy; 2025 Casa y Jardin - Vivero Café. Todos los derechos reservados.</p>
</footer>
</html>

