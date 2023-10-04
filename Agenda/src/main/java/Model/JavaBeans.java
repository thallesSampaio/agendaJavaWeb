package Model;

public class JavaBeans {
	private int contato_id;
	private String nome, telefone, email;

	public JavaBeans() {
		super();

	}

	public JavaBeans(int contato_id, String nome, String telefone, String email) {
		super();
		this.contato_id = contato_id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public int getContato_id() {
		return contato_id;
	}

	public void setContato_id(int contato_id) {
		this.contato_id = contato_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
