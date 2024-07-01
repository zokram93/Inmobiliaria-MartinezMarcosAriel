package ar.edu.unlam.pb2;

import java.time.LocalDate;

public class Alquiler extends Operacion {
	private Usuario inquilino;
	private Propiedad propiedad;
	private LocalDate desde;
	private LocalDate hasta;
	
	
	public Alquiler(Usuario inquilino, Propiedad propiedad, LocalDate desde, LocalDate hasta) {
		this.inquilino=inquilino;
		this.propiedad=propiedad;
		this.desde=desde;
		this.hasta=hasta;
	}

	@Override
	public Boolean verificarDisponibilidad(Propiedad propiedad) throws elEstadoDeLaPropiedadNoSeEncuentraDisponibleException {
		if(propiedad.getEstado().equals(EstadoPropiedad.SE_ALQUILA )) {
			return true;
		} else throw new elEstadoDeLaPropiedadNoSeEncuentraDisponibleException ("LA PROPIEDAD NO SE ENCUENTRA DISPONIBLE PARA EL ALQUILER");
	}

	@Override
	public Boolean efectuar()throws laOperacionNoPuedoSerEfectuadaException, elEstadoDeLaPropiedadNoSeEncuentraDisponibleException {
		if (desde == null || hasta == null) {
            throw new IllegalArgumentException("Las fechas de inicio y fin no pueden ser nulas");
        }
        if (desde.isAfter(hasta)) {
            throw new IllegalArgumentException("La fecha de hasta debe ser posterior o igual a la fecha de inicio");
        }
        if(verificarDisponibilidad(propiedad)) {
        	this.propiedad.setEstado(EstadoPropiedad.ALQUILADO);
        	return true;
        } else throw new laOperacionNoPuedoSerEfectuadaException("LA OPERACION ALQUILER NO PUEDO SER EFECTUADA");
	
	}


	public Usuario getInquilino() {
		return inquilino;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public LocalDate getDesde() {
		return desde;
	}

	public LocalDate getHasta() {
		return hasta;
	}


	

}
