package ES.ufsj.edu.br.controller;

import java.io.IOException;

import ES.ufsj.edu.br.model.Jogo;
import ES.ufsj.edu.br.persistencia.PJogos;

public class CJogos {
	
	private PJogos pJogo = new PJogos();
	
	public void carregarJogos() {
		try {
			pJogo.carregarJogos();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void salvarJogos() {
		try {
			pJogo.salvarJogos();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int cadastrarJogos(Jogo a) {
		int n = pJogo.incluir(a);
		//pJogo.imprimirListaJogos();
		return n;
	}
	
	public int apagarJogo(String nome) {
		int n = pJogo.remover(nome);
		//pJogo.imprimirListaJogos();
		return n;
	}
}
