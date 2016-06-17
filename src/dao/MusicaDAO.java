
package dao;

import excepciones.MiExcepcion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;



/**
 *
 * @author kinky
 */
public class MusicaDAO {
    
    private Connection connection;
    
    
    public void insertarClient(Cliente c) throws MiExcepcion {
        
            existeCliente(c);
            conectar();
            try {
            String insert = "insert into cliente values (?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1, c.getNif());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellidos());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            throw new MiExcepcion("Error al insertar " + ex.getLocalizedMessage());
        } finally {
                desconectar();
            }
    }
    
    
    private void existeCliente(Cliente c) throws MiExcepcion {
        
            conectar();
            try {
            String query = "select * from cliente where nif='" + c.getNif() + "';";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                throw new MiExcepcion("Ya existe un cliente con ese NIF");
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            throw new MiExcepcion("ERROR al consultar " + ex.getLocalizedMessage());
        } finally {
                desconectar();
            }
    }
    
    
    private void conectar() throws MiExcepcion {
       
            String url = "jdbc:mysql://localhost:3306/uf1290";
            String user = "root";
            String pass = "";
            try {
                connection = DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
                throw new MiExcepcion("Error al conectar" + ex.getLocalizedMessage());
        }
    }
    
    
    private void desconectar() throws MiExcepcion {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new MiExcepcion("Error al desconectar " + ex.getLocalizedMessage());
        }
    }
    
}
