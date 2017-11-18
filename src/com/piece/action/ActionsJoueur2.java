package com.piece.action;

import java.awt.event.KeyEvent;

import com.piece.aire.AireJeu;
import com.piece.aire.grille.ITable;
import com.piece.tetris.Piece;


/**
 * Classe permettant de gerer les actions du joueur 2.
 *
 */
public class ActionsJoueur2 extends DispatchActionJoueurs implements ActionJoueurs
{
    /**
     * Facade pour gerer les pieces.
     */
    private PieceFacade pieceFacade = null;
    
    public ActionsJoueur2(){
        pieceFacade = new PieceFacade();
    }

    public void deplacerBas()
    {
        ITable grilleJoueur2 = AireJeu.getInstance().getGrilleJoueur2();
        Piece pieceCourante2 = AireJeu.getInstance().getPieceCourantJoueur2();
        pieceFacade.deplacerBas(grilleJoueur2, pieceCourante2);   
    }

    public void deplacerDroite()
    {
        ITable grilleJoueur2 = AireJeu.getInstance().getGrilleJoueur2();
        Piece pieceCourante2 = AireJeu.getInstance().getPieceCourantJoueur2();
        pieceFacade.deplacerDroite(grilleJoueur2, pieceCourante2);   
    }

    public void deplacerGauche()
    {
        ITable grilleJoueur2 = AireJeu.getInstance().getGrilleJoueur2();
        Piece pieceCourante2 = AireJeu.getInstance().getPieceCourantJoueur2();
        pieceFacade.deplacerGauche(grilleJoueur2, pieceCourante2);  
        
    }

    public void rotation()
    {
        ITable grilleJoueur2 = AireJeu.getInstance().getGrilleJoueur2();
        Piece pieceCourante2 = AireJeu.getInstance().getPieceCourantJoueur2();
        pieceFacade.rotation(grilleJoueur2, pieceCourante2);  
    }

    public int getCodeDeplacementBas()
    {
        return KeyEvent.VK_DOWN;
    }

    public int getCodeDeplacementDroite()
    {
        return KeyEvent.VK_RIGHT;
    }

    public int getCodeDeplacementGauche()
    {
        return KeyEvent.VK_LEFT;
    }

    public int getCodeRotation()
    {
        return KeyEvent.VK_UP;
    }
    
    
  

}
