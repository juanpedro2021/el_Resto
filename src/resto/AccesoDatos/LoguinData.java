/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.AccesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import resto.Entidades.Mesero;


public class LoguinData {
      private Connection con=null;
      ResultSet rs;

    public LoguinData() {
        con= Conexion.getConexion();
    }
    
    public Mesero login (String user, String password){
        Mesero lo = new Mesero();
        String sql= "SELECT * FROM mesero WHERE user=? and password=?"; 
        try {
            PreparedStatement ps = con.prepareStatement (sql);
            ps.setString(1, user);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            if(rs.next()){
                lo.setIdMesero(rs.getInt("idMesero"));
                lo.setNombre(rs.getString("nombre"));
                lo.setUser(rs.getString("user"));
                lo.setPassword(rs.getString("password"));
                lo.setEstado(rs.getBoolean("estado"));
                
            }
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lo;
}
  public boolean validacionJuan (String usuario , String contra){
        MeseroData md = new MeseroData();
        
        boolean correcto = false;
        
        List<Mesero> listadoMeseros = new ArrayList<>();

        listadoMeseros = md.listarUsuario();
        
        for(Mesero me : listadoMeseros){
            if(me.getUser().equals(usuario)){
                if(me.getPassword().equals(contra)){
                    correcto=true;
                    JOptionPane.showMessageDialog(null, "Bienvenido a ");
                    return correcto;
                }else{
                JOptionPane.showMessageDialog(null, "contraseña incorrecta.");
               return correcto = false;
                }
            }else{
            JOptionPane.showMessageDialog(null, "usuario incorrecto");
            }
            
        }
        

        return correcto;
    }   
    
    
}