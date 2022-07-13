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
import ES.ufsj.edu.br.controller.CJogos;
import ES.ufsj.edu.br.model.*;

public class Janela implements ActionListener{
	private CCliente cCliente = new CCliente();
	private CAtendente cAtendente = new CAtendente();
	private CJogos cJogos = new CJogos();
	
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
	private JButton botaoApagarCliente;
	private JButton botaoCadastrarAtendente;
	private JButton botaoApagarAtendente;
	private JButton botaoCadastrarJogo;
	private JButton botaoApagarJogo;
	private JButton botaoLogoutMA;
	
	private JPanel painelCadastroJogo;	//painel Cadastro Jogo
	private JTextField textoNomeJogo;
	private JLabel labelNomeJogo;
	private JButton botaoConfirmaCadastroJogo;
	private JButton botaoVoltarCadastroJogo;
	
	private JPanel painelApagaJogo;	//painel Cadastro Jogo
	private JTextField textoApagaJogo;
	private JLabel labelApagaJogo;
	private JButton botaoConfirmaApagaJogo;
	private JButton botaoVoltarApagaJogo;
	
	private JPanel BuscaClienteA; //painel da busca do cliente no menu do atendente
	private JTextField textoBuscaClienteA;
	private JLabel labelCpfClienteA;
	private JButton botaoConfirmaClienteA;
	private JButton botaoVoltarClienteA;
	
	private JPanel painelVCA;	//painel visualizar cliente (atendente)
	private JLabel nomeVCA;
	private JLabel creditosVCA;
	private JLabel CPFVCA;
	private JButton botaoAdicionarCreditos;
	private JButton botaoVoltarVCA;
	
	private JPanel painelApagar;	//painel apagar cliente/atendente
	private JLabel cpfA;
	private JTextField textoA;
	private JButton botaoConfirmarA;
	private JButton botaoVoltarA;
	
	private JPanel painelAC;	//painel adicionar creditos
	private JLabel creditosAC;
	private JTextField textoAC;
	private JButton botaoAdicionarAC;
	private JButton botaoVoltarAC;
	
	public Janela () {
		cAtendente.carregarAtendentes();
		cJogos.carregarJogos();
		
		moldura = new JFrame();
		moldura.setTitle("Fliperama Menu");	//mudar depois
		moldura.setSize(350, 200);
		moldura.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		moldura.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	cAtendente.salvarAtendentes();
		    	cCliente.salvarClientes();
		    	cJogos.salvarJogos();
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
		
		//painel menu atendente
		painelMA = new JPanel();
		painelMA.setLayout(null);
		
		botaoBuscarCliente = new JButton("Buscar Cliente");
		botaoBuscarCliente.setBounds(10, 10, 155, 25);	//x y width height
		botaoBuscarCliente.addActionListener(this);
		painelMA.add(botaoBuscarCliente);
		
		botaoApagarCliente = new JButton("Apagar Cliente");
		botaoApagarCliente.setBounds(170, 10, 155, 25);
		botaoApagarCliente.addActionListener(this);
		painelMA.add(botaoApagarCliente);
		
		botaoCadastrarAtendente = new JButton("Cadastrar Atendente");
		botaoCadastrarAtendente.setBounds(10, 40, 155, 25);
		botaoCadastrarAtendente.addActionListener(this);
		painelMA.add(botaoCadastrarAtendente);
		
		botaoApagarAtendente = new JButton("Apagar Atendente");
		botaoApagarAtendente.setBounds(170, 40, 155, 25);
		botaoApagarAtendente.addActionListener(this);
		painelMA.add(botaoApagarAtendente);
		
		botaoCadastrarJogo = new JButton("Cadastrar Jogo");	//TODO: CADASTRAR JOGO
		botaoCadastrarJogo.setBounds(10, 70, 155, 25);
		botaoCadastrarJogo.addActionListener(this);
		painelMA.add(botaoCadastrarJogo);
		
		botaoApagarJogo = new JButton("Apagar Jogo");	//TODO: Apagar JOGO
		botaoApagarJogo.setBounds(170, 70, 155, 25);
		botaoApagarJogo.addActionListener(this);
		painelMA.add(botaoApagarJogo);
		
		botaoLogoutMA = new JButton("Logout");
		botaoLogoutMA.setBounds(185, 100, 80, 25);
		botaoLogoutMA.addActionListener(this);
		painelMA.add(botaoLogoutMA);
		
		painelCadastroJogo = new JPanel(); //painel cadastro jogo
		painelCadastroJogo.setLayout(null);
		textoNomeJogo = new JTextField();
		labelNomeJogo = new JLabel("Nome do Jogo");
		botaoConfirmaCadastroJogo = new JButton("Confirmar");
		botaoVoltarCadastroJogo = new JButton("Voltar");
		textoNomeJogo.setBounds(100, 50, 120, 25); //int x, int y, int width, int height
		labelNomeJogo.setBounds(120, 30, 120, 25);
		botaoConfirmaCadastroJogo.setBounds(40, 100, 100, 25);
		botaoVoltarCadastroJogo.setBounds(160, 100, 100, 25);
		botaoConfirmaCadastroJogo.addActionListener(this);
		botaoVoltarCadastroJogo.addActionListener(this);
		painelCadastroJogo.add(labelNomeJogo);
		painelCadastroJogo.add(textoNomeJogo);
		painelCadastroJogo.add(botaoConfirmaCadastroJogo);
		painelCadastroJogo.add(botaoVoltarCadastroJogo);
		
		//painel apaga jogo
		painelApagaJogo = new JPanel();
		painelApagaJogo.setLayout(null);
		textoApagaJogo = new JTextField();
		textoApagaJogo.setBounds(100, 50, 120, 25);
		labelApagaJogo = new JLabel("Nome do Jogo");
		labelApagaJogo.setBounds(120, 30, 120, 25);
		botaoConfirmaApagaJogo = new JButton("Confirmar");
		botaoConfirmaApagaJogo.setBounds(40, 100, 100, 25);
		botaoConfirmaApagaJogo.addActionListener(this);
		botaoVoltarApagaJogo = new JButton("Voltar");
		botaoVoltarApagaJogo.setBounds(160, 100, 100, 25);
		botaoVoltarApagaJogo.addActionListener(this);
		painelApagaJogo.add(labelApagaJogo);
		painelApagaJogo.add(textoApagaJogo);
		painelApagaJogo.add(botaoConfirmaApagaJogo);
		painelApagaJogo.add(botaoVoltarApagaJogo);
		
		BuscaClienteA = new JPanel();	//painel busca cliente
		BuscaClienteA.setLayout(null);
		textoBuscaClienteA = new JTextField();
		textoBuscaClienteA.setBounds(100, 20, 165, 25);
		labelCpfClienteA = new JLabel("CPF");
		labelCpfClienteA.setBounds(60, 20, 165, 25);
		botaoConfirmaClienteA = new JButton("Confirmar");
		botaoConfirmaClienteA.setBounds(40, 100, 80, 25);
		botaoConfirmaClienteA.addActionListener(this);
		botaoVoltarClienteA = new JButton("Voltar");
		botaoVoltarClienteA.setBounds(140, 100, 80, 25);
		botaoVoltarClienteA.addActionListener(this);
		BuscaClienteA.add(textoBuscaClienteA);
		BuscaClienteA.add(labelCpfClienteA);
		BuscaClienteA.add(botaoConfirmaClienteA);
		BuscaClienteA.add(botaoVoltarClienteA);
		
		painelVCA = new JPanel();	//painel visualizar cliente
		painelVCA.setLayout(null);
		botaoAdicionarCreditos = new JButton("Adicionar Creditos");
		botaoAdicionarCreditos.setBounds(10, 70, 140, 25);
		botaoAdicionarCreditos.addActionListener(this);
		botaoVoltarVCA = new JButton("Voltar");
		botaoVoltarVCA.setBounds(240, 100, 80, 25);
		botaoVoltarVCA.addActionListener(this);
		painelVCA.add(botaoAdicionarCreditos);
		painelVCA.add(botaoVoltarVCA);
		
		painelApagar = new JPanel();	//painel apagar
		painelApagar.setLayout(null);
		textoA = new JTextField();
		textoA.setBounds(100, 20, 165, 25);
		cpfA = new JLabel("CPF");
		cpfA.setBounds(60, 20, 165, 25);
		botaoConfirmarA = new JButton("Confirmar");
		botaoConfirmarA.setBounds(40, 100, 80, 25);
		botaoConfirmarA.addActionListener(this);
		botaoVoltarA = new JButton("Voltar");
		botaoVoltarA.setBounds(140, 100, 80, 25);
		botaoVoltarA.addActionListener(this);
		painelApagar.add(textoA);
		painelApagar.add(cpfA);
		painelApagar.add(botaoConfirmarA);
		painelApagar.add(botaoVoltarA);
		
		painelAC = new JPanel();	//painel adicionar creditos
		painelAC.setLayout(null);
		creditosAC = new JLabel("Creditos");
		creditosAC.setBounds(40, 20, 165, 25);
		textoAC = new JTextField();
		textoAC.setBounds(100, 20, 165, 25);
		botaoAdicionarAC = new JButton("Confirmar");
		botaoAdicionarAC.setBounds(40, 100, 80, 25);
		botaoAdicionarAC.addActionListener(this);
		botaoVoltarAC = new JButton("Voltar");
		botaoVoltarAC.setBounds(140, 100, 80, 25);
		botaoVoltarAC.addActionListener(this);
		painelAC.add(creditosAC);
		painelAC.add(textoAC);
		painelAC.add(botaoAdicionarAC);
		painelAC.add(botaoVoltarAC);
		
		
		moldura.add(painelMP);
		moldura.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == carregar_lista) {
			int n = cCliente.carregarClientes();
			if (n == 0) {
				JOptionPane.showMessageDialog(null, "So e possivel carregar uma lista de clientes caso a atual esteja vazia", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		//painel menu principal
		else if (e.getSource() == botaoCC) {
	    	moldura.remove(painelMP);
	    	
	    	moldura.setTitle("Cadastrar Cliente");
	    	
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
		//painel cadastrar cliente/atendente
		else if (e.getSource() == botaoConfirmar) {	
			try {
				String nome = textoNome.getText();
				long cpf = Long.parseLong(textoCPF.getText());
				String senha = new String(textoSenha.getPassword()); 
				if(moldura.getTitle() == "Cadastrar Cliente") {
					Cliente c = new Cliente(nome, senha, cpf);
					int n = cCliente.cadastrarCliente(c);
					if (n == 0) {
						JOptionPane.showMessageDialog(null, "CPF ja cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
						textoNome.setText("");
						textoCPF.setText("");
						textoSenha.setText("");
					}
					else {
						textoNome.setText("");
						textoCPF.setText("");
						textoSenha.setText("");
						moldura.setTitle("Fliperama Menu");
						moldura.remove(painelCC);
						moldura.add(painelMP);
						moldura.validate();
						moldura.setVisible(false);
						moldura.setVisible(true);
					}
				}
				else if (moldura.getTitle() == "Cadastrar Atendente") {
					Atendente a = new Atendente(nome, senha, cpf);
					int n = cAtendente.cadastrarAtendente(a);
					if (n == 0) {
						JOptionPane.showMessageDialog(null, "CPF ja cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
						textoNome.setText("");
						textoCPF.setText("");
						textoSenha.setText("");
					}
					else {
						textoNome.setText("");
						textoCPF.setText("");
						textoSenha.setText("");
						moldura.setTitle("Fliperama Menu");
						moldura.remove(painelCC);
						moldura.add(painelMA);
						moldura.validate();
						moldura.setVisible(false);
						moldura.setVisible(true);
					}
				}
			} catch (NumberFormatException t) {
				JOptionPane.showMessageDialog(null, "CPF deve conter apenas numeros", "Erro", JOptionPane.ERROR_MESSAGE);
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
				if (moldura.getTitle() == "Cadastrar Cliente") {
					moldura.setTitle("Fliperama Menu");
					moldura.add(painelMP);
					moldura.validate();
					moldura.setVisible(false);
					moldura.setVisible(true);
				}
				else if (moldura.getTitle() == "Cadastrar Atendente") {
					moldura.setTitle("Fliperama Menu");
					moldura.add(painelMA);
					moldura.validate();
					moldura.setVisible(false);
					moldura.setVisible(true);
				}
			}
		}
		//painel fazer login
		else if (e.getSource() == botaoLogin) {
			try {
				long cpf = Long.parseLong(textoCPFFL.getText());
			    String senha = new String(textoSenhaFL.getPassword()); 
				int n = cCliente.fazerLogin(cpf, senha);
				int m = cAtendente.fazerLogin(cpf, senha);
				if (n == m) {
					//TODO: nao permitir CPFs iguais para usuarios/atendentes
					JOptionPane.showMessageDialog(null, "CPF ou senha invalido", "Erro", JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(null, "CPF deve conter apenas numeros", "Erro", JOptionPane.ERROR_MESSAGE);
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
		//painel menu cliente
		else if (e.getSource() == botaoLogoutMC) {
			moldura.remove(painelMC);
			moldura.add(painelFL);
			moldura.validate();
			moldura.setVisible(false);
			moldura.setVisible(true);
		}
		//painel menu atendente
		else if(e.getSource() == botaoBuscarCliente) {
			moldura.remove(painelMA);
			moldura.add(BuscaClienteA);
			moldura.validate();
			moldura.setVisible(false);
			moldura.setVisible(true);
		}
		else if (e.getSource() == botaoApagarCliente){
			moldura.remove(painelMA);
			moldura.setTitle("Apagar Cliente");
			moldura.add(painelApagar);
			moldura.validate();
			moldura.setVisible(false);
			moldura.setVisible(true);
		}
		else if (e.getSource() == botaoCadastrarAtendente) {
			moldura.remove(painelMA);
			moldura.setTitle("Cadastrar Atendente");
			moldura.add(painelCC);
			moldura.validate();
			moldura.setVisible(false);
			moldura.setVisible(true);
		}
		
		else if (e.getSource() == botaoApagarAtendente){
			moldura.remove(painelMA);
			moldura.setTitle("Apagar Atendente");
			moldura.add(painelApagar);
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
		//painel buscar cliente
		else if(e.getSource() == botaoConfirmaClienteA) {
			try {
				//TODO: arrumar erro no try/catch
				long cpf = Long.parseLong(textoBuscaClienteA.getText());
			    Cliente c = cCliente.buscaClienteA(cpf);
				if (c == null) {
					JOptionPane.showMessageDialog(null, "Cliente nao cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
					textoBuscaClienteA.setText("");
				}
				else {
					textoBuscaClienteA.setText("");
					moldura.remove(BuscaClienteA);
					
					nomeVCA = new JLabel("Nome: " + cCliente.dadosCliente()[0]);
					nomeVCA.setBounds(10, 0, 250, 25);
					painelVCA.add(nomeVCA);
					CPFVCA = new JLabel("CPF: " + cCliente.dadosCliente()[1]);
					CPFVCA.setBounds(10, 20, 250, 25);
					painelVCA.add(CPFVCA);
					creditosVCA = new JLabel("Creditos: " + cCliente.dadosCliente()[2]);
					creditosVCA.setBounds(10, 40, 250, 25);
					painelVCA.add(creditosVCA);
					
					moldura.add(painelVCA);
					moldura.validate();
					moldura.setVisible(false);
					moldura.setVisible(true);
				}
			} catch (NumberFormatException t) {
				JOptionPane.showMessageDialog(null, "CPF deve conter apenas numeros", "Erro", JOptionPane.ERROR_MESSAGE);
				textoBuscaClienteA.setText("");
			}
		}
		else if (e.getSource() == botaoVoltarClienteA) {
			textoBuscaClienteA.setText("");
			moldura.remove(BuscaClienteA);
			moldura.add(painelMA);
			moldura.validate();
			moldura.setVisible(false);
			moldura.setVisible(true);
		}
		//painel apagar cliente/atendente
		else if (e.getSource() == botaoConfirmarA) {
			try {
				//TODO: arrumar erro no try/catch
				long cpf = Long.parseLong(textoA.getText());
				if(moldura.getTitle() == "Apagar Cliente") {
					if (JOptionPane.showConfirmDialog(null, "Deseja apagar o cliente?", "Confirmacao de remocao", JOptionPane.YES_NO_OPTION) == 0) {
						int n = cCliente.apagarCliente(cpf);
						if (n == 0) {
							JOptionPane.showMessageDialog(null, "Cliente nao cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
							textoA.setText("");
						}
						else {
							textoA.setText("");
							moldura.setTitle("Fliperama Menu");
							moldura.remove(painelApagar);
							moldura.add(painelMA);
							moldura.validate();
							moldura.setVisible(false);
							moldura.setVisible(true);
						}
					}
				}
				else if(moldura.getTitle() == "Apagar Atendente") {
					if (JOptionPane.showConfirmDialog(null, "Deseja apagar o atendente?", "Confirmacao de remocao", JOptionPane.YES_NO_OPTION) == 0) {
						int n = cAtendente.apagarAtendente(cpf);
						if (n == 0) {
							JOptionPane.showMessageDialog(null, "Atendente nao cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
							textoA.setText("");
						}
						else {
							textoA.setText("");
							moldura.setTitle("Fliperama Menu");
							moldura.remove(painelApagar);
							moldura.add(painelMA);
							moldura.validate();
							moldura.setVisible(false);
							moldura.setVisible(true);
							moldura.remove(painelCC);
						}
					}
				}
			}catch (NumberFormatException t) {
				JOptionPane.showMessageDialog(null, "CPF deve conter apenas numeros", "Erro", JOptionPane.ERROR_MESSAGE);
				textoCPF.setText("");
			}
		}
		else if (e.getSource() == botaoVoltarA) {
			textoA.setText("");
			moldura.remove(painelApagar);
			moldura.add(painelMA);
			moldura.validate();
			moldura.setVisible(false);
			moldura.setVisible(true);
		}
		//painel visualizar cliente (atendente)
		else if (e.getSource() == botaoAdicionarCreditos) {
			moldura.remove(painelVCA);
			moldura.add(painelAC);
			moldura.validate();
			moldura.setVisible(false);
			moldura.setVisible(true);
		}
		else if (e.getSource() == botaoVoltarVCA) {
			cCliente.desmarcarCliente();
			painelVCA.remove(nomeVCA);
			painelVCA.remove(CPFVCA);
			painelVCA.remove(creditosVCA);
			moldura.remove(painelVCA);
			moldura.add(BuscaClienteA);
			moldura.validate();
			moldura.setVisible(false);
			moldura.setVisible(true);
		}
		
		//painel adicionar creditos
		else if (e.getSource() == botaoAdicionarAC) {
			try {
				int n = Integer.parseInt(textoAC.getText());
				cCliente.adicionarCreditos(n);
				textoAC.setText("");
				moldura.remove(painelAC);
				painelVCA.remove(creditosVCA);
				creditosVCA = new JLabel("Creditos: " + cCliente.dadosCliente()[2]);
				creditosVCA.setBounds(10, 40, 250, 25);
				painelVCA.add(creditosVCA);
				moldura.add(painelVCA);
				moldura.validate();
				moldura.setVisible(false);
				moldura.setVisible(true);
			} catch (NumberFormatException t) {
				JOptionPane.showMessageDialog(null, "Creditos deve conter apenas numeros", "Erro", JOptionPane.ERROR_MESSAGE);
				textoAC.setText("");
			}
		}
		else if (e.getSource() == botaoVoltarAC) {
			textoAC.setText("");
			moldura.remove(painelAC);
			moldura.add(painelVCA);
			moldura.validate();
			moldura.setVisible(false);
			moldura.setVisible(true);
		}
		//painel Cadastrar Jogos
		else if(e.getSource() == botaoCadastrarJogo) {
			moldura.remove(painelMA);
	    	moldura.setTitle("Cadastrar Jogos");
	    	textoNomeJogo.setText("");
	    	moldura.add(painelCadastroJogo);
	    	moldura.validate();
	    	moldura.setVisible(false);
			moldura.setVisible(true);
		}
		//painel Cadastrar Jogos
		else if(e.getSource() == botaoConfirmaCadastroJogo) {
			try {
				String nomeJogo = textoNomeJogo.getText();
				Jogo j = new Jogo(nomeJogo, 0);
				cJogos.cadastrarJogos(j);
				
				moldura.remove(painelCadastroJogo);
		    	moldura.setTitle("Fliperama Menu");
		    	moldura.add(painelMA);
		    	moldura.validate();
		    	moldura.setVisible(false);
				moldura.setVisible(true);
				
			} catch (NumberFormatException t) {
				JOptionPane.showMessageDialog(null, "Jogo ja cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
				textoNomeJogo.setText("");
			}
		}else if(e.getSource() == botaoVoltarCadastroJogo) {		
			moldura.remove(painelCadastroJogo);
	    	moldura.setTitle("Fliperama Menu");
	    	moldura.add(painelMA);
	    	moldura.validate();
	    	moldura.setVisible(false);
			moldura.setVisible(true);

		}
	}
}
