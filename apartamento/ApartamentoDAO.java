package apartamento;
import java.util.List;

import morador.Morador;

/**
 * 
 */
public interface ApartamentoDAO {
	
    List<Apartamento> CarregarApartamentos();
    boolean SalvarApartamento(Apartamento a);
    boolean ExcluirApartamento(Apartamento a);
    boolean ExcluirAssociacaoMorador(Apartamento a, Morador m);
    boolean AdicionarAssociacaoMorador(Apartamento a, Morador m);
}