package cl.untec.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cl.untec.model.UsuarioDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String usuario = request.getParameter("txtUsuario");
        String clave = request.getParameter("txtPassword");

        UsuarioDAO dao = new UsuarioDAO();

        if (dao.validar(usuario, clave)) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuarioLogueado", usuario);
            response.sendRedirect("home");
            return;
        } else {
            response.sendRedirect("index.jsp?error=1");
            return;
        }
    }
}
    
