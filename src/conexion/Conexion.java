package conexion;

import java.sql.*;

/**
 *
 * @author Miller
 */
public class Conexion {

    // conexion local
    public static Connection conectar() {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_ds", "root", "");
            return cn;
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime el seguimiento completo del error en la consola
            System.out.println("Error en la conexión: " + e.getMessage());
        }
        return (null);
    }
}
