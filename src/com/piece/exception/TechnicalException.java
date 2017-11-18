package com.piece.exception;

/**
 * Erreur technique.<br/>
 *
 */
public class TechnicalException extends Exception
{
    
    public TechnicalException(String message){
        super(message);
    }
    
    public TechnicalException(Throwable e){
        super(e);
    }

}
