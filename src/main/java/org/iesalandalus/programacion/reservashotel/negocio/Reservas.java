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
		return reservas;
	}
	
	
	private Reserva [] copiaProfundaReservas() {
		Reserva [] copiaReservas=new Reserva [reservas.length];
		
		for (int i=0;i<reservas.length;i++) {
		copiaReservas[i]=new Reserva(reservas[i]);
		}
		return copiaReservas;
	}

	
	
	public int getTamano() {
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
		if(reserva!=null) {
			for (int i=0;i<reservas.length;i++) {
			if(reservas[i] != null && reservas[i].equals(reserva)) {throw new OperationNotSupportedException("Huesped ya incluido en le array");}
			else {reservas[getTamano()+1]=reserva;}}
			
		}else {throw new NullPointerException("ERROR: No se puede insertar un hu�sped nulo.");}
	}
	
	public int buscarIndice (Reserva reserva) {
		if(reserva!=null) {
			int contador=0;
			int posicion=0;
	
			for (int i=0;i<reservas.length;i++) {
				contador++;
				posicion=contador;
				
				if (reservas[i].equals(reserva)) {posicion=contador;}
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
			if(reservas[i].equals(reserva)) {encontrado=true;}
			else {encontrado=false;}}
			
			if (encontrado=true) {return reserva;}else {return null;}
		}else {throw new NullPointerException("ERROR:");}
	}
	
	public void borrar (Reserva reserva) throws OperationNotSupportedException {
		if(reserva!=null) {
		int contador=0;
			for (int i=0;i<reservas.length;i++) {
				contador++;
				if(reservas[i].equals(reserva)) {desplazarUnaPosicionHaciaIzquierda(contador);}
				else {throw new OperationNotSupportedException("ERROR: No existe ning�n hu�sped como el indicado.");}}	
		}else {throw new NullPointerException("ERROR: No se puede borrar un hu�sped nulo.");}
	}
	
	
	public void desplazarUnaPosicionHaciaIzquierda(int indice) {
		
		for (int i=indice;i<reservas.length;i++) {
			reservas[i]=reservas[i+1];}
			
	}
	
	public Reserva [] get (Huesped huesped) {
	
	if(huesped!=null) {
		Reserva [] nuevoArray=new Reserva[reservas.length];
		int contador=0;
		
		for (int i=0;i<reservas.length;i++) {
			if(reservas[i].getHuesped().equals(huesped)) {
				contador++;
				nuevoArray[contador]=reservas[i];
			}else {System.out.println("Nulo");}
		
		}return nuevoArray;
	}else {throw new  NullPointerException("ERROR: No se puede insertar un hu�sped nulo.");}
	}
	
	public Reserva [] get (TipoHabitacion tipoHabitacion) {
		
		if(tipoHabitacion!=null) {
			Reserva [] nuevoArray=new Reserva[reservas.length];
			int contador=0;
			
			for (int i=0;i<reservas.length;i++) {
				if(reservas[i].getHabitacion().getTipoHabitacion().equals(tipoHabitacion)) {
					contador++;
					nuevoArray[contador]=reservas[i];
				}else {System.out.println("Nulo");}
			
			}return nuevoArray;
		}else {throw new  NullPointerException("ERROR: No se puede insertar un hu�sped nulo.");}
	}
	
	public Reserva [] get (Habitacion habitacion) {
		
	if(habitacion!=null) {
		Reserva [] nuevoArray=new Reserva[reservas.length];
		int contador=0;
		
		for (int i=0;i<reservas.length;i++) {
			if(reservas[i].getHabitacion().equals(habitacion)) {
				contador++;
				nuevoArray[contador]=reservas[i];
			}else {System.out.println("Nulo");}
		
		}return nuevoArray;
	}else {throw new  NullPointerException("ERROR: No se puede insertar un hu�sped nulo.");}
	}

}
