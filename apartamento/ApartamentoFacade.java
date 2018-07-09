
import java.util.*;

/**
 * 
 */
public class ApartamentoFacade {

    /**
     * Default constructor
     */
    public ApartamentoFacade() {
    }



    /**
     * @param strategy 
     * @return
     */
    public Apartamento ListarApartamentos(ApartamentoSortStrategy strategy) {
        // TODO implement here
        return null;
    }

    /**
     * @param id 
     * @return
     */
    public Apartamento BuscarApartamento(int id) {
        // TODO implement here
        return null;
    }

    /**
     * @param numero 
     * @param andar 
     * @param tipoArmarios 
     * @param tipoPisos 
     * @return
     */
    public boolean CadastrarApartamentoSimples(int numero, int andar, String tipoArmarios, String tipoPisos) {
        // TODO implement here
        return false;
    }

    /**
     * @param numero 
     * @param andar 
     * @param luminarias 
     * @param geladeira 
     * @param fogao 
     * @return
     */
    public boolean CadastrarApartamentoLuxo(int numero, int andar, String luminarias, boolean geladeira, boolean fogao) {
        // TODO implement here
        return false;
    }

    /**
     * @param id 
     * @param numero 
     * @param andar 
     * @param tipoArmarios 
     * @param tipoPisos 
     * @return
     */
    public boolean EditarApartamentoSimples(int id, int numero, int andar, String tipoArmarios, String tipoPisos) {
        // TODO implement here
        return false;
    }

    /**
     * @param id 
     * @param numero 
     * @param andar 
     * @param luminarias 
     * @param geladeira 
     * @param fogao 
     * @return
     */
    public boolean EditarApartamentoLuxo(int id, int numero, int andar, String luminarias, boolean geladeira, boolean fogao) {
        // TODO implement here
        return false;
    }

    /**
     * @param id 
     * @return
     */
    public boolean ExcluirApartamento(int id) {
        // TODO implement here
        return false;
    }

    /**
     * @param idApartamento 
     * @param idMorador 
     * @return
     */
    public boolean AssociarMorador(int idApartamento, int idMorador) {
        // TODO implement here
        return false;
    }

    /**
     * @param idApartamento 
     * @return
     */
    public boolean DesassociarMorador(int idApartamento) {
        // TODO implement here
        return false;
    }

}