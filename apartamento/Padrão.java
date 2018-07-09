package apartamento;

import java.util.List;

import edificio.Edificio;
import morador.Morador;

public class Padrão extends Apartamento {

	private String tipoArmarios;
    private String tipoPisos;
    
	public Padrão(int id, int numero, int andar, Edificio edificio, List<Morador> moradores, String tipoArmarios,
			String tipoPisos) {
		super(id, numero, andar, edificio, moradores);
		this.tipoArmarios = tipoArmarios;
		this.tipoPisos = tipoPisos;
	}

	public Padrão(int numero, int andar, Edificio edificio, List<Morador> moradores, String tipoArmarios,
			String tipoPisos) {
		super(numero, andar, edificio, moradores);
		this.tipoArmarios = tipoArmarios;
		this.tipoPisos = tipoPisos;
	}
	
	public Padrão(int id) {
		super(id);
	}

	public String getTipoArmarios() {
		return tipoArmarios;
	}

	public void setTipoArmarios(String tipoArmarios) {
		this.tipoArmarios = tipoArmarios;
	}

	public String getTipoPisos() {
		return tipoPisos;
	}

	public void setTipoPisos(String tipoPisos) {
		this.tipoPisos = tipoPisos;
	}
}