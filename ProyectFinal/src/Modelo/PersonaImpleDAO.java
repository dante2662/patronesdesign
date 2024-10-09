/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Clases.Persona;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class PersonaImpleDAO implements GenericoDAO<Persona>{
    
    private Connection connection;

    PersonaImpleDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Persona objeto) {
        CallableStatement callableStatement = null;

        try {
            // Preparar la llamada al procedimiento almacenado
            callableStatement = connection.prepareCall("{CALL insertarPersona(?, ?, ?, ?, ?)}");
            callableStatement.setString(1, objeto.getDocumentoIdentidad());
            callableStatement.setString(2, objeto.getPassword());
            callableStatement.setString(3, objeto.getEmail());
            callableStatement.setString(4, objeto.getNombre());
            callableStatement.setString(5, objeto.getTelefono());
            
            // Ejecutar el procedimiento
            callableStatement.execute();

        } catch (SQLException ex) {
            System.err.println("Error al crear la persona: " + ex.getMessage());
            // Aquí podrías lanzar una excepción personalizada o manejar el error de otra forma
        } finally {
            // Cerrar recursos
            try {
                if (callableStatement != null) {
                    callableStatement.close();
                }
                // No cerramos la conexión aquí, ya que se maneja externamente
            } catch (SQLException ex) {
                System.err.println("Error al cerrar los recursos: " + ex.getMessage());
            }
        }
        
    }

    @Override
    public void eliminar(String id) {
        CallableStatement callableStatement = null;

        try {
            callableStatement = connection.prepareCall("{CALL eliminarPersona(?)}");
            callableStatement.setString(1,id);
            callableStatement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error al eliminar la persona: " + ex.getMessage());
        } finally {
            try {
                if (callableStatement != null) {
                    callableStatement.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar los recursos: " + ex.getMessage());
            }
        }
    }

    @Override
    public List<Persona> listar() {
        List<Persona> personas = new ArrayList<>();
            CallableStatement callableStatement = null;
            ResultSet rs = null;

            try {
                callableStatement = connection.prepareCall("{CALL listarPersonas()}");
                rs = callableStatement.executeQuery();
                while (rs.next()) {
                    String idEntidad = rs.getString("idEntidad");
                    String documentoIdentidad = rs.getString("documentoIdentidad");
                    String password = rs.getString("password"); 
                    String email = rs.getString("email");
                    String nombre = rs.getString("nombre");
                    String telefono = rs.getString("telefono");

                    // Crea una nueva instancia de Persona utilizando el constructor adecuado
                    Persona persona = new Persona(nombre, telefono, idEntidad, documentoIdentidad, password, email, idEntidad);
                    
                    personas.add(persona);
                }
            } catch (SQLException ex) {
                System.err.println("Error al listar personas: " + ex.getMessage());
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (callableStatement != null) {
                        callableStatement.close();
                    }
                } catch (SQLException ex) {
                    System.err.println("Error al cerrar los recursos: " + ex.getMessage());
                }
            }
        return personas;
    }

    @Override
    public Persona buscarPorId(String id) {
        Persona persona = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;

        try {
            callableStatement = connection.prepareCall("{CALL obtenerPersona(?)}");
            callableStatement.setString(1, id);
            rs = callableStatement.executeQuery();
            if (rs.next()) {
                String idEntidad = rs.getString("idEntidad");
                String documentoIdentidad = rs.getString("documentoIdentidad");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");

                // Crea una nueva instancia de Persona utilizando el constructor adecuado
            persona = new Persona(nombre, telefono, idEntidad, documentoIdentidad, password, email, idEntidad);
            }
        } catch (SQLException ex) {
            System.err.println("Error al buscar la persona: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (callableStatement != null) {
                    callableStatement.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar los recursos: " + ex.getMessage());
            }
        }
        return persona;
    }

    @Override
    public void actualizar(Persona objeto) {
        CallableStatement callableStatement = null;

        try {
            callableStatement = connection.prepareCall("{CALL actualizarPersona(?, ?, ?)}");
            callableStatement.setString(1, objeto.getIdEntidad());
            callableStatement.setString(2, objeto.getNombre());
            callableStatement.setString(3, objeto.getTelefono());
            callableStatement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error al actualizar la persona: " + ex.getMessage());
        } finally {
            try {
                if (callableStatement != null) {
                    callableStatement.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar los recursos: " + ex.getMessage());
            }
        }
    }
    
}
