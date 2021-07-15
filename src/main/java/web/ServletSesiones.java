/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author david
 */
@WebServlet("/ServletSesiones")
public class ServletSesiones extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession sesion = request.getSession();
        String titulo = null;
        
        
        //pedir el atributo contadorVisitas a la sesion
        
        Integer contadorVisitas = (Integer)sesion.getAttribute("contadorVisitas");
        //si es nulo es la primera vez qie accede a la aplicacion
        if(contadorVisitas == null){
            contadorVisitas = 1;
            titulo="bienbenido por primera vez";
        }else{
            contadorVisitas++;
            titulo = "bienvenido nuevamente";
        }
           //agregamos el nuevo valor a la sesion
           sesion.setAttribute("contadorVisitas", contadorVisitas);
        //mandamos la respuesta a l cliente
        PrintWriter out = response.getWriter();
        out.println(titulo);
        out.println("<br>");
        out.println("no. de accesos al recurso:"+contadorVisitas);
        out.println("<br>");
        out.println("id de la secion:"+sesion.getId());
        out.close();
        
        
    }
}
