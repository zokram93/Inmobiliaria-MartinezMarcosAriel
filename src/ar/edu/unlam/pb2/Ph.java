package ar.edu.unlam.pb2;

public class Ph extends Propiedad{
	
	private Integer cantidadAmbientes;

	public Ph(String calle,Integer altura,Integer cantidadAmbientes, String localidad, Provincias provincia, Double precio, EstadoPropiedad estado,
			Usuario propietarios) {
		super(calle, altura,localidad, provincia, precio, estado, propietarios);
		this.cantidadAmbientes = cantidadAmbientes;
	}
	
	public Integer getCantAmbientes() {
		return this.cantidadAmbientes;
	}

}
