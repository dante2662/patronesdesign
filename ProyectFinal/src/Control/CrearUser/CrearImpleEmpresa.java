/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.CrearUser;

import Clases.DTO.UsuariosDTO;
import Clases.Empresa;

/**
 *
 * @author Dan
 */
public class CrearImpleEmpresa implements crearUsuario<Empresa>{

    @Override
    public Empresa crear(UsuariosDTO user) {
        return new Empresa(user.getDireccion(), user.getTipoEmpresa(), user.getTelefono(), user.getIdEntidad(), user.getDocumentoIdentidad(),user.getPassword(), user.getEmail(),"Empresa");
    }
    
}
