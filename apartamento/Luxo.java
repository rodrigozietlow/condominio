package apartamento;

import java.util.List;

import edificio.Edificio;
import morador.Morador;

/**
 * 
 */
public class Luxo extends Apartamento {

    private String luminarias;
    private boolean geladeira;
    private boolean fogao;
	
    public Luxo(int id, int numero, int andar, Edificio edificio, List<Morador> moradores, String luminarias,
			boolean geladeira, boolean fogao) {
		super(id, numero, andar, edificio, moradores);
		this.luminarias = luminarias;
		this.geladeira = geladeira;
		this.fogao = fogao;
	}
    public Luxo(int numero, int andar, Edificio edificio, List<Morador> moradores, String luminarias,
			boolean geladeira, boolean fogao) {
		super(numero, andar, edificio, moradores);
		this.luminarias = luminarias;
		this.geladeira = geladeira;
		this.fogao = fogao;
	}
    
    public Luxo(int id) {
    	super(id);
    }
    
	public String getLuminarias() {
		return luminarias;
	}
	public void setLuminarias(String luminarias) {
		this.luminarias = luminarias;
	}
	public boolean isGeladeira() {
		return geladeira;
	}
	public void setGeladeira(boolean geladeira) {
		this.geladeira = geladeira;
	}
	public boolean isFogao() {
		return fogao;
	}
	public void setFogao(boolean fogao) {
		this.fogao = fogao;
	}
}