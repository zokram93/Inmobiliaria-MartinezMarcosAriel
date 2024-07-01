package ar.edu.unlam.pb2;

public class Campo extends Propiedad {
	
	private Integer cantHectarias;
	
	public Campo(Integer cantHectareas, String localidad, Provincias provincia, Double precio, EstadoPropiedad estado,
			Usuario propietarios) {
		super(null,null, localidad, provincia, precio, estado, propietarios);
		this.cantHectarias = cantHectareas;
	}

	public Integer getCantHectarias() {
		return cantHectarias;
	}

	public void setCantHectarias(Integer cantHectarias) {
		this.cantHectarias = cantHectarias;
	}
	
}
