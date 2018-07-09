package morador;
import java.util.ArrayList;
import java.util.List;


public class MoradorDAODecorator implements MoradorDAO {

    private MoradorDAO moradorDAO;
    private List<Morador> cache;
    private boolean cached;
    
    public MoradorDAODecorator(MoradorDAO dao) {
    	this.moradorDAO = dao;
    	this.cache = new ArrayList<Morador>();
    }
    
    public List<Morador> CarregarMoradores() {
    	
    	if(!cached) {
    		this.cache = this.moradorDAO.CarregarMoradores();
    		cached = true;
    	}
    	
        return this.cache;
    }
    
    public boolean SalvarMorador(Morador m) {
    	// se já fizemos cache dos moradores e é uma inserção no banco, precisamos adicionar o objeto no nosso cache
    	if(cached && m.getId() == 0) {
    		this.cache.add(m);
    	}
        return this.moradorDAO.SalvarMorador(m);
    }

    public boolean ExcluirMorador(Morador m) {
    	// se já fizemos cache dos moradores, precisamos remover a referencia do id dos objetos em cache
    	if(cached) {
    		for (int i = 0; i < cache.size(); i++) {
				Morador morador = cache.get(i);
				if(morador.getId() == m.getId()) {
					cache.remove(i);
					break;
				}
			}
    	}
    	
    	
        return this.moradorDAO.ExcluirMorador(m);
    }
}