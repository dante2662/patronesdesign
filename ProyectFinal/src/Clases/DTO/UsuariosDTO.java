/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.DTO;

/**
 *
 * @author Dan
 */
public class UsuariosDTO {
    private String idEntidad;
    private String documentoIdentidad;
    private String password;
    private String email;
    
    private String nombre;
    private String telefono;
    
    private String direccion;
    private String tipoEmpresa;

    private UsuariosDTO(Builder builder) {
        this.idEntidad = builder.idEntidad;
        this.documentoIdentidad = builder.documentoIdentidad;
        this.password = builder.password;
        this.email = builder.email;
        this.nombre = builder.nombre;
        this.direccion = builder.direccion;
        this.tipoEmpresa = builder.tipoEmpresa;
        this.telefono = builder.telefono;
    }
    
    public static class Builder {
        private String idEntidad;
        private String documentoIdentidad;
        private String password;
        private String email;

        private String nombre;
        private String telefono;

        private String direccion;
        private String tipoEmpresa;
        

        public Builder setIdEntidad(String idEntidad) {
            this.idEntidad = idEntidad;
            return this;
            
        }

        public Builder setDocumentoIdentidad(String documentoIdentidad) {
            this.documentoIdentidad = documentoIdentidad;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setTelefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Builder setDireccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public Builder setTipoEmpresa(String tipoEmpresa) {
            this.tipoEmpresa = tipoEmpresa;
            return this;
        }
        
        public UsuariosDTO build(){
            return new UsuariosDTO(this);
        }
    }

    public String getIdEntidad() {
        return idEntidad;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }


    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }
    @Override
    public String toString() {
        return "UsuariosDTO{" + "idEntidad=" + idEntidad + ", documentoIdentidad=" + documentoIdentidad + ", password=" + password + ", email=" + email + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", tipoEmpresa=" + tipoEmpresa + '}';
    }
    
    
}
