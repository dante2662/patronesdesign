/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAOs;

/**
 *
 * @author Dan
 */
public class CuentaBanco {
    private int idCuenta;        // Identificador único para la cuenta
    private int idEntidad;       // Relación con la entidad
    private String numC;         // Número de cuenta
    private int cvc;             // Código de seguridad
    private int fV;              // Fecha de vencimiento (en formato MMYY)
    private String tipoCuenta;    // Tipo de cuenta (Bancaria o Tarjeta de Crédito)

    // Constructor
    public CuentaBanco(int idCuenta, int idEntidad, String numC, int cvc, int fV, String tipoCuenta) {
        this.idCuenta = idCuenta;
        this.idEntidad = idEntidad;
        this.numC = numC;
        this.cvc = cvc;
        this.fV = fV;
        this.tipoCuenta = tipoCuenta;
    }

    // Getters y Setters
    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getNumC() {
        return numC;
    }

    public void setNumC(String numC) {
        this.numC = numC;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public int getFV() {
        return fV;
    }

    public void setFV(int fV) {
        this.fV = fV;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "idCuenta=" + idCuenta +
                ", idEntidad=" + idEntidad +
                ", numC='" + numC + '\'' +
                ", cvc=" + cvc +
                ", fV=" + fV +
                ", tipoCuenta='" + tipoCuenta + '\'' +
                '}';
    }
}
