package ar.edu.unlam.pb2;

public class Departamento extends Propiedad {


	private String piso = null ;
	private Integer numeroPiso = null;

	

	public Departamento(String calle,Integer altura,Integer numPiso, String piso, String localidad, Provincias provincia, Double precio, EstadoPropiedad estado,
			Usuario propietarios) {
		super(calle,altura, localidad, provincia, precio, estado, propietarios);
		this.piso = piso;
		this.numeroPiso=numPiso;
		
	}

	public Integer getIdCasa() {
		return idPropiedad;
	}

	public void setIdCasa(Integer idCasa) {
		this.idPropiedad = idCasa;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}


	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public Integer getNumeroPiso() {
		return numeroPiso;
	}

	public void setNumeroPiso(Integer numeroPiso) {
		this.numeroPiso = numeroPiso;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "Departamento: " + getIdPropiedad() + " Calle: " + getCalle()+ " - Altura: " + getAltura()+" - Num_Piso: " + getNumeroPiso()+" - Piso: "+getPiso() + "\n Localidad: " + getLocalidad() + "\n Provincia: "
				+ getProvincia() + "\n Estado: " + getEstado() + "\n Precio: $" + getPrecio();
				
	}
	



	
	
	
	
}

