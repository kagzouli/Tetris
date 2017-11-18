package com.piece.action;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.piece.aire.AireJeu;

public class DispatchActionJoueurs implements KeyListener
{
    protected static final String ACTION_JOUEUR1 = "actionJoueur1";
      
    protected static final String ACTION_JOUEUR2 = "actionJoueur2";
    
    protected static Map actions = null;
    
    protected transient Log log = LogFactory.getLog(DispatchActionJoueurs.class);
    
    private boolean isModeSolo;
 
    public DispatchActionJoueurs(){
    	this.isModeSolo = false;
    }

    
    public DispatchActionJoueurs(boolean isModeSolo){
    	this.isModeSolo = isModeSolo;
    }

    public void keyPressed(KeyEvent theE)
    {
        initActions();
                     
        //Action Joueur1
        ActionsJoueur1 aj1 = (ActionsJoueur1) actions.get(ACTION_JOUEUR1);
        actionJoueur(theE,aj1);  
        
        //Action Joueur2
        if (!this.isModeSolo){
            ActionsJoueur2 aj2 = (ActionsJoueur2) actions.get(ACTION_JOUEUR2);
            actionJoueur(theE,aj2);         	
        }
        
        //Reaffiche l'ecran.
        AireJeu.getInstance().repaint();

    }

    public void keyReleased(KeyEvent theE)
    {
        
    }

    public void keyTyped(KeyEvent theE)
    {
    }
    
    /**
     * Methode permettant d'initialiser si besoin les actions(Cad la 1er fois).<br/>
     *
     */
    protected void initActions(){
        if (actions == null){
            actions = new HashMap();
            actions.put(ACTION_JOUEUR1, new ActionsJoueur1());
            
            // Si mode solo ou non, le joueur2 est soit un humain, soit un ordi
            if (!this.isModeSolo){
                actions.put(ACTION_JOUEUR2, new ActionsJoueur2());           	
            }else{
            	actions.put(ACTION_JOUEUR2, new ActionsComputer());
            }
        }
    }
    
    /**
     * Methode permettant d'enregistrer les actions du joueur.<br/>
     * @param theE KeyEvent.<br/>
     * @param aj ActionJoueur.<br/>
     *
     */
    protected void actionJoueur(KeyEvent theE,ActionJoueurs aj){
        
    	// Si la piece du joueur1 n'est pas cree.
    	if (AireJeu.getInstance().getPieceCourantJoueur1() == null){
    		return;
    	}

    	// Si la piece du joueur2 n'est pas cree.
    	if (AireJeu.getInstance().getPieceCourantJoueur2() == null){
    		return;
    	}

        int codeTouche = theE.getKeyCode();
        
        if (codeTouche == aj.getCodeDeplacementGauche()){
            log.info("Appuie touche gauche joueu");
            aj.deplacerGauche();
        }
        
        if (codeTouche == aj.getCodeDeplacementDroite()){
            log.info("Appuie touche droite joueu");
            aj.deplacerDroite();
        }
        
        if (codeTouche == aj.getCodeDeplacementBas()){
            log.info("Appuie touche bas joueur");
            aj.deplacerBas();
        }
        
        if (codeTouche == aj.getCodeRotation()){
            log.info("Appuie touche rotation joueur");
            aj.rotation();
        }

    }
    
    

}
