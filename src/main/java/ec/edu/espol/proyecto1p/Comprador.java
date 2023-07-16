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
    }
}