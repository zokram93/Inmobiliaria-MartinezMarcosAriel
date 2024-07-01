package ar.edu.unlam.test.pb2;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import ar.edu.unlam.pb2.Casa;
import ar.edu.unlam.pb2.Departamento;
import ar.edu.unlam.pb2.EstadoPropiedad;
import ar.edu.unlam.pb2.Inmobiliaria;
import ar.edu.unlam.pb2.Propiedad;
import ar.edu.unlam.pb2.Provincias;
import ar.edu.unlam.pb2.SinResultadoException;
import ar.edu.unlam.pb2.UmbralMinimoNoAlcanzadoException;
import ar.edu.unlam.pb2.Usuario;
import ar.edu.unlam.pb2.elCompradorDeLaPropiedadEsElMismoQueElDueñoException;
import ar.edu.unlam.pb2.elEstadoDeLaPropiedadNoSeEncuentraDisponibleException;
import ar.edu.unlam.pb2.elUsuarioNoSeEncuentraDeAltaComoClienteException;
import ar.edu.unlam.pb2.laOperacionNoPuedoSerEfectuadaException;
import ar.edu.unlam.pb2.propiedadNoSeEncuentraDadaDeAltaEnInmobiliariaException;

public class test {

	@Test
	public void queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria() throws UmbralMinimoNoAlcanzadoException {
		//PREPARACION DE DATOS
		 Inmobiliaria inmobiliaria = new Inmobiliaria();
		 Usuario cliente1 = new Usuario("Juan", 13245678);
		 Casa casa =  new Casa("Lara",230, "cañuelas", Provincias.BUENOS_AIRES, 100000.0, EstadoPropiedad.SE_VENDE, cliente1);
		 //EJECUCION
		 Boolean valorObtenido = null;
		 valorObtenido = inmobiliaria.agregarPropiedad(casa);
		 //VALIDACION
		 Boolean valorEsperado = true;
		 assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void queSePuedanDarDeAltaDosCasasEnLaInmobiliaria() throws UmbralMinimoNoAlcanzadoException {
		//PREPARACION DE DATOS
		 Inmobiliaria inmobiliaria = new Inmobiliaria();
		 Usuario cliente = new Usuario("Juan", 13245678);
		 Usuario cliente1 = new Usuario("Carlos", 1324567);
		 Casa casa =  new Casa("Lara",230, "cañuelas", Provincias.BUENOS_AIRES, 100000.0, EstadoPropiedad.SE_VENDE, cliente);
		 Casa casa1 =  new Casa("Libertad", 230, "cañuelas", Provincias.BUENOS_AIRES, 120000.0, EstadoPropiedad.SE_VENDE, cliente1);
		 //EJECUCION
		 Integer valorObtenido = null;
		 inmobiliaria.agregarPropiedad(casa);
		 inmobiliaria.agregarPropiedad(casa1);
		 valorObtenido = inmobiliaria.devuelveColeccionDeCasas().size();
		 //VALIDACION DE DATOS
		 Integer valorEsperado = 2 ;
		 assertEquals(valorEsperado, valorObtenido);
	}	
	@Test
	public void queSePuedaDarDeAltaUnDepartamentoEnLaInmobiliaria() throws UmbralMinimoNoAlcanzadoException {
		//PREPARACION DE DATOS
		 Inmobiliaria inmobiliaria = new Inmobiliaria();
		 Usuario cliente1 = new Usuario("Juan", 13245678);
		 Departamento depto =  new Departamento("Lara",230,2,"A","cañuelas", Provincias.BUENOS_AIRES, 100000.0, EstadoPropiedad.SE_VENDE, cliente1);
		 //EJECUCION
		 Boolean valorObtenido = null;
		 valorObtenido = inmobiliaria.agregarPropiedad(depto);
		 //VALIDACION
		 Boolean valorEsperado = true;
		 assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void queSePuedaDarDeAltaDosDepartamentoEnLaInmobiliaria() throws UmbralMinimoNoAlcanzadoException {
		//PREPARACION DE DATOS
		 Inmobiliaria inmobiliaria = new Inmobiliaria();
		 Usuario cliente1 = new Usuario("Juan", 13245678);
		 Usuario cliente = new Usuario("Emanuel", 1324567);
		 Departamento depto =  new Departamento("Lara",230,2,"A","Cañuelas", Provincias.BUENOS_AIRES, 100000.0, EstadoPropiedad.SE_VENDE, cliente1);
		 Departamento depto1 =  new Departamento("Libertad",110,3,"B","Cañuelas", Provincias.BUENOS_AIRES, 100000.0, EstadoPropiedad.SE_VENDE, cliente);
		 //EJECUCION
		 Integer valorObtenido = null;
		 inmobiliaria.agregarPropiedad(depto1);
		 inmobiliaria.agregarPropiedad(depto);
		 valorObtenido = inmobiliaria.devuelveColeccionDeDepartamentos().size();
		 //VALIDACION
		 Integer valorEsperado = 2;
		 assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void queSePuedaObtenerElValorPromedioDeLasCasas() throws UmbralMinimoNoAlcanzadoException {
		//PREPARACION DE DATOS
		 Inmobiliaria inmobiliaria = new Inmobiliaria();
		 Usuario cliente = new Usuario("Juan", 13245678);
		 Usuario cliente1 = new Usuario("Carlos", 1324567);
		 Usuario cliente2 = new Usuario("Roberto", 132457);
		 Casa casa =  new Casa("Lara" ,230, "cañuelas", Provincias.BUENOS_AIRES, 100000.0, EstadoPropiedad.SE_VENDE, cliente);
		 Casa casa1 =  new Casa("Libertad", 110, "cañuelas", Provincias.BUENOS_AIRES, 150000.0, EstadoPropiedad.SE_VENDE, cliente1);
		 Casa casa2 =  new Casa("Ameguino", 1140, "Gonzalez Catan", Provincias.BUENOS_AIRES, 120000.0, EstadoPropiedad.SE_VENDE, cliente2);
		//EJECUCION
		 Double valorObtenido = null;
		 inmobiliaria.agregarPropiedad(casa);
		 inmobiliaria.agregarPropiedad(casa1);
		 inmobiliaria.agregarPropiedad(casa2);
		 valorObtenido = inmobiliaria.obtenerPromedioDeCasas();
		//VALIDACION
		 Double valorEsperado = 123333.33;
		 assertEquals(valorEsperado,valorObtenido,0.01);
		 
	}
	@Test
	public void queSePuedaObtenerElValorPromedioDeLosDepartamentos() throws UmbralMinimoNoAlcanzadoException {
		//PREPARACION DE DATOS
		 Inmobiliaria inmobiliaria = new Inmobiliaria();
		 Usuario cliente1 = new Usuario("Juan", 13245678);
		 Usuario cliente = new Usuario("Emanuel", 1324567);
		 Usuario cliente2 = new Usuario("Roberto", 132457);
		 Departamento depto =  new Departamento("Lara",230,2,"A","Cañuelas", Provincias.BUENOS_AIRES, 120000.0, EstadoPropiedad.SE_VENDE, cliente1);
		 Departamento depto1 =  new Departamento("Libertad",110,3,"B","Cañuelas", Provincias.BUENOS_AIRES, 110000.0, EstadoPropiedad.SE_VENDE, cliente2);
		 Departamento depto2 =  new Departamento("Libertad",110,4,"B","Cañuelas", Provincias.BUENOS_AIRES, 180000.0, EstadoPropiedad.SE_VENDE, cliente);
		//EJECUCION
		 Double valorObtenido = null;
		 inmobiliaria.agregarPropiedad(depto);
		 inmobiliaria.agregarPropiedad(depto1);
		 inmobiliaria.agregarPropiedad(depto2);
		 valorObtenido = inmobiliaria.obtenerPromedioDeDepto();
		//VALIDACION
		 Double valorEsperado = 136666.66;
		 assertEquals(valorEsperado,valorObtenido,0.01);
		 
	}
	@Test
	public void queSePuedaAgregarUnClienteALaInmobiliaria () {
		//PREPARACION DE DATOS
		 Inmobiliaria inmobiliaria = new Inmobiliaria();
		 Usuario cliente = new Usuario("Juan", 13245678);
		
		//EJECUCION
		 Integer valorObtenido = null;
		 inmobiliaria.altaCliente(cliente);
		 valorObtenido = inmobiliaria.getClientes().size();
		//VALIDACION
		 Integer valorEsperado = 1;
		 assertEquals(valorEsperado,valorObtenido);
		 
	}
	@Test
	public void queNoSePuedanAgregarDosClientesConUnMismoDni() {
		//PREPARACION DE DATOS
		 Inmobiliaria inmobiliaria = new Inmobiliaria();
		 Usuario cliente = new Usuario("Juan", 13245678);
		 Usuario cliente1 = new Usuario("Julian", 13245678);
		//EJECUCION
		 Boolean valorObtenido = null;
		 inmobiliaria.altaCliente(cliente);
		 valorObtenido = inmobiliaria.altaCliente(cliente1);
		//VALIDACION
		 Boolean valorEsperado = false;
		 assertEquals(valorEsperado,valorObtenido);
	}
	@Test
	public void queSePuedaRealizarLaVentaDeUnaPropiedad() throws elUsuarioNoSeEncuentraDeAltaComoClienteException, propiedadNoSeEncuentraDadaDeAltaEnInmobiliariaException, laOperacionNoPuedoSerEfectuadaException, elEstadoDeLaPropiedadNoSeEncuentraDisponibleException, elCompradorDeLaPropiedadEsElMismoQueElDueñoException, UmbralMinimoNoAlcanzadoException {
		//PREPARACION DE DATOS
		 Inmobiliaria inmobiliaria = new Inmobiliaria();
		 Usuario dueñoanterior = new Usuario("Juan", 13245678);
		 Usuario comprador = new Usuario("Julian", 132145678);
		 Propiedad casa =  new Casa("Lara",230, "cañuelas", Provincias.BUENOS_AIRES, 100000.0, EstadoPropiedad.SE_VENDE, dueñoanterior);
		 inmobiliaria.altaCliente(comprador);
		 inmobiliaria.agregarPropiedad(casa);
		//EJECUCION
		 Boolean valorObtenido = null;
		 valorObtenido = inmobiliaria.venderPropiedad(casa, comprador);
		//VALIDACION
		 Boolean valorEsperado = true;
		 assertEquals(valorEsperado,valorObtenido);
		 
	}
	@Test (expected = elUsuarioNoSeEncuentraDeAltaComoClienteException.class)
	public void queNoSePuedaRealizarLaVentaDeUnaPropiedadPorqueElClienteNoSeDioDeAlta() throws elUsuarioNoSeEncuentraDeAltaComoClienteException, propiedadNoSeEncuentraDadaDeAltaEnInmobiliariaException, laOperacionNoPuedoSerEfectuadaException, elEstadoDeLaPropiedadNoSeEncuentraDisponibleException, elCompradorDeLaPropiedadEsElMismoQueElDueñoException{
		 Inmobiliaria inmobiliaria = new Inmobiliaria();
		 Usuario comprador = new Usuario("Julian", 13245678);
		 Propiedad casa =  new Casa("Lara",230, "cañuelas", Provincias.BUENOS_AIRES, 100000.0, EstadoPropiedad.SE_VENDE, comprador);
		//EJECUCION
		 inmobiliaria.venderPropiedad(casa,comprador);
	}
	@Test
	public void queSePuedaRealizarElAlquilerDeUnaPropiedad() throws UmbralMinimoNoAlcanzadoException, laOperacionNoPuedoSerEfectuadaException, elEstadoDeLaPropiedadNoSeEncuentraDisponibleException, elUsuarioNoSeEncuentraDeAltaComoClienteException, propiedadNoSeEncuentraDadaDeAltaEnInmobiliariaException, elCompradorDeLaPropiedadEsElMismoQueElDueñoException {
		//PREPARACION DE DATOS
		 Inmobiliaria inmobiliaria = new Inmobiliaria();
		 Usuario cliente = new Usuario("Juan", 13245678);
		 Usuario inquilino = new Usuario("Julian", 135678);
		 LocalDate desde = LocalDate.of(2024, 6, 1);
		 LocalDate hasta = LocalDate.of(2025, 6, 30);
		 Propiedad casa =  new Casa("Lara",230, "cañuelas", Provincias.BUENOS_AIRES, 100000.0, EstadoPropiedad.SE_ALQUILA, cliente);
		 //EJECUCION
		 Boolean valorObtenido = null;
		 
		 inmobiliaria.agregarPropiedad(casa);
		 inmobiliaria.altaCliente(inquilino);
		 valorObtenido = inmobiliaria.alquilarPropiedad(casa, inquilino,desde,hasta );
		 //VALIDACION
		 Boolean valorEsperado = true;
		 assertEquals(valorEsperado, valorObtenido);
		 
	}
	@Test (expected = elEstadoDeLaPropiedadNoSeEncuentraDisponibleException.class)
	public void queNoseSePuedaRealizarElAlquilerDeUnaPropiedadPorQueSuEstadoEsAlquilado() throws UmbralMinimoNoAlcanzadoException, laOperacionNoPuedoSerEfectuadaException, elEstadoDeLaPropiedadNoSeEncuentraDisponibleException, elUsuarioNoSeEncuentraDeAltaComoClienteException, propiedadNoSeEncuentraDadaDeAltaEnInmobiliariaException, elCompradorDeLaPropiedadEsElMismoQueElDueñoException {
		//PREPARACION DE DATOS
		 Inmobiliaria inmobiliaria = new Inmobiliaria();
		 Usuario cliente = new Usuario("Juan", 145678);
		 Usuario inquilino = new Usuario("Julian", 13245678);
		 LocalDate desde = LocalDate.of(2024, 6, 30);
		 LocalDate hasta = LocalDate.of(2025, 9, 30);
		 Propiedad casa =  new Casa("Lara",230, "cañuelas", Provincias.BUENOS_AIRES, 100000.0, EstadoPropiedad.ALQUILADO, cliente);
		 //EJECUCION
		 inmobiliaria.agregarPropiedad(casa);
		 inmobiliaria.altaCliente(inquilino);
		 inmobiliaria.alquilarPropiedad(casa, inquilino,desde,hasta );}
	@Test (expected = propiedadNoSeEncuentraDadaDeAltaEnInmobiliariaException.class)
	public void queNoSePuedaRealizarElAlquilerDeUnaPropiedadPorQueLaCasaNoSeEncontro() throws  elEstadoDeLaPropiedadNoSeEncuentraDisponibleException, elUsuarioNoSeEncuentraDeAltaComoClienteException, propiedadNoSeEncuentraDadaDeAltaEnInmobiliariaException, elCompradorDeLaPropiedadEsElMismoQueElDueñoException, laOperacionNoPuedoSerEfectuadaException  {
		//PREPARACION DE DATOS
		 Inmobiliaria inmobiliaria = new Inmobiliaria();
		 Usuario dueño = new Usuario("Juan", 13245678);
		 Usuario inquilino = new Usuario("Julian", 13245678);
		 LocalDate desde = LocalDate.of(2024, 6, 30);
		 LocalDate hasta = LocalDate.of(2023, 9, 30);
		 Propiedad casa =  new Casa("Lara",230, "cañuelas", Provincias.BUENOS_AIRES, 10000000.0, EstadoPropiedad.SE_VENDE, dueño);
		 //EJECUCION
		 inmobiliaria.altaCliente(inquilino);
		 inmobiliaria.alquilarPropiedad(casa, inquilino,desde,hasta );
	
	}

	@Test
	public void queSePuedaRealizarLaPermutaDeDosPropiedades() throws   UmbralMinimoNoAlcanzadoException, elUsuarioNoSeEncuentraDeAltaComoClienteException, propiedadNoSeEncuentraDadaDeAltaEnInmobiliariaException, elCompradorDeLaPropiedadEsElMismoQueElDueñoException, laOperacionNoPuedoSerEfectuadaException, elEstadoDeLaPropiedadNoSeEncuentraDisponibleException{
		//PREPARACION DE DATOS
		 Inmobiliaria inmobiliaria = new Inmobiliaria();
		 Usuario cliente = new Usuario("Juan", 13245678);
		 Usuario cliente1 = new Usuario("Julian", 123245678);
		 Propiedad casa =  new Casa("Lara",230, "cañuelas", Provincias.BUENOS_AIRES, 100000.0, EstadoPropiedad.SE_PERMUTA, cliente);
		 Propiedad casa1 =  new Departamento ("Lara",230,2,"A","cañuelas", Provincias.BUENOS_AIRES, 100000.0, EstadoPropiedad.SE_PERMUTA, cliente1);
		 //EJECUCION
		 Boolean valorObtenido = null;
		 inmobiliaria.agregarPropiedad(casa);
		 inmobiliaria.agregarPropiedad(casa1);
		 inmobiliaria.altaCliente(cliente);
		 inmobiliaria.altaCliente(cliente1);
		 valorObtenido = inmobiliaria.hacerPermuta(casa,casa1);
	
		 //VALIDACION
		 Boolean valorEsperado = true;
		 assertNotEquals(casa.getEstado(), EstadoPropiedad.SE_PERMUTA);
		 assertEquals(casa1.getPropietario(), cliente);
		 assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void queSePuedaRealizarLaBusquedaDeCasasPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio() throws SinResultadoException, UmbralMinimoNoAlcanzadoException {
		//PREPARACION DE DATOS
		 Inmobiliaria inmobiliaria = new Inmobiliaria();
		 Usuario cliente = new Usuario("Juan", 13245678);
		 Usuario cliente1 = new Usuario("Carlos", 132467);
		 Usuario cliente2 = new Usuario("Roberto", 13257);
		 Usuario cliente3 = new Usuario("Roberto", 13457);
		 Usuario cliente4 = new Usuario("Roberto", 32457);
		 Propiedad casa =  new Casa("Lara" ,230, "cañuelas", Provincias.BUENOS_AIRES, 100000.0, EstadoPropiedad.SE_VENDE, cliente);
		 Propiedad casa1 =  new Casa("Libertad", 110, "cañuelas", Provincias.BUENOS_AIRES, 150000.0, EstadoPropiedad.SE_VENDE, cliente1);
		 Propiedad casa2 =  new Casa("Ameguino", 1140, "Gonzalez Catan", Provincias.BUENOS_AIRES, 80000.0, EstadoPropiedad.SE_ALQUILA, cliente2);
		 Propiedad casa3 =  new Casa("Ameguino", 1170, "Gonzalez Catan", Provincias.BUENOS_AIRES, 90000.0, EstadoPropiedad.SE_PERMUTA, cliente3);
		 Propiedad casa4 =  new Casa("LePuseLaMismaDireccionYNoMeLoAgregabaxD", 1180, "Gonzalez Catan", Provincias.BUENOS_AIRES, 140000.0, EstadoPropiedad.SE_VENDE, cliente4);
		 Propiedad depto2 =  new Departamento("Libertad",110,4,"B","Cañuelas", Provincias.BUENOS_AIRES, 120000.0, EstadoPropiedad.SE_VENDE, cliente);
		 Propiedad casa5 =  new Casa("Ameguino", 1170, "Gonzalez Catan", Provincias.BUENOS_AIRES, 90000.0, EstadoPropiedad.SE_PERMUTA, cliente3);
		 
		//EJECUCION
		 inmobiliaria.agregarPropiedad(casa);
		 inmobiliaria.agregarPropiedad(casa1);
		 inmobiliaria.agregarPropiedad(casa2);
		 inmobiliaria.agregarPropiedad(casa3);
		 inmobiliaria.agregarPropiedad(casa4);
		 inmobiliaria.agregarPropiedad(casa5);
		 inmobiliaria.agregarPropiedad(depto2);
		 //VALIDACION
		 System.out.println("CASAS BUSCADAS POR RANGO DE PRECIO Y ORDENADAS \n");
		 for(Casa c : inmobiliaria.buscarCasaPorRangoDePRecio(90000.0,140000.0)) {
			 System.out.println(c.toString()+ "\n");
		 }
		 assertEquals(casa3,inmobiliaria.buscarCasaPorRangoDePRecio(90000.0,140000.0).getFirst() );
		 assertEquals(casa4,inmobiliaria.buscarCasaPorRangoDePRecio(90000.0,140000.0).getLast() );
	}
	@Test
	public void queSePuedaRealizarLaBusquedaDeCasasPorUbicacionYElResultadoEsteOrdenadoPorUbicacion() throws UmbralMinimoNoAlcanzadoException {
		//PREPARACION DE DATOS
		 Inmobiliaria inmobiliaria = new Inmobiliaria();
		 Usuario cliente = new Usuario("Juan", 13245678);
		 Usuario cliente1 = new Usuario("Carlos", 132467);
		 Usuario cliente2 = new Usuario("Roberto", 13257);
		 Usuario cliente3 = new Usuario("Roberto", 13457);
		 Usuario cliente4 = new Usuario("Roberto", 32457);
		 Casa casa =  new Casa("Lara" ,230, "Cañuelas", Provincias.BUENOS_AIRES, 100000.0, EstadoPropiedad.SE_VENDE, cliente);
		 Casa casa1 =  new Casa("Libertad", 110, "Gonzalez Catan", Provincias.BUENOS_AIRES, 150000.0, EstadoPropiedad.SE_VENDE, cliente1);
		 Casa casa2 =  new Casa("Ameguino", 1140, "San Justo", Provincias.BUENOS_AIRES, 80000.0, EstadoPropiedad.SE_ALQUILA, cliente2);
		 Casa casa3 =  new Casa("Burela", 1170, "San Justo", Provincias.BUENOS_AIRES, 90000.0, EstadoPropiedad.SE_PERMUTA, cliente3);
		 Casa casa4 =  new Casa("Ameguino", 1180, "San Justo", Provincias.BUENOS_AIRES, 140000.0, EstadoPropiedad.SE_VENDE, cliente4);
		 Casa casa5 =  new Casa("Ameguino", 1180, "San Justo", Provincias.BUENOS_AIRES, 140000.0, EstadoPropiedad.SE_VENDE, cliente4);
		 Departamento depto2 =  new Departamento("Libertad",110,4,"B","Cañuelas", Provincias.BUENOS_AIRES, 120000.0, EstadoPropiedad.SE_VENDE, cliente);
		//EJECUCION
		 inmobiliaria.agregarPropiedad(casa);
		 inmobiliaria.agregarPropiedad(casa1);
		 inmobiliaria.agregarPropiedad(casa2);
		 inmobiliaria.agregarPropiedad(casa3);
		 inmobiliaria.agregarPropiedad(casa4);
		 inmobiliaria.agregarPropiedad(depto2);
		 inmobiliaria.agregarPropiedad(casa5);
		 //VALIDACION
		 System.out.println("CASAS BUSCADAS POR UBICACION Y ORDENADAS \n");
		 for(Casa c : inmobiliaria.buscarCasaPorUbicacion(Provincias.BUENOS_AIRES)) {
			 System.out.println(c.toString()+ "\n");
		 }
		 assertEquals(casa,inmobiliaria.buscarCasaPorUbicacion(Provincias.BUENOS_AIRES).getFirst() );
		 assertEquals(casa3,inmobiliaria.buscarCasaPorUbicacion(Provincias.BUENOS_AIRES).getLast() );
	}
	@Test
	public void queSePuedaRealizarLaBusquedaDeDepartamentosPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio() throws UmbralMinimoNoAlcanzadoException {
		//PREPARACION DE DATOS
		 Inmobiliaria inmobiliaria = new Inmobiliaria();
		 Usuario cliente = new Usuario("Juan", 13245678);
		 Propiedad depto1 =  new Departamento("Lara",110,4,"B","Cañuelas", Provincias.BUENOS_AIRES, 140000.0, EstadoPropiedad.SE_ALQUILA, cliente);
		 Propiedad depto2 =  new Departamento("Libertad",330,4,"B","Cañuelas", Provincias.BUENOS_AIRES, 80000.0, EstadoPropiedad.SE_VENDE, cliente);
		 Propiedad depto3= new Departamento("25 de Mayo",200,4,"B","Cañuelas", Provincias.BUENOS_AIRES, 90000.0, EstadoPropiedad.SE_PERMUTA, cliente);
		 Casa casa3 =  new Casa("Ameguino", 1170, "Gonzalez Catan", Provincias.BUENOS_AIRES, 90000.0, EstadoPropiedad.SE_PERMUTA, cliente);
		 Casa casa4 =  new Casa("Montecarlo", 1180, "Gonzalez Catan", Provincias.BUENOS_AIRES, 140000.0, EstadoPropiedad.SE_VENDE, cliente);
		 Departamento depto4 =  new Departamento("Paganini",1101,4,"B","Cañuelas", Provincias.BUENOS_AIRES, 135000.0, EstadoPropiedad.SE_VENDE, cliente);
		 Departamento depto5 =  new Departamento("Paganini",1101,4,"B","Cañuelas", Provincias.BUENOS_AIRES, 135000.0, EstadoPropiedad.SE_VENDE, cliente);
		//EJECUCION
		 inmobiliaria.agregarPropiedad(depto1);
		 inmobiliaria.agregarPropiedad(depto2);
		 inmobiliaria.agregarPropiedad(depto3);
		 inmobiliaria.agregarPropiedad(depto4);
		 inmobiliaria.agregarPropiedad(depto5);
		 inmobiliaria.agregarPropiedad(casa3);
		 inmobiliaria.agregarPropiedad(casa4);

		 //VALIDACION
		 System.out.println("DEPARTAMENTOS BUSCADAS POR RANGO DE PRECIO Y ORDENADAS \n");
		 for(Departamento c : inmobiliaria.buscarDepartamentoPorRangoDePrecio(90000.0,140000.0)) {
			 System.out.println(c.toString()+ "\n");
		 }
		 assertEquals(depto3,inmobiliaria.buscarDepartamentoPorRangoDePrecio(90000.0,140000.0).getFirst() );
		 assertEquals(depto1,inmobiliaria.buscarDepartamentoPorRangoDePrecio(90000.0,140000.0).getLast() );
	}
	@Test
	public void queSePuedaRealizarLaBusquedaDeDepartamentosPorUbicacionYElResultadoEsteOrdenadoPorUbicacion() throws UmbralMinimoNoAlcanzadoException {
		//PREPARACION DE DATOS
		 Inmobiliaria inmobiliaria = new Inmobiliaria();
		 Usuario cliente = new Usuario("Juan", 13245678);
		 Propiedad depto1 =  new Departamento("Lara",110,1,"B","Cañuelas", Provincias.BUENOS_AIRES, 140000.0, EstadoPropiedad.SE_ALQUILA, cliente);
		 Propiedad depto2 =  new Departamento("Libertad",330,2,"B","San Justo", Provincias.BUENOS_AIRES, 80000.0, EstadoPropiedad.SE_VENDE, cliente);
		 Propiedad depto3 =  new Departamento("25 de Mayo",200,3,"B","Moron", Provincias.BUENOS_AIRES, 90000.0, EstadoPropiedad.SE_PERMUTA, cliente);
		 Propiedad depto4 =  new Departamento("Paganini",1103,5,"B","San Justo", Provincias.BUENOS_AIRES, 135000.0, EstadoPropiedad.SE_VENDE, cliente);
		 Propiedad depto5 =  new Departamento("Paganini",1104,4,"B","San Justo", Provincias.BUENOS_AIRES, 135000.0, EstadoPropiedad.SE_VENDE, cliente);
		 Propiedad depto6 =  new Departamento("Paganini",1103,4,"A","San Justo", Provincias.BUENOS_AIRES, 135000.0, EstadoPropiedad.SE_VENDE, cliente);
		 Casa casa3 =  new Casa("Ameguino", 1170, "San Justo", Provincias.BUENOS_AIRES, 90000.0, EstadoPropiedad.SE_PERMUTA, cliente);
		 Casa casa4 =  new Casa("Montecarlo", 1180, "Virrey del Pino", Provincias.BUENOS_AIRES, 140000.0, EstadoPropiedad.SE_VENDE, cliente);
		//EJECUCION
		 inmobiliaria.agregarPropiedad(depto1);
		 inmobiliaria.agregarPropiedad(depto2);
		 inmobiliaria.agregarPropiedad(depto3);
		 inmobiliaria.agregarPropiedad(depto4);
		 inmobiliaria.agregarPropiedad(depto5);
		 inmobiliaria.agregarPropiedad(depto6);
		 inmobiliaria.agregarPropiedad(casa3);
		 inmobiliaria.agregarPropiedad(casa4);

		 //VALIDACION
		 System.out.println("DEPARTAMENTOS BUSCADAS POR UBICACION Y ORDENADAS \n");
		 for(Departamento c : inmobiliaria.buscarDepartamentoPorUbicacion(Provincias.BUENOS_AIRES)) {
			 System.out.println(c.toString()+ "\n");
		 }
		 assertEquals(depto1,inmobiliaria.buscarDepartamentoPorUbicacion(Provincias.BUENOS_AIRES).getFirst() );
		 assertEquals(depto5,inmobiliaria.buscarDepartamentoPorUbicacion(Provincias.BUENOS_AIRES).getLast() );
	}
	@Test (expected = SinResultadoException.class)
	public void queAlBuscarPorUnCriterioQueNoArrojeResultadosSeProduzcaLaExcepcionSinResultadosException() throws SinResultadoException, UmbralMinimoNoAlcanzadoException {
		//PREPARACION DE DATOS
		 Inmobiliaria inmobiliaria = new Inmobiliaria();
		 Usuario cliente = new Usuario("Juan", 13245678);
		 Usuario cliente1 = new Usuario("Carlos", 132467);
		 Usuario cliente2 = new Usuario("Roberto", 13257);
		 Usuario cliente3 = new Usuario("Roberto", 13457);
		 Usuario cliente4 = new Usuario("Roberto", 32457);
		 Casa casa =  new Casa("Lara" ,230, "cañuelas", Provincias.BUENOS_AIRES, 100000.0, EstadoPropiedad.SE_VENDE, cliente);
		 Casa casa1 =  new Casa("Libertad", 110, "cañuelas", Provincias.BUENOS_AIRES, 150000.0, EstadoPropiedad.SE_VENDE, cliente1);
		 Casa casa2 =  new Casa("Ameguino", 1140, "Gonzalez Catan", Provincias.BUENOS_AIRES, 80000.0, EstadoPropiedad.SE_ALQUILA, cliente2);
		 Casa casa3 =  new Casa("Ameguino", 1170, "Gonzalez Catan", Provincias.BUENOS_AIRES, 90000.0, EstadoPropiedad.SE_PERMUTA, cliente3);
		 Casa casa4 =  new Casa("LePuseLaMismaDireccionYNoMeLoAgregabaxD", 1180, "Gonzalez Catan", Provincias.BUENOS_AIRES, 140000.0, EstadoPropiedad.SE_VENDE, cliente4);
		 Departamento depto2 =  new Departamento("Libertad",110,4,"B","Cañuelas", Provincias.BUENOS_AIRES, 120000.0, EstadoPropiedad.SE_VENDE, cliente);
		//EJECUCION
		 inmobiliaria.agregarPropiedad(casa);
		 inmobiliaria.agregarPropiedad(casa1);
		 inmobiliaria.agregarPropiedad(casa2);
		 inmobiliaria.agregarPropiedad(casa3);
		 inmobiliaria.agregarPropiedad(casa4);
		 inmobiliaria.agregarPropiedad(depto2);
		 //VALIDACION
		 inmobiliaria.buscarCasaPorRangoDePRecio(5000.0,9000.0);
		
		 }
	@Test (expected = UmbralMinimoNoAlcanzadoException.class)
	public void queAlIntentarGuardarUnaPropiedadParaLaVentaCuyoImporteEstaPorDebajoDelUmbral10000SeArrojeLaExcepcionUmbralMinimoNoAlcanzadoException() throws UmbralMinimoNoAlcanzadoException {
		//PREPARACION DE DATOS
		 Inmobiliaria inmobiliaria = new Inmobiliaria("IMPACTO",10000.0);
		 Usuario cliente1 = new Usuario("Juan", 13245678);
		 Casa casa =  new Casa("Lara",230, "cañuelas", Provincias.BUENOS_AIRES, 9999.0, EstadoPropiedad.SE_VENDE, cliente1);
		 //EJECUCION
		 inmobiliaria.agregarPropiedad(casa);

	}
		
	}
	
	
	
//	@Test
//	public void  queLaBusquedaPorRangoDePrecioDeCasasMeArrojeUnaListaNuloSiNoAplicanResultados() {
//		//PREPARACION DE DATOS
//		 Inmobiliaria inmobiliaria = new Inmobiliaria();
//		 Usuario cliente = new Usuario("Juan", 13245678);
//		 Usuario cliente1 = new Usuario("Carlos", 1324567);
//		 Usuario cliente2 = new Usuario("Roberto", 132457);
//		 Usuario cliente3 = new Usuario("Roberto", 132457);
//		 Usuario cliente4 = new Usuario("Roberto", 132457);
//		 Casa casa =  new Casa("Lara" ,230, "cañuelas", Provincias.BUENOS_AIRES, 100000.0, EstadoPropiedad.SE_VENDE, cliente);
//		 Casa casa1 =  new Casa("Libertad", 110, "cañuelas", Provincias.BUENOS_AIRES, 150000.0, EstadoPropiedad.SE_VENDE, cliente1);
//		 Casa casa2 =  new Casa("Ameguino", 1140, "Gonzalez Catan", Provincias.BUENOS_AIRES, 80000.0, EstadoPropiedad.SE_VENDE, cliente2);
//		 Casa casa3 =  new Casa("Ameguino", 1170, "Gonzalez Catan", Provincias.BUENOS_AIRES, 900000.0, EstadoPropiedad.SE_VENDE, cliente3);
//		 Casa casa4 =  new Casa("LePuseLaMismaDireccionYNoMeLoAgregabaxD", 1180, "Gonzalez Catan", Provincias.BUENOS_AIRES, 140000.0, EstadoPropiedad.SE_VENDE, cliente4);
//		//EJECUCION
//		 LinkedList<Casa> valorObtenido = new LinkedList<>();
//		 Casa casaencontrada = null;
//		 inmobiliaria.agregarPropiedad(casa);
//		 inmobiliaria.agregarPropiedad(casa1);
//		 inmobiliaria.agregarPropiedad(casa2);
//		 inmobiliaria.agregarPropiedad(casa3);
//		 inmobiliaria.agregarPropiedad(casa4);
//		 valorObtenido = inmobiliaria.devolverCasaPorRangoDePrecio(160000.0, 200000.0);
//		 for (Casa obj : valorObtenido) {
//			if(obj!=null) {
//				casaencontrada =obj;
//			}
//		}
//		//VALIDACION
//		 Integer valorCasasEncontradasEsperadas = 0;
//		 Integer valorCasaEncontradasObtenidas = valorObtenido.size();
//		 assertEquals(valorCasasEncontradasEsperadas, valorCasaEncontradasObtenidas );
//		 assertNull(casaencontrada);
//		
//		 
//		 
//		 
//	}
//	
//	@Test
//	public void  queLaBusquedaDePropiedadesPorVentaMeArrojeUnaLista() {
//		//PREPARACION DE DATOS
//		 Inmobiliaria inmobiliaria = new Inmobiliaria();
//		 Usuario cliente = new Usuario("Juan", 13245678);
//		 Usuario cliente1 = new Usuario("Carlos", 1324567);
//		 Usuario cliente2 = new Usuario("Roberto", 132457);
//		 Usuario cliente3 = new Usuario("Roberto", 132457);
//		 Usuario cliente4 = new Usuario("Roberto", 132457);
//		 Casa casa =  new Casa("Lara" ,230, "cañuelas", Provincias.BUENOS_AIRES, 100000.0, EstadoPropiedad.SE_VENDE, cliente);
//		 Casa casa1 =  new Casa("Libertad", 110, "cañuelas", Provincias.BUENOS_AIRES, 150000.0, EstadoPropiedad.SE_VENDE, cliente1);
//		 Casa casa2 =  new Casa("Ameguino", 1140, "Gonzalez Catan", Provincias.BUENOS_AIRES, 80000.0, EstadoPropiedad.SE_ALQUILA, cliente2);
//		 Casa casa3 =  new Casa("Ameguino", 1170, "Gonzalez Catan", Provincias.BUENOS_AIRES, 900000.0, EstadoPropiedad.SE_PERMUTA, cliente3);
//		 Casa casa4 =  new Casa("LePuseLaMismaDireccionYNoMeLoAgregabaxD", 1180, "Gonzalez Catan", Provincias.BUENOS_AIRES, 140000.0, EstadoPropiedad.SE_VENDE, cliente4);
//		 Departamento depto2 =  new Departamento("Libertad",110,4,"B","Cañuelas", Provincias.BUENOS_AIRES, 180000.0, EstadoPropiedad.SE_VENDE, cliente);
//		//EJECUCION
//		 LinkedList<Propiedad> valorObtenido = new LinkedList<>();
//		 inmobiliaria.agregarPropiedad(casa);
//		 inmobiliaria.agregarPropiedad(casa1);
//		 inmobiliaria.agregarPropiedad(casa2);
//		 inmobiliaria.agregarPropiedad(casa3);
//		 inmobiliaria.agregarPropiedad(casa4);
//		 inmobiliaria.agregarPropiedad(depto2);
//		 valorObtenido = inmobiliaria.obtenerPropiedadesEnVenta();
//		//VALIDACION
//		 Integer valorCasasEncontradasEsperadas = 4;
//		 Integer valorCasaEncontradasObtenidas = valorObtenido.size();
//		 assertEquals(valorCasasEncontradasEsperadas, valorCasaEncontradasObtenidas );
//	}
//	@Test
//	public void  queLaBusquedaDePropiedadesPorVentaMeArrojeUnaListaNuloSiNoAplicanResultados() {
//		//PREPARACION DE DATOS
//		 Inmobiliaria inmobiliaria = new Inmobiliaria();
//		 Usuario cliente = new Usuario("Juan", 13245678);
//		 Usuario cliente1 = new Usuario("Carlos", 1324567);
//		 Usuario cliente2 = new Usuario("Roberto", 132457);
//		 Usuario cliente3 = new Usuario("Roberto", 132457);
//		 Usuario cliente4 = new Usuario("Roberto", 132457);
//		 Casa casa =  new Casa("Lara" ,230, "cañuelas", Provincias.BUENOS_AIRES, 100000.0, EstadoPropiedad.SE_ALQUILA, cliente);
//		 Casa casa1 =  new Casa("Libertad", 110, "cañuelas", Provincias.BUENOS_AIRES, 150000.0, EstadoPropiedad.SE_ALQUILA, cliente1);
//		 Casa casa2 =  new Casa("Ameguino", 1140, "Gonzalez Catan", Provincias.BUENOS_AIRES, 80000.0, EstadoPropiedad.SE_ALQUILA, cliente2);
//		 Casa casa3 =  new Casa("Ameguino", 1170, "Gonzalez Catan", Provincias.BUENOS_AIRES, 900000.0, EstadoPropiedad.SE_PERMUTA, cliente3);
//		 Casa casa4 =  new Casa("LePuseLaMismaDireccionYNoMeLoAgregabaxD", 1180, "Gonzalez Catan", Provincias.BUENOS_AIRES, 140000.0, EstadoPropiedad.SE_PERMUTA, cliente4);
//		 Departamento depto2 =  new Departamento("Libertad",110,4,"B","Cañuelas", Provincias.BUENOS_AIRES, 180000.0, EstadoPropiedad.SE_PERMUTA, cliente);
//		//EJECUCION
//		 LinkedList<Propiedad> valorObtenido = new LinkedList<>();
//		 Propiedad propiedadEncontrada = null;
//		 inmobiliaria.agregarPropiedad(casa);
//		 inmobiliaria.agregarPropiedad(casa1);
//		 inmobiliaria.agregarPropiedad(casa2);
//		 inmobiliaria.agregarPropiedad(casa3);
//		 inmobiliaria.agregarPropiedad(casa4);
//		 inmobiliaria.agregarPropiedad(depto2);
//		 valorObtenido = inmobiliaria.obtenerPropiedadesEnVenta();
//		 
//		 for (Propiedad obj : valorObtenido) {
//				if(obj!=null) {
//					propiedadEncontrada = obj;
//				}
//		//VALIDACION
//		 Integer valorCasasEncontradasEsperadas = 0;
//		 Integer valorCasaEncontradasObtenidas = valorObtenido.size();
//		 assertEquals(valorCasasEncontradasEsperadas, valorCasaEncontradasObtenidas );
//		 assertNull(propiedadEncontrada);
//	}
//	}
//	@Test
//	public void queNoSePuedanDarDeAltaDosDepartamentoConUnaMismaDireccion() {
//		//PREPARACION DE DATOS
//		 Inmobiliaria inmobiliaria = new Inmobiliaria();
//		 Usuario cliente1 = new Usuario("Juan", 13245678);
//		 Departamento depto =  new Departamento("Lara",230,2,"A","Cañuelas", Provincias.BUENOS_AIRES, 100000.0, EstadoPropiedad.SE_VENDE, cliente1);
//		 Departamento depto1 =  new Departamento("Lara",230,2,"A","Cañuelas", Provincias.BUENOS_AIRES, 100000.0, EstadoPropiedad.SE_VENDE, cliente1);
//		 //EJECUCION
//		 Boolean valorObtenido = null;
//		 inmobiliaria.agregarPropiedad(depto);
//		 valorObtenido = inmobiliaria.agregarPropiedad(depto1);
//		 //VALIDACION
//		 Boolean valorEsperado = false;
//		 assertEquals(valorEsperado, valorObtenido);
//	}
//	@Test
//	public void  queLaBusquedaPorRangoDePrecioDeMeArrojeUnaListaNoNuloSiAplicanResultados() {
//		//PREPARACION DE DATOS
//		 Inmobiliaria inmobiliaria = new Inmobiliaria();
//		 Usuario cliente = new Usuario("Juan", 13245678);
//		 Usuario cliente1 = new Usuario("Carlos", 1324567);
//		 Usuario cliente2 = new Usuario("Roberto", 132457);
//		 Usuario cliente3 = new Usuario("Roberto", 132457);
//		 Usuario cliente4 = new Usuario("Roberto", 132457);
//		 Casa casa =  new Casa("Lara" ,230, "cañuelas", Provincias.BUENOS_AIRES, 100000.0, EstadoPropiedad.SE_VENDE, cliente);
//		 Casa casa1 =  new Casa("Libertad", 110, "cañuelas", Provincias.BUENOS_AIRES, 150000.0, EstadoPropiedad.SE_VENDE, cliente1);
//		 Casa casa2 =  new Casa("Ameguino", 1140, "Gonzalez Catan", Provincias.BUENOS_AIRES, 80000.0, EstadoPropiedad.SE_VENDE, cliente2);
//		 Casa casa3 =  new Casa("Ameguino", 1170, "Gonzalez Catan", Provincias.BUENOS_AIRES, 900000.0, EstadoPropiedad.SE_VENDE, cliente3);
//		 Casa casa4 =  new Casa("LePuseLaMismaDireccionYNoMeLoAgregabaxD", 1180, "Gonzalez Catan", Provincias.BUENOS_AIRES, 140000.0, EstadoPropiedad.SE_VENDE, cliente4);
//		//EJECUCION
//		 LinkedList<Casa> valorObtenido = new LinkedList<>();
//		 Casa casaencontrada = null;
//		 inmobiliaria.agregarPropiedad(casa);
//		 inmobiliaria.agregarPropiedad(casa1);
//		 inmobiliaria.agregarPropiedad(casa2);
//		 inmobiliaria.agregarPropiedad(casa3);
//		 inmobiliaria.agregarPropiedad(casa4);
//		 valorObtenido = inmobiliaria.devolverCasaPorRangoDePrecio(100000.0, 150000.0);
//		 for (Casa obj : valorObtenido) {
//			if(obj!=null) {
//				casaencontrada =obj;
//			}
//		}
//		//VALIDACION
//		 Integer valorCasasEncontradasEsperadas = 3;
//		 Integer valorCasaEncontradasObtenidas = valorObtenido.size();
//		 assertEquals(valorCasasEncontradasEsperadas, valorCasaEncontradasObtenidas );
//		 assertNotNull(casaencontrada);
//		
//		 
//		 
//		 
//	}

