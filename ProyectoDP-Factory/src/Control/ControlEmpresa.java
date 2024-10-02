package Control;

import Interface.EmpresaInterfaz;
import Modelo.*;

public class ControlEmpresa {
   public void CrearEmpresa(int dcentidad, 
           String rsoci, int CodCuen
            , String direccion, int contacto,
            char[] pw, String tipoc){
      EmpresaInterfaz fa = new EmpresaFactory();
      Empresa e1= fa.crearEntidad(dcentidad, rsoci, CodCuen
            , direccion, contacto, pw, tipoc);   
      GestionBD.SubirEmpresa(e1);
  }   
}
