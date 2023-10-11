/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resto.AccesoDatos;

import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import resto.Entidades.Reserva;


public class ReservaData {
    private Connection con=null;
    
    public ReservaData () {
        con = Conexion.getConexion();
    }
    
    public void guardarReserva (Reserva reserva) {
        String sql = "INSERT INTO reserva (idMesa, nombre, DNI, fecha, estado) VALUES (?, ?, ?, ?, ?)";
        try {
                PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                
                ps.setInt(1, reserva.getIdMesa());               
                ps.setString(2, reserva.getNombre());                
                ps.setInt(3, reserva.getDNI());              
                ps.setTimestamp(4, reserva.getFecha());
                ps.setBoolean(5, reserva.isEstado());
              
                ps.executeUpdate();
                
                ResultSet rs = ps.getGeneratedKeys();
                
                
                if (rs.next()){
			reserva.setIdReserva(rs.getInt(1));
		JOptionPane.showMessageDialog(null, "Su Reserva se ha añadido con éxito");
		}
		ps.close();
		} catch (SQLException ex){
		JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva"+ex.getMessage());
		}
		}
    
        public void modificarReserva(Reserva reserva){
        
       
        String sql="UPDATE reserva SET idMesa=?, nombre =?, DNI=?, fecha=? , estado=? WHERE idReserva=?";
        
       try{
           PreparedStatement ps=con.prepareStatement(sql);
           
           ps.setInt(1, reserva.getIdMesa());
           ps.setString(2,reserva.getNombre());
           ps.setInt(3, reserva.getDNI());
           ps.setTimestamp(4, reserva.getFecha());
           ps.setBoolean(5, reserva.isEstado());
           ps.setInt(6, reserva.getIdReserva());
            

            	int exito = ps.executeUpdate();

		if (exito == 1) {
		
		JOptionPane.showMessageDialog(null, "Modificado exitosamente");
                
                } else {
                    
		JOptionPane.showMessageDialog(null, "La reserva  no existe");
		}

            
            //ps.close();
            
       } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "error al modificar la reserva" +ex.getMessage()); 
     }
    }
    
    
    
    
        public void eliminarReserva(int id) {
String sql = "UPDATE reserva SET estado = 0 WHERE idReserva = ? ";
	try {
		
		PreparedStatement ps = con.prepareStatement (sql);
		ps.setInt(1, id);
		int fila=ps.executeUpdate();

		if (fila==1) {
			JOptionPane.showMessageDialog(null, "Se eliminó la reserva");
		}
		ps.close();
		} catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva "+ ex.getMessage());
		}
	}
        
        
        
        
    public Reserva buscarReserva(int id){
	Reserva reserva = null;
	String sql = "SELECT idMesa, nombre, DNI, fecha FROM reserva WHERE idReserva = ? AND estado = 1";
	
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
		reserva=new Reserva();
		reserva.setIdReserva(id);
		reserva.setNombre(rs.getString("Nombre"));
                reserva.setDNI(rs.getInt("DNI"));
                reserva.setFecha(rs.getTimestamp("Fecha"));
		reserva.setEstado(true); 
		
		} else {
			JOptionPane.showMessageDialog(null, "No existe la Reserva");
		}
		ps.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva "+ex.getMessage());
		}
		return reserva;
                
    
}
        public Reserva buscarReservaPorDNI(int DNI){
	Reserva reserva = null;
	String sql = "SELECT idReserva,idMesa, nombre, fecha FROM reserva WHERe DNI = ? AND estado = 1";
        
	
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, DNI);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
		reserva=new Reserva();
		reserva.setIdReserva(rs.getInt("idReserva"));
		reserva.setNombre(rs.getString("Nombre"));
                reserva.setFecha(rs.getTimestamp("Fecha"));
		reserva.setEstado(true); 
		
		} else {
			JOptionPane.showMessageDialog(null, "No existe la Reserva");
		}
		ps.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva "+ex.getMessage());
		}
		return reserva;
                
    
}
        
}
