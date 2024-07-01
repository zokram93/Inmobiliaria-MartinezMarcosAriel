package ar.edu.unlam.pb2;

public class Permuta extends Operacion {

	private Propiedad propiedad;
	private Propiedad propiedad1;

	public Permuta(Propiedad propiedad, Propiedad propiedad1) {
		this.propiedad = propiedad;
		this.propiedad1 = propiedad1;
	}

	@Override
	public Boolean efectuar()throws laOperacionNoPuedoSerEfectuada, elEstadoDeLaPropiedadNoSeEncuentraDisponibleException {
		if(verificarDisponibilidadParaPermuta(propiedad)&&verificarDisponibilidadParaPermuta(propiedad1)) {
			Usuario temporal = propiedad.getPropietario();
			this.propiedad.setPropietario(propiedad1.getPropietario());
			this.propiedad1.setPropietario(temporal);
			this.propiedad.setEstado(EstadoPropiedad.PERMUTADO);
			this.propiedad1.setEstado(EstadoPropiedad.PERMUTADO);
			return true;
		}
		else throw new laOperacionNoPuedoSerEfectuada("LA OPERACION PERMUTA NO PUEDO SER EFECTUADA");
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public Propiedad getPropiedad1() {
		return propiedad1;
	}
	
	

}
