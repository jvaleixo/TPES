package ES.ufsj.edu.br.testes;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import ES.ufsj.edu.br.model.Cliente;

public class TesteUsuario {

	@Test
	public void testeCPF() {
		Cliente cliente = new Cliente("henrique", "123", Long.parseLong("25564491017"));
		assertEquals(Long.parseLong("25564491017"), cliente.getCPF());
	}

}
