package com.piece.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Manager permettant de gerer l'ensemble des threads lances.<br/>
 * 
 */
public final class QueueManager
{
    
    private transient Log log = LogFactory.getLog(QueueManager.class);
    
    private static QueueManager queue = new QueueManager();
    
    private List threadLance;

    protected QueueManager(){
        threadLance = new ArrayList();
    }
    
    /**
     * Methode permettant de recuperer une instance de la queue.<br/>
     * @return Retourne la queue.<br/>
     */
    public static QueueManager getInstance(){
        return queue;
    }
    
    
    
    public void addThread(Runnable runnable){
        threadLance.add(runnable);
        log.info(new StringBuffer().append("Ajout d'un thread ").append(runnable).toString());
    }
    
    public Iterator iterator(){
        
        
        return queue.iterator();
    }

}
