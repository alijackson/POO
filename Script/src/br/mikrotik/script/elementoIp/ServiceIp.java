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
public class ServiceIp extends ElementoIp{
    public ServiceIp(String ip){
        super(ip);
//        converterParaDecimal(ip);
    }
    /**
    * M�todo para verificar se endere�o IP � v�lido.
    * @return true - se for endere�o v�lido ou false se n�o for.
    */
   public boolean validarIP()
   {
        if(primeiroCampoDecimal == 127)
        {
                System.out.println("Endere�o de loopback!");
                return false;
        }
        else if((primeiroCampoDecimal >= 0 && primeiroCampoDecimal <= 255) && 
                (segundoCampoDecimal >= 0 &&  segundoCampoDecimal <=255) && 
                (terceiroCampoDecimal >= 0 && terceiroCampoDecimal <= 255) && 
                (quartoCampoDecimal >= 0 && quartoCampoDecimal <=255))
        {
                return true;
        }
        else{
                return false;
        }		
   }
}
