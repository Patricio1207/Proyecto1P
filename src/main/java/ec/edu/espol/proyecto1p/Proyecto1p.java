/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.proyecto1p;



import archivos.Utilidades;
import archivos.manejoArchivos;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *  Esta es la calse principal, permitara arrancar el sistema
 *  asi como es el encargado de leer todos los ficheros guardados
 * @author Patricio Vásquez
 */
public class Proyecto1p {
    
    public static ArrayList<Persona> vendedores = new ArrayList<>();
    public static ArrayList<Persona> compradores = new ArrayList<>();
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    public static ArrayList<Registro> registro = new ArrayList<>();
    public static ArrayList<Oferta> ofertas = new ArrayList<>();


    public Proyecto1p(){
        //Leera los archivos y los cargara al sistema
        
        //agregar vendedores
        ArrayList<String[]> data = manejoArchivos.LeerValidando("vendedores.txt", false);
        for(String[] linea: data){
            vendedores.add(new Vendedor(linea[0], linea[1], linea[2], linea[3], linea[4]));
        }
        
        
        //agregar compradores
        data = manejoArchivos.LeerValidando("comprador.txt", false);
        for(String[] linea: data){
            compradores.add(new Comprador(linea[0], linea[1], linea[2], linea[3], linea[4]));
        }
        
        //Agregar vehiculos
        data = manejoArchivos.LeerValidando("vehiculos.txt", false);
        for(String[] linea: data){
            if(linea[0].equals("A")){
                vehiculos.add(new Auto(linea[1], linea[2], linea[3], linea[4],
                        Integer.parseInt(linea[5]), Double.parseDouble(linea[6]),
                        linea[7], linea[8], Double.parseDouble(linea[9]), linea[10], linea[11]));
            }else if(linea[0].equals("M")){
                vehiculos.add(new Motocicleta(linea[1], linea[2], linea[3], linea[4],
                        Integer.parseInt(linea[5]), Double.parseDouble(linea[6]), linea[7], linea[8], Double.parseDouble(linea[9])));
            }else{
                vehiculos.add(new Camioneta(linea[1], linea[2], linea[3], linea[4],
                        Integer.parseInt(linea[5]), Double.parseDouble(linea[6]), linea[7], linea[8],
                        Double.parseDouble(linea[9]), linea[10], linea[11], linea[12]));
            }
        }
        //Agregagar los registros
        data = manejoArchivos.LeerValidando("regsitro.txt", false);
        for(String[] linea: data){
            String correo = linea[2];
            String placa = linea[3];
            
            //Debido a que es un registro sera un vendedor
            Vendedor usuario = (Vendedor) Persona.getPersona(correo, "V");
            Vehiculo vehiculo = Vehiculo.getVehiculo(placa);
            
            registro.add(new Registro(usuario, vehiculo));
        }
        
        //Agregagar las oferta
        data = manejoArchivos.LeerValidando("ofertas.txt", false);
        for(String[] linea: data){
            String correo = linea[2];
            String placa = linea[3];
            
            //Debido a que es un registro sera un vendedor
            Comprador usuario = (Comprador) Persona.getPersona(correo, "C");
            Vehiculo vehiculo = Vehiculo.getVehiculo(placa);
            
            ofertas.add(new Oferta(usuario, Double.parseDouble(linea[4]), vehiculo));
        }
    }
    /**
     * Este metodo se encarga de agregar el vendedor al sistma, es decir
     * actualizara todo elemento relacionado a el, asi como tambien actualizara
     * el fichero que contiene a todos estos usuarios
     * @param vendedor
     */
    public static void addVendedor(Vendedor vendedor){
        vendedores.add(vendedor);
        manejoArchivos.EscribirArchivo("vendedores.txt", vendedor.toString());
    }
    public static void addComprador(Comprador comprador){
        compradores.add(comprador);
        manejoArchivos.EscribirArchivo("comprador.txt", comprador.toString());
    }
    
    public static void addRegistro(Registro reg){
        registro.add(reg);
        manejoArchivos.EscribirArchivo("regsitro.txt", reg.toString());
    }
    public static void addVehiculo(Vehiculo veh){
        vehiculos.add(veh);
        manejoArchivos.EscribirArchivo("vehiculos.txt", veh.toString());
    }

    public static void addOferta(Oferta oferta){
        ofertas.add(oferta);
        manejoArchivos.EscribirArchivo("ofertas.txt", oferta.toString());
    }
    
    
    public static void remove(String ruta, int indice){
        manejoArchivos.EliminarLinea(ruta, indice+1);
        
    }
    
    private int menuPrincipal(){
        int opcion;
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingrese la opcion que mas desee");
        System.out.println("1. Vendedor\n2. Comprador \n3. Salir");
        
        opcion = entrada.nextInt();
        entrada.nextLine();
  
        return opcion;
    }
    
    private void initVendedor(){
        Scanner entrada = new Scanner(System.in);
        
        int opcion = Vendedor.menuVendedor();
        while(opcion > 4 || opcion <= 0){
            System.out.println("Acabar de ingresar una opcion que no se encuentra presente");
            System.out.println("Por favor intentelo de nuevo");
            opcion = Vendedor.menuVendedor();
        }
        
        switch(opcion){
            case 1:
                Vendedor.registrarVendedor();
                initVendedor();
                break;
            case 2:
                // Se inicia sesion
                System.out.println("Ingrese su correo: ");
                String correo = entrada.nextLine();
                System.out.println("Ingrese su contraseña: ");
                String password = entrada.nextLine();
                password = Utilidades.hash(password);
                Vendedor vendInput = new Vendedor(correo, password);
                Vendedor vendedor = (Vendedor) vendInput.login();
                if(vendedor == null){
                    initVendedor();
                    return;
                }
                 //Vendedor ya verficado
                
                vendedor.registrarVehiculo();
                initVendedor();
                break; 
                
            case 3:
                System.out.println("Ingrese su correo: ");
                correo = entrada.nextLine();
                System.out.println("Ingrese su contraseña: ");
                password = entrada.nextLine();
                password = Utilidades.hash(password);
                vendInput = new Vendedor(correo, password);
                vendedor = (Vendedor) vendInput.login();
                if(vendedor == null){
                    initVendedor();
                    return;
                }
                 //Vendedor ya verficado
                
                vendedor.aceptarOferta();
                initVendedor();
                break;
            case 4:
                initSistema();
        }
        
    }
    
    private void initComprador(){
        Scanner entrada = new Scanner(System.in);
        
        int opcion = Comprador.menuComprador();
        while(opcion > 3 || opcion <= 0){
            System.out.println("Acabar de ingresar una opcion que no se encuentra presente");
            System.out.println("Por favor intentelo de nuevo");
            opcion = Comprador.menuComprador();
        }
        
        switch(opcion){
            case 1:
                Comprador.registrarComprador();
                initComprador();
                break;
            case 2:
                // Se inicia sesion
                System.out.println("Ingrese su correo: ");
                String correo = entrada.nextLine();
                System.out.println("Ingrese su contraseña: ");
                String password = entrada.nextLine();
                password = Utilidades.hash(password);
                Comprador compInput = new Comprador(correo, password);
                Comprador comprador = (Comprador) compInput.login();
                if(comprador == null){
                    initComprador();
                    return;
                }
                 //comprador ya verficado
                
                comprador.mostrarVehiculos();
                
                
                initComprador();
                break; 
                
            case 3:
                initSistema();
        }
    }
    
    public void initSistema(){
        //Se cargaran los datos de los archivos
        
        //Llamada al menu
        int opcion = menuPrincipal();
        while(opcion > 3 || opcion <= 0){
            System.out.println("Acabar de ingresar una opcion que no se encuentra presente");
            System.out.println("Por favor intentelo de nuevo");
            opcion = menuPrincipal();
        }
        
        switch(opcion){
            case 1:
                initVendedor();
                break;
            case 2:
                initComprador();
                break;
                
            case 3:
                System.out.println("Programa finalizado");
                //System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        Proyecto1p sistema = new Proyecto1p();
        System.out.println("Bienvenido");
        sistema.initSistema();

        
    }
}
