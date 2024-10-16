/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.SisUser;

/**
 *
 * @author Yato
 */
public class FactoryUserImple implements FactoryUserInter{

    @Override
    public SubSisUser llamdaUser(boolean decorator) {
        SubSisUser serviceuser = new SubSisUserImple();
        if(decorator){
            serviceuser = new UserLoggerDecorator(serviceuser);
        }
        return serviceuser;
    }
   
}
