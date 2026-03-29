package cl.untec.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cl.untec.model.Libro;
import cl.untec.model.LibroDAO;

@WebServlet("/insertar")
public class InsertarServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String titulo = request.getParameter("txtTitulo");
        String autor = request.getParameter("txtAutor");
        
        Libro nuevoLibro = new Libro();
        nuevoLibro.setTitulo(titulo);
        nuevoLibro.setAutor(autor);
        
        LibroDAO dao = new LibroDAO();
        dao.insertar(nuevoLibro);
        
        response.sendRedirect("home");
    }
}