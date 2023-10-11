/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.AccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
      private static final String URL="jdbc:mariadb://localhost/";
    private static final String DB="elresto_";
    private static final String USUARIO="root";
    private static final String PASSWORD="";
    
    private static Connection connection;
    
    //contructor
    public Conexion(){}
    
    //metodo getConection
    
    public static Connection getConexion(){
        try{
        if (connection==null) {
            Class.forName("org.mariadb.jdbc.Driver");
            //creo la conexion con la base de datos
            
            connection = DriverManager.getConnection(URL+DB + 
                    "?useLegacyDatetimecode=false&serverTimezone-UTC"+ "&user=" 
                    + USUARIO + "&password=" + PASSWORD) ;
             JOptionPane.showMessageDialog(null, "Se conecto correctamente");
        }
        } catch (ClassNotFoundException ex) {
          JOptionPane.showMessageDialog(null, "error a cargar driver = " + ex.getLocalizedMessage());
            
        } catch (SQLException co) {
            JOptionPane.showMessageDialog(null, "error de conexion = " + co.getLocalizedMessage());
            
        }
       
        
        return connection;
    }
}
