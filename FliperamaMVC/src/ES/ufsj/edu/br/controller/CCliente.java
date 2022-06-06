package ES.ufsj.edu.br.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import ES.ufsj.edu.br.model.Cliente;
import ES.ufsj.edu.br.persistencia.PCliente;

public class CCliente {
	private PCliente pCliente = new PCliente();
	
	public void carregarClientes() {
		try {
			pCliente.carregarClientes();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void salvarClientes() {
		try {
			pCliente.salvarClientes();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int cadastrarCliente(Cliente c) {
		int n = pCliente.incluir(c);
		return n;
		//pCliente.imprimirLista();
	}
	
	public int fazerLogin(String nome, String senha) {
		int n = pCliente.checarUsuarioSenha(nome, senha);
		return n;
	}
}
