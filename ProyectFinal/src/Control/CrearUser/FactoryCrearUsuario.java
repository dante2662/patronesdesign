/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Control.CrearUser;

/**
 *
 * @author Dan
 */
public interface FactoryCrearUsuario {
    CrearImpleAdmin llamarimpleadmin();
    CrearImpleEmpresa llamarimplempre();
    CrearImplePerson llamarimpleperson();
}
