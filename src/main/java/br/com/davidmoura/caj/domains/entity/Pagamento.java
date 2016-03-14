package br.com.davidmoura.caj.domains.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.davidmoura.caj.application.util.DateTestUtil;

public class Pagamento {
	
	private Aluno aluno;
	private Double valorPago;
	private Date dataPagamento;
	
	Pagamento(){
		// Necessario pelo Hibernate
	}
	
	public Pagamento(Aluno aluno, Double valorPago, Date dataPagamento){
		this.aluno = aluno;
		this.valorPago = valorPago;
		this.dataPagamento = dataPagamento;
	}

	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public String getDataPagamentoFormatado() {
		return new SimpleDateFormat("dd-MM-yyyy").format(dataPagamento);
	}

	/**
	 * O pagamento para ser valido precisa estar entre os valores do plano.
	 * @return
	 */
	public boolean valido() {
		if ((valorPago >= aluno.getPlano().getValorParcelaComDesconto())
				&& valorPago <= aluno.getPlano().getValorParcela()) {
			return true;
		}
		return false;
	}

	public boolean noPrazo() {
		Calendar diaCalendar = Calendar.getInstance();
		diaCalendar.setTime(dataPagamento);
		int dia = diaCalendar.get(Calendar.DAY_OF_MONTH);
		if (dia <= aluno.getPlano().getDiaLimitePagamento()) {
			return true;
		}
		return false;
	}

}
