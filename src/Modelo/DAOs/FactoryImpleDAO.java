package Modelo.DAOs;

/*@author Dan*/

public class FactoryImpleDAO implements FactoryDAO{

    public FactoryImpleDAO() {

    }

    @Override
    public SistemasDAO llamadaSistemaDAO() {
        return new SistemasDAO();
    }

    @Override
    public UsuarioDAO llamadaUsuarioDAO() {
        return new UsuarioDAO();
    }

    @Override
    public DonacionDAO llamadaDonacionDAO() {
        return new DonacionDAO();
    }
    
}
