/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mikrotik.script.cgnat;

import br.mikrotik.script.elementoIp.ServiceIp;

/**
 *
 * @author jackson
 */
public class CgNat extends ServiceIp{
    private Ip publico;
    private Ip privado;
    
    public CgNat(Ip rede){
        super(rede.getIp());
        setPublico(rede);
    }

    public Ip getPublico() {
        return publico;
    }

    public void setPublico(Ip publico) {
        this.publico = publico;
    }

    public Ip getPrivado() {
        return privado;
    }

    public void setPrivado(Ip privado) {
        this.privado = privado;
    }
    
}
