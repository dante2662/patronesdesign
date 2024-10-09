/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.CrearUser;

import Clases.DTO.UsuariosDTO;
import Clases.Persona;

/**
 *
 * @author Dan
 */
public class CrearImplePerson implements crearUsuario<Persona>{

    @Override
    public Persona crear(UsuariosDTO user) {
        return new Persona(user.getNombre(),user.getTelefono(), user.getIdEntidad(), user.getDocumentoIdentidad(), user.getPassword(), user.getEmail(),"Persona");
    }
    
}
