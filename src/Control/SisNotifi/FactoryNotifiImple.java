/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.SisNotifi;

/**
 *
 * @author Dan
 */
public class FactoryNotifiImple implements FactoryNotifiInter{

    @Override
    public SubSisNotifi llamadaNotifi(boolean decorator) {
        SubSisNotifi servicenotifi = new SubSisNotifiImpl();
        if(decorator){
            servicenotifi = new NotificacionLoggerDecorator(servicenotifi);
        }
        return servicenotifi;
    }
    
}
