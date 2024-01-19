package org.iesalandalus.programacion.reservashotel.negocio;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.dominio.TipoHabitacion;

public class Reservas {
	
	private int capacidad;
	private int tamano;
	private static Reserva [] reservas;
	
	public Reservas (int capacidad) {
		if(capacidad>0) {
		reservas=new Reserva [capacidad];
		}else {throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");}
	}
	

	public Reserva [] get() {
		Reserva[] copia=copiaProfundaReservas();
		return copia;
	}
	
	
	private Reserva [] copiaProfundaReservas() {
		Reserva [] copiaReservas=new Reserva [reservas.length];
		
		for (int i=0;i<reservas.length;i++) {
			if (reservas[i]!=null) {copiaReservas[i]=new Reserva(reservas[i]);}
			else {copiaReservas[i]=null;}
		}
		return copiaReservas;
	}

	
	
	public int getTamano() {
		int tamano=0;
		
		for (int i=0;i<reservas.length;i++) {
		if(reservas[i]!=null) {tamano++;}
		else {System.out.println("Nulo");};
		}
		System.out.println(tamano);
		return tamano;
	}
	
	public int getCapacidad() {
		System.out.println(reservas.length);
		return reservas.length;
	}
	
	public void insertar (Reserva reserva) throws OperationNotSupportedException {
		boolean noEncontrado=false;
		
		if(reserva!=null) {
			for (int i=0;i<reservas.length;i++) {
			if(reservas[i] != null && reservas[i].equals(reserva)) {throw new OperationNotSupportedException("ERROR: Ya existe una reserva igual.");}
			else {noEncontrado=true;}}
			
			if(noEncontrado==true && getTamano()<getCapacidad()){reservas[getTamano()]=reserva;}
			else{throw new OperationNotSupportedException("ERROR: No se aceptan m�s reservas.");} 
			
		}else {throw new NullPointerException("ERROR: No se puede insertar una reserva nula.");}
	}
	
	public int buscarIndice (Reserva reserva) {
		if(reserva!=null) {
			int contador=0;
			int posicion=0;
	
			for (int i=0;i<reservas.length;i++) {
				contador=i;
				posicion=contador;
				
				if (reservas[i]!=null && reservas[i].equals(reserva)) {posicion=contador;}
				{posicion=0;}
			}
			return posicion;		
		}else {throw new NullPointerException("ERROR:");}
	}
	
	
	public boolean tamañoSuperado(int indice) {
		boolean superado=false;
		
		if (indice> getTamano()) {superado=true;}
		else{superado=false;}
		
		return superado;
	}
	
	public boolean capacidadSuperada(int indice) {
		boolean superado=false;
		
		if (indice> getCapacidad()) {superado=true;}
		else{superado=false;}
		
		return superado;
	}
	
	public Reserva buscar(Reserva reserva) {	
		if(reserva!=null) {
			boolean encontrado=false;
			
			for (int i=0;i<reservas.length;i++) {
			if(reservas[i]!=null && reservas[i].equals(reserva)) {encontrado=true;}
			else {System.out.println("No encontrado");}}
			
			if (encontrado==true) {return new Reserva(reserva);}else {return null;}
		}else {throw new NullPointerException("ERROR:");}
	}
	
	public void borrar (Reserva reserva) throws OperationNotSupportedException {
		boolean encontrado=false;
		
		if(reserva!=null) {
		int contador=0;
		int indice=0;
			for (int i=0;i<reservas.length;i++) {
				contador=i;
				if(reservas[i]!=null && reservas[i].equals(reserva)){
					encontrado=true;indice=contador;}
					else {System.out.println("No encontrado");}}
			
			if(encontrado==true){reservas[indice]=null;	
			desplazarUnaPosicionHaciaIzquierda(indice);}
			else {throw new OperationNotSupportedException("ERROR: No existe ninguna reserva como la indicada.");}	
		
		}else {throw new NullPointerException("ERROR: No se puede borrar una reserva nula.");}
	}
	
	
	public void desplazarUnaPosicionHaciaIzquierda(int indice) {
		
		for (int i=indice;i<reservas.length-1;i++) {
			reservas[i]=reservas[i+1];
			reservas[reservas.length-1]=null;}
			
	}
	
	public Reserva [] getReservas (Huesped huesped) {
	
	if(huesped!=null) {
		Reserva [] nuevoArray=new Reserva[reservas.length];
		boolean encontrado=false;
		int posicion=0;
	
		
		for (int i=0;i<reservas.length;i++) {
			if(reservas[i].getHuesped().equals(huesped)) {
				encontrado=true;
				posicion=i;
			}else {System.out.println("Nulo");}
			
		if (encontrado==true) {
			int tamano=0;
			
			for (int j=0;j<nuevoArray.length;j++) {
			if(nuevoArray[j]!=null) {tamano++;}
			else {System.out.println("Nulo");}}
			
			nuevoArray[tamano]=reservas[posicion];
			}else {System.out.println("Nulo");}
			
		}return nuevoArray;
		
	}else {throw new  NullPointerException("ERROR: No se pueden buscar reservas de un huesped nulo.");}
	}
	
	public Reserva [] getReservas (TipoHabitacion tipoHabitacion) {
		
		if(tipoHabitacion!=null) {
			Reserva [] nuevoArray=new Reserva[reservas.length];
			boolean encontrado=false;
			int posicion=0;
			
			for (int i=0;i<reservas.length;i++) {
				if(reservas[i].getHabitacion().getTipoHabitacion().equals(tipoHabitacion)) {
				encontrado=true;
				posicion=i;
				}else {System.out.println("Nulo");}
				
			if (encontrado==true) {
				int tamano=0;
					
				for (int j=0;j<nuevoArray.length;j++) {
				if(nuevoArray[j]!=null) {tamano++;}
				else {System.out.println("Nulo");}}
					
				nuevoArray[tamano]=reservas[posicion];
				}else {System.out.println("Nulo");}			
			}return nuevoArray;
		}else {throw new  NullPointerException("ERROR: No se pueden buscar reservas de un tipo de habitaci�n nula.");}
	}
	
	
	public Reserva [] getReservasFuturas (Habitacion habitacion) {
		
	if(habitacion!=null) {
		Reserva [] nuevoArray=new Reserva[reservas.length];
		boolean encontrado=false;
		int posicion=0;
		
		for (int i=0;i<reservas.length;i++) {
			if(reservas[i].getHabitacion().equals(habitacion)) {
			encontrado=true;
			posicion=i;
			}else {System.out.println("Nulo");}
			
		if (encontrado==true) {
			int tamano=0;
				
			for (int j=0;j<nuevoArray.length;j++) {
			if(nuevoArray[j]!=null) {tamano++;}
			else {System.out.println("Nulo");}}
				
			nuevoArray[tamano]=reservas[posicion];
			}else {System.out.println("Nulo");}
			
		}return nuevoArray;
	}else {throw new  NullPointerException("ERROR: No se pueden buscar reservas de una habitaci�n nula.");}
	}

}
