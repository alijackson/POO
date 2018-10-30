package br.mikrotik.servicosIp;


/**
 * Classe da m�scara de rede.
 * @author Elma Santos e Fabiana Marinheiro
 *
 */

public class Mascara extends ElementoDeRede {
	
	private String octetosConcatenados;
	
	/**
	 * M�todo construtor.
	 * @param elemento String - m�scara de rede.
	 */
	public Mascara(String elemento) {
		super(elemento);
	}
	
	/**
	 * M�todo para concatenar octetos da m�scara em uma �nica string.
	 * @return String - m�scara concatenada.
	 */
	public void concatenarOctetos(){
		octetosConcatenados = primeiroOcteto + segundoOcteto + terceiroOcteto + quartoOcteto;
	}
	
	/**
	 * M�todo para validar m�scara.
	 * @param zero boolean - indica os 0s da m�scara.
	 * @param invalida boolean - indica se m�scara � inv�lida.
	 * @param unsNaMascara String - quantidade de 1s no in�cio da m�scara.
	 */
	public void validarMascara(boolean zero, boolean invalida, String unsNaMascara){
		int tamanho = octetosConcatenados.length();
		for(int i = 0; i < tamanho; i++){
                    if(octetosConcatenados.charAt(i) == '0')
                    {
                            zero = true;
                    }
                    else{
                        if(zero)
                        {
                                System.out.println("M�scara inv�lida");
                                invalida = true;
                                break;
                        }
                    }
		}
		if(octetosConcatenados.startsWith(unsNaMascara) && invalida == false){
                    System.out.println("M�scara v�lida");
		}
		else{
                    System.out.println("M�scara inv�lida");
                    invalida = true;
                }
	}
	
	
	/**
	 * M�todo para verificar se m�scara � v�lida.
	 * @param classe String - classe da m�scara.
	 * @return boolean - validez da m�scara.
	 */
	public boolean verificarMascara(String classe){
		
		concatenarOctetos();
		boolean zero = false; //boolean indicando exist�ncia de 0s na m�scara
		boolean invalida = false; //boolean indicando m�scara inv�lida
//			switch (classe){
//			//valida m�scara de acordo com cada classe
//				case "CLASSE A":
//					validarMascara(zero, invalida, "11111111");					
//					break;
//					
//				case "CLASSE B":
//					validarMascara(zero, invalida, "1111111111111111");
//					break;
//				case "CLASSE C":
//					validarMascara(zero, invalida, "111111111111111111111111");
//					break;
//				case "CLASSE D":
//					System.out.println("M�scara Classe D");
//					break;
//				case "CLASSE E":
//					System.out.println("M�scara Clase E");
//					break;
//				default:
//					System.out.println("Classe inv�lida.");
//			}
			return invalida;
	}
}
