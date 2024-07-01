package ar.edu.unlam.pb2;

public abstract class Operacion implements Comparable <Operacion>{
	
	private Integer idOperacion;
	private static Integer contador = 0;

	public Operacion() {
		this.idOperacion = contador++ ;
	}

	public Boolean verificarDisponibilidadParaLaVenta(Propiedad propiedad) throws elEstadoDeLaPropiedadNoSeEncuentraDisponibleException {
		if(propiedad.getEstado().equals(EstadoPropiedad.SE_VENDE)) {
			return true;
		} else throw new elEstadoDeLaPropiedadNoSeEncuentraDisponibleException ("LA PROPIEDAD NO SE ENCUENTRA DISPONIBLE PARA LA VENTA");
	}
	
	public Boolean verificarDisponibilidadParaElAlquiler(Propiedad propiedad) throws elEstadoDeLaPropiedadNoSeEncuentraDisponibleException {
		if(propiedad.getEstado().equals(EstadoPropiedad.SE_ALQUILA )) {
			return true;
		} else throw new elEstadoDeLaPropiedadNoSeEncuentraDisponibleException ("LA PROPIEDAD NO SE ENCUENTRA DISPONIBLE PARA ALQUILARLA");
	}
	
	public Boolean verificarDisponibilidadParaPermuta(Propiedad propiedad) throws elEstadoDeLaPropiedadNoSeEncuentraDisponibleException {
		if(propiedad.getEstado().equals(EstadoPropiedad.SE_PERMUTA )) {
			return true;
		} else throw new elEstadoDeLaPropiedadNoSeEncuentraDisponibleException ("LA PROPIEDAD NO SE ENCUENTRA DISPONIBLE PARA LA PERMUTA");
	}

	public abstract Boolean efectuar() throws laOperacionNoPuedoSerEfectuadaException, elEstadoDeLaPropiedadNoSeEncuentraDisponibleException;
	
	public Integer getIdOperacion() {
		return this.idOperacion;
	}
	
	@Override
	public int compareTo(Operacion o) {
		return this.idOperacion - o.getIdOperacion();
	}
	
}
