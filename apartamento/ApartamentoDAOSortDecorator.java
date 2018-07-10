package apartamento;
import java.util.*;

import morador.Morador;

/**
 * 
 */
public class ApartamentoDAOSortDecorator extends ApartamentoDAODecorator {

    private ApartamentoSortStrategy sortStrategy;
    
    public ApartamentoDAOSortDecorator(ApartamentoDAO dao) {
    	super(dao);
    }

    public List<Apartamento> CarregarApartamentos() {
    	List<Apartamento> aps = this.apartamentoDAO.CarregarApartamentos(); 
    	this.sortStrategy.Sort(aps);
        return aps;
    }
}