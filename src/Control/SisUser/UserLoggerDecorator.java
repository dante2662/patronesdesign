package Control.SisUser;

import Modelo.PyB.UsuariosDTO;
import Modelo.Session;

/**@author ElMataPollos*/

public class UserLoggerDecorator extends UserDecorator {
    
    public UserLoggerDecorator(SubSisUser decoratedUser) {
        super(decoratedUser);
    }

    @Override
    public void registrar(UsuariosDTO user) {
        super.registrar(user);
        registrarLog("Usuario registrado y verificado con Decorator ");
    }

    @Override
    public void logear(String di, String pass) {
        super.logear(di, pass);
        registrarLog("Usuario intenta logear con Decorator " + di);
    }

    @Override
    public void actualizar(UsuariosDTO user) {
        super.actualizar(user);
        registrarLog("Usuario actualizado con Decorator " + user.toString());
    }

    @Override
    public void verperfil() {
        super.verperfil();
        registrarLog("Perfil visto por el usuario con Decorator " 
                + Session.getInstance().getID());
    }

    private void registrarLog(String mensaje) {
        System.out.println("LOG: " + mensaje);
    }
}
