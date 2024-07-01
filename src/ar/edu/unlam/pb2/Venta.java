package ar.edu.unlam.pb2;

public class Venta extends Operacion {
	private Usuario comprador;
	private Propiedad propiedadEnVenta;
	
	public Venta( Usuario comprador, Propiedad propiedad) {
		this.comprador = comprador;
		this.propiedadEnVenta = propiedad;
	}
	
	@Override
	public Boolean verificarDisponibilidad(Propiedad propiedad) throws elEstadoDeLaPropiedadNoSeEncuentraDisponibleException {
		if(propiedad.getEstado().equals(EstadoPropiedad.SE_VENDE )) {
			return true;
		} else throw new elEstadoDeLaPropiedadNoSeEncuentraDisponibleException ("LA PROPIEDAD NO SE ENCUENTRA DISPONIBLE PARA LA VENTA");
	}
	
	@Override
	public Boolean efectuar() throws laOperacionNoPuedoSerEfectuadaException, elEstadoDeLaPropiedadNoSeEncuentraDisponibleException {
		
		if(verificarDisponibilidad(propiedadEnVenta)) {
			this.propiedadEnVenta.setEstado(EstadoPropiedad.VENDIDO);
			this.propiedadEnVenta.setPropietario(comprador);
			return true;
		} else throw new laOperacionNoPuedoSerEfectuadaException("LA OPERACION VENTA NO PUEDO SER EFECTUADA");
		
		
	}
	public Usuario getComprador() {
		return comprador;
	}

	public Propiedad getPropiedadEnVenta() {
		return propiedadEnVenta;
	}
	
	}
	
