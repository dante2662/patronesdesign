package Control.SisUser;

import Modelo.PyB.UsuariosDTO;

/**@author ElMataPollos*/
public abstract class UserDecorator implements SubSisUser {
    protected SubSisUser decoratedUser;

    public UserDecorator(SubSisUser decoratedUser) {
        this.decoratedUser = decoratedUser;
    }

    @Override
    public void registrar(UsuariosDTO user) {
        decoratedUser.registrar(user);
    }

    @Override
    public void logear(String di, String pass) {
        decoratedUser.logear(di, pass);
    }

    @Override
    public void actualizar(UsuariosDTO user) {
        decoratedUser.actualizar(user);
    }

    @Override
    public void verperfil() {
        decoratedUser.verperfil();
    }
}
