/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.PyB.Clonar;

/**
 *
 * @author Dan
 */
public class Campania implements Clonar{
    private String idCampania;
    private String nombre;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private String estado;
    private String tipo;
    private int cantidad;
    
    @Override
    public Clonar clon() {
        return new Campania(this.idCampania,this.nombre, this.descripcion,
                this.fechaInicio, this.fechaFin, this.estado, this.tipo, 
                this.cantidad);
    }
    
    public Campania(String idCampania, String nombre, String descripcion, 
            String fechaInicio, String fechaFin, String estado, String tipo, 
            int cantidad) {
        this.idCampania = idCampania;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdCampania() {
        return idCampania;
    }

    public void setIdCampania(String idCampania) {
        this.idCampania = idCampania;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Campania{" + "idCampania=" + idCampania + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estado=" + estado + '}';
    }

}
