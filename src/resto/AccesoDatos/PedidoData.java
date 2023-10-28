
package resto.AccesoDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import resto.Entidades.DetallePedido;
import resto.Entidades.Mesa;
import resto.Entidades.Mesero;
import resto.Entidades.Pedido;

/**
 *
 * @author Gianfranco
 */

public class PedidoData {
    
    private Connection con=null;
    private MesaData md ;
    private MeseroData meserod;

    public PedidoData() {
        con = Conexion.getConexion();
        md = new MesaData();
        meserod = new MeseroData();
    }
  
    
    

     public void guardarPedido(Pedido pedido){
         // muestro el pedido antes de que lo guarde
         //System.out.println(""+ pedido.toString());
        
           String sql = "INSERT INTO pedido(idMesa , idMesero , fecha , estado , importe, hora) Values(?,?,?,?,?,?)";
           
      try {
         PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         

          ps.setInt(1,pedido.getMesa().getIdMesa());
          ps.setInt(2, pedido.getMesero().getIdMesero());
          ps.setDate(3, Date.valueOf(pedido.getFecha()));  
          //localDate a Date
          ps.setBoolean(4,pedido.isEstado());
          ps.setDouble(5 , pedido.getImporte());
          ps.setTime(6, pedido.getHora());
          ps.executeUpdate();
          
          ResultSet rs = ps.getGeneratedKeys();
       
          
          if (rs.next()){
			pedido.setIdPedido(rs.getInt(1));
		JOptionPane.showMessageDialog(null, "Pedido añadida con éxito");
		}

          ps.close();
          
          
      } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pedido"+ex.getMessage());
      }     
    }
     
    public void eliminarPedido(int id) {
        String sql = "UPDATE pedido SET estado = 0 WHERE idPedido = ? ";
            
	try {
		
		PreparedStatement ps = con.prepareStatement (sql);
		ps.setInt(1, id);
		int fila=ps.executeUpdate();

		if (fila==1) {
			JOptionPane.showMessageDialog(null, "Pedido eliminado");
		}
		ps.close();
		} catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pedido "+ ex.getMessage());
		}
	}
    
    public void modificarPedido(Pedido pedido){
            String sql = "UPDATE pedido SET idMesa =?, idMesero=?, fecha=?, estado=?, importe=?,hora=? WHERE idPedido=?";
           
      try {
          PreparedStatement ps = con.prepareStatement (sql, Statement.RETURN_GENERATED_KEYS);
          
          ps.setInt(1,pedido.getMesa().getIdMesa());
          ps.setInt(2, pedido.getMesero().getIdMesero());
          ps.setDate(3, Date.valueOf(pedido.getFecha()));           //localDate a Date
          ps.setBoolean(4,pedido.isEstado());
          ps.setDouble(5 , pedido.getImporte());
          ps.setTime(6, pedido.getHora());
          ps.setInt(7, pedido.getIdPedido());
           int  exito = ps.executeUpdate();
          
          if (exito == 1) {
		
		JOptionPane.showMessageDialog(null, "Modificado exitosamente"); 
		} else {
		JOptionPane.showMessageDialog(null, "El pedido no existe");
		}
      
      
          
      } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pedido"+ex.getMessage());
      }    
  
}
 
    public List <Pedido> listarPedidos() {
	
	List<Pedido> listadoPedidos = new ArrayList<>();
	String sql = "SELECT * FROM pedido WHERE estado = 1";
	try{

                 PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

		Pedido pedido=new Pedido();
                
                pedido.setIdPedido(rs.getInt("idPedido"));
                Mesa m = md.buscarMesa(rs.getInt("idMesa"));
                Mesero mesero = meserod.buscarMesero(rs.getInt("idMesero"));
                pedido.setMesa(m);
                pedido.setMesero(mesero);
                pedido.setFecha((rs.getDate("fecha")).toLocalDate());
                pedido.setEstado(true);
                pedido.setImporte(rs.getInt("importe"));
                pedido.setHora(rs.getTime("hora"));

		listadoPedidos.add(pedido);
		
		
		}
		ps.close ();

	 	} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno "+ex.getMessage());
		}
		return listadoPedidos;
}
    
    public Pedido buscarPedido(int id){
	Pedido pedido = null;
	String sql = "SELECT idMesa , idMesero , fecha , estado , importe, hora FROM pedido WHERE idPedido = ? AND estado = 1";

	
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
		pedido=new Pedido();//acá uso el constructor vacío de pedido
                //agrego el id
		pedido.setIdPedido(id);
                
              // busco la mesa y el mesero con sus id y la agrego
                Mesa m = md.buscarMesa(rs.getInt("idMesa"));
                Mesero mesero = meserod.buscarMesero(rs.getInt("idMesero"));
                pedido.setMesa(m);
                pedido.setMesero(mesero);
                
              // busco la fecha y la agrego
                pedido.setFecha((rs.getDate("fecha")).toLocalDate());
                
              // agego el estado en true
                pedido.setEstado(true);
                
              // busco el importe y lo agrego
                pedido.setImporte(rs.getInt("importe"));
                
              // busco la hora y la agrego
                pedido.setHora(rs.getTime("hora"));
		
		} else {
			JOptionPane.showMessageDialog(null, "No existe el pedido");
		}
		ps.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pedido "+ex.getMessage());
		}
		return pedido;
	
}   

     public List<Pedido> listarPedidoPorIdMesero(int idMesero){
        List<Pedido> pedidos=new ArrayList<>();
        String sql="SELECT * FROM pedido WHERE idMesero=? AND estado IN(0, 1)";
       try{
           PreparedStatement ps=con.prepareStatement(sql);
           ps.setInt(1, idMesero);
           ResultSet rs=ps.executeQuery();
           while(rs.next()){
               Pedido pedido=new Pedido();
               pedido.setIdPedido(rs.getInt("idPedido"));
                Mesa m = md.buscarMesa(rs.getInt("idMesa"));
                Mesero mesero = meserod.buscarMesero(rs.getInt("idMesero"));
                pedido.setMesa(m);
                pedido.setMesero(mesero);
                pedido.setFecha((rs.getDate("fecha")).toLocalDate());
                pedido.setEstado(rs.getBoolean("estado"));
                pedido.setImporte(rs.getInt("importe"));
                pedido.setHora(rs.getTime("hora"));
               pedidos.add(pedido);
           }
           ps.close();
       } catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pedido "+ex.getMessage());
		}
        return pedidos;
       
    }
   
    
    public List<Pedido> listarIngresosPorFecha(LocalDate fecha){
      List<Pedido> pedidos=new ArrayList();
      String sql="SELECT * FROM pedido WHERE DATE(fecha) = ? AND estado=1";
      
      try{
          PreparedStatement ps=con.prepareStatement(sql);
          ps.setDate(1, Date.valueOf(fecha));
          ResultSet rs=ps.executeQuery();
          
          while(rs.next()){
              Pedido pedido=new Pedido();
              pedido.setIdPedido(rs.getInt("idPedido"));
                Mesa m = md.buscarMesa(rs.getInt("idMesa"));
                Mesero mesero = meserod.buscarMesero(rs.getInt("idMesero"));
                pedido.setMesa(m);
                pedido.setMesero(mesero);
                pedido.setFecha((rs.getDate("fecha")).toLocalDate());
                pedido.setEstado(true);
                pedido.setImporte(rs.getInt("importe"));
                pedido.setHora(rs.getTime("hora"));
               pedidos.add(pedido);
          }
      }catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pedido "+ex.getMessage());
		}
      return pedidos;
    }
    
    public List<Pedido> listarPedidosCobradosPorMeseroEnDia(int idMesero, LocalDate fecha ){
        List<Pedido> pedidos=new ArrayList();
        String sql="SELECT * FROM pedido WHERE idMesero = ? AND DATE(fecha)= ? AND estado IN (0,1)";
        
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idMesero);
            ps.setDate(2, Date.valueOf(fecha));
            ResultSet rs= ps.executeQuery();
            
            while(rs.next()){
              Pedido pedido=new Pedido();
              pedido.setIdPedido(rs.getInt("idPedido"));
                Mesa m = md.buscarMesa(rs.getInt("idMesa"));
                Mesero mesero = meserod.buscarMesero(rs.getInt("idMesero"));
                pedido.setMesa(m);
                pedido.setMesero(mesero);
                pedido.setFecha((rs.getDate("fecha")).toLocalDate());
                pedido.setEstado(rs.getBoolean("estado"));
                pedido.setImporte(rs.getInt("importe"));
                pedido.setHora(rs.getTime("hora"));
               pedidos.add(pedido);  
            }
        }catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pedido "+ex.getMessage());
		}
        return pedidos;
    }
                                                                       // Time inicio,Time Fin
    public List<Pedido> listarPedidosMesaEntreHoras(int idMesa, Time inicio, Time fin, LocalDate fecha){
     List<Pedido> listadopedidos=new ArrayList();
     String sql="SELECT * FROM pedido WHERE idMesa = ? AND hora BETWEEN ? AND ? AND fecha = ? ";
     
     try{
         PreparedStatement ps=con.prepareStatement(sql);
         ps.setInt(1, idMesa);
         ps.setTime(2, inicio);
         ps.setTime(3, fin);
         ps.setDate(4, Date.valueOf(fecha));

         ResultSet rs=ps.executeQuery();

         while(rs.next()){
              Pedido pedido=new Pedido();
              pedido.setIdPedido(rs.getInt("idPedido"));
                Mesa m = md.buscarMesa(rs.getInt("idMesa"));
                Mesero mesero = meserod.buscarMesero(rs.getInt("idMesero"));
                pedido.setMesa(m);
                pedido.setMesero(mesero);
                pedido.setFecha((rs.getDate("fecha")).toLocalDate());
                pedido.setEstado(rs.getBoolean("estado"));
                pedido.setImporte(rs.getInt("importe"));
                pedido.setHora(rs.getTime("hora"));
                
               listadopedidos.add(pedido);  

         }

         ps.close();
     }catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pedido "+ex.getMessage());
		}
     return listadopedidos;
    }
    
     public Pedido buscarPedidoPorMesa(int idMesa){
	Pedido pedido = null;

	String sql = "SELECT idPedido , idMesa , idMesero , fecha , estado , importe, hora FROM pedido WHERE idMesa = ? AND estado = 1";

	
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, idMesa);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
		pedido=new Pedido();//acá uso el constructor vacío de pedido
                //agrego el id
		pedido.setIdPedido(rs.getInt("idPedido"));
                
              // busco la mesa y el mesero con sus id y la agrego
                Mesa m = md.buscarMesa(idMesa);
                Mesero mesero = meserod.buscarMesero(rs.getInt("idMesero"));
                pedido.setMesa(m);
                pedido.setMesero(mesero);
                
              // busco la fecha y la agrego
                pedido.setFecha((rs.getDate("fecha")).toLocalDate());
                
              // agego el estado en true
                pedido.setEstado(true);
                
              // busco el importe y lo agrego
                pedido.setImporte(rs.getInt("importe"));
                
              // busco la hora y la agrego
                pedido.setHora(rs.getTime("hora"));
		
		} else {
			JOptionPane.showMessageDialog(null, "No existe el pedido");
		}
		ps.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pedido "+ex.getMessage());
		}
		return pedido;
	
}
      public List<Pedido> buscarPedidoPorMesaHistorial(int idMesa){
	 List<Pedido> listadopedidos=new ArrayList();
	String sql = "SELECT idPedido , idMesa , idMesero , fecha , estado , importe, hora FROM pedido WHERE idMesa = ? AND estado IN (0,1)";

	
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, idMesa);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
		Pedido pedido=new Pedido();//acá uso el constructor vacío de pedido
                //agrego el id
		pedido.setIdPedido(rs.getInt("idPedido"));
                
              // busco la mesa y el mesero con sus id y la agrego
                Mesa m = md.buscarMesa(idMesa);
                Mesero mesero = meserod.buscarMesero(rs.getInt("idMesero"));
                pedido.setMesa(m);
                pedido.setMesero(mesero);
                
              // busco la fecha y la agrego
                pedido.setFecha((rs.getDate("fecha")).toLocalDate());
                
              // agego el estado en true
                pedido.setEstado(rs.getBoolean("estado"));
                
              // busco el importe y lo agrego
                pedido.setImporte(rs.getInt("importe"));
                
              // busco la hora y la agrego
                pedido.setHora(rs.getTime("hora"));
                
                listadopedidos.add(pedido);
		
		} 
		ps.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pedido "+ex.getMessage());
		}return listadopedidos;	
} 
     
     
         public List <Pedido> listarPedidoss() {
	
	List<Pedido> listadoPedidos = new ArrayList<>();
	String sql = "SELECT * FROM pedido WHERE estado IN (0,1)";
	try{

                 PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

		Pedido pedido=new Pedido();
                
                pedido.setIdPedido(rs.getInt("idPedido"));
                Mesa m = md.buscarMesa(rs.getInt("idMesa"));
                Mesero mesero = meserod.buscarMesero(rs.getInt("idMesero"));
                pedido.setMesa(m);
                pedido.setMesero(mesero);
                pedido.setFecha((rs.getDate("fecha")).toLocalDate());
                pedido.setEstado(rs.getBoolean("estado"));
                pedido.setImporte(rs.getInt("importe"));
                pedido.setHora(rs.getTime("hora"));

		listadoPedidos.add(pedido);
		
		
		}
		ps.close ();

	 	} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno "+ex.getMessage());
		}
		return listadoPedidos;
}
    
//    public List<Pedido> listarPedidoPorIdMesero(int idMesero){
//        List<Pedido> pedidos=new ArrayList<>();
//        String sql="SELECT * FROM pedido WHERE idMesero=? AND estado = 1";
//       try{
//           PreparedStatement ps=con.prepareStatement(sql);
//           ps.setInt(1, idMesero);
//           ResultSet rs=ps.executeQuery();
//           while(rs.next()){
//               Pedido pedido=new Pedido();
//               pedido.setIdPedido(rs.getInt("idPedido"));
//                Mesa m = md.buscarMesa(rs.getInt("idMesa"));
//                Mesero mesero = meserod.buscarMesero(rs.getInt("idMesero"));
//                pedido.setMesa(m);
//                pedido.setMesero(mesero);
//                pedido.setFecha((rs.getDate("fecha")).toLocalDate());
//                pedido.setEstado(true);
//                pedido.setImporte(rs.getInt("importe"));
//                pedido.setHora(rs.getTime("hora"));
//               pedidos.add(pedido);
//           }
//           ps.close();
//       } catch (SQLException ex) {
//			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pedido "+ex.getMessage());
//		}
//        return pedidos;
//       
//    }
//   
//    
//    public List<Pedido> listarIngresosPorFecha(LocalDate fecha){
//      List<Pedido> pedidos=new ArrayList();
//      String sql="SELECT * FROM pedido WHERE DATE(fecha) = ? AND estado=1";
//      
//      try{
//          PreparedStatement ps=con.prepareStatement(sql);
//          ps.setDate(1, Date.valueOf(fecha));
//          ResultSet rs=ps.executeQuery();
//          
//          while(rs.next()){
//              Pedido pedido=new Pedido();
//              pedido.setIdPedido(rs.getInt("idPedido"));
//                Mesa m = md.buscarMesa(rs.getInt("idMesa"));
//                Mesero mesero = meserod.buscarMesero(rs.getInt("idMesero"));
//                pedido.setMesa(m);
//                pedido.setMesero(mesero);
//                pedido.setFecha((rs.getDate("fecha")).toLocalDate());
//                pedido.setEstado(true);
//                pedido.setImporte(rs.getInt("importe"));
//                pedido.setHora(rs.getTime("hora"));
//               pedidos.add(pedido);
//          }
//      }catch (SQLException ex) {
//			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pedido "+ex.getMessage());
//		}
//      return pedidos;
//    }
//    
//    public List<Pedido> listarPedidosCobradosPorMeseroEnDia(int idMesero, LocalDate fecha ){
//        List<Pedido> pedidos=new ArrayList();
//        String sql="SELECT * FROM pedido WHERE idMesero = ? AND DATE(fecha)= ? AND estado = 1";
//        
//        try{
//            PreparedStatement ps=con.prepareStatement(sql);
//            ps.setInt(1, idMesero);
//            ps.setDate(2, Date.valueOf(fecha));
//            ResultSet rs= ps.executeQuery();
//            
//            while(rs.next()){
//              Pedido pedido=new Pedido();
//              pedido.setIdPedido(rs.getInt("idPedido"));
//                Mesa m = md.buscarMesa(rs.getInt("idMesa"));
//                Mesero mesero = meserod.buscarMesero(rs.getInt("idMesero"));
//                pedido.setMesa(m);
//                pedido.setMesero(mesero);
//                pedido.setFecha((rs.getDate("fecha")).toLocalDate());
//                pedido.setEstado(true);
//                pedido.setImporte(rs.getInt("importe"));
//                pedido.setHora(rs.getTime("hora"));
//               pedidos.add(pedido);  
//            }
//        }catch (SQLException ex) {
//			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pedido "+ex.getMessage());
//		}
//        return pedidos;
//    }
                                                                       // Time inicio,Time Fin
    public List<Pedido> listarPedidosMesaEntreHoras(int idMesa, Time inicio, Time fin){
     List<Pedido> listadopedidos=new ArrayList();
     String sql="SELECT * FROM pedido WHERE idMesa = ? AND hora BETWEEN ? AND ? ";
     
     try{
         PreparedStatement ps=con.prepareStatement(sql);
         ps.setInt(1, idMesa);
         ps.setTime(2, inicio);
         ps.setTime(3, fin);

         ResultSet rs=ps.executeQuery();

         while(rs.next()){
              Pedido pedido=new Pedido();
              pedido.setIdPedido(rs.getInt("idPedido"));
                Mesa m = md.buscarMesa(rs.getInt("idMesa"));
                Mesero mesero = meserod.buscarMesero(rs.getInt("idMesero"));
                pedido.setMesa(m);
                pedido.setMesero(mesero);
                pedido.setFecha((rs.getDate("fecha")).toLocalDate());
                pedido.setEstado(true);
                pedido.setImporte(rs.getInt("importe"));
                pedido.setHora(rs.getTime("hora"));
                
               listadopedidos.add(pedido);  

         }

         ps.close();
     }catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pedido "+ex.getMessage());
		}
     return listadopedidos;
    }
    
//     public Pedido buscarPedidoPorMesa(int idMesa){
//	Pedido pedido = null;
//
//	String sql = "SELECT idPedido , idMesa , idMesero , fecha , estado , importe, hora FROM pedido WHERE idMesa = ? AND estado = 1";
//
//	
//	try {
//		PreparedStatement ps = con.prepareStatement(sql);
//		ps.setInt(1, idMesa);
//
//		ResultSet rs = ps.executeQuery();
//
//		if (rs.next()) {
//		pedido=new Pedido();//acá uso el constructor vacío de pedido
//                //agrego el id
//		pedido.setIdPedido(rs.getInt("idPedido"));
//                
//              // busco la mesa y el mesero con sus id y la agrego
//                Mesa m = md.buscarMesa(idMesa);
//                Mesero mesero = meserod.buscarMesero(rs.getInt("idMesero"));
//                pedido.setMesa(m);
//                pedido.setMesero(mesero);
//                
//              // busco la fecha y la agrego
//                pedido.setFecha((rs.getDate("fecha")).toLocalDate());
//                
//              // agego el estado en true
//                pedido.setEstado(true);
//                
//              // busco el importe y lo agrego
//                pedido.setImporte(rs.getInt("importe"));
//                
//              // busco la hora y la agrego
//                pedido.setHora(rs.getTime("hora"));
//		
//		} else {
//			JOptionPane.showMessageDialog(null, "No existe el pedido");
//		}
//		ps.close();
//		} catch (SQLException ex) {
//			JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pedido "+ex.getMessage());
//		}
//		return pedido;
//	
//}  
 
     
     
}
