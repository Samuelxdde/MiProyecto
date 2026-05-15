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
                    <li><a href="<%= request.getContextPath() %>/index.jsp">Inicio</a></li>
                    <li><a href="<%= request.getContextPath() %>/Vista/Historia.jsp">Historia</a></li>
                    <li><a href="<%= request.getContextPath() %>/Vista/Reserva.jsp">Reservas</a></li>
                    <li><a href="<%= request.getContextPath() %>/Vista/Menu.jsp">Menú</a></li>
                    <li><a href="<%= request.getContextPath() %>/index.jsp">Cerrar Sesión</a></li>
                </ul>
            </nav>
        </div>
<div class="contenedores">
        <h2 class="titulo-seccion">Nuestras Actividades</h2>
        
        <div class="actividades">
            
            
            <div class="card">
                <div class="content">
                    <div class="back">
                        <div class="back-content">
                            <div class="circle"></div>
                            <div class="circle" id="bottom"></div>
                            <div class="circle" id="right"></div>
                            <strong>Tote-Bag</strong>
                        </div>
                    </div>
                    <div class="front">
                        
                        <img src="<%= request.getContextPath() %>/Vista/Imagenes/Tote-bag.jpg" class="tote" alt="Tote Bag">
                        <div class="front-content">
                            <small class="badge">Actividad</small>
                            <div class="description">
                                <p class="title"><strong>Pintura Creativa</strong></p>
                                <p class="card-footer">Personaliza tu bolso con materiales incluidos.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

           
            <div class="card">
                <div class="content">
                    <div class="back">
                        <div class="back-content">
                            <div class="circle"></div>
                            <div class="circle" id="bottom"></div>
                            <strong>Cerámicas</strong>
                        </div>
                    </div>
                    <div class="front">
                        <img src="<%= request.getContextPath() %>/Vista/Imagenes/Ceramica.jpg" class="cera" alt="Cerámicas">
                        <div class="front-content">
                            <small class="badge">Taller</small>
                            <div class="description">
                                <p class="title"><strong>Modelado</strong></p>
                                <p class="card-footer">Crea piezas únicas de barro y cerámica.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

           
            <div class="card">
                <div class="content">
                    <div class="back">
                        <div class="back-content">
                            <div class="circle" id="right"></div>
                            <strong>Kokedama</strong>
                        </div>
                    </div>
                    <div class="front">
                        <img src="<%= request.getContextPath() %>/Vista/Imagenes/kokedama.jpg" class="koka" >
                        <div class="front-content">
                            <small class="badge">Vivero</small>
                            <div class="description">
                                <p class="title"><strong>Arte Japonés</strong></p>
                                <p class="card-footer">Aprende a crear plantas en bolas de musgo.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div> 
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
