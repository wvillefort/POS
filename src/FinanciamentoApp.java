import java.util.Scanner;

public class FinanciamentoApp {

	public static void main(String[] args) {
		
		// Metodo main criado para realizar um "Live Test" na classe "FinanCalc"
			
		System.out.println("*=======================================*");
		System.out.println("|                                       |");
		System.out.println("|      CALCULO DE PRESTAÇÃO - V1.0      |");
		System.out.println("|                                       |");
		System.out.println("*=======================================*");
		System.out.println();
		System.out.println("Entre com os parametros abaixo: ");
		
		
		Scanner inputReader = new Scanner(System.in);
		System.out.print("> Valor do veiculo? ");
		float pV = inputReader.nextFloat(); /* valor financiado */
		System.out.print("> Valor do entrada? ");
		float entrada = inputReader.nextFloat(); /* valor financiado */
		System.out.print("> Valor do salario? ");
		float salario = inputReader.nextFloat(); /* valor financiado */
		System.out.print("> Taxa de juros (%)? ");
		float i = inputReader.nextFloat();  /* taxa juros */
		System.out.print("> Quantidade de parcelas? ");
		int n = inputReader.nextInt();      /* num prestacoes */
		
		FinanCalc pmt = new FinanCalc();
		pmt.setPrecoVeiculo(pV);
		pmt.setTaxaJuros(i);
		pmt.setNumParcela(n);
		pmt.setEntrada(entrada);
		pmt.setSalario(salario);
		pmt.setPercMaxComprometimento(40);
		System.out.print("\nO valor do veículo: R$ ");
		System.out.printf("%.2f",pV);
		System.out.print("\nO valor da prestação é: R$ ");
		System.out.printf("%.2f",pmt.calcularPrestacao());
		System.out.print("\nSalário informado: R$ ");
		System.out.printf("%.2f",salario);
		System.out.print("\nPercentual comprometido:");
		double comprometido = pmt.calculaPercentualSobreSalario();
		System.out.printf("%.2f",comprometido);
		System.out.println("%");
		if(comprometido>40.00f) {
			System.out.print("\nPercentual do salário comprometido é maior que o permitido!");
			System.out.print("\nValor máximo permitido para a parcela: R$ ");
			System.out.printf("%.2f",pmt.valorMaximoPrestacao());
		} else 
		{
			System.out.print("\nFinanciamento autorizado!");
		}
		inputReader.close();
	}
}
