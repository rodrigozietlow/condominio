package apartamento;
import java.util.ArrayList;
import java.util.List;

import morador.Morador;

/**
 * 
 */
public class ApartamentoDAOCacheDecorator extends ApartamentoDAODecorator {
	
	private List<Apartamento> cacheApartamentos;
	private boolean cached;
	
    public ApartamentoDAOCacheDecorator(ApartamentoDAO dao) {
		super(dao);
    	this.cacheApartamentos = new ArrayList<Apartamento>();
	}

	@Override
	public List<Apartamento> CarregarApartamentos() {
		
		if(!cached) {
    		this.cacheApartamentos = this.apartamentoDAO.CarregarApartamentos();
    		cached = true;
    	}
		
		return this.cacheApartamentos;
	}
	
	@Override
	public boolean SalvarApartamento(Apartamento a) {
		if(cached && a.getId() == 0) {
    		this.cacheApartamentos.add(a);
    	}
		
        return this.apartamentoDAO.SalvarApartamento(a);
    }
    
	@Override
    public boolean ExcluirApartamento(Apartamento a) {
		if(cached) {
    		for (int i = 0; i < cacheApartamentos.size(); i++) {
				Apartamento apartamento = cacheApartamentos.get(i);
				if(apartamento.getId() == a.getId()) {
					cacheApartamentos.remove(i);
					break;
				}
			}
    	}
		
        return this.apartamentoDAO.ExcluirApartamento(a);
    }

	@Override
	public boolean ExcluirAssociacaoMorador(Apartamento a, Morador m) {
		if(cached) {
			for (Apartamento apartamento : cacheApartamentos) {
				if(apartamento.getId() == a.getId()) {
					for (int i = 0; i < apartamento.getMoradores().size(); i++) {
						Morador morador = apartamento.getMoradores().get(i);
						if(morador.getId() == m.getId()) {
							apartamento.getMoradores().remove(i);
						}
					}
				}
			}
    	}
		
		return this.apartamentoDAO.ExcluirAssociacaoMorador(a, m);
	}

	@Override
	public boolean AdicionarAssociacaoMorador(Apartamento a, Morador m) {
		if(cached) {
			for (Apartamento apartamento : cacheApartamentos) {
				if(a.getId() == apartamento.getId()) {
					apartamento.getMoradores().add(m);
				}
			}
		}
		return this.apartamentoDAO.AdicionarAssociacaoMorador(a, m);
	}

}