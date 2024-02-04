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
		controlador.getHuespedes();
		
		/*pdte*/
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
		controlador.getHabitaciones();
		/*pdte*/
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
		controlador.getReservas(huesped);
	}
	
	private void listarReservas (TipoHabitacion tipoHabitacion) {
		controlador.getReservas(tipoHabitacion);
	}

	private Reserva [] getReservasAnulables (Reserva [] reservasAAnular) {
		
		boolean reservasAnulables=false;
		int contador=0;
		Reserva [] nuevoArray=new Reserva[reservasAAnular.length];
		
		 for (int i=0; i<reservasAAnular.length;i++) {
			 if (reservasAAnular[i].getFechaInicioReserva().isAfter(LocalDate.now())) {
				 reservasAnulables=true;
				 nuevoArray[contador]=reservasAAnular[i];
				 contador++;
			   }
		 }
		 
		 if (reservasAnulables==true) {return nuevoArray;
		 }else {return null;}
		 
	}
	
	private void anularReserva() {
		
		int contador=0;
		Reserva [] nuevoArray1=null;
		Reserva [] nuevoArray2=new Reserva[getReservasAnulables (controlador.getReservas(Consola.getHuespedPorDni())).length];
		
		nuevoArray1=getReservasAnulables (controlador.getReservas(Consola.getHuespedPorDni()));
		
		for(int i=0;i<nuevoArray1.length;i++) {
			if(nuevoArray1[i]!=null) {contador++;
				nuevoArray2[contador]=nuevoArray1[i];
				}else{System.out.println("vacio");}
		}
	
		switch (contador){
			
			case 0:
				System.out.println("No existen reservas");
				break;
				
			case 1:
				for(int i=0;i<nuevoArray2.length;i++) {nuevoArray2[i]=null;}
				break;
				
			case 2,3,4,5,6,7,8:
				
				int reservaAborrar=0;
				System.out.println("Elige cual de las reservas siguientes quieres borrar borrar");
				int contadornuevo=0;
				for(int i=0;i<nuevoArray2.length;i++) {
					contador++;
					System.out.println("Reserva numero"+contadornuevo+nuevoArray2[i]);}
				reservaAborrar=Entrada.entero();
				nuevoArray2[reservaAborrar]=null;
				break;
				
			default:
				throw new IllegalArgumentException("el numero es incorrecto");
		}}
	
	
	private void mostrarReservas() {
		controlador.getReservas();
	}
	
	private Habitacion consultarDisponiblidad (TipoHabitacion tipoHabitacion, LocalDate fechaInicioReserva, LocalDate fechaFinReserva){
		Reserva [] nuevoArray=controlador.getReservas(tipoHabitacion);
		boolean habitacionesLibres=false;
		Habitacion habitacionDisponible=null;
		
		for (int i=0;i<nuevoArray.length;i++) {
			
			if(nuevoArray[i].getFechaFinReserva().isBefore(fechaInicioReserva)
					&& nuevoArray[i].getFechaFinReserva().isBefore(fechaFinReserva))
			{habitacionesLibres=true; habitacionDisponible=nuevoArray[i].getHabitacion();
			}else {System.out.println("No libre");}
			}
		
		if (habitacionesLibres=true){return habitacionDisponible; }else {return null;}
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
