package ES.ufsj.edu.br.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import ES.ufsj.edu.br.model.Cliente;
import ES.ufsj.edu.br.persistencia.PCliente;

public class CCliente {
	private PCliente pCliente = new PCliente();
	private Cliente atual = null;
	
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
	
	public int cadastrarCliente(Cliente c, ArrayList<Long> cpfsA) {
		ArrayList<Long> cpfsC = pCliente.getCPFs();
		int n = checarCPFs(c.getCPF(), cpfsA, cpfsC);
			if (n == 1)
				pCliente.incluir(c);
		//pCliente.imprimirLista();
		return n;
	}
	
	public int apagarCliente(long cpf) {
		int n = pCliente.remover(cpf);
		//pCliente.imprimirLista();
		return n;
	}
	
	public void adicionarCreditos(int creditos) {
		pCliente.adicionarCreditos(atual, creditos);
	}
	
	public void desmarcarCliente() {
		atual = null;
	}
	
	public int fazerLogin(long cpf, String senha) {
		int n = pCliente.checarCPFSenha(cpf, senha);
		return n;
	}
	
	public String[] dadosCliente() {
		String[] dados = {atual.getNome(), Long.toString(atual.getCPF()), Integer.toString(atual.getCreditos())};
		return dados;
	}
	
	public Cliente buscaClienteA(long cpf) {
		Cliente cliente = pCliente.getCliente(cpf);
		if (cliente == null)
			atual = null;
		else
			atual = cliente;
		return pCliente.getCliente(cpf);
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
		ArrayList<Long> cpfs = pCliente.getCPFs();
		return cpfs;
	}
	
	public void alterarNome(String nome) {
		pCliente.alterarNome(atual, nome);
	}
	
	public void alterarSenha(String senha) {
		pCliente.alterarSenha(atual, senha);
	}
}
