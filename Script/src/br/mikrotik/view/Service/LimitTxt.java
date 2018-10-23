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
        
        if(maxlen <= 0)
            setHasLimit(false);
        else
            setiMaxLength(maxlen);
    }
    
    @Override
    public void insertString(int offset, String str, AttributeSet attr)
                    throws BadLocationException 
    {
        //if (s == null) return;
        if (isHasLimit())        // aceitara qualquer no. de caracteres
        {
            super.insertString(offset, str.toUpperCase(), attr);
            return;
        }
        
        int ilen = (getLength() + str.length());
        // Valida se é maior que o informado, e se é um número
        if (ilen <= getiMaxLength())    // se o comprimento final for menor...
            super.insertString(offset, str.toUpperCase(), attr);   // ...aceita str
        
    }

    public boolean isHasLimit() {
        return hasLimit;
    }

    public void setHasLimit(boolean hasLimit) {
        this.hasLimit = hasLimit;
    }
            
    public int getiMaxLength() {
        return iMaxLength;
    }

    public void setiMaxLength(int iMaxLength) {
        this.iMaxLength = iMaxLength;
    }
}