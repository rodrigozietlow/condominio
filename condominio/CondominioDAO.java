
import java.util.*;

/**
 * 
 */
public abstract class CondominioDAO {

    /**
     * Default constructor
     */
    public CondominioDAO() {
    }

    /**
     * 
     */
    private ConexaoBD conexao;

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