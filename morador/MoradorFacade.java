package morador;
import java.util.ArrayList;
import java.util.List;

import apartamento.Apartamento;
import apartamento.ApartamentoFacade;
import run.ConexaoBD;

public class MoradorFacade {
	
	private MoradorDAO dao;
	
    public MoradorFacade(ConexaoBD c) {
    	this.dao = new MoradorDAODecorator(new MoradorDAOConcreto(c));
    }
    
    public List<Morador> ListarMoradores() {
        return this.dao.CarregarMoradores();
    }
    public Morador BuscarMorador(int id) {
    	System.out.println("Buscando morador de id "+id);
        for (Morador morador: this.dao.CarregarMoradores() ) {
			if(morador.getId() == id) {
				return morador;
			}
		}
        return null;
    }
    public boolean CadastrarMorador(String nome, String cpf, String rg, char sexo, int idade, float renda) {
        Morador m = new Morador(nome, cpf, rg, sexo, idade, renda, new ArrayList<Apartamento>());
        return this.dao.SalvarMorador(m);
    }
    public boolean EditarMorador(int id, String nome, String cpf, String rg, char sexo, int idade, float renda) {
        Morador m = this.BuscarMorador(id);
        return this.dao.SalvarMorador(m);
    }
    public boolean ExcluirMorador(int id) {
        return this.dao.ExcluirMorador(new Morador(id));
    }
    
    public MoradorDAO getDAO() {
    	return this.dao;
    }

}