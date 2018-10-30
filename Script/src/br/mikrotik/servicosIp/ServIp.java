/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mikrotik.servicosIp;

/**
 *
 * @author jackson
 */
public class ServIp extends Ip {
    
    /**
     * Construtor
     * @param ip 
     * Ip para manipulação.
     */
    public ServIp (String ip)
    {
        super(ip);
        separateOctets();
    }

    /**
     * M�todo para converter a String do elemento de rede em decimal, dividida em 4 campos.
     * @param elemento String - Elemento de rede.
     */
    public void separateOctets()
    {   
        String campo[];
        campo = getIp().split("\\.");
        //separa a string pelos pontos e atribui a um vetor
        //converte cada posi��o do vetor para int e atribui �s respectivas vari�veis        
        setFirstOctetoDec(Integer.parseInt(campo[0]));
        setSecondOctetoDec(Integer.parseInt(campo[1]));
        setThirdOctetoDec(Integer.parseInt(campo[2]));
        setRoomOctetoDec(Integer.parseInt(campo[3]));
        
        converterParaBinario();
    }
    /**
     * M�todo para converter os campos do elemento de inteiro para bin�rio (String).
     */
    private void converterParaBinario()
    {
        //cada campo � convertido para bin�rio e 0s s�o inseridos � esquerda at� que tenha 8 bits
        setFirstOcteto(Integer.toBinaryString(getFirstOctetoDec()));
        while(getFirstOcteto().length() < 8)
        {
            setFirstOcteto("0" + getFirstOcteto());
        }
        
        setSecondOcteto(Integer.toBinaryString(getSecondOctetoDec()));
        while(getSecondOcteto().length() < 8)
        {    
            setSecondOcteto("0" + getSecondOcteto());
        }
        
        setThirdOcteto(Integer.toBinaryString(getThirdOctetoDec()));
        while(getThirdOcteto().length() < 8)
        {
            setThirdOcteto("0" + getThirdOcteto());
        }
        
        setRoomOcteto(Integer.toBinaryString(getRoomOctetoDec()));
        while(getRoomOcteto().length() < 8)
        {
            setRoomOcteto("0" + getRoomOcteto());
        }
        
    }
}
