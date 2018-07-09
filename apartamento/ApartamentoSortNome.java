package apartamento;
import java.util.*;

/**
 * 
 */
public class ApartamentoSortNome implements ApartamentoSortStrategy {

	public List<Apartamento> Sort(List<Apartamento> apartamentos) {
		apartamentos.sort(Comparator.comparingInt(Apartamento::getNumero));
		return apartamentos;
	}

}