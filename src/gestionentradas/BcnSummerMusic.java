
package gestionentradas;

import modelo.ListaClientes;
import modelo.ListaConciertos;
import utilidades.Fichero;
import vista.MenuPrincipal;

/**
 *
 * @author usu21
 */
public class BcnSummerMusic {

    /**
     * @param args the command line arguments
     */
    
    
    public static Fichero ficheroConciertos;
    public static ListaConciertos misConciertos;
    
    public static Fichero ficheroClientes;
    public static ListaClientes misClientes;
    
    
    public static void main(String[] args) {
        
        ficheroConciertos = new Fichero("conciertos.xml");
        misConciertos = (ListaConciertos) ficheroConciertos.leer();
        if (misConciertos == null) {
            misConciertos = new ListaConciertos();
        }
        
        ficheroClientes = new Fichero("clientes.xml");
        misClientes = (ListaClientes) ficheroClientes.leer();
        if (misClientes == null) {
            misClientes = new ListaClientes();
        }
        
        
        
        
        MenuPrincipal mp = new MenuPrincipal();
        //mp.setLocationRelativeTo(null);
        mp.setVisible(true);
    }
    
}
