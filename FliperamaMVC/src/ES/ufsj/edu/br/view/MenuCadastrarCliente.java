package ES.ufsj.edu.br.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MenuCadastrarCliente {
	private JPanel painel;
	private JFrame moldura;
	private JLabel labelUsuario;
	private JTextField textoUsuario;
	private JLabel labelSenha;
	private JPasswordField textoSenha;
	private JButton botaoConfirmar;
	private JButton botaoCancelar;
	
	public MenuCadastrarCliente() {
		painel = new JPanel();
		moldura = new JFrame();
		moldura.setTitle("Fliperama Menu Cadastrar Cliente");	//mudar depois
		moldura.setSize(350, 200);
		moldura.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		moldura.add(painel);
		
		painel.setLayout(null);
		
		labelUsuario = new JLabel("Usuario");
		labelUsuario.setBounds(10, 20, 80, 25);	//x, y, width, height
		painel.add(labelUsuario);
		
		textoUsuario = new JTextField();
		textoUsuario.setBounds(100, 20, 165, 25);
		painel.add(textoUsuario);
		
		labelSenha = new JLabel("Senha");
		labelSenha.setBounds(10, 50, 80, 25);
		painel.add(labelSenha);
		
		textoSenha = new JPasswordField();
		textoSenha.setBounds(100, 50, 165, 25);
		painel.add(textoSenha);
		
		botaoConfirmar = new JButton("Confirmar");
		botaoConfirmar.setBounds(10, 80, 100, 25);
		painel.add(botaoConfirmar);
		
		botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setBounds(165, 80, 100, 25);
		painel.add(botaoCancelar);
		
	}

	//gets
	public JFrame getMoldura() {
		return this.moldura;
	}
	public JButton getBotaoConfirmar() {
		return this.botaoConfirmar;
	}
	public JButton getBotaoCancelar() {
		return this.botaoCancelar;
	}
	public String getUsuario() {
		return this.textoUsuario.getText();
	}
	public String getSenha() {
		return new String(textoSenha.getPassword());
	}
}
