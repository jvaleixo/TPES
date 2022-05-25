package ES.ufsj.edu.br.persistencia;

import java.util.ArrayList;
import java.util.List;

import ES.ufsj.edu.br.model.Cliente;

public class PCliente {
	private List<Cliente> clientes;
	
	void PClient() {
		clientes =  new ArrayList<Cliente>();
		
	}
	
	// *verificar se usuario ja existe. 
	public int incluir(Cliente c) {
		
		clientes.add(c);
		return 1;
	}
}
