/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Dan
 */
public class Persona extends Entidad {
    private String nombre;
    private String telefono;

    public Persona(String nombre, String telefono, String idEntidad, String documentoIdentidad, String password, String email, String tipoEntidad) {
        super(idEntidad, documentoIdentidad, password, email, tipoEntidad);
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" +
                super.toString() +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }


}

