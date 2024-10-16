/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Dan
 */
public class Entidad {
    private String idEntidad;
    private String documentoIdentidad;
    private String password;
    private String email;
    private String tipoEntidad;

    public Entidad(String idEntidad, String documentoIdentidad, String password, String email, String tipoEntidad) {
        this.idEntidad = idEntidad;
        this.documentoIdentidad = documentoIdentidad;
        this.password = password;
        this.email = email;
        this.tipoEntidad = tipoEntidad;
    }
    
    public String getIdEntidad() {
        return idEntidad;
    }
    
    public void setIdEntidad(String idEntidad) {    
        this.idEntidad = idEntidad;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(String tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    @Override
    public String toString() {
        return "Entidad{" +
                "idEntidad=" + idEntidad +
                ", documentoIdentidad='" + documentoIdentidad + '\'' +
                ", email='" + email + '\'' +
                ", tipoEntidad='" + tipoEntidad + '\'' +
                '}';
    }
}
