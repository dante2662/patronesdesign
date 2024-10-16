/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo.DAOs;

import java.util.List;

/**
 *
 * @author Dan
 * @param <T>
 * @param <S>
 */
public interface InterfaceDAOs<T,S> {
    void crear(S t);
    void eliminar(String id);
    List<T> listar();
    T buscarPorId(String id);
    void actualizar(S t);
}
