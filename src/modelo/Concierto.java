/*
 * Entity for Concert
 */
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author mfontana
 */
public class Concierto {

    private int id;
    private String cantante;
    private String sala;
    private String ciudad;
    private int capacidad;
    private double precio;
    private int entradas;

    public Concierto() {
        cantante = "";
        sala = "";
        ciudad = "";
    }
    
    
    public int getEntradas() {
        return entradas;
    }

    public void setEntradas(int entradas) {
        int oldEntradas = this.entradas;
        this.entradas = entradas;
        propertyChangeSupport.firePropertyChange(PROP_ENTRADAS, oldEntradas, entradas);
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double price) {
        double oldPrecio = this.precio;
        this.precio = precio;
        propertyChangeSupport.firePropertyChange(PROP_PRECIO, oldPrecio, precio);
    }
    
    
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        int oldCapacidad = this.capacidad;
        this.capacidad = capacidad;
        propertyChangeSupport.firePropertyChange(PROP_CAPACIDAD, oldCapacidad, capacidad);
    }
    
    
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        String oldCiudad = this.ciudad;
        this.ciudad = ciudad;
        propertyChangeSupport.firePropertyChange(PROP_CIUDAD, oldCiudad, ciudad);
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
    
    
    
    
    
    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        String oldCantante = this.cantante;
        this.cantante = cantante;
        propertyChangeSupport.firePropertyChange(PROP_CANTANTE, oldCantante, cantante);
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange(PROP_ID, oldId, id);
    }
    
   
    
    @Override
    public String toString() {
        return cantante + " - " + ciudad;
    }
    
    
    

    public static final String PROP_ENTRADAS = "entradas";
    public static final String PROP_PRECIO = "precio";
    public static final String PROP_CAPACIDAD = "capacidad";
    public static final String PROP_CIUDAD = "ciudad";
    public static final String PROP_SALA = "sala";
    public static final String PROP_CANTANTE = "cantante";
    public static final String PROP_ID = "id";

    

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
