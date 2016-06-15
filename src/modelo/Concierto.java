
package modelo;

import java.io.Serializable;

/**
 *
 * @author usu21
 */
public class Concierto implements Serializable {
    
    private String cantante;    
    private String recinto;   
    private String ciudad;    
    private int capacidad;
    private Cliente cliente;
    private double precio;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    

    
    public Concierto() {
        this.cantante = "";
        this.recinto = "";
        this.ciudad = "";
        this.cliente = new Cliente ();
    }

    
    
    
    public Concierto(String cantante, String recinto, String ciudad, int capacidad, Cliente cliente, double precio) {
        this.cantante = cantante;
        this.recinto = recinto;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
        this.cliente = cliente;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return cantante +  "" +  ciudad + "" + precio;
    }
    
    
    

    
    
 
    
    

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    


    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }


    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


    public String getRecinto() {
        return recinto;
    }

    public void setRecinto(String recinto) {
        this.recinto = recinto;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    
}
