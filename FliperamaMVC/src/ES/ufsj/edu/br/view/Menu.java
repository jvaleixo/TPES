package ES.ufsj.edu.br.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu {
	private JPanel painel;
	private JFrame moldura;
	private JButton botaoCC;
	private JButton botaoEL;
	private JButton botaoSair;
	
	
	public Menu () {
		
		painel = new JPanel();
		moldura = new JFrame();
		moldura.setTitle("Fliperama Menu");	//mudar depois
		moldura.setSize(350, 200);
		moldura.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		moldura.add(painel);
		
		painel.setLayout(null);
		
		botaoCC = new JButton("Cadastrar Cliente");
		botaoCC.setBounds(90, 10, 140, 25);
		painel.add(botaoCC);
		
		botaoEL = new JButton("Efetuar Login");
		botaoEL.setBounds(90, 50, 140, 25);
		painel.add(botaoEL);
		
		botaoSair = new JButton("Sair");
		botaoSair.setBounds(90, 90, 140, 25);
		painel.add(botaoSair);
		
	}
	
	//gets
	public JFrame getMoldura() {
		return this.moldura;
	}
	public JButton getBotaoCC() {
		return this.botaoCC;
	}
	public JButton getBotaoEL() {
		return this.botaoEL;
	}
	public JButton getBotaoSair() {
		return this.botaoSair;
	}
}