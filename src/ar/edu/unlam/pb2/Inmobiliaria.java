package ar.edu.unlam.pb2;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Inmobiliaria {
	private String nombre;
	private Double umbralMinimo;
	private TreeSet <Propiedad> propiedades;
	private HashSet<Usuario>clientes;
	private TreeSet <Operacion>operaciones;
	
	//CONSTRUCTORES
	public Inmobiliaria() {
		this.nombre = "Martinez Marcos";
		this.umbralMinimo = 20000.0;
		this.propiedades = new TreeSet<>();
		this.clientes = new HashSet<>();
		this.operaciones = new TreeSet<>();
		
	}
	public Inmobiliaria(String nombre, Double importeMinimoDeVenta) {
		this.propiedades = new TreeSet<>();
		this.clientes = new HashSet<>();
		this.umbralMinimo = importeMinimoDeVenta;
		this.nombre = nombre;
	}

	public Boolean agregarPropiedad(Propiedad propiedad) throws UmbralMinimoNoAlcanzadoException {
		if(propiedad.getEstado().equals(EstadoPropiedad.SE_VENDE)) {
			if(propiedad.getPrecio()>=this.umbralMinimo) {
				return propiedades.add(propiedad);
			} else throw new UmbralMinimoNoAlcanzadoException("NO SE ALCANZO EL IMPORTE MINIMO DE UNA VENTA DE PROPIEDAD");
		}
		 return propiedades.add(propiedad);
		
		
		
	}
	//DEVOLVER COLECCION 
	public TreeSet<Propiedad> getPropiedades() {
		return propiedades;
	}
	public HashSet<Usuario> getClientes() {
		return clientes;
	}
	public TreeSet<Operacion> getOperaciones() {
		return operaciones;
	}
	//DEVOLVER COLECCION POR TIPO
	public TreeSet <Casa> devuelveColeccionDeCasas() {
		TreeSet <Casa> casas = new TreeSet <>();
		for (Propiedad actual:propiedades) {
			if (actual instanceof Casa) {
				casas.add((Casa) actual);
			}
		}
		return casas;
	}
	
	public TreeSet <Departamento> devuelveColeccionDeDepartamentos() {
		TreeSet <Departamento> departamentos = new TreeSet <>();
		for (Propiedad actual:propiedades) {
			if (actual instanceof Departamento) {
				departamentos.add((Departamento) actual);
			}
		}
		return departamentos;
	}
	
	public TreeSet <Campo> devuelveColeccionDeCampos() {
		TreeSet <Campo> campos = new TreeSet <>();
		for (Propiedad actual:propiedades) {
			if (actual instanceof Campo) {
				campos.add((Campo) actual);
			}
		}
		return campos;
	}
	
	public TreeSet <Terreno> devuelveColeccionDeTerrenos() {
		TreeSet <Terreno> terrenos = new TreeSet <>();
		for (Propiedad actual:propiedades) {
			if (actual instanceof Terreno) {
				terrenos.add((Terreno) actual);
			}
		}
		return terrenos;
	}
	//OBTENER PROMEDIOS
	public Double obtenerPromedioDeCasas() {
		TreeSet<Casa> casas = devuelveColeccionDeCasas();
		Double sumaPromedio = 0.0;
		for(Casa actual: casas) {
			sumaPromedio += actual.precio;
		}
		return sumaPromedio/casas.size();
	}
	public Double obtenerPromedioDeDepto() {
		TreeSet <Departamento> departamentos = devuelveColeccionDeDepartamentos();
		Double sumaPromedio = 0.0;
		for(Departamento actual: departamentos) {
			sumaPromedio += actual.precio;
		}
		return sumaPromedio/departamentos.size();
	}
	
	//ALTA CLIENTE
	public Boolean altaCliente(Usuario cliente) {
		return clientes.add(cliente);
}

	//VENTA
	public Boolean venderPropiedad(Propiedad propiedad, Usuario comprador) throws elUsuarioNoSeEncuentraDeAltaComoClienteException, propiedadNoSeEncuentraDadaDeAltaEnInmobiliariaException, elEstadoDeLaPropiedadNoSeEncuentraDisponibleException, elCompradorDeLaPropiedadEsElMismoQueElDueñoException, laOperacionNoPuedoSerEfectuadaException{
		//SE VERFICA QUE ESTEN EN LA COLECCION EL USUARIO Y LA PROPIEDAD, TAMBIEN SE VERIFICA QUE EL COMPRADOR NO SEA DUEÑO DE LA PROPIEDAD QUE QUIERE COMPRAR.
		if(verificarCompradorPropiedadYPropietario(comprador, propiedad)) {
			Operacion nuevaVenta = new Venta (comprador, propiedad);
			if(nuevaVenta.efectuar()) {
				return operaciones.add(nuevaVenta);
			}
		} throw new laOperacionNoPuedoSerEfectuadaException("NO SE PUDO REALIZAR LA OPERACION DE VENTA");
		
	}
	
	//ALQUILER
	public Boolean alquilarPropiedad(Propiedad propiedad, Usuario inquilino, LocalDate desde, LocalDate hasta) throws laOperacionNoPuedoSerEfectuadaException, elEstadoDeLaPropiedadNoSeEncuentraDisponibleException, elUsuarioNoSeEncuentraDeAltaComoClienteException, propiedadNoSeEncuentraDadaDeAltaEnInmobiliariaException, elCompradorDeLaPropiedadEsElMismoQueElDueñoException {
		if(verificarCompradorPropiedadYPropietario(inquilino, propiedad)) {
			Operacion nuevoAlquiler = new Alquiler (inquilino, propiedad,desde,hasta);
			if(nuevoAlquiler.efectuar()) {
				return operaciones.add(nuevoAlquiler);
			}
	}
		throw new laOperacionNoPuedoSerEfectuadaException("NO SE PUDO REALIZAR LA OPERACION DEL ALQUILER");	
	}
	
	//PERMUTA
	public Boolean hacerPermuta(Propiedad propiedad, Propiedad propiedad1) throws  elUsuarioNoSeEncuentraDeAltaComoClienteException, propiedadNoSeEncuentraDadaDeAltaEnInmobiliariaException, elCompradorDeLaPropiedadEsElMismoQueElDueñoException, laOperacionNoPuedoSerEfectuadaException, elEstadoDeLaPropiedadNoSeEncuentraDisponibleException {
		//SE VERIFICA QUE EL CLIENTE NO SEA DUEÑO DE LA PROPIEDAD A LA QUE QUIERE HACER PERMUTA, COMO TAMBIEN SI ESTA DADO DE ALTA LA PROPIEDAD Y EL CLIENTE.
		if(verificarCompradorPropiedadYPropietario(propiedad.getPropietario(),propiedad1) && verificarCompradorPropiedadYPropietario(propiedad1.getPropietario(),propiedad)) {
			Operacion nuevaPermuta = new Permuta ( propiedad, propiedad1);	
			if(nuevaPermuta.efectuar()) {
				return operaciones.add(nuevaPermuta);
		}
			
		}
		throw new laOperacionNoPuedoSerEfectuadaException("NO SE PUDO REALIZAR LA OPERACION DE PERMUTA");	
		
	}
	
	//VERIFICACIONES
	private Boolean verificarCompradorPropiedadYPropietario(Usuario comprador, Propiedad propiedad) throws elUsuarioNoSeEncuentraDeAltaComoClienteException, propiedadNoSeEncuentraDadaDeAltaEnInmobiliariaException, elCompradorDeLaPropiedadEsElMismoQueElDueñoException {
		if(verificarUsuario(comprador)&&verificarPropiedad(propiedad)&&verificarPropietario(comprador, propiedad)) {
			return true;
		}
		return false;
	}
	private Boolean verificarPropietario(Usuario comprador, Propiedad propiedad) throws elCompradorDeLaPropiedadEsElMismoQueElDueñoException {
		if(!(propiedad.getPropietario().equals(comprador))) {
			return true;
		}else throw new elCompradorDeLaPropiedadEsElMismoQueElDueñoException("EL COMPRADOR DE LA PROPIEDAD ES TAMBIEN EL DUEÑO");
	}
	private Boolean verificarPropiedad(Propiedad propiedadAVerificar) throws propiedadNoSeEncuentraDadaDeAltaEnInmobiliariaException {
		if(propiedades.contains(propiedadAVerificar)) {
			return true;
		} else throw new propiedadNoSeEncuentraDadaDeAltaEnInmobiliariaException("LA PROPIEDAD NO SE ENCUENTRA DADA DE ALTA EN INMOBILIARIA");
	}
	private Boolean verificarUsuario(Usuario usuarioAVErificar) throws elUsuarioNoSeEncuentraDeAltaComoClienteException {
		if(clientes.contains(usuarioAVErificar)) {
			return true;
		} else throw new elUsuarioNoSeEncuentraDeAltaComoClienteException("EL USUARIO NO ESTA DADO DE ALTA COMO CLIENTE");
	}
	
	//BUSQUEDAS
	public Propiedad buscarPropiedadPorID(Integer idPropiedadBuscada) throws propiedadNoSeEncuentraDadaDeAltaEnInmobiliariaException {
			for(Propiedad actual: propiedades) {
				if(actual.getIdPropiedad().equals(idPropiedadBuscada)) {
					return actual;
				} 
			}
			throw new propiedadNoSeEncuentraDadaDeAltaEnInmobiliariaException ("LA PROPIEDAD NO AH PODIDO SER ENCUENTRA, VERIFIQUE QUE HAYA SIDO DADA DE ALTA");
	}		
	public LinkedList<Casa> buscarCasaPorRangoDePRecio(Double desde, Double hasta) throws SinResultadoException {
		LinkedList <Casa> casasBuscadaPorRango = new LinkedList<>();
		for(Casa c : devuelveColeccionDeCasas()){
			if(c.getPrecio()>=desde&&c.getPrecio()<=hasta) {
				casasBuscadaPorRango.add(c);
			} 
		}
		if(casasBuscadaPorRango.size()==0) {
			throw new SinResultadoException("NO SE AH ENCONTRADO RESULTADOS");
		}
		casasBuscadaPorRango.sort(new ordenadoPorPrecio());
		return casasBuscadaPorRango ;
	}
	public LinkedList<Departamento> buscarDepartamentoPorRangoDePrecio(Double desde, Double hasta) {
		LinkedList <Departamento> deptoOrdenadosPorPrecio = new LinkedList<>();
		for(Departamento d : devuelveColeccionDeDepartamentos()){
			if(d.getPrecio()>=desde&&d.getPrecio()<=hasta) {
				deptoOrdenadosPorPrecio.add(d);
			}
		}
		deptoOrdenadosPorPrecio.sort(new ordenadoPorPrecio());
		return deptoOrdenadosPorPrecio ;
	}	
	public LinkedList<Casa> buscarCasaPorUbicacion(Provincias provincia) {
		LinkedList<Casa> casasBuscadaPorUbicacion = new LinkedList<>();
		for(Casa c : devuelveColeccionDeCasas()){
			if(c.getProvincia().equals(provincia)) {
				casasBuscadaPorUbicacion.add(c);
			}
		}
		Collections.sort(casasBuscadaPorUbicacion,new propiedadOrdenadosPorUbicacion());
		return casasBuscadaPorUbicacion ;
	}
	public LinkedList<Departamento> buscarDepartamentoPorUbicacion(Provincias provincia) {
		LinkedList <Departamento> deptoBuscadoPorUbicacion = new LinkedList<>();
		for(Departamento c : devuelveColeccionDeDepartamentos()){
			if(c.getProvincia().equals(provincia)) {
				deptoBuscadoPorUbicacion.add(c);
			}
		}
		deptoBuscadoPorUbicacion.sort(new propiedadOrdenadosPorUbicacion());
		return deptoBuscadoPorUbicacion ;
	}
	
	//GETTERS AND SETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getImporteMinimoDeVenta() {
		return umbralMinimo;
	}
	public void setImporteMinimoDeVenta(Double importeMinimoDeVenta) {
		this.umbralMinimo = importeMinimoDeVenta;
	}
	
	
	
//	public Casa crearCasa(String calle,Integer altura, String localidad, Provincias provincia, Double precio, EstadoPropiedad estado,Usuario cliente) {
//	Casa nueva = new Casa(calle,altura, localidad, provincia, precio, estado, cliente);
//	return nueva;
//	
//}
//
//public Casa buscarCasaPorID(Integer idcasa) {
//	Casa casabusqueda = null;
//	for(Propiedad actual: propiedades) {
//		if(actual instanceof Casa) {
//		if(actual.getIdPropiedad().compareTo(idcasa)== 0) {
//			casabusqueda=(Casa) actual;
//			return casabusqueda;
//		}
//		}
//	}
//	return casabusqueda;	
//	
//}
	
//	public Boolean venderCasa(Casa elejirCasa, Usuario elejirPropietario) {
//	for (Casa casa : casas) {
//		if(casa!=null&&casa.equals(elejirCasa)) {
//			if(casa.getEstado()==EstadoPropiedad.SE_VENDE) {
//				casa.setPropietarios(elejirPropietario);
//				return true;
//			}
//		}
//	}
//	return false;
//	
//}
//	public LinkedList<Casa> devuelverArrayordenadoPorPrecio() {
//	Collections.sort(casas);
//	return this.casas;
//}
//
//public LinkedList<Casa> devuelverArrayordenadoPorUbicacion() {
//	Collections.sort(casas, new Comparador());
//	return casas;
//}
//
//public LinkedList<Casa> devolverCasaPorRangoDePrecio(Double elejirDesde, Double elejirHasta) {
//	LinkedList<Casa> auxiliar = new LinkedList<>();
//	for(Casa actual:casas) {
//		if(actual.getPrecio()>=elejirDesde&&actual.getPrecio()<=elejirHasta) {
//				auxiliar.add(actual);
//		}
//	}
//	return auxiliar;
//}
//	public LinkedList<Propiedad> obtenerPropiedadesEnVenta() {
//		LinkedList<Propiedad>propiedadEnVenta = new LinkedList<>();
//		for(Casa casa:casas) {
//			if(casa.getEstado()==EstadoPropiedad.SE_VENDE) {
//				propiedadEnVenta.add(casa);
//			}
//		}
//		for(Departamento dpto:departamentos) {
//			if(dpto.getEstado()==EstadoPropiedad.SE_VENDE) {
//				propiedadEnVenta.add(dpto);
//			}
//		}
//		return propiedadEnVenta;
//	}
//	public LinkedList<Casa> devolverPropiedadPorUbicacion(String ubicacionSeleccionada) {
//		LinkedList<Casa> auxiliar = new LinkedList<>();
//		for(Casa obj:casas) {
//			if(obj.getLocalidad().compareTo(ubicacionSeleccionada)==0) {
//				auxiliar.add(obj);
//			}
//		}
//		return auxiliar;
//	}
//





	
}
