package hotel;

public class Novo_Hospede {
	private String nome;
	private String endereco;
	private String CPF;
	private String RG;
	private int idade;
	private String sexoM;
	private String sexoF;
	private int qtdQuartos;
	private boolean checkIn;
	private boolean checkOut;

	public Novo_Hospede(String nome, String endereco, String CPF, String RG, int idade, String sexoM,String sexoF, int qtdQuartos,
			boolean checkIn, boolean checkOut) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.CPF = CPF;
		this.RG = RG;
		this.idade = idade;
		this.sexoM = sexoM;
		this.sexoF = sexoF;
		this.qtdQuartos = qtdQuartos;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Novo_Hospede() {
		// TODO Auto-generated constructor stub
	}

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

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String RG) {
		this.RG = RG;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexoM() {
		return sexoM;
	}

	public void setSexoM(String sexoM) {
		this.sexoM = sexoM;
	}
	public String getSexoF() {
		return sexoF;
	}

	public void setSexoF(String sexoF) {
		this.sexoF = sexoF;
	}

	public int getQtdQuartos() {
		return qtdQuartos;
	}

	public void setQtdQuartos(int qtdQuartos) {
		this.qtdQuartos = qtdQuartos;
	}

	public boolean isCheckIn() {
		return checkIn;
	}

	public void setCheckIn(boolean checkIn) {
		this.checkIn = checkIn;
	}

	public boolean isCheckOut() {
		return checkOut;
	}

	public void setCheckOut(boolean checkOut) {
		this.checkOut = checkOut;
	}

}
