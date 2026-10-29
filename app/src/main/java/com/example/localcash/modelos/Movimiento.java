package com.example.localcash.modelos;

public class Movimiento {
    private int id;
    private int idCuenta;
    private String tipo;
    private double monto;
    private double latitud;
    private double longitud;

    public Movimiento(int id, int idCuenta, String tipo, double monto, double latitud, double longitud) {
        this.id = id;
        this.idCuenta = idCuenta;
        this.tipo = tipo;
        this.monto = monto;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdCuenta() { return idCuenta; }
    public void setIdCuenta(int idCuenta) { this.idCuenta = idCuenta; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }
    public double getLatitud() { return latitud; }
    public void setLatitud(double latitud) { this.latitud = latitud; }
    public double getLongitud() { return longitud; }
    public void setLongitud(double longitud) { this.longitud = longitud; }
}