/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.SisNotifi;

/**
 *
 * @author ElMataPollos
 */
public abstract class NotificacionDecorator implements SubSisNotifi {
    protected SubSisNotifi decoratedNotifi;

    public NotificacionDecorator(SubSisNotifi decoratedNotifi) {
        this.decoratedNotifi = decoratedNotifi;
    }

    @Override
    public void enviarNotificacion(String idEntidad, String mensaje) {
        decoratedNotifi.enviarNotificacion(idEntidad, mensaje);
    }

    @Override
    public void obtenerNotificaciones(String idEntidad) {
        decoratedNotifi.obtenerNotificaciones(idEntidad);
    }
}
