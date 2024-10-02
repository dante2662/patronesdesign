package Interface;
import Modelo.Persona;
/*@author GRUPO*/
public interface PersonaInterfaz {
    Persona crearEntidad(int dcentidad, String rsoci, int CodCuen, String email, int contacto, char[] pw, String tipoc);
}
