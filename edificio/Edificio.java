package edificio;

import java.util.ArrayList;
import java.util.List;
import condominio.Condominio;
import apartamento.Apartamento;


public class Edificio {
    private int id;
    private int andares;
    private String cor;
    private Condominio condominio;
    private List<Apartamento> apartamentos;
    
	public Edificio(int id, int andares, String cor, Condominio condominio, List<Apartamento> apartamentos) {
		this.id = id;
		this.andares = andares;
		this.cor = cor;
		this.condominio = condominio;
		this.apartamentos = apartamentos;
	}
	
	public Edificio(int andares, String cor, Condominio condominio, List<Apartamento> apartamentos) {
		this.andares = andares;
		this.cor = cor;
		this.condominio = condominio;
		this.apartamentos = apartamentos;
	}
	
	public Edificio(int id) {
		this.id = id;
		this.apartamentos = new ArrayList<Apartamento>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAndares() {
		return andares;
	}
	public void setAndares(int andares) {
		this.andares = andares;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Condominio getCondominio() {
		return condominio;
	}
	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}
	public List<Apartamento> getApartamentos() {
		return apartamentos;
	}
	public void setApartamentos(List<Apartamento> apartamentos) {
		this.apartamentos = apartamentos;
	}
}