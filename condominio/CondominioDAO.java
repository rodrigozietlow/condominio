
import java.util.*;

/**
 * 
 */
public interface CondominioDAO {

    List<Condominio> CarregarCondominios();
    boolean SalvarCondominio(Condominio c);
    boolean ExcluirCondominio(Condominio c);

}