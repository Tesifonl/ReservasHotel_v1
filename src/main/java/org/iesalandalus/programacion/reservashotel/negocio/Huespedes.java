package org.iesalandalus.programacion.reservashotel.negocio;


import org.iesalandalus.programacion.reservashotel.dominio.Huesped;

public class Huespedes {
	
	private int capacidad;
	private int tamaño;
	private static Huesped [] huespedes;
	
	public Huespedes(int capacidad) {
		
		huespedes=new Huesped [capacidad];
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
		
		for (int i=0;i<huespedes.length;i++) {
		if(huespedes[i]!=null) {tamaño++;}
		else {System.out.println("Nulo");};
		}
		return tamaño;
	}
	
	public int getCapacidad () {
		
		return huespedes.length;
	
	}

	public void insertar (Huesped huesped) {
		
		for (int i=0;i<huespedes.length;i++) {
		if(huespedes[i].equals(huesped)) {System.out.println("Huesped ya incluido en le array");}
		else {huespedes[getTamano()+1]=huesped;};
		}
	}
	
	public Huesped buscar(Huesped huesped) {
		boolean encontrado=false;
		
		for (int i=0;i<huespedes.length;i++) {
		if(huespedes[i].equals(huesped)) {encontrado=true;}
		else {encontrado=false;}}
		
		if (encontrado=true) {return huesped;}else {return null;}
	}
	
	public void borrar (Huesped huesped) {
		if(huesped!=null) {
		int contador=0;
			for (int i=0;i<huespedes.length;i++) {
				contador++;
				if(huespedes[i].equals(huesped)) {desplazarUnaPosicionHaciaIzquierda(contador);}
				else {System.out.println("Huesped ya incluido en le array");}}
		
		}else {throw new NullPointerException("ERROR: No se puede borrar un hu�sped nulo.");}
	}
	
	
	public int buscarIndice (Huesped huesped) {
		
		int contador=0;
		int posicion=0;

		for (int i=0;i<huespedes.length;i++) {
			contador++;
			posicion=contador;
			
			if (huespedes[i].equals(huesped)) {posicion=contador;}
			{posicion=0;}
		}
		return posicion;
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
	
	public void desplazarUnaPosicionHaciaIzquierda(int indice) {
		
		for (int i=indice;i<huespedes.length;i++) {
			huespedes[i]=huespedes[i+1];}
			
	}
}
