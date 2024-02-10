package org.iesalandalus.programacion.reservashotel;


import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservashotel.controlador.Controlador;
import org.iesalandalus.programacion.reservashotel.modelo.Modelo;
import org.iesalandalus.programacion.reservashotel.vista.Consola;
import org.iesalandalus.programacion.reservashotel.vista.Opcion;
import org.iesalandalus.programacion.reservashotel.vista.Vista;

public class MainApp {

	public static final int CAPACIDAD=100;//mantengo la variable capacidad para pasar eliminar error en los test.
	
    public static void main(String[] args) throws OperationNotSupportedException {
    	
		Vista vista=new Vista();
		Modelo modelo=new Modelo();
		Controlador controlador=new Controlador(modelo, vista);
		
		controlador.comenzar();

		}
    }
	


