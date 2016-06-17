
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author usu21
 */
public class Concierto { 
    
    private int id;    
    private String cantante;    
    private String sala;    
    private String ciudad;   
    private int capacidad;    
    private double precio;    
    private int vendido;

    public Concierto() {
        this.cantante = "";
        this.sala = "";
        this.ciudad = "";
    }
    
    

    @Override
    public String toString() {
        return cantante + " - " + ciudad;
    }
    
     
    

    public static final String PROP_VENDIDO = "vendido";

    public int getVendido() {
        return vendido;
    }

    public void setVendido(int vendido) {
        int oldVendido = this.vendido;
        this.vendido = vendido;
        propertyChangeSupport.firePropertyChange(PROP_VENDIDO, oldVendido, vendido);
    }


    public static final String PROP_PRECIO = "precio";

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        double oldPrecio = this.precio;
        this.precio = precio;
        propertyChangeSupport.firePropertyChange(PROP_PRECIO, oldPrecio, precio);
    }


    public static final String PROP_CAPACIDAD = "capacidad";

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        int oldCapacidad = this.capacidad;
        this.capacidad = capacidad;
        propertyChangeSupport.firePropertyChange(PROP_CAPACIDAD, oldCapacidad, capacidad);
    }


    public static final String PROP_CIUDAD = "ciudad";

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        String oldCiudad = this.ciudad;
        this.ciudad = ciudad;
        propertyChangeSupport.firePropertyChange(PROP_CIUDAD, oldCiudad, ciudad);
    }


    public static final String PROP_SALA = "sala";

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        String oldSala = this.sala;
        this.sala = sala;
        propertyChangeSupport.firePropertyChange(PROP_SALA, oldSala, sala);
    }


    public static final String PROP_CANTANTE = "cantante";

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        String oldCantante = this.cantante;
        this.cantante = cantante;
        propertyChangeSupport.firePropertyChange(PROP_CANTANTE, oldCantante, cantante);
    }


    public static final String PROP_ID = "id";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange(PROP_ID, oldId, id);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
