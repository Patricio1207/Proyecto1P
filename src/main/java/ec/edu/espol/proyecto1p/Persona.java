/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1p;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Personal
 */

public abstract class Persona {
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

    /**
     * Constructor util para los datos que ingrese al usuario y luego 
     * verificarlo
     * @param correoElectronico
     * @param clave 
     */
    public Persona(String correoElectronico, String clave) {
        this.correoElectronico = correoElectronico;
        this.clave = clave;
    }
    
    
    public Persona login(){
        //Verificar que el usuario exista
        ArrayList<Persona> usuarios;
        String tipo;
        if(this instanceof Vendedor){
            usuarios = Proyecto1p.vendedores;
            tipo = "V";
        }else{
            usuarios = Proyecto1p.compradores;
            tipo = "C";
        }
        
        if(!Persona.existUser(this, usuarios)){
            System.out.println("Lo siento, el usuario que ha ingresado no se encuentra registrado");
            return null;
        }
        //Verificar que la constraseña sea correcta
        if(this.clave.equals(getPersona(this.correoElectronico, tipo).clave)){
            System.out.println("Login exitoso");
            return getPersona(this.correoElectronico, tipo);
        }
        System.out.println("Lo siento, credenciales incorrectas");
        return null;
    }
    
    /**
     * Obtiene los datos completos de una persona
     * dependiendo del tipo que se le envie
     * V vendedor
     * C comprador
     * @param correo
     * @param tipo
     * @return 
     */
    public static Persona getPersona(String correo, String tipo){
        ArrayList<Persona> usuarios;
        if(tipo.equals("V")){
            usuarios = Proyecto1p.vendedores;
        }else{
            usuarios = Proyecto1p.compradores;
        }
        
        
        for(Persona usuario: usuarios){
            if(usuario.correoElectronico.equals(correo)){
                return usuario;
            }
        }
        return null;
    }
    
    /**
     * Este metodo verifica si una persona ya se encuentra registrado
     * @param usuario
     * @param usuarios
     * @return 
     */
    public static boolean existUser(Persona usuario, ArrayList<Persona> usuarios){
        for(Persona persona: usuarios){
            if(persona.equals(usuario)){
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return Objects.equals(this.correoElectronico, other.correoElectronico);
    }

    @Override
    public String toString() {
        return nombres + "," + apellidos + "," + organizacion + "," + correoElectronico + "," + clave;
    }

    public String getNombres() {
        return nombres;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getClave() {
        return clave;
    }
    
    
    
    
}