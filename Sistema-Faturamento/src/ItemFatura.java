public class ItemFatura {

	private Produto produto;
	private int quantidade;
	public ItemFatura(Produto produto, int quantidade) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
	}
	public Produto getProduto() {
		return produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	
	public double getSubtotal() {
		return produto.getPreco() * quantidade;
	}
	
	public String toString() {
		return produto.getNome() + " x " + quantidade + " - Subtotal: R$ " + getSubtotal(); 
	}
	
	
	
}
