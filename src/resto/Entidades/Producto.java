
package resto.Entidades;


public class Producto {
     private int idProducto;
    private boolean estado;
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(int idProducto, boolean estado, String nombre, int cantidad, double precio) {
        this.idProducto = idProducto;
        this.estado = estado;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Producto(boolean estado, String nombre, int cantidad, double precio) {
        this.estado = estado;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Producto() {
    }

    public int getidProducto() {
        return idProducto;
    }

    public void setidProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", estado=" + estado + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }

 
    
}
