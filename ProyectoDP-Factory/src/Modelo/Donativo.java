package Modelo;
//Utilizamos la interfaz Cloneable de Java para implementar
//el patrón de diseño "Prototype"
public class Donativo implements Cloneable{
   String tip;
   int codemi,codrec, codDon;
    public Donativo(String tip, int codemi, int codrec, int codDon) {
        this.tip = tip;
        this.codemi = codemi;
        this.codrec = codrec;
        this.codDon = codDon;
    }
    public String getTip() {
        return tip;
    }
    public void setTip(String tip) {
        this.tip = tip;
    }
    public int getCodemi() {
        return codemi;
    }
    public void setCodemi(int codemi) {
        this.codemi = codemi;
    }
    public int getCodrec() {
        return codrec;
    }
    public void setCodrec(int codrec) {
        this.codrec = codrec;
    }
    public int getCodDon() {
        return codDon;
    }
    public void setCodDon(int codDon) {
        this.codDon = codDon;
    }
    
    @Override
    public Donativo clone() throws CloneNotSupportedException {
        return (Donativo) super.clone();
    }
    @Override
    public String toString() {
        return "Donativo{" + "tip=" + tip + ", codemi=" + codemi + ", codrec=" + codrec + ", codDon=" + codDon + '}';
    } 
}
