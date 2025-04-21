public class Produto {

	private String nome;
	private double preco;
	private int estoque;
	
	public Produto(String nome, double preco, int estoque) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public void reduzirEstoque(int quantidade) {
		if(quantidade <= estoque) {
			estoque -= quantidade;
		}
	}
	
	public String toString() {
		return "Nome: " + nome + " || Preço: " + preco + " || Estoque: " + estoque;

	}
	
	
	
}
