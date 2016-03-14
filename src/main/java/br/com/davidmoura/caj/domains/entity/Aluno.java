package br.com.davidmoura.caj.domains.entity;

public class Aluno {

	private Long id;
	
	private String nome;
	
	
	private Responsavel responsavel;
	private Endereco endereco;
	
	private Plano plano;
	private Modalidade modalidade;
	private Turma turma;

	Aluno() {
		// Needed by Hibernate
	}
	
	public Aluno(String nome) {
		this.nome = nome;
	}


	public String getNome() {
		return this.nome;
	}
	
	
	public static final class Builder {
		
		
		private String nome;


		public Builder addNome(String nome){
			this.nome = nome;
			return this;
		}
		

		public Aluno build() {
			return new Aluno(nome);
		}
		
	}


	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public Plano getPlano() {
		return plano;
	}

}
