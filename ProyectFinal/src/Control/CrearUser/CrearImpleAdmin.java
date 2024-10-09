/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.CrearUser;

import Clases.Administrador;
import Clases.DTO.UsuariosDTO;

/**
 *
 * @author Dan
 */
public class CrearImpleAdmin implements crearUsuario<Administrador>{

    @Override
    public Administrador crear(UsuariosDTO user) {
        return new Administrador(user.getIdEntidad(), user.getDocumentoIdentidad(), user.getPassword(), user.getEmail(), "Administrador");
    }
}
