/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.SisRegs;

import Clases.Administrador;
import Clases.DTO.UsuariosDTO;
import Clases.Empresa;
import Clases.Persona;
import Control.CrearUser.FactoryCrearUser;
import Modelo.FactoryDAO;
import Modelo.FactoryImpleDAO;
import java.sql.*;

/**
 *
 * @author Dan
 */
public class SubSisRegisUserImple implements SubSisRegistroUser{
    
    private FactoryCrearUser crear;
    private FactoryDAO dao;
    
    public SubSisRegisUserImple(Connection connection) {
        this.crear = new FactoryCrearUser();
        this.dao = new FactoryImpleDAO(connection);
    }
    
    @Override
    public void registrarPersona(UsuariosDTO user) {
        Persona per = crear.llamarimpleperson().crear(user);
       
        dao.llamadaImplePerson().crear(per);
        
    }

    @Override
    public void registrarEmpresa(UsuariosDTO user) {
        Empresa emp =  crear.llamarimplempre().crear(user);
        dao.llamadaImpleEmpres().crear(emp);
    }

    @Override
    public void registrarAdmin(UsuariosDTO user) {
        Administrador adm = crear.llamarimpleadmin().crear(user);
        dao.llamadaImpleAdmin().crear(adm);
    }

}
