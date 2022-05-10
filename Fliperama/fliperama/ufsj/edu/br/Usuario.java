package fliperama.ufsj.edu.br;

public abstract class Usuario {
	private String nome;
	private String senha;
	
	// get
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	//set
	public String getNome() {
		return this.nome;
	}
	public String getSenha() {
		return this.nome;
	}
	
	public abstract void cadastrarCliente(String n, String senha) ;

	public abstract void fazerLogin(String n, String s) ;
}
