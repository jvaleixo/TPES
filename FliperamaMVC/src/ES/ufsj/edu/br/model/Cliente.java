package ES.ufsj.edu.br.model;

public class Cliente extends Usuario{
	private int creditos;
	
	public Cliente(String n, String s, long cpf) {
		super(n, s, cpf,  false);
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