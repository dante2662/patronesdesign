/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Control;

import Control.SisCampania.SubSisCampania;
import Control.SisDonacion.SubSisDonativos;
import Control.SisNotifi.SubSisNotifi;
import Control.SisUser.SubSisUser;


/**
 *
 * @author Dan
 */
public interface FactorySubSis {
    SubSisCampania llamadacampania(Boolean decorator);
    SubSisNotifi llamadaNotifi(Boolean decorator);
    SubSisDonativos llamadaDonacion(Boolean decorator);
    SubSisUser llamadaUser(Boolean decorator);
}
