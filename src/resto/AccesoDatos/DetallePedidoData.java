/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.AccesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import resto.Entidades.DetallePedido;

/**
 *
 * @author Gianfranco
 */
public class DetallePedidoData {
    private Connection con = null;
    
    public DetallePedidoData(){
        con = Conexion.getConexion();
    }
    
    public void agregarDetallePedido (DetallePedido detallePedido){
       String sql = "INSERT INTO DetallePedido (idPedido, idProducto, Cantidad) VALUES (?, ?, ?)";
      
       try{
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, detallePedido.getPedido().getIdPedido());
           ps.setInt(2, detallePedido.getProducto().getidProducto());
           ps.setInt(3, detallePedido.getCantidad());
           ps.executeUpdate();
           ps.close();
       }catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error al agregar detalle "+ ex.getMessage());
		}
    }
    
    public void eliminarDetallePedido(int idDetallePedido) {
        
         String sql = "DELETE FROM DetallePedido WHERE idDetallePedido = ?";
        
        try {
           
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, idDetallePedido);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error al eliminar detalle "+ ex.getMessage());
		}
    }
    
    
     public void modificarDetallePedido(DetallePedido detallePedido) {
       
          String sql = "UPDATE DetallePedido SET idPedido = ?, idProducto = ?, Cantidad = ? WHERE idDetallePedido = ?";
         
         try {

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, detallePedido.getPedido().getIdPedido());
            statement.setInt(2, detallePedido.getProducto().getidProducto());
            statement.setInt(3, detallePedido.getCantidad());
            statement.setInt(4, detallePedido.getIdDtallePedido());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error al modificar detalle "+ ex.getMessage());
		}
    }

}
