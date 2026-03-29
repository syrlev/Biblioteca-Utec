package cl.untec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import cl.untec.utils.Conexion;

public class UsuarioDAO {
    
    public boolean validar(String username, String password) {
        Connection cn = Conexion.getConexion();
        String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND clave = ?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}