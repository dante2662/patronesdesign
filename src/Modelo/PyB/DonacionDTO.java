/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.PyB;

/**
 *
 * @author Dan
 */
public class DonacionDTO {
    private String idDonacion;
    private String idcampania;
    private double monto;
    private String fecha;
    private String estado;
    private String tipo;

    private DonacionDTO(Builder builder) {
        this.idDonacion = builder.idDonacion;
        this.idcampania = builder.idcampania;
        this.monto = builder.monto;
        this.fecha = builder.fecha;
        this.estado = builder.estado;
        this.tipo = builder.tipo;
    }
    public static class Builder {
        private String idDonacion;
        private String idcampania;
        private double monto;
        private String fecha;
        private String estado;
        private String tipo;

        public Builder setIdDonacion(String idDonacion) {
            this.idDonacion = idDonacion;
            return this;
        }

        public Builder setIdcampania(String idcampania) {
            this.idcampania = idcampania;
            return this;
        }

        public Builder setMonto(double monto) {
            this.monto = monto;
            return this;
        }

        public Builder setFecha(String fecha) {
            this.fecha = fecha;
            return this;
        }

        public Builder setEstado(String estado) {
            this.estado = estado;
            return this;
        }

        public Builder setTipo(String tipo) {
            this.tipo = tipo;
            return this;
        }

        public DonacionDTO build() {
            return new DonacionDTO(this);
        }
    }
    // Getters (opcional)
    public String getIdDonacion() { return idDonacion; }
    public String getIdcampania() { return idcampania; }
    public double getMonto() { return monto; }
    public String getFecha() { return fecha; }
    public String getEstado() { return estado; }
    public String getTipo() { return tipo; }

    @Override
    public String toString() {
        return "DonacionDTO{" + "idDonacion=" + idDonacion + ", idcampania=" + idcampania + ", monto=" + monto + ", fecha=" + fecha + ", estado=" + estado + ", tipo=" + tipo + '}';
    }
    
    
}
