package ar.edu.unlam.pb2;

public class Terreno extends Propiedad {
	Double ancho ;
	Double largo ;
	Double metrosCuadrados;
	
	public Terreno(String calle,Integer altura,Double ancho,Double largo, String localidad, Provincias provincia, Double precio, EstadoPropiedad estado,
			Usuario propietario) {
		super(calle,altura, localidad, provincia, precio, estado, propietario);
		this.ancho=ancho;
		this.largo = largo;
		this.metrosCuadrados = ancho * largo;
	}
	
	public Double getAncho() {
		return ancho;
	}
	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}
	public Double getLargo() {
		return largo;
	}
	public void setLargo(Double largo) {
		this.largo = largo;
	}
	public Double getMetrosCuadrados() {
		return metrosCuadrados;
	}
	public void setMetrosCuadrados(Double metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}
	
		
	

}
