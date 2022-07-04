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

import ES.ufsj.edu.br.controller.CAtendente;
import ES.ufsj.edu.br.controller.CCliente;
import ES.ufsj.edu.br.model.*;

public class Janela implements ActionListener{
	private CCliente cCliente = new CCliente();
	private CAtendente cAtendente = new CAtendente();
	
	private JFrame moldura;
	
	private JMenuBar menu_b;	//barra de menu
	private JMenu menu_arquivo;
	private JMenuItem carregar_lista;
	
	private JPanel painelMP;	//painel menu principal
	private JButton botaoCC;
	private JButton botaoEL;
	private JButton botaoSair;
	
	private JPanel painelCC;	//painel cadastrar cliente
	private JLabel labelNome;
	private JTextField textoNome;
	private JLabel labelCPF;
	private JTextField textoCPF;
	private JLabel labelSenha;
	private JPasswordField textoSenha;
	private JButton botaoConfirmar;
	private JButton botaoCancelar;
	
	private JPanel painelFL;	//painel fazer login
	private JLabel labelCPFFL;
	private JTextField textoCPFFL;
	private JLabel labelSenhaFL;
	private JPasswordField textoSenhaFL;
	private JButton botaoLogin;
	private JButton botaoVoltar;
	
	private JPanel painelMC;	//painel menu cliente
	private JButton botaoLogoutMC;
	
	private JPanel painelMA;	//painel menu atendente
	private JButton botaoBuscarCliente;
	private JButton botaoCadastrarAtendente;
	private JButton botaoCadastrarJogo;
	private JButton botaoLogoutMA;
	
	private JPanel BuscaClienteA; //painel da busca do cliente no menu do atendente
	private JTextField textoBuscaClienteA;
	private JLabel labelCpfClienteA;
	private JButton botaoConfirmaClienteA;
	private JButton botaoVoltarClienteA;
	
	public Janela () {
		cAtendente.carregarAtendentes();
		
		moldura = new JFrame();
		moldura.setTitle("Fliperama Menu");	//mudar depois
		moldura.setSize(350, 200);
		moldura.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		moldura.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	cAtendente.salvarAtendentes();
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
		
		labelNome = new JLabel("Nome");
		labelNome.setBounds(10, 10, 80, 25);	//x, y, width, height
		painelCC.add(labelNome);
		
		textoNome = new JTextField();
		textoNome.setBounds(100, 10, 165, 25);
		painelCC.add(textoNome);
		
		labelCPF = new JLabel("CPF");
		labelCPF.setBounds(10, 40, 80, 25);	//x, y, width, height
		painelCC.add(labelCPF);
		
		textoCPF = new JTextField();
		textoCPF.setBounds(100, 40, 165, 25);
		painelCC.add(textoCPF);
		
		labelSenha = new JLabel("Senha");
		labelSenha.setBounds(10, 70, 80, 25);
		painelCC.add(labelSenha);
		
		textoSenha = new JPasswordField();
		textoSenha.setBounds(100, 70, 165, 25);
		painelCC.add(textoSenha);
		
		botaoConfirmar = new JButton("Confirmar");
		botaoConfirmar.setBounds(10, 100, 100, 25);
		botaoConfirmar.addActionListener(this);
		painelCC.add(botaoConfirmar);
		
		botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setBounds(165, 100, 100, 25);
		botaoCancelar.addActionListener(this);
		painelCC.add(botaoCancelar);
		
		//painel fazer login
		painelFL = new JPanel();
		painelFL.setLayout(null);
		
		labelCPFFL = new JLabel("CPF");
		labelCPFFL.setBounds(10, 20, 80, 25);	//x, y, width, height
		painelFL.add(labelCPFFL);
		
		textoCPFFL = new JTextField();
		textoCPFFL.setBounds(100, 20, 165, 25);
		painelFL.add(textoCPFFL);
		
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
		
		//painel menu atendente (sem funcionalidades ainda)
		painelMA = new JPanel();
		painelMA.setLayout(null);
		
		botaoBuscarCliente = new JButton("Buscar Cliente");
		botaoBuscarCliente.setBounds(90, 10, 155, 25);	//x y width height
		botaoBuscarCliente.addActionListener(this);
		painelMA.add(botaoBuscarCliente);
		
		botaoCadastrarAtendente = new JButton("Cadastrar Atendente");
		botaoCadastrarAtendente.setBounds(90, 40, 155, 25);
		botaoCadastrarAtendente.addActionListener(this);
		painelMA.add(botaoCadastrarAtendente);
		
		botaoCadastrarJogo = new JButton("Cadastrar Jogo");
		botaoCadastrarJogo.setBounds(90, 70, 155, 25);
		botaoCadastrarJogo.addActionListener(this);
		painelMA.add(botaoCadastrarJogo);
		
		botaoLogoutMA = new JButton("Logout");
		botaoLogoutMA.setBounds(185, 100, 80, 25);
		botaoLogoutMA.addActionListener(this);
		painelMA.add(botaoLogoutMA);
		
		BuscaClienteA = new JPanel();
		BuscaClienteA.setLayout(null);
		textoBuscaClienteA = new JTextField();
		textoBuscaClienteA.setBounds(100, 20, 165, 25);
		labelCpfClienteA = new JLabel("CPF");
		labelCpfClienteA.setBounds(60, 20, 165, 25);
		botaoConfirmaClienteA = new JButton("Comfirmar");
		botaoConfirmaClienteA.setBounds(40, 100, 80, 25);
		botaoConfirmaClienteA.addActionListener(this);
		botaoVoltarClienteA = new JButton("Voltar");
		botaoVoltarClienteA.setBounds(140, 100, 80, 25);
		botaoConfirmaClienteA.addActionListener(this);
		BuscaClienteA.add(textoBuscaClienteA);
		BuscaClienteA.add(labelCpfClienteA);
		BuscaClienteA.add(botaoConfirmaClienteA);
		BuscaClienteA.add(botaoVoltarClienteA);
		
		moldura.add(painelMP);
		moldura.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == carregar_lista) {
			int n = cCliente.carregarClientes();
			if (n == 0) {
				JOptionPane.showMessageDialog(null, "Só é possível carregar uma lista de clientes caso a atual esteja vazia", "Erro", JOptionPane.ERROR_MESSAGE);
			}
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
			cAtendente.salvarAtendentes();
			cCliente.salvarClientes();
			moldura.setVisible(false);
	    	System.exit(0);
		}
		else if (e.getSource() == botaoConfirmar) {	
			try {
				String nome = textoNome.getText();
				long cpf = Long.parseLong(textoCPF.getText());
				String senha = new String(textoSenha.getPassword()); 
				Cliente c = new Cliente(nome, senha, cpf);
				int n = cCliente.cadastrarCliente(c);
				if (n == 0) {
					JOptionPane.showMessageDialog(null, "CPF já cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
					textoNome.setText("");
					textoCPF.setText("");
					textoSenha.setText("");
				}
				else {
					textoNome.setText("");
					textoCPF.setText("");
					textoSenha.setText("");
					moldura.remove(painelCC);
					moldura.add(painelMP);
					moldura.validate();
					moldura.setVisible(false);
					moldura.setVisible(true);
				}
			} catch (NumberFormatException t) {
				JOptionPane.showMessageDialog(null, "CPF deve conter apenas números", "Erro", JOptionPane.ERROR_MESSAGE);
				textoNome.setText("");
				textoCPF.setText("");
				textoSenha.setText("");
			}
		}
		else if (e.getSource() == botaoCancelar) {
			if (JOptionPane.showConfirmDialog(null, "Deseja cancelar?", "Confirmacao cancelamento", JOptionPane.YES_NO_OPTION) == 0) {
				textoNome.setText("");
				textoSenha.setText("");
				moldura.remove(painelCC);
				moldura.add(painelMP);
				moldura.validate();
				moldura.setVisible(false);
				moldura.setVisible(true);
			}
		}
		else if (e.getSource() == botaoLogin) {
			try {
				long cpf = Long.parseLong(textoCPFFL.getText());
			    String senha = new String(textoSenhaFL.getPassword()); 
				int n = cCliente.fazerLogin(cpf, senha);
				int m = cAtendente.fazerLogin(cpf, senha);
				if (n == m) {
					//TODO: nao permitir CPFs iguais para usuarios/atendentes
					JOptionPane.showMessageDialog(null, "CPF ou senha inválido", "Erro", JOptionPane.ERROR_MESSAGE);
					textoCPFFL.setText("");
					textoSenhaFL.setText("");
				}
				else if (n==1) {
					textoCPFFL.setText("");
					textoSenhaFL.setText("");
					moldura.remove(painelFL);
					moldura.add(painelMC);
					moldura.validate();
					moldura.setVisible(false);
					moldura.setVisible(true);
				}
				else if (m==1) {
					textoCPFFL.setText("");
					textoSenhaFL.setText("");
					moldura.remove(painelFL);
					moldura.add(painelMA);
					moldura.validate();
					moldura.setVisible(false);
					moldura.setVisible(true);
				}
			} catch (NumberFormatException t) {
				JOptionPane.showMessageDialog(null, "CPF deve conter apenas números", "Erro", JOptionPane.ERROR_MESSAGE);
				textoCPFFL.setText("");
				textoSenhaFL.setText("");
			}
		}
		else if (e.getSource() == botaoVoltar) {	//deve ter confirmacao de cancelamento?
			textoCPFFL.setText("");
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
		}else if(e.getSource() == botaoBuscarCliente) {
			moldura.remove(painelMA);
			moldura.add(BuscaClienteA);
			moldura.validate();
			moldura.setVisible(false);
			moldura.setVisible(true);
		}else if(e.getSource() == botaoConfirmaClienteA) {
			try {
				long cpf = Long.parseLong(textoCPFFL.getText());
			    Cliente c = cCliente.buscaClienteA(cpf);
				if (c == null) {
					//TODO: nao permitir CPFs iguais para usuarios/atendentes
					JOptionPane.showMessageDialog(null, "Cliente Não Cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
					textoBuscaClienteA.setText("");
				}
				else {
					textoBuscaClienteA.setText("");
					moldura.remove(BuscaClienteA);
					//moldura.add(painelMC);
					moldura.validate();
					moldura.setVisible(false);
					moldura.setVisible(true);
				}
			} catch (NumberFormatException t) {
				JOptionPane.showMessageDialog(null, "CPF deve conter apenas números", "Erro", JOptionPane.ERROR_MESSAGE);
				textoBuscaClienteA.setText("");
			}
		}
	}
}
