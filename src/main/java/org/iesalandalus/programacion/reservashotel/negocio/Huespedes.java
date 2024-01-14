package org.iesalandalus.programacion.reservashotel.negocio;


import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservashotel.dominio.Huesped;

public class Huespedes {
	
	private int capacidad;
	private int tamano;
	private static Huesped [] huespedes;
	
	
	public Huespedes(int capacidad) {
		if(capacidad>0) {
		huespedes=new Huesped [capacidad];
		}else {throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");}
	}
	
	
	public Huesped [] get() {
		return huespedes;
	}
	
	
	private Huesped [] copiaProfundaHuespedes() {
		Huesped [] copiahuespedes=new Huesped [huespedes.length];
		
		for (int i=0;i<huespedes.length;i++) {
		copiahuespedes[i]=new Huesped(huespedes[i]);
		}
		return copiahuespedes;
	}

	public int getTamano () {
		tamano=0;
		for (int i=0;i<huespedes.length;i++) {
		if(huespedes[i]!=null) {tamano++;}
		else {System.out.println("Nulo");};
		}
		System.out.println(tamano);
		return tamano;
	}
	
	public int getCapacidad () {
		System.out.println(huespedes.length);
			return huespedes.length;
	}
	
	/*huespedes[i] != null && huespedes[i].equals(objetoComparado)*/
			
	public void insertar (Huesped huesped) throws OperationNotSupportedException {
		boolean noEncontrado=false;
		
		if(huesped!=null) {
			for (int i=0;i<huespedes.length;i++) 
			if(huespedes[i] != null && huespedes[i].equals(huesped)) {throw new OperationNotSupportedException("ERROR: Ya existe un hu�sped con ese dni.");}
			else {noEncontrado=true;}
					
			if(noEncontrado==true && getTamano()<getCapacidad()) {huespedes[getTamano()]=huesped;}
			else {throw new OperationNotSupportedException("ERROR: No se aceptan m�s hu�spedes.");}
			
		}else {throw new NullPointerException("ERROR: No se puede insertar un hu�sped nulo.");}
	}
	
	public int buscarIndice (Huesped huesped) {
		if(huesped!=null) {
			int contador=0;
			int posicion=0;
	
			for (int i=0;i<huespedes.length;i++) {
				contador=i;
				posicion=contador;
				
				if (huespedes[i] != null && huespedes[i].equals(huesped)) {posicion=contador;}
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
	
	
	public Huesped buscar(Huesped huesped) {	
		if(huesped!=null) {
			boolean encontrado=false;
			
			for (int i=0;i<huespedes.length;i++) {
			if(huespedes[i] != null && huespedes[i].equals(huesped)) {encontrado=true;}
			else {System.out.println("No encontrado");}}
			
			if (encontrado==true) {return huesped;}else {return null;}
		}else {throw new NullPointerException("ERROR:");}
	}
		
	public void borrar (Huesped huesped) throws OperationNotSupportedException  {
		boolean encontrado=false;
		
		if(huesped!=null) {
		int contador=0;
		int indice=0;
			for (int i=0;i<huespedes.length;i++) {
				contador=i;
				if(huespedes[i] != null && huespedes[i].equals(huesped)) {
				encontrado=true;indice=contador;}
				else {System.out.println("No encontrado");}}	
			
			if (encontrado==true) {huespedes[indice] = null;
			desplazarUnaPosicionHaciaIzquierda(indice);}
			else {throw new OperationNotSupportedException("ERROR: No existe ning�n hu�sped como el indicado.");}
		
		}else {throw new NullPointerException("ERROR: No se puede borrar un hu�sped nulo.");}
	}
	

	public void desplazarUnaPosicionHaciaIzquierda(int indice) {
		
		for (int i=indice;i<huespedes.length-1;i++) {
			huespedes[i]=huespedes[i+1];
			huespedes [huespedes.length-1]=null;}
			
	}
	
	
}
