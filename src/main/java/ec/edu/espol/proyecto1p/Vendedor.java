/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1p;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Personal
 */
public class Vendedor extends Persona{
    protected ArrayList<Vehiculo> vehiculos;
    
    public Vendedor(String nombres, String apellidos, String organizacion, String correo, String clave){
        super(nombres,apellidos,organizacion,correo,clave);
        this.vehiculos = new ArrayList<>();
    }
    
    public Vendedor registrarVendedor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Se va a registrar un nuevo vendedor");
        System.out.println("Ingrese sus nombres");
        String noms = sc.nextLine();
        System.out.println("Ingrese sus apellidos");
        String apell = sc.nextLine();
        System.out.println("Ingrese la organizacion");
        String org = sc.nextLine();
        System.out.println("Ingrese el correo electrónico");
        String cor = sc.nextLine();
        System.out.println("Ingrese la clave");
        String cla = sc.nextLine();
        return new Vendedor(noms,apell,org,cor,cla);
        //Falta validar
        //Falta agregar al nuevo vendedor a la lista de vendedores
    }
    public void registrarVehiculo(){
        //Falta validar clave
        Scanner sc = new Scanner(System.in);
        System.out.println("Se va a registrar un nuevo vehiculo");
        System.out.println("Elija el tipo de vehiculo: \"Auto\" , \"Camioneta\", \"Motocicleta\"");
        String tipoVehiculo = sc.nextLine();
        System.out.println("Ingrese su placa");
        String placa = sc.nextLine();
        System.out.println("Ingrese la marca");
        String marca = sc.nextLine();
        System.out.println("Ingrese el modelo");
        String modelo = sc.nextLine();
        System.out.println("Ingrese el tipo de motor");
        String tipoMotor = sc.nextLine();
        System.out.println("Ingrese el año del vehiculo");
        int año = sc.nextInt();
        System.out.println("Ingrese el recorrido");
        double recorrido = sc.nextDouble();
        System.out.println("Ingrese el color");
        String color = sc.nextLine();
        System.out.println("Ingrese el tipo de combustible");
        String combustible = sc.nextLine();
       double precio = sc.nextDouble();
        if (tipoVehiculo.equals("Auto")){
            System.out.println("Ingrese el tipo de vidirios");
            String vidrios = sc.nextLine();
            System.out.println("Ingrese el tipo de transmisión");
            String transmision = sc.nextLine();
            Vehiculo v = new Auto(placa,marca,modelo,tipoMotor,año,recorrido,color,combustible,precio,vidrios,transmision);
        }
        if (tipoVehiculo.endsWith("Camioneta")){
            System.out.println("Ingrese el tipo de vidirios");
            String vidrios = sc.nextLine();
            System.out.println("Ingrese el tipo de transmisión");
            String transmision = sc.nextLine();
            System.out.println("Ingrese el tipo de tracción");
            String traccion = sc.nextLine();
            Vehiculo v = new Camioneta(placa,marca,modelo,tipoMotor,año,recorrido,color,combustible,precio,vidrios,transmision,traccion);
        }else{
            Vehiculo v = new Motocicleta(placa,marca,modelo,tipoMotor,año,recorrido,color,combustible,precio);
        }
        //Falta agregar vehiculo v a la lista de vehiculos disponibles
    }
    
    
}
