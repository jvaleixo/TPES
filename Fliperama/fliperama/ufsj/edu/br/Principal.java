package fliperama.ufsj.edu.br;
import java.util.ArrayList;
import java.util.List;

import fliperama.ufsj.edu.br.util.Scan;

public class Principal {
	
	private static List<Atendente> atendentes =  new ArrayList<Atendente>();
	private static List<Cliente> clientes =  new ArrayList<Cliente>();
	private static List<Jogo> jogos =  new ArrayList<Jogo>();
	
	public static void main(String[] args) {
		
		//primeiro Atendente do systema
		Atendente A = new Atendente("admin", "admin");
		atendentes.add(A);
		
		int opcao = 30;
		
		do{
			System.out.println("\t\tMENU\n\n");
			System.out.println("Sair - 0\n");
			System.out.println("Cadastrar Cliente - 1\n");
			System.out.println("Efetuar Login - 2\n");
			System.out.println("Escolha uma opção: ");
			opcao = Integer.parseInt(Scan.readLine());
			
			 switch ( opcao ) {
		        case 1 :
		        	System.out.println("\nCadastar Cliente\n");
		        	cadastrarUsuario(false);
		        	break;
	            case 2 :
	            	Boolean login = true;
	            	while(login) {
	            		System.out.println("\nEfetuar Login");
	            		//como retornar um usuario do tipo Atendente ou Cliente???
	            		Usuario U = realizarLogin();
	            		if(U != null) 
	            			if(U.getRoot()) {
	            				int opcaoatd = 30;
	            				while(opcaoatd != 0) {
	            					System.out.println("\n\nMenu Atendente\n\n");
	            					System.out.println("\nSair - 0");
	            					System.out.println("\nCadastrar Cliente - 1");
	            					System.out.println("\nCadastrar Atendente - 2");
	            					System.out.println("Escolha uma opção: ");
	            					opcaoatd = Integer.parseInt(Scan.readLine());
	            					if(opcaoatd == 0 || opcaoatd == 30) {
	            						login = false;
	            						opcaoatd = 30;
	            						break;
	            					}
	            					
	            					switch(opcaoatd) {
		            					case 1:
		            						System.out.println("\nCadastar Cliente\n");
		            			        	//cadastrarCliente(U);
		            						break;
	            					}
	            				}
	            			}else {
	            				int opcaocl = 30;
	            				while(opcaocl != 0) {
	            					System.out.println("\n\nMenu Cliente\n\n");
	            					System.out.println("\nSair - 0");
	            					System.out.println("Escolha uma opção: ");
	            					opcaocl = Integer.parseInt(Scan.readLine());
	            					if(opcaocl == 0 || opcaocl == 30) {
	            						login = false;
	            						opcaocl = 30;
	            						break;
	            					}
	            				}
	            				
	            			}
	            		else {
	            			System.out.println("\nUsuario ou senha incorretos ou não existente");
	            		}
	            		
	            	}
	            	break;	
			 }
			 
		}while(opcao != 0);
	}
	
	public static void cadastrarUsuario(Boolean root) {
		
		System.out.println("Nome de Usuario: ");
	    String nome = Scan.readLine();
	    System.out.println("Senha do Usuario: ");
	    String senha = Scan.readLine();
	    
	    if(root) {
	    	
			Atendente a = new Atendente(nome, senha);
			atendentes.add(a);
			System.out.println("\nAtendente Cadastrado\n\n");
			
		}else {
			
			Cliente c = new Cliente(nome, senha);
			System.out.println("\n nome: " + nome + " Senha: " + senha);
			System.out.println("\n nome: " + c.getNome() + " Senha: " + c.getSenha());
			clientes.add(c);
			System.out.println("\nCliente Cadastrado\n\n");

		}
	}
	
	//tipo de retorno diferentes?????????
	public static Usuario realizarLogin() {

		System.out.println("Login: ");
	    String nome = Scan.readLine();
	    System.out.println("Senha: ");
	    String senha = Scan.readLine();
	    
	    for(Atendente atendente : atendentes) {
	    	System.out.println("\n nome: " + atendente.getNome() + " Senha: " + atendente.getSenha());
	    	if(atendente.fazerLogin(nome, senha)){
	    		return atendente;
	    	}
	    }
	    for(Cliente cliente : clientes) {
	    	System.out.println("\n nome: " + cliente.getNome() + " Senha: " + cliente.getSenha());
	    	if(cliente.fazerLogin(nome, senha)){
	    		return cliente;
	    	}
	    }
	    return null;
	}
	
	public static void cadastrarCliente(Atendente U) {
		
		System.out.println("Nome de Usuario: ");
	    String nome = Scan.readLine();
	    System.out.println("Senha do Usuario: ");
	    String senha = Scan.readLine();
	    System.out.println("Numero de Creditos: ");
	    String creditos = Scan.readLine();
    	
	    Cliente c = new Cliente(nome, senha);
    	U.cadastrarCliente(c, Integer.parseInt(creditos));
		clientes.add(c);
		System.out.println("\nCliente Cadastrado\n\n");
		
	}

	public static void cadastrarAtendente(Boolean root) {
		
		System.out.println("Nome de Usuario: ");
	    String nome = Scan.readLine();
	    System.out.println("Senha do Usuario: ");
	    String senha = Scan.readLine();
	    
	    Atendente atendente = new Atendente(nome, senha);
		atendentes.add(atendente);
		System.out.println("\nAtendente Cadastrado\n\n");
	
	}
	
}
