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
	
	
	private void realizarChechin() {}
	
	private void realizarChechout() {}
	
}
