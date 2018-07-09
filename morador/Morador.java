package morador;

import apartamento.Apartamento;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 */
public class Morador {

	private int id;
    private String nome;
    private String cpf;
    private String rg;
    private char sexo;
    private int idade;
    private float renda;
    private List<Apartamento> apartamentos;

	
    public Morador(int id, String nome, String cpf, String rg, char sexo, int idade, float renda, List<Apartamento> apartamentos) {
    	this.id = id;
    	this.nome = nome;
    	this.cpf = cpf;
    	this.rg = rg;
    	this.sexo = sexo;
    	this.idade = idade;
    	this.renda = renda;
    	this.apartamentos = apartamentos;
    }


	public Morador(String nome, String cpf, String rg, char sexo, int idade, float renda,
			List<Apartamento> apartamentos) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
		this.idade = idade;
		this.renda = renda;
		this.apartamentos = apartamentos;
	}

	public Morador(int id) {
		this.id = id;
		this.apartamentos = new ArrayList<Apartamento>();
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


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public char getSexo() {
		return sexo;
	}


	public void setSexo(char sexo) {
		this.sexo = sexo;
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}


	public float getRenda() {
		return renda;
	}


	public void setRenda(float renda) {
		this.renda = renda;
	}


	public List<Apartamento> getApartamentos() {
		return apartamentos;
	}

	public void setApartamentos(List<Apartamento> apartamentos) {
		this.apartamentos = apartamentos;
	}
	
}