package Modelo;
import Interface.Mostrar;
public class MostrarIm implements Mostrar{
    @Override
    public void Mostrar(Object k) {
        System.out.println("Mostrando........");
        System.out.print(k + "\n");
    }
}
