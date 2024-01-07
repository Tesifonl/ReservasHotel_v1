package org.iesalandalus.programacion.reservashotel.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Reserva {
	
	public static final int MAX_NUMERO_MESES_RESERVA=6;
	private static final int MAX_HORAS_POSTERIOR_CHECKOUT=12;
	public static final String FORMATO_FECHA_RESERVA="yyyy-MM-dd";
	public static final String FORMATO_FECHA_HORA_RESERVA="[1-2][0-9][0-9][0-9]-[0-1]+[0-9]-[0-1]+[0-9]";

	private Huesped huesped;
	private Habitacion habitacion;
	private Regimen regimen;
	private LocalDate fechaInicioReserva;
	private LocalDate fechaFinReserva;
	private LocalDateTime checkIn;
	private LocalDateTime checkOut;
	private double precio;
	private int numeroPersonas;
	
	
	public Huesped getHuesped() {
		return huesped;
	}
	public void setHuesped(Huesped huesped) {
		if (huesped==null) {throw new NullPointerException("ERROR: No es posible crear un objeto nulo.");}
		else {this.huesped = huesped;}
	}
	public Habitacion getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(Habitacion habitacion) {
		if (habitacion==null) {throw new NullPointerException("ERROR: No es posible crear un objeto nulo.");}
		else {this.habitacion = habitacion;}
	}
	public Regimen getRegimen() {
		return regimen;
	}
	public void setRegimen(Regimen regimen) {
		if (regimen==null) {throw new NullPointerException("ERROR: No es posible crear un objeto nulo.");}
		else {this.regimen = regimen;}
	}
	public LocalDate getFechaInicioReserva() {
		return fechaInicioReserva;
	}
	public void setFechaInicioReserva(LocalDate fechaInicioReserva) {
		if (fechaInicioReserva==null) {throw new NullPointerException("ERROR: La fecha de inicio de una reserva no puede ser nula.");}
		if (fechaInicioReserva.isBefore(LocalDate.now())) 
		{throw new IllegalArgumentException("ERROR: La fecha de inicio de la reserva no puede ser anterior al d�a de hoy.");}
		else if(fechaInicioReserva.isAfter(LocalDate.now().plusMonths(MAX_NUMERO_MESES_RESERVA)))
		{throw new IllegalArgumentException("ERROR: La fecha de inicio de la reserva no puede ser posterior a seis meses.");}
		else {this.fechaInicioReserva = fechaInicioReserva;}
	}
	public LocalDate getFechaFinReserva() {
		return fechaFinReserva;
	}
	public void setFechaFinReserva(LocalDate fechaFinReserva) {
		if (fechaFinReserva==null) {throw new NullPointerException("ERROR: No es posible crear un objeto nulo.");}
		if (fechaFinReserva.isBefore(getFechaInicioReserva()))
		{throw new IllegalArgumentException("La fecha no puede ser posterior al dia de inicio reserva");}
		else{this.fechaFinReserva = fechaFinReserva;}
	}
	public LocalDateTime getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(LocalDateTime checkIn) {
		if (checkIn==null) {throw new NullPointerException("ERROR: El checkin de una reserva no puede ser nulo.");}
		if (checkIn.isBefore(getFechaInicioReserva().atStartOfDay()))
		{throw new IllegalArgumentException("ERROR: El checkin de una reserva no puede ser anterior a la fecha de inicio de la reserva.");}
		else{this.checkIn = checkIn;}
	}
	public LocalDateTime getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(LocalDateTime checkOut) {
		if (checkOut==null) {throw new NullPointerException("ERROR: El checkout de una reserva no puede ser nulo.");}
		if (checkOut.isAfter(fechaFinReserva.atTime(MAX_HORAS_POSTERIOR_CHECKOUT, 0))) 
		{throw new IllegalArgumentException("ERROR: El checkout de una reserva puede ser como m�ximo 12 horas despu�s de la fecha de fin de la reserva.");}
		else if (checkOut.isBefore(checkIn)){throw new IllegalArgumentException("ERROR: El checkout de una reserva no puede ser anterior al checkin.");}
		else {this.checkOut = checkOut;}
	}
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		
		this.precio = habitacion.getPrecio()*getNumeroPersonas();
	}
	
	public int getNumeroPersonas() {
		return numeroPersonas;
	}
	public void setNumeroPersonas(int numeroPersonas) {
		
		if (numeroPersonas<=0) {throw new IllegalArgumentException("ERROR: El n�mero de personas de una reserva no puede ser menor o igual a 0.");}		
		else if(habitacion.getTipoHabitacion().equals(TipoHabitacion.SIMPLE)&& numeroPersonas>1) {throw new IllegalArgumentException("ERROR: El n�mero de personas de una reserva no puede superar al m�ximo de personas establacidas para el tipo de habitaci�n reservada.");}
		else if(habitacion.getTipoHabitacion().equals(TipoHabitacion.DOBLE)&& numeroPersonas>2) {throw new IllegalArgumentException("ERROR: El n�mero de personas de una reserva no puede superar al m�ximo de personas establacidas para el tipo de habitaci�n reservada.");}
		else if(habitacion.getTipoHabitacion().equals(TipoHabitacion.TRIPLE)&& numeroPersonas>3) {throw new IllegalArgumentException("ERROR: El n�mero de personas de una reserva no puede superar al m�ximo de personas establacidas para el tipo de habitaci�n reservada.");}
		else if(habitacion.getTipoHabitacion().equals(TipoHabitacion.SUITE)&& numeroPersonas>4) {throw new IllegalArgumentException("ERROR: El n�mero de personas de una reserva no puede superar al m�ximo de personas establacidas para el tipo de habitaci�n reservada.");}
		else {this.numeroPersonas=numeroPersonas;}
	}
	
	public Reserva(Huesped huesped,Habitacion habitacion, Regimen regimen,LocalDate fechaInicioReserva,LocalDate fechaFinReserva,int numeroPersonas) {
		
		setHuesped(huesped);
		setHabitacion(habitacion);
		setRegimen(regimen);
		setFechaInicioReserva(fechaInicioReserva);
		setFechaFinReserva(fechaFinReserva);
		setNumeroPersonas(numeroPersonas);
		
	}
	
	public Reserva(Reserva reserva) {
		
		if (reserva==null) {throw new NullPointerException("ERROR: No es posible copiar una reserva nula.");}
		else {
		this.huesped=new Huesped(reserva.getHuesped());
		this.habitacion=new Habitacion (reserva.getHabitacion());
		setRegimen(reserva.getRegimen());
		setFechaInicioReserva(reserva.getFechaInicioReserva());
		setFechaFinReserva(reserva.getFechaFinReserva());
		setNumeroPersonas(reserva.getNumeroPersonas());}
	}
	@Override
	public int hashCode() {
		return Objects.hash(fechaInicioReserva, habitacion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(fechaInicioReserva, other.fechaInicioReserva)
				&& Objects.equals(habitacion, other.habitacion);
	}
	@Override
	public String toString() {
		return "Huesped: " + huesped.getNombre()+" "+huesped.getDni() + " Habitaci�n:"+ habitacion.getPlanta() + habitacion.getPuerta() + " - " +habitacion.getTipoHabitacion()
				+ " Fecha Inicio Reserva: " + getFechaInicioReserva() + " Fecha Fin Reserva: " + getFechaFinReserva() + " CheckIn:"
				+ getCheckIn() + " CheckOut:" + getCheckOut() + " Precio:" + precio + " Personas:" + numeroPersonas
				+ "]";
	}
	
	
	}


