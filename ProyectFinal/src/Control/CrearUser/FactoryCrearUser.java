/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.CrearUser;

/**
 *
 * @author Dan
 */
public class FactoryCrearUser implements FactoryCrearUsuario{

    @Override
    public CrearImpleAdmin llamarimpleadmin() {
        return new CrearImpleAdmin();
    }

    @Override
    public CrearImpleEmpresa llamarimplempre() {
        return new CrearImpleEmpresa();
    }

    @Override
    public CrearImplePerson llamarimpleperson() {
        return new CrearImplePerson();
    }
    
}
