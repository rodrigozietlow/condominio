package apartamento;
import java.util.*;

/**
 * 
 */
public class ApartamentoSortVazios implements ApartamentoSortStrategy {

	@Override
	public List<Apartamento> Sort(List<Apartamento> apartamentos) {
		apartamentos.sort(new Comparator<Apartamento>() {

			@Override
			public int compare(Apartamento a1, Apartamento a2) {
				if(a1.getMoradores().size() == 0 && a2.getMoradores().size() != 0) {
					return -1;
				}
				else if(a1.getMoradores().size() != 0 && a2.getMoradores().size() == 0) {
					return 1;
				}
				else {
					if(a1.getNumero() > a2.getNumero()) {
						return -1;
					}
					else {
						return 1;
					}
				}
			}
			
		});
		return apartamentos;
	}

}