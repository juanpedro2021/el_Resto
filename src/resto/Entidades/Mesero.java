
package resto.Entidades;


public class Mesero {
    private int idMesero;
    private String nombre;
    private String user;
    private String password;
    private Boolean estado;

    public Mesero() {
    }

    public Mesero(int idMesero, String nombre, String user, String password, Boolean estado) {
        this.idMesero = idMesero;
        this.nombre = nombre;
        this.user = user;
        this.password = password;
        this.estado = estado;
    }

    public Mesero(String nombre, String user, String password,Boolean estado) {

        this.nombre = nombre;
        this.user = user;
        this.password = password;
        this. estado = estado;
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


    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String toString() {
        return "Mesero{" + "idMesero=" + idMesero + ", nombre=" + nombre + ", user=" + user + ", password=" + password + ", estado=" + estado + '}';
    }
  
    
    
   
    

    
    
    
    
    
}