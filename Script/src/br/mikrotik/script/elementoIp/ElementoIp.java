/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mikrotik.script.elementoIp;

/**
 *
 * @author jackson
 */
public class ElementoIp {
    private String elemento;
	protected String primeiroOcteto, segundoOcteto, terceiroOcteto, quartoOcteto; //campos em bin�rio
	protected int primeiroCampoDecimal, segundoCampoDecimal, terceiroCampoDecimal, quartoCampoDecimal; //campos em decimal
	
	/**
	 * M�todo construtor.
	 * @param elemento String - Elemento de rede.
	 */
	public ElementoIp(String elemento){
		this.elemento = elemento;
	}
		
	/**
	 * M�todo para converter a String do elemento de rede em decimal, dividida em 4 campos.
	 * @param elemento String - Elemento de rede.
	 */
	public void converterParaDecimal(String elemento){
		
		String campo[] = new String[4];
		campo = elemento.split("\\.");//separa a string pelos pontos e atribui a um vetor
		
		//converte cada posi��o do vetor para int e atribui �s respectivas vari�veis
		primeiroCampoDecimal = Integer.parseInt(campo[0]);
		segundoCampoDecimal = Integer.parseInt(campo[1]);
		terceiroCampoDecimal = Integer.parseInt(campo[2]);
		quartoCampoDecimal = Integer.parseInt(campo[3]);
	}	
	
	
	/**
	 * M�todo para converter os campos do elemento de inteiro para bin�rio (String).
	 */
	public void converterParaBinario(){
		//cada campo � convertido para bin�rio e 0s s�o inseridos � esquerda at� que tenha 8 bits
		primeiroOcteto = Integer.toBinaryString(primeiroCampoDecimal);
		while(primeiroOcteto.length() < 8){
			primeiroOcteto = "0" + primeiroOcteto;
		}
		segundoOcteto = Integer.toBinaryString(segundoCampoDecimal);
		while(segundoOcteto.length() < 8){
			segundoOcteto = "0" + segundoOcteto;
		}
		terceiroOcteto = Integer.toBinaryString(terceiroCampoDecimal);
		while(terceiroOcteto.length() < 8){
			terceiroOcteto = "0" + terceiroOcteto;
		}
		quartoOcteto = Integer.toBinaryString(quartoCampoDecimal);
		while(quartoOcteto.length() < 8){
			quartoOcteto = "0" + quartoOcteto;
		}
	}
	
	/**
	 * M�todo para retornar primeiro octeto do elemento.
	 * @return String - primeiro octeto.
	 */
	public String getPrimeiroOcteto(){
		return primeiroOcteto;
	}
	
	/**
	 * M�todo para retornar segundo octeto do elemento.
	 * @return String - segundo octeto.
	 */
	public String getSegundoOcteto(){
		return segundoOcteto;
	}
	
	/**
	 * M�todo para retornar terceiro octeto do elemento..
	 * @return String - terceiro octeto.
	 */
	public String getTerceiroOcteto(){
		return terceiroOcteto;
	}

	/**
	 * M�todo para retornar quarto octeto do elemento..
	 * @return String - quarto octeto.
	 */
	public String getQuartoOcteto(){
		return quartoOcteto;
	}
}
