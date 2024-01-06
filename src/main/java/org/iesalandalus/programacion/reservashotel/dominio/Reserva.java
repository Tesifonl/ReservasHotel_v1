package org.iesalandalus.programacion.reservashotel.dominio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Reserva {
	
	private static final int MAX_NUMERO_MESES_RESERVA=0;
	private static final int MAX_HORAS_POSTERIOR_CHECKOUT=12;
	public static final String FORMATO_FECHA_RESERVA=null;

	private Huesped huesped;
	private Habitacion habitacion;
	private Regimen regimen;
	private LocalDate fechaInicioReserva;
	private LocalDate fechaFinReserva;
	private LocalDate checkIn;
	private LocalDate checkOut;
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
		if (fechaInicioReserva.isBefore(LocalDate.now())|| fechaInicioReserva.isAfter(LocalDate.now().plusMonths(MAX_NUMERO_MESES_RESERVA))) 
		{throw new IllegalArgumentException("La fecha no puede ser anterior al dia de hoy ni posterior al numero de meses");}
		else {this.fechaInicioReserva = fechaInicioReserva;}
	}
	public LocalDate getFechaFinReserva() {
		return fechaFinReserva;
	}
	public void setFechaFinReserva(LocalDate fechaFinReserva) {
		if (fechaFinReserva.isBefore(getFechaInicioReserva()))
		{throw new IllegalArgumentException("La fecha no puede ser posterior al dia de inicio reserva");}
		else{this.fechaFinReserva = fechaFinReserva;}
	}
	public LocalDate getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(LocalDate checkIn) {
		if (checkIn.isBefore(getFechaInicioReserva()))
		{throw new IllegalArgumentException("La fecha no puede ser anterior al dia de inicio reserva");}
		else{this.checkIn = checkIn;}
	}
	public LocalDate getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(LocalDate checkOut) {
		if (checkOut.atTime(LocalTime.now()).isBefore(fechaFinReserva.atTime(MAX_HORAS_POSTERIOR_CHECKOUT, 0))) 
		{throw new IllegalArgumentException("La fecha no puede ser anterior al dia de inicio reserva");}
			else if (checkOut.isBefore(checkIn)){throw new IllegalArgumentException("La fecha no puede ser anterior al checkin ");}
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
		
		if (numeroPersonas<=0 && numeroPersonas>=4){throw new IllegalArgumentException("La fecha no puede ser anterior al dia de inicio reserva");}
		else if(habitacion.getTipoHabitacion().equals(TipoHabitacion.SIMPLE)&& numeroPersonas>1) {throw new IllegalArgumentException("La fecha no puede ser anterior al dia de inicio reserva");}
		else if(habitacion.getTipoHabitacion().equals(TipoHabitacion.DOBLE)&& numeroPersonas>2) {throw new IllegalArgumentException("La fecha no puede ser anterior al dia de inicio reserva");}
		else if(habitacion.getTipoHabitacion().equals(TipoHabitacion.TRIPLE)&& numeroPersonas>3) {throw new IllegalArgumentException("La fecha no puede ser anterior al dia de inicio reserva");}
		else if(habitacion.getTipoHabitacion().equals(TipoHabitacion.SUITE)&& numeroPersonas>4) {throw new IllegalArgumentException("La fecha no puede ser anterior al dia de inicio reserva");}
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
		
		setHuesped(new Huesped(huesped));
		setHabitacion(new Habitacion (habitacion));
		setRegimen(reserva.getRegimen());
		setFechaInicioReserva(reserva.getFechaInicioReserva());
		setFechaFinReserva(reserva.getFechaFinReserva());
		setNumeroPersonas(reserva.getNumeroPersonas());
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
		return "Reserva [huesped=" + huesped + ", habitacion=" + habitacion + ", regimen=" + regimen
				+ ", fechaInicioReserva=" + fechaInicioReserva + ", fechaFinReserva=" + fechaFinReserva + ", checkIn="
				+ checkIn + ", checkOut=" + checkOut + ", precio=" + precio + ", numeroPersonas=" + numeroPersonas
				+ "]";
	}
	
	
	}


