package ES.ufsj.edu.br.model;

public abstract class Usuario {
	private String nome;
	private String senha;
	private int CPF;
	private Boolean root;
	
	public Usuario(String n, String s, int cpf, Boolean root) {
		this.setNome(n);
		this.setCPF(cpf);
		this.setSenha(s);
		setRoot(root);
	}
	// set
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setCPF (int cpf) {
		this.CPF = cpf;
	}
	public void setRoot(Boolean root) {
		this.root = root;
	}
	
	//get
	public String getNome() {
		return this.nome;
	}
	public String getSenha() {
		return this.senha;
	}
	public int getCPF() {
		return this.CPF;
	}
	public Boolean getRoot() {
		return this.root;
	}
	
	public Boolean cadastrarUsuario(String n, String s, int cpf) {
		this.setNome(n);
		this.setSenha(s);
		this.setCPF(cpf);
	    return true;
	}
}
