/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.SisCampania;

import Modelo.Campania;

/**
 *
 * @author ElMataPollos
 */
public class CampaniaLoggerDecorator extends CampaniaDecorator {

    public CampaniaLoggerDecorator(SubSisCampania decoratedCampania) {
        super(decoratedCampania);
    }

    @Override
    public void crearCampania(Campania campania) {
        System.out.println("Log: Creando campaña " + campania.getNombre());
        super.crearCampania(campania);
    }

    @Override
    public void modificarCampania(Campania campania) {
        System.out.println("Log: Modificando campaña " + campania.getNombre());
        super.modificarCampania(campania);
    }
}
