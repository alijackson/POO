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
public class Ip 
{
    private String ip;
    
    private String firstOcteto;
    private String secondOcteto;
    private String thirdOcteto;
    private String roomOcteto;

    private int firstOctetoDec;
    private int secondOctetoDec;
    private int thirdOctetoDec;
    private int roomOctetoDec;

    public int getFirstOctetoDec() {
        return firstOctetoDec;
    }

    public void setFirstOctetoDec(int firstOctetoDec) {
        this.firstOctetoDec = firstOctetoDec;
    }

    public int getSecondOctetoDec() {
        return secondOctetoDec;
    }

    public void setSecondOctetoDec(int secondOctetoDec) {
        this.secondOctetoDec = secondOctetoDec;
    }

    public int getThirdOctetoDec() {
        return thirdOctetoDec;
    }

    public void setThirdOctetoDec(int thirdOctetoDec) {
        this.thirdOctetoDec = thirdOctetoDec;
    }

    public int getRoomOctetoDec() {
        return roomOctetoDec;
    }

    public void setRoomOctetoDec(int roomOctetoDec) {
        this.roomOctetoDec = roomOctetoDec;
    }
    
    public String getFirstOcteto() {
        return firstOcteto;
    }

    public void setFirstOcteto(String firstOcteto) {
        this.firstOcteto = firstOcteto;
    }

    public String getSecondOcteto() {
        return secondOcteto;
    }

    public void setSecondOcteto(String secondOcteto) {
        this.secondOcteto = secondOcteto;
    }

    public String getThirdOcteto() {
        return thirdOcteto;
    }

    public void setThirdOcteto(String thirdOcteto) {
        this.thirdOcteto = thirdOcteto;
    }

    public String getRoomOcteto() {
        return roomOcteto;
    }

    public void setRoomOcteto(String roomOcteto) {
        this.roomOcteto = roomOcteto;
    }

    public Ip(String ip){
        setIp(ip);
    }
    
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
}
