
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


/**
 *
 * @author usu21
 */
public class Cliente { 
    
    private String nif;    
    private String nombre;    
    private String apellidos;

    
    
    public Cliente() {
        nif = "";
        nombre = "";
        apellidos = "";
    }

    @Override
    public String toString() {
        return nombre + " - " + apellidos;
    }
    
    
    
    

    public static final String PROP_APELLIDOS = "apellidos";

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        String oldApellidos = this.apellidos;
        this.apellidos = apellidos;
        propertyChangeSupport.firePropertyChange(PROP_APELLIDOS, oldApellidos, apellidos);
    }


    public static final String PROP_NOMBRE = "nombre";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        propertyChangeSupport.firePropertyChange(PROP_NOMBRE, oldNombre, nombre);
    }


    public static final String PROP_NIF = "nif";

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        String oldNif = this.nif;
        this.nif = nif;
        propertyChangeSupport.firePropertyChange(PROP_NIF, oldNif, nif);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
