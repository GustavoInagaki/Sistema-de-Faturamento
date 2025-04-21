import java.time.LocalDate;
import java.util.ArrayList;

public class Fatura {

	private Cliente cliente;
	private LocalDate data;
	private ArrayList<ItemFatura> itens;
	public Fatura(Cliente cliente) {
		super();
		this.cliente = cliente;
		this.data = LocalDate.now();
		this.itens = new ArrayList<>();
	}
	
	
	public void adicionarItem(Produto produto, int quantidade) {
		itens.add(new ItemFatura(produto, quantidade));
		produto.reduzirEstoque(quantidade);
	}
	
	public double getTotal() {
		double total = 0;
		for(ItemFatura item : itens) {
			total += item.getSubtotal();
		}
		return total;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Cliente: ").append(cliente.getNome()).append("\n");
		sb.append("Data: ").append(data).append("\n");
		sb.append("Itens: \n");
		
		for(ItemFatura item : itens) {
			sb.append("   ").append(item).append("\n");
		}
		
		sb.append("Total: R$ ").append(getTotal());
		return sb.toString();
		
	}
	
}
