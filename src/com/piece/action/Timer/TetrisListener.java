package com.piece.action.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.piece.action.PieceFacade;
import com.piece.action.strategy.IStrategyDeplacementPiece;
import com.piece.action.strategy.StrategyAleatoire;
import com.piece.action.strategy.StrategyComplexe;
import com.piece.aire.AireJeu;
import com.piece.aire.FactoryTable;
import com.piece.aire.grille.ICell;
import com.piece.aire.grille.IRow;
import com.piece.aire.grille.ITable;
import com.piece.exception.TechnicalException;
import com.piece.level.Level;
import com.piece.level.LevelManager;
import com.piece.tetris.FactoryPiece;
import com.piece.tetris.Piece;

/**
 * Action repetee un certain nombre de fois fait par tetris.
 * 
 */
public class TetrisListener implements ActionListener
{
    private transient Log log = LogFactory.getLog(TetrisListener.class);

    /**
     * Timer tetris.
     */
    private TetrisTimer timer;

    private static int INDEX_POS_LONG = 0;

    private static int INDEX_POS_LARG = 3;

    private PieceFacade pieceFacade = new PieceFacade();
    
    /** mode 1 joueur ou 2 joueurs **/
    private boolean isModeSolo;
    
    /** Strategy aleatoire ordinateur. **/
    private IStrategyDeplacementPiece strategyDeplacementPiece;
    
    public TetrisListener(){
    	strategyDeplacementPiece = new StrategyComplexe(pieceFacade);
    }
       

    public void setTimer(TetrisTimer theTimer,final boolean isModeSolo)
    {
        timer = theTimer;
        this.isModeSolo = isModeSolo;
    }

    public void actionPerformed(ActionEvent theE)
    {
        log.info(new StringBuffer("methode actionPerformed de la classe ").append(this.getClass().getName()).toString());
        ITable grilleJoueur1 = AireJeu.getInstance().getGrilleJoueur1();
        ITable grilleJoueur2 = AireJeu.getInstance().getGrilleJoueur2();
        

        // Pour le joueur1.
        boolean nonCollisionJoueur1 = AireJeu.getInstance().isNonCollisionJoueur1();

        // S'il y'a une collision pour le joueur1.
        if (!nonCollisionJoueur1)
        {
            Piece pieceJoueur1 = FactoryPiece.getInstance().createPiece();
            nonCollisionJoueur1 = pieceFacade.afficherPiece(grilleJoueur1, pieceJoueur1);
            
            if (nonCollisionJoueur1){
            	 AireJeu.getInstance().setPieceCourantJoueur1(pieceJoueur1); 	
            }else{
            	AireJeu.getInstance().setVivantJoueur1(false);
            }
           
        } else
        {
            nonCollisionJoueur1 = pieceFacade.deplacerBas(grilleJoueur1, AireJeu.getInstance().getPieceCourantJoueur1());
        }
        AireJeu.getInstance().setNonCollisionJoueur1(nonCollisionJoueur1);
        

        // Pour le joueur2.
        boolean nonCollisionJoueur2 = AireJeu.getInstance().isNonCollisionJoueur2();
        if (!nonCollisionJoueur2)
        {
            Piece pieceJoueur2 = FactoryPiece.getInstance().createPiece();
            boolean estAffiche = nonCollisionJoueur2 = pieceFacade.afficherPiece(grilleJoueur2, pieceJoueur2);
            if (estAffiche){
                AireJeu.getInstance().setPieceCourantJoueur2(pieceJoueur2);
            }else{
            	AireJeu.getInstance().setVivantJoueur2(Boolean.FALSE);
            }
         } else
        {
            nonCollisionJoueur2 = pieceFacade.deplacerBas(grilleJoueur2, AireJeu.getInstance().getPieceCourantJoueur2());
        }
        AireJeu.getInstance().setNonCollisionJoueur2(nonCollisionJoueur2);
        
        
        /* Test si c'est la fin de la partie */
        if ((!AireJeu.getInstance().isVivantJoueur1()) && (!AireJeu.getInstance().isVivantJoueur2())){
        	String messageFin = recupereMessageFin();
        	JOptionPane.showMessageDialog(AireJeu.getInstance(), messageFin,"Resultat",JOptionPane.INFORMATION_MESSAGE);
        	//Reinitialise le  jeu
        	AireJeu.getInstance().reinitialisePartie();
          }
      	

        // Remet a jour la grille (Supprime les lignes remplits).
        int numLignSupp1 = 0;
        int numLignSupp2 = 0;
        if (AireJeu.getInstance().getPieceCourantJoueur1().isBloque()){
        	numLignSupp1 = AireJeu.getInstance().getGrilleJoueur1().supprimeLignePleine();
                   	
        }
        
        if (AireJeu.getInstance().getPieceCourantJoueur2().isBloque()){
            numLignSupp2 = AireJeu.getInstance().getGrilleJoueur2().supprimeLignePleine();
        }
       	 
 
        // mise a jour de la grille du joueur 1 si besoin.
        if (numLignSupp1 > 0)
        {
            this.miseAJourGrilleJoueur1(numLignSupp1);
            AireJeu.getInstance().setScoreJoueur1(AireJeu.getInstance().getScoreJoueur1() + numLignSupp1);
        }

        // mise a jour de la grille du joueur 2 si besoin.
        if (numLignSupp2 > 0)
        {
            this.miseAJourGrilleJoueur2(numLignSupp2);
            AireJeu.getInstance().setScoreJoueur2(AireJeu.getInstance().getScoreJoueur2() + numLignSupp2);
        }

      
        //Gere la vitesse du jeu selon le score.
        gestionTimer();
       

        // Reaffiche le jeu.
        AireJeu.getInstance().repaint();
        
        //Action joueur2 - Intelligence artificielle.
        if (this.isModeSolo){
        	Piece pieceJoueur2 = AireJeu.getInstance().getPieceCourantJoueur2();
        	strategyDeplacementPiece.deplacerPiece(grilleJoueur2, pieceJoueur2);
        }

    }

    /**
     * Methode permettant de mettre a jour la grille du joueur1.<br/>
     * 
     * @param numLignSupp1 Nombre de lignes a supprimer.<br/>
     */
    protected void miseAJourGrilleJoueur1(int numLignSupp1)
    {
        ITable grilleJoueur1New = FactoryTable.creerTable(50, 80, 14, 10);

        ITable tableTempJoueur1 = AireJeu.getInstance().getGrilleJoueur1();

        this.miseAJourGrilleJoueur(numLignSupp1, grilleJoueur1New, tableTempJoueur1);

        AireJeu.getInstance().setGrilleJoueur1(grilleJoueur1New);
    }

    /**
     * Methode permettant de mettre a jour la grille du joueur2.<br/>
     * 
     * @param numLignSupp2 Nombre de lignes a supprimer.<br/>
     */
    protected void miseAJourGrilleJoueur2(int numLignSupp2)
    {
        ITable grilleJoueur2New = FactoryTable.creerTable(550, 80, 14, 10);

        ITable tableTempJoueur2 = AireJeu.getInstance().getGrilleJoueur2();

        this.miseAJourGrilleJoueur(numLignSupp2, grilleJoueur2New, tableTempJoueur2);

        AireJeu.getInstance().setGrilleJoueur2(grilleJoueur2New);
    }

    /**
     * Methode permettant de mettre a jour la grille d'un joueur quelconque.<br/>
     * 
     * @param numLignSupp Nombre de lignes supprimes.<br/>
     * @param grilleJoueurNew nouvelle grille du joueur.<br/>
     * @param tableTemp Ancienne grille.<br/>
     */
    protected void miseAJourGrilleJoueur(int numLignSup, ITable grilleJoueurNew, ITable tableTemp)
    {
        Iterator itGrilleJoueurNew = grilleJoueurNew.iterator();
        int indexLigne = 0;
        for (int indx = 0; indx < numLignSup; indx++)
        {
            itGrilleJoueurNew.next();
            indexLigne = indexLigne + 1;
        }

        Iterator itRowSave = tableTemp.iterator();
        while (itGrilleJoueurNew.hasNext())
        {
            IRow row = (IRow) itGrilleJoueurNew.next();
            IRow rowSave = (IRow) itRowSave.next();
            Iterator itCell = rowSave.iterator();
            int indexCell = 0;
            while (itCell.hasNext())
            {
                ICell cellSave = (ICell) itCell.next();
                row.getCell(indexCell).setLargeur(cellSave.getLargeur());
                row.getCell(indexCell).setLongueur(cellSave.getLongueur());
                row.getCell(indexCell).setOccupe(cellSave.getCouleurCellule());
                indexCell = indexCell + 1;
            }

            indexLigne = indexLigne + 1;
        }
    }

    /**
     * Methode permettant de gerer le timer et la vitesse du jeu.<br/>
     *
     */
    protected void gestionTimer()
    {
        int score1 = AireJeu.getInstance().getScoreJoueur1();
        int score2 = AireJeu.getInstance().getScoreJoueur2();

        int score = 0;
        if (score1 <= score2)
        {
            score = score2;
        } else
        {
            score = score1;
        }
        
        // Gestion
        try
        {
            Level levelCourant = LevelManager.getInstance().getLevel(new Integer(score));
            Integer timerAppli = levelCourant.getTimer();

            if ((timerAppli != null) && (!timerAppli.equals(AireJeu.getInstance().getTimer())))
            {
                AireJeu.getInstance().setTimer(timerAppli);
                AireJeu.getInstance().setLevelJoueur1(levelCourant.getLabel());
                AireJeu.getInstance().setLevelJoueur2(levelCourant.getLabel());
                this.timer.stop();
                this.timer.setRaffraichissement(timerAppli.intValue());
                this.timer.start();
            }
        } catch (TechnicalException e)
        {
            log.error(e, e);
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Message permettant de recuperer le message de fin.<br/>
     * @return Recupere le message.<br/>
     */
    protected String recupereMessageFin(){
    	StringBuffer buffer = new StringBuffer();
    	
    	int score1 = AireJeu.getInstance().getScoreJoueur1();
    	int score2 = AireJeu.getInstance().getScoreJoueur2();
    	
    	if (score1 > score2){
    		buffer.append("Victoire du joueur1 face au joueur2 : ");
    		buffer.append(new Integer(score1).toString());
    		buffer.append(" - ");
    		buffer.append(new Integer (score2).toString());
    	}else if (score1 == score2){
    		buffer.append("Match nul entre le joueur1 et le joueur 2 : ");
       		buffer.append(new Integer(score1).toString());
    		buffer.append(" - ");
    		buffer.append(new Integer (score2).toString());
     	}else{
       		buffer.append("Victoire du joueur2 face au joueur1 : ");
    		buffer.append(new Integer(score2).toString());
    		buffer.append(" - ");
    		buffer.append(new Integer (score1).toString());
     	}
    	
    	return buffer.toString();	
    }

}
