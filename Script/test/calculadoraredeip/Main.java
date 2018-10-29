package calculadoraredeip;
import br.mikrotik.servicosIp.CalculadoraDeRede;
import java.util.Scanner;


/**
 * Classe principal para executar as opera��es.
 * @author Elma Santos e Fabiana Marinheiro
 *
 */
public class Main {
    
    private static Scanner ler;

    public static void main(String[] args) 
    {
        int opcao = 0;
        Scanner ler = new Scanner(System.in);
        CalculadoraDeRede calculadora = new CalculadoraDeRede();

        System.out.println("============= FUNCIONALIDADES =============\n"
                        + "Digite 1 para identifica��o de endere�o padr�o.\n"
                        + "Digite 2 para identifica��o de endere�o com m�scara.\n"
                        + "Digte 3 para c�lculo de bloco.\n"
                        + "Digite 4 para c�lculo de sub-redes.");
        opcao = ler.nextInt();

        String ip;
        System.out.println("Insira um IP: ");
        ip = ler.next();	
        EnderecoIP enderecoIP = new EnderecoIP(ip);
        enderecoIP.converterParaDecimal(ip); //converte para decimal
        enderecoIP.converterParaBinario(); //converte para bin�rio

        switch(opcao)
        {
            case 1:
                System.out.println(
                        "IDENTIFICA��O DE ENDERE�O PADR�O\n"
                                + "================================");

                if(enderecoIP.validarIP())
                {
                        calculadora.informarClasse(enderecoIP.getPrimeiroCampoDecimal(), enderecoIP.getSegundoCampoDecimal());
                        calculadora.calcularMascaraPadrao();
                        calculadora.calcularNetID(enderecoIP.getPrimeiroCampoDecimal(), enderecoIP.getSegundoCampoDecimal(), enderecoIP.getTerceiroCampoDecimal());
                        calculadora.calcularHostID(enderecoIP.getSegundoCampoDecimal(), enderecoIP.getTerceiroCampoDecimal(), enderecoIP.getQuartoCampoDecimal());
                }
                else{System.out.println("IP inválido!");}
                break;
            case 2:
                System.out.println(
                        "IDENTIFICA��O DE ENDERE�O COM M�SCARA\n"
                            + "=====================================");

                if(enderecoIP.validarIP())
                {
                        calculadora.informarClasse(enderecoIP.getPrimeiroCampoDecimal(), 
                                enderecoIP.getSegundoCampoDecimal());

                        String mascara;
                        System.out.println("Insira uma m�scara:");
                        mascara = ler.next();

                        Mascara mascaraDeRede = new Mascara(mascara);
                        mascaraDeRede.converterParaDecimal(mascara);
                        mascaraDeRede.converterParaBinario();

                        if(mascaraDeRede.verificarMascara(calculadora.getClasse()) == true)
                        {
                                break;
                        }					
                        //calculadora.calcularEndereco(mascaraDeRede.getPrimeiroOcteto(), mascaraDeRede.getSegundoOcteto(),mascaraDeRede.getTerceiroOcteto(), mascaraDeRede.getQuartoOcteto(), enderecoIP.getPrimeiroOcteto(), enderecoIP.getSegundoOcteto(), enderecoIP.getTerceiroOcteto(), enderecoIP.getQuartoOcteto());
                        calculadora.enderecoDeRedeNetidEHostid(mascaraDeRede.getPrimeiroOcteto(), mascaraDeRede.getSegundoOcteto(),mascaraDeRede.getTerceiroOcteto(), mascaraDeRede.getQuartoOcteto(), enderecoIP.getPrimeiroOcteto(), enderecoIP.getSegundoOcteto(), enderecoIP.getTerceiroOcteto(), enderecoIP.getQuartoOcteto());
                }
                else{System.out.println("IP inv�lido!");}
                break;
            case 3:
                System.out.println("CÁLCULO DE BLOCO\n================================");

                if(enderecoIP.validarIP())
                {
                    calculadora.informarClasse(enderecoIP.getPrimeiroCampoDecimal(), enderecoIP.getSegundoCampoDecimal());

                    String mascara;
                    System.out.println("Insira uma máscara:");
                    mascara = ler.next();

                    Mascara mascaraDeRede = new Mascara(mascara);
                    mascaraDeRede.converterParaDecimal(mascara);
                    mascaraDeRede.converterParaBinario();

                    if(mascaraDeRede.verificarMascara(calculadora.getClasse()) == true)
                    {
                            break;
                    }				
                    //calculadora.calcularEndereco(mascaraDeRede.getPrimeiroOcteto(), mascaraDeRede.getSegundoOcteto(),mascaraDeRede.getTerceiroOcteto(), mascaraDeRede.getQuartoOcteto(), enderecoIP.getPrimeiroOcteto(), enderecoIP.getSegundoOcteto(), enderecoIP.getTerceiroOcteto(), enderecoIP.getQuartoOcteto());
                    calculadora.enderecoDeRedeNetidEHostid(
                            mascaraDeRede.getPrimeiroOcteto(), mascaraDeRede.getSegundoOcteto(),
                            mascaraDeRede.getTerceiroOcteto(), mascaraDeRede.getQuartoOcteto(), 
                            enderecoIP.getPrimeiroOcteto(), enderecoIP.getSegundoOcteto(), 
                            enderecoIP.getTerceiroOcteto(), enderecoIP.getQuartoOcteto());

                    calculadora.imprimirBroadcast(
                            mascaraDeRede.getPrimeiroOcteto(), mascaraDeRede.getSegundoOcteto(),
                            mascaraDeRede.getTerceiroOcteto(), mascaraDeRede.getQuartoOcteto(), 
                            enderecoIP.getPrimeiroOcteto(), enderecoIP.getSegundoOcteto(), 
                            enderecoIP.getTerceiroOcteto(), enderecoIP.getQuartoOcteto());

                    calculadora.quantidadeSubRedes(mascaraDeRede.getPrimeiroOcteto(), 
                            mascaraDeRede.getSegundoOcteto(),mascaraDeRede.getTerceiroOcteto(), 
                            mascaraDeRede.getQuartoOcteto());
                }
                else{System.out.println("IP inválido!");}
                break;
            case 4:
                System.out.println(
                        "CÁLCULO DE SUB-REDES\n"
                                + "=====================================");

                if(enderecoIP.validarIP())
                {
                    calculadora.informarClasse(enderecoIP.getPrimeiroCampoDecimal(), enderecoIP.getSegundoCampoDecimal());
                    String mascara;
                    System.out.println("Insira uma máscara:");
                    mascara = ler.next();

                    Mascara mascaraDeRede = new Mascara(mascara);
                    mascaraDeRede.converterParaDecimal(mascara);
                    mascaraDeRede.converterParaBinario();

                    if(mascaraDeRede.verificarMascara(calculadora.getClasse()) == true)
                    {
                            break;
                    }						

                    calculadora.quantidadeSubRedes(mascaraDeRede.getPrimeiroOcteto(), 
                            mascaraDeRede.getSegundoOcteto(), mascaraDeRede.getTerceiroOcteto(), 
                            mascaraDeRede.getQuartoOcteto());

                    calculadora.subRedesDaSubRede(mascaraDeRede.getPrimeiroOcteto(), 
                            mascaraDeRede.getSegundoOcteto(),mascaraDeRede.getTerceiroOcteto(), 
                            mascaraDeRede.getQuartoOcteto());

                    calculadora.calcularEnderecoComMP(enderecoIP.getPrimeiroOcteto(), 
                            enderecoIP.getSegundoOcteto(), enderecoIP.getTerceiroOcteto(), 
                            enderecoIP.getQuartoOcteto());

                    calculadora.listarSubRede();

                }
                else
                {
                    System.out.println("IP inválido!");
                }

                break;
                
            default:
                System.out.println("Opção inválida!");
        }
    }

}
