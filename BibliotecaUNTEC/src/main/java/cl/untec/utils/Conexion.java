package cl.untec.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static Connection connection = null;
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca_untec";
    private static final String USER = "root";
    private static final String PASS = "1234";

    private Conexion() {}

    public static Connection getConexion() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}