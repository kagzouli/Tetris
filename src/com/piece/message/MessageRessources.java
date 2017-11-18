package com.piece.message;

import java.util.ResourceBundle;

import com.piece.constant.Constante;
import com.piece.exception.TechnicalException;

/**
 * Classes pour recuperer les messages.
 * 
 * @author x587368
 * 
 */
public final class MessageRessources
{
    
    /**
     * Attribut pour recuperer les messages.<br/>
     */
    private static MessageRessources messages = new MessageRessources(Constante.BUNDLE_NAME_AIREJEU);

    /**
     * Recupere le bundle du fichier
     */
    private transient ResourceBundle bundle;
    
    
    protected MessageRessources(){
        
    }

    /**
     * Constructeur par default.<br/>
     */
    protected MessageRessources(String bundleName)
    {
        bundle = ResourceBundle.getBundle(bundleName);
    }

    /**
     * Methode permettant de recuperer une instance des messages.<br/>
     * @param bundleName Nom du fichier de propriete.<br/>
     * @return Retourne une instance des messages.<br/>
     */
    public static MessageRessources getInstance(String bundleName)
    {
        return messages;
    }

    /**
     * Methode permettant de recuperer un message sous forme de String.<br/>
     * 
     * @param key Cle.<br/>
     * @return Retourne le message correspondant a la cle.<br/>
     * @throws TechnicalException Erreur technique.<br/>
     */
    public String getMessage(String key) throws TechnicalException
    {
        String message = null;
        
        try{
            message = bundle.getString(key);
        } catch (Exception e)
        {
            throw new TechnicalException(e);
        }
        
        return message;
    }

    /**
     * Methode permettant de recuperer un message sous forme d'entier.<br/>
     * 
     * @param key Cle.<br/>
     * @return Retourne le message sous forme d'entier.<br/>
     * @throws TechnicalException Erreur technique.<br/>
     */
    public Integer getMessageInteger(String key) throws TechnicalException
    {
        Integer messageInteger = null;
        try
        {
            String message = bundle.getString(key);

            if ((message != null) && (!message.trim().equals("")))
            {
                messageInteger = new Integer(message);
            }
        } catch (Exception e)
        {
            throw new TechnicalException(e);
        }
        return messageInteger;
    }

}
