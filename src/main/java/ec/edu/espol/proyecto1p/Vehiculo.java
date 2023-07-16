/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1p;

import java.util.ArrayList;

/**
 *
 * @author Personal
 */
public class Vehiculo {
    protected String placa;
    protected String marca;
    protected String modelo;
    protected String tipoMotor;
    protected int año;
    protected double recorrido;
    protected String color;
    protected String combustible;
    protected double precio;
    protected ArrayList<Oferta> ofertas;
    
    public Vehiculo(String placa, String marca, String modelo, String tipoMotor, int año, double recorrido, String color, String combustible, double precio){
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoMotor = tipoMotor;
        this.año = año;
        this.recorrido = recorrido;
        this.color = color;
        this.combustible = combustible;
        this.precio = precio;
    }
    
    public static Vehiculo getVehiculo(String placa) {
        for (Vehiculo vehi : Proyecto1p.vehiculos) {
            if (placa.equals(vehi.placa)) {
                return vehi;
            }
        }
        return null;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public int getAño() {
        return año;
    }

    public double getRecorrido() {
        return recorrido;
    }

    public String getColor() {
        return color;
    }

    public String getCombustible() {
        return combustible;
    }

    public double getPrecio() {
        return precio;
    }

    public ArrayList<Oferta> getOfertas() {
        return ofertas;
    }
    
}
