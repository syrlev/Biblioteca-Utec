package cl.untec.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cl.untec.model.PrestamoDAO;

@WebServlet("/prestamo")
public class PrestamoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        PrestamoDAO dao = new PrestamoDAO();
        
        if ("solicitar".equals(accion)) {
            int idLibro = Integer.parseInt(request.getParameter("idLibro"));
            String usuario = (String) request.getSession().getAttribute("usuarioLogueado");
            dao.registrarPrestamo(idLibro, usuario);
        } else if ("devolver".equals(accion)) {
            int idPrestamo = Integer.parseInt(request.getParameter("id"));
            dao.devolverLibro(idPrestamo);
        }
        
        response.sendRedirect("home");
    }
}
