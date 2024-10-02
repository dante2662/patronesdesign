package Modelo;
public class Empresa extends Entidad implements Cloneable{
    int contacto;
    String direccion, tipoc;
    public Empresa(int dcentidad, 
            String rsoci, int CodCuen
            , String direccion,int contacto, char[] pw, String tipoc) {
        super(rsoci, dcentidad, CodCuen, pw);
        this.contacto=contacto;
        this.direccion=direccion;
        this.tipoc=tipoc;
    }   
    public Empresa(){}
    public int getContacto() {return contacto;}
    public void setContacto(int contacto) {this.contacto = contacto;}
    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    public String getTipo(){return tipoc;}
    public void setTipo(String tipoc) {this.tipoc = tipoc;}
    
    @Override
    public Empresa clone() {
        try {
            return (Empresa) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    @Override
    public String toString() {
        return "Empresa{" + "contacto=" + contacto + ", direccion=" + direccion +  super.toString()+'}';
    }           
}
