package br.mikrotik.servicosIp;


/**
 * Classe do endere�o IP.
 * @author Elma Santos e Fabiana Marinheiro
 *
 */
public class EnderecoIP extends ElementoDeRede {

	/**
	 * M�todo construtor.
	 * @param elemento String - Endere�o IP.
	 */
	public EnderecoIP(String elemento) {
		super(elemento);
	}
	
	/**
	 * M�todo para verificar se endere�o IP � v�lido.
	 * @return true - se for endere�o v�lido ou false se n�o for.
	 */
	public boolean validarIP(){
		if(primeiroCampoDecimal == 127){
			System.out.println("Endere�o de loopback!");
			return false;
		}
		else if((primeiroCampoDecimal >= 0 && primeiroCampoDecimal <= 255) && (segundoCampoDecimal >= 0 && segundoCampoDecimal <=255) && (terceiroCampoDecimal >= 0 && terceiroCampoDecimal <= 255) && (quartoCampoDecimal >= 0 && quartoCampoDecimal <=255)){
			return true;
		}
		else{
			return false;
		}		
	}
	
	/**
	 * M�todo para retornar primeiro campo decimal do endere�o IP.
	 * @return int - primeiro campo do endere�o IP.
	 */
	public int getPrimeiroCampoDecimal(){
		return primeiroCampoDecimal;
	}
	
	/**
	 * M�todo para retornar segundo campo decimal do endere�o IP.
	 * @return int - segundo campo do endere�o IP.
	 */
	public int getSegundoCampoDecimal(){
		return segundoCampoDecimal;
	}
	
	/**
	 * M�todo para retornar terceiro campo decimal do endere�o IP.
	 * @return int - terceiro campo do endere�o IP.
	 */
	public int getTerceiroCampoDecimal(){
		return terceiroCampoDecimal;
	}

	/**
	 * M�todo para retornar quarto campo decimal do endere�o IP.
	 * @return int - quarto campo do endere�o IP.
	 */
	public int getQuartoCampoDecimal(){
		return quartoCampoDecimal;
	}
	
}
