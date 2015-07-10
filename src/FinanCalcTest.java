import static org.junit.Assert.*;

import org.junit.Test;

public class FinanCalcTest {

	@Test
	public void testCalcularPrestacao() {
		FinanCalc pmt = new FinanCalc();
		pmt.setPrecoVeiculo(10000.00f);
		pmt.setTaxaJuros(2.00f);
		pmt.setNumParcela(36);
		pmt.setPercMaxComprometimento(40);
		double result = pmt.calcularPrestacao();
		double esperado = 199.51f;

		assertEquals(esperado, result, 0.01);
	}

	@Test
	public void testComprometidoAbaixo() {
		FinanCalc pmt = new FinanCalc();
		pmt.setPrecoVeiculo(35000.00f);
		pmt.setTaxaJuros(2.00f);
		pmt.setNumParcela(36);
		pmt.setSalario(3500);
		pmt.setEntrada(5000);
		pmt.setPercMaxComprometimento(40);
		boolean esperado = true;
		boolean result = false;
		double calc = pmt.calculaPercentualSobreSalario();
		if(calc<=40.00f) {
			result = true;
		} 
		//System.out.println(calc);
		assertEquals(esperado, result);
	}

	@Test 
	public void testComprometidoAcima() {
		FinanCalc pmt = new FinanCalc();
		pmt.setPrecoVeiculo(60000.00f);
		pmt.setTaxaJuros(2.00f);
		pmt.setNumParcela(36);
		pmt.setEntrada(2000);
		pmt.setSalario(2500);
		pmt.setPercMaxComprometimento(40);
		boolean esperado = true;
		boolean result = false;
		double calc = pmt.calculaPercentualSobreSalario();
		if(calc>=40.00f) {
			result = true;
		} 
		//System.out.println(calc);
		assertEquals(esperado, result);
	}

	@Test
	public void testComprometidoIgual() {
		FinanCalc pmt = new FinanCalc();
		pmt.setPrecoVeiculo(50000.00f);
		pmt.setTaxaJuros(2.00f);
		pmt.setNumParcela(36);
		pmt.setSalario(2499.00f);
		pmt.setEntrada(0);
		double result = pmt.calculaPercentualSobreSalario();
		double esperado = 40.00f;

		assertEquals(esperado, result, 0.01);
	}

}
