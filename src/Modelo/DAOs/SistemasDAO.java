/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAOs;

import Modelo.Empresa;
import Modelo.Entidad;
import Modelo.Persona;
import Modelo.Administrador;
import Modelo.PyB.UsuariosDTO;
import Modelo.Conexion.Conexion;
import java.sql.*;


/**
 *
 * @author Dan
 */
public class SistemasDAO {
    Connection conn;

    public SistemasDAO() {
        this.conn = Conexion.getInstancia().getConexion();
    }
    
    public Entidad loginUsuario(String documentoIdentidad, String password) {
        CallableStatement stmt = null;
        ResultSet rs = null;
        Entidad ent = null;
        try {
            stmt = conn.prepareCall("{CALL logUser(?, ?)}");

            // Establecer los parámetros de entrada
            stmt.setString(1, documentoIdentidad);
            stmt.setString(2, password);

            // Ejecutar el procedimiento
            rs = stmt.executeQuery();

            if (rs != null && rs.next()) {
                // Crear una instancia del usuario y asignar los valores comunes
                String idEntidad = rs.getString("idEntidad");
                String DocI = rs.getString("documentoIdentidad");
                String email = rs.getString("email");
                String pass = rs.getString("password");
                // Verificar el tipo de entidad y asignar los campos específicos
                String tipoEntidad = rs.getString("tipoEntidad");
                switch (tipoEntidad) {
                    case "Persona" -> {
                        String nombre = rs.getString("nombre");
                        String telefono = rs.getString("telefono");
                        ent = new Persona(nombre, telefono, idEntidad, DocI, pass, email, tipoEntidad);
                    }
                    case "Empresa" -> {
                        String direccion = rs.getString("direccion");
                        String tipoEmpresa = rs.getString("tipoEmpresa");
                        String telefono = rs.getString("telefono");
                        ent = new Empresa(direccion, tipoEmpresa, telefono, idEntidad, DocI, pass, email, tipoEntidad);
                    }
                    case "Administrador" -> {
                        ent = new Administrador(idEntidad, DocI, pass, email, tipoEntidad);
                    }
                    default -> {
                        System.out.println("Tipo de entidad desconocido.");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(" " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return ent;
    }

    
}
