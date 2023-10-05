
package resto.AccesoDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import resto.Entidades.Mesero;


public class MeseroData {
      private Connection con=null;

    public MeseroData() {
        con= Conexion.getConexion();
    }
    public void guardarMesero (Mesero mesero) {
	
	String sql = "INSERT INTO mesero (nombre, user, password) VALUES (?, ?, ?)";
	try {
		PreparedStatement ps = con.prepareStatement (sql, Statement.RETURN_GENERATED_KEYS);
                
                // relleno el sql con los datos del mesero
                
		ps.setString(1, mesero.getNombre());
		ps.setString(2, mesero.getUser());
		ps.setString(3, mesero.getPassword());
		
		
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
	
	String sql = "UPDATE mesero SET nombre = ?, user = ?, password = ? WHERE idMesero = ?";


	try {

                 PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(2, mesero.getNombre());
		ps.setString(3, mesero.getUser());
		ps.setString(4, mesero.getPassword());
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
        
        
        
        
        
        
        
        
        
        
        
        
}
