/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.SisDonacion;

import Modelo.Donacion;
import Modelo.PyB.DonacionDTO;
import java.util.List;

/**
 *
 * @author ElMataPollos
 */
public class DonacionLoggerDecorator extends DonacionDecorator {

    public DonacionLoggerDecorator(SubSisDonativos decoratedDonativos) {
        super(decoratedDonativos);
    }

    @Override
    public void donar(DonacionDTO donacion) {
        super.donar(donacion);
        registrarLog("Donación realizada: " + donacion.getIdDonacion());
    }

    @Override
    public void cancelarDonacion(String idDonacion) {
        super.cancelarDonacion(idDonacion);
        registrarLog("Donación cancelada: " + idDonacion);
    }

    @Override
    public List<Donacion> obtenerHistorialDonaciones(String idEntidad) {
        List<Donacion> historial = super.obtenerHistorialDonaciones(idEntidad);
        registrarLog("Historial de donaciones obtenido para entidad: " + idEntidad);
        return historial;
    }

    @Override
    public Donacion obtenerEstadoDonativo(String idDonacion) {
        Donacion donacion = super.obtenerEstadoDonativo(idDonacion);
        registrarLog("Estado del donativo obtenido: " + idDonacion);
        return donacion;
    }

    @Override
    public boolean verificarDonativo(String idDonacion) {
        boolean resultado = super.verificarDonativo(idDonacion);
        registrarLog("Verificación del donativo: " + idDonacion);
        return resultado;
    }

    private void registrarLog(String mensaje) {
        System.out.println("LOG: " + mensaje);
    }
}
