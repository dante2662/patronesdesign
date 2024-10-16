/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Control.SisCampania;

import Modelo.Campania;
import java.util.List;

/**
 *
 * @author Dan
 */
public interface SubSisCampania {
    void crearCampania(Campania Campania);
    void modificarCampania(Campania Campania);
    void cerrarCampania(String idCampania);
    void eliminarCampania(String idCampania);
    Campania obtenerEstadisticas(String idCampania);
    List<Campania> buscarCampania(String filtro);
}
