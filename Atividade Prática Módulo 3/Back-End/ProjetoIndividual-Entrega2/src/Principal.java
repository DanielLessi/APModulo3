import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Principal {

	public static void main(String[] args) {
//		Conexão com o Banco de Dados
		ClienteDAO clienteDAO = new ClienteDAO();
		DestinoDAO destinoDAO = new DestinoDAO();
//		Captura dos dados digitados pelo usuário
		Scanner input = new Scanner(System.in);	
		int menuPrincipal=9;
		do {
			PrintMenuPrincipal();
			
			menuPrincipal = input.nextInt();

			switch(menuPrincipal) {
			case 1:
				MenuCliente(clienteDAO, input);
				break;
			case 2:
				MenuDestino(destinoDAO, input);
				break;
			case 0:
				System.out.println("Obrigado por usar nossa Agência.");
				break;
			default:
				break;
			}
		}while(menuPrincipal != 0);
		input.close();
	}
	
	public static void PrintMenuPrincipal() {
		System.out.println("------------------------------------------------");
		System.out.println("|              Agencia de Viagens              |");
		System.out.println("------------------------------------------------");
		System.out.println("1 - Editar Clientes");
		System.out.println("2 - Editar Destinos");
		System.out.println("0 - Sair");
	}
	
	public static void MenuCliente(ClienteDAO _clienteDAO, Scanner _input) {
		int menuInterno = 9;
		do {
			System.out.println("------------------------------------------------");
			System.out.println("|              Gerenciar Clientes              |");
			System.out.println("------------------------------------------------");
			System.out.println("1 - Cadastrar Cliente");
			System.out.println("2 - Excluir Cliente");
			System.out.println("3 - Mostrar Clientes");
			System.out.println("4 - Buscar Cliente por nome");
			System.out.println("5 - Buscar Cliente por id");
			System.out.println("6 - Editar Cliente");
			System.out.println("0 - Voltar ao menu principal");
			
			menuInterno = _input.nextInt();

			switch(menuInterno) {
			case 1:
				CadastroCliente(_clienteDAO, _input);
				break;
			case 2:
				ExcluirCliente(_clienteDAO, _input);
				break;
			case 3:
				BuscarCliente(_clienteDAO);
				break;
			
			case 4:
				BuscarClienteNome(_clienteDAO, _input);				
				break;
			case 5:
				BuscarClienteID(_clienteDAO, _input);				
				break;
			case 6:
				EditarCliente(_clienteDAO, _input);
				break;
			case 0:
				System.out.println("Voltando ao menu principal.");
				break;
			default:
				break;
			}
		}while(menuInterno != 0);
		
	}
	
	public static void MenuDestino(DestinoDAO _destinoDAO, Scanner _input) {
		int menuInterno = 9;
		do {
			System.out.println("------------------------------------------------");
			System.out.println("|              Gerenciar Destinos              |");
			System.out.println("------------------------------------------------");
			System.out.println("1 - Cadastrar Destino");
			System.out.println("2 - Excluir Destino");
			System.out.println("3 - Mostrar Destinos");
			System.out.println("4 - Buscar Destino por nome");
			System.out.println("5 - Buscar Destino por id");
			System.out.println("6 - Editar Destino");
			System.out.println("0 - Voltar ao menu principal");
			
			menuInterno = _input.nextInt();
	
			switch(menuInterno) {
			case 1:
				CadastroDestino(_destinoDAO, _input);
				break;
			case 2:
				ExcluirDestino(_destinoDAO, _input);
				break;
			case 3:
				BuscarDestino(_destinoDAO);
				break;
			
			case 4:
				BuscarDestinoNome(_destinoDAO, _input);				
				break;
			case 5:
				BuscarDestinoID(_destinoDAO, _input);				
				break;
			case 6:
				EditarDestino(_destinoDAO, _input);
				break;
			case 0:
				System.out.println("Voltando ao menu principal.");
				break;
			default:
				break;
			}
		}while(menuInterno != 0);
	}
	
	//Cliente
	
	public static Cliente CriarCliente(Scanner _input) {
		Cliente cliente = new Cliente();
		System.out.println("Digite o nome que deseja cadastrar:");
		cliente.setNome(_input.next());
		
		System.out.println("Digite o sobrenome que deseja cadastrar:");
		cliente.setSobrenome(_input.next());
		
		System.out.println("Digite o CPF:");
		cliente.setCPF(_input.next());
		
		System.out.println("Digite a Data de Nascimento(dd/MM/yyyy):");
		String data = _input.next();
		Date dataNasc = new Date();
		try {
			dataNasc = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cliente.setDataNascimento(dataNasc);
		
		System.out.println("Digite o telefone:");
		cliente.setTelefone(_input.next());
		
		System.out.println("Digite o email:");
		cliente.setEmail(_input.next());
		
		System.out.println("Digite o endereço:");
		cliente.setEndereco(_input.next());
		
		System.out.println("Digite o numero da residência:");
		cliente.setNumero(_input.nextInt());
		
		System.out.println("Digite o CEP:");
		cliente.setCEP(_input.next());
		return cliente;
		
	}
	
	public static void PrintCliente(Cliente c) {
		System.out.println("Id: " + c.getId());
		System.out.println("NOME: " + c.getNome());
		System.out.println("SOBRENOME: " + c.getSobrenome());
		System.out.println("CPF: " + c.getCPF());
		System.out.println("DATA DE NASCIMENTO: " + c.getDataNascimento());
		System.out.println("TELEFONE: " + c.getTelefone());
		System.out.println("E-MAIL: " + c.getEmail());
		System.out.println("ENDEREÇO: " + c.getEndereco());
		System.out.println("NUMERO: " + c.getNumero());
		System.out.println("CEP: " + c.getCEP());
		System.out.println("----------------------------------- ");
	}
	
	public static void CadastroCliente(ClienteDAO _clienteDAO, Scanner _input){
		Cliente cliente = CriarCliente(_input);
		_clienteDAO.saveCliente(cliente);
	}
	
	public static void BuscarCliente(ClienteDAO _contatoDAO) {
		for (Cliente c : _contatoDAO.getClientes()) {
			PrintCliente(c);
		}
	}
	
	public static void ExcluirCliente(ClienteDAO _clienteDAO, Scanner _input) {
		int numDigitado;
		System.out.println("Digite o ID do cliente que deseja excluir:");
		numDigitado = _input.nextInt();
		_clienteDAO.removeById(numDigitado);		
	}
	
	public static void EditarCliente(ClienteDAO _clienteDAO, Scanner _input) {
		System.out.println("Digite o ID do usuário que deseja alterar:");
		int id = _input.nextInt();
		
		Cliente cliente = CriarCliente(_input);
		cliente.setId(id);		
		_clienteDAO.updateCliente(cliente);
	}
	
	public static void BuscarClienteNome(ClienteDAO _clienteDAO, Scanner _input) {
		System.out.println("Digite o nome que deseja buscar:");
		String nomeBuscado = CapturarString(_input);
		boolean encontrado = false;
		for (Cliente c : _clienteDAO.getClientesNome(nomeBuscado)) {
			if(c.getNome() != null && c.getNome().contains(nomeBuscado)) {
				PrintCliente(c);
				encontrado = true;
			}
		}
		if(encontrado == false) {
			System.out.println("Cliente não encontrado");
		}
	}
	public static void BuscarClienteID(ClienteDAO _clienteDAO, Scanner _input) {
		System.out.println("Digite o ID que deseja buscar:");
		int idBuscado = _input.nextInt();
		boolean encontrado = false;
		Cliente c =  _clienteDAO.getClientesID(idBuscado);
		if(c.getId() != 0) {
			PrintCliente(c);
			encontrado = true;
		}
		if(encontrado == false) {
			System.out.println("ID não encontrado");
		}
	}
	
	//Destino
	
	public static Destino CriarDestino(Scanner _input) {
		Destino destino = new Destino();
		
		System.out.println("Digite o nome do destino:");
		destino.setNome(_input.next());
		
		System.out.println("Digite o País:");
		destino.setPais(_input.next());
		
		System.out.println("Digite a Cidade do Destino:");
		destino.setCidade(_input.next());
		
		System.out.println("Digite o Aeroporto:");
		destino.setAeroporto(_input.next());
		
		return destino;
		
	}
	
	public static void CadastroDestino(DestinoDAO _destinoDAO, Scanner _input){
		Destino destino = CriarDestino(_input);
		_destinoDAO.saveDestino(destino);
	}
	
	public static void PrintDestino(Destino d) {
		System.out.println("Id: " + d.getId());
		System.out.println("NOME: " + d.getNome());
		System.out.println("País: " + d.getPais());
		System.out.println("Cidade: " + d.getCidade());
		System.out.println("Aeroporto: " + d.getAeroporto());
		System.out.println("----------------------------------- ");
	}
	
	public static void BuscarDestino(DestinoDAO _destinoDAO) {
		for (Destino d : _destinoDAO.getDestinos()) {
			PrintDestino(d);
		}
	}
	
	public static void ExcluirDestino(DestinoDAO _destinoDAO, Scanner _input) {
		int numDigitado;
		System.out.println("Digite o ID do destino que deseja excluir:");
		numDigitado = _input.nextInt();
		_destinoDAO.removeById(numDigitado);		
	}

	public static void EditarDestino(DestinoDAO _destinoDAO, Scanner _input) {
		System.out.println("Digite o ID do usuário que deseja alterar:");
		int id = _input.nextInt();
		
		Destino destino = CriarDestino(_input);
		destino.setId(id);		
		_destinoDAO.updateDestino(destino);
	}
	
	public static void BuscarDestinoNome(DestinoDAO _destinoDAO, Scanner _input) {
		System.out.println("Digite o nome do destino que deseja buscar:");
		String nomeBuscado = CapturarString(_input);
		boolean encontrado = false;
		for (Destino d : _destinoDAO.getDestinosNome(nomeBuscado)) {
			if(d.getNome() != null && d.getNome().contains(nomeBuscado)) {
				PrintDestino(d);
				encontrado = true;
			}
		}
		if(encontrado == false) {
			System.out.println("Destino não encontrado");
		}
	}
	
	public static void BuscarDestinoID(DestinoDAO _destinoDAO, Scanner _input) {
		System.out.println("Digite o ID que deseja buscar:");
		int idBuscado = _input.nextInt();
		boolean encontrado = false;
		Destino d =  _destinoDAO.getDestinosID(idBuscado);
		if(d.getId() != 0) {
			PrintDestino(d);
			encontrado = true;
		}
		if(encontrado == false) {
			System.out.println("ID não encontrado");
		}
	}
	
	public static String CapturarString(Scanner inputInterno) {
		String stringEspaco = inputInterno.nextLine();
		stringEspaco = inputInterno.nextLine();
		return stringEspaco;	
	}
	
}