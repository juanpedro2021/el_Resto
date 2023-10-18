
package resto.Entidades;

public class DetallePedido {
    private int idDtallePedido;
    private Pedido pedido;
    private Producto producto;
    private int cantidad;

    public DetallePedido(int idDtallePedido, Pedido pedido, Producto producto, int cantidad) {
        this.idDtallePedido = idDtallePedido;
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public DetallePedido(Pedido pedido, Producto producto, int cantidad) {
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public DetallePedido() {
    }

    public int getIdDtallePedido() {
        return idDtallePedido;
    }

    public void setIdDtallePedido(int idDtallePedido) {
        this.idDtallePedido = idDtallePedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DetallePedido{" + "idDtallePedido=" + idDtallePedido + ", pedido=" + pedido + ", producto=" + producto + ", cantidad=" + cantidad + '}';
    }

   
 
}
