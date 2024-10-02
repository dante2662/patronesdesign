package Control;
import Modelo.Persona;
import Interface.PersonaInterfaz;
/*@author GRUPO*/
public class PersonaFactory implements PersonaInterfaz{
    @Override
    public Persona crearEntidad(int dcentidad, String rsoci, int CodCuen, 
            String email, int contacto, char[] pw, String tipoc) {
        return new Persona(dcentidad,rsoci, CodCuen, email, contacto, pw, tipoc);
    }
}
