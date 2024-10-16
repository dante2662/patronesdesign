/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Dan
 */
public class Empresa extends Entidad {
    private String direccion;
    private String tipoEmpresa;
    private String telefono; // Agregado

    public Empresa(String direccion, String tipoEmpresa, String telefono, String idEntidad, String documentoIdentidad, String password, String email, String tipoEntidad) {
        super(idEntidad, documentoIdentidad, password, email, tipoEntidad);
        this.direccion = direccion;
        this.tipoEmpresa = tipoEmpresa;
        this.telefono = telefono;
    }

    // Getters y Setters
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getTelefono() {
        return telefono; // Método para obtener el teléfono
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono; // Método para establecer el teléfono
    }

    @Override
    public String toString() {
        return "Empresa{" +
                super.toString() +
                ", direccion='" + direccion + '\'' +
                ", tipoEmpresa='" + tipoEmpresa + '\'' +
                ", telefono='" + telefono + '\'' + // Incluido en la representación de cadena
                '}';
    }
}



