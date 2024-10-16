/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Control.SisDonacion;

import Modelo.Donacion;
import Modelo.PyB.DonacionDTO;
import java.util.List;

/**
 *
 * @author Dan
 */
public interface SubSisDonativos {
    void donar(DonacionDTO donacion);
    void cancelarDonacion(String idDonacion);
    List<Donacion> obtenerHistorialDonaciones(String idEntidad); //devolver lista
    Donacion obtenerEstadoDonativo(String idDonacion);
    boolean verificarDonativo(String idDonacion);
}
