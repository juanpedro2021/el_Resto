
package Principal;

import java.sql.Connection;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
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
    }
    }
       //probando conexion
       
//       Conexion con= new Conexion();
//       con= (Conexion) Conexion.getConexion();


//                      ******Probando productoData***********


//         *** creo pruductos
//forma de el constructor  
  //                      estado,nombre,cantidad,precio
// Producto produ = new Producto();
// Producto produ1 = new Producto();
// Producto produ2 = new Producto();
//  ProductoData PD = new ProductoData();
//  
//  // creo un producto
//  
//produ.setEstado(true);
//produ.setNombre("Lomito");
//produ.setCantidad(15);
//produ.setPrecio(1500.0);
//PD.agregarProducto(produ);
//
//produ1.setEstado(true);
//produ1.setNombre("Pizza");
//produ1.setCantidad(20);
//produ1.setPrecio(1000.0);
//PD.agregarProducto(produ1);
//
//produ2.setEstado(true);
//produ2.setNombre("Hamburguesa");
//produ2.setCantidad(10);
//produ2.setPrecio(700.0);
//PD.agregarProducto(produ2);
//
//
//
////      eliminar un producto
//
//int idsalsa = 1 ;
//
//PD.eliminarProducto(idsalsa);
//
////      *** modifico el producto con el id=1***
//        
//Producto salsa = new Producto(3,true,"aceite",5,500.0);
////
//PD.modificarProducto(salsa);
//
//// busco un producto
//Producto p = new Producto();
////
//p=PD.buscarProducto(5);
//        System.out.println(""+ p.toString());
//
////listo todos los productos
//
//for(Producto prod: PD.listarProductos()){
// 
//
//    System.out.println(""+prod.toString());
//
//    }

//                  *** PRUEBA MesaData *****


//Mesa mesa=new Mesa();
//Mesa mesa2 = new Mesa();
//
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
//
//mesa2.setNumMesa(3);
//mesa2.setCapacidad(5);
//mesa2.setEstado(3);
//
//
//
//// agrego 2 mesas
//
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
////
//Mesero mesero = new Mesero("pepe","pepe23","2023", true);
//
//Mesero mesero2 = new Mesero("pedro","p23","pedro12345", true);
//
//MeseroData meserod = new MeseroData();
//// guardo los meseros
//
//meserod.guardarMesero(mesero);
//meserod.guardarMesero(mesero2);
//
//// elimino mesero
//
//meserod.eliminarMesero(3);
//
//// modifico un mesero
////
//Mesero mesero3 = new Mesero(3,"pepe","pepe23","2023",false);
////
//meserod.modificarMesero(mesero3);

//pruebo buscar mesero

//Mesero mesero =new Mesero();
//mesero=meserod.buscarMesero(1);
//        System.out.println("" + mesero.toString());




//                  *** PRUEBA ReservaData *****


// guardo una reserva
//
//String fecha= "2023-10-10 17:30:00";
////
//Timestamp time = Timestamp.valueOf(fecha);
////
////String fecha2= "2021-10-10 20:30:00";
////
////Timestamp time2 = Timestamp.valueOf(fecha2);
////
//Reserva reserva = new Reserva(4,"jorge",12345,time,true);
////
////Reserva reserva2 = new Reserva(2,"nilda",456789,time2,true);
////
//ReservaData rd = new ReservaData();
//////
//////agrego las reservas
////
//rd.guardarReserva(reserva);
////rd.guardarReserva(reserva2);


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

/////////////***PRUEBA PEDIDODATA**/////////////

//MesaData md = new MesaData();
//MeseroData meserod = new MeseroData();
//ProductoData pd = new ProductoData();
//
//
//Pedido pedido=new Pedido();
//
//pedido.setMesa(md.buscarMesa(2));
//pedido.setMesero(meserod.buscarMesero(1));
//
//pedido.setFecha(LocalDate.of(2023, 10, 25));
//pedido.setEstado(true);
//pedido.setImporte(900.50);
//String hora = ("19:01:46"); 
//pedido.setHora(Time.valueOf(hora));
//
//pedido.setProducto(pd.buscarProducto(8));
//
//        System.out.println("antes ");
//PedidoData pedidod = new PedidoData();
//        System.out.println("casi");
//pedidod.guardarPedido(pedido);
//
//        System.out.println("agego");
//   }
//    
    //Mesero mesero = new Mesero("pedro","p23","pedro12345", true);
////MeseroData meserod = new MeseroData();
////// guardo los meseros
////
    
    ////                  *** PRUEBA DetallePedidoData *****



//// creo un detalle pedido
//
//DetallePedido detalle = new DetallePedido();
  //      System.out.println("1");

////busco el producto y lo agrego
//
//Producto produ = new Producto();
// System.out.println("2");
//ProductoData pd = new ProductoData();
// System.out.println("3");
//produ = pd.buscarProducto(6);
// System.out.println("4");
//detalle.setProducto(produ);
// System.out.println("5");
//detalle.setCantidad(2);
// System.out.println("6");
//
//DetallePedidoData detalled = new DetallePedidoData();
//System.out.println("7");
//detalled.agregarDetallePedido(detalle);
//System.out.println("8");
    

