package cl.untec.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import cl.untec.utils.Conexion;

public class PrestamoDAO {
    public void registrarPrestamo(int idLibro, String usuario) {
        String sql = "INSERT INTO prestamos (id_libro, usuario, fecha_prestamo, estado) VALUES (?, ?, CURDATE(), 'Activo')";
        try (Connection cn = Conexion.getConexion(); 
             PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, idLibro);
            pst.setString(2, usuario);
            pst.executeUpdate();
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
    }

    public List<Prestamo> listarPrestamos() {
        List<Prestamo> lista = new ArrayList<>();
        String sql = "SELECT p.id, p.usuario, p.fecha_prestamo, p.estado, l.titulo FROM prestamos p JOIN libros l ON p.id_libro = l.id";
        try (Connection cn = Conexion.getConexion();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Prestamo p = new Prestamo();
                p.setId(rs.getInt("id"));
                p.setUsuario(rs.getString("usuario"));
                p.setTituloLibro(rs.getString("titulo"));
                p.setFecha(rs.getDate("fecha_prestamo"));
                p.setEstado(rs.getString("estado"));
                lista.add(p);
            }
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
        return lista;
    }

    public void devolverLibro(int idPrestamo) {
        String sql = "UPDATE prestamos SET estado = 'Devuelto' WHERE id = ?";
        try (Connection cn = Conexion.getConexion(); 
             PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, idPrestamo);
            pst.executeUpdate();
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
    }
}