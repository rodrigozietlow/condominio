package edificio;
import java.util.List;

import run.ConexaoBD;

/**
 * 
 */
public class EdificioDAOConcreto implements EdificioDAO {

	ConexaoBD conexao;
	
    public EdificioDAOConcreto(ConexaoBD c) {
    	this.conexao = c;
    }

    public List<Edificio> CarregarEdificios() {
        // TODO implement here
        return null;
    }

    public boolean SalvarEdificio(Edificio e) {
        // TODO implement here
        return false;
    }
    
    public boolean ExcluirEdificio(Edificio e) {
        // TODO implement here
        return false;
    }

}