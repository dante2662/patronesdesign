/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package Modelo;

/**
 *
 * @author Dan
 */
public class Session {
    
    private static Session instancia;
    private Entidad usuario;
    private boolean autenticado;
    
    private Session() {
        this.autenticado = false;
    }
    
    public static Session getInstance() {
        if (instancia == null) {
            instancia = new Session();
        }
        return instancia;
    }
    
    public void login(Entidad ent){
        if(ent!=null){
            this.usuario =ent;
            this.autenticado = true;
        }
    }

    public Entidad getUsuario() {
        return usuario;
    }
    
    public String getTipoEntidad() {
        if (usuario instanceof Persona) {
            return "Persona";
        } else if (usuario instanceof Empresa) {
            return "Empresa";
        } else if (usuario instanceof Administrador) {
            return "Administrador";
        }
        return "Desconocido";
    }
    
    public String getID(){
        if(this.autenticado){
            return usuario.getIdEntidad();
        }
        return "";
    }
    
    public void logout(){
        this.usuario = null;
        this.autenticado = false;
    }
}
