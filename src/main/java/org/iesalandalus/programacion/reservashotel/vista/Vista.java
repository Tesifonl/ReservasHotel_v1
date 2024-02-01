package org.iesalandalus.programacion.reservashotel.vista;

import java.time.LocalDate;

import javax.naming.OperationNotSupportedException;


import org.iesalandalus.programacion.reservashotel.controlador.Controlador;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.TipoHabitacion;

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
		controlador.insertar(Consola.leerHuesped());
	}
	
	private void buscarHuesped() {
		controlador.buscar(Consola.getHuespedPorDni());
	}
	
	private void borrarHuesped() {
		controlador.borrar(Consola.getHuespedPorDni());
	}
	
	private void mostrarHuespedes() {
		controlador.getHuespedes();
	}
	
	private void insertarHabitacion() {
		controlador.insertar(Consola.leerHabitacion());
	}
	
	private void buscarHabitacion() {
		controlador.buscar(Consola.leerHabitacionPorIdentificador());
	}
	
	private void borrarHabitacion() {
		controlador.borrar(Consola.leerHabitacionPorIdentificador());
	}
	
	private void mostrarHabitaciones() {
		controlador.getHabitaciones();
	}
	
	private void insertarReserva() {
		controlador.insertar(Consola.leerReserva());
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
		Reserva [] nuevoArray=null;
		
		 for (int i=0; i<reservasAAnular.length;i++) {
			 if (reservasAAnular[i].getFechaInicioReserva().isBefore(LocalDate.now())) {
				 reservasAnulables=true;
				 contador++;
				 nuevoArray=new Reserva[contador];
			 }else { System.out.println("No existen reservas");}
		 }
		 
		 if (reservasAnulables=true) {return nuevoArray;
		 }else {return null;}
		 
	}
	
	private void anularReserva() {
		
		int contador=0;
		Reserva [] nuevoArray=null;
		
		nuevoArray=getReservasAnulables (controlador.getReservas(Consola.getHuespedPorDni()));
		
		for(int i=0;i<nuevoArray.length;i++) {
			if(nuevoArray[i]!=null)
		}
		
		/*voy por aqui*/
		
	}
	
	private void mostrarReservas() {}
	
	private Habitacion (TipoHabitacion tipoHabitacion, LocalDate fechaInicioReserva, LocalDate fechaFinReserva){
		return.tipoHabitacion/*mal*/}
	
	private int getNumElementosNonulos(Reserva [] reservas) {
		return.int/*mal*/
	}
	
	private void realizarChechin() {}
	
	private void realizarChechout() {}
	
}
