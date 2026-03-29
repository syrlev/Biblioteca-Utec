package cl.untec.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cl.untec.model.LibroDAO;

@WebServlet("/eliminar")
public class EliminarServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        LibroDAO dao = new LibroDAO();
        dao.eliminar(id);
        
        response.sendRedirect("home");
    }
}