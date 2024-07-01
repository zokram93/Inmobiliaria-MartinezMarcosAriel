package ar.edu.unlam.test.pb2;

import java.util.Scanner;
import ar.edu.unlam.pb2.Campo;
import ar.edu.unlam.pb2.Casa;
import ar.edu.unlam.pb2.Departamento;
import ar.edu.unlam.pb2.EstadoPropiedad;
import ar.edu.unlam.pb2.Inmobiliaria;
import ar.edu.unlam.pb2.Ph;
import ar.edu.unlam.pb2.Propiedad;
import ar.edu.unlam.pb2.Provincias;
import ar.edu.unlam.pb2.Terreno;
import ar.edu.unlam.pb2.UmbralMinimoNoAlcanzadoException;
import ar.edu.unlam.pb2.Usuario;
import ar.edu.unlam.pb2.propiedadNoSeEncuentraDadaDeAltaEnInmobiliariaException;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static Inmobiliaria inmobiliaria = new Inmobiliaria();
	static Usuario cliente = new Usuario("Juan", 12345678);
	static Usuario admin = new Usuario("Julio", 123457);
	public static void main(String[] args) throws propiedadNoSeEncuentraDadaDeAltaEnInmobiliariaException {
		Integer opcion = null;
		do {
            // Menú de opciones
            System.out.println("Menu de opciones:");
            System.out.println("1. Agregar nueva propiedad");
            System.out.println("2. Modificar propiedad existente");
            System.out.println("3. Agregar cliente");
            System.out.println("4. Obtener listado de propiedades ordenado por precio");
            System.out.println("5. Obtener listado de propiedades ordenado por ubicación");
            System.out.println("6. Buscar propiedades");
            System.out.println("7. Realizar venta de propiedad");
            System.out.println("8. Realizar alquiler de propiedad");
            System.out.println("0. Salir");
            System.out.print("Ingrese la opcion deseada: \n");
            opcion = scanner.nextInt(); 

            // Manejar la opción seleccionada
            switch (opcion) {
                case 1:	switch(consultaPropiedad("agregar")) {
                			case 1: if(menuAgregarCasa(admin)) {
                						System.out.println("SE AGREGO EXITOSAMENTE");
                					}
                				break;
                			case 2: if(menuAgregarDepartamento(admin)) {
        						System.out.println("SE AGREGO EXITOSAMENTE");
        					}
                				break;
                			case 3: if(menuAgregarTerreno(admin)) {
        						System.out.println("SE AGREGO EXITOSAMENTE");
        					}
                				break;
                			case 4: if(menuAgregarPh(admin)) {
        						System.out.println("SE AGREGO EXITOSAMENTE");
        					}
                				break;
                			case 5: if(menuAgregarCampo(admin)) {
        						System.out.println("SE AGREGO EXITOSAMENTE");
        					}
                				break;
                			case 6: 
        						System.out.println("");			
                				break;	
                			}
                	break;
                case 2:	if(menuModificarPropiedad(admin)) {
                	
                } 
    						
            

                    break;
//                case 3: agregarCliente();
//                    break;
//                case 4: mostrarArreglo(inmobiliaria.devuelverArrayordenadoPorPrecio());
//                    break;
//                case 5: mostrarArreglo(inmobiliaria.devuelverArrayordenadoPorUbicacion());       
//                    break;
//                case 6: switch(seleccionBusqueda()) {
//                			case 1: mostrarArreglo(inmobiliaria.devolverCasaPorRangoDePrecio(elejirDesde(),elejirHasta()));
//                			break;
//                			case 2: mostrarArreglo(inmobiliaria.devolverPropiedadPorUbicacion(ubicacionSeleccionada()));
//                			break;
//                			default: break;
//                									}
//                    break;
//                case 7: switch(consultaPropiedad()) {
//               			case 1 : if(inmobiliaria.venderCasa(elejirCasa(),elejirPropietario(inmobiliaria))) {
//               				System.out.println("SE HA VENDIDO CON EXISTO");
//               			} else System.out.println("NO SE PUEDO REALIZAR LA OPECION");
//               			break;
//                				}
//                	break;
//                case 8:
//                   inmobiliaria.realizarAlquiler();
//                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            
            }
        } while (opcion != 0);
    

	}


	//METODOS DE SOLICITUD DE DATOS
	private static String solicitarPorScannerUnString(String mensaje) {
		String datosIngresados;
		System.out.println(mensaje);
		datosIngresados = scanner.next();scanner.nextLine();
		return datosIngresados;
	}
	private static Integer solicitarPorScannerUnInteger(String mensaje) {
		Integer datosIngresados;
		System.out.println(mensaje);
		datosIngresados = scanner.nextInt();
		return datosIngresados;
	}
	private static Double solicitarPorScannerUnDouble(String mensaje) {
		Double datosIngresados;
		System.out.println(mensaje);
		datosIngresados = scanner.nextDouble();
		return datosIngresados;
	}

//	private static Double elejirDesde() {
//		System.out.println("POR FAVOR DIJITE DESDE QUE PRECIO DESDE REALIZAR LA BUSQUEDA");
//		Double desde = scanner.nextDouble();
//		return desde;
//	}
//	private static Double elejirHasta() {
//		System.out.println("POR FAVOR DIJITE HASTA QUE PRECIO DESDE REALIZAR LA BUSQUEDA");
//		Double hasta = scanner.nextDouble();
//		return hasta;
//	}
//	private static Integer seleccionBusqueda() {	
//		Integer opcionElejida = 0;
//		Boolean opcion = false;
//		do {
//			System.out.println("INGRESE\n1-BUSQUEDA POR RANGO\n2-BUSQUEDA POR UBICACION\n0-PARA SALIR");
//			opcionElejida = scanner.nextInt();
//			switch(opcionElejida) {
//			case 1 : opcion = true;break;
//			case 2 : opcion = true ; break;
//			case 0: opcion = true; break;
//			default : System.out.println("INGRESE UNA OPCION VALIDAD, POR FAVOR");break;
//			}
//		}while(opcion==false);
//		return opcionElejida;
//	}
//
//	private static void mostrarArreglo(LinkedList<Casa>casas) {
//		for (Casa actual : casas) {
//			
//				System.out.println(actual.toString());
//			}
//		}
		

//	private static void agregarCliente() {
//		System.out.println("INGRESE EL NOMBRE DEL CLIENTE");
//		String nombre = scanner.next();scanner.nextLine();
//		System.out.println("INGRESE EL DNI DEL CLIENTE");
//		Integer dni = scanner.nextInt();
//		if(inmobiliaria.altaCliente(cliente)) {
//			System.out.println("se agrego exitosamente: " + cliente.toString());
//		}else System.out.println("no se puedo agregar intente nuevamente");
//	}

	//CONSULTA PROPIEDAD
	private static Integer consultaPropiedad(String mensaje) {
		Boolean salir = false;
		Integer opcion = null;
		do {
			System.out.println("Que tipo de propiedad desea "+mensaje+"\n1-Casa\n2-Departamento\n3-Terreno\n4-PH\n5-Campo\n6-Volver");
			opcion = scanner.nextInt();
			if(opcion>=1&&opcion<=6) {
			salir=true;
			}else System.out.println("OPCION INCORRECTA");
		}while(salir==false);
		return opcion;
	}

//	private static Integer solicitarID() {
//		System.out.println("INGRESE EL ID DE LA CASA");
//		Integer idIngresadoInteger = scanner.nextInt();
//		return idIngresadoInteger;
//	}
	//MENU PARA AGREGAR PROPIEDADES
	private static Boolean menuAgregarCasa (Usuario cliente) {
		Propiedad nueva;
		String calle = solicitarPorScannerUnString("INGRESE LA CALLE");
		Integer altura = solicitarPorScannerUnInteger("INGRESE LA ALTURA");
		String localidad = solicitarPorScannerUnString("INGRESE LA LOCALIDAD");
		Provincias provincia = Provincias.BUENOS_AIRES;
		Double precio = solicitarPorScannerUnDouble("INGRESE EL PRECIO");
		EstadoPropiedad estado = obtenerEstadoPropiedad(); 
		nueva = new Casa (calle,altura,localidad,provincia,precio,estado,cliente);
		try {
			return inmobiliaria.agregarPropiedad(nueva);
		} catch (UmbralMinimoNoAlcanzadoException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	private static boolean menuAgregarDepartamento(Usuario cliente) {
		Propiedad nueva;
		String calle = solicitarPorScannerUnString("INGRESE LA CALLE");
		Integer altura = solicitarPorScannerUnInteger("INGRESE LA ALTURA");
		Integer numPiso = solicitarPorScannerUnInteger("INGRESE EL NUMERO DE PISO");
		String piso = solicitarPorScannerUnString("INGRESE EL PISO");
		String localidad = solicitarPorScannerUnString("INGRESE LA LOCALIDAD");
		Provincias provincia = Provincias.BUENOS_AIRES;
		Double precio = solicitarPorScannerUnDouble("INGRESE EL PRECIO");
		EstadoPropiedad estado = obtenerEstadoPropiedad(); 
		nueva = new Departamento(calle,altura,numPiso,piso,localidad,provincia,precio,estado,cliente);
		try {
			return inmobiliaria.agregarPropiedad(nueva);
		} catch (UmbralMinimoNoAlcanzadoException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	private static boolean menuAgregarTerreno(Usuario cliente) {
		Propiedad nueva;
		String calle = solicitarPorScannerUnString("INGRESE LA CALLE");
		Integer altura = solicitarPorScannerUnInteger("INGRESE ALTURA");
		Double ancho = solicitarPorScannerUnDouble("INGRESE EL ANCHO DEL TERRENOS EN METROS");
		Double largo = solicitarPorScannerUnDouble("INGRESE EL LARGO DEL TERRENOS EN METROS");
		String localidad = solicitarPorScannerUnString("INGRESE LA LOCALIDAD");
		Provincias provincia = Provincias.BUENOS_AIRES;
		Double precio = solicitarPorScannerUnDouble("INGRESE EL PRECIO");
		EstadoPropiedad estado = obtenerEstadoPropiedad(); 
		nueva = new Terreno (calle,altura,ancho,largo,localidad,provincia,precio,estado,cliente);
		try {
			return inmobiliaria.agregarPropiedad(nueva);
		} catch (UmbralMinimoNoAlcanzadoException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	private static boolean menuAgregarPh(Usuario cliente) {
		Propiedad nueva;
		String calle = solicitarPorScannerUnString("INGRESE LA CALLE");
		Integer altura = solicitarPorScannerUnInteger("INGRESE LA ALTURA");
		Integer cantAmbientes = solicitarPorScannerUnInteger("INGRESE LA CANTIDAD DE AMBIENTES DISPONIBLES");
		String localidad = solicitarPorScannerUnString("INGRESE LA LOCALIDAD");
		Provincias provincia = Provincias.BUENOS_AIRES;
		Double precio = solicitarPorScannerUnDouble("INGRESE EL PRECIO");
		EstadoPropiedad estado = obtenerEstadoPropiedad(); 
		nueva = new Ph (calle,altura,cantAmbientes,localidad,provincia,precio,estado,cliente);
		try {
			return inmobiliaria.agregarPropiedad(nueva);
		} catch (UmbralMinimoNoAlcanzadoException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	private static boolean menuAgregarCampo(Usuario cliente) {
		Propiedad nueva;
		Integer cantHectareas = solicitarPorScannerUnInteger("INGRESE LA CANTIDAD DE HECTAREAS");
		String localidad = solicitarPorScannerUnString("INGRESE LA LOCALIDAD");
		Provincias provincia = Provincias.BUENOS_AIRES;
		Double precio = solicitarPorScannerUnDouble("INGRESE EL PRECIO");
		EstadoPropiedad estado = obtenerEstadoPropiedad(); 
		nueva = new Campo (cantHectareas,localidad,provincia,precio,estado,cliente);
		try {
			return inmobiliaria.agregarPropiedad(nueva);
		} catch (UmbralMinimoNoAlcanzadoException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	//MENU PARA MODIFICAR PROPIEDADES
	private static boolean menuModificarPropiedad(Usuario admin) {
		Boolean salir = false;
		Integer opcion = 0;
		for(Propiedad p : inmobiliaria.getPropiedades()) {
			System.out.println(p.toString());
		}

		do {
			System.out.println("INGRESE (1) PARA MODIFICAR Y (2) PARA VOLVER");
			opcion = scanner.nextInt();
			switch (opcion) {
			case 1:	try {
					if(hacerModificacionPropiedad()) {
						System.out.println("SE MODIFICO EXITOSAMENTE");
					}
				} catch (propiedadNoSeEncuentraDadaDeAltaEnInmobiliariaException e) {
					System.out.println(e.getMessage());
				}
			break;
			case 2: salir = true;
			break;
			default : System.out.println("opcion invalida");
			break;
							}
			}while(salir==false);
		return false;
	}



	private static Boolean hacerModificacionPropiedad() throws propiedadNoSeEncuentraDadaDeAltaEnInmobiliariaException {
		Integer idIngresado = 0;	
		Propiedad propiedadEncontrada ;
			idIngresado = solicitarPorScannerUnInteger("INGRESE EL ID DE LA PROPIEDAD");
			propiedadEncontrada = inmobiliaria.buscarPropiedadPorID(idIngresado);
			if(propiedadEncontrada instanceof Casa) {
				modificarCasa((Casa) propiedadEncontrada);
				return true;
			}
			if(propiedadEncontrada instanceof Departamento) {
				modificarDepartamento((Departamento) propiedadEncontrada);
				return true;
			}
			return false;

		
	}


	private static void modificarDepartamento(Departamento propiedadEncontrada) {
		String calle = solicitarPorScannerUnString("INGRESE LA CALLE");
		Integer altura = solicitarPorScannerUnInteger("INGRESE LA ALTURA");
		Integer numPiso = solicitarPorScannerUnInteger("INGRESE EL NUMERO DE PISO");
		String piso = solicitarPorScannerUnString("INGRESE EL PISO");
		String localidad = solicitarPorScannerUnString("INGRESE LA LOCALIDAD");
		Double precio = solicitarPorScannerUnDouble("INGRESE EL PRECIO");
		EstadoPropiedad estado = obtenerEstadoPropiedad();
		propiedadEncontrada.setCalle(calle);
		propiedadEncontrada.setAltura(altura);
		propiedadEncontrada.setNumeroPiso(numPiso);
		propiedadEncontrada.setPiso(piso);
		propiedadEncontrada.setLocalidad(localidad);
		propiedadEncontrada.setPrecio(precio);
		propiedadEncontrada.setEstado(estado);
	}
	private static void modificarCasa(Casa propiedadEncontrada) {
		String calle = solicitarPorScannerUnString("INGRESE LA CALLE");
		Integer altura = solicitarPorScannerUnInteger("INGRESE LA ALTURA");
		String localidad = solicitarPorScannerUnString("INGRESE LA LOCALIDAD");
		Double precio = solicitarPorScannerUnDouble("INGRESE EL PRECIO");
		EstadoPropiedad estado = obtenerEstadoPropiedad(); 
		propiedadEncontrada.setCalle(calle);
		propiedadEncontrada.setAltura(altura);
		propiedadEncontrada.setLocalidad(localidad);
		propiedadEncontrada.setPrecio(precio);
		propiedadEncontrada.setEstado(estado);
	}


	private static EstadoPropiedad obtenerEstadoPropiedad() {
		Boolean salir = false;
		Integer opcion = 0;
		EstadoPropiedad estado = null;
		do {
			System.out.println("INGRESE SU ESTADO\n1-SE VENDE\n2-SE ALQUILA\n3-SE PERMUTA");
			opcion = scanner.nextInt();
			switch (opcion) {
			case 1 :estado= EstadoPropiedad.SE_VENDE;salir=true;			
			break;
			case 2 : estado= EstadoPropiedad.SE_ALQUILA;salir=true;	
			break;
			case 3 : estado= EstadoPropiedad.SE_PERMUTA;salir=true;	
			break;
			default : System.out.println("opcion invalida");
			break;
							}
			}while(salir==false);
		return estado;
	}

}
