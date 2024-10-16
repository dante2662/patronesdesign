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
public abstract class DonacionDecorator implements SubSisDonativos {
    protected SubSisDonativos decoratedDonativos;

    public DonacionDecorator(SubSisDonativos decoratedDonativos) {
        this.decoratedDonativos = decoratedDonativos;
    }

    @Override
    public void donar(DonacionDTO donacion) {
        decoratedDonativos.donar(donacion);
    }

    @Override
    public void cancelarDonacion(String idDonacion) {
        decoratedDonativos.cancelarDonacion(idDonacion);
    }

    @Override
    public List<Donacion> obtenerHistorialDonaciones(String idEntidad) {
        return decoratedDonativos.obtenerHistorialDonaciones(idEntidad);
    }

    @Override
    public Donacion obtenerEstadoDonativo(String idDonacion) {
        return decoratedDonativos.obtenerEstadoDonativo(idDonacion);
    }

    @Override
    public boolean verificarDonativo(String idDonacion) {
        return decoratedDonativos.verificarDonativo(idDonacion);
    }
}
