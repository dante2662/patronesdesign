/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.SisCampania;

/**
 *
 * @author Dan
 */
public class FactoryCampaniaImple implements FactoryCampaniaInter{

    @Override
    public SubSisCampania llamadaCampania(boolean decorator) {
        SubSisCampania campaniaSistema = new SubSisCampaniaImpl();
        if(decorator){
            campaniaSistema = new CampaniaLoggerDecorator(campaniaSistema);
        }
        return campaniaSistema;
    }
    
}
