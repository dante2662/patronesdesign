package Modelo;
public class Persona extends Entidad implements Cloneable {
    int contac;
    String email,tipoc;
    public Persona(int dcentidad, String rsoci, int CodCuen, String email, int contacto, char[] pw, String tipoc) {
        super(rsoci, dcentidad, CodCuen, pw);
        this.contac=contacto;
        this.email=email;
        this.tipoc=tipoc;
    }
    
    public Persona(){
    }
    
    public int getContac() {return contac;}
    public void setContac(int contac) {this.contac = contac;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getTipoc() {return tipoc;}
    public void setTipoc(String tipoc) {this.tipoc = tipoc;}
    @Override
    public Persona clone() {
        try {
            return (Persona) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    @Override
    public String toString() {
        return "Persona{" + "contac=" + contac + ", email=" + email + super.toString()+'}';
    }     
}
