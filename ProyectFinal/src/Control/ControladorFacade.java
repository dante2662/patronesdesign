/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Clases.DTO.UsuariosDTO;
import Control.SisRegs.SubSisRegisUserImple;
import Modelo.Conexion.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dan
 */
public class ControladorFacade {

    SubSisRegisUserImple regisuser;

    public ControladorFacade() {

    }    
    
    public void registrarUsuario(UsuariosDTO user){

            regisuser = new SubSisRegisUserImple(Conexion.getInstancia().getConexion());
            if(user.getNombre()!= null){
                regisuser.registrarPersona(user);
            }else if(user.getDireccion()!=null && user.getTipoEmpresa()!=null){
                regisuser.registrarEmpresa(user);
            }else{
                regisuser.registrarAdmin(user);
            }
    
    }
}