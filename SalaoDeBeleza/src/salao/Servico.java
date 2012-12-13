package salao;

public class Servico {
	
	private String tipo;
    private int id;
    
	public Servico(String tipo,int id) {
		super();
		this.tipo = tipo;
		this.id=id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getId() {
		return tipo;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Servico [tipo=" + tipo + ", id=" + id + "]";
	}
	
	
}
