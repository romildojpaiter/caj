package br.com.davidmoura.caj.domains.pagamento;

import java.util.Date;

import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;

import junit.framework.TestCase;
import br.com.davidmoura.caj.application.util.DateTestUtil;
import br.com.davidmoura.caj.domains.entity.Aluno;
import br.com.davidmoura.caj.domains.entity.Pagamento;
import br.com.davidmoura.caj.domains.entity.Plano;


public class PagamentoTest extends TestCase {
	
	private static final String NOME_ALUNO = "Romildo Jozué Paiter";
	/*
	 * Levantamento de um cenário
	 * 
	 * O Aluno deverá ter informações dos responsáveis, informações de importantes de contato, 
	 * plano.
	 * 
	 * Criar um pagamento
	 * 
	 * O valor do pagamento deve estar associado ao Plano do Aluno
	 * 
	 * Validar informações de um pagamento
	 * 
	 * Ao receber um pagamento verificar se já excede a data limite com desconto. 
	 *  Se exceder receber somente o valor integral do plano.
	 *   
	 * Receber um pagamento dentro limite estabelicido pelo plano
	 * 
	 * Verificar se já encerrou o plano contrado.
	 * 
	 * 
	 * Pagamentos com vencimento nas datas de Sabado e Domingo deverão ser acrescidos de um dia para a data limite de 
	 *  pagamento
 	 *     
	 */
	
	private Aluno aluno;
	
	protected void setUp() throws Exception {
		aluno = new Aluno.Builder()
				.addNome(NOME_ALUNO)
				.build();
	}
	
	public void testConstrution() throws Exception {
		
		Date dataPagamento = DateTestUtil.toDate("09-03-2016");
		Pagamento pagamento = new Pagamento(aluno, new Double("220"), dataPagamento);
		
		assertEquals(NOME_ALUNO, pagamento.getAluno().getNome());
		assertEquals(new Double("220"), pagamento.getValorPago());
		assertEquals("09-03-2016", pagamento.getDataPagamentoFormatado());
	}
	
	public void testPagamentoComValorValido() throws Exception {

		Date dataPagamento = DateTestUtil.toDate("09-03-2016");
		Plano plano = new Plano.Builder()
						.addNome("Mensal Judô")
						.addValorParcela(new Double("220"))
						.addValorParcelaComDesconto(new Double("185"))
						.addDiaLimiteComDesconto(10)
						.build();
		aluno.setPlano(plano);
		Pagamento pagamento = new Pagamento(aluno, new Double("220"), dataPagamento);
		
		assertEquals(true, pagamento.valido());
		assertEquals(true, pagamento.noPrazo());
	}
	
	@Test(expected = IndexOutOfBoundsException.class) 
	public void testPagamentoExcedeLimitePrazoPagamento() {
		
	}
	
	public void testPagamentoComDataNoSabado(){
		
	}
	
	
	
	

}
