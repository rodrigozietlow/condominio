package apartamento;
import java.util.List;

/**
 * 
 */
public interface ApartamentoDAO {
	
    List<Apartamento> CarregarApartamentos();
    boolean SalvarApartamento(Apartamento a);
    boolean ExcluirApartamento(Apartamento a);
    
}