
package resto.Entidades;


public class Mesa {
    private int idMesa;
    private int numMesa;
    private int capacidad;
    private int estado ;

    public Mesa(int idMesa, int numMesa, int capacidad, int estado) {
        this.idMesa = idMesa;
        this.numMesa = numMesa;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public Mesa(int numMesa, int capacidad, int estado) {
        this.numMesa = numMesa;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public Mesa() {
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Mesa{" + "idMesa=" + idMesa + ", numMesa=" + numMesa + ", capacidad=" + capacidad + ", estado=" + estado + '}';
    }
    
    

}
