package morador;
import java.util.List;

public interface MoradorDAO {
    List<Morador> CarregarMoradores();
    boolean SalvarMorador(Morador m);
    boolean ExcluirMorador(Morador m);
}