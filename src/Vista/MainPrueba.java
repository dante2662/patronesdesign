package Vista;

import Modelo.PyB.UsuariosDTO;
import Control.*;
import Control.SisCampania.CampaniaLoggerDecorator;
import Control.SisCampania.SubSisCampania;
import Control.SisCampania.SubSisCampaniaImpl;
import Control.SisDonacion.DonacionLoggerDecorator;
import Control.SisDonacion.SubSisDonativos;
import Control.SisDonacion.SubSisDonativosImpl;
import Control.SisUser.SubSisUserImple;
import Modelo.*;
import Modelo.PyB.DonacionDTO;
import java.util.*;

/**@author Dan*/
public class MainPrueba {
    /**@param args the command line arguments*/
    public static void main(String[] args) {
        // Creación de una instancia del controlador Facade
        //que unifica las operaciones
        ControladorFacade facade = new ControladorFacade();

        // Creación de usuarios usando el patrón Builder
        UsuariosDTO user1 = new UsuariosDTO.Builder()
              .setDocumentoIdentidad("AB123456")
              .setPassword("pepelotas123321")
              .setEmail("Pepelotas1@example.com")
              .setNombre("Pepelotas")
              .setTelefono("555-1234")
              .build();

        UsuariosDTO user2 = new UsuariosDTO.Builder()
              .setDocumentoIdentidad("AB123222")
              .setPassword("pepelotas123321")
              .setEmail("kepelotas1@example.com")
              .build();

        UsuariosDTO user3 = new UsuariosDTO.Builder()
                .setDocumentoIdentidad("987654321")
                .setPassword("password456")
                .setEmail("empresa@example.com")
                .setTipoEmpresa("Tecnología")
                .setTelefono("555-5678")
                .setDireccion("Avenida Siempre Viva 742")
                .build();

        // Registro de usuarios en el subsistema "Usuario"
        facade.registrarUsuario(user1, true);
        facade.registrarUsuario(user2, true);
        facade.registrarUsuario(user3, true);

        // Logueo del usuario registrado
        facade.loguear("AB123456", "pepelotas123321", true);

        // Actualización y visualización del perfil de usuario
        UsuariosDTO useractualizado = new UsuariosDTO.Builder()
                .setNombre("kevin")
                .build();
        facade.actualizaruser(useractualizado, true);
        facade.verperfil(useractualizado, true);

        // Creación de una donación utilizando el patrón Builder
        DonacionDTO donacion1 = new DonacionDTO.Builder()
                .setIdDonacion("D123")
                .setMonto(150.00)
                .setTipo("Monetario")
                .setFecha("2024-10-14")
                .build();

        // Implementación del patrón Prototype para clonar la donación
        Donacion donacion2 = new Donacion(donacion1); //Conversión de DonacionDTO a Donacion
        Donacion clon1 = donacion2.clon();//Clonación de donación
        clon1.setMonto(200);//Modificación de la donación clonada
        clon1.setTipo("Alimento");

        // Mostrar la donación original y la clonada
        System.out.println("Donacion: " + donacion2.toString());
        System.out.println("Donacion clonada:  " + clon1.toString());

        // Registro de una nueva donación
        System.out.println("=== Registrando nueva donacion ===");
        facade.donacioncrear(donacion1, true);

        // Listar todas las donaciones registradas por el usuario
        System.out.println("=== Listando todas las donaciones ===");
        facade.donacionHistorial("AB123456", true);

        // Obtener el estado actual de la donación con ID "D123"
        System.out.println("=== Estado de la donación D123 ===");
        facade.donacionEstado("D123", true);

        // Cancelación de la donación
        System.out.println("=== Cancelando donación D123 ===");
        facade.donacioncancelar("D123", true);        
    }
}
