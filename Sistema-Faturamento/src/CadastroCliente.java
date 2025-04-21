
import java.util.ArrayList;
import java.util.Scanner;

public class CadastroCliente {
	
	private static ArrayList<Cliente> clientes = new ArrayList<>();
	private static ArrayList<Produto> produtos = new ArrayList<>();
	private static ArrayList<Fatura> faturas = new ArrayList<>();
	
	
	public static void main(String[] args) {
		
		
		Scanner entrada = new Scanner(System.in);
		int opcao;
		
		do {
			System.out.println("\n--- Sistema de Faturamento ---");
			System.out.println("1. Cadastrar cliente");
			System.out.println("2. Listar clientes");
			System.out.println("3. Cadastrar produto");
			System.out.println("4. Listar produtos");
			System.out.println("5. Criar fatura");
			System.out.println("6. Listar faturas");
			System.out.println("0. Sair");
			System.out.println("Escolha uma opção: ");
			opcao = entrada.nextInt();
			entrada.nextLine();
			
			switch (opcao) {
			case 1: 
				cadastrarCliente(entrada);
				break;
				
			case 2:
				listarCliente();
				break;
				
			case 3: 
				cadastrarProduto(entrada);
				break;
				
			case 4: 
				listarProdutos();
				break;
				
			case 5: 
				criarFatura(entrada);
				break;
				
			case 6: 
				listarFaturas();
				break;
				
			case 0:
				System.out.println("Encerrando...");
				break;
			default:
				System.out.println("Opção Inválida!");
			}
		}while(opcao != 0);
		
	
		entrada.close();
		
		
		
		
	}
	
	public static boolean validarDocumento(String doc) {
		String numeros = doc.replaceAll("[^0-9]", "");
		return numeros.length() == 11 || numeros.length() == 14;
	}
	
	public static void cadastrarCliente(Scanner entrada) {
		System.out.println("Nome: ");
		String nome = entrada.nextLine();
		
		String documento;
		while(true) {
			System.out.println("CPF ou CNPJ: ");
			documento = entrada.nextLine();
			if(validarDocumento(documento)) {
				break;
			}else {
				System.out.println("Documento inválido.");
			}
		}
		
		System.out.println("Email: ");
		String email = entrada.nextLine();
		
		Cliente cliente = new Cliente(nome, documento, email);
		clientes.add(cliente);
		
		System.out.println("Cadastro realizado com sucesso!");
	}
	
	public static void listarCliente() {
		if(clientes.isEmpty()) {
			System.out.println("Nenhum cliente cadastrado.");
		}else {
			System.out.println("\n --- Lista de clientes ---");
			for(Cliente c : clientes) {
				System.out.println(c);
			}
		}
	}
	
	public static void cadastrarProduto(Scanner entrada) {
		System.out.println("Nome do produto: ");
		String nome = entrada.nextLine();
		
		double preco = 0;
		while(true) {
			try {
				System.out.print("Preco: ");
				preco = Double.parseDouble(entrada.nextLine().replace("," , "."));
				if(preco < 0) {
					System.out.println("Preço não pode ser negativo.");
					continue;
				}
				break;
			}catch (NumberFormatException e) {
				System.out.println("Digite um valor numérico válido.");
			}
		}
		
		int estoque = 0;
		while(true) {
			try {
				System.out.println("Quantidade em estoque: ");
				estoque = Integer.parseInt(entrada.nextLine());
			
			if(estoque < 0) {
				System.out.println("Estoque não pode ser negativo.");
				continue;
			}
			break;
			
			}catch(NumberFormatException e){
				System.out.println("Digite um número inteiro válido.");
			}
		  }
		
		
		Produto produto = new Produto(nome, preco, estoque);
		produtos.add(produto);
		
		System.out.println("Produto cadastrado com sucesso!");
	}
	
	public static void listarProdutos() {
		if(produtos.isEmpty()) {
			System.out.println("Nenhum produto cadastrado.");
		}else {
			System.out.println("\n--- Lista de produtos ---");
			for(Produto p : produtos) {
				System.out.println(p);
			}
		}
	}
	
	
	public static void criarFatura(Scanner entrada) {
		if(clientes.isEmpty() || produtos.isEmpty()) {
			System.out.println("É necessário ter ao menos um cliente e um produto cadastrado.");
			return;
		}
		
		System.out.println("Selecione um cliente: ");
		for(int i = 0; i < clientes.size(); i++) {
			System.out.println(i + " - " + clientes.get(i).getNome() );
		}
		
		int clienteIndex = entrada.nextInt();
		entrada.nextLine();
		Cliente cliente = clientes.get(clienteIndex);
		
		Fatura fatura = new Fatura(cliente);
		
		String continuar;
		
		do {
			System.out.println("Selecione um produto: ");
			for(int i = 0; i < produtos.size(); i++) {
				System.out.println(i + " - " + produtos.get(i).getNome() + "(Estoque: " + produtos.get(i).getEstoque() + ")");
			}
			int produtoIndex = entrada.nextInt();
			Produto produto = produtos.get(produtoIndex);
			
			System.out.println("Quantidade: ");
			int quantidade = entrada.nextInt();
			entrada.nextLine();
			
			if(quantidade > produto.getEstoque()) {
				System.out.println("Estoque insuficiente!");
			}else {
				fatura.adicionarItem(produto, quantidade);
			}
			
			System.out.println("Adicionar outro produto? (s/n): ");
			continuar = entrada.nextLine();
			
		}while(continuar.equalsIgnoreCase("s"));
		
		faturas.add(fatura);
		System.out.println("Fatura criada com sucesso!\n");
		System.out.println(fatura);
	}
	
	public static void listarFaturas() {
		if(faturas.isEmpty()) {
			System.out.println("Nenhuma fatura criada.");
		}else {
			for(Fatura f : faturas) {
				System.out.println("\n--- Fatura ---");
				System.out.println(f);
			}
		}
	}
}
