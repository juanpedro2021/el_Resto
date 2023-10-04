
package resto.AccesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import resto.Entidades.Producto;


public class ProductoData {
    private Connection con=null;

    public ProductoData() {
        con= Conexion.getConexion();
    }
    
    public void eliminarProducto(int id) {
String sql = "UPDATE producto SET estado = 0 WHERE idProducto = ? ";
	try {
		
		PreparedStatement ps = con.prepareStatement (sql);
		ps.setInt(1, id);
		int fila=ps.executeUpdate();

		if (fila==1) {
			JOptionPane.showMessageDialog(null, "Se eliminó el producto");
		}
		ps.close();
		} catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto "+ ex.getMessage());
		}
	}
    
//     public List<Producto> obtenerProducto() {
//       List <Producto> productos=new ArrayList<>();
//       String sql = "SELECT * from producto";
//       try{
//           PreparedStatement ps= con.prepareStatement(sql);
//           ResultSet rs=ps.executeQuery();
//           
//           while(rs.next()){
//               int id= rs.getInt("idProducto");
//               int codigo= rs.getInt("codigo");
//               String nombre= rs.getString("nombre");
//               int cantidad= rs.getInt("cantidad");
//               double precio = rs.getDouble("precio");
//               productos.add(new Producto(id,codigo,nombre,cantidad,precio));
//           }
//       }catch (SQLException ex) {
//         JOptionPane.showMessageDialog(null, "error al acceder a la tabla Productos"); 
//     }
//     return productos;
//    }
}
