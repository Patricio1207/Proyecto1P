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
public class Persona {
    protected String nombres;
    protected String apellidos;
    protected String organizacion;
    protected String correoElectronico;
    protected String clave;
    
    public Persona(String nombres, String apellidos, String organizacion, String correo, String clave){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.organizacion = organizacion;
        this.correoElectronico = correo;
        this.clave = clave;
    }
    public boolean validarClave(String correo, String clave){
        //Falta codigo
        return true;
    }
    public boolean validarCorreo(String correo,ArrayList<Vendedor> vendedores){
        for (Vendedor v: vendedores){
            if(correo.toLowerCase().equals(v.correoElectronico.toLowerCase())){
                return false;
            }
        }
        return true;
    }
}
