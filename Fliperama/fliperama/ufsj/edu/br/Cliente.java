package fliperama.ufsj.edu.br;

import fliperama.ufsj.edu.br.util.Scan;

public class Cliente extends Usuario{
	private int creditos;
	
	public Cliente(String n, String s) {
		super(n, s, false);
		this.setCreditos(0);
	}
	//set
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	//get
	public int getCreditos() {
		return this.creditos;
	}
	
	public void visualizarCliente(Jogo j) {
		
	}
	public void visualizarPontuacao(Jogo j) {
		
	}
}