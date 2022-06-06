package ES.ufsj.edu.br.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ES.ufsj.edu.br.controller.CCliente;
import ES.ufsj.edu.br.model.*;

public class Janela implements ActionListener{
	private CCliente cCliente = new CCliente();
	
	private JFrame moldura;
	
	private JMenuBar menu_b;	//barra de menu
	private JMenu menu_arquivo;
	private JMenuItem carregar_lista;
	
	private JPanel painelMP;	//painel menu principal
	private JButton botaoCC;
	private JButton botaoEL;
	private JButton botaoSair;
	
	private JPanel painelCC;	//painel cadastrar cliente
	private JLabel labelUsuario;
	private JTextField textoUsuario;
	private JLabel labelSenha;
	private JPasswordField textoSenha;
	private JButton botaoConfirmar;
	private JButton botaoCancelar;
	
	private JPanel painelFL;	//painel fazer login
	private JLabel labelUsuarioFL;
	private JTextField textoUsuarioFL;
	private JLabel labelSenhaFL;
	private JPasswordField textoSenhaFL;
	private JButton botaoLogin;
	private JButton botaoVoltar;
	
	private JPanel painelMC;	//painel menu cliente
	private JButton botaoLogoutMC;
	
	private JPanel painelMA;	//painel menu atendente
	private JButton botaoLogoutMA;
	
	public Janela () {
		moldura = new JFrame();
		moldura.setTitle("Fliperama Menu");	//mudar depois
		moldura.setSize(350, 200);
		moldura.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		moldura.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	cCliente.salvarClientes();
				moldura.setVisible(false);
		    	System.exit(0);
		        }
		});
		
		//menu em cima para carregar lista de clientes
		menu_b = new JMenuBar();
		menu_arquivo = new JMenu("Arquivo");
		carregar_lista = new JMenuItem("Carregar lista de clientes");
		carregar_lista.addActionListener(this);
		menu_arquivo.add(carregar_lista);
		menu_b.add(menu_arquivo);
		moldura.setJMenuBar(menu_b);
		
		//painel menu principal
		painelMP = new JPanel();
		painelMP.setLayout(null);
		//moldura.add(painelMP);
		
		botaoCC = new JButton("Cadastrar Cliente");
		botaoCC.setBounds(90, 10, 140, 25);
		botaoCC.addActionListener(this);
		painelMP.add(botaoCC);
		
		botaoEL = new JButton("Efetuar Login");
		botaoEL.setBounds(90, 50, 140, 25);
		botaoEL.addActionListener(this);
		painelMP.add(botaoEL);
		
		botaoSair = new JButton("Sair");
		botaoSair.setBounds(90, 90, 140, 25);
		botaoSair.addActionListener(this);
		painelMP.add(botaoSair);
		
		//painel cadastrar cliente
		painelCC = new JPanel();
		painelCC.setLayout(null);
		
		labelUsuario = new JLabel("Usuario");
		labelUsuario.setBounds(10, 20, 80, 25);	//x, y, width, height
		painelCC.add(labelUsuario);
		
		textoUsuario = new JTextField();
		textoUsuario.setBounds(100, 20, 165, 25);
		painelCC.add(textoUsuario);
		
		labelSenha = new JLabel("Senha");
		labelSenha.setBounds(10, 50, 80, 25);
		painelCC.add(labelSenha);
		
		textoSenha = new JPasswordField();
		textoSenha.setBounds(100, 50, 165, 25);
		painelCC.add(textoSenha);
		
		botaoConfirmar = new JButton("Confirmar");
		botaoConfirmar.setBounds(10, 80, 100, 25);
		botaoConfirmar.addActionListener(this);
		painelCC.add(botaoConfirmar);
		
		botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setBounds(165, 80, 100, 25);
		botaoCancelar.addActionListener(this);
		painelCC.add(botaoCancelar);
		
		//painel fazer login
		painelFL = new JPanel();
		painelFL.setLayout(null);
		
		labelUsuarioFL = new JLabel("Usuario");
		labelUsuarioFL.setBounds(10, 20, 80, 25);	//x, y, width, height
		painelFL.add(labelUsuarioFL);
		
		textoUsuarioFL = new JTextField();
		textoUsuarioFL.setBounds(100, 20, 165, 25);
		painelFL.add(textoUsuarioFL);
		
		labelSenhaFL = new JLabel("Senha");
		labelSenhaFL.setBounds(10, 50, 80, 25);
		painelFL.add(labelSenhaFL);
		
		textoSenhaFL = new JPasswordField();
		textoSenhaFL.setBounds(100, 50, 165, 25);
		painelFL.add(textoSenhaFL);
		
		botaoLogin = new JButton("Login");
		botaoLogin.setBounds(10, 80, 80, 25);
		botaoLogin.addActionListener(this);
		painelFL.add(botaoLogin);
		
		botaoVoltar = new JButton("Voltar");
		botaoVoltar.setBounds(185, 80, 80, 25);
		botaoVoltar.addActionListener(this);
		painelFL.add(botaoVoltar);
		
		//painel menu cliente (sem funcionalidades ainda)
		painelMC = new JPanel();
		painelMC.setLayout(null);
		
		botaoLogoutMC = new JButton("Logout");
		botaoLogoutMC.setBounds(185, 80, 80, 25);
		botaoLogoutMC.addActionListener(this);
		painelMC.add(botaoLogoutMC);
		
		//painel menu cliente (sem funcionalidades ainda)
		painelMA = new JPanel();
		painelMA.setLayout(null);
		
		botaoLogoutMA = new JButton("Logout");
		botaoLogoutMA.setBounds(185, 80, 80, 25);
		botaoLogoutMA.addActionListener(this);
		painelMA.add(botaoLogoutMA);
		
		moldura.add(painelMP);
		moldura.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == carregar_lista) {
			cCliente.carregarClientes();
		}
		else if (e.getSource() == botaoCC) {
	    	moldura.remove(painelMP);
	    	moldura.add(painelCC);
	    	moldura.validate();
	    	moldura.setVisible(false);
			moldura.setVisible(true);
		}
		else if (e.getSource() == botaoEL) {
			moldura.remove(painelMP);
			moldura.add(painelFL);
			moldura.validate();
			moldura.setVisible(false);
			moldura.setVisible(true);
		}
		else if (e.getSource() == botaoSair) {
			cCliente.salvarClientes();
			moldura.setVisible(false);
	    	System.exit(0);
		}
		else if (e.getSource() == botaoConfirmar) {	
			String nome = textoUsuario.getText();
		    String senha = new String(textoSenha.getPassword()); 
			Cliente c = new Cliente(nome, senha);
			int n = cCliente.cadastrarCliente(c);
			if (n == 0) {
				JOptionPane.showMessageDialog(null, "Nome de usuário indisponível", "Erro", JOptionPane.ERROR_MESSAGE);
				textoUsuario.setText("");
				textoSenha.setText("");
			}
			else {
				textoUsuario.setText("");
				textoSenha.setText("");
				moldura.remove(painelCC);
				moldura.add(painelMP);
				moldura.validate();
				moldura.setVisible(false);
				moldura.setVisible(true);
			}
		}
		else if (e.getSource() == botaoCancelar) {
			if (JOptionPane.showConfirmDialog(null, "Deseja cancelar?", "Confirmacao cancelamento", JOptionPane.YES_NO_OPTION) == 0) {
				textoUsuario.setText("");
				textoSenha.setText("");
				moldura.remove(painelCC);
				moldura.add(painelMP);
				moldura.validate();
				moldura.setVisible(false);
				moldura.setVisible(true);
			}
		}
		else if (e.getSource() == botaoLogin) {
			String nome = textoUsuarioFL.getText();
		    String senha = new String(textoSenhaFL.getPassword()); 
			int n = cCliente.fazerLogin(nome, senha);
			if (n == 0) {
				JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos", "Erro", JOptionPane.ERROR_MESSAGE);
				textoUsuarioFL.setText("");
				textoSenhaFL.setText("");
			}
			else {
				textoUsuarioFL.setText("");
				textoSenhaFL.setText("");
				moldura.remove(painelFL);
				moldura.add(painelMC);
				moldura.validate();
				moldura.setVisible(false);
				moldura.setVisible(true);
			}
		}
		else if (e.getSource() == botaoVoltar) {	//deve ter confirmacao de cancelamento?
			textoUsuarioFL.setText("");
			textoSenhaFL.setText("");
			moldura.remove(painelFL);
			moldura.add(painelMP);
			moldura.validate();
			moldura.setVisible(false);
			moldura.setVisible(true);
		}
		else if (e.getSource() == botaoLogoutMC) {
			moldura.remove(painelMC);
			moldura.add(painelFL);
			moldura.validate();
			moldura.setVisible(false);
			moldura.setVisible(true);
		}
		else if (e.getSource() == botaoLogoutMA) {
			moldura.remove(painelMA);
			moldura.add(painelFL);
			moldura.validate();
			moldura.setVisible(false);
			moldura.setVisible(true);
		}
	}
}
