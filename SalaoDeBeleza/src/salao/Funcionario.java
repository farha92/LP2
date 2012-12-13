package salao;


public class Funcionario extends Pessoa{
	
	private String funcao;

	public Funcionario(String nome, String endereco, String telefone,
			String funcao, int id) {
		super(id,nome, endereco, telefone);
		this.funcao = funcao;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	
	
}
