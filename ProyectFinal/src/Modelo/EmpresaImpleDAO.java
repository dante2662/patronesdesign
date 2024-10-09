/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Clases.Empresa;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Dan
 */
public class EmpresaImpleDAO implements GenericoDAO<Empresa>{
    
    Connection connection;

    public EmpresaImpleDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Empresa objeto) {
        CallableStatement callableStatement = null;

        try {
            // Preparar la llamada al procedimiento almacenado
            callableStatement = connection.prepareCall("{CALL insertarEmpresa(?, ?, ?, ?, ?, ?)}");
            callableStatement.setString(1, objeto.getDocumentoIdentidad());
            callableStatement.setString(2, objeto.getPassword());
            callableStatement.setString(3, objeto.getEmail());
            callableStatement.setString(4, objeto.getDireccion());
            callableStatement.setString(5, objeto.getTipoEmpresa());
            callableStatement.setString(6, objeto.getTelefono());
            
            // Ejecutar el procedimiento
            callableStatement.execute();
        } catch (SQLException ex) {
            System.err.println("Error al crear la empresa: " + ex.getMessage());
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
            // Preparar la llamada al procedimiento almacenado
            callableStatement = connection.prepareCall("{CALL eliminarEmpresa(?)}");
            callableStatement.setString(1, id);
            
            // Ejecutar el procedimiento
            callableStatement.execute();
        } catch (SQLException ex) {
            System.err.println("Error al eliminar la empresa: " + ex.getMessage());
        } finally {
            // Cerrar recursos
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
    public List<Empresa> listar() {
        List<Empresa> empresas = new ArrayList<>();
        CallableStatement callableStatement = null;
        ResultSet rs = null;

        try {
            callableStatement = connection.prepareCall("{CALL listarEmpresas()}");
            rs = callableStatement.executeQuery();
            while (rs.next()) {
                String idEntidad = rs.getString("idEntidad");
                String documentoIdentidad = rs.getString("documentoIdentidad");
                String password = rs.getString("password"); // Manejar este campo según sea necesario
                String email = rs.getString("email");
                String direccion = rs.getString("direccion");
                String tipoEmpresa = rs.getString("tipoEmpresa");
                String telefono = rs.getString("telefono");

                Empresa empresa = new Empresa(direccion, tipoEmpresa, telefono, idEntidad, documentoIdentidad, password, email, idEntidad);
                empresas.add(empresa);
            }
        } catch (SQLException ex) {
            System.err.println("Error al listar empresas: " + ex.getMessage());
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
        return empresas;
    }

    @Override
    public Empresa buscarPorId(String id) {
        Empresa empresa = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;

        try {
            callableStatement = connection.prepareCall("{CALL obtenerEmpresa(?)}");
            callableStatement.setString(1, id);
            rs = callableStatement.executeQuery();
            if (rs.next()) {
                String idEntidad = rs.getString("idEntidad");
                String documentoIdentidad = rs.getString("documentoIdentidad");
                String password = rs.getString("password"); // Manejar este campo según sea necesario
                String email = rs.getString("email");
                String direccion = rs.getString("direccion");
                String tipoEmpresa = rs.getString("tipoEmpresa");
                String telefono = rs.getString("telefono");

                // Crear una nueva instancia de Empresa utilizando el constructor adecuado
                empresa = new Empresa(direccion, tipoEmpresa, telefono, idEntidad, documentoIdentidad, password, email, idEntidad);
            }
        } catch (SQLException ex) {
            System.err.println("Error al buscar la empresa: " + ex.getMessage());
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
        return empresa;
    }

    @Override
    public void actualizar(Empresa objeto) {
        CallableStatement callableStatement = null;

        try {
            // Preparar la llamada al procedimiento almacenado
            callableStatement = connection.prepareCall("{CALL actualizarEmpresa(?, ?, ?, ?, ?, ?, ?)}");
            callableStatement.setString(1, objeto.getIdEntidad());
            callableStatement.setString(2, objeto.getDocumentoIdentidad());
            callableStatement.setString(3, objeto.getPassword());
            callableStatement.setString(4, objeto.getEmail());
            callableStatement.setString(5, objeto.getDireccion());
            callableStatement.setString(6, objeto.getTipoEmpresa());
            callableStatement.setString(7, objeto.getTelefono());
            
            // Ejecutar el procedimiento
            callableStatement.execute();
        } catch (SQLException ex) {
            System.err.println("Error al actualizar la empresa: " + ex.getMessage());
        } finally {
            // Cerrar recursos
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
