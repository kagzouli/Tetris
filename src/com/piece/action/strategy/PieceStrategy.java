package com.piece.action.strategy;

import com.piece.aire.grille.ITable;
import com.piece.tetris.Piece;

public abstract class PieceStrategy
{
    /**
     * Methode permettant de deplacer a gauche la piece dans la grille.<br/>
     * 
     * @param table Grille.<br/>
     * @param piece Piece.<br/>
     * @return Retourne vrai si la piece a pu se deplacer, faux sinon.<br/>
     */
    public boolean deplacerGauche(ITable table, Piece piece)
    {
        boolean nonDeplace = false;
        if (!piece.isBloque())
        {

            int positionPiece = piece.getPosition();

            switch (positionPiece)
            {
            case 1:
                nonDeplace = this.deplacerGauchePosition1(table, piece);
                break;
            case 2:
                nonDeplace = this.deplacerGauchePosition2(table, piece);
                break;
            case 3:
                nonDeplace = this.deplacerGauchePosition3(table, piece);
                break;
            case 4:
                nonDeplace = this.deplacerGauchePosition4(table, piece);
                break;
            }
        }
        return nonDeplace;

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
        boolean nonDeplace = false;
        if (!piece.isBloque())
        {
            int positionPiece = piece.getPosition();

            switch (positionPiece)
            {
            case 1:
                nonDeplace = this.deplacerDroitePosition1(table, piece);
                break;
            case 2:
                nonDeplace = this.deplacerDroitePosition2(table, piece);
                break;
            case 3:
                nonDeplace = this.deplacerDroitePosition3(table, piece);
                break;
            case 4:
                nonDeplace = this.deplacerDroitePosition4(table, piece);
                break;
            }
        }

        return nonDeplace;
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
        boolean nonDeplace = false;

        if (!piece.isBloque())
        {
            int positionPiece = piece.getPosition();

            switch (positionPiece)
            {
            case 1:
                nonDeplace = this.deplacerBasPosition1(table, piece);
                break;
            case 2:
                nonDeplace = this.deplacerBasPosition2(table, piece);
                break;
            case 3:
                nonDeplace = this.deplacerBasPosition3(table, piece);
                break;
            case 4:
                nonDeplace = this.deplacerBasPosition4(table, piece);
                break;
            }
        }

        return nonDeplace;
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
        boolean nonDeplace = false;

        if (!piece.isBloque())
        {
            int positionPiece = piece.getPosition();

            switch (positionPiece)
            {
            case 1:
                nonDeplace = this.rotationPosition1(table, piece);
                break;
            case 2:
                nonDeplace = this.rotationPosition2(table, piece);
                break;
            case 3:
                nonDeplace = this.rotationPosition3(table, piece);
                break;
            case 4:
                nonDeplace = this.rotationPosition4(table, piece);
                break;
            }
        }

        return nonDeplace;
    }

    /**
     * Methode permettant de deplacer a gauche dans la position 1.
     * 
     * @param grille Grille.<br/>
     * @param piece Piece.<br/>
     * @return Retourne vrai si la piece a pu se deplacer, faux sinon.<br/>
     */
    public abstract boolean deplacerGauchePosition1(ITable grille, Piece piece);

    /**
     * Methode permettant de deplacer a droite dans la position 1.
     * 
     * @param grille Grille.<br/>
     * @param piece Piece.<br/>
     * @return Retourne vrai si la piece a pu se deplacer, faux sinon.<br/>
     */
    public abstract boolean deplacerDroitePosition1(ITable grille, Piece piece);

    /**
     * Methode permettant de deplacer a droite dans la position 1.
     * 
     * @param grille Grille.<br/>
     * @param piece Piece.<br/>
     * @return Retourne vrai si la piece a pu se deplacer, faux sinon.<br/>
     */
    public abstract boolean deplacerBasPosition1(ITable grille, Piece piece);

    /**
     * Methode permettant de deplacer a gauche dans la position 2.
     * 
     * @param grille Grille.<br/>
     * @param piece Piece.<br/>
     * @return Retourne vrai si la piece a pu se deplacer, faux sinon.<br/>
     */
    public abstract boolean deplacerGauchePosition2(ITable grille, Piece piece);

    /**
     * Methode permettant de deplacer a droite dans la position 2.
     * 
     * @param grille Grille.<br/>
     * @param piece Piece.<br/>
     * @return Retourne vrai si la piece a pu se deplacer, faux sinon.<br/>
     */
    public abstract boolean deplacerDroitePosition2(ITable grille, Piece piece);

    /**
     * Methode permettant de deplacer a droite dans la position 2.
     * 
     * @param grille Grille.<br/>
     * @param piece Piece.<br/>
     * @return Retourne vrai si la piece a pu se deplacer, faux sinon.<br/>
     */
    public abstract boolean deplacerBasPosition2(ITable grille, Piece piece);

    /**
     * Methode permettant de deplacer a gauche dans la position 3.
     * 
     * @param grille Grille.<br/>
     * @param piece Piece.<br/>
     * @return Retourne vrai si la piece a pu se deplacer, faux sinon.<br/>
     */
    public abstract boolean deplacerGauchePosition3(ITable grille, Piece piece);

    /**
     * Methode permettant de deplacer a droite dans la position 3.
     * 
     * @param grille Grille.<br/>
     * @param piece Piece.<br/>
     * @return Retourne vrai si la piece a pu se deplacer, faux sinon.<br/>
     */
    public abstract boolean deplacerDroitePosition3(ITable grille, Piece piece);

    /**
     * Methode permettant de deplacer a droite dans la position 3.
     * 
     * @param grille Grille.<br/>
     * @param piece Piece.<br/>
     * @return Retourne vrai si la piece a pu se deplacer, faux sinon.<br/>
     */
    public abstract boolean deplacerBasPosition3(ITable grille, Piece piece);

    /**
     * Methode permettant de deplacer a gauche dans la position 4.
     * 
     * @param grille Grille.<br/>
     * @param piece Piece.<br/>
     * @return Retourne vrai si la piece a pu se deplacer, faux sinon.<br/>
     */
    public abstract boolean deplacerGauchePosition4(ITable grille, Piece piece);

    /**
     * Methode permettant de deplacer a droite dans la position 4.
     * 
     * @param grille Grille.<br/>
     * @param piece Piece.<br/>
     * @return Retourne vrai si la piece a pu se deplacer, faux sinon.<br/>
     */
    public abstract boolean deplacerDroitePosition4(ITable grille, Piece piece);

    /**
     * Methode permettant de deplacer a droite dans la position 4.
     * 
     * @param grille Grille.<br/>
     * @param piece Piece.<br/>
     * @return Retourne vrai si la piece a pu se deplacer, faux sinon.<br/>
     */
    public abstract boolean deplacerBasPosition4(ITable grille, Piece piece);

    /**
     * Methode permettant de faire une rotation sur la position1.<br/>
     * 
     * @param grille Grille.<br/>
     * @param piece Piece.<br/>
     * @return Retourne la rotation sur la position1.<br/>
     */
    public abstract boolean rotationPosition1(ITable grille, Piece piece);

    /**
     * Methode permettant de faire une rotation sur la position2.<br/>
     * 
     * @param grille Grille.<br/>
     * @param piece Piece.<br/>
     * @return Retourne la rotation sur la position2.<br/>
     */
    public abstract boolean rotationPosition2(ITable grille, Piece piece);

    /**
     * Methode permettant de faire une rotation sur la position3.<br/>
     * 
     * @param grille Grille.<br/>
     * @param piece Piece.<br/>
     * @return Retourne la rotation sur la position3.<br/>
     */
    public abstract boolean rotationPosition3(ITable grille, Piece piece);

    /**
     * Methode permettant de faire une rotation sur la position4.<br/>
     * 
     * @param grille Grille.<br/>
     * @param piece Piece.<br/>
     * @return Retourne la rotation sur la position4.<br/>
     */
    public abstract boolean rotationPosition4(ITable grille, Piece piece);

    /**
     * Methode permettant d'afficher la piece en position initial.<br/>
     * 
     * @param grille La grille.<br/>
     * @param piece La piece.<br/>
     * @return Retourne vrai s'il y'a eu une collision, faux sinon.<br/>
     */
    public abstract boolean afficherInitialPiece(ITable grille, Piece piece);

}
