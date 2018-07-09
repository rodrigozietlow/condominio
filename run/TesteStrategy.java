package run;

import java.util.ArrayList;
import java.util.List;

import apartamento.Apartamento;
import edificio.Edificio;
import morador.Morador;

public class TesteStrategy {

	public static void main(String[] args) {
		List<Apartamento> l = new ArrayList<Apartamento>();
		
		Apartamento a1 = new Apartamento(12, 3, new Edificio(1), new ArrayList<Morador>());
	}

}
