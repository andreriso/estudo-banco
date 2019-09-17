package estudo;

public class Movimentacao {
	
	enum TipoMovimentacao {
		CREDITO, DEBITO
	}

	private TipoMovimentacao tipoMovimentacao;
	private double valor;
	private Conta conta;
	
	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}
	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public String toString() {
		return "Tipo Movimentacao :" + tipoMovimentacao.toString() + " Valor :" + String.valueOf(valor);
	}
}
