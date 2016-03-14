package br.com.davidmoura.caj.domains.entity;

import br.com.davidmoura.caj.domains.entity.Aluno.Builder;

public class Plano {
	
	private String nome;
	private Double valorParcela;
	private Double valorParcelaComDesconto;	
	private Integer diaLimitePagamento;
	
	
	public static final class Builder {
		
		Plano plano = new Plano();


		public Builder addNome(String nome) {
			plano.nome = nome;
			return this;
		}
		
		public Builder addValorParcela(Double valorParcela){
			plano.valorParcela = valorParcela;
			return this;
		}

		public Builder addValorParcelaComDesconto(Double valorParcelaComDesconto) {
			plano.valorParcelaComDesconto = valorParcelaComDesconto;
			return this;
		}

		public Builder addDiaLimiteComDesconto(int diaLimitePagamento) {
			plano.diaLimitePagamento = diaLimitePagamento;
			return this;
 	 	}
		
		public Plano build() {
			return plano;
		}
	}


	public Double getValorParcela() {
		return valorParcela;
	}


	public Double getValorParcelaComDesconto() {
		return valorParcelaComDesconto;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getDiaLimitePagamento() {
		return diaLimitePagamento;
	}


	public void setDiaLimitePagamento(Integer diaLimitePagamento) {
		this.diaLimitePagamento = diaLimitePagamento;
	}


	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}


	public void setValorParcelaComDesconto(Double valorParcelaComDesconto) {
		this.valorParcelaComDesconto = valorParcelaComDesconto;
	}
	
}
