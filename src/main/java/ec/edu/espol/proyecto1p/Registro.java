/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto1p;

/**
 *
 * @author Personal
 */
public class Registro {
    private Vendedor vendedor;
    private Vehiculo vehiculo;
    private int codRegistro;
    private static int cod = 0;
    
    public Registro(Vendedor vendedor, Vehiculo vehiculo) {
        this.vendedor = vendedor;
        this.vehiculo = vehiculo;
        codRegistro = ++cod;
    }
    
    /**
     * Ingresa el nuevo registro al sistema
     * y llama al sistema para guardarlo en el fichero
     */
    public void add(){
        Proyecto1p.addRegistro(this);
    }

    @Override
    public String toString() {
        return codRegistro + "," + vendedor.getNombres() + "," +vendedor.getCorreoElectronico()
                + "," + vehiculo.getPlaca();
    }
}
