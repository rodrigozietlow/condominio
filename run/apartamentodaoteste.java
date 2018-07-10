package run;

import java.util.List;

import apartamento.Apartamento;
import apartamento.ApartamentoDAO;
import apartamento.ApartamentoDAOConcreto;
import morador.Morador;
import morador.MoradorDAO;
import morador.MoradorDAOConcreto;
import morador.MoradorDAODecorator;

public class apartamentodaoteste {

	public static void main(String[] args) {
		ConexaoBD c = new ConexaoBD();
		MoradorDAO moDAO = new MoradorDAODecorator(new MoradorDAOConcreto(c));
		
		ApartamentoDAO dao = new ApartamentoDAOConcreto(c, moDAO);
		
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
	}

}
