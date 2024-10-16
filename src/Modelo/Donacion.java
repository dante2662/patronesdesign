package Modelo;

import Modelo.PyB.Clonar;
import Modelo.PyB.DonacionDTO;

/**@author Dan*/
public class Donacion implements Clonar{
    private String idDonacion;
    private String idcampania;
    private double monto;
    private String fecha;
    private String estado;
    private String tipo;
    
    // Constructor que acepta un DonacionDTO
    public Donacion(DonacionDTO dto) {
        this.idDonacion = dto.getIdDonacion();
        this.idcampania = dto.getIdcampania();
        this.monto = dto.getMonto();
        this.fecha = dto.getFecha();
        this.estado = dto.getEstado();
        this.tipo = dto.getTipo();
    }
    @Override
    public Donacion clon(){
        return new Donacion(this.idDonacion, this.idcampania, 
                this.monto, this.fecha, this.estado, tipo);
    }
    
    public Donacion(String idDonacion, String idcampania, double monto
            , String fecha, String estado, String tipo) {
        this.idDonacion = idDonacion;
        this.idcampania = idcampania;
        this.monto = monto;
        this.fecha = fecha;
        this.estado = estado;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
 
    public String getIdDonacion() {
        return idDonacion;
    }

    public void setIdDonacion(String idDonacion) {
        this.idDonacion = idDonacion;
    }

    public void setIdcampania(String idcampania) {
        this.idcampania = idcampania;
    }

    public String getIdcampania() {
        return idcampania;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Donacion{" + "idDonacion=" + idDonacion + ", idcampania=" + idcampania + ", monto=" + monto + ", fecha=" + fecha + ", estado=" + estado + ", tipo=" + tipo + '}';
    }

}
