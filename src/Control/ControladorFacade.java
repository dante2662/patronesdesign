package Control;

import Control.SisCampania.FactoryCampaniaImple;
import Control.SisDonacion.FactoryDonacionImple;
import Control.SisNotifi.FactoryNotifiImple;
import Control.SisUser.FactoryUserImple;
import Modelo.Donacion;
import Modelo.PyB.DonacionDTO;
import Modelo.PyB.UsuariosDTO;
import java.util.List;

/**@author GRUPO*/

public class ControladorFacade {
    
    //un factory en cada subsistema
    FactoryCampaniaImple camp;
    FactoryDonacionImple don;
    FactoryNotifiImple not;
    FactoryUserImple use;

    //un factory para todos los subsistemas
    FactorySubsistemas fac;
    
    public ControladorFacade() {
        //this.fac = new FactorySubsistemas();
        this.use = new FactoryUserImple();
        this.don = new FactoryDonacionImple();
    }    
    
    public void registrarUsuario(UsuariosDTO user,boolean a){
        //fac.llamadaUser(a).registrar(user);
        use.llamdaUser(a).registrar(user);
    }
    
    public void loguear(String di,String pass,boolean a){
        //fac.llamadaUser(a).logear(di, pass);
        use.llamdaUser(a).logear(di, pass);
    }
    
    public void actualizaruser(UsuariosDTO user,boolean a){
        //fac.llamadaUser(a).actualizar(user);
        use.llamdaUser(a).actualizar(user);
    }
    public void verperfil(UsuariosDTO user,boolean a){
        //fac.llamadaUser(a).verperfil();
        use.llamdaUser(a).verperfil();
    }
    
//    public void campaniacrear(){
//        
//    }
//    public void campanialistar(){
//        
//    }
    public void donacioncrear(DonacionDTO donacion, boolean a){
        //fac.llamadaDonacion(a).donar(donacion);
        //don.llamadaDonativo(a).donar(donacion);
        System.out.println("Creando el donativo");
        System.out.println(donacion.toString());
        System.out.println(".............");
    }
    public void donacionHistorial(String idEntidad, boolean a){
        //return fac.llamadaDonacion(a).obtenerHistorialDonaciones(idEntidad);
        //don.llamadaDonativo(a).obtenerHistorialDonaciones(idEntidad);
        System.out.println("Obteniendo lista de donaciones con respecto a la identidad: "+idEntidad);
    }
    public void donacioncancelar(String idDonacion, boolean a){
        //fac.llamadaDonacion(a).cancelarDonacion(idDonacion);
        //don.llamadaDonativo(a).cancelarDonacion(idDonacion);
        System.out.println("Cancelando donativo con la siguiente identidad: "+idDonacion);
    }
    public void donacionEstado(String idDonacion, boolean a){
        //fac.llamadaDonacion(a).obtenerEstadoDonativo(idDonacion);
//        don.llamadaDonativo(a).obtenerEstadoDonativo(idDonacion);
        System.out.println("Obteniendo estado de donacion de ID: "+idDonacion+"--> Estado: Completado");
    }
    public void donacionVerificar(String idDonacion, boolean a){
        //fac.llamadaDonacion(a).verificarDonativo(idDonacion);
//        don.llamadaDonativo(a).verificarDonativo(idDonacion);
        System.out.println("Verificando donativo...");
        System.out.println("El donativo ha sido registrado exitosamente...!!!");
    }
}