/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Clases.Administrador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dan
 */
public class AdminImpleDAO implements GenericoDAO<Administrador>{
    private Connection connection;

    public AdminImpleDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Administrador objeto) {
        CallableStatement callableStatement = null;
        try {
            callableStatement = connection.prepareCall("{CALL insertarAdministrador(?, ?, ?)}");
            callableStatement.setString(1, objeto.getDocumentoIdentidad());
            callableStatement.setString(2, objeto.getPassword());
            callableStatement.setString(3, objeto.getEmail());
            callableStatement.execute();
        } catch (SQLException ex) {
            System.err.println("Error al crear administrador: " + ex.getMessage());
        } finally {
             
            try {
                
                if (callableStatement != null) {
                    callableStatement.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar recursos: " + ex.getMessage());
            }
        }
    }

    @Override
    public void eliminar(String id) {
        CallableStatement callableStatement = null;
        try {
            callableStatement = connection.prepareCall("{CALL eliminarAdministrador(?)}");
            callableStatement.setString(1, id);
            callableStatement.execute();
        } catch (SQLException ex) {
            System.err.println("Error al eliminar administrador: " + ex.getMessage());
        } finally {
            try {
                if (callableStatement != null) {
                    callableStatement.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar recursos: " + ex.getMessage());
            }
        }
    }

    @Override
    public List<Administrador> listar() {
        List<Administrador> administradores = new ArrayList<>();
        CallableStatement callableStatement = null;
        ResultSet rs = null;

        try {
            callableStatement = connection.prepareCall("{CALL listarAdministradores()}");
            rs = callableStatement.executeQuery();
            while (rs.next()) {
                String idEntidad = rs.getString("idEntidad");
                String documentoIdentidad = rs.getString("documentoIdentidad");
                String password = rs.getString("password"); // Manejar este campo según sea necesario
                String email = rs.getString("email");
                
                Administrador admin = new Administrador(idEntidad, documentoIdentidad, password, email, idEntidad);

                administradores.add(admin);
            }
        } catch (SQLException ex) {
            System.err.println("Error al listar administradores: " + ex.getMessage());
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
        return administradores;
    }

    @Override
    public Administrador buscarPorId(String id) {
        Administrador administrador = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;

        try {
            callableStatement = connection.prepareCall("{CALL obtenerAdministrador(?)}");
            callableStatement.setString(1, id);
            rs = callableStatement.executeQuery();
            if (rs.next()) {
                String idEntidad = rs.getString("idEntidad");
                String documentoIdentidad = rs.getString("documentoIdentidad");
                String password = rs.getString("password"); // Manejar este campo según sea necesario
                String email = rs.getString("email");

                administrador = new Administrador(idEntidad, documentoIdentidad, password, email, idEntidad);

            }
        } catch (SQLException ex) {
            System.err.println("Error al buscar el administrador: " + ex.getMessage());
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
        return administrador;
    }

    @Override
    public void actualizar(Administrador objeto) {
        CallableStatement callableStatement = null;
        try {
            callableStatement = connection.prepareCall("{CALL actualizarEyA(?, ?, ?, ?)}");
            callableStatement.setString(1, objeto.getIdEntidad());
            callableStatement.setString(2, objeto.getDocumentoIdentidad());
            callableStatement.setString(3, objeto.getPassword());
            callableStatement.setString(4, objeto.getEmail());
            callableStatement.execute();
        } catch (SQLException ex) {
            System.err.println("Error al actualizar el administrador: " + ex.getMessage());
        } finally {
            try {
                if (callableStatement != null) {
                    callableStatement.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar recursos: " + ex.getMessage());
            }
        }
    }
    
}
