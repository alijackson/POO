/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mikrotik.view.Service;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

/**
 *
 * @author jackson
 */
public class ValidaIp extends LimitTxt{
    
    private int ponto, octeto;
    
    public ValidaIp()
    {
        super(15);
    }
    
    @Override
    public void insertString(int offset, String str, AttributeSet attr)
                    throws BadLocationException 
    {
        if(validaDado(str))
            super.insertString(offset, str, attr);
        
    }
    
    private boolean validaDado(String str)
    {
        return tipodeDado(str) ? mapearDados(str) : false;
    }
    
    private boolean tipodeDado(String str)
    {
        return str.matches("\\d?\\.?");
    }
    
    private boolean mapearDados(String str)
    {
        return (str.matches("[0-9]+") ? 
                incrementeOcteto() : incrementePonto());    
    }
    
    private boolean incrementeOcteto()
    {
        if(getOcteto() >= 0 && getOcteto() <=3)
            setOcteto(getOcteto() + 1);
        
        return getOcteto() <= 3;
    }
    
    private boolean incrementePonto()
    {
        if(getOcteto() > 0 && getPonto() < 3)
        {
            setOcteto(0);
            setPonto(getPonto() + 1 );
            return true;
        }
        return false;
    }
    public void backSpace()
    {
        if(super.getLength() == 0)
            return;
        try {
            String txt = super.getText(0
                    , super.getLength());
            
            char text = txt.charAt(txt.length()-1);
            txt = String.valueOf(text);
            
            if(txt.length() > 0)
            {
                if(txt.matches("\\d?"))
                    setOcteto(getOcteto() == 0 ? getOcteto() : getOcteto() - 1);
                else
                    setPonto(getPonto() == 0 ? getPonto() : getPonto() - 1);
            }
            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    public int getPonto() {
        return ponto;
    }

    public void setPonto(int ponto) {
        this.ponto = ponto;
    }
    
    public int getOcteto() {
        return octeto;
    }

    public void setOcteto(int octeto) {
        this.octeto = octeto;
    }
}
