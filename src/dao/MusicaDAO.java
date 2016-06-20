
package dao;

import excepciones.MiExcepcion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.Concierto;
import modelo.Venta;



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
    
    
    public ArrayList<Cliente> selectAllClientes() throws MiExcepcion {
        
        ArrayList<Cliente> misClientes = new ArrayList<>();
            conectar();
        try {
            String query = "select * from ciente order by nombre;";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            Cliente c = new Cliente();
            while(rs.next()) {
              c.setNif(rs.getString("nif"));
              c.setNombre(rs.getString("nombre"));
              c.setApellidos(rs.getString("apellidos"));
              misClientes.add(c);
            } 
            st.close();
            rs.close();
            
        } catch (SQLException ex) {
            throw new MiExcepcion("Error en la consulta " + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }
        return misClientes;
    }
    
    
    public void insertarConcierto(Concierto c) throws MiExcepcion {
        
        conectar();
        try {
            String insertar = "insert into concierto values(null, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(insertar);
            ps.setString(1, c.getCantante());
            ps.setString(2, c.getSala());
            ps.setString(3, c.getCiudad());
            ps.setInt(4, c.getCapacidad());
            ps.setDouble(5, c.getPrecio());
            ps.setInt(6, c.getEntradas());
            ps.executeUpdate();
            ps.close();
         
        } catch (SQLException ex) {
            throw new MiExcepcion("Error al insertar " + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }
    }
    
   
    
    public ArrayList<Concierto> selectConciertosDisponibles() throws MiExcepcion {
        
        ArrayList<Concierto> conciertos = new ArrayList<>();
            conectar();
        
        try {
            String query = "select * from concierto where capacidad > vendido order by cantante;";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Concierto c = new Concierto();
                c.setId(rs.getInt("idconcierto"));
                c.setCantante(rs.getString("cantante"));
                c.setSala(rs.getString("sala"));
                c.setCiudad(rs.getString("ciudad"));
                c.setCapacidad(rs.getInt("capacidad"));
                c.setPrecio(rs.getDouble("precio"));
                c.setEntradas(rs.getInt("vendido"));
                conciertos.add(c);
            }
        } catch (SQLException ex) {
            throw new MiExcepcion("Error en la query " + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }
        return conciertos;
    }
    
    
    public void insertarVenta(Venta v) throws MiExcepcion {
        
        conectar();
        try {
            String insertar = "insert into venta values (null, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(insertar);
            ps.setString(1, v.getCliente().getNif());
            ps.setInt(2, v.getConcierto().getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            throw new MiExcepcion("Error al insertar " + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }
    }
    
    
    public double totalVentas() throws MiExcepcion {
        conectar();
        double total = 0;
        try {
            String query = "select sum (precio) from concierto join venta on idconcierto= concierto;";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                total = rs.getDouble(1);
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            throw new MiExcepcion("Error en la suma " + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }
        return total;
    }

    
    
    public void actualizarConciertosConVentas(Concierto c) throws MiExcepcion{
        conectar();
        try {
            String update = "update concierto set venta=? where idconcierto=?;";
            PreparedStatement ps = connection.prepareStatement(update);
            ps.setInt(1, c.getEntradas());
            ps.setInt(2, c.getId());
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            throw new MiExcepcion("Error al actualizar " + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }
    }
    
    
    private void conectar() throws MiExcepcion {
       
            String url = "jdbc:mysql://localhost:3306/uf1290";
            String user = "root";
            String pass = "tambacounda";
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
