
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author usu21
 */
public class ListaConciertos implements Serializable {
    
    private ArrayList<Concierto> lista;

    
    
    public ListaConciertos() {
        lista = new ArrayList<>();
    }
    
    
    public void altaConcierto(Concierto c) {
        lista.add(c);   
    }
    
    
    public boolean existeConcierto(Concierto c) {
        return lista.contains(c);
    }
    
    
    
    

    public ArrayList<Concierto> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Concierto> lista) {
        this.lista = lista;
    }
    
   
//    public ListaConciertos clientePorConcierto(Cliente cliente) {
//        ListaConciertos lc = new ListaConciertos();
//        for(Concierto actual : lista) {
//            if (cliente.equals(actual.getCliente())) {
//                cliente.getNif(actual);
//            }
//        }
//        return cliente;
//    }       
    

    
    
    
    

    
}
