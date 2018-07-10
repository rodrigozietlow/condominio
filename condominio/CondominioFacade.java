package condominio;
import java.util.ArrayList;
import java.util.List;

import run.ConexaoBD;

public class CondominioFacade {
	
	private CondominioDAO dao;
	
    public CondominioFacade(ConexaoBD c) {
    	this.dao = new CondominioDAODecorator(new CondominioDAOConcreto(c));
    }
    public List<Condominio> ListarCondominios() {
        return this.dao.CarregarCondominios();
    }
    public Condominio BuscarCondominio(int id) {
    	System.out.println("Buscando condominio de id "+id);
        for (Condominio condominio: this.dao.CarregarCondominios() ) {
			if(condominio.getId() == id) {
				return condominio;
			}
		}
        return null;
    }
    public boolean CadastrarCondominio(String nome, String cidade, String bairro, String numero) {
        Condominio c = new Condominio(nome, cidade, bairro, numero);
        return this.dao.SalvarCondominio(c);
    }
    public boolean EditarCondominio(int id, String nome, String cidade, String bairro, String numero) {
        Condominio c = this.BuscarCondominio(id);
        return this.dao.SalvarCondominio(c);
    }
    public boolean ExcluirCondominio(int id) {
        return this.dao.ExcluirCondominio(new Condominio(id));
    }

}