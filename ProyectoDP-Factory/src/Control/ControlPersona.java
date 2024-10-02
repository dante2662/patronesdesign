package Control;
import Interface.PersonaInterfaz;
import Modelo.GestionBD;
import Modelo.Persona;
public class ControlPersona {
  public void CrearPersona(int dcentidad, String rsoci, int CodCuen
            , String direccion, int contacto, char[] pw, String tipoc){
      PersonaInterfaz fa = new PersonaFactory();
      Persona pe1= fa.crearEntidad(dcentidad, rsoci, CodCuen
            , direccion, contacto, pw, tipoc);   
      GestionBD.SubirPersona(pe1);
  }  
}
