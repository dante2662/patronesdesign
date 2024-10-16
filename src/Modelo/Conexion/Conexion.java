/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Dan
 */
public class Conexion {
    private static Conexion instancia;
    private Connection conexion;
    private Conexion() {
        String conexionStr = "jdbc:sqlserver://localhost:1433;databaseName=DONATIVOSPRUEBA;encrypt=true;trustServerCertificate=true";
        try {
            conexion = DriverManager.getConnection(conexionStr, "sa", "sa1234");          
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar: " + ex.toString());
        }
    }
    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection getConexion() {
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
