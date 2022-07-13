package ES.ufsj.edu.br.testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ES.ufsj.edu.br.model.Cliente;
import ES.ufsj.edu.br.persistencia.PCliente;
import ES.ufsj.edu.br.model.Atendente;


class Teste {

	@Test
	void testeCliente() {
		Cliente cliente = new Cliente("henrique", "123", Long.parseLong("25564491017"));
		assertEquals(Long.parseLong("25564491017"), cliente.getCPF());
		assertEquals("henrique", cliente.getNome());
		assertEquals("123", cliente.getSenha());
		assertEquals(0, cliente.getCreditos());
		assertEquals(false, cliente.getRoot());
	}
	void testeAtendente() {
		Atendente atendente = new Atendente("paulo", "admin", Long.parseLong("96745238690"));
		assertEquals(Long.parseLong("96745238690"), atendente.getCPF());
		assertEquals("henrique", atendente.getNome());
		assertEquals("123", atendente.getSenha());
		assertEquals(true, atendente.getRoot());
	}
	
	void testePCliente() {
		PCliente pCliente = new PCliente();
		Cliente cliente1 = new Cliente("henrique", "123", Long.parseLong("25564491017"));
		Cliente cliente2 = new Cliente("paulo", "321", Long.parseLong("98536584237"));
		Cliente cliente3 = new Cliente("juan", "213", Long.parseLong("98514765251"));
		Cliente cliente4 = new Cliente("teste", "312", Long.parseLong("25564491017"));
		pCliente.incluir(cliente1);
		pCliente.incluir(cliente2);
		pCliente.incluir(cliente3);
		pCliente.incluir(cliente4);
		ArrayList<Long> cpfs = pCliente.getCPFs();
		assertEquals(3, cpfs.size());
		pCliente.remover(cliente3.getCPF());
		ArrayList<Long> cpfs2 = pCliente.getCPFs();
		assertEquals(2, cpfs2.size());
	}
}