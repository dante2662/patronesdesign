package Modelo.DAOs;
/*@author GRUPO*/
public interface FactoryDAO {
    SistemasDAO llamadaSistemaDAO();
    UsuarioDAO llamadaUsuarioDAO();
    DonacionDAO llamadaDonacionDAO();
}
