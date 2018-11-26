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
public class CgNat{
    
    private ServIp publico;
    private ServIp maskPublico;
    private ServIp privado;
    private ServIp privadoMask;
    
    private int id;
    private int maskPublic = 0;
    private int maskPrivada = 0;
    
    private Double quathostPublic;
    private Double quathostPrivado;
    
    private float divPool;
    /**
     * Constroi um objeto com dois range de IPs 
     * recebendo como parametro o ID da rede, 
     * com a respectiva mascara de rede.
     * Assim  para as duas redes. 
     * A primeira sendo o IPs validos, 
     * e a segunda com o range de IP privados.
     * @param ip 
     * ID de rede Publica
     * @param maskIp
     * Mascara de rede publica.
     * @param pool
     * ID da rede privada.
     * @param maskPool 
     * Mascara de rede privada.
     */
    public CgNat(String ip, String maskIp,
            String pool, String maskPool)
    {
        publico = new ServIp(ip);
        maskPublico = new ServIp(maskIp);
        
        privado = new ServIp(pool);
        privadoMask = new ServIp(maskPool);
    }
    
    /**
     * Com base nos dados informa a quantidade de IP publico,
     * e a quantidade de IP privado, 
     * Função calcula quantos IP privados irão "sair" por um IP publico.
     */
    public void sharePool()
    {
        quantPrivado();
        quantPublico();
        
        setQuathostPublic(Math.pow(2, getMaskPublic()));
        setQuathostPrivado(Math.pow(2, getMaskPrivada()));
        
        divPool();
        
        designarToNat();
        System.out.println("Segue conversão binaria das Maskara IP \n"+ privadoMask.toString() +"\nSegue maskra privada \n" + maskPublico.toString());
    }
    /**
     * Calcula a quantidade de IP publico por cada range de IP privado. 
     */
    private void divPool()
    {
        setDivPool((float)(getQuathostPrivado() / getQuathostPublic()));
        System.out.println("Segue quantos host tera por IP publico "+getDivPool());
    }
    /**'
     * Devine a quantidade de IP privado contida no range informado.
     */
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
    /**
     * Devine quantos IP tem baseado na mascara informada.
     * @param elemento 
     * Mascara de rede. 
     */
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
        setMaskPrivada(cont + getMaskPrivada());
        System.out.println("Segue tamanho da maska privada "+getMaskPrivada());
    }

    /**
     * Devine a quantidade de IP privado contida no range informado.
     */
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
    /**
     * Devine quantos IP tem baseado na mascara informada.
     * @param elemento 
     * Mascara de rede. 
     */
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
    /**
     * devine o ID da rede publica/privada
     */
    public void designarToNat()
    {
        StringBuilder idRede = new StringBuilder();
        if(getQuathostPublic() < 255)
        {
            for (int i = 0; i < 8 - getMaskPublic() ; i++) 
            {
                idRede.append(publico.getRoomOcteto().charAt(i));
            }
            
            if(8 < idRede.length())
                throw new IllegalAccessError("Erro ao definir id de rede.");
            
            while (8 != idRede.length()) 
            {
                idRede.append("0");
            }
        }
        String octeto = idRede.toString();
        setId(Integer.parseInt(octeto, 2));
        System.out.println("Segue id de rede em binario "+octeto+
                "\nSegue IP convertido " +Integer.parseInt(octeto, 2)+
                "\nSegue pool divido " +getDivPool()+
                "\nSegue quantidade de host privado " +getQuathostPrivado()+
                "\nSegue quantidade de host publico " +getQuathostPublic()+
                "\n Segue mask decimal "+valorMask((int)getDivPool(),0));
        publicToPrivado();
        
    }
    /**
     * Função define o tamanho da maskara IP abreviado 
     * Ou seja. 
     * para uma quantidade de host 256 ele ira retornar 8.
     * subtraindo 32 por 8 o resultado será 24.
     * Ou seja, a mascara é /24 
     * @param host Quantidade de host
     * @param mask favor atribuir 0 para esse parâmetro.
     * @return quantidade de zero na maskara binária.
     */
    private int valorMask(int host, int mask){
        int cont = ++mask;
        
        if (host <= 2)
            return cont;
        
        return valorMask(host/2, cont);
        
    }
    private void publicToPrivado(){
        int maskAbrev = 32 - valorMask((int) getDivPool(),0);
        for(int i = 0; i < getQuathostPublic(); i++){
            System.out.println("Segue Ip publico "+publico.getFirstOctetoDec()+"."+
                    publico.getSecondOctetoDec()+"."+publico.getThirdOctetoDec()+"."+(getId() + i)+"\n"+
                    ipPrivado(i)+"/"+maskAbrev);
        }
    }
    private String ipPrivado(int block){
        
        String um = privado.getFirstOctetoDec()+".";
        String dois = privado.getSecondOctetoDec()+".";
        int tres = privado.getThirdOctetoDec();
        int quatro = privado.getRoomOctetoDec();
        
        if(block != 0){
            if(getDivPool() == 256){
                tres = privado.getThirdOctetoDec() + block;
            }
        }
        return um+dois+tres+"."+quatro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
