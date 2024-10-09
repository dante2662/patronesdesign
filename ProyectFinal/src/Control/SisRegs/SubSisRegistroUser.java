/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Control.SisRegs;

import Clases.DTO.UsuariosDTO;

/**
 *
 * @author Dan
 */
public interface SubSisRegistroUser {
    void registrarPersona(UsuariosDTO user);
    void registrarEmpresa(UsuariosDTO user);
    void registrarAdmin(UsuariosDTO user);

}
