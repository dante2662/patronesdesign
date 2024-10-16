/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.SisCampania;

import Modelo.Campania;
import java.util.List;

/**
 *
 * @author ElMataPollos
 */
public abstract class CampaniaDecorator implements SubSisCampania {
    protected SubSisCampania decoratedCampania;

    public CampaniaDecorator(SubSisCampania decoratedCampania) {
        this.decoratedCampania = decoratedCampania;
    }

    @Override
    public void crearCampania(Campania campania) {
        decoratedCampania.crearCampania(campania);
    }

    @Override
    public void modificarCampania(Campania campania) {
        decoratedCampania.modificarCampania(campania);
    }

    @Override
    public void cerrarCampania(String idCampania) {
        decoratedCampania.cerrarCampania(idCampania);
    }

    @Override
    public void eliminarCampania(String idCampania) {
        decoratedCampania.eliminarCampania(idCampania);
    }

    @Override
    public Campania obtenerEstadisticas(String idCampania) {
        return decoratedCampania.obtenerEstadisticas(idCampania);
    }

    @Override
    public List<Campania> buscarCampania(String filtro) {
        return decoratedCampania.buscarCampania(filtro);
    }
}

