package salao;

public class Pessoa {

	private int id;
	private String nome;
	private String endereco;
	private String telefone;

	
	public Pessoa(int id,String nome, String endereco, String telefone) {
		super();
		this.id=id;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;

	}

	public int getId()
	{return id;}
	
	public void setId(int id)
	{this.id = id;}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	


	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", endereco=" + endereco
				+ ", telefone=" + telefone + ", id=" + id + "]";
	}
	
	
}
