
package resto.AccesoDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import resto.Entidades.Mesa;


public class MesaData {
    private Connection con=null;

    public MesaData() {
        con= Conexion.getConexion();
        
    }
        public void guardarMesa (Mesa mesa) {
	
	String sql = "INSERT INTO mesa (numMesa, capacidad, estado) VALUES (?, ?, ?)";
	try {
		PreparedStatement ps = con.prepareStatement (sql, Statement.RETURN_GENERATED_KEYS);
                
                ps.setInt(1, mesa.getNumMesa());
		ps.setInt(2, mesa.getCapacidad());
		ps.setInt(3, mesa.getEstado());
		//ps.setObject(4, mesa.getClass(reserva));
		
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();

		if (rs.next()){
			mesa.setIdMesa(rs.getInt(1));
		JOptionPane.showMessageDialog(null, "Mesa añadida con éxito");
		}
		ps.close();
		} catch (SQLException ex){
		JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Mesa"+ex.getMessage());
		}
        }
		
        public void eliminarMesa(int id) {
String sql = "UPDATE mesa SET estado = 0 WHERE idMesa = ? ";
	try {
		
		PreparedStatement ps = con.prepareStatement (sql);
		ps.setInt(1, id);
		int fila=ps.executeUpdate();

		if (fila==1) {
			JOptionPane.showMessageDialog(null, "Se eliminó la mesa");
		}
		ps.close();
		} catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Mesa "+ ex.getMessage());
		}
	}
        
   
  public void modificarMesa (Mesa mesa) {
	
	String sql = "UPDATE mesa SET numMesa = ?, capacidad = ?, estado = ? WHERE idMesa = ?";


	try {

                 PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, mesa.getNumMesa());
		ps.setInt(2, mesa.getCapacidad());
		ps.setInt(3, mesa.getEstado());
		ps.setInt(4, mesa.getIdMesa());
        
                int exito = ps.executeUpdate();

		if (exito == 1) {
		
		JOptionPane.showMessageDialog(null, "Modificación exitosa"); 
		} else {
		JOptionPane.showMessageDialog(null, "La mesa no existe");
		}
		} catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Mesa "+ex.getMessage());
		}
		}

 	public List <Mesa> listarMesasReservadas() {

	List<Mesa> mesas = new ArrayList<>();
	String sql = "SELECT * FROM mesa WHERE estado = 1";
	try{

                PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

		Mesa mesa=new Mesa();

		mesa.setIdMesa(rs.getInt("idMesa"));
		mesa.setNumMesa(rs.getInt("numMesa"));
		mesa.setCapacidad(rs.getInt("capacidad"));
		mesa.setEstado(rs.getInt("estado"));
		
                
		mesas.add(mesa);
                
		}
		ps.close ();

	 	} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Mesa "+ex.getMessage());
		}
		return mesas;
		}
        
        
        
        public List <Mesa> listarMesasLibres() {

	List<Mesa> mesas = new ArrayList<>();
	String sql = "SELECT * FROM mesa WHERE estado = 0";
	try{

                PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

		Mesa mesa=new Mesa();

		mesa.setIdMesa(rs.getInt("idMesa"));
		mesa.setNumMesa(rs.getInt("numMesa"));
		mesa.setCapacidad(rs.getInt("capacidad"));
		mesa.setEstado(rs.getInt("estado"));
		
                
		mesas.add(mesa);
                
		}
		ps.close ();

	 	} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Mesa "+ex.getMessage());
		}
		return mesas;
		}
  
    }


