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
    
    public ValidaIp()
    {
        super(18);
    }
    
    @Override
    public void insertString(int offset, String str, AttributeSet attr)
                    throws BadLocationException 
    {
        if(isPonto(str))
        {
            super.insertString(offset, str, attr);
            return;
        }
        if(octeto())
        {
            super.insertString(offset, str, attr);
            return;
        }
        
    }
    
    private boolean isPonto(String str)
    {
        if(str.equals("."))
        {
            return octeto();
        } 
        return false;
    }
    
    private boolean octeto()
    {
        if(getLength() <= 3)
        {
            return true;
        }
        return false;
    }
    
    private void incrementoPonto()
    {
        
    }
}
