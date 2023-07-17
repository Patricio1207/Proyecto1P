/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1p;

import archivos.Utilidades;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Personal
 */
public class Comprador extends Persona {

    public Comprador(String nombres, String apellidos, String organizacion, String correo, String clave) {
        super(nombres, apellidos, organizacion, correo, clave);
    }

    public Comprador(String correoElectronico, String clave) {
        super(correoElectronico, clave);
    }

    public static int menuComprador() {
        int opcion;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ud se encuentra en el menu de comprador");
        System.out.println("Porfavor ingrese una opcion");
        System.out.println("""
                           1. Registrar nuevo Comprador 
                           2. Ofertar por un vehiculo
                           3. Regresar
                           """);

        opcion = entrada.nextInt();
        entrada.nextLine();

        return opcion;
    }

    public static void registrarComprador() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Se va a registrar un nuevo comprador");
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

        //Hasheando la constraseña, se lo puede realizar antes de la verificacion
        cla = Utilidades.hash(cla);
        if (Persona.existUser(new Comprador(noms, apell, org, cor, cla), Proyecto1p.compradores)) {
            System.out.println("Lo siento, el usuario que ingreso, ya se encuentra registrado");
            return;
        }
        
    }

    public void mostrarVehiculos() {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Vehiculo> vehic = new ArrayList<>();
        //Primero se deben filtrar los datos
        System.out.println("Buscar Vehiculos");
        System.out.println("Ingrese el tipo de vehiculo");
        String tipo = entrada.nextLine();

        System.out.println("Ingrese un recorrido");
        System.out.println("Limite inferirior ");
        double inicial = entrada.nextDouble();
        entrada.nextLine();
        System.out.println("Limite superior");
        double sup = entrada.nextDouble();
        entrada.nextLine();

        System.out.println("Ingrese un año");
        System.out.println("Limite inferirior ");
        int inicialA = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Limite superior");
        int supA = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Ingrese un precio");
        System.out.println("Limite inferirior ");
        inicial = entrada.nextDouble();
        entrada.nextLine();
        System.out.println("Limite superior");
        sup = entrada.nextDouble();
        entrada.nextLine();

        System.out.println("""
                           -----------------------------------------------------
                                              VEHICULOS
                           -----------------------------------------------------
                           """);
        //Mostrar al usuario
        for (int i = 0; i < vehic.size(); i++) {
            System.out.println("Vehiculo" + (i + 1));
            String tipoVeh = "";
            if (vehic.get(i).getTipo().equals("A")) {
                tipoVeh = "Auto";
            } else if (vehic.get(i).getTipo().equals("C")) {
                tipoVeh = "Camioneta";
            } else {
                tipoVeh = "Moto";
            }

            System.out.println("placa: " + vehic.get(i).getPlaca()
                    + "\nModelo: " + vehic.get(i).getModelo()
                    + "\nAño: " + vehic.get(i).getAño()
                    + "\nRecordido: " + vehic.get(i).getRecorrido()
                    + "\nPrecio: " + vehic.get(i).getPrecio()
                    + "\nModelo: " + vehic.get(i).getModelo()
                    + "\nTipo: " + tipo);

            System.out.println("\nOpciones");

            System.out.println("""
                                   1. Retroceder
                                   2. Avanzar
                                   3. Ofertar
                                   4. Salir
                                   """);
            
            int opc = entrada.nextInt();
            entrada.nextLine();
            
            while(opc > 5 || opc <= 0){
                    System.out.println("Ingrese una opcion veridica");
                    System.out.println("""
                                   1. Retroceder
                                   2. Avanzar
                                   3. Ofertar
                                   4. Salir
                                   """);
            
                    opc = entrada.nextInt();
                    entrada.nextLine();
            }
            
            if(i == 0){
                while(opc == 1){
                    System.out.println("Lo siento ud se encuentra en el limte inferior de la lista");
                    System.out.println("""
                                   1. Retroceder
                                   2. Avanzar
                                   3. Ofertar
                                   4. Salir
                                   """);
            
                    opc = entrada.nextInt();
                    entrada.nextLine();
                }
              
            }
            if(i == vehic.size()-1){
                while(opc == 2){
                    System.out.println("Lo siento ud se encuentra en el limte superior de la lista");
                    System.out.println("""
                                   1. Retroceder
                                   2. Avanzar
                                   3. Ofertar
                                   4. Salir
                                   """);
            
                    opc = entrada.nextInt();
                    entrada.nextLine();
                }
                
            }
            
            if(opc == 1){
                i -=2;
                continue;
            }else if(opc ==2){
                continue;
            }
            if(opc == 3){
                //El usuario va a oferta
                System.out.println("Indique su precio: ");
                double precio = entrada.nextDouble();
                
                //se registra la oferta
                Oferta oferta = new Oferta(this, precio, vehic.get(i));
                oferta.add(); //Se añade la oferta al sistema
                
                System.out.println("La oferta se realizo con exito");
            }
            if(opc == 4){
                return;
            }
            
        }

    }
}