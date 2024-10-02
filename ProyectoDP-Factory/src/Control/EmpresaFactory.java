package Control;

import Modelo.Empresa;
import Interface.EmpresaInterfaz;

/*@author GRUPO*/
public class EmpresaFactory implements EmpresaInterfaz{
    @Override
    public Empresa crearEntidad(int dcentidad, String rsoci, int CodCuen
            , String direccion, int contacto, char[] pw, String tipoc) 
    { return new Empresa(dcentidad, rsoci, CodCuen
            , direccion, contacto, pw, tipoc);
    }
       
}
