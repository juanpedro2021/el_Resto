/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resto.Entidades;

import java.time.LocalDate;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author Mati Lafor
 */
public class Reserva {
    private int idReserva;
    private int idMesa;
    private String nombre;
    private int DNI;
    private Timestamp fecha;
    private boolean estado;


    public Reserva (int idReserva, int idMesa, String nombre, int DNI, Timestamp fecha, boolean estado){
        this.idReserva = idReserva;
        this.idMesa = idMesa;
        this.nombre = nombre;
        this.DNI = DNI;
        this.fecha = fecha;
        this.estado = estado;
    }
    
    public Reserva (int idMesa, String nombre, int DNI, Timestamp fecha, boolean estado){
        this.idMesa = idMesa;
        this.nombre = nombre;
        this.DNI = DNI;
        this.fecha = fecha;
        this.estado = estado;
    }
    
    public Reserva (){
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    
    
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

  

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", idMesa=" + idMesa + ", nombre=" + nombre + ", DNI=" + DNI + ", fecha=" + fecha + ", estado=" + estado + '}';
    }

}