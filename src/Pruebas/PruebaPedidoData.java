/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import resto.AccesoDatos.MesaData;
import resto.AccesoDatos.MeseroData;
import resto.AccesoDatos.PedidoData;
import resto.AccesoDatos.ProductoData;
import resto.Entidades.Pedido;

/**
 *
 * @author lau-d
 */
public class PruebaPedidoData {
     public static void main(String[] args){
         
MesaData md = new MesaData();
MeseroData meserod = new MeseroData();
ProductoData pd = new ProductoData();

Pedido pedido=new Pedido();
Pedido pedido2 = new Pedido();
Pedido pedido3 = new Pedido();
Pedido pedido4 = new Pedido();
Pedido pedido5 = new Pedido();
PedidoData pedidod = new PedidoData();

//creo un pedido

//pedido.setMesa(md.buscarMesa(2));
//pedido.setMesero(meserod.buscarMesero(1));
//
//pedido.setFecha(LocalDate.of(2023, 10, 30));
//pedido.setEstado(true);
//pedido.setImporte(900.50);
//String hora = ("19:01:46"); 
//pedido.setHora(Time.valueOf(hora));
//
//pedido.setProducto(pd.buscarProducto(8));
//
//// creo otro pedido
//
//pedido2.setMesa(md.buscarMesa(3));
//pedido2.setMesero(meserod.buscarMesero(1));
//
//pedido2.setFecha(LocalDate.of(2023, 10, 30));
//pedido2.setEstado(true);
//pedido2.setImporte(8000.20);
//String hora2 = ("20:15:00"); 
//pedido2.setHora(Time.valueOf(hora2));
//
//pedido2.setProducto(pd.buscarProducto(7));
//
////creo otro pedido
//
//pedido3.setMesa(md.buscarMesa(2));
//pedido3.setMesero(meserod.buscarMesero(1));
//
//pedido3.setFecha(LocalDate.of(2023, 10, 30));
//pedido3.setEstado(true);
//pedido3.setImporte(80.20);
//String hora3 = ("20:30:00"); 
//pedido3.setHora(Time.valueOf(hora3));
//
//pedido3.setProducto(pd.buscarProducto(7));
//
//
//         System.out.println("1");
//pedidod.guardarPedido(pedido);
//System.out.println("2");
//pedidod.guardarPedido(pedido2);
//System.out.println("3");
//pedidod.guardarPedido(pedido3);

//elimino un pedido EL PEDIDO 9

//pedidod.eliminarPedido(9);


//// modifico el estado de el pedido 9
//
//pedido4.setIdPedido(9);
//pedido4.setMesa(md.buscarMesa(2));
//pedido4.setMesero(meserod.buscarMesero(1));
//
//pedido4.setFecha(LocalDate.of(2023, 10, 30));
//pedido4.setEstado(true);
//pedido4.setImporte(80.20);
//String hora4 = ("20:30:00"); 
//pedido4.setHora(Time.valueOf(hora4));
//
//pedido4.setProducto(pd.buscarProducto(9));
//
//pedidod.modificarPedido(pedido4);

       
//listo todos los pedidos

//List<Pedido> listadoPedidos = new ArrayList<>();
//
//listadoPedidos = pedidod.listarPedidos();
//
//for(Pedido pe :listadoPedidos ){
// 
//    System.out.println(""+pe.toString());
//    }

// busco el pedido con el id 7

//        pedido5 = pedidod.buscarPedido(7);
//         System.out.println(""+pedido5.toString());


// listos todos los pedidos de un mesero con el id 1

//List<Pedido> listadoPedidosMesero = new ArrayList<>();
//
//listadoPedidosMesero = pedidod.listarPedidoPorIdMesero(1);
//
//for(Pedido pe :listadoPedidosMesero ){
// 
//    System.out.println(""+pe.toString());
//    }

//listar ingresos por fecha

//List<Pedido> listadoIngresoPorFecha1 = new ArrayList<>();
//
//LocalDate fecha =LocalDate.of(2023, 10, 30);
//
//listadoIngresoPorFecha1 = pedidod.listarIngresosPorFecha(fecha);
//
//for(Pedido pe :listadoIngresoPorFecha1 ){
// 
//    System.out.println(""+pe.toString());
//    }

//listo los pedidos cobrados en un dia

//List<Pedido> listado = new ArrayList<>();
//
//LocalDate fecha =LocalDate.of(2023, 10, 30);
//
//listado = pedidod.listarPedidosCobradosPorMeseroEnDia(1,fecha);
//
//for(Pedido pe :listado ){
// 
//    System.out.println(""+pe.toString());
//    }


//

//        List<Pedido> listado = new ArrayList<>();
//String hora5 = ("18:30:00");
//Time inicio=Time.valueOf(hora5);
//
//String hora6 = ("21:00:00");
//Time fin=Time.valueOf(hora5);
//
//listado = pedidod.listarPedidosMesaEntreHoras(1,inicio,fin);
//
//for(Pedido pe :listado ){
// 
//    System.out.println(""+pe.toString());
//    }
   }
     }
