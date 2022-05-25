package ES.ufsj.edu.br.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ES.ufsj.edu.br.view.*;
import ES.ufsj.edu.br.persistencia.*;
import ES.ufsj.edu.br.model.*;

public class Principal implements ActionListener{
	
	//Menus
	private static Menu menu = new Menu();
	private static MenuCadastrarCliente menuCC = new MenuCadastrarCliente();
	
	//Listas
	private static PCliente pCliente = new PCliente();
	
	
	public static void main(String[] args) {
		menu.getBotaoCC().addActionListener(new Principal());
		//menu.getBotaoEL().addActionListener(new Principal());
		menu.getBotaoSair().addActionListener(new Principal());
		menuCC.getBotaoConfirmar().addActionListener(new Principal());
		menuCC.getBotaoCancelar().addActionListener(new Principal());
		
		menu.getMoldura().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		//clica no botao cadastrar cliente no menu principal
		if (e.getSource() == menu.getBotaoCC()) {
			menu.getMoldura().setVisible(false);
	    	menuCC.getMoldura().setVisible(true);
		}
		//clica no botao de sair no menu principal
		else if (e.getSource() == menu.getBotaoSair()) {
			menu.getMoldura().setVisible(false);
	    	System.exit(0);
		}
		//clica no botao de confirmar no menu de cadastrar cliente
		else if (e.getSource() == menuCC.getBotaoConfirmar()) {
			cadastrarCliente();
			menuCC.getMoldura().setVisible(false);
			menu.getMoldura().setVisible(true);
		}
		//clica no botao de cancelar no menu de cadastrar cliente
		else if (e.getSource() == menuCC.getBotaoCancelar()) {
			if (JOptionPane.showConfirmDialog(null, "Deseja cancelar?", "Confirmacao cancelamento", JOptionPane.YES_NO_OPTION) == 0) {
				menuCC.getMoldura().setVisible(false);
				menu.getMoldura().setVisible(true);
			}
		}
	}
	
	public static void cadastrarCliente() {
	    String nome = menuCC.getUsuario();
	    String senha = menuCC.getSenha(); 
			
		Cliente c = new Cliente(nome, senha);
		pCliente.incluir(c);
		
		System.out.println("\nCliente Cadastrado\n\n");
	}

}
