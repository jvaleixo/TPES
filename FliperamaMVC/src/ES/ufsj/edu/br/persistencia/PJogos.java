package ES.ufsj.edu.br.persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ES.ufsj.edu.br.model.Jogo;

public class PJogos {
	private List<Jogo> jogos;
	
	public PJogos() {
		 jogos =  new ArrayList<Jogo>();
	}
	
	public void carregarJogos() throws IOException {
		File arquivo = new File("./jogos.txt");
		BufferedReader br = new BufferedReader(new FileReader(arquivo));
		String linha;
		linha = br.readLine();
		while (linha != null) {
			String[] dados = linha.split(" ");
			String pontuacao = dados[0];
			String nome = dados[1];
			int i = 0;
			for( String dado : dados) {
				if (i > 1) {
					nome = nome.concat(" ");
					nome = nome.concat(dado);
				}
				i++;
			}
			Jogo a = new Jogo(nome, Integer.parseInt(pontuacao));
			jogos.add(a);
			linha = br.readLine();
		}
		br.close();
	}
	
	public void salvarJogos() throws IOException {
		File arquivo = new File("./jogos.txt");
		FileWriter arquivoW = new FileWriter(arquivo.getAbsolutePath());
		for(Jogo jogo : jogos) {
			//System.out.println(jogo.getNome() + " " + jogo.getPontuacao() +  "\n");
			arquivoW.write(jogo.getPontuacao() + " " + jogo.getNome() +  "\n");
		}
		arquivoW.close();
	}
	
	public Jogo getJogo(String nome) {
		for (Jogo jogo : jogos) {
			if(nome.equals(jogo.getNome())) {
				return jogo;
			}
		}
		return null;
	}
	
	public int buscarJogo(Jogo a) {
		for (Jogo jogo : jogos) {
			if(a.getNome().equals(jogo.getNome())) {
				return 0;
			}
		}
		return 1;
	}
	
	public int incluir(Jogo a) {
		int n = buscarJogo(a);
		if (n == 1) {
			jogos.add(a);
			return 1;
		}
		return 0;
	}
	
	public int remover(String nome) {
		Jogo a = getJogo(nome);
		if(a != null) {
			jogos.remove(a);
			return 1;
		}
		return 0;
	}
	
	public void imprimirListaJogos() {
		for (Jogo jogo : jogos)
			System.out.println("Nome: " + jogo.getNome() + " Pontuação: " + jogo.getPontuacao());
	}
}