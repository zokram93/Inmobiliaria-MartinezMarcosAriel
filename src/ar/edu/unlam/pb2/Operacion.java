package ar.edu.unlam.pb2;

public abstract class Operacion implements Comparable <Operacion>{
	
	private Integer idOperacion;
	private static Integer contador = 0;

	public Operacion() {
		this.idOperacion = contador++ ;
	}
	public abstract Boolean verificarDisponibilidad(Propiedad propiedad) throws elEstadoDeLaPropiedadNoSeEncuentraDisponibleException ;
		
	public abstract Boolean efectuar() throws laOperacionNoPuedoSerEfectuadaException, elEstadoDeLaPropiedadNoSeEncuentraDisponibleException;
	
	public Integer getIdOperacion() {
		return this.idOperacion;
	}
	
	@Override
	public int compareTo(Operacion o) {
		return this.idOperacion - o.getIdOperacion();
	}
	
}
