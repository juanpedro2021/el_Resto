
package Principal;

import java.sql.Connection;
import java.sql.Timestamp;
import resto.AccesoDatos.Conexion;
import resto.AccesoDatos.DetallePedidoData;
import resto.AccesoDatos.MesaData;
import resto.AccesoDatos.MeseroData;
import resto.AccesoDatos.PedidoData;
import resto.AccesoDatos.ProductoData;
import resto.AccesoDatos.ReservaData;
import resto.Entidades.DetallePedido;
import resto.Entidades.Mesa;
import resto.Entidades.Mesero;
import resto.Entidades.Pedido;
import resto.Entidades.Producto;
import resto.Entidades.Reserva;


public class ElResto {

 
    public static void main(String[] args) {
       //probando conexion
       
//       Conexion con= new Conexion();
//       con= (Conexion) Conexion.getConexion();


//                      ******Probando productoData***********


//         *** creo pruductos
//forma de el constructor  
  //                      estado,nombre,cantidad,precio
//Producto salsa = new Producto(true,"salsa",12,200.2);
//
//Producto agua = new Producto(true,"agua mineral",3,200.2);
//
ProductoData PD = new ProductoData();
//
////      ***agrego los productos
//
//PD.agregarProducto(salsa);

//PD.agregarProducto(agua);

//      eliminar un producto

//int idagua = 1 ;
//
//PD.eliminarProducto(idagua);

//      *** modifico el producto con el id=1***
        
//Producto salsa = new Producto(1,true,"salsa",10,45.0);
//
//PD.modificarProducto(salsa);

// busco un producto
//Producto p = new Producto();
//
//p=PD.buscarProducto(5);
//        System.out.println(""+ p.toString());

//listo todos los productos

//for(Producto produ: PD.listarProductos()){
// 
//
//    System.out.println(""+produ.toString());
//
//    }

//                  *** PRUEBA MesaData *****


//Mesa mesa=new Mesa();
//Mesa mesa2 = new Mesa();

//MesaData md = new MesaData();

//****pruebo buscar mesa

//Mesa me =new Mesa();
//me=md.buscarMesa(4);
//me.toString();
//
//    System.out.println("numero"+me.getNumMesa());
//    
//    System.out.println("capacidad" +me.getCapacidad());
//    
//    System.out.println("estado "+ me.getEstado());

//mesa.setNumMesa(6);
//mesa.setCapacidad(10);
//mesa.setEstado(3);

//mesa2.setNumMesa(3);
//mesa2.setCapacidad(5);
//mesa2.setEstado(3);



// agrego 2 mesas

//md.guardarMesa(mesa);
//md.guardarMesa(mesa2);

//elimino una mesa

//md.eliminarMesa(1);

// modifico una mesa

//Mesa maseModi = new Mesa(2,6,20,2);
//md.modificarMesa(maseModi);
//

//    listado las mesas


//for(Mesa me:md.listarMesasLibres() ){
// 
//
//    System.out.println("numero"+me.getNumMesa());
//    
//    System.out.println("capacidad" +me.getCapacidad());
//    
//    System.out.println("estado "+ me.getEstado());
//    
//    }

//for(Mesa me:md.listarMesasReservadas() ){
// 
//
//    System.out.println("numero"+me.getNumMesa());
//    
//    System.out.println("capacidad" +me.getCapacidad());
//    
//    System.out.println("estado "+ me.getEstado());
//    
//    }



//               *** PRUEBA MeseroData *****


/////creo meseros
//
//Mesero mesero = new Mesero("pepe","pepe23","2023");
//
//Mesero mesero2 = new Mesero("pedro","p23","pedro12345");
//
//MeseroData meserod = new MeseroData();
//// guardo los meseros
//
//meserod.guardarMesero(mesero);
//meserod.guardarMesero(mesero2);
//
//// elimino mesero
//
//meserod.eliminarMesero(2);
//
//// modifico un mesero
//
//Mesero mesero3 = new Mesero(1,"pepe","pepe23","pepe2025");
//
//meserod.modificarMesero(mesero3);

//pruebo buscar mesero

//Mesero mesero =new Mesero();
//mesero=meserod.buscarMesero(1);
//mesero.toString();
//
//    System.out.println("nombre "+mesero.getNombre());
//    
//    System.out.println("contra " +mesero.getPassword());
//    
//    System.out.println("usuario "+ mesero.getUser());


//                  *** PRUEBA ReservaData *****


// guardo una reserva
//
//String fecha= "2023-10-10 15:30:00";
//
//Timestamp time = Timestamp.valueOf(fecha);
//
//String fecha2= "2021-10-10 20:30:00";
//
//Timestamp time2 = Timestamp.valueOf(fecha2);
//
//Reserva reserva = new Reserva(1,"jorge",12345,time,true);
//
//Reserva reserva2 = new Reserva(2,"nilda",456789,time2,true);
//
//ReservaData rd = new ReservaData();
////
////agrego las reservas
//
//rd.guardarReserva(reserva);
//rd.guardarReserva(reserva2);


//elimino una reserva

//rd.eliminarReserva(12);


//// modifico reserva
//Reserva reserva5 = new Reserva(14,2,"martha",456789,time,true);
//rd.modificarReserva(reserva5);
// busco una reserva

//Reserva reserva3 = new Reserva();
//
//reserva3 = rd.buscarReserva(10);
//
//reserva3.toString();
//   System.out.println("id reserva "+reserva3.getIdReserva());
//    
//   System.out.println("id mesa" +reserva3.getIdMesa());
//    
//   System.out.println("DNI = "+ reserva3.getDNI());
//    System.out.println("nombre "+reserva3.getNombre());
//    
//    System.out.println("fecha y hora " + reserva3.getFecha());
//    
//    System.out.println("estado "+ reserva3.isEstado());
//


////                  *** PRUEBA DetallePedidoData *****

//pido 2 aguas mineral

// creo un producto
ProductoData pd= new ProductoData();
Producto produ = new Producto();

// creo un detalle pedido

DetallePedido detalle = new DetallePedido();
DetallePedidoData detalled = new DetallePedidoData();

PedidoData pedidod = new PedidoData();
Pedido pedido = new Pedido();

//busco el producto y lo agrego

produ = pd.buscarProducto(5);
detalle.setProducto(produ);
detalle.setCantidad(2);

//detalle.setPedido(pedido.get);

detalled.agregarDetallePedido(detalle);




    }
    
}
