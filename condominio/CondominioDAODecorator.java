package condominio;
import java.util.ArrayList;
import java.util.List;


public class CondominioDAODecorator implements CondominioDAO {

    private CondominioDAO condominioDAO;
    private List<Condominio> cache;
    private boolean cached;
    
    public CondominioDAODecorator(CondominioDAO dao) {
    	this.condominioDAO = dao;
    	this.cache = new ArrayList<Condominio>();
    }
    
    public List<Condominio> CarregarCondominios() {
    	
    	if(!cached) {
    		this.cache = this.condominioDAO.CarregarCondominios();
    		cached = true;
    	}
    	
        return this.cache;
    }
    
    public boolean SalvarCondominio(Condominio c) {
    	// se já fizemos cache dos condominios e é uma inserção no banco, precisamos adicionar o objeto no nosso cache
    	if(cached && m.getId() == 0) {
    		this.cache.add(c);
    	}
        return this.condominioDAO.SalvarCondominio(c);
    }

    public boolean ExcluirCondominio(Condominio c) {
    	// se já fizemos cache dos condominios, precisamos remover a referencia do id dos objetos em cache
    	if(cached) {
    		for (int i = 0; i < cache.size(); i++) {
				Condominio condominio = cache.get(i);
				if(condominio.getId() == m.getId()) {
					cache.remove(i);
					break;
				}
			}
    	}
    	
    	
        return this.condominioDAO.ExcluirCondominio(c);
    }
}