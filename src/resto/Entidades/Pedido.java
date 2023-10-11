
package resto.Entidades;



import java.sql.Time;
import java.time.LocalDate;
import  java.time.LocalDateTime;

public class Pedido {
    private int idPedido;
    private Mesa mesa;
    private Mesero mesero;
    private Producto producto;
    private DetallePedido detallepedido;
    private LocalDate fecha;
    private Time hora;
    private boolean estado;
    private double importe;

    public Pedido(int idPedido, Mesa mesa, Mesero mesero, Producto producto, DetallePedido detallepedido, LocalDate fecha, Time hora, boolean estado, double importe) {
        this.idPedido = idPedido;
        this.mesa = mesa;
        this.mesero = mesero;
        this.producto = producto;
        this.detallepedido = detallepedido;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.importe = importe;
    }

    public Pedido(Mesa mesa, Mesero mesero, Producto producto, DetallePedido detallepedido, LocalDate fecha, Time hora, boolean estado, double importe) {
        this.mesa = mesa;
        this.mesero = mesero;
        this.producto = producto;
        this.detallepedido = detallepedido;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.importe = importe;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

 

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public DetallePedido getDetallepedido() {
        return detallepedido;
    }

    public void setDetallepedido(DetallePedido detallepedido) {
        this.detallepedido = detallepedido;
    }
    
    
    

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", mesa=" + mesa + ", mesero=" + mesero + ", producto=" + producto + ", fecha=" + fecha + ", hora=" + hora + ", estado=" + estado + ", importe=" + importe + '}';
    }

    

    
    
    
    
}
