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
		Habitacion[] copia=copiaProfundaHabitaciones();
		return copia;
	}
	
	
	private Habitacion [] copiaProfundaHabitaciones() {
		Habitacion [] copiahabitaciones=new Habitacion [habitaciones.length];
		
		for (int i=0;i<habitaciones.length;i++) {
		if (habitaciones[i]!=null) {copiahabitaciones[i]=new Habitacion(habitaciones[i]);}
		else {copiahabitaciones[i]=null;}
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
		int tamano=0;
		
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
		boolean noEncontrado=false;
		
		if(habitacion!=null) {
			for (int i=0;i<habitaciones.length;i++) {
			if(habitaciones[i] != null && habitaciones[i].equals(habitacion)) {throw new OperationNotSupportedException("ERROR: Ya existe una habitaci�n con ese identificador.");}
			else {noEncontrado=true;}}
			
			if(noEncontrado==true && getTamano()<getCapacidad()){habitaciones[getTamano()]=habitacion;}
			else{throw new OperationNotSupportedException("ERROR: No se aceptan m�s habitaciones.");} 
			
		}else {throw new NullPointerException("ERROR: No se puede insertar una habitaci�n nula.");}
	}
	
	public int buscarIndice (Habitacion habitacion) {
		if(habitacion!=null) {
			int contador=0;
			int posicion=0;
	
			for (int i=0;i<habitaciones.length;i++) {
				contador=i;
				posicion=contador;
				
				if (habitaciones[i]!=null && habitaciones[i].equals(habitacion)) {posicion=contador;}
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
			if(habitaciones[i]!=null &&habitaciones[i].equals(habitacion)) {encontrado=true;}
			else {System.out.println("No encontrado");}}
			
			if (encontrado==true) {return new Habitacion (habitacion);}else {return null;}
		}else {throw new NullPointerException("ERROR:");}
	}
	
	public void borrar (Habitacion habitacion) throws OperationNotSupportedException {
		boolean encontrado=false;
		
		if(habitacion!=null) {
		int contador=0;
		int indice=0;
			for (int i=0;i<habitaciones.length;i++) {
				contador=i;
				if(habitaciones[i]!=null && habitaciones[i].equals(habitacion)) {
				encontrado=true;indice=contador;}
				else {System.out.println("No encontrado");}}
				
			
			if(encontrado==true){habitaciones[indice]=null;
			desplazarUnaPosicionHaciaIzquierda(indice);}
			else {throw new OperationNotSupportedException("ERROR: No existe ninguna habitaci�n como la indicada.");}	
		
	}else {throw new NullPointerException("ERROR: No se puede borrar una habitaci�n nula.");}
	}
	
	
	public void desplazarUnaPosicionHaciaIzquierda(int indice) {
		
		for (int i=indice;i<habitaciones.length-1;i++) {
			habitaciones[i]=habitaciones[i+1];
			habitaciones[habitaciones.length-1]=null;}
			
	}
	
}


