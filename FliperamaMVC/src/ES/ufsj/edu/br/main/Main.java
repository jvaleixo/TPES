package ES.ufsj.edu.br.main;

import java.io.IOException;
import java.util.Scanner;

import ES.ufsj.edu.br.controller.*;
import ES.ufsj.edu.br.model.*;
import ES.ufsj.edu.br.persistencia.*;
import ES.ufsj.edu.br.view.*;

public class Main {
	public static void main(String[] args) {
		PCliente pCliente = new PCliente();
		PAtendente pAtendente = new PAtendente();
		PJogos pJogos = new PJogos();
		
		//pCliente.imprimirLista();
		//pAtendente.imprimirListaAtendente();
		
		Janela J = new Janela();
	}
}
