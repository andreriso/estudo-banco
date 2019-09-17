package estudo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import estudo.Movimentacao.TipoMovimentacao;

public abstract class Conta implements VisitableElement {
	private int id;
	private List<Movimentacao> movimentacoes;
	private Cliente cliente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSaldo() {
		double saldo = 0;
		if (movimentacoes != null) {
			for (Movimentacao m : movimentacoes) {
				if (m.getTipoMovimentacao().equals(TipoMovimentacao.CREDITO)) {
					saldo += m.getValor();
				} else {
					saldo -= m.getValor();
				}
			}
		}
		return saldo;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Movimentacao creditar(double valor) {
		return this.gerarMovimento(valor, TipoMovimentacao.CREDITO);
	}

	public Movimentacao debitar(double valor) {
		return this.gerarMovimento(valor, TipoMovimentacao.DEBITO);
	}

	private Movimentacao gerarMovimento(double valor, TipoMovimentacao tipoMovimentacao) {
		Movimentacao m = new Movimentacao();
		m.setConta(this);
		m.setTipoMovimentacao(tipoMovimentacao);
		m.setValor(valor);
		if (this.getMovimentacoes() == null) {
			this.setMovimentacoes(new ArrayList<Movimentacao>());
		}
		this.getMovimentacoes().add(m);
		return m;
	}
	
	public void gerarExtrato() {
		System.out.println("----------------EXTRATO--------------");
		System.out.println("Cliente: " + cliente.getNome() + " " + cliente.getSobrenome());
		System.out.println("Conta: " + id);
		System.out.println("Movimentações:");
		if (movimentacoes != null) {
			Stream<Movimentacao> streamMov = movimentacoes.stream();
			streamMov.forEach(m -> System.out.println(m.toString()));
		}
		System.out.println("SALDO: " + getSaldo());
	}
	
	@Override
	public void accept(ContaVisitor visitor) {
		visitor.visit(this);
	}	
}
