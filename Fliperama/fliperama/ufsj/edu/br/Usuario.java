package fliperama.ufsj.edu.br;

public abstract class Usuario {
	private String nome;
	private String senha;
	private Boolean root;
	
	public Usuario(String n, String s, Boolean root) {
		this.setNome(n);
		this.setSenha(s);
		setRoot(root);
	}
	// get
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setRoot(Boolean root) {
		this.root = root;
	}
	
	//set
	public String getNome() {
		return this.nome;
	}
	public String getSenha() {
		return this.senha;
	}
	public Boolean getRoot() {
		return this.root;
	}
	
	public Boolean cadastrarUsuario(String n, String s) {
		this.setNome(n);
		this.setSenha(s);
	    return true;
	}

	public Boolean fazerLogin(String n, String s) {
		if (this.getNome().equals(n) && this.getSenha().equals(s))
			return true;
		return false;
	}
}
