<%-- 
    Document   : index
    Created on : 8 sep. 2022, 22:33:30
    Author     : Alexis
--%>
<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="controlador.mostrarOperaciones" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Actividad 8</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession(false);
            Enumeration enu = sesion.getAttributeNames();
            if(enu.hasMoreElements()){
                out.print(sesion.getAttribute("U"));
            }
            
            Cookie ck[] = request.getCookies();
            if(ck != null){
                for(int i = 0; i < ck.length; i++){
                    if(ck[i].getName().equals("B")){
                        out.print(" Tus operaciones anteriores fue " + ck[i].getValue()+ " + ");
                    }
                    if(ck[i].getName().equals("H")) {
                        out.print(ck[i].getValue() + " = ");
                    }
                    if(ck[i].getName().equals("Area")){
                        out.print(ck[i].getValue()+ " y ");
                    }
                    if(ck[i].getName().equals("Perimetro")){
                        out.print(ck[i].getValue()+ "");
                    } 
                }
            }
            
            if(request.getAttribute("flag") != null){
                out.print("Utiliza nnúmeros mayores a 0");
            }
        %>
        <div> Hola querido usuario
        <form action="mostrarOperaciones" method = "post">
            <br> ¿Cuál es tu nombre?
            <input type = "text" name="U" value=""><br>
            <br>Digite el valor de la base:
            <input type = "text" name="B" value=""><br>
            <br>Digite el valor de la altura:
            <input type= "text" name="H" value=""><br><br>
            <input type= "submit" value="Magia!">
            </form>
        </div>
    </body>
</html>
