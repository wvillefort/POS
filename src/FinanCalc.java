
public class FinanCalc {

	private double precoVeiculo = 0; // valor do veiculo
	private double taxaJuros = 0; // taxa de juros
	private int numParcelas = 0; // numero de parcelas
	private double entrada = 0; // valor da entrada
	private double salario = 0; // valor do salario
	private double percMaxComprometimento = 0; // percentual maximo da parcela

	/**
	 * Pega o valor do veiculo
	 * 
	 * @return double
	 */
	public double getPrecoVeiculo() {
		return precoVeiculo;
	}

	/**
	 * Define o valor do veiculo
	 * 
	 * @param precoVeiculo
	 */
	public void setPrecoVeiculo(double pV) {
		this.precoVeiculo = pV;
	}

	/**
	 * Pega o valor da taxa de juros
	 * 
	 * @return double
	 */
	public double getTaxaJuros() {
		return taxaJuros;
	}

	/**
	 * Define o valor da taxa de juros
	 * 
	 * @param i
	 */
	public void setTaxaJuros(double i) {
		this.taxaJuros = i / 100.00;
	}

	/**
	 * Pega o numero de parcelas
	 * 
	 * @return int
	 */
	public int getNumParcela() {
		return numParcelas;
	}

	/**
	 * Define o numero de prestações
	 * 
	 * @param n
	 */
	public void setNumParcela(int n) {
		this.numParcelas = n;
	}

	/**
	 * Retorna o valor da entrada
	 * 
	 * @return
	 */
	public double getEntrada() {
		return entrada;
	}

	/**
	 * Define o valor da entrada
	 * 
	 * @param entrada
	 */
	public void setEntrada(double entrada) {
		this.entrada = entrada;
	}

	/**
	 * Pega o valor do salario
	 * 
	 * @return
	 */
	public double getSalario() {
		return salario;
	}

	/**
	 * Define o valor do salario
	 * 
	 * @param salario
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}

	/**
	 * Retorna o percentual maximo de comprometimento
	 * 
	 * @return
	 */
	public double getPercMaxComprometimento() {
		return percMaxComprometimento;
	}

	/**
	 * Define o percentual maximo de comprometimento do salario
	 * 
	 * @param percMaxComprometimento
	 */
	public void setPercMaxComprometimento(double percMax) {
		this.percMaxComprometimento = percMax / 100;
	}

	/**
	 * Calcula o valor das prestações
	 * 
	 * @return double
	 */
	public double calcularPrestacao() {

		double pmt = 0; // valor da prestacao

		pmt = (this.precoVeiculo - this.entrada) * this.taxaJuros;
		pmt = pmt / 1 - (1 / Math.pow((1 + this.taxaJuros), this.numParcelas));

		return pmt;
	}

	/**
	 * Calcula o percentual do salario comprometido
	 * 
	 * @return
	 */
	public double calculaPercentualSobreSalario() {
		double comprometido = ((this.calcularPrestacao() * 100) / this.salario);
		return comprometido;
	}

	/**
	 * Calcula o valor maximo da prestacao permitido
	 */
	public double valorMaximoPrestacao() {
		return this.salario * this.percMaxComprometimento;
	}
}
