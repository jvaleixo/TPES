package ES.ufsj.edu.br.controller;
import ES.ufsj.edu.br.model.*;
import ES.ufsj.edu.br.persistencia.PCliente;
import java.io.IOException;

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
	
	public int fazerLogin(long cpf, String senha) {
		int n = pAtendente.checarCPFSenha(cpf, senha);
		return n;
	}

}