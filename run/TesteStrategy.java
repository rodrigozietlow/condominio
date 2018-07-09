package run;

import java.util.ArrayList;
import java.util.List;

import apartamento.Apartamento;
import apartamento.ApartamentoSortAndarNumero;
import apartamento.ApartamentoSortStrategy;
import apartamento.ApartamentoSortVazios;
import apartamento.Luxo;
import apartamento.Padrão;
import edificio.Edificio;
import morador.Morador;

public class TesteStrategy {

	public static void main(String[] args) {
		List<Apartamento> l = new ArrayList<Apartamento>();
		Edificio e = new Edificio(1);
		Morador m1 = new Morador(1);
		Morador m2 = new Morador(2);
		Morador m3 = new Morador(3);
		
		Apartamento a1 = new Luxo(1, 3, e, new ArrayList<Morador>(), "Lumináias azuis", true, true);
		Apartamento a2 = new Luxo(10, 2, e, new ArrayList<Morador>(), "Lumináias verdes", false, true);
		Apartamento a3 = new Luxo(14, 1, e, new ArrayList<Morador>(), "", true, false);
		
		Apartamento a4 = new Padrão(3, 1, e, new ArrayList<Morador>(), "Armários simples", "Carpete");
		Apartamento a5 = new Padrão(4, 1, e, new ArrayList<Morador>(), "Sem armários", "Azulejo");
		
		l.add(a1);
		l.add(a2);
		l.add(a3);
		l.add(a4);
		l.add(a5);
		
		a1.getMoradores().add(m1);
		a1.getMoradores().add(m2);
		
		a4.getMoradores().add(m3);
		
		ApartamentoSortStrategy ss1 = new ApartamentoSortAndarNumero();
		ApartamentoSortStrategy ss2 = new ApartamentoSortVazios();
		
		System.out.println("padrão");
		for (Apartamento apartamento : l) {
			System.out.println("AP "+apartamento.getAndar()+"-"+apartamento.getNumero()+" - "+apartamento.getClass()+" com "+apartamento.getMoradores().size());
		}
		ss1.Sort(l);
		System.out.println("SortAndar");
		for (Apartamento apartamento : l) {
			System.out.println("AP "+apartamento.getAndar()+"-"+apartamento.getNumero()+" - "+apartamento.getClass()+" com "+apartamento.getMoradores().size());
		}
		ss2.Sort(l);
		System.out.println("SortVazio");
		for (Apartamento apartamento : l) {
			System.out.println("AP "+apartamento.getAndar()+"-"+apartamento.getNumero()+" - "+apartamento.getClass()+" com "+apartamento.getMoradores().size());
		}
	}

}
