/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import resto.AccesoDatos.MeseroData;
import resto.Entidades.Mesero;

/**
 *
 * @author lau-d
 */
public class PruebaMesero {
     public static void main(String[] args){
         

////creo meseros
//
//Mesero mesero = new Mesero("pepe","pepe23","2023", true);
//
//Mesero mesero2 = new Mesero("pedro","p23","pedro12345", true);
//

MeseroData meserod = new MeseroData();
// //guardo los meseros
//
//meserod.guardarMesero(mesero);
//meserod.guardarMesero(mesero2);
//
//// elimino mesero
//
//meserod.eliminarMesero(3);
//
// //modifico un mesero
//
//Mesero mesero3 = new Mesero(3,"pepe","pepe23","2023",false);
//
//meserod.modificarMesero(mesero3);

//pruebo buscar mesero

Mesero mesero4 = new Mesero();

mesero4=meserod.buscarMesero(1);
        System.out.println("" + mesero4.toString());




     }
}
