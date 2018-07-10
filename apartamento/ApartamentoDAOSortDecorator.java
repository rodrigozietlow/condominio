package apartamento;
import java.util.*;

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
        return aps; // isto é uma gambiarra
    }
    
    public void setSortStrategy(ApartamentoSortStrategy strategy) {
    	this.sortStrategy = strategy;
    }
}