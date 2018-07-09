package apartamento;
import java.util.ArrayList;
import java.util.List;

import run.ConexaoBD;

/**
 * 
 */
public class ApartamentoDAOConcreto implements ApartamentoDAO {

	private ConexaoBD conexao;
	
    public ApartamentoDAOConcreto(ConexaoBD c) {
    	this.conexao = c;
    }

    public List<Apartamento> CarregarApartamentos() {
        List<Apartamento> lista = new ArrayList<Apartamento>();
        
        return null;
    }
    
    public boolean SalvarApartamento(Apartamento a) {
        // TODO implement here
        return false;
    }

    public boolean ExcluirApartamento(Apartamento a) {
        // TODO implement here
        return false;
    }
}