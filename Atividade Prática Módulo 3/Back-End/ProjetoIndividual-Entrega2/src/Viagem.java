import java.util.Date;
public class Viagem {
	private int id;
	private int id_Cliente;
	private int id_Destino;
	private Date data_partida;
	private Date data_retorno;
	private float preco;
	private int duracao;

	public int getId() {
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	
	public int getIdCliente() {
		return id_Cliente;
	}
	public void setIdCliente(int _id_Cliente){
		this.id_Cliente = _id_Cliente;
	}
	
	public int getIdDestino() {
		return id_Destino;
	}
	public void setIdDestino(int _id_Destino){
		this.id_Destino = _id_Destino;
	}
	
	public Date getDataPartida() {
		return data_partida;
	}
	public void setDataPartida(Date _data_partida) {
		this.data_partida = _data_partida;
	}
	
	public Date getDataRetorn() {
		return data_retorno;
	}
	public void setDataRetorno(Date _data_retorno) {
		this.data_retorno = _data_retorno;
	}
	
	public float getPreco() {
		return preco;
	}
	public void setPreco(float _preco) {
		this.preco = _preco;
	}
	
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int _duracao) {
		this.duracao = _duracao;
	}
}
