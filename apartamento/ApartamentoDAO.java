package apartamento;
import java.util.List;

import morador.Morador;

/**
 * 
 */
public interface ApartamentoDAO {
	
    List<Apartamento> CarregarApartamentos();
    List<Apartamento> CarregarApartamentosMorador(Morador m);
    boolean SalvarApartamento(Apartamento a);
    boolean ExcluirApartamento(Apartamento a);
    
}