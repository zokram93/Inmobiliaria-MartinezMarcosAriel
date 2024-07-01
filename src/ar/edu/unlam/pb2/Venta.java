package ar.edu.unlam.pb2;

public class Venta extends Operacion {
	private Usuario comprador;
	private Propiedad propiedadEnVenta;
	
	public Venta( Usuario comprador, Propiedad propiedad) {
		this.comprador = comprador;
		this.propiedadEnVenta = propiedad;
	}

	public Boolean efectuar() throws laOperacionVentaNoPuedoSerEfectuada, elEstadoDeLaPropiedadNoSeEncuentraDisponibleException {
		
		if(verificarDisponibilidadParaLaVenta(propiedadEnVenta)) {
			this.propiedadEnVenta.setEstado(EstadoPropiedad.VENDIDO);
			this.propiedadEnVenta.setPropietario(comprador);
			return true;
		} else throw new laOperacionVentaNoPuedoSerEfectuada("LA OPERACION VENTA NO PUEDO SER EFECTUADA");
		
		
	}
	public Usuario getComprador() {
		return comprador;
	}

	public Propiedad getPropiedadEnVenta() {
		return propiedadEnVenta;
	}
	
	}
	
