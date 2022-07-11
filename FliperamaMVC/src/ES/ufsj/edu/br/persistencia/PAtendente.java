package ES.ufsj.edu.br.persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ES.ufsj.edu.br.model.Atendente;
import ES.ufsj.edu.br.model.Cliente;

public class PAtendente {
	private List<Atendente> atendentes;
	
	public PAtendente() {
		atendentes =  new ArrayList<Atendente>();		
	}
	
	public void carregarAtendentes() throws IOException {
		File arquivo = new File("./atendentes.txt");
		BufferedReader br = new BufferedReader(new FileReader(arquivo));
		String linha;
		linha = br.readLine();
		while (linha != null) {
			String[] dados = linha.split(" ");
			String cpf = dados[0];
			String senha = dados[1];
			int i = 0;
			String nome = dados[2];
			for( String dado : dados) {
				if (i > 2) {
					nome = nome.concat(" ");
					nome = nome.concat(dado);
				}
				i++;
			}
			Atendente a = new Atendente(nome, senha, Long.parseLong(cpf));
			atendentes.add(a);
			linha = br.readLine();
		}
		br.close();
	}
	
	public void salvarAtendentes() throws IOException {
		File arquivo = new File("./atendentes.txt");
		FileWriter arquivoW = new FileWriter(arquivo.getAbsolutePath());
		for(Atendente atendente : atendentes) {
			arquivoW.write(atendente.getCPF() + " " + atendente.getSenha() + " " + atendente.getNome() + "\n");
		}
		arquivoW.close();
	}
	
	public Atendente getAtendente(long cpf) {
		for (Atendente atendente : atendentes) {
			if(cpf == atendente.getCPF()) {
				return atendente;
			}
		}
		return null;
	}
	
	public int buscarAtendente(Atendente a) {
		for (Atendente atendente : atendentes) {
			if(a.getCPF() == atendente.getCPF()) {
				return 0;
			}
		}
		return 1;
	}
	
	public int incluir(Atendente a) {
		int n = buscarAtendente(a);
		if (n == 1) {
			atendentes.add(a);
			return 1;
		}
		return 0;
	}
	
	public int remover(long cpf) {
		Atendente a = getAtendente(cpf);
		if(a != null) {
			atendentes.remove(a);
			return 1;
		}
		return 0;
	}
	
	public int checarCPFSenha(long cpf, String senha) {
		for(Atendente atendente : atendentes) {
			if(cpf == atendente.getCPF() && senha.equals(atendente.getSenha()))
				return 1;
		}
		return 0;
	}
	
	public void imprimirListaAtendente() {
		for (Atendente atendente : atendentes)
			System.out.println("CPF: " + atendente.getCPF() + " Senha: " + atendente.getSenha() + " Nome: " + atendente.getNome());
	}
}
