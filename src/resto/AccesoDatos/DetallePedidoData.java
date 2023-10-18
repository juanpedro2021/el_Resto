/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.AccesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import resto.Entidades.DetallePedido;
import resto.Entidades.Pedido;
import resto.Entidades.Producto;

/**
 *
 * @author Gianfranco
 */
public class DetallePedidoData {
    private Connection con = null;
   
    private ProductoData proD=new ProductoData();
    
    public DetallePedidoData(){
        con = Conexion.getConexion();
    }
    
    public void agregarDetallePedido (DetallePedido detallePedido){
       String sql = "INSERT INTO DetallePedido (idPedido, idProducto, Cantidad) VALUES (?, ?, ?)";
      
       try{
           PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           ps.setInt(1, detallePedido.getPedido().getIdPedido());
           ps.setInt(2, detallePedido.getProducto().getidProducto());
           ps.setInt(3, detallePedido.getCantidad());
           ps.executeUpdate();
           
           ResultSet rs = ps.getGeneratedKeys();

		if (rs.next()){
			detallePedido.setIdDtallePedido(rs.getInt(1));
		JOptionPane.showMessageDialog(null, "detalle añadido con éxito");
		}else{
                JOptionPane.showMessageDialog(null, "detalle no existe");
		    
                }
           
           ps.close();
       }catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error al agregar detalle "+ ex.getMessage());
		}
    }
    
    public void eliminarDetallePedido(int idDetallePedido) {
        
         String sql = "DELETE FROM DetallePedido WHERE idDetallePedido = ?";
        
        try {
           
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idDetallePedido);

         int exito = ps.executeUpdate();

		if (exito == 1) {
		
		JOptionPane.showMessageDialog(null, "Eliminacion Exitosa"); 
		} else {
		JOptionPane.showMessageDialog(null, "El detalle  no existe");
		}
                ps.close();
        } catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error al eliminar detalle "+ ex.getMessage());
		}
    }
    
    public void modificarDetallePedido(DetallePedido detallePedido) {
       
          String sql = "UPDATE DetallePedido SET idPedido = ?, idProducto = ?, Cantidad = ? WHERE idDetallePedido = ?";
         
         try {

           PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, detallePedido.getPedido().getIdPedido());
            ps.setInt(2, detallePedido.getProducto().getidProducto());
            ps.setInt(3, detallePedido.getCantidad());
            ps.setInt(4, detallePedido.getIdDtallePedido());

            int exito = ps.executeUpdate();

		if (exito == 1) {
		
		JOptionPane.showMessageDialog(null, "Modificado exitosamente"); 
		} else {
		JOptionPane.showMessageDialog(null, "El detalle no existe");
		}
                
        } catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error al modificar detalle "+ ex.getMessage());
		}
    }
 
    public DetallePedido buscarDetalle(int id){
	DetallePedido detalle = null;
        PedidoData pd=new PedidoData();
     
	String sql = "SELECT idPedido, idProducto , cantidad FROM detallepedido WHERE idDetallePedido = ? ";
	PreparedStatement ps = null;
	try {
		ps = (PreparedStatement) con.prepareStatement(sql);
                
                // le paso el id 
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		if (rs.next()){
                   //ver aca porque tengo que poner nombre diferentes a los detalles marcados en rojo
		detalle=new DetallePedido();
                detalle.setIdDtallePedido(id);
                Pedido pedido = pd.buscarPedido(rs.getInt("idPedido"));
                detalle.setPedido(pedido);
               
                Producto producto = proD.buscarProducto(rs.getInt("idProducto"));
                detalle.setProducto(producto);
                detalle.setCantidad(rs.getInt("cantidad"));           
		
		} else {
			JOptionPane.showMessageDialog(null, "No existe el detalle");
		}
		ps.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalle pedido "+ex.getMessage());
		}
		return detalle;
		} 
}
