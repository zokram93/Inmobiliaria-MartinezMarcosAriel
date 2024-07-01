package ar.edu.unlam.pb2;

import java.time.LocalDate;

public class Casa extends Propiedad{
	
	private Usuario inquilino = null;
	private LocalDate desde = null;
	private LocalDate hasta = null;
	
	public Casa(String calle,Integer altura, String localidad, Provincias provincia, Double precio, EstadoPropiedad estado,
			Usuario propietarios) {
		super(calle,altura, localidad, provincia, precio, estado, propietarios);
	}

	

	@Override
	public String toString() {
		return "Casa id: " + getIdPropiedad()  + "\n Calle: " + getCalle()+ "\n Altura: " + getAltura() + "\n Localidad: " + getLocalidad()+ "\n Provincia: "
				+ getProvincia() + "\n Estado: " + getEstado() + "\n Precio: $" + getPrecio();
				
	}
		
	public Usuario getInquilino() {
		return inquilino;
	}

	public void setInquilino(Usuario inquilino) {
		this.inquilino = inquilino;
	}

	public LocalDate getDesde() {
		return desde;
	}

	public void setDesde(LocalDate desde) {
		this.desde = desde;
	}

	public LocalDate getHasta() {
		return hasta;
	}

	public void setHasta(LocalDate hasta) {
		this.hasta = hasta;
	}


	
	
	
	

	
}
