/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Alexis Pérez
 * Matrícula: 2942889
 * 
 */
@WebServlet(name = "mostrarOperaciones", urlPatterns = {"/mostrarOperaciones"})
public class mostrarOperaciones extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){

            if(request.getAttribute("flag") != null){
                request.setAttribute("flag", 1);
                request.getRequestDispatcher("/index.jps").forward(request, response);
            } else {
                String B = request.getParameter("B");
                String H = request.getParameter("H");
                String U = request.getParameter("U");

                model.Triangulo t = new model.Triangulo(B,H);
                t.setUsuario(U);
                t.Area();
                t.Perimeter();
                double resultado = t.getResult();

                HttpSession sesion = request.getSession();
                sesion.setAttribute("U", t.getUsuario());

                Cookie ck = new Cookie("B", t.getBase() + "");
                response.addCookie(ck);
                ck = new Cookie("H", t.getHeight() + "");
                response.addCookie(ck);
                ck = new Cookie("Area", t.getResult() + "");
                response.addCookie(ck);
                ck = new Cookie("Perimetro", t.getResulta() + "");
                response.addCookie(ck);

                request.setAttribute("Operaciones", t);
                request.getRequestDispatcher("/mostrarResultado.jsp").forward(request, response);
            }  
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    
    
}

    

