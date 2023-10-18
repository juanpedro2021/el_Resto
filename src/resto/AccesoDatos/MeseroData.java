
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
import resto.Entidades.Mesero;


public class MeseroData {
      private Connection con=null;

    public MeseroData() {
        //System.out.println("uno "+con);
        con= Conexion.getConexion();
        //System.out.println("dos "+con);
    }
    public void guardarMesero (Mesero mesero) {
	
	String sql = "INSERT INTO mesero (nombre, user, password, estado) VALUES (?, ?, ?, ?)";
	try {
		PreparedStatement ps = con.prepareStatement (sql, Statement.RETURN_GENERATED_KEYS);
                
                // relleno el sql con los datos del mesero
                
		ps.setString(1, mesero.getNombre());
		ps.setString(2, mesero.getUser());
		ps.setString(3, mesero.getPassword());
		ps.setBoolean(4, mesero.isEstado());
		
                //ejecuto el comando sql
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();

		if (rs.next()){
			mesero.setIdMesero(rs.getInt(1));
		JOptionPane.showMessageDialog(null, "Mesero añadido con éxito");
		}
		ps.close();
		} catch (SQLException ex){
		JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesero "+ex.getMessage());
		}
		}
    
  public void modificarMesero (Mesero mesero) {
	
	String sql = "UPDATE mesero SET nombre = ?, user = ?, password = ?, estado = ? WHERE idMesero = ?";


	try {

                 PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, mesero.getNombre());
		ps.setString(2, mesero.getUser());
		ps.setString(3, mesero.getPassword());
                ps.setBoolean(4, mesero.isEstado());
		ps.setInt(5, mesero.getIdMesero());
		int exito = ps.executeUpdate();

		if (exito == 1) {
		
		JOptionPane.showMessageDialog(null, "Modificado exitosamente"); 
		} else {
		JOptionPane.showMessageDialog(null, "El mesero no existe");
		}
		} catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Mesero "+ex.getMessage());
		}
  }
        public void eliminarMesero(int id) {
String sql = "UPDATE mesero SET estado = 0 WHERE idMesero = ? ";
	try {
		
		PreparedStatement ps = con.prepareStatement (sql);
		ps.setInt(1, id);
		int fila=ps.executeUpdate();

		if (fila==1) {
			JOptionPane.showMessageDialog(null, "Se eliminó el mesero");
		}
		ps.close();
		} catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Mesero "+ ex.getMessage());
		}
        }
        

 public Mesero buscarMesero(int id){
	Mesero mesero = null;
     
	String sql = "SELECT nombre , user , password, estado FROM mesero WHERE idMesero = ?";
	PreparedStatement ps = null;
	try {
		ps = (PreparedStatement) con.prepareStatement(sql);
                
                // le paso el id 
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		if (rs.next()){
		mesero=new Mesero();
		mesero.setIdMesero(id);
                mesero.setNombre(rs.getString("nombre"));
                mesero.setUser(rs.getString("user"));
                mesero.setPassword(rs.getString("password"));
                mesero.setEstado(rs.getBoolean("estado"));
             
             
		
		} else {
			JOptionPane.showMessageDialog(null, "No existe el Mesero");
		}
		ps.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Mesero "+ex.getMessage());
		}
		return mesero;
		}         
 public List <Mesero> listarUsuario() {

	List<Mesero> meseros = new ArrayList<>();
	String sql = "SELECT * FROM mesero WHERE estado = 1";
	try{

                PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

		Mesero mesero=new Mesero();
		mesero.setIdMesero(rs.getInt("idMesero"));
                mesero.setNombre(rs.getString("nombre"));
                mesero.setUser(rs.getString("user"));
                mesero.setPassword(rs.getString("password"));
                mesero.setEstado(rs.getBoolean("estado"));
		
                
		meseros.add(mesero);
                
		}
		ps.close ();

	 	} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Mesero "+ex.getMessage());
		}
		return meseros;
		}        
	}

        

