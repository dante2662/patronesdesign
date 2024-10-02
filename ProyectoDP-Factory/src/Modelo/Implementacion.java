package Modelo;
import Interface.Interface;
public class Implementacion implements Interface {

    @Override
    public void Registro(Object k) {
        System.out.println("Registrando......");
        System.out.print(k+"\n");
    }

    @Override
    public void Mostrar(Object k) {
        System.out.println("Mostrando........");
        System.out.print(k+"\n");
    }

    
}
