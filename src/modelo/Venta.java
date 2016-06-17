
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author kinky
 */
public class Venta {
    
    private int num;    
    private Concierto concierto;    
    private Cliente cliente;

    
    
    public Venta() {
        concierto = new Concierto();
        cliente = new Cliente();   
    }
    
    
    
    public static final String PROP_CLIENTE = "cliente";

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        Cliente oldCliente = this.cliente;
        this.cliente = cliente;
        propertyChangeSupport.firePropertyChange(PROP_CLIENTE, oldCliente, cliente);
    }


    public static final String PROP_CONCIERTO = "concierto";

    public Concierto getConcierto() {
        return concierto;
    }

    public void setConcierto(Concierto concierto) {
        Concierto oldConcierto = this.concierto;
        this.concierto = concierto;
        propertyChangeSupport.firePropertyChange(PROP_CONCIERTO, oldConcierto, concierto);
    }


    public static final String PROP_NUM = "num";

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        int oldNum = this.num;
        this.num = num;
        propertyChangeSupport.firePropertyChange(PROP_NUM, oldNum, num);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
}
