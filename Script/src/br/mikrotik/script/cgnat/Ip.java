/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mikrotik.script.cgnat;

/**
 *
 * @author jackson
 */
public class Ip {
    private String ip;
    private String mask;
    
    public Ip(String ip){
        setIp(ip);
    }
    
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }
    
    @Override
    public String toString(){
        return "\n"+getIp()+"\n"+getMask();
    }
    
}
