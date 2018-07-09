package condominio;

import java.util.List;
import edificio.Edificio;



public class Condominio {
    private int id;
    private String nome;
    private String cidade;
    private String bairro;
    private String numero;
    private List<Edificio> edificios;
    
	public Condominio(int id, String nome, String cidade, String bairro, String numero, List<Edificio> edificios) {
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.bairro = bairro;
		this.numero = numero;
		this.edificios = edificios;
	}

	public Condominio(String nome, String cidade, String bairro, String numero, List<Edificio> edificios) {
		this.nome = nome;
		this.cidade = cidade;
		this.bairro = bairro;
		this.numero = numero;
		this.edificios = edificios;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Edificio> getEdificios() {
		return edificios;
	}

	public void setEdificios(List<Edificio> edificios) {
		this.edificios = edificios;
	}
    
}