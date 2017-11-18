package com.piece.action;

import java.util.HashMap;
import java.util.Map;

import com.piece.action.strategy.BarreHorizontaleStrategy;
import com.piece.action.strategy.CarreStrategy;
import com.piece.action.strategy.ConstanteStrategy;
import com.piece.action.strategy.PieTStrategy;
import com.piece.action.strategy.PieceStrategy;
import com.piece.action.strategy.PieceZInverseStrategy;
import com.piece.action.strategy.PieceZStrategy;
import com.piece.action.strategy.PistoletDroitStrategy;
import com.piece.action.strategy.PistoletGaucheStrategy;
import com.piece.aire.grille.ITable;
import com.piece.tetris.BarreHorizontale;
import com.piece.tetris.Carre;
import com.piece.tetris.PieT;
import com.piece.tetris.Piece;
import com.piece.tetris.PieceInverseZ;
import com.piece.tetris.PieceZ;
import com.piece.tetris.PistoletDroit;
import com.piece.tetris.PistoletGauche;

/**
 * Facade permettant le deplacement des objets.<br/>
 * 
 */
public class PieceFacade
{
    /**
     * Stocke l'ensemble des map contenant les strategies.<br/>
     */
    private transient Map mapStrategy;

    public PieceFacade()
    {
        this.initAllStrategy();
    }

    /**
     * Methode permettant de deplacer a gauche la piece dans la grille.<br/>
     * 
     * @param table Grille.<br/>
     * @param piece Piece.<br/>
     * @return Retourne vrai si la piece a pu se deplacer, faux sinon.<br/>
     */
    public boolean deplacerGauche(ITable table, Piece piece)
    {

        // Recupere la bonne strategy
        PieceStrategy strategy = getStrategy(piece);

        // Deplace la piece
        return strategy.deplacerGauche(table, piece);
    }

    /**
     * Methode permettant de deplacer a droite la piece dans la grille.<br/>
     * 
     * @param table Grille.<br/>
     * @param piece Piece.<br/>
     * @return Retourne vrai si la piece a pu se deplacer, faux sinon.<br/>
     */
    public boolean deplacerDroite(ITable table, Piece piece)
    {
        PieceStrategy strategy = getStrategy(piece); 
        return strategy.deplacerDroite(table, piece);
    }

    /**
     * Methode permettant de deplacer en bas la piece dans la grille.<br/>
     * 
     * @param table Grille.<br/>
     * @param piece Piece.<br/>
     * @return Retourne vrai si la piece a pu se deplacer, faux sinon.<br/>
     */
    public boolean deplacerBas(ITable table, Piece piece)
    {
        PieceStrategy strategy = getStrategy(piece);
        return strategy.deplacerBas(table, piece);
    }

    /**
     * Methode permettant de faire la rotation dans la grille.<br/>
     * 
     * @param table Grille.<br/>
     * @param piece Piece.<br/>
     * @return Retourne vrai si la piece a pu se deplacer, faux sinon.<br/>
     */
    public boolean rotation(ITable table, Piece piece)
    {
        PieceStrategy strategy = getStrategy(piece);
        return strategy.rotation(table, piece);
    }

    /**
     * Methode permettant d'afficher la piece en position initiale.<br/>
     * @param grille La grille.<br/>
     * @param piece La piece.<br/>
     * @return Retourne vrai s'il n'y a pas eu une collision, faux sinon.<br/>
     */
    public boolean afficherPiece(ITable grille, Piece piece)
    {
        PieceStrategy strategy = getStrategy(piece);
        return strategy.afficherInitialPiece(grille, piece);
    }

    /**
     * Methode permettant de stocker l'ensemble des strategies.<br/>
     * 
     */
    public void initAllStrategy()
    {
        mapStrategy = new HashMap();
        mapStrategy.put(ConstanteStrategy.CARRE_STRATEGY, new CarreStrategy());
        mapStrategy.put(ConstanteStrategy.BARRE_HOR_STRATEGY, new BarreHorizontaleStrategy());
        mapStrategy.put(ConstanteStrategy.PIET_STRATEGY, new PieTStrategy());
        mapStrategy.put(ConstanteStrategy.PISTOLET_DROIT_STRATEGY, new PistoletDroitStrategy());
        mapStrategy.put(ConstanteStrategy.PISTOLET_GAUCHE_STRATEGY, new PistoletGaucheStrategy());
        mapStrategy.put(ConstanteStrategy.PIECEZ_STRATEGY, new PieceZStrategy());
        mapStrategy.put(ConstanteStrategy.PIECEINVERSEZ_STRATEGY,new PieceZInverseStrategy());

        
        // TODO : Put your code here
    }

    /**
     * Methode permettant de recuperer la bonne strategie.<br/>
     * 
     * @param piece Piece.<br/>
     * @return Retourne la bonne strategie.<br/>
     */
    public PieceStrategy getStrategy(Piece piece)
    {
        String constanteStrategy = "";

        if (piece instanceof Carre)
        {
            constanteStrategy = ConstanteStrategy.CARRE_STRATEGY;

        }

        else if (piece instanceof BarreHorizontale)
        {
            constanteStrategy = ConstanteStrategy.BARRE_HOR_STRATEGY;
        }
        
        else if (piece instanceof PieT){
        	constanteStrategy = ConstanteStrategy.PIET_STRATEGY;
        }
        
        else if (piece instanceof PistoletDroit){
            constanteStrategy = ConstanteStrategy.PISTOLET_DROIT_STRATEGY;	
        }
        
        else if (piece instanceof PistoletGauche){
        	constanteStrategy = ConstanteStrategy.PISTOLET_GAUCHE_STRATEGY;
        }
        
        else if (piece instanceof PieceZ){
           	constanteStrategy = ConstanteStrategy.PIECEZ_STRATEGY;
        }
        
        else if (piece instanceof PieceInverseZ){
        	constanteStrategy = ConstanteStrategy.PIECEINVERSEZ_STRATEGY;
        }
        
        return (PieceStrategy) mapStrategy.get(constanteStrategy);
    }

}
