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
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class UsuarioDAO implements UserInterfaceDAO<Entidad>{
    Connection conn ;

    public UsuarioDAO() {
        this.conn = Conexion.getInstancia().getConexion();
    }

    @Override
    public void crear(UsuariosDTO usuario) {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{CALL registeruser(?, ?, ?, ?, ?, ?, ?, ?)}");
            stmt.setString(1, usuario.getTipoUsuario()); // Obtiene el tipo de entidad desde el DTO
            stmt.setString(2, usuario.getDocumentoIdentidad());
            stmt.setString(3, usuario.getPassword());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getNombre()); // Solo aplica para Persona
            stmt.setString(6, usuario.getTelefono()); // Aplicable para Persona y Empresa
            stmt.setString(7, usuario.getDireccion()); // Solo aplica para Empresa
            stmt.setString(8, usuario.getTipoEmpresa()); // Solo aplica para Empresa
            stmt.execute(); // Ejecutar el procedimiento
        } catch (SQLException e) {
            System.out.println("usuario ya registrado");// Manejo de excepciones
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void eliminar(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Entidad> listar() {
        CallableStatement stmt = null;
        ResultSet rs = null;
        List<Entidad> listaUsuarios = new ArrayList<>();

        try {
            String sql = "{CALL obtainuser()}";  // Llamada al procedimiento almacenado
            stmt = conn.prepareCall(sql);

            // Ejecutar el procedimiento
            rs = stmt.executeQuery();

            // Recorrer los resultados y agregar los usuarios a la lista
            while (rs.next()) {
                String idEntidad = rs.getString("idEntidad");
                String DocumentodeIdentidad = rs.getString("documentoIdentidad");
                String email = rs.getString("email");
                String password = rs.getString("password");

                String tipoEntidad = rs.getString("tipoEntidad");

                // Asignar los campos dependiendo del tipo de entidad
                if (tipoEntidad.equals("Persona")) {
                    String nombre = rs.getString("nombre");
                    String telefono = rs.getString("telefono");
                    // Crear PersonaDTO
                    Persona persona = new Persona(nombre, telefono, idEntidad, DocumentodeIdentidad, password, email, tipoEntidad);
                    listaUsuarios.add(persona);

                } else if (tipoEntidad.equals("Empresa")) {
                    String direccion = rs.getString("direccion");
                    String tipoEmpresa = rs.getString("tipoEmpresa");
                    String telefono = rs.getString("telefono");
                    // Crear EmpresaDTO
                    Empresa empresa = new Empresa(direccion, tipoEmpresa, telefono, idEntidad, DocumentodeIdentidad, password, email, tipoEntidad);
                    listaUsuarios.add(empresa);

                } else if (tipoEntidad.equals("Administrador")) {
                    // Crear AdministradorDTO
                    Administrador administrador = new Administrador(idEntidad, DocumentodeIdentidad, password, email, tipoEntidad);
                    listaUsuarios.add(administrador);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listaUsuarios;
    }

    @Override
    public Entidad buscarPorId(String id) {
        Entidad ent = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        
        try {
            // Llamada al procedimiento almacenado
            String sql = "{CALL ObtainUserById(?)}"; // Asegúrate de que el nombre del procedimiento coincida
            stmt = conn.prepareCall(sql);
            stmt.setString(1, id);
            
            // Ejecutar el procedimiento
            rs = stmt.executeQuery();

            // Procesar los resultados
            if (rs.next()) {
                String idEntidad = rs.getString("idEntidad");
                String documentoIdentidad = rs.getString("documentoIdentidad");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String tipoEntidad = rs.getString("tipoEntidad");
                
                // Verificar el tipo de entidad y crear la instancia correspondiente
                if ("Persona".equals(tipoEntidad)) {
                    String nombre = rs.getString("nombre");
                    String telefono = rs.getString("telefono");
                    ent = new Persona(nombre, telefono, idEntidad, documentoIdentidad, password, email, tipoEntidad);
                    
                } else if ("Empresa".equals(tipoEntidad) ) {
                    String direccion = rs.getString("direccion");
                    String tipoEmpresa = rs.getString("tipoEmpresa");
                    String telefono = rs.getString("telefono");
                    ent = new Empresa(direccion, tipoEmpresa, telefono, idEntidad, documentoIdentidad, password, email, tipoEntidad);
                    
                } else if ("Administrador".equals(tipoEntidad)) {
                    ent = new Administrador(idEntidad, documentoIdentidad, password, email, tipoEntidad);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return ent; // Devuelve la entidad encontrada o null si no se encontró
    
    }

    @Override
    public void actualizar(UsuariosDTO usuario) {
            CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{CALL updateuser(?, ?, ?, ?, ?, ?, ?, ?)}");

            stmt.setString(1, usuario.getIdEntidad());             // ID de la entidad
            stmt.setString(2, usuario.getDocumentoIdentidad());    // Documento de identidad
            stmt.setString(3, usuario.getPassword());               // Contraseña
            stmt.setString(4, usuario.getEmail());                  // Correo electrónico
            stmt.setString(5, usuario.getNombre());                 // Nombre
            stmt.setString(6, usuario.getTelefono());               // Teléfono
            stmt.setString(7, usuario.getDireccion());              // Dirección
            stmt.setString(8, usuario.getTipoEmpresa());            // Tipo de empresa

            stmt.executeUpdate(); // Ejecutar el procedimiento

            System.out.println("Usuario actualizado con éxito.");
        } catch (SQLException ex) {
            System.err.println("Error al actualizar el usuario: " + ex.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar recursos: " + ex.getMessage());
            }
        }
    }
    
}
