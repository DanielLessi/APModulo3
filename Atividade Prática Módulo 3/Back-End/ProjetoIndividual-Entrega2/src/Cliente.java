import java.util.Date;
public class Cliente {
	private int id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private Date dataNasc;
	private String telefone;
	private String email;
	private String endereco;
	private int numero;
	private String cep;

	public int getId() {
		return id;
	}
	public void setId(int _id){
		this.id = _id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String _nome) {
		this.nome = _nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String _sobrenome) {
		this.sobrenome = _sobrenome;
	}
	
	public String getCPF() {
		return cpf;
	}
	public void setCPF(String _cpf) {
		this.cpf = _cpf;
	}
	
	public Date getDataNascimento() {
		return dataNasc;
	}
	public void setDataNascimento(Date _dataNasc) {
		this.dataNasc = _dataNasc;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String _telefone) {
		this.telefone = _telefone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String _email) {
		this.email = _email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String _endereco) {
		this.endereco = _endereco;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int _numero) {
		this.numero = _numero;
	}
	
	public String getCEP() {
		return cep;
	}
	public void setCEP(String _cep) {
		this.cep = _cep;
	}
}
