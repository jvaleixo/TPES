package ES.ufsj.edu.br.persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ES.ufsj.edu.br.model.Cliente;

public class PCliente {
	private List<Cliente> clientes;
	
	public PCliente(){
		clientes =  new ArrayList<Cliente>();
	}
	
	public void carregarClientes() throws FileNotFoundException, IOException {
		File arquivo = new File("./clientes.txt");
		BufferedReader br = new BufferedReader (new FileReader(arquivo));
		String linha;
		linha = br.readLine();
		while (linha != null) {
			String[] dados = linha.split(" ");
			String cpf = dados[0];
			String creditos = dados[1];
			String senha = dados[2];
			int i = 0;
			String nome = dados[3];
			for( String dado : dados) {
				if (i > 3) {
					nome = nome.concat(" ");
					nome = nome.concat(dado);
				}
				i++;
			}
			Cliente c = new Cliente(nome, senha, Long.parseLong(cpf));
			c.setCreditos(Integer.parseInt(creditos));
			clientes.add(c);
			linha = br.readLine();
		}
		br.close();
	}
	
	public int carregar() {
		if (clientes.size() == 0) {
			try {
				carregarClientes();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return 1;
		}
		else
			return 0;
	}
	
	public void salvarClientes() throws FileNotFoundException, IOException {
		File arquivo = new File("./clientes.txt");
		FileWriter arquivoW = new FileWriter(arquivo.getAbsolutePath());
		for(Cliente cliente : clientes) {
			arquivoW.write(cliente.getCPF() + " " + cliente.getCreditos() + " " + cliente.getSenha() + " " + cliente.getNome() + "\n");
		}
		arquivoW.close();
	}
	
	public Cliente getCliente(long cpf) {
		for (Cliente cliente : clientes) {
			if(cpf == cliente.getCPF()) {
				return cliente;
			}
		}
		return null;
	}
	
	public void incluir(Cliente c) {
		c.setCreditos(0);
		clientes.add(c);
	}
	
	public int remover(long cpf) {
		Cliente c = getCliente(cpf);
		if(c != null) {
			clientes.remove(c);
			return 1;
		}
		return 0;
	}
	
	public void adicionarCreditos(Cliente c, int creditos) {
		creditos = c.getCreditos() + creditos;
		c.setCreditos(creditos);
	}
	
	public int checarCPFSenha(long cpf, String senha) {
		for(Cliente cliente : clientes) {
			if(cpf == cliente.getCPF() && senha.equals(cliente.getSenha()))
				return 1;
		}
		return 0;
	}
	
	public ArrayList<Long> getCPFs() {
		ArrayList<Long> cpfs = new ArrayList<Long>();
		for (Cliente cliente : clientes) {
			cpfs.add(cliente.getCPF());
		}
		return cpfs;
	}
	
	public void alterarNome(Cliente c, String nome) {
		clientes.remove(c);
		c.setNome(nome);
		clientes.add(c);
	}
	
	public void alterarSenha(Cliente c, String senha) {
		clientes.remove(c);
		c.setSenha(senha);
		clientes.add(c);
	}
	
	public void imprimirLista() {
		for (Cliente cliente : clientes)
			System.out.println("CPF: " + cliente.getCPF() + " Creditos: " + cliente.getCreditos() + " Senha: " + cliente.getSenha() + " Nome: " + cliente.getNome());
	}
}
