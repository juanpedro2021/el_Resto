
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
    
    //gfgdg
    public List<Producto> obtenerProducto() {
       List <Producto> productos=new ArrayList<>();
       String sql = "SELECT * from producto";
       try{
           PreparedStatement ps= con.prepareStatement(sql);
           ResultSet rs=ps.executeQuery();
           
           while(rs.next()){
               int id= rs.getInt("idProducto");
               Boolean codigo= rs.getBoolean("codigo");
               String nombre= rs.getString("nombre");
               int cantidad= rs.getInt("cantidad");
               double precio = rs.getDouble("precio");
               productos.add(new Producto(id,codigo,nombre,cantidad,precio));
           }
       }catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "error al acceder a la tabla Productos"); 
     }
     return productos;
    }
    
    public void agregarProducto(Producto producto){
        String sql="INSERT INTO producto (estado, nombre, cantidad, precio) VALUES (?, ?, ?, ?)";
        
        try{
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setBoolean(1, producto.isEstado());
            ps.setString(2, producto.toString());
            ps.setInt(3, producto.getCantidad());
            ps.setDouble(4, producto.getPrecio());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "error al agregar Producto"); 
     }
        
    }
    
    public void modificarProducto(Producto producto){
        String sql="INSERT INTO producto (estado, nombre, cantidad, precio) VALUES (?, ?, ?, ?)";
        
       try{
           PreparedStatement ps=con.prepareStatement(sql);
           ps.setBoolean(1, producto.isEstado());
            ps.setString(2, producto.toString());
            ps.setInt(3, producto.getCantidad());
            ps.setDouble(4, producto.getPrecio());
            ps.executeUpdate();
            ps.close();
       } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "error al modificar Producto"); 
     }
    }
}
