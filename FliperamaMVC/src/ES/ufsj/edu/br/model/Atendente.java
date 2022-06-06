package ES.ufsj.edu.br.model;

import ES.ufsj.edu.br.util.Scan;

public class Atendente extends Usuario{

	public Atendente(String n, String s, int cpf) {
		super(n, s, cpf, true);
	}
	
	public void cadastrarCliente(Cliente c, int cred) {
		c.setCreditos(cred);
	}
	public void cadastrarAtendente(String n, String s) {
		
	}
	public void cadastrarJogo(String n) {
		
	}
	public void definir_pontuação(Cliente C, Jogo j, int p) {
		
	}
	public void visualizarCliente(Cliente C) {
		
	}
	public void buscarCliente(Cliente c) {
		
	}
	public void vusualizarPontuacao(Cliente c, Jogo j) {
		
	}
	public void gereciarCreditos(Cliente c, int cred) {
		
	}
}
