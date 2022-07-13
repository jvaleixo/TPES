package ES.ufsj.edu.br.controller;

import java.io.IOException;
import java.util.ArrayList;

import ES.ufsj.edu.br.model.Atendente;
import ES.ufsj.edu.br.persistencia.PAtendente;

public class CAtendente {
	private PAtendente pAtendente = new PAtendente();
	
	public void carregarAtendentes() {
		try {
			pAtendente.carregarAtendentes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void salvarAtendentes() {
		try {
			pAtendente.salvarAtendentes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int cadastrarAtendente(Atendente a, ArrayList<Long> cpfsC) {
		ArrayList<Long> cpfsA = pAtendente.getCPFs();
		int n = checarCPFs(a.getCPF(), cpfsA, cpfsC);
		if (n == 1)
			pAtendente.incluir(a);
		//pAtendente.imprimirLista();
		return n;
	}
	
	public int apagarAtendente(long cpf) {
		int n = pAtendente.remover(cpf);
		//pAtendente.imprimirListaAtendente();
		return n;
	}
	
	public int fazerLogin(long cpf, String senha) {
		int n = pAtendente.checarCPFSenha(cpf, senha);
		return n;
	}
	
	public int checarCPFs(long cpf, ArrayList<Long> cpfs1, ArrayList<Long> cpfs2) {
		for(long cfps : cpfs1) {
			if (cpf == cfps)
				return 0;
		}
		for(long cfps : cpfs2) {
			if (cpf == cfps)
				return 0;
		}
		return 1;
	}
	
	public ArrayList<Long> listaCPFs() {
		ArrayList<Long> cpfs = pAtendente.getCPFs();
		return cpfs;
	}
}