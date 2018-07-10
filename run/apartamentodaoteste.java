package run;

import java.util.ArrayList;
import java.util.List;

import apartamento.Apartamento;
import apartamento.ApartamentoDAO;
import apartamento.ApartamentoDAOCacheDecorator;
import apartamento.ApartamentoDAOConcreto;
import apartamento.Luxo;
import apartamento.Padrão;
import edificio.Edificio;
import morador.Morador;
import morador.MoradorDAO;
import morador.MoradorDAOConcreto;
import morador.MoradorDAODecorator;

public class apartamentodaoteste {

	public static void main(String[] args) {
		ConexaoBD c = new ConexaoBD();
		MoradorDAO moDAO = new MoradorDAODecorator(new MoradorDAOConcreto(c));
		
		ApartamentoDAO dao = new ApartamentoDAOCacheDecorator(new ApartamentoDAOConcreto(c, moDAO));
		
		/*
		List<Apartamento> lista = dao.CarregarApartamentos();
		
		for (Apartamento apartamento : lista) {
			System.out.println("AP "+apartamento.getAndar()+"-"+apartamento.getNumero()+" - "+apartamento.getClass()+" com "+apartamento.getMoradores().size());
		}
		
		System.out.println("==================");
		
		for (Morador m : moDAO.CarregarMoradores()) {
			System.out.println("Nome "+m.getNome()+" apartamentos:");
			for (Apartamento apartamento : m.getApartamentos()) {
				System.out.println("AP "+apartamento.getAndar()+"-"+apartamento.getNumero()+" - "+apartamento.getClass()+" com "+apartamento.getMoradores().size());
			}
		}
		
		System.out.println(lista.get(1).getId());
		System.out.println(moDAO.CarregarMoradores().get(0).getId());
		boolean x = dao.ExcluirAssociacaoMorador(lista.get(0), moDAO.CarregarMoradores().get(0));
		boolean y = dao.AdicionarAssociacaoMorador(lista.get(0), moDAO.CarregarMoradores().get(0));
		System.out.println(x);
		System.out.println(y);
		*/
		Edificio e = new Edificio(2);
		
		Apartamento a1 = new Luxo(1, 3, e, new ArrayList<Morador>(), "Luminárias azuis", true, true);
		Apartamento a2 = new Luxo(10, 2, e, new ArrayList<Morador>(), "Luminárias verdes", false, true);
		Apartamento a3 = new Luxo(14, 1, e, new ArrayList<Morador>(), "", true, false);
		
		Apartamento a4 = new Padrão(3, 1, e, new ArrayList<Morador>(), "Armários simples", "Carpete");
		Apartamento a5 = new Padrão(4, 1, e, new ArrayList<Morador>(), "Sem armários", "Azulejo");
		
		//dao.SalvarApartamento(a2);
		//a2.setAndar(3);
		//dao.SalvarApartamento(a2);
		//dao.SalvarApartamento(a5);
		//dao.ExcluirApartamento(new Luxo(12));
		//dao.ExcluirApartamento(new Padrão(13));
	}

}
