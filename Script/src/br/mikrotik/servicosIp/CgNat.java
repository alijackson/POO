/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mikrotik.servicosIp;

import java.util.HashSet;

/**
 *
 * @author jackson
 */
public class CgNat{
    
    private ServIp publico;
    private ServIp maskPublico;
    private ServIp privado;
    private ServIp privadoMask;
    
    private int maskPublic = 0;
    private int maskPrivada = 0;
    
    private Double quathostPublic;
    private Double quathostPrivado;
    
    private float divPool;
    
    public CgNat(String ip, String maskIp,
            String pool, String maskPool)
    {
        publico = new ServIp(ip);
        maskPublico = new ServIp(maskIp);
        
        privado = new ServIp(pool);
        privadoMask = new ServIp(maskPool);
    }
    public void sharePool()
    {
        quantPrivado();
        quantPublico();
        
        setQuathostPublic(Math.pow(2, getMaskPublic()));
        setQuathostPrivado(Math.pow(2, getMaskPrivada()));
        
        divPool();
        
        designarToNat();
    }
    
    private void divPool()
    {
        setDivPool((float)(getQuathostPrivado() / getQuathostPublic()));
    }
    private void quantPrivado()
    {        
        if(privadoMask.getFirstOctetoDec() < 255)
            maskPrivada(privadoMask.getFirstOcteto());
        
        if(privadoMask.getSecondOctetoDec() < 255)
            maskPrivada(privadoMask.getSecondOcteto());
        
        if(privadoMask.getThirdOctetoDec() < 255)
            maskPrivada(privadoMask.getThirdOcteto());
        
        if(privadoMask.getRoomOctetoDec() < 255)
            maskPrivada(privadoMask.getRoomOcteto());
        
    }
    
    public void maskPrivada(String elemento)
    {
        int cont = 0;
        int tamanho = elemento.length();
        for(int i = 0; i < tamanho; i++)
        {
            if(elemento.charAt(i) == '0')
            {
                cont++;
            }
        }
        setMaskPrivada(cont+getMaskPublic());
    }

    private void quantPublico()
    {        
        if(maskPublico.getFirstOctetoDec() < 255)
            maskPublic(maskPublico.getFirstOcteto());
        
        if(maskPublico.getSecondOctetoDec() < 255)
            maskPublic(maskPublico.getSecondOcteto());
        
        if(maskPublico.getThirdOctetoDec() < 255)
            maskPublic(maskPublico.getThirdOcteto());
        
        if(maskPublico.getRoomOctetoDec() < 255)
            maskPublic(maskPublico.getRoomOcteto());
        
    }
    public void maskPublic(String elemento)
    {
        int cont = 0;
        int tamanho = elemento.length();
        for(int i = 0; i < tamanho; i++)
        {
            if(elemento.charAt(i) == '0')
            {
                cont++;
            }
        }
        setMaskPublic(cont+getMaskPublic());
    }
    
    public void designarToNat()
    {
        StringBuilder idRede = new StringBuilder();
        
        if(getQuathostPublic() < 255)
        {
            for (int i = 0; i < 7 - getMaskPublic() ; i++) 
            {
                idRede.append(publico.getRoomOcteto().charAt(i));
            }
            for (int i = 0; i <= getMaskPublic(); i++) 
            {
                idRede.append("0");
            }
        }
        String octeto = idRede.toString();
        System.out.println("Segue id de rede em binario "+octeto+
                "\nSegue IP convertido " +Integer.parseInt(octeto, 2));
    }
    public float getDivPool() {
        return divPool;
    }

    public void setDivPool(float divPool) {
        this.divPool = divPool;
    }

    public Double getQuathostPrivado() {
        return quathostPrivado;
    }

    public void setQuathostPrivado(Double quathostPrivado) {
        this.quathostPrivado = quathostPrivado;
    }

    public Double getQuathostPublic() {
        return quathostPublic;
    }

    public void setQuathostPublic(Double quathostPublic) {
        this.quathostPublic = quathostPublic;
    }

    public int getMaskPrivada() {
        return maskPrivada;
    }

    public void setMaskPrivada(int maskPrivada) {
        this.maskPrivada = maskPrivada;
    }
    
    public int getMaskPublic() {
        return maskPublic;
    }

    public void setMaskPublic(int exponecial) {
        this.maskPublic = exponecial;
    }
    
}
