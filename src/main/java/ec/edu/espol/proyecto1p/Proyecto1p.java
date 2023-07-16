/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.proyecto1p;



import archivos.manejoArchivos;
import java.util.ArrayList;



public class Proyecto1p {
    
    public static ArrayList<Persona> vendedores = new ArrayList<>();
    public static ArrayList<Persona> compradores = new ArrayList<>();
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
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
    }
}
