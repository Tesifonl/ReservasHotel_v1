package org.iesalandalus.programacion.reservashotel;

import java.time.LocalDate;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.dominio.TipoHabitacion;
import org.iesalandalus.programacion.reservashotel.negocio.Habitaciones;
import org.iesalandalus.programacion.reservashotel.negocio.Huespedes;
import org.iesalandalus.programacion.reservashotel.negocio.Reservas;
import org.iesalandalus.programacion.reservashotel.vista.Consola;
import org.iesalandalus.programacion.reservashotel.vista.Opcion;

public class MainApp {
    
	public static final int CAPACIDAD=100;
	public Huespedes huespedes;
	public Habitaciones habitaciones;
	public Reservas reservas;
	


    public static void main(String[] args) throws OperationNotSupportedException {
    	
		Huespedes huespedes=new Huespedes(CAPACIDAD);
		Habitaciones habitaciones=new Habitaciones(CAPACIDAD);
		Reservas reservas=new Reservas(CAPACIDAD);
		
		
		
		Consola.mostrarMenu();
		Opcion opcion=ejecutarOpcion(Consola.elegirOpcion());
		
		do {
			
		if (opcion.equals(Opcion.INSERTAR_HUESPED)) {
			try{huespedes.insertar(Consola.leerHuesped());}
				catch(OperationNotSupportedException e){
				System.out.println(e.getMessage());}
				catch(NullPointerException e){
				System.out.println(e.getMessage());}}
		
		if (opcion.equals(Opcion.BUSCAR_HUESPED)) {
			try{huespedes.buscar(Consola.getHuespedPorDni());}
			catch(NullPointerException e){
			System.out.println(e.getMessage());}}
		
		if (opcion.equals(Opcion.BORRAR_HUESPED)) {
			try{huespedes.borrar(Consola.getHuespedPorDni());}
			catch(OperationNotSupportedException e){
			System.out.println(e.getMessage());}
			catch(NullPointerException e){
			System.out.println(e.getMessage());}}
		
		if (opcion.equals(Opcion.MOSTRAR_HUESPEDES)) {
			if(huespedes.getTamano()>0) {System.out.println(huespedes.get());}
			else {System.out.println("No hay ningun huesped");} }
		
		if (opcion.equals(Opcion.INSERTAR_HABITACION)) {habitaciones.insertar(Consola.leerHabitacion());}
		if (opcion.equals(Opcion.BUSCAR_HABITACION)) {habitaciones.buscar(Consola.leerHabitacionPorIdentificador());}
		if (opcion.equals(Opcion.BORRAR_HABITACION)) {habitaciones.borrar(Consola.leerHabitacionPorIdentificador());}
		if (opcion.equals(Opcion.MOSTRAR_HABITACIONES)) {habitaciones.get();}
		if (opcion.equals(Opcion.INSERTAR_RESERVA)) {reservas.insertar(Consola.leerReserva());}
		if (opcion.equals(Opcion.ANULAR_RESERVA)) {reservas.getReservas(Consola.getHuespedPorDni());}
		if (opcion.equals(Opcion.MOSTRAR_RESERVAS)) {reservas.get();}
		if (opcion.equals(Opcion.CONSULTAR_DISPONIBILIDAD)) {reservas.getReservas(Consola.leerTipoHabitacion());}
		} while(opcion.equals(Opcion.SALIR));
	
    }

	private static Opcion ejecutarOpcion(Opcion opcion) throws OperationNotSupportedException{
		return opcion;
	}

	
}
