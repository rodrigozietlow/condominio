package edificio;
import java.util.List;

/**
 * 
 */
public abstract class EdificioDAODecorator implements EdificioDAO {

    private EdificioDAO dao;
    
    public EdificioDAODecorator(EdificioDAO dao) {
    	this.dao = dao;
    }

    public List<Edificio> CarregarEdificios(){
    	return null;
    }

    public boolean SalvarEdificio(Edificio e) {
        // TODO implement here
        return false;
    }

    /**
     * @param e 
     * @return
     */
    public boolean ExcluirEdificio(Edificio e) {
        // TODO implement here
        return false;
    }

}