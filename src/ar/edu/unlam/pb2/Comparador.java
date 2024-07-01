package ar.edu.unlam.pb2;

import java.util.Comparator;

public class Comparador implements Comparator <Casa>{

	@Override
	public int compare(Casa casa1, Casa casa2) {
		// TODO Auto-generated method stub
		return casa1.getLocalidad().compareTo(casa2.getLocalidad());
	}

}
