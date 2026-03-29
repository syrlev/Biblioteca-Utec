package cl.untec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import cl.untec.utils.Conexion;

public class LibroDAO {

    public List<Libro> obtenerTodos() {
        List<Libro> lista = new ArrayList<>();
        Connection cn = Conexion.getConexion();
        String sql = "SELECT * FROM libros";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Libro l = new Libro();
                l.setId(rs.getInt("id"));
                l.setTitulo(rs.getString("titulo"));
                l.setAutor(rs.getString("autor"));
                lista.add(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    public void eliminar(int id) {
        Connection cn = Conexion.getConexion();
        String sql = "DELETE FROM libros WHERE id = ?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }public void insertar(Libro libro) {
            Connection cn = Conexion.getConexion();
            String sql = "INSERT INTO libros (titulo, autor) VALUES (?, ?)";
            
            try {
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, libro.getTitulo());
                pst.setString(2, libro.getAutor());
                pst.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
