package ar.edu.unlam.pb2;


public class Propiedad implements Comparable <Propiedad> {
	private static Integer codigoActual = 0;
	protected Integer idPropiedad;
	protected String calle;
	protected Integer altura;
	protected String localidad;
	private Provincias provincia;
	private EstadoPropiedad estado;
	protected Double precio;
	private Usuario propietario;

	
	public Propiedad(String calle,Integer altura, String localidad, Provincias provincia
			, Double precio,EstadoPropiedad estado, Usuario propietarios) {
		this.idPropiedad= codigoActual++;
		this.calle = calle;
		this.altura = altura;
		this.localidad = localidad;
		this.provincia = provincia;
		this.estado = estado;
		this.precio = precio;
		this.propietario = propietarios;
	}
	
	@Override
	public int compareTo(Propiedad o) {
		return this.idPropiedad - o.getIdPropiedad();
	}
	
	public static Integer getCodigoActual() {
		return codigoActual;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public Provincias getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincias provincia) {
		this.provincia = provincia;
	}

	public EstadoPropiedad getEstado() {
		return estado;
	}

	public void setEstado(EstadoPropiedad estado) {
		this.estado = estado;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Usuario getPropietario() {
		return propietario;
	}

	public void setPropietario(Usuario propietarios) {
		this.propietario = propietarios;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String direccion) {
		this.calle = direccion;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public Integer getIdPropiedad() {
		return idPropiedad;
	}





	

	
	
	
	
}
