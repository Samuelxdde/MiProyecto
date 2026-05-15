
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
                    <li><a href="<%= request.getContextPath() %>/Vista/index.jsp">Inicio</a></li>
                    <li><a href="<%= request.getContextPath() %>/Vista/Historia.jsp">Historia</a></li>
                    <li><a href="<%= request.getContextPath() %>/Vista/Actividad.jsp">Actividad</a></li>
                    <li><a href="<%= request.getContextPath() %>/Vista/Reserva.jsp">Reservas</a></li>
                    <li><a href="<%= request.getContextPath() %>/Vista/Menu.jsp">Menú</a></li>
                    <li><a href="<%= request.getContextPath() %>/Vista/InicioSesion.jsp">Iniciar Sesión</a></li>
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




