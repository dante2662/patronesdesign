/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import java.util.List;

/**
 *
 * @author Dan
 */
public interface GenericoDAO<T> {
    void crear(T objeto);
    void eliminar(String id);
    List<T> listar();
    T buscarPorId(String id);
    void actualizar(T objeto); 
}
