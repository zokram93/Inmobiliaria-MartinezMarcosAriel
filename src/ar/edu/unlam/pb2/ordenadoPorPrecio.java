package ar.edu.unlam.pb2;

import java.util.Comparator;

public class ordenadoPorPrecio implements Comparator<Propiedad> {


	@Override
	public int compare(Propiedad casa1, Propiedad casa2) {
			return (int) (casa1.getPrecio()-casa2.getPrecio());
		}	
	}