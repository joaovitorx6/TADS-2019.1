package campeonato;

public class Jogador {
	private int cod;
	private String nome;
	private int idade;
	private int time_cod;
	
	public Jogador(int cod, String nome, int idade, int time_cod) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.idade = idade;
		this.time_cod = time_cod;
	}
	
	public int getCod() {
		return cod;
	}
	
	public void setCod(int cod) {
		this.cod = cod;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getTime_cod() {
		return time_cod;
	}
	
	public void setTime_cod(int time_cod) {
		this.time_cod = time_cod;
	}

}
