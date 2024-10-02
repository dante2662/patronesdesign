package Modelo;
/* @author GRUPO DP*/
public abstract class Usuario implements Cloneable {
    protected String Dcentidad;
    protected String Rsoci;
    protected String contacto;
    protected String pw;
    protected String tipo;

    // Métodos comunes
    public abstract Usuario clone() throws CloneNotSupportedException;

    // Getters y setters
    public String getDcentidad() {
        return Dcentidad;
    }

    public void setDcentidad(String Dcentidad) {
        this.Dcentidad = Dcentidad;
    }

    public String getRsoci() {
        return Rsoci;
    }

    public void setRsoci(String Rsoci) {
        this.Rsoci = Rsoci;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}

