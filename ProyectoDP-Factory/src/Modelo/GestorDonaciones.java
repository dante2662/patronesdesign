package Modelo;

import Interface.*;
import java.util.*;

public class GestorDonaciones {
    //Creamos una lista para poder almacenar los donativos, utilizando la clase
    //"Donativo"
    private List<Donativo> donativos;

    public GestorDonaciones() {
        donativos = new ArrayList<>();
    }
    
    //Método para realizar una donación usando un registro que ya tengamos
    
    public void realizarDonacion(Donativo donativo) {
        if (donativos.isEmpty()) {
            System.out.println("Registro de Donaciones:");
            System.out.println();
        }
        
        //Usamos la interfaz de registro para registrar una nueva donación
        Registro<Donativo> registro = new RegistroIm();
        
        registro.Registro(donativo);//Usa la interfaz "Registro" para registrar
        donativos.add(donativo);//Agregamos el donativo a la lista
    }
    
    // Método para mostrar la lista de donativos
    
    public void mostrarDonativos() {
        System.out.println();
        System.out.println("Lista de Donativos:");
        System.out.println();
        
        //Usamos la interfaz de registro para mostrar la nueva donación
        Mostrar<Donativo> mostrar = new MostrarIm();
        
        //Iteramos con un "for-each" sobre cada elemento de la lista "donativos"
        //y se le asignará cada elemento a la variable "donativo"
        for (Donativo donativo : donativos) {
            mostrar.Mostrar(donativo);//Usa la interfaz "Mostrar" para imprimir
        }
        
    }
}


