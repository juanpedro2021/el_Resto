package packLoginete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import resto.AccesoDatos.Conexion;


public class LogineteeData {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn= new Conexion(); 
    
    
    public Loginetee log(String user, String password){
        Loginetee lo= new Loginetee();
        String sql= "SELECT * FROM mesero WHERE user=? and password=?"; 
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){
                lo.setIdMesero(rs.getInt("idMesero"));
                lo.setNombre(rs.getString("nombre"));
                lo.setUser(rs.getString("user"));
                lo.setPassword(rs.getString("password"));
                
            }
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lo;
        
 
}
}
