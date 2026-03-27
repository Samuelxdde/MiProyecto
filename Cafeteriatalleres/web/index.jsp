<%-- 
    Document   : index
    Created on : 25/03/2026, 8:06:54 p. m.
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="Formulario">
            <h2>Iniciar Sesion</h2>
           
            <% 
                // Captura el mensaje enviado desde el servlet
                String mensaje = (String) request.getAttribute("mensaje");
                if (mensaje != null) { 
            %>
                <p class="mensaje"><%= mensaje %></p>
            <% } %>
            <form action="Iniciar" method= "post">
                <label>Usuario</label><input type= "text" name= "usuario" >
                <label>Password</label><input type= "password" name= "pass">
                <input type= "submit" value= "Iniciar Sesion">
            </form>
        </div>
    </body>
</html>
