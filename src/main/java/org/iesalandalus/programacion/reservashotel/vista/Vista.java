package org.iesalandalus.programacion.reservashotel.vista;

import java.time.LocalDate;

import javax.naming.OperationNotSupportedException;


import org.iesalandalus.programacion.reservashotel.controlador.Controlador;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.TipoHabitacion;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Vista {
	
	private Controlador controlador;
	private Opcion opcion;
	
	public void setControlador(Controlador controlador) {
		if(controlador!=null) {this.controlador=controlador;
		}else {throw new NullPointerException("ERROR: No con un contralador nulo");}
	}
	
	public void comenzar() {
		
		do {
			Consola.mostrarMenu();
			ejecutarOpcion(Consola.elegirOpcion());
		}while (!opcion.equals(Opcion.SALIR));
		
	}
	
	public void terminar() {
		System.out.println("Gracias");
	}
	
	private void ejecutarOpcion(Opcion opicion) {
		
		try {
			switch (opcion) {
		
			case INSERTAR_HUESPED: {
				insertarHuesped();
				}break;

			case BUSCAR_HUESPED: {
				buscarHuesped();
			}break;
			
			case BORRAR_HUESPED: {
				borrarHuesped();
			}break;
			
			case MOSTRAR_HUESPEDES: {
				mostrarHuespedes();
			}break;
			
			case INSERTAR_HABITACION: {
				insertarHabitacion();
			}break;
			
			case BUSCAR_HABITACION: {
				buscarHabitacion();
			}break;
			
			case BORRAR_HABITACION: {
				borrarHabitacion();
			}break;
			
			case MOSTRAR_HABITACIONES: {
				mostrarHabitaciones();
			}break;
			
			case INSERTAR_RESERVA : {
				insertarReserva();
			}break;
			
			case ANULAR_RESERVA : {
				anularReserva();
			}break;
			
			case MOSTRAR_RESERVAS : {
				mostrarReservas();
			}break;	
			
			case CONSULTAR_DISPONIBILIDAD : {
			}break;	
			
			case REALIZAR_CHECKIN : {
				realizarChechin();
			}break;	
			
			case REALIZAR_CHECKOUT: {
				realizarChechout();
			}break;
			
			case SALIR: {
				break;
			}
			default: {
				System.out.println("Opción incorrecta");
			}
		}
	}
	catch (Exception ex) {
		System.out.println(ex.getMessage());
	}
}
	
	
	private void insertarHuesped() throws OperationNotSupportedException {
		try {
			controlador.insertar(Consola.leerHuesped());
		}
		catch(OperationNotSupportedException e){
			System.out.println(e.getMessage());
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());
		}
	}
	
	private void buscarHuesped() {
		try {
			controlador.buscar(Consola.getHuespedPorDni());
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());
		}
	}
	
	private void borrarHuesped() {
		try {
			controlador.borrar(Consola.getHuespedPorDni());
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());
		}
	}
	
	private void mostrarHuespedes() {
		int contador=0;
		
		for (int i=0;i<controlador.getHuespedes().length;i++) {
			if (controlador.getHuespedes()[i]!=null) {
				contador++;}
			}
		if(contador>0) {
			for (int i=0;i<controlador.getHuespedes().length;i++)
				System.out.println(controlador.getHuespedes()[i]);
		}
		else {
			System.out.println("No hay ningun huesped");
		} 
		}
			
	
	private void insertarHabitacion() {
		try {
			controlador.insertar(Consola.leerHabitacion());
		}
		catch(OperationNotSupportedException e){
			System.out.println(e.getMessage());
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());}
		}
	}
	
	private void buscarHabitacion() {
		try {	
			controlador.buscar(Consola.leerHabitacionPorIdentificador());
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());}
	}
	
	private void borrarHabitacion() {
		try {
			controlador.borrar(Consola.leerHabitacionPorIdentificador());
		}
		catch(OperationNotSupportedException e){
			System.out.println(e.getMessage());
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());}
	}
	
	
	private void mostrarHabitaciones() {
	
		int contador=0;
		
		for (int i=0;i<controlador.getHabitaciones().length;i++) {
			if (controlador.getHabitaciones()[i]!=null) {
				contador++;}
			}
		if(contador>0) {
			for (int i=0;i<controlador.getHabitaciones().length;i++)
				System.out.println(controlador.getHabitaciones()[i]);
		}
		else {
			System.out.println("No hay ninguna habitacion");
		} 
	}
	
	private void insertarReserva() {
		try {
			controlador.insertar(Consola.leerReserva());
		}
		catch(OperationNotSupportedException e){
			System.out.println(e.getMessage());
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());}
	}
	
	
	private void listarReservas(Huesped huesped) {
		Reserva[] nuevoArray = controlador.getReservas(huesped);
		
		if (nuevoArray!=null) {
			for (int i=0;i<nuevoArray.length;i++) {
				System.out.println(nuevoArray[i]);
			}
		}else {
			System.out.println("No existen reservas para este huesped.");
		}
	}
	
	private void listarReservas (TipoHabitacion tipoHabitacion) {
		
		Reserva[] nuevoArray = controlador.getReservas(tipoHabitacion);
		
		if (nuevoArray!=null) {
			for (int i=0;i<nuevoArray.length;i++) {
				System.out.println(nuevoArray[i]);
			}
		}else {
			System.out.println("No existen reservas para este tipo de habitacion.");
		}
	}

	private Reserva [] getReservasAnulables (Reserva [] reservasAAnular) {
		
		boolean reservasAnulables=false;
		int posicion=0;
		Reserva [] nuevoArray=new Reserva[reservasAAnular.length];
		
		 for (int i=0; i<reservasAAnular.length;i++) {
			 if (reservasAAnular[i].getFechaInicioReserva().isAfter(LocalDate.now())) {
				 reservasAnulables=true;
				 nuevoArray[posicion]=reservasAAnular[i];
				 posicion++;
			   }
		 }
		 
		 if (reservasAnulables==true) {return nuevoArray;
		 }else {return null;}
		 
	}
	
	private void anularReserva() {
		Reserva [] nuevoArray1=controlador.getReservas(Consola.getHuespedPorDni());
		
		if (nuevoArray1.length > 0) {	
			Reserva [] nuevoArray2=getReservasAnulables(nuevoArray1);
			
			if (nuevoArray2.length > 0) {
				for (int i=0;i<nuevoArray2.length;i++) {
					if (nuevoArray2[i]!=null) {
						controlador.borrar(nuevoArray2[i]);
					}
				}
			}
			else {
				System.out.println("No existe ninguna reserva anulable para este huesped");
			}
		}
	}
	
	
	private void mostrarReservas() {
		int contador=0;
		
		for (int i=0;i<controlador.getReservas().length;i++) {
			if (controlador.getReservas()[i]!=null) {
				contador++;}
			}
		if(contador>0) {
			for (int i=0;i<controlador.getReservas().length;i++)
				System.out.println(controlador.getReservas()[i]);
		}
		else {
			System.out.println("No hay ninguna habitacion");
		} 
	}
	
	private Habitacion consultarDisponiblidad (TipoHabitacion tipoHabitacion, LocalDate fechaInicioReserva, LocalDate fechaFinReserva){
		
		Reserva [] nuevoArray=controlador.getReservas(tipoHabitacion);
		boolean habitacionesLibres=false;
		Habitacion habitacionDisponible=null;
		
		for (int i=0;i<nuevoArray.length;i++) {
			if(nuevoArray[i].getFechaFinReserva().isBefore(fechaInicioReserva)
				&& nuevoArray[i].getFechaFinReserva().isBefore(fechaFinReserva)){
				habitacionesLibres=true; habitacionDisponible=nuevoArray[i].getHabitacion();
			}else {System.out.println("No libre");}
			}
		
		if (habitacionesLibres=true){
			return habitacionDisponible; 
			}else {
				return null;}
		}
	
	
	private void realizarChechin() {
		Reserva [] nuevoArray= controlador.getReservas(Consola.leerHuesped());
		boolean reservasAcheckin=false;
		
		/*for (int i=0;i<nuevoArray.length;i++) {
			if (nuevoArray[i].getFechaInicioReserva()) {}else {}
		}*/
			
			
		controlador.realizarCheckin(null, null);;
	}
	
	private void realizarChechout() {
		controlador.realizarCheckout(null, null);
	}
	
}
