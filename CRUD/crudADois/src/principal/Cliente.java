package principal;

public class Cliente {
	private int id;
	private String nome; 
	private int idade;
	private String endereco;
	private String rg;
	private String telefone;
	
	
	public Cliente(int id, String nome, int idade, String endereco, String rg, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.rg = rg;
		this.telefone = telefone;
		
	}
	public Cliente() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
}
