package ES.ufsj.edu.br.model;

public class Jogo {
	private String nome;
	private int pontuacao;
	
	public Jogo(String nome, int pontuacao) {
		this.nome = nome;
		this.pontuacao = pontuacao;
	}
	
	//set
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	//get
	public String getNome() {
		return this.nome;
	}
	public int getPontuacao() {
		return this.pontuacao;
	}
}
