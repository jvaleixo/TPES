package ES.ufsj.edu.br.persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import ES.ufsj.edu.br.model.Cliente;

public class PCliente {
	private List<Cliente> clientes;
	
	public PCliente(){
		clientes =  new ArrayList<Cliente>();
	}
	
	public void carregarClientes() throws FileNotFoundException, IOException {
		JFileChooser selecionaArquivo = new JFileChooser();
		selecionaArquivo.setDialogTitle("Selecione o arquivo para carregar os dados");
		selecionaArquivo.setCurrentDirectory(new File("."));
		int n = selecionaArquivo.showOpenDialog(null);
		if (n == JFileChooser.APPROVE_OPTION) {
			File arquivo = new File(selecionaArquivo.getSelectedFile().getAbsolutePath());
			BufferedReader br = new BufferedReader (new FileReader(arquivo));
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
				Cliente c = new Cliente(nome, senha, Integer.parseInt(cpf));
				clientes.add(c);
				linha = br.readLine();
			}
			br.close();
		}
	}
	
	public void salvarClientes() throws FileNotFoundException, IOException {
		JFileChooser selecionaArquivo = new JFileChooser();
		selecionaArquivo.setDialogTitle("Selecione o arquivo para salvar os dados");
		selecionaArquivo.setCurrentDirectory(new File("."));
		int n = selecionaArquivo.showSaveDialog(null);
		if (n == JFileChooser.APPROVE_OPTION) {
			FileWriter arquivoW = new FileWriter(selecionaArquivo.getSelectedFile().getAbsolutePath());
			for(Cliente cliente : clientes) {
				arquivoW.write(cliente.getCPF() + " " + cliente.getSenha() + " " + cliente.getNome() + "\n");
			}
			arquivoW.close();
		}
		else {
			System.exit(0);
		}
	}
	
	public int buscarCliente(Cliente c) {
		for (Cliente cliente : clientes) {
			if(c.getCPF() == cliente.getCPF()) {
				return 0;
			}
		}
		return 1;
	}
	
	public int incluir(Cliente c) {
		int n = buscarCliente(c);
		if (n == 1) {
			clientes.add(c);
			return 1;
		}
		return 0;
	}
	
	public int checarCPFSenha(int cpf, String senha) {
		for(Cliente cliente : clientes) {
			if(cpf == cliente.getCPF() && senha.equals(cliente.getSenha()))
				return 1;
		}
		return 0;
	}
	
	public void imprimirLista() {
		for (Cliente cliente : clientes)
			System.out.println("CPF: " + cliente.getCPF() + " Senha: " + cliente.getSenha() + " Nome: " + cliente.getNome());
	}
}
