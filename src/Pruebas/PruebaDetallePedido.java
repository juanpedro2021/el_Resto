/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import resto.AccesoDatos.DetallePedidoData;
import resto.AccesoDatos.PedidoData;
import resto.AccesoDatos.ProductoData;
import resto.Entidades.DetallePedido;
import resto.Entidades.Pedido;
import resto.Entidades.Producto;

/**
 *
 * @author lau-d
 */
public class PruebaDetallePedido {
     public static void main(String[] args){
     DetallePedido detallep = new DetallePedido();
     DetallePedido detallep2 = new DetallePedido();
     DetallePedido detallep3 = new DetallePedido();
     DetallePedidoData detalled = new DetallePedidoData();
     ProductoData pd = new ProductoData();
     Producto producto = new Producto();
     PedidoData pedidod = new PedidoData();
     Pedido pedido = new Pedido();
         //creo un pedido
pedido = pedidod.buscarPedido(7);


producto = pd.buscarProducto(8);
detallep.setProducto(producto);
detallep.setCantidad(2);
detallep.setPedido(pedido);
        // System.out.println(""+detallep.toString());
         
//agrego un detalle pedio     

//detalled.agregarDetallePedido(detallep);

// elimino un detalle

//detalled.eliminarDetallePedido(2);

//modifico 
       
//pedido = pedidod.buscarPedido(7);
//
//producto = pd.buscarProducto(8);
//detallep2.setProducto(producto);
//detallep2.setCantidad(3);
//detallep2.setPedido(pedido); 

// busco un detalle
        
detallep3= detalled.buscarDetalle(3);
         System.out.println("" + detallep3.toString());
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
     }
}
