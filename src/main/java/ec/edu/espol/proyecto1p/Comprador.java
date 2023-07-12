/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1p;

import java.util.Scanner;

/**
 *
 * @author Personal
 */
public class Comprador extends Persona{
    
    public Comprador(String nombres, String apellidos, String organizacion, String correo, String clave){
        super(nombres,apellidos,organizacion,correo,clave);   
    }
    public void registrarComprador(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Se va a registrar un nuevo comprador");
        System.out.println("Ingrese sus nombres");
        String nombres = sc.nextLine();
        System.out.println("Ingrese sus apellidos");
        String apellidos = sc.nextLine();
        System.out.println("Ingrese la organizacion");
        String organizacion = sc.nextLine();
        System.out.println("Ingrese el correo electrónico");
        String correo = sc.nextLine();
        System.out.println("Ingrese la clave");
        String clave = sc.nextLine();
        Comprador c = new Comprador(nombres,apellidos,organizacion,correo,clave);
        //Falta la clave en hash
        //Falta validar
        //Falta agregar al nuevo comprador c a la lista de compradores
    }
    public Vehiculo buscarVehiculo(String tipo){
        return null;
    }
    public void hacerOferta(Vehiculo v){
        
    }
}
