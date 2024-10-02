package Modelo;
public class Entidad implements Cloneable{
    private String rsoci;
    private char[] pw;
    private int dcentidad, CodCuen;
    public Entidad(String rsoci, int dcentidad,int CodCuen, char[]pw) {
        this.rsoci = rsoci;
        this.dcentidad = dcentidad;
        this.CodCuen = CodCuen;
        this.pw=pw;
    }
    
    public Entidad(){}
    
    public char[] getPw() {
        return pw;
    }
    public void setPw(char[] pw) {
        this.pw = pw;
    }
    public String getRsoci() {
        return rsoci;
    }
    public void setRsoci(String rsoci) {
        this.rsoci = rsoci;
    }
    public int getDcentidad() {
        return dcentidad;
    }
    public void setDcentidad(int dcentidad) {
        this.dcentidad = dcentidad;
    }
    public int getCodCuen() {
        return CodCuen;
    }
    public void setCodCuen(int CodCuen) {
        this.CodCuen = CodCuen;
    }
    @Override
    public String toString() {
        return "Entidad{" + "rsoci=" + rsoci + ", dcentidad=" + dcentidad +  ", CodCuen=" + CodCuen + '}';
    }  
}
