package com.piece.aire;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.piece.action.EcouteurMusique;
import com.piece.action.QueueManager;
import com.piece.action.Timer.TetrisListener;
import com.piece.action.Timer.TetrisTimer;
import com.piece.aire.grille.ITable;
import com.piece.constant.Constante;
import com.piece.exception.TechnicalException;
import com.piece.message.MessageRessources;
import com.piece.tetris.Piece;

/**
 * L'aire de jeu represente le panel.<br/>
 * 
 */
public final class AireJeu extends JPanel
{
    private transient Log log = LogFactory.getLog(AireJeu.class);

    private static final long serialVersionUID = 1234343665656565L;
    

    /**
     * Aire jeu joueur1.<br/>
     */
    protected ITable grilleJoueur1;

    /**
     * Aire jeu joueur 2.<br/>
     */
    protected ITable grilleJoueur2;

    /**
     * Piece courante joueur1.
     */
    protected Piece pieceCourantJoueur1;
    
    /**
     * Pas de collision joueur1.<br/>
     */
    protected boolean nonCollisionJoueur1;

    /**
     * Pas de collision joueur2.<br/>
     */
    protected boolean nonCollisionJoueur2;
    
    /**
     * Score du joueur1.<br/>
     */
    protected int scoreJoueur1;
    
    /**
     * Score du joueur2.<br/>
     */
    protected int scoreJoueur2;
    
    /**
     * Level du joueur1.<br/>
     */
    protected String levelJoueur1;
    
    /**
     * Level du joueur2.<br/>
     */
    protected String levelJoueur2;
    
    /**
     * Booleen permettant de savoir si le joueur1 est vivant.<br/>
     */
    protected  boolean vivantJoueur1;
    
    /**
     * Boolean permettant de savoir si le joueur1 est vivant.<br/>
     */
    protected boolean vivantJoueur2;
    

    /**
     * Piece courante joueur2.
     */
    protected Piece pieceCourantJoueur2;

    private static AireJeu aireJeu = new AireJeu();
    
    /**
     * Timer.<br/>
     */
    private Integer timer;
    
    /** Mode pour savoir si on est a 1 joueur ou 2.<br/>  **/
    private boolean isModeSolo;

    /**
     * Methode pour savoir si l'aire de jeu est initialisee. Cela permet de savoir quand commencer a raffraichir avec
     * paint.<br/>
     */
    private boolean init = false;

    protected AireJeu()
    {
    	scoreJoueur1 = 0;
    	scoreJoueur2 = 0;
    	
    	vivantJoueur1 = true;
    	vivantJoueur2 = true;

    }

    /**
     * Singleton
     * 
     * @return
     */
    public static AireJeu getInstance()
    {
        return aireJeu;
    }

    /**
     * Methode permettant d'initialiser l'aire de jeu.<br/>
     * 
     * @throws TechnicalException Erreur technique.<br/>
     */
    public void init(final boolean isModeSolo) throws TechnicalException
    {
        log.info("DEBUT de la methode init de la classe "+this.getClass().getName());
        
        try
        {
        	// Mode solo.
        	this.isModeSolo = isModeSolo;
        	
            // Couleur de fond noir.
            this.setBackground(Color.BLACK);

            // Creation de la grille du joueur 1.
            grilleJoueur1 = FactoryTable.creerTable(50, 80, 14, 10);

            // Creation de la grille du joueur 2.
            grilleJoueur2 = FactoryTable.creerTable(550, 80, 14, 10);
    
            // lancement du timer de tetris
            Integer delay = MessageRessources.getInstance(Constante.BUNDLE_NAME_AIREJEU).getMessageInteger(Constante.CLE_TEMPS_TIMER_LEVEL0);
            TetrisListener tetrisListener = new TetrisListener();
            TetrisTimer tetrisTimer = new TetrisTimer(delay.intValue(),tetrisListener);
            tetrisTimer.start();
            tetrisListener.setTimer(tetrisTimer,isModeSolo);
            
            // lancement de la musique
            String musique = MessageRessources.getInstance(Constante.BUNDLE_NAME_AIREJEU).getMessage(Constante.CLE_MUSIQUE);
            EcouteurMusique ecouteurMusique = new EcouteurMusique();
            ecouteurMusique.setMusique(musique);
            Thread threadEcouteurMusique = new Thread(ecouteurMusique);
            threadEcouteurMusique.start();
            QueueManager.getInstance().addThread(threadEcouteurMusique);

            
               
            //Le panel est initialise.
            init = true;
        } catch (Exception e)
        {
            log.error(e,e);
            throw new TechnicalException(e);
        }
        
        log.info("FIN de la methode init de la classe "+this.getClass().getName());
    }

    public void paint(Graphics gc)
    {
        // Couleur de fond noir.
        this.setBackground(Color.BLACK);
        if (init)
        {
            log.info("paint");
            
            super.paint(gc);

            gc.setColor(Color.BLUE);
            Font font = new Font(null, Font.BOLD, 14);
            gc.setFont(font);
            gc.drawString("Joueur 1", 190, 35);
            StringBuffer texte1 = new StringBuffer();
            texte1.append("(Score : ");
            texte1.append(this.scoreJoueur1);
            texte1.append(",level : ");
            texte1.append((this.levelJoueur1 == null ? "0" : this.levelJoueur1));
            texte1.append(")");
            gc.drawString(texte1.toString(), 190, 50);
            gc.drawString("Joueur 2", 690, 35);
            StringBuffer texte2 = new StringBuffer();
            texte2.append("(Score : ");
            texte2.append(this.scoreJoueur2);
            texte2.append(",level : ");
            texte2.append((this.levelJoueur2 == null ? "0" : this.levelJoueur2));
            texte2.append(")");
            gc.drawString(texte2.toString(), 690, 50);

            // Trace la grille du joueur1.
            this.traceGrille(gc, grilleJoueur1);

            // Trace la grille du joueur2.
            this.traceGrille(gc, grilleJoueur2);
        }

    }

    /**
     * Methode permettant de tracer la grille.<br/>
     * 
     * @param gc Graphics.<br/>
     * @param grille Grille.<br/>
     * @param positionInitialeX positionInitialeX
     * @param int positionInitialeY positionInitialeY.
     */
    private void traceGrille(Graphics gc, ITable grille)
    {
        if (grille != null)
        {
            grille.draw(gc);
        }
    }
    
    /**
     * Methode permettant de reinitialiser la partie apres la fin(Annonce du score)
     */
	public void reinitialisePartie(){
		scoreJoueur1 = 0;
		scoreJoueur2 = 0;
		this.vivantJoueur1 = true;
		this.vivantJoueur2 = true;
		grilleJoueur1.reset();
		grilleJoueur2.reset();
	}


    public ITable getGrilleJoueur1()
    {
        return grilleJoueur1;
    }

    public void setGrilleJoueur1(ITable theGrilleJoueur1)
    {
        grilleJoueur1 = theGrilleJoueur1;
    }

    public ITable getGrilleJoueur2()
    {
        return grilleJoueur2;
    }

    public void setGrilleJoueur2(ITable theGrilleJoueur2)
    {
        grilleJoueur2 = theGrilleJoueur2;
    }

    public Piece getPieceCourantJoueur1()
    {
        return pieceCourantJoueur1;
    }

    public void setPieceCourantJoueur1(Piece thePieceCourantJoueur1)
    {
        pieceCourantJoueur1 = thePieceCourantJoueur1;
    }

    public Piece getPieceCourantJoueur2()
    {
        return pieceCourantJoueur2;
    }

    public void setPieceCourantJoueur2(Piece thePieceCourantJoueur2)
    {
        pieceCourantJoueur2 = thePieceCourantJoueur2;
    }

    public boolean isNonCollisionJoueur1()
    {
        return nonCollisionJoueur1;
    }

    public void setNonCollisionJoueur1(boolean theNonCollisionJoueur1)
    {
        nonCollisionJoueur1 = theNonCollisionJoueur1;
    }

    public boolean isNonCollisionJoueur2()
    {
        return nonCollisionJoueur2;
    }

    public void setNonCollisionJoueur2(boolean theNonCollisionJoueur2)
    {
        nonCollisionJoueur2 = theNonCollisionJoueur2;
    }

    public int getScoreJoueur1()
    {
        return scoreJoueur1;
    }

    public void setScoreJoueur1(int theScoreJoueur1)
    {
        scoreJoueur1 = theScoreJoueur1;
    }

    public int getScoreJoueur2()
    {
        return scoreJoueur2;
    }

    public void setScoreJoueur2(int theScoreJoueur2)
    {
        scoreJoueur2 = theScoreJoueur2;
    }

    public Integer getTimer()
    {
        return timer;
    }

    public void setTimer(Integer theTimer)
    {
        timer = theTimer;
    }

    public String getLevelJoueur1()
    {
        return levelJoueur1;
    }

    public void setLevelJoueur1(String theLevelJoueur1)
    {
        levelJoueur1 = theLevelJoueur1;
    }

    public String getLevelJoueur2()
    {
        return levelJoueur2;
    }

    public void setLevelJoueur2(String theLevelJoueur2)
    {
        levelJoueur2 = theLevelJoueur2;
    }

	/**
	 * @return the vivantJoueur1
	 */
	public boolean isVivantJoueur1() {
		return vivantJoueur1;
	}

	/**
	 * @param vivantJoueur1 the estVivantJoueur1 to set
	 */
	public void setVivantJoueur1(boolean vivantJoueur1) {
		this.vivantJoueur1 = vivantJoueur1;
	}

	/**
	 * @return the vivantJoueur2
	 */
	public boolean isVivantJoueur2() {
		return vivantJoueur2;
	}

	/**
	 * @param estVivantJoueur2 the estVivantJoueur2 to set
	 */
	public void setVivantJoueur2(boolean vivantJoueur2) {
		this.vivantJoueur2 = vivantJoueur2;
	}

	public boolean isModeSolo() {
		return isModeSolo;
	}

	public void setModeSolo(boolean isModeSolo) {
		this.isModeSolo = isModeSolo;
	}	
	
	

}
