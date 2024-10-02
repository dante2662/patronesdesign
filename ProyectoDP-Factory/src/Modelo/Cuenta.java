package Modelo;
public class Cuenta {
    int numC, cvc, fV, cCuenta;
    public Cuenta(int numC, int cvc, int fV, int cCuenta) {
        this.numC = numC;
        this.cvc = cvc;
        this.fV = fV;
        this.cCuenta = cCuenta;
    }
    public int getNumC() {
        return numC;
    }
    public void setNumC(int numC) {
        this.numC = numC;
    }
    public int getCvc() {
        return cvc;
    }
    public void setCvc(int cvc) {
        this.cvc = cvc;
    }
    public int getfV() {
        return fV;
    }
    public void setfV(int fV) {
        this.fV = fV;
    }
    public int getcCuenta() {
        return cCuenta;
    }
    public void setcCuenta(int cCuenta) {
        this.cCuenta = cCuenta;
    }
    @Override
    public String toString() {
        return "Cuenta{" + "numC=" + numC + ", cvc=" + cvc + ", fV=" + fV + ", cCuenta=" + cCuenta + '}';
    }    
}
