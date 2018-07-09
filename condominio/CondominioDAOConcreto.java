
import java.util.*;

/**
 * 
 */
public class CondominioDAOConcreto extends CondominioDAO {

    /**
     * Default constructor
     */
    public CondominioDAOConcreto() {
    }

    /**
     * @return
     */
    public Condominio CarregarCondominios() {
        // TODO implement here
        return null;
    }

    /**
     * @param c 
     * @return
     */
    public boolean SalvarCondominio(Condominio c) {
        // TODO implement here
        return false;
    }

    /**
     * @param c 
     * @return
     */
    public boolean ExcluirCondominio(Condominio c) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public abstract Condominio CarregarCondominios();

    /**
     * @param c 
     * @return
     */
    public abstract boolean SalvarCondominio(Condominio c);

    /**
     * @param c 
     * @return
     */
    public abstract boolean ExcluirCondominio(Condominio c);

}