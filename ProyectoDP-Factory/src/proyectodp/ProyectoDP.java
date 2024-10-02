package proyectodp;
import Control.PersonaFactory;
import Interface.PersonaInterfaz;
import Modelo.Empresa;
import Modelo.Persona;
import Modelo.GestorDonaciones;
import Modelo.Donativo;
public class ProyectoDP {
    public static void main(String[] args) {
//        Persona p=new Persona(123, "pepito@gh","Pepito",12345678,1, 01);
//        Empresa e=new Empresa(1234, "Jr pepito","Pepito SAC", 1234567891, 2,02);
//        Cuenta c=new Cuenta(123456,273,2030,01);
//        Donativo d=new Donativo("Viveres",01,02,01);
//        RegistroIm i=new RegistroIm();
//        MostrarIm m=new MostrarIm();
//        i.Registro(p);
//        m.Mostrar(p);
//        i.Registro(e);
//        m.Mostrar(e);
//        i.Registro(d);
//        m.Mostrar(d);
         /*Uso del patrón de diseño "Prototype" para la clase "Donativo"*/
        
        //Creamos una instancia para la gestión de las donaciones
        GestorDonaciones gestor = new GestorDonaciones();
        
        //Utilizamos try-catch para manejar las excepciones del
        //uso del método clone()
        try {
            //Creamos instancias para 
            Donativo donativo1 = new Donativo("Alimentos", 221012, 202659, 101);
            Donativo donativo2 = new Donativo("Ropa", 243103, 237595, 102);

            //Realizamos donaciones
            gestor.realizarDonacion(donativo1);
            gestor.realizarDonacion(donativo2);

            //Clonamos donativos
            Donativo donativoClonado = donativo1.clone();
            
            donativoClonado.setTip("Muebles");//Cambiamos el tipo de donativo
            donativoClonado.setCodDon(103);//Cambiamos el código de donación

            //Realizamos la donación del donativo clonado
            gestor.realizarDonacion(donativoClonado);

            //Mostramos todos los donativos
            gestor.mostrarDonativos();

        } catch (CloneNotSupportedException e) {
            System.out.println("No se pudo clonar el donativo: " + e.getMessage());
        }
        System.out.println();
        PersonaFactory fa= new PersonaFactory();
        fa.crearEntidad(12, "qwe", 13, "er", 0, "asd".toCharArray(), "asf");
        
    }
}