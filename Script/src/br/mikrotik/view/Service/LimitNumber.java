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
public class LimitNumber extends LimitTxt{
    
    public LimitNumber(int limit){
        super(limit);
    }
    @Override
    public void insertString(int offset, String str, AttributeSet attr)
                    throws BadLocationException 
    {
        // Valida se é maior que o informado, e se é um número
        if (validateIsNumber(str))    // se o comprimento final for menor...
            super.insertString(offset, str, attr);   // ...aceita str
    }
    /**
     * Codificado para validar se é um número 
     * que o usuario digitou ou letras.
     * @param str
     * @return 
     */
    private boolean validateIsNumber(String str){
        try 
        {
            Integer.parseInt(str);
            return true;
        } 
        catch (Exception e) 
        {
            return false;
        }
    }
}
