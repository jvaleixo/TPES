package ES.ufsj.edu.br.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MenuLogin implements ActionListener{
	private JPanel painel;
	private JFrame moldura;
	private JLabel labelUsuario;
	private JTextField textoUsuario;
	private JLabel labelSenha;
	private JPasswordField textoSenha;
	private JButton botaoLogin;
	private JButton botaoVoltar;
	private JLabel sucesso;
	
	//TAVA TESTANDO ESSA CLASSE AINDA NAO FIZ CERTINHA PRA COLOCAR NO MAIN
	public MenuLogin () {
		
		painel = new JPanel();
		moldura = new JFrame();
		moldura.setTitle("Fliperama Login");	//mudar depois
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
		
		botaoLogin = new JButton("Login");
		botaoLogin.setBounds(10, 80, 80, 25);
		botaoLogin.addActionListener(this);
		painel.add(botaoLogin);
		
		botaoVoltar = new JButton("Voltar");
		botaoVoltar.setBounds(185, 80, 80, 25);
		botaoVoltar.addActionListener(this);
		painel.add(botaoVoltar);
		
		sucesso = new JLabel("");
		sucesso.setBounds(10, 110, 330, 25);
		painel.add(sucesso);
		
		moldura.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoLogin) {
			String usuario = textoUsuario.getText();
			String senha = new String(textoSenha.getPassword());
			
			if (usuario.equals("asd") && senha.equals("dsa")) {
				sucesso.setText("Login efetuado");
			}
		}
		else {
			return;
		}
	}
}
