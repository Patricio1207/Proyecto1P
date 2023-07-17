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
public class Vendedor extends Persona{
    protected ArrayList<Vehiculo> vehiculos;
    
    public Vendedor(String nombres, String apellidos, String organizacion, String correo, String clave){
        super(nombres,apellidos,organizacion,correo,clave);
        this.vehiculos = new ArrayList<>();
    }
    public Vendedor(String correo, String clave) {
        super(correo, clave);
    }
    
    public static int menuVendedor() {
        int opcion;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ud se encuentra en el menu de vendedor");
        System.out.println("Porfavor ingrese una opcion");
        System.out.println("""
                           1. Registrar nuevo vendedor 
                           2. Registrar nuevo vehiculo
                           3. Aceptar Oferta
                           4. Regresar
                           """);

        opcion = entrada.nextInt();
        entrada.nextLine();

        return opcion;
    }
    //No se necesita un vendedor para registrar a uno
    //por lo tanto sera estatico
    public static void registrarVendedor(){
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
        //Hasheando la constraseña, se lo puede realizar antes de la verificacion
        cla = Utilidades.hash(cla);
        if (Persona.existUser(new Vendedor(noms, apell, org, cor, cla), Proyecto1p.vendedores)) {
            System.out.println("Lo siento, el usuario que ingreso, ya se encuentra registrado");
            return;
        }
        Proyecto1p.addVendedor(new Vendedor(noms, apell, org, cor, cla));
    }
    public void registrarVehiculo(){
        //Debe agregar un nuevo vehiculo
        Scanner entrada = new Scanner(System.in);
        Vehiculo vehiculo = null;
        //Pedir datos al usuario
        System.out.println("Que tipo de vehiculo ingresara");
        System.out.println("""
                                   1. auto
                                   2. Camioneta
                                   3. Moto
                                   """);
        int opcionVeh = entrada.nextInt();
        entrada.nextLine();
        while (opcionVeh > 3 || opcionVeh <= 0) {
            System.out.println("Acabar de ingresar una opcion que no se encuentra presente");
            System.out.println("Por favor intentelo de nuevo");
            opcionVeh = entrada.nextInt();
            entrada.nextLine();
        }

        System.out.println("Ingrese la placa: ");
        String placa = entrada.nextLine();

        System.out.println("Ingrese la marca");
        String marca = entrada.nextLine();

        System.out.println("Ingrese el modelo");
        String modelo = entrada.nextLine();

        System.out.println("Ingrese el tipo de motor");
        String tipoMotor = entrada.nextLine();

        System.out.println("Ingrese el Año");
        int año = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Ingrese Recorrido");
        double recorrido = entrada.nextDouble();
        entrada.nextLine();

        System.out.println("Ingrese el color: ");
        String color = entrada.nextLine();

        System.out.println("Ingrese el tipo de combustible");
        String tipoCombustible = entrada.nextLine();

        System.out.println("Ingrese el precio");
        double precio = entrada.nextDouble();
        entrada.nextLine();

        switch (opcionVeh) {
            case 1: {
                //auto
                System.out.println("Ingrese los vidrios ");
                String vidrios = entrada.nextLine();
                System.out.println("Ingrese tipo de transmision");
                String transmision = entrada.nextLine();
                vehiculo = new Auto(placa, marca, modelo, tipoMotor, año, recorrido, color, tipoCombustible, precio, vidrios, transmision);
                break;
            }
            case 2: {
                System.out.println("Ingrese los vidrios ");
                String vidrios = entrada.nextLine();
                System.out.println("Ingrese tipo de transmision");
                String transmision = entrada.nextLine();
                System.out.println("Ingrese tipo de traccion");
                String traccion = entrada.nextLine();
                vehiculo = new Camioneta(placa, marca, modelo, tipoMotor, año, recorrido, color, tipoCombustible, precio, vidrios, transmision, traccion);
                break;
            }
            case 3:
                vehiculo = new Motocicleta(placa, marca, modelo, tipoMotor, año, recorrido, color, tipoCombustible, precio);
                break;
        }
        if (vehiculo == null) {
            System.out.println("Ha existido un error");
            return;
        }

        if (Vehiculo.existVehiculo(vehiculo, Proyecto1p.vehiculos)) {
            System.out.println("El vehiculo, ya se encuentra en nustra base de datos");
            return;
        }

        //Crea el vehiculo
        vehiculo.addVehiculo();

        //Crear el registro
        Registro registro = new Registro(this, vehiculo);
        registro.add();

        System.out.println("El vehiculo ha sido registrado con exito\n\n");

    }
    public void aceptarOferta() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese la placa: ");
        String placa = entrada.nextLine();
        Vehiculo vehAsc = Vehiculo.getVehiculo(placa);
        
        if(vehAsc == null){
            System.out.println("No se pudo encotrar vehiculo con esa especificacion");
            return;
        }
        
        ArrayList<Oferta> ofertasVeh = new ArrayList<>();
        int contador = 0;
        //Se busca la oferta para ese vehiculo
        for (Oferta oferta : Proyecto1p.ofertas) {
            if (!oferta.getVehiculo().placa.equals(vehAsc.getPlaca())) {
                continue;
            }
            ofertasVeh.add(oferta);
            contador++;
        }

        System.out.println(vehAsc.getModelo() + " Precio: " + vehAsc.getPrecio());
        System.out.println("Se han realizaod " + contador + " ofertas");

        for (int i = 0; i < ofertasVeh.size(); i++) {
            if (!ofertasVeh.get(i).getVehiculo().placa.equals(vehAsc.getPlaca())) {
                continue;
            }
            System.out.println("Oferta " + (i + 1));
            System.out.println("Correo: " + ofertasVeh.get(i).getComprador().getCorreoElectronico());
            System.out.println("Precio Ofertado: " + ofertasVeh.get(i).getPrecio());

            System.out.println("""
                               1. Siguiente oferta
                               2. Anterior Oferta
                               3. Aceptar Oferta
                               4. Salir
                               """);
            int opc = entrada.nextInt();
            entrada.nextLine();

            while (opc > 4 || opc < 1) {

                System.out.println("La opcion que ingreso no se encuentra entre las opcion");

                System.out.println("""
                               1. Siguiente oferta
                               2. Anterior Oferta
                               3. Aceptar Oferta
                               4. Salir
                               """);
                opc = entrada.nextInt();
                entrada.nextLine();
            }

            if (i == 0) {
                while(opc == 2){
                    System.out.println("Ud se encuentra en el limite inferior de la lista");
                    System.out.println("""
                               1. Siguiente oferta
                               2. Anterior Oferta
                               3. Aceptar Oferta
                               4. Salir
                               """);
                    opc = entrada.nextInt();
                    entrada.nextLine();
                    
                }
            }
            if(i == ofertasVeh.size()-1){
                while(opc == 2){
                    System.out.println("Ud se encuentra en el limite superior de la lista");
                    System.out.println("""
                               1. Siguiente oferta
                               2. Anterior Oferta
                               3. Aceptar Oferta
                               4. Salir
                               """);
                    opc = entrada.nextInt();
                    entrada.nextLine();
                    
                }
               
            }
            if(opc == 1){
                continue;
            }else if(opc == 2){
                i-=2;
                continue;
            }
            if(opc == 3){
                Oferta ofer = ofertasVeh.get(i);
                
                //Se acepta la ofeta
                System.out.println("Como seguirdad ingrese su contraseña nuevamente");
                String password  = entrada.nextLine();
                
                if(!Utilidades.hash(password).equals(this.getClave())){
                    System.out.println("No se pudo validar sus credenciales");
                    return;
                }
                //Se envia un correo
                Utilidades.enviarConGMail(this.getCorreoElectronico(), password, ofer.getComprador().getCorreoElectronico(),
                        "Confirmacion de oferta", "Felicidades, el vendedor acaba de confirmar su oferta");
                
                //Eliminar el vehiculo
                
                //Elimina el vehiculo del sistema
                Vehiculo.removeVehiculo(ofer.getVehiculo());
                
                //Elimina todas las ofertas que hay
                Oferta.removeOfertas(ofertasVeh);
                
               
                System.out.println("Se ha aceptado la oferta con exito");
                return;
                
            }else if(opc == 4){
                return;
            }
        }
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    //Debido a que un vendedor sera igual a otro siempre y cuando
    //sus correos sean diferentes
    public String getNombres() {
        return nombres;
    }
}
