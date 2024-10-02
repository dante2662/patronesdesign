package Modelo;
import Interface.*;
public class RegistroIm implements Registro {
    @Override
    public void Registro(Object k) {
        System.out.println("Registrando......");
        System.out.print(k+"\n");
    }   
}
