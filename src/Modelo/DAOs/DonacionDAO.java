/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAOs;

import Modelo.Conexion.Conexion;
import Modelo.Donacion;
import Modelo.PyB.DonacionDTO;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class DonacionDAO implements InterfaceDAOs<Donacion, DonacionDTO>{
    
    Connection conn;

    public DonacionDAO() {
        this.conn = Conexion.getInstancia().getConexion();
    }

    @Override
    public void crear(DonacionDTO donacion) {
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{CALL registerDonacion(?, ?, ?, ?)}");
            stmt.setString(1, donacion.getIdDonacion());
            stmt.setDouble(2, donacion.getMonto());
            stmt.setString(3, donacion.getTipo());
            stmt.setString(4, donacion.getFecha());
            stmt.execute(); // Ejecutar el procedimiento
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
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
    public List<Donacion> listar() {
        CallableStatement stmt = null;
        ResultSet rs = null;
        List<Donacion> listaDonaciones = new ArrayList<>();

        try {
            stmt = conn.prepareCall("{ obtenerDonaciones()}"); // Llamada al procedimiento almacenado
            rs = stmt.executeQuery();

            // Recorrer los resultados y agregar las donaciones a la lista
            while (rs.next()) {
                String idDonacion = rs.getString("idDonacion");
                double monto = rs.getDouble("monto");
                String tipoDonativo = rs.getString("tipoDonativo");
                String fecha = rs.getString("fecha");

                Donacion donacion = new Donacion(idDonacion, idDonacion, monto, fecha, fecha, tipoDonativo);
                listaDonaciones.add(donacion);
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
        return listaDonaciones;        
    }

    @Override
    public Donacion buscarPorId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(DonacionDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
