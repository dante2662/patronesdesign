/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.SisNotifi;

/**
 *
 * @author ElMataPollos
 */
public class NotificacionLoggerDecorator extends NotificacionDecorator {

    public NotificacionLoggerDecorator(SubSisNotifi decoratedNotifi) {
        super(decoratedNotifi);
    }

    @Override
    public void enviarNotificacion(String idEntidad, String mensaje) {
        super.enviarNotificacion(idEntidad, mensaje);
        registrarLog("Notificación enviada a entidad: " + idEntidad + " con mensaje: " + mensaje);
    }

    @Override
    public void obtenerNotificaciones(String idEntidad) {
        super.obtenerNotificaciones(idEntidad);
        registrarLog("Notificaciones obtenidas para la entidad: " + idEntidad);
    }

    private void registrarLog(String mensaje) {
        System.out.println("LOG: " + mensaje);
    }
}