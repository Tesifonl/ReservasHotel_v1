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

	public int getTamaño () {
		
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
		else {huespedes[getTamaño()+1]=huesped;};
		}
	}
	
	public Huesped buscar(Huesped huesped) {
	
		boolean encontrado=false;
		
		for (int i=0;i<huespedes.length;i++) {
		if(huespedes[i].equals(huesped)) {encontrado=true;}
		else {encontrado=false;}}
		
		if (encontrado=true) {return huesped;}else {return null;}
	}
	
	
	
}
