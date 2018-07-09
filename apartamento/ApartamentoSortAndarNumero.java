package apartamento;
import java.util.*;

/**
 * 
 */
public class ApartamentoSortAndarNumero implements ApartamentoSortStrategy {

	public void Sort(List<Apartamento> apartamentos) {
		apartamentos.sort(Comparator.comparingInt(Apartamento::getAndar).thenComparing(Comparator.comparingInt(Apartamento::getNumero)));
	}

}