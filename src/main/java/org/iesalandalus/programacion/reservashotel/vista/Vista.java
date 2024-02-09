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
	
	public void comenzar() throws OperationNotSupportedException {
		
		do {
			Consola.mostrarMenu();
			ejecutarOpcion(Consola.elegirOpcion());
		}while (!opcion.equals(Opcion.SALIR));
		
	}
	
	public void terminar() {
		System.out.println("Gracias");
	}
	
	private void ejecutarOpcion(Opcion opicion) throws OperationNotSupportedException {
		
		do {
			if(opcion.equals(Opcion.INSERTAR_HUESPED)) {
				insertarHuesped();}

			if(opcion.equals(Opcion.BUSCAR_HUESPED)) {
				buscarHuesped();}
			
			if(opcion.equals(Opcion.BORRAR_HUESPED)) {
				borrarHuesped();}
			
			if(opcion.equals(Opcion.MOSTRAR_HUESPEDES)) {
				mostrarHuespedes();}
			
			if(opcion.equals(Opcion.INSERTAR_HABITACION)) {
				insertarHabitacion();}
			
			if(opcion.equals(Opcion.BUSCAR_HABITACION)) {
				buscarHabitacion();}
			
			if(opcion.equals(Opcion.BORRAR_HABITACION)) {
				borrarHabitacion();}
			
			if(opcion.equals(Opcion.MOSTRAR_HABITACIONES)) {
				mostrarHabitaciones();}
			
			if(opcion.equals(Opcion.INSERTAR_RESERVA)) {
				insertarReserva();}
			
			if(opcion.equals(Opcion.ANULAR_RESERVA)) {
				anularReserva();}
			
			if(opcion.equals(Opcion.MOSTRAR_RESERVAS)) {
				mostrarReservas();}	
			
			if(opcion.equals(Opcion.CONSULTAR_DISPONIBILIDAD)) {
				System.out.println("Introduce el tipo de habitacion");
				TipoHabitacion tipoHabitacion=Consola.leerTipoHabitacion();
				System.out.println("Introduce la fecha de inicio de la reserva");
				String fecha1=Entrada.cadena();
				LocalDate fechaInicioReserva=Consola.leerFecha(fecha1);
				System.out.println("Introduce la fecha de fin de la reserva");
				String fecha2=Entrada.cadena();
				LocalDate fechaFinReserva=Consola.leerFecha(fecha2);
				
				consultarDisponiblidad (tipoHabitacion,fechaInicioReserva,fechaFinReserva);
			}	
			
			if(opcion.equals(Opcion.REALIZAR_CHECKIN)) {
				realizarChechin();}
			
			if(opcion.equals(Opcion.REALIZAR_CHECKOUT)) {
				realizarChechout();}

		}while(opcion!=Opcion.SALIR);
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
		catch(NullPointerException e){
			System.out.println(e.getMessage());}
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
		Reserva reservaAnular=null;
		
		if (nuevoArray1.length > 0) {	
			Reserva [] nuevoArray2=getReservasAnulables(nuevoArray1);
			int contador=0;
			int posicion=0;
			
			if (nuevoArray2.length > 0) {
				for (int i=0;i<nuevoArray2.length;i++) {
						System.out.println("Puede anular la reserva nº"
						+i 
						+"detallada seguidamente"
						+nuevoArray2[i]);
					}
				}
			
			System.out.println("Introduce el numero de reserva a anular");
			posicion=Entrada.entero();
			reservaAnular=nuevoArray2[posicion];
			controlador.borrar(reservaAnular);
			}
			else {
				System.out.println("No existe ninguna reserva anulable para este huesped");
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
		Reserva reservaCheck=null;
		
		int contador=0;
		int posicion=0;
		
		for (int i=0;i<nuevoArray.length;i++) {
			if (nuevoArray!=null) {
				contador++;}

		if (contador>0) {		
			for (int j=0;j<nuevoArray.length;j++) {
				if (nuevoArray!=null) {
					System.out.println("Puede realizar checking de la reserva nº"
					+j 
					+"detallada seguidamente"
					+nuevoArray[j]);}}
			
		System.out.println("Introduce el numero de reserva a checar");
		posicion=Entrada.entero();
		reservaCheck=nuevoArray[posicion];
			
		controlador.realizarCheckin(reservaCheck,reservaCheck.getCheckIn());
			}else {System.out.println("No existen reservas para este huesped");}
		}
	}
	private void realizarChechout() {
		Reserva [] nuevoArray= controlador.getReservas(Consola.leerHuesped());
		Reserva reservaCheck=null;
		
		int contador=0;
		int posicion=0;
		
		for (int i=0;i<nuevoArray.length;i++) {
			if (nuevoArray!=null) {
				contador++;}

		if (contador>0) {		
			for (int j=0;j<nuevoArray.length;j++) {
				if (nuevoArray!=null) {
					System.out.println("Puede realizar checking de la reserva nº"
					+j 
					+"detallada seguidamente"
					+nuevoArray[j]);}}
			
		System.out.println("Introduce el numero de reserva a checar");
		posicion=Entrada.entero();
		reservaCheck=nuevoArray[posicion];
			
		controlador.realizarCheckin(reservaCheck,reservaCheck.getCheckOut());
			}else {System.out.println("No existen reservas para este huesped");}
		}
	}
	
}
