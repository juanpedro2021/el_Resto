
package resto.Entidades;



import  java.time.LocalDateTime;

public class Pedido {
    private int idPedido;
    private Mesa mesa;
    private Mesero mesero;
    private Producto producto;
    private LocalDateTime fecha;
    private int estado;

    public Pedido(int idPedido, Mesa mesa, Mesero mesero, Producto producto, LocalDateTime fecha, int estado) {
        this.idPedido = idPedido;
        this.mesa = mesa;
        this.mesero = mesero;
        this.producto = producto;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Pedido(Mesa mesa, Mesero mesero, Producto producto, LocalDateTime fecha, int estado) {
        this.mesa = mesa;
        this.mesero = mesero;
        this.producto = producto;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Pedido() {
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", mesa=" + mesa + ", mesero=" + mesero + ", producto=" + producto + ", fecha=" + fecha + ", estado=" + estado + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
