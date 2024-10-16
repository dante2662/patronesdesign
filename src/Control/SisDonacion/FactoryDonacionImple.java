/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.SisDonacion;

/**
 *
 * @author Dan
 */
public class FactoryDonacionImple implements FactoryDonacionInter{

    @Override
    public SubSisDonativos llamadaDonativo(boolean decorator) {
        SubSisDonativos servicedonativo = new SubSisDonativosImpl();
        if(decorator){
            servicedonativo = new DonacionLoggerDecorator(servicedonativo);
        }
        return servicedonativo ;
    }
    
}
