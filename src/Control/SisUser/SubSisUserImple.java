/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.SisUser;

import Modelo.Entidad;
import Modelo.Session;
import Modelo.PyB.UsuariosDTO;
import Modelo.DAOs.FactoryImpleDAO;

/**@author Dan*/
public class SubSisUserImple implements SubSisUser{
    
    FactoryImpleDAO dao;
    
    public SubSisUserImple() {
        this.dao = new FactoryImpleDAO();
    }

    @Override
    public void registrar(UsuariosDTO user) {
        if(user.getTipoUsuario()!= null){
            dao.llamadaUsuarioDAO().crear(user);
        }
    }

    @Override
    public void logear(String di, String pass) {
        if (di == null || di.isEmpty()) {
            System.out.println("documento de identidad vacío");
            return;
        }
        
        if (pass == null || pass.isEmpty()) {
            System.out.println("contraseña vacía"); 
            return;
        }
        Entidad ent =dao.llamadaSistemaDAO().loginUsuario(di, pass);
        if(ent!=null){
            Session.getInstance().login(ent);
            System.out.println("Funciono XD");
        }   
    }

    @Override
    public void actualizar(UsuariosDTO user) {
        String id = Session.getInstance().getID();
        if(user != null){
            user.setIdEntidad(id);
            dao.llamadaUsuarioDAO().actualizar(user);
        }
    }

    @Override
    public void verperfil() {
        
        String id = Session.getInstance().getID();
        if(id!=null){
            dao.llamadaUsuarioDAO().buscarPorId(id);
        }
    }

}
