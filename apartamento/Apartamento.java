package apartamento;

import java.util.ArrayList;
import java.util.List;
import edificio.Edificio;
import morador.Morador;

/**
 * 
 */
public abstract class Apartamento {
    private int id;
    private int numero;
    private int andar;
    private Edificio edificio;
    private List<Morador> moradores;
    
	public Apartamento(int id, int numero, int andar, Edificio edificio, List<Morador> moradores) {
		this.id = id;
		this.numero = numero;
		this.andar = andar;
		this.edificio = edificio;
		this.moradores = moradores;
	}

	public Apartamento(int numero, int andar, Edificio edificio, List<Morador> moradores) {
		this.numero = numero;
		this.andar = andar;
		this.edificio = edificio;
		this.moradores = moradores;
	}
	
	public Apartamento(int id) {
		this.id = id;
		this.moradores = new ArrayList<Morador>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	public List<Morador> getMoradores() {
		return moradores;
	}

	public void setMoradores(List<Morador> moradores) {
		this.moradores = moradores;
	}
	
}