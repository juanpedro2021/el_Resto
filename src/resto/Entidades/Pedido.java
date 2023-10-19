
package resto.Entidades;



import java.sql.Time;
import java.time.LocalDate;

public class Pedido {
    private int idPedido;
    private Mesa mesa;
    private Mesero mesero;
    private LocalDate fecha;
    private Time hora;
    private boolean estado;
    private double importe;

    public Pedido(int idPedido, Mesa mesa, Mesero mesero,LocalDate fecha, Time hora, boolean estado, double importe) {
        this.idPedido = idPedido;
        this.mesa = mesa;
        this.mesero = mesero;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.importe = importe;
    }

    public Pedido(Mesa mesa, Mesero mesero, LocalDate fecha, Time hora, boolean estado, double importe) {
        this.mesa = mesa;
        this.mesero = mesero;
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

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", mesa=" + mesa + ", mesero=" + mesero + ", fecha=" + fecha + ", hora=" + hora + ", estado=" + estado + ", importe=" + importe + '}';
    }

   


}
