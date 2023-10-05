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
        String sql = "INSERT INTO reserva (idmesa, nombre, DNI, fecha) VALUES (?, ?, ?, ?)";
        try {
                PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, reserva.getIdMesa());
                ps.setString(2, reserva.getNombre());
                ps.setInt(3, reserva.getDNI());
                ps.setTimestamp(4, Timestamp.valueOf(reserva.getFecha()));
        
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                
                if (rs.next()){
			reserva.setIdReserva(rs.getInt(1));
		JOptionPane.showMessageDialog(null, "Su Reserva se ha añadido con éxito");
		}
		ps.close();
		} catch (SQLException ex){
		JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva "+ex.getMessage());
		}
		}
    
    
}
