package Modelo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class GestionBD {
    public static void SubirEmpresa(Empresa empresa) {
        Connection con = Conexion.getInstancia().getConexion(); 
        CallableStatement cs = null;
        try {
            cs = con.prepareCall("{call sp_insertarEntidad(?, ?, ?, ?, ?,?)}");
            cs.setString(1, empresa.getRsoci());
            cs.setString(2, String.valueOf(empresa.getDcentidad()));
            cs.setString(3, String.valueOf(empresa.getPw()));
            cs.setString(4, empresa.getTipo());
            cs.setString(5, String.valueOf((char) empresa.getContacto()));  
            cs.setString(6, empresa.getDireccion());
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro realizado con éxito");
        } catch (SQLException ex) {
            Logger.getLogger(GestionBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al registrar empresa", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GestionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void SubirPersona(Persona persona) {
        Connection con = Conexion.getInstancia().getConexion();
        CallableStatement cs = null;
        try {
            cs = con.prepareCall("{call sp_insertarEntidad(?, ?, ?, ?, ?,?)}");
            cs.setString(1, persona.getRsoci());
            cs.setString(2, String.valueOf(persona.getDcentidad()));
            cs.setString(3, String.valueOf(persona.getPw()));
            cs.setString(4, persona.getTipoc());
            cs.setString(5, String.valueOf( persona.getContac()));  
            cs.setString(6, persona.getEmail());
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro realizado con éxito");
        } catch (SQLException ex) {
            Logger.getLogger(GestionBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al registrar persona", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (con != null && !con.isClosed()) {
                    con.close(); 
                }
            } catch (SQLException ex) {
                Logger.getLogger(GestionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
