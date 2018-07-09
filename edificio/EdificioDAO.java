package edificio;

import java.util.List;

public interface EdificioDAO {
    List<Edificio> CarregarEdificios();
    boolean SalvarEdificio(Edificio e);
    boolean ExcluirEdificio(Edificio e);
}