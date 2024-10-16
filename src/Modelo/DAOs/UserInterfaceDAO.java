/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo.DAOs;

import Modelo.PyB.UsuariosDTO;
import java.util.List;

/**
 *
 * @author Dan
 */
public interface UserInterfaceDAO<T> {
    void crear(UsuariosDTO usuarioDTO);
    void eliminar(String id);
    List<T> listar();
    T buscarPorId(String id);
    void actualizar(UsuariosDTO usuarioDTO); 
}
