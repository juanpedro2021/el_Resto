
package packLoginete;


public class Loginetee {
    private int idMesero;
    private String nombre;
    private String user;
    private String password;

    public Loginetee() {
    }

    public Loginetee(int idMesero, String nombre, String user, String password) {
        this.idMesero = idMesero;
        this.nombre = nombre;
        this.user = user;
        this.password = password;
    }

    public int getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(int idMesero) {
        this.idMesero = idMesero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
    
    
}
