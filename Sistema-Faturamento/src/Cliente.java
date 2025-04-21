public class Cliente {
	
	private String nome;
	private String documento;
	private String email;
	
	public Cliente(String nome, String documento, String email) {
		super();
		this.nome = nome;
		this.documento = documento;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEmail() {
		return email;
	}

	public String toString() {
		return "Nome: " + nome + ", Documento: " + documento + ", Email: " + email;
	}
	
}
