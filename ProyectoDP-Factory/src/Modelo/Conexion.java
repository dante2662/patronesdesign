package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Conexion {
    private static Conexion instancia;
    private Connection conexion;
    private Conexion() {
        conectar();
    }
    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }
    private void conectar() {
        String conexionStr = "jdbc:sqlserver://localhost:1433;databaseName=DonacionesBD;encrypt=true;trustServerCertificate=true";
        try {
            conexion = DriverManager.getConnection(conexionStr, "sa", "sa1234");
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar: " + ex.toString());
        }
    }
    public Connection getConexion() {
        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar la conexión: " + ex.toString());
        }
        return conexion;
    }
    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.toString());
        }
    }
}

