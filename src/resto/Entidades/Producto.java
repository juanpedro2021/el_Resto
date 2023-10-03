
package resto.Entidades;


public class Producto {
     private int idProducto;
    private int codigo;
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(int idProducto, int codigo, String nombre, int cantidad, double precio) {
        this.idProducto = idProducto;
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Producto(int codigo, String nombre, int cantidad, double precio) {
        this.codigo = codigo;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
        return "Producto{" + "productoID=" + idProducto + ", codigo=" + codigo + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }
    
    
}
