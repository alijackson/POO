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
public class maskPrivada{
    
    private ServIp publico;
    private ServIp maskPublico;
    private ServIp privado;
    private ServIp privadoMask;
    
    private int maskPublic = 0;
    private int maskPrivada = 0;
    
    private Double quathostPublic;
    private Double quathostPrivado;
    
    public maskPrivada(String ip, String maskIp,
            String pool, String maskPool)
    {
        publico = new ServIp(ip);
        maskPublico = new ServIp(maskIp);
        
        privado = new ServIp(pool);
        privadoMask = new ServIp(maskPool);
    }
    public void sharePool()
    {
        if(maskPublico.getFirstOctetoDec() < 255)
            maskPublic(maskPublico.getFirstOcteto());
        
        if(maskPublico.getSecondOctetoDec() < 255)
            maskPublic(maskPublico.getSecondOcteto());
        
        if(maskPublico.getThirdOctetoDec() < 255)
            maskPublic(maskPublico.getThirdOcteto());
        
        if(maskPublico.getRoomOctetoDec() < 255)
            maskPublic(maskPublico.getRoomOcteto());
        
        setQuathostPublic(Math.pow(2, getExponecial()));
        
        System.out.println("Segue quantidade de host publico "+getQuathostPublic());
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
        setExponecial(cont+getExponecial());
    }

    public Double getQuathostPublic() {
        return quathostPublic;
    }

    public void setQuathostPublic(Double quathostPublic) {
        this.quathostPublic = quathostPublic;
    }

    public Double getQuathostPrivado() {
        return quathostPrivado;
    }

    public void setQuathostPrivado(Double quathostPrivado) {
        this.quathostPrivado = quathostPrivado;
    }
    
    public int getExponecial() {
        return maskPublic;
    }

    public void setExponecial(int exponecial) {
        this.maskPublic = exponecial;
    }
    
}
