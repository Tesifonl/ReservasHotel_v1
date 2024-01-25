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
		Opcion opcion=Consola.elegirOpcion();
		
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
		
		if (opcion.equals(Opcion.INSERTAR_HABITACION)) {
			try{habitaciones.insertar(Consola.leerHabitacion());}
			catch(OperationNotSupportedException e){
				System.out.println(e.getMessage());}
				catch(NullPointerException e){
				System.out.println(e.getMessage());}}
		
		if (opcion.equals(Opcion.BUSCAR_HABITACION)) {
			try{habitaciones.buscar(Consola.leerHabitacionPorIdentificador());}
			catch(NullPointerException e){
			System.out.println(e.getMessage());}}
			
		if (opcion.equals(Opcion.BORRAR_HABITACION)) {
			try{habitaciones.borrar(Consola.leerHabitacionPorIdentificador());}
			catch(OperationNotSupportedException e){
			System.out.println(e.getMessage());}
			catch(NullPointerException e){
			System.out.println(e.getMessage());}}		
		
		if (opcion.equals(Opcion.MOSTRAR_HABITACIONES)) {
			if(habitaciones.getTamano()>0) {habitaciones.get();}
			else {System.out.println("No hay ningun huesped");} }
		
		if (opcion.equals(Opcion.INSERTAR_RESERVA)) {
			try{reservas.insertar(Consola.leerReserva());}
			catch(OperationNotSupportedException e){
			System.out.println(e.getMessage());}
			catch(NullPointerException e){
			System.out.println(e.getMessage());}}
		
		if (opcion.equals(Opcion.ANULAR_RESERVA)) {

			Reserva [] reservaHuesped=reservas.getReservas(Consola.getHuespedPorDni());
			for (int i=0;i<reservaHuesped.length;i++)
			if (reservaHuesped[i]!=null) {
				reservaHuesped[i]=null;
				System.out.println("Procedemos a anular todas las reservas del huesped");
			}else {System.out.println("No existe ninguna reserva anulable para este huesped");}}

			
		if (opcion.equals(Opcion.MOSTRAR_RESERVAS)) {
			if(reservas.getTamano()>=1) {reservas.get();}
			else {System.out.println("No hay reservas");}}
		
		
		if (opcion.equals(Opcion.CONSULTAR_DISPONIBILIDAD)) {reservas.getReservas(Consola.leerTipoHabitacion());}
		
		
		} while(opcion!=Opcion.SALIR);
		}}
	


