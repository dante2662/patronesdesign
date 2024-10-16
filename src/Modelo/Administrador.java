/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Dan
 */
public class Administrador extends Entidad {

    public Administrador(String idEntidad, String documentoIdentidad, String password, String email, String tipoEntidad) {
        super(idEntidad, documentoIdentidad, password, email, tipoEntidad);
    }

   
    @Override
    public String toString() {
        return "Administrador{" +
                super.toString() +
                '}';
    }
}
