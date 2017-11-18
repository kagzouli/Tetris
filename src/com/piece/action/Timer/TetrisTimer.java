package com.piece.action.Timer;

import javax.swing.Timer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.piece.aire.AireJeu;

/**
 * Timer utilise pour Tetris.<br/>
 * Le timer est unique.<br/>
 * 
 * @author x587368
 * 
 */
public final class TetrisTimer
{ 
    
    private transient Log log = LogFactory.getLog(TetrisTimer.class);
    
    /**
     * Delai du timer par default.
     */
      
    /**
     * Timer.
     */
    private transient Timer timer = null;
    
    /**
     * Constructeur permettant de construire un timer pour tetris.<br/>
     * @param delay Delai entre chaque raffraichissement.<br/>
     * @param actionListener Listener.<br/>
     */
    public TetrisTimer(int delay,TetrisListener actionListener){
        timer = new Timer(delay,actionListener);
    }
    
    /**
     * Lance le timer de tetris.<br/>
     *
     */
    public void start(){
        if (timer != null){
            log.info("Debut du timer");
            timer.start();
        }
    }
    
    /**
     * Methode donnant le tempo pour raffraichir le timer.
     * @param delay
     */
    public void setRaffraichissement(int delay){
        timer.setDelay(delay);
    }
    
    /**
     * Methode permettant d'arreter le timer.<br/>
     *
     */
    public void stop(){
        timer.stop();
    }
}
