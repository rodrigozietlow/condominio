package apartamento;
import java.util.List;

import morador.Morador;

/**
 * 
 */
public abstract class ApartamentoDAODecorator implements ApartamentoDAO {

	protected ApartamentoDAO apartamentoDAO;
	
    public ApartamentoDAODecorator(ApartamentoDAO dao) {
    	this.apartamentoDAO = dao;
    }

    public abstract List<Apartamento> CarregarApartamentos();
    
    public boolean SalvarApartamento(Apartamento a) {
        return this.apartamentoDAO.SalvarApartamento(a);
    }
    
    public boolean ExcluirApartamento(Apartamento a) {
        return this.apartamentoDAO.ExcluirApartamento(a);
    }

    public boolean ExcluirAssociacaoMorador(Apartamento a, Morador m) {
    	return this.apartamentoDAO.ExcluirAssociacaoMorador(a, m);
    }
    public boolean AdicionarAssociacaoMorador(Apartamento a, Morador m) {
    	return this.apartamentoDAO.AdicionarAssociacaoMorador(a, m);
    }
}