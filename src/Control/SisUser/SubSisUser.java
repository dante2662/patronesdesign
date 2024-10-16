package Control.SisUser;

import Modelo.PyB.UsuariosDTO;

/**@author Yato*/

public interface SubSisUser {
    void registrar(UsuariosDTO user);
    void logear(String di,String pass);
    void actualizar(UsuariosDTO user);
    void verperfil();
}
