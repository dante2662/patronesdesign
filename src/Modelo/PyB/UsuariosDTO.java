package Modelo.PyB;
/**@author Dan*/
public class UsuariosDTO {
    private String idEntidad;
    private String documentoIdentidad;
    private String password;
    private String email;
    private String nombre;
    private String telefono;
    private String direccion;
    private String tipoEmpresa;
    private String tipoUsuario;

    private UsuariosDTO(Builder builder) {
        this.documentoIdentidad = builder.documentoIdentidad;
        this.password = builder.password;
        this.email = builder.email;
        this.nombre = builder.nombre;
        this.direccion = builder.direccion;
        this.tipoEmpresa = builder.tipoEmpresa;
        this.telefono = builder.telefono;
        this.tipoUsuario = builder.tipoUsuario; // Establecer el tipo de usuario
    }
    
    public static class Builder {
        private String documentoIdentidad;
        private String password;
        private String email;
        private String nombre;
        private String telefono;
        private String direccion;
        private String tipoEmpresa;
        private String tipoUsuario; // Atributo del Builder


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
            this.tipoUsuario = "Persona"; // Establecer tipo de usuario como Persona
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
            this.tipoUsuario = "Empresa"; // Establecer tipo de usuario como Empresa
            return this;
        }

        public Builder setTipoUsuario(String tipoUsuario) {
            this.tipoUsuario = tipoUsuario;
            return this;
        }

        public UsuariosDTO build(){
            // Si el tipoUsuario no ha sido establecido, se considera como Administrador
            if (tipoUsuario == null) {
                this.tipoUsuario = "Administrador"; 
            }
            return new UsuariosDTO(this);
        }
    }

    public void setIdEntidad(String idEntidad) {
        this.idEntidad = idEntidad;
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

    public String getTipoUsuario() {
        return tipoUsuario; // Método para obtener el tipo de usuario
    }

    @Override
    public String toString() {
        return "UsuariosDTO{" + "idEntidad=" + idEntidad + ", documentoIdentidad=" + documentoIdentidad + ", password=" + password + ", email=" + email + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", tipoEmpresa=" + tipoEmpresa + ", tipoUsuario=" + tipoUsuario + '}'; 
    }
    
}
