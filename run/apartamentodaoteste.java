package run;

import java.util.List;

import apartamento.Apartamento;
import apartamento.ApartamentoDAO;
import apartamento.ApartamentoDAOConcreto;

public class apartamentodaoteste {

	public static void main(String[] args) {
		ConexaoBD c = new ConexaoBD();
		
		ApartamentoDAO dao = new ApartamentoDAOConcreto(c);
		
		List<Apartamento> lista = dao.CarregarApartamentos();
		
		for (Apartamento apartamento : lista) {
			System.out.println("AP "+apartamento.getAndar()+"-"+apartamento.getNumero()+" - "+apartamento.getClass()+" com "+apartamento.getMoradores().size());
		}
	}

}
