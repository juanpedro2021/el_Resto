
package Principal;

import java.sql.Connection;
import resto.AccesoDatos.Conexion;
import resto.AccesoDatos.ProductoData;
import resto.Entidades.Producto;


public class ElResto {

 
    public static void main(String[] args) {
       //probando conexion
       
//       Conexion con= new Conexion();
//       con= (Conexion) Conexion.getConexion();

//                      ******Probando productoData***********

//         *** creo pruductos
//forma de el constructor  
//                        estado,nombre,cantidad,precio
//Producto salsa = new Producto(true,"salsa",12,200.2);

//Producto agua = new Producto(true,"agua mineral",3,200.2);

ProductoData PD = new ProductoData();

//      ***agrego los productos

//PD.agregarProducto(salsa);

//PD.agregarProducto(agua);

//      eliminar un producto

//int idagua = 1 ;
//
//PD.eliminarProducto(idagua);

//      *** modifico el producto con el id=1***
        
Producto salsa = new Producto(1,true,"salsa",10,45.0);

PD.modificarProducto(salsa);





       //////PROBAR OBTENER PRODUCTO/////
//      ProductoData pd=new ProductoData();
//      List<Producto> lp= pd.obtenerProducto();
//      
//      for(Producto produ : lp){
//          System.out.println("ID: " + produ.getidProducto());
//          System.out.println("Codigo: " + produ.getCodigo());
//          System.out.println("Nombre: " + produ.getNombre());
//          System.out.println("Cantidad: " + produ.getCantidad());
//          System.out.println("Precio: " + produ.getPrecio());
//      }
      
    }
    
}
