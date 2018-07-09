
import java.util.*;

/**
 * 
 */
public class ApartamentoDAOCacheDecorator extends ApartamentoDAODecorator {

    /**
     * Default constructor
     */
    public ApartamentoDAOCacheDecorator() {
    }

    /**
     * 
     */
    private Set<Apartamento> cacheApartamentos;

    /**
     * @return
     */
    public Apartamento CarregarApartamentos() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public abstract Apartamento CarregarApartamentos();

}