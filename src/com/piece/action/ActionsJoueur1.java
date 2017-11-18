package com.piece.action;

import java.awt.event.KeyEvent;

import com.piece.aire.AireJeu;
import com.piece.aire.grille.ITable;
import com.piece.tetris.Piece;

/**
 * Classe permettant de gerer les actions du joueur 1.
 * 
 */
public class ActionsJoueur1 extends DispatchActionJoueurs implements ActionJoueurs
{
    /**
     * Facade pour gerer les pieces.
     */
    private PieceFacade pieceFacade = null;

    public ActionsJoueur1()
    {
        pieceFacade = new PieceFacade();
    }

    public void deplacerBas()
    {
        ITable grilleJoueur1 = AireJeu.getInstance().getGrilleJoueur1();
        Piece pieceCourante1 = AireJeu.getInstance().getPieceCourantJoueur1();
        pieceFacade.deplacerBas(grilleJoueur1, pieceCourante1);
    }

    public void deplacerDroite()
    {
        ITable grilleJoueur1 = AireJeu.getInstance().getGrilleJoueur1();
        Piece pieceCourante1 = AireJeu.getInstance().getPieceCourantJoueur1();
        pieceFacade.deplacerDroite(grilleJoueur1, pieceCourante1);
    }

    public void deplacerGauche()
    {
        ITable grilleJoueur1 = AireJeu.getInstance().getGrilleJoueur1();
        Piece pieceCourante1 = AireJeu.getInstance().getPieceCourantJoueur1();
        pieceFacade.deplacerGauche(grilleJoueur1, pieceCourante1);
    }

    public void rotation()
    {
        ITable grilleJoueur1 = AireJeu.getInstance().getGrilleJoueur1();
        Piece pieceCourante1 = AireJeu.getInstance().getPieceCourantJoueur1();
        pieceFacade.rotation(grilleJoueur1, pieceCourante1);
    }

    public int getCodeDeplacementBas()
    {
        return KeyEvent.VK_X;
    }

    public int getCodeDeplacementDroite()
    {
        return KeyEvent.VK_F;
    }

    public int getCodeDeplacementGauche()
    {
        return KeyEvent.VK_S;
    }

    public int getCodeRotation()
    {
        return KeyEvent.VK_D;
    }

}
