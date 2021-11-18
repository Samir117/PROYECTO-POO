package Conexion_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexion {

    Connection conect = null;

    public Connection conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://localhost/conchap", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
        }
        return conect;
    }

    public void test() {
        conexion c = new conexion();
        java.sql.Connection cn = c.conexion();
        if (cn != null) {

            JOptionPane.showMessageDialog(null, "Conectado");

            try {

                cn.close();

            } catch (SQLException ex) {

                System.out.println("Error al desconectar " + ex);

            }
        }
    }
}
