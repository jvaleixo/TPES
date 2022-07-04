package ES.ufsj.edu.br.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import ES.ufsj.edu.br.model.Cliente;
import ES.ufsj.edu.br.persistencia.PCliente;

public class CCliente {
	private PCliente pCliente = new PCliente();
	
	public int carregarClientes() {
		int n = pCliente.carregar();
		return n;
	}
	
	public PCliente getClientes() {
		return this.pCliente;
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
		//pCliente.imprimirLista();
		return n;
	}
	
	public int fazerLogin(long cpf, String senha) {
		int n = pCliente.checarCPFSenha(cpf, senha);
		return n;
	}
	
	public Cliente buscaClienteA(long cpf) {
		return pCliente.getCliente(cpf);
	}
}
