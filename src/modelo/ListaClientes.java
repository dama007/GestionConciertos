
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author usu21
 */
public class ListaClientes implements Serializable {
    
    private ArrayList<Cliente> lista;

    
    
    public ListaClientes() {
        lista = new ArrayList<>();
    }
    
    
    public void altaCliente(Cliente cl) {
        lista.add(cl);
    }
    
    
    public boolean existeCliente(Cliente cl) {
        return lista.contains(cl);
    }
    
    
    

    public ArrayList<Cliente> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Cliente> lista) {
        this.lista = lista;
    }
    
    

    
}
