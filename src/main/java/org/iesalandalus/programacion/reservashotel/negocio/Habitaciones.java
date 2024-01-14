package org.iesalandalus.programacion.reservashotel.negocio;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.dominio.TipoHabitacion;


public class Habitaciones {
	
	private int capacidad;
	private int tamano;
	private static Habitacion [] habitaciones;
	
	public Habitaciones(int capacidad) {
		if(capacidad>0) {
		habitaciones=new Habitacion [capacidad];
		}else {throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");}
	}
	

	public Habitacion [] get() {
		return habitaciones;
	}
	
	
	private Habitacion [] copiaProfundaHabitaciones() {
		Habitacion [] copiahabitaciones=new Habitacion [habitaciones.length];
		
		for (int i=0;i<habitaciones.length;i++) {
		copiahabitaciones[i]=new Habitacion(habitaciones[i]);
		}
		return copiahabitaciones;
	}

	
	public Habitacion [] get (TipoHabitacion tipoHabitacion) {
		
		if(tipoHabitacion!=null) {
			Habitacion [] nuevoArray=new Habitacion[habitaciones.length];
			int contador=0;
			
			for (int i=0;i<habitaciones.length;i++) {
				if(habitaciones[i].getTipoHabitacion().equals(tipoHabitacion)) {
					contador++;
					nuevoArray[contador]=habitaciones[i];
				}else {System.out.println("Nulo");}
			
			}return nuevoArray;
		}else {throw new  NullPointerException("ERROR: No se puede insertar un hu�sped nulo.");}
	}
	
	
	public int getTamano() {
		for (int i=0;i<habitaciones.length;i++) {
		if(habitaciones[i]!=null) {tamano++;}
		else {System.out.println("Nulo");};
		}
		System.out.println(tamano);
		return tamano;
	}
	
	public int getCapacidad() {
		System.out.println(habitaciones.length);
		return habitaciones.length;
	}
	
	public void insertar (Habitacion habitacion) throws OperationNotSupportedException {
		if(habitacion!=null) {
			for (int i=0;i<habitaciones.length;i++) {
			if(habitaciones[i] != null && habitaciones[i].equals(habitacion)) {throw new OperationNotSupportedException("Huesped ya incluido en le array");}
			else {habitaciones[getTamano()+1]=habitacion;}}
			
		}else {throw new NullPointerException("ERROR: No se puede insertar un hu�sped nulo.");}
	}
	
	public int buscarIndice (Habitacion habitacion) {
		if(habitacion!=null) {
			int contador=0;
			int posicion=0;
	
			for (int i=0;i<habitaciones.length;i++) {
				contador++;
				posicion=contador;
				
				if (habitaciones[i].equals(habitacion)) {posicion=contador;}
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
	
	public Habitacion buscar(Habitacion habitacion) {	
		if(habitacion!=null) {
			boolean encontrado=false;
			
			for (int i=0;i<habitaciones.length;i++) {
			if(habitaciones[i].equals(habitacion)) {encontrado=true;}
			else {encontrado=false;}}
			
			if (encontrado=true) {return habitacion;}else {return null;}
		}else {throw new NullPointerException("ERROR:");}
	}
	
	public void borrar (Habitacion habitacion) throws OperationNotSupportedException {
		if(habitacion!=null) {
		int contador=0;
			for (int i=0;i<habitaciones.length;i++) {
				contador++;
				if(habitaciones[i].equals(habitacion)) {desplazarUnaPosicionHaciaIzquierda(contador);}
				else {throw new OperationNotSupportedException("ERROR: No existe ning�n hu�sped como el indicado.");}}	
		}else {throw new NullPointerException("ERROR: No se puede borrar un hu�sped nulo.");}
	}
	
	
	public void desplazarUnaPosicionHaciaIzquierda(int indice) {
		
		for (int i=indice;i<habitaciones.length;i++) {
			habitaciones[i]=habitaciones[i+1];}
			
	}
	
}


