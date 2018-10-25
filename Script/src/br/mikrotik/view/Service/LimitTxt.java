package br.mikrotik.view.Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.text.*;

public class LimitTxt extends PlainDocument 
{
    private int iMaxLength;
    private boolean hasLimit = true;
    
    public LimitTxt(int maxlen) 
    {
        super();
        
        setiMaxLength(maxlen);
    }
    
    @Override
    public void insertString(int offset, String str, AttributeSet attr)
                    throws BadLocationException 
    {
        
        int ilen = (getLength() + str.length());
        // Valida se é maior que o informado, e se é um número
        if (ilen <= getiMaxLength())    // se o comprimento final for menor...
            super.insertString(offset, str, attr);   // ...aceita str
        
    }
            
    public int getiMaxLength() {
        return iMaxLength;
    }

    public void setiMaxLength(int iMaxLength) {
        this.iMaxLength = iMaxLength;
    }
}