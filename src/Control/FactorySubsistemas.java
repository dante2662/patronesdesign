/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Control.SisCampania.CampaniaLoggerDecorator;
import Control.SisCampania.SubSisCampania;
import Control.SisCampania.SubSisCampaniaImpl;
import Control.SisDonacion.DonacionLoggerDecorator;
import Control.SisDonacion.SubSisDonativos;
import Control.SisDonacion.SubSisDonativosImpl;
import Control.SisNotifi.NotificacionLoggerDecorator;
import Control.SisNotifi.SubSisNotifi;
import Control.SisNotifi.SubSisNotifiImpl;
import Control.SisUser.SubSisUser;
import Control.SisUser.SubSisUserImple;
import Control.SisUser.UserLoggerDecorator;

/**
 *
 * @author Dan
 */
public class FactorySubsistemas implements FactorySubSis{

    @Override
    public SubSisCampania llamadacampania(Boolean decorator) {
        SubSisCampania campaniaSistema = new SubSisCampaniaImpl();
        if(decorator){
            campaniaSistema = new CampaniaLoggerDecorator(campaniaSistema);
        }
        return campaniaSistema;
    }


    @Override
    public SubSisUser llamadaUser(Boolean decorator) {
        SubSisUser serviceuser = new SubSisUserImple();
        if(decorator){
            serviceuser = new UserLoggerDecorator(serviceuser);
        }
        return serviceuser;
    }

    @Override
    public SubSisNotifi llamadaNotifi(Boolean decorator) {
        SubSisNotifi servicenotifi = new SubSisNotifiImpl();
        if(decorator){
            servicenotifi = new NotificacionLoggerDecorator(servicenotifi);
        }
        return servicenotifi;
    }

    @Override
    public SubSisDonativos llamadaDonacion(Boolean decorator) {
        SubSisDonativos servicedonativo = new SubSisDonativosImpl();
        if(decorator){
            servicedonativo = new DonacionLoggerDecorator(servicedonativo);
        }
        return servicedonativo ;
    }

    
}
