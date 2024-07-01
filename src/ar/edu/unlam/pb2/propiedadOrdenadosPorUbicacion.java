package ar.edu.unlam.pb2;

import java.util.Comparator;

public class propiedadOrdenadosPorUbicacion implements Comparator<Propiedad> {

	@Override
	public int compare(Propiedad propiedad, Propiedad propiedad1) {
		//ORDENAMIENTOS PARA LA CASA.
		if(propiedad instanceof Casa && propiedad1 instanceof Casa ) {
			Casa casa = ((Casa)propiedad);
			Casa casa1 = ((Casa)propiedad1);
			if(casa.getLocalidad().compareTo(casa1.getLocalidad())==0) {
				if(casa.getCalle().compareTo(casa1.getCalle())==0) {
					return casa.getAltura().compareTo(casa1.getAltura());
				}
				return casa.getCalle().compareTo(casa1.getCalle());
			}
			return casa.getLocalidad().compareTo(casa1.getLocalidad());
		}
		
		//ORDENAMIENTO PARA DEPARTAMENTOS
		if(propiedad instanceof Departamento && propiedad1 instanceof Departamento ) {
			Departamento dpto  = ((Departamento)propiedad);
			Departamento dpto1  = ((Departamento)propiedad1);
			if(dpto.getLocalidad().compareTo(dpto1.getLocalidad())==0) {
				if(dpto.getCalle().compareTo(dpto1.getCalle())==0) {
					if(dpto.getAltura().compareTo(dpto1.getAltura())==0) {
						if((dpto).getNumeroPiso().compareTo((dpto1).getNumeroPiso())==0) {
							return (dpto).getPiso().compareTo((dpto1).getPiso());
						}
						return (dpto).getNumeroPiso().compareTo((dpto1).getNumeroPiso());
					}
					return dpto.getAltura().compareTo(dpto1.getAltura());
				}
				return dpto.getCalle().compareTo(dpto1.getCalle());
			}
			return dpto.getLocalidad().compareTo(dpto1.getLocalidad());
		}
		
		//ORDENAMIENTO POR EL RESTO DE LAS PROPIEDADES
		return propiedad.getLocalidad().compareTo(propiedad1.getLocalidad());
		
	}

}
