package org.iesalandalus.programacion.reservashotel.vista;

public enum Opcion {
	
	
	SALIR ("13º.-Salir"), 
	INSERTAR_HUESPED ("1º.-Insertar huesped"),
	BUSCAR_HUESPED ("2º.-Buscar huesped"),
	BORRAR_HUESPED ("3º.-Borrar huesped"),
	MOSTRAR_HUESPEDES ("4º.-Mostrar huespedes"),
	INSERTAR_HABITACION ("5º.-Insertar habitacion"),
	BUSCAR_HABITACION ("6º.-Buscar habitacion"),
	BORRAR_HABITACION ("7º.-Borrar habitacion"),
	MOSTRAR_HABITACIONES ("8.-Mostrar habitaciones"),
	INSERTAR_RESERVA ("9.-Insertar reserva"),
	ANULAR_RESERVA ("10º-Anular reserva"),
	MOSTRAR_RESERVAS ("11º-Mostrar reserva"),
	CONSULTAR_DISPONIBILIDAD ("12º-Consultar disponibilidad"),
	REALIZAR_CHECKIN("13º-Realizar checkin"),
	REALIZAR_CHECKOUT("14º-Realizar checkout");
	
	private String mensajeAMostrar;
	
	
	private Opcion(String mensajeAMostrar) {
		this.mensajeAMostrar=mensajeAMostrar;
	
	}
	
	
    @Override
    public String toString() {
        return (this.ordinal() + 1) + ".-" + mensajeAMostrar;
    }
	

}
