package org.iesalandalus.programacion.reservashotel.modelo;

import java.time.LocalDateTime;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservashotel.modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.TipoHabitacion;
import org.iesalandalus.programacion.reservashotel.modelo.negocio.Habitaciones;
import org.iesalandalus.programacion.reservashotel.modelo.negocio.Huespedes;
import org.iesalandalus.programacion.reservashotel.modelo.negocio.Reservas;

public class Modelo {
	
	private Huespedes huespedes;
	private Habitaciones habitaciones;
	private Reservas reservas;
	private final int CAPACIDAD=100;
	
	public Modelo() {
		comenzar();
	}

	public void comenzar() {
		huespedes=new Huespedes(CAPACIDAD);
		habitaciones=new Habitaciones(CAPACIDAD);
		reservas=new Reservas(CAPACIDAD);
		
	}
	
	public void terminar() {
		System.out.println("El modelo ha finalizado");
	}
	
	public void insertar(Huesped huesped) throws OperationNotSupportedException {
		try {
			huespedes.insertar(huesped);
			}catch (OperationNotSupportedException ex) {
			System.out.println(ex.getMessage());}
	}
	
	public Huesped buscar(Huesped huesped) {
		return huespedes.buscar(huesped);
	}
	
	public void borrar (Huesped huesped) throws OperationNotSupportedException {
		try {
			huespedes.borrar(huesped);
			}catch (OperationNotSupportedException ex) {
			System.out.println(ex.getMessage());}
		}
	
	public Huesped [] getHuespedes(){
		Huesped [] nuevoArray1=huespedes.get();
		Huesped [] nuevoArray2= new Huesped [CAPACIDAD];
		int contador=0;
		
		for(int i=0;i<nuevoArray1.length;i++) {
		contador++;
		nuevoArray2[contador]=nuevoArray1[i];}
		
		return nuevoArray2;
	}
	
	public void insertar(Habitacion habitacion) throws OperationNotSupportedException {
		try {
			habitaciones.insertar(habitacion);
			}catch (OperationNotSupportedException ex) {
			System.out.println(ex.getMessage());}
	}
	
	public Habitacion buscar(Habitacion habitacion) {
		return habitaciones.buscar(habitacion);
	}
	
	public void borrar (Habitacion habitacion) throws OperationNotSupportedException {
		
		try {
			habitaciones.borrar(habitacion);
			}catch (OperationNotSupportedException ex) {
				System.out.println(ex.getMessage());}
		
	}
	
	public Habitacion [] getHabitaciones(){
		Habitacion [] nuevoArray1=habitaciones.get();
		Habitacion [] nuevoArray2= new Habitacion [CAPACIDAD];
		int contador=0;
		
		for(int i=0;i<nuevoArray1.length;i++) {
		contador++;
		nuevoArray2[contador]=nuevoArray1[i];}
		
		return nuevoArray2;
	}
	
	public Habitacion [] getHabitaciones(TipoHabitacion tipoHabitacion){
		Habitacion [] nuevoArray1=habitaciones.get(tipoHabitacion);
		Habitacion [] nuevoArray2= new Habitacion [CAPACIDAD];
		int contador=0;
		
		for(int i=0;i<nuevoArray1.length;i++) {
		contador++;
		nuevoArray2[contador]=nuevoArray1[i];}
		
		return nuevoArray2;
	}
	
	public void insertar(Reserva reserva) throws OperationNotSupportedException {
		try {
			reservas.insertar(reserva);
			}catch (OperationNotSupportedException ex) {
			System.out.println(ex.getMessage());}
	}
	
	public Reserva buscar(Reserva reserva) {
		return reservas.buscar(reserva);
	}
	
	public void borrar (Reserva reserva) throws OperationNotSupportedException {
		
		try {
			reservas.borrar(reserva);
			}catch (OperationNotSupportedException ex) {
			System.out.println(ex.getMessage());}	
	}
	
	public Reserva [] getReservas(){
		Reserva [] nuevoArray1=reservas.get();
		Reserva [] nuevoArray2= new Reserva [CAPACIDAD];
		int contador=0;
		
		for(int i=0;i<nuevoArray1.length;i++) {
		contador++;
		nuevoArray2[contador]=nuevoArray1[i];}
		
		return nuevoArray2;
	}
	
	public Reserva [] getReservas(Huesped huesped){
		Reserva [] nuevoArray1=reservas.getReservas(huesped);
		Reserva [] nuevoArray2= new Reserva [CAPACIDAD];
		int contador=0;
		
		for(int i=0;i<nuevoArray1.length;i++) {
		contador++;
		nuevoArray2[contador]=nuevoArray1[i];}
		
		return nuevoArray2;
	}
	
	public Reserva [] getReservas(TipoHabitacion tipoHabitacion){
		Reserva [] nuevoArray1=reservas.getReservas(tipoHabitacion);
		Reserva [] nuevoArray2= new Reserva [CAPACIDAD];
		int contador=0;
		
		for(int i=0;i<nuevoArray1.length;i++) {
		contador++;
		nuevoArray2[contador]=nuevoArray1[i];}
		
		return nuevoArray2;
	}
	
	public void realizarCheckin(Reserva reserva, LocalDateTime fecha) throws OperationNotSupportedException {
		if(reserva==null || fecha==null) {
			throw new  OperationNotSupportedException("ERROR: No se puede hacer checkin de una reserva nula o sin fecha");
		}else {reserva.setCheckIn(fecha);}
	}
	
	public void realizarCheckout(Reserva reserva, LocalDateTime fecha) throws OperationNotSupportedException {
		if(reserva==null || fecha==null) {
			throw new  OperationNotSupportedException("ERROR: No se puede hacer checkin de una reserva nula o sin fecha");
		}else {reserva.setCheckOut(fecha);}
	}
}
