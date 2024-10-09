/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Vista;

import Clases.DTO.UsuariosDTO;
import Clases.Persona;
import Control.ControladorFacade;
import Control.CrearUser.FactoryCrearUser;
import Modelo.Conexion.Conexion;
import Modelo.FactoryImpleDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Dan
 */
public class MainPrueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        FactoryImpleDAO dao = new FactoryImpleDAO(Conexion.getInstancia().getConexion());
//        Persona per = new Persona();
//
//        per.setDocumentoIdentidad("1234567");
//        per.setPassword("Password"); 
//        per.setEmail("persona@exple.com");
//        per.setNombre("Nombre Completo");
//        per.setTelefono("1234567890");
//        dao.llamadaImplePerson().crear(per);
//        
//       Persona personaecontrado= dao.llamadaImplePerson().buscarPorId("24P678p");
//        System.out.println(""+personaecontrado);
//        
//        dao.llamadaImplePerson().eliminar("24P678p");
        
//        Persona per2 = new Persona();
//
//        per2.setDocumentoIdentidad("12345");
//        per2.setPassword("Password"); 
//        per2.setEmail("peona@example.com");
//        per2.setNombre("Nombre Completo");
//        per2.setTelefono("1234567890");
//        dao.llamadaImplePerson().crear(per2);
        
        
//        List<Persona> lista =  dao.llamadaImplePerson().listar();
//        
//        for (Persona persona : lista) {
//            System.out.println("Nombre: " + persona.toString());
//        }
//
//          FactoryCrearUser crear = new FactoryCrearUser();
//          
          UsuariosDTO user1 = new UsuariosDTO.Builder()
                .setDocumentoIdentidad("AB123456")
                .setPassword("pepelotas123321")
                .setEmail("Pepelotas1@example.com")
                .setNombre("Pepelotas")
                .setTelefono("555-1234")
                .build();
//        
          UsuariosDTO user2 = new UsuariosDTO.Builder()
                .setDocumentoIdentidad("AB123222")
                .setPassword("pepelotas123321")
                .setEmail("kepelotas1@example.com")
                .setNombre("kkkkk")
                .setTelefono("555-12322")
                .build();
//        
//          Persona per =crear.llamarimpleperson().crear(user1);

//          
            ControladorFacade cfc = new ControladorFacade();
            cfc.registrarUsuario(user1);

            cfc.registrarUsuario(user2);


    }
}
