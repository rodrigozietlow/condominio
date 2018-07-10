package run;

import java.util.ArrayList;
import java.util.Scanner;

import apartamento.Apartamento;
import morador.Morador;
import morador.MoradorFacade;

public class Main {
    private static MoradorFacade mf;
	private static Scanner s;

	public static void main(String[] args) {
    	s = new Scanner(System.in);
    	
    	int modulo, opcao;
    	
    	ConexaoBD c = new ConexaoBD();
    	mf = new MoradorFacade(c);
    	
    	while(true) {
    		System.out.println("Digite o módulo que deseja trabalhar: ");
    		System.out.println("1 - Moradores");
    		
    		modulo = s.nextInt();
    		
    		if(modulo == 1) {
    			while(true) {
    				System.out.println("Digite a operação que deseja realizar: ");
    				System.out.println("1 - Listar todos os moradores");
    				System.out.println("2 - Cadastrar novo morador");
    				System.out.println("3 - Visualizar informações de um morador");
    				System.out.println("4 - Editar morador");
    				System.out.println("5 - Excluir morador");
    				System.out.println("0 - Voltar à opção anterior");
    				
    				opcao = s.nextInt();
    				if(opcao == 1) {
						listarMoradores();
					}
    				else if(opcao == 2) {
    					cadastrarMorador();
    				}
    				else if(opcao == 3) {
    					informacoesMorador();
    				}
    				else if(opcao == 4) {
    					editarMorador();
    				}
    				else if(opcao == 5) {
    					excluirMorador();
    				}
    				else if(opcao == 0) {
    					break;
    				}
    			}
    		}
    	}
    }
    
    public static void listarMoradores() {
    	if(mf.ListarMoradores().size() > 0) {
			for (Morador morador : mf.ListarMoradores()) {
				System.out.print("Morador nro "+morador.getId()+": "+morador.getNome());
				if(morador.getApartamentos().size() > 0) {
					System.out.println(", Atualmente cadastrado em "+morador.getApartamentos().size()+" apartamentos");
				}
				System.out.println();
			}
		}
		else {
			System.out.println("Nenhum morador cadastrado");							
		}
    }
    
    public static void cadastrarMorador() {
    	s.nextLine(); // limpar as linhas
    	String nome, cpf, rg;
    	char sexo;
    	int idade;
    	float renda;
    	
    	while(true) {
    		System.out.println("Digite o nome do morador:");
    		try {
				nome = s.nextLine();
				break;
			} catch (Exception e) {
				System.out.println("Digite um nome válido");
			}
    		
    		// if(nome) é valido
    	}
    	while(true) {
    		System.out.println("Digite o cpf do morador:");
    		try {
				cpf = s.nextLine();
			} catch (Exception e) {
				System.out.println("Digite um cpf válido");
				cpf = "";
			}
    		
    		if(cpf.length() == 14) {
				break;
			}
			else {
				System.out.println("O cpf não possui 14 dígitos");
			}
    	}
    	// TODO: entradas válidas?
    	
    	while(true) {
    		System.out.println("Digite o rg do morador");
    		rg = s.nextLine();
    		
    		System.out.println("Digite o sexo do morador");
    		sexo = s.nextLine().charAt(0);
    		
    		System.out.println("Digite a idade do morador");
    		idade = s.nextInt();
    		s.nextLine();
    		
    		System.out.println("Digite a renda do morador");
    		renda = s.nextFloat();
    		s.nextLine();
    		
    		break;
    	}
    	System.out.println("Saiu do while");
    	
    	if(mf.CadastrarMorador(nome, cpf, rg, sexo, idade, renda)) {
    		System.out.println("Morador salvo com sucesso");
    	}
    	else {
    		System.out.println("Erro na hora de salvar o morador");
    	}
    }
    public static void editarMorador() {
    	s.nextLine(); // limpar o buffer
    	String nome, cpf, rg;
    	char sexo;
    	int idade, id;
    	float renda;
    	
    	
    	
    	while(true) {
    		System.out.println("Digite o nome do morador:");
    		try {
				nome = s.nextLine();
				break;
			} catch (Exception e) {
				System.out.println("Digite um nome válido");
			}
    		
    		// if(nome) é valido
    	}
    	while(true) {
    		System.out.println("Digite o cpf do morador:");
    		try {
				cpf = s.nextLine();
			} catch (Exception e) {
				System.out.println("Digite um cpf válido");
				cpf = "";
			}
    		
    		if(cpf.length() == 14) {
				break;
			}
			else {
				System.out.println("O cpf não possui 14 dígitos");
			}
    	}
    	// TODO: fazer, pois cansei
    	
    	while(true) {
    		System.out.println("Digite o rg do morador");
    		rg = s.nextLine();
    		
    		System.out.println("Digite o sexo do morador");
    		sexo = s.nextLine().charAt(0);
    		
    		System.out.println("Digite a idade do morador");
    		idade = s.nextInt();
    		s.nextLine();
    		
    		System.out.println("Digite a renda do morador");
    		renda = s.nextFloat();
    		
    		System.out.println("Digite o identificador do morador");
    		id = s.nextInt();
    		
    		break;
    	}
    	System.out.println("Saiu do while");
    	
    	if(mf.EditarMorador(id, nome, cpf, rg, sexo, idade, renda)) {
    		System.out.println("Morador editado com sucesso");
    	}
    	else {
    		System.out.println("Erro na hora de editar o morador");
    	}
    }
    
    
    public static void excluirMorador() {
    	System.out.println("Digite o identificador do morador a ser excluído:");
    	int id = s.nextInt();
    	if(mf.ExcluirMorador(id)) {
    		System.out.println("Excluído com sucesso");
    	}
    	else {
    		System.out.println("Erro na hora de excluir o morador");
    	}
    }
    
    public static void informacoesMorador() {
    	System.out.println("Digite o identificador do morador a ser visualizado:");
    	int id = s.nextInt();
    	Morador m = mf.BuscarMorador(id);
    	if(m != null) {
    		System.out.println("Informações do morador "+m.getNome());
    		System.out.println("CPF: "+m.getCpf());
    		System.out.println("RG: "+m.getRg());
    		System.out.println("Sexo: "+m.getSexo());
    		System.out.println("Idade: "+m.getIdade());
    		System.out.println("Renda: "+m.getRenda());
    		if(m.getApartamentos().size() > 0) {
    			System.out.println("Atualmente associado a "+m.getApartamentos().size()+" apartamentos");
    		}
    	}
    	else {
    		System.out.println("Nenhum morador encontrado com esse identificador");
    	}
    }
}