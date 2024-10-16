/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.SisDonacion;

import Modelo.DAOs.FactoryImpleDAO;
import Modelo.Donacion;
import Modelo.PyB.DonacionDTO;
import java.util.List;

/**
 *
 * @author ElMataPollos
 */
public class SubSisDonativosImpl implements SubSisDonativos {

    private FactoryImpleDAO dao;

    public SubSisDonativosImpl() {
        this.dao = new FactoryImpleDAO();
    }

    @Override
    public void donar(DonacionDTO donacion) {
        if (donacion != null && donacion.getIdDonacion() != null) {
            dao.llamadaDonacionDAO().crear(donacion);
            System.out.println("Donación registrada con éxito.");
        } else {
            System.out.println("Donación inválida.");
        }
    }

    @Override
    public void cancelarDonacion(String idDonacion) {
        if (idDonacion != null && !idDonacion.isEmpty()) {
            dao.llamadaDonacionDAO().eliminar(idDonacion);
            System.out.println("Donación cancelada con éxito.");
        } else {
            System.out.println("ID de donación inválido.");
        }
    }

    @Override
    public List<Donacion> obtenerHistorialDonaciones(String idEntidad) {
        if (idEntidad != null && !idEntidad.isEmpty()) {
            return dao.llamadaDonacionDAO().listar(); // Ajustar si necesitas filtrar por idEntidad
        } else {
            System.out.println("ID de entidad inválido.");
            return null;
        }
    }

    @Override
    public Donacion obtenerEstadoDonativo(String idDonacion) {
        if (idDonacion != null && !idDonacion.isEmpty()) {
            return dao.llamadaDonacionDAO().buscarPorId(idDonacion);
        } else {
            System.out.println("ID de donación inválido.");
            return null;
        }
    }

    @Override
    public boolean verificarDonativo(String idDonacion) {
        if (idDonacion != null && !idDonacion.isEmpty()) {
            Donacion donacion = dao.llamadaDonacionDAO().buscarPorId(idDonacion);
            return donacion != null;
        } else {
            System.out.println("ID de donación inválido.");
            return false;
        }
    }
}
