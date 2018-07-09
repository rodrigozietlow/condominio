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
        return this.sortStrategy.Sort(this.apartamentoDAO.CarregarApartamentos());
    }
}