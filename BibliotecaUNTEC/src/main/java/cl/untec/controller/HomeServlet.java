package cl.untec.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cl.untec.model.LibroDAO;
import cl.untec.model.PrestamoDAO;
import cl.untec.model.Libro;
import cl.untec.model.Prestamo;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession(false);
        if (sesion == null || sesion.getAttribute("usuarioLogueado") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        LibroDAO lDao = new LibroDAO();
        PrestamoDAO pDao = new PrestamoDAO();

        List<Libro> listaLibros = lDao.obtenerTodos();
        List<Prestamo> listaPrestamos = pDao.listarPrestamos();

        request.setAttribute("libros", listaLibros);
        request.setAttribute("listaPrestamos", listaPrestamos);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}