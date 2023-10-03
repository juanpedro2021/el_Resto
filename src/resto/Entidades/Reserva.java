/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resto.Entidades;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Mati Lafor
 */
public class Reserva {
    private int idReserva;
    private int idMesa;
    private String nombre;
    private int DNI;
    private LocalDateTime fecha;
    private int estado;


    public Reserva (int idReserva, int idMesa, String nombre, int DNI, LocalDateTime fecha, int estado){
        this.idReserva = idReserva;
        this.idMesa = idMesa;
        this.nombre = nombre;
        this.DNI = DNI;
        this.fecha = fecha;
        this.estado = estado;
    }
    
    public Reserva (int idMesa, String nombre, int DNI, LocalDateTime fecha, int estado){
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
        return "Reserva{" + "idReserva=" + idReserva + ", idMesa=" + idMesa + ", nombre=" + nombre + ", DNI=" + DNI + ", fecha=" + fecha + ", estado=" + estado + '}';
    }

}