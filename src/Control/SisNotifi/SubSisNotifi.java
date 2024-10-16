/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Control.SisNotifi;

/**
 *
 * @author Dan
 */
public interface SubSisNotifi {
    void enviarNotificacion(String idEntidad, String mensaje);
    void obtenerNotificaciones(String idEntidad);
    
}
