package ar.edu.unlam.pb2;

import java.util.Objects;

public class Usuario {
	private static Integer numActual = 0;
	private Integer numIdentificador;
	private String nombre;
	private Integer dni = 0;
	public Usuario(String nombre, Integer dni) {
		this.numIdentificador = numActual++;
		this.nombre = nombre;
		this.dni = dni;
	}
	public Integer getNumIdentificador() {
		return numIdentificador;
	}
	public void setNumIdentificador(Integer numIdentificador) {
		this.numIdentificador = numIdentificador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Usuario [numIdentificador=" + numIdentificador + ", nombre=" + nombre + "]";
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(dni, other.dni);
	}


	
	
}
