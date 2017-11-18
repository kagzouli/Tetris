package com.piece.action.strategy;

import com.piece.aire.grille.ICell;
import com.piece.aire.grille.IRow;
import com.piece.aire.grille.ITable;
import com.piece.tetris.Piece;

public class BarreHorizontaleStrategy extends PieceStrategy
{

    public boolean deplacerBasPosition1(ITable theGrille, Piece thePiece)
    {
        return this.deplacerBasBarrePos1Pos3(theGrille, thePiece);
    }

    public boolean deplacerBasPosition2(ITable theGrille, Piece thePiece)
    {
        return this.deplacerBasBarrePos2Pos4(theGrille, thePiece);
    }

    public boolean deplacerBasPosition3(ITable theGrille, Piece thePiece)
    {
        return this.deplacerBasBarrePos1Pos3(theGrille, thePiece);
    }

    public boolean deplacerBasPosition4(ITable theGrille, Piece thePiece)
    {
        return this.deplacerBasBarrePos2Pos4(theGrille, thePiece);
    }

    /**
     * Methode permettant de deplacer vers le bas pour la position1 et 3.<br/>
     * 
     * @param theGrille La grille.<br/>
     * @param thePiece La piece.<br/>
     * @return Retourne vrai si on peut deplacer la piece, faux sinon.<br/>
     */
    protected boolean deplacerBasBarrePos1Pos3(ITable theGrille, Piece thePiece)
    {
        int nombreLignes = theGrille.getRowNumber();

        int indexNumCellPosRefPiece = thePiece.getIndexCellulePositionRef();
        int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

        /**
         * On arrive au bout.
         */
        if (indexNumLigPosRefPiece + 4 >= nombreLignes)
        {
            thePiece.setBloque(true);
            return false;
           
        }

        ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece + 4, indexNumCellPosRefPiece);
        if (cell1.estOccupe())
        {
            thePiece.setBloque(true);
            return false;
        }

        // Liberation de 1 cellules.
        theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece).fixeLibre();

        // Remplissage de 1 cellules
        theGrille.getCell(indexNumLigPosRefPiece + 4, indexNumCellPosRefPiece).setOccupe(thePiece.getColor());

        // Deplacement de la piece.
        thePiece.setIndexLignePositionRef(thePiece.getIndexLignePositionRef() + 1);

        return true;
    }

    /**
     * Methode permettant de deplacer vers le bas pour la position2 et 4.<br/>
     * 
     * @param theGrille La grille.<br/>
     * @param thePiece La piece.<br/>
     * @return Retourne vrai si on peut deplacer la piece, faux sinon.<br/>
     */
    protected boolean deplacerBasBarrePos2Pos4(ITable theGrille, Piece thePiece)
    {
        int indexNumCellPosRefPiece = thePiece.getIndexCellulePositionRef();
        int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

        int nombreLignes = theGrille.getRowNumber();

        /**
         * On arrive au bout.
         */
        if (indexNumLigPosRefPiece + 1 >= nombreLignes)
        {
            thePiece.setBloque(true);
            return false;
        }

        ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece);
        if (cell1.estOccupe())
        {
            thePiece.setBloque(true);
            return false;
        }

        ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece + 1);
        if (cell2.estOccupe())
        {
            thePiece.setBloque(true);
            return false;
        }

        ICell cell3 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece + 2);
        if (cell3.estOccupe())
        {
            thePiece.setBloque(true);
            return false;
        }

        ICell cell4 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece + 3);
        if (cell4.estOccupe())
        {
            thePiece.setBloque(true);
            return false;
        }

        // Liberation de 4 cellules.
        theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece).fixeLibre();
        theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece + 1).fixeLibre();
        theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece + 2).fixeLibre();
        theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece + 3).fixeLibre();

        // Remplissage de 4 cellules.
        theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece).setOccupe(thePiece.getColor());
        theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece + 1).setOccupe(thePiece.getColor());
        theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece + 2).setOccupe(thePiece.getColor());
        theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece + 3).setOccupe(thePiece.getColor());

        // Deplacement du centre de la piece.
        thePiece.setIndexLignePositionRef(indexNumLigPosRefPiece + 1);

        return true;
    }

    public boolean deplacerDroitePosition1(ITable theGrille, Piece thePiece)
    {
        return this.deplacerDroitePos1Pos3(theGrille, thePiece);
    }

    public boolean deplacerDroitePosition2(ITable theGrille, Piece thePiece)
    {
        return this.deplacerDroitePos2Pos4(theGrille, thePiece);
    }

    public boolean deplacerDroitePosition3(ITable theGrille, Piece thePiece)
    {
        return this.deplacerDroitePos1Pos3(theGrille, thePiece);
    }

    public boolean deplacerDroitePosition4(ITable theGrille, Piece thePiece)
    {
        return this.deplacerDroitePos2Pos4(theGrille, thePiece);
    }

    /**
     * Methode permettant de deplacer la barre dans la position 1 et position 3.<br/>
     * 
     * @param theGrille La grille.<br/>
     * @param thePiece La piece.<br/>
     * @return Retourne vrai si on peut deplacer la barre, faux sinon.<br/>
     */
    protected boolean deplacerDroitePos1Pos3(ITable theGrille, Piece thePiece)
    {
        int indexNumCellPosRefPiece = thePiece.getIndexCellulePositionRef();
        int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

        IRow row = (IRow) theGrille.getRow(indexNumLigPosRefPiece);
        if (row != null)
        {
            int nbCellule = row.getCellNumber();

            if ((indexNumCellPosRefPiece + 1) < nbCellule)
            {
                ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece + 1);
                ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece + 1);
                ICell cell3 = theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumCellPosRefPiece + 1);
                ICell cell4 = theGrille.getCell(indexNumLigPosRefPiece + 3, indexNumCellPosRefPiece + 1);

                if ((cell1.estLibre()) && (cell2.estLibre()) && (cell3.estLibre()) && (cell4.estLibre()))
                {
                    // Libere les cellules
                    theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece).fixeLibre();
                    theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece).fixeLibre();
                    theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumCellPosRefPiece).fixeLibre();
                    theGrille.getCell(indexNumLigPosRefPiece + 3, indexNumCellPosRefPiece).fixeLibre();

                    // Remplit les cellules
                    theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece + 1).setOccupe(thePiece.getColor());
                    theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece + 1).setOccupe(thePiece.getColor());
                    theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumCellPosRefPiece + 1).setOccupe(thePiece.getColor());
                    theGrille.getCell(indexNumLigPosRefPiece + 3, indexNumCellPosRefPiece + 1).setOccupe(thePiece.getColor());

                    // Deplacement de la piece.
                    thePiece.setIndexCellulePositionRef(thePiece.getIndexCellulePositionRef() + 1);
                }
            }
        }
        return true;
    }

    protected boolean deplacerDroitePos2Pos4(ITable theGrille, Piece thePiece)
    {
        int indexNumCellPosRefPiece = thePiece.getIndexCellulePositionRef();
        int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

        IRow row = (IRow) theGrille.getRow(indexNumLigPosRefPiece);
        if (row != null)
        {
            int nbCellule = row.getCellNumber();

            if ((indexNumCellPosRefPiece + 4) < nbCellule)
            {
                ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece + 4);

                if (cell1.estLibre())
                {
                    // Libere les cellules
                    theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece).fixeLibre();

                    // Remplit les cellules
                    theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece + 4).setOccupe(thePiece.getColor());

                    // Deplacement de la piece.
                    thePiece.setIndexCellulePositionRef(thePiece.getIndexCellulePositionRef() + 1);
                }
            }
        }
        return true;
    }

    public boolean deplacerGauchePosition1(ITable theGrille, Piece thePiece)
    {
        return this.deplacerGauchePos1Pos3(theGrille, thePiece);
    }

    public boolean deplacerGauchePosition2(ITable theGrille, Piece thePiece)
    {
        return this.deplacerGauchePos2Pos4(theGrille, thePiece);
    }

    public boolean deplacerGauchePosition3(ITable theGrille, Piece thePiece)
    {
        return this.deplacerGauchePos1Pos3(theGrille, thePiece);
    }

    public boolean deplacerGauchePosition4(ITable theGrille, Piece thePiece)
    {
        return this.deplacerGauchePos2Pos4(theGrille, thePiece);
    }

    /**
     * Methode permettant de deplacer la piece dans la position 1 et 3.<br/>
     * @param theGrille La grille.<br/>
     * @param thePiece La piece.<br/>
     * @return Retourne vrai si pas collision, faux sinon.<br/>
     */
    protected boolean deplacerGauchePos1Pos3(ITable theGrille, Piece thePiece)
    {
        int indexNumCellPosRefPiece = thePiece.getIndexCellulePositionRef();
        int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

        if (indexNumCellPosRefPiece < 1)
        {
            return true;
        }

        // Test les cellules.
        ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece - 1);
        if (cell1.estOccupe())
        {
            return true;
        }

        ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece - 1);
        if (cell2.estOccupe())
        {
            return true;
        }

        ICell cell3 = theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumCellPosRefPiece - 1);
        if (cell3.estOccupe())
        {
            return true;
        }

        ICell cell4 = theGrille.getCell(indexNumLigPosRefPiece + 3, indexNumCellPosRefPiece - 1);
        if (cell4.estOccupe())
        {
            return true;
        }

        // Libere les cellules
        theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece).fixeLibre();
        theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece).fixeLibre();
        theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumCellPosRefPiece).fixeLibre();
        theGrille.getCell(indexNumLigPosRefPiece + 3, indexNumCellPosRefPiece).fixeLibre();

        // Remplit les cellules
        theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece - 1).setOccupe(thePiece.getColor());
        theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece - 1).setOccupe(thePiece.getColor());
        theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumCellPosRefPiece - 1).setOccupe(thePiece.getColor());
        theGrille.getCell(indexNumLigPosRefPiece + 3, indexNumCellPosRefPiece - 1).setOccupe(thePiece.getColor());

        // Deplacement de la piece.
        thePiece.setIndexCellulePositionRef(thePiece.getIndexCellulePositionRef() - 1);

        return true;
    }
    
    /**
     * Methode permettant de deplacer la piece dans la position 2 et 4.<br/>
     * @param theGrille La grille.<br/>
     * @param thePiece La piece.<br/>
     * @return Retourne vrai si pas collision, faux sinon.<br/>
     */
    protected boolean deplacerGauchePos2Pos4(ITable theGrille, Piece thePiece){
        int indexNumCellPosRefPiece = thePiece.getIndexCellulePositionRef();
        int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

        if (indexNumCellPosRefPiece < 1)
        {
            return true;
        }

        // Test les cellules.
        ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece - 1);
        if (cell1.estOccupe())
        {
            return true;
        }
        
        // Libere les cellules
        theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece+3).fixeLibre();
        
        // Remplit les cellules
        theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece - 1).setOccupe(thePiece.getColor());
 
        // Deplacement de la piece.
        thePiece.setIndexCellulePositionRef(thePiece.getIndexCellulePositionRef() - 1);

        return true;

    }

    public boolean rotationPosition1(ITable theGrille, Piece thePiece)
    {
        return this.rotationPos1Pos3(theGrille, thePiece);
    }

    public boolean rotationPosition2(ITable theGrille, Piece thePiece)
    {
        return this.rotationPos2Pos4(theGrille, thePiece);
    }

    public boolean rotationPosition3(ITable theGrille, Piece thePiece)
    {
        return this.rotationPos1Pos3(theGrille, thePiece);
    }

    public boolean rotationPosition4(ITable theGrille, Piece thePiece)
    {
        return this.rotationPos2Pos4(theGrille, thePiece);
    }

    /**
     * Methode permettant de faire la rotation pour les positions 1 et 3.<br/>
     * 
     * @param theGrille La grille.<br/>
     * @param thePiece La piece.<br/>
     * @return Retourne vrai s'il y'a pas eu collision, faux sinon.<br/>
     */
    protected boolean rotationPos1Pos3(ITable theGrille, Piece thePiece)
    {
        int indexNumCellPosRefPiece = thePiece.getIndexCellulePositionRef();
        int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

        // Si l'index de la cellule est 3, pas de rotation.
        if (indexNumCellPosRefPiece < 2)
        {
            return false;
        }
        
        IRow row1 = theGrille.getRow(indexNumLigPosRefPiece);
        int nbCellule = row1.getCellNumber();
        
        if (nbCellule<= indexNumCellPosRefPiece+2){
            return false;
        }

        ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece - 1);
        if (cell1.estOccupe())
        {
            return false;
        }

        ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece + 1);
        if (cell2.estOccupe())
        {
            return false;
        }

        ICell cell3 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece + 2);
        if (cell3.estOccupe())
        {
            return false;
        }

        // Liberation de 4 cellules.
        theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece).fixeLibre();
        theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumCellPosRefPiece).fixeLibre();
        theGrille.getCell(indexNumLigPosRefPiece + 3, indexNumCellPosRefPiece).fixeLibre();

        // Remplissage de 4 cellules.
        theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece - 1).setOccupe(thePiece.getColor());
        theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece + 1).setOccupe(thePiece.getColor());
        theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece + 2).setOccupe(thePiece.getColor());

        // Deplacement du centre de la piece.
        thePiece.setIndexCellulePositionRef(indexNumCellPosRefPiece - 1);
        thePiece.setIndexLignePositionRef(indexNumLigPosRefPiece + 1);

        // Rotation de la piece.
        thePiece.rotation();

        return true;
    }

    /**
     * Methode permettant de faire la rotation pour les positions 2 et 4.<br/>
     * 
     * @param theGrille La grille.<br/>
     * @param thePiece La piece.<br/>
     * @return Retourne vrai s'il y'a pas eu collision, faux sinon.<br/>
     */
    protected boolean rotationPos2Pos4(ITable theGrille, Piece thePiece)
    {
        int indexNumCellPosRefPiece = thePiece.getIndexCellulePositionRef();
        int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();
        int nbLigne = theGrille.getRowNumber();

        // Si l'index de la ligne est inferieur a 1
        if ((indexNumLigPosRefPiece < 1) || (indexNumLigPosRefPiece + 2 >= nbLigne))
        {
            return false;
        }

        ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumCellPosRefPiece + 1);
        if (cell1.estOccupe())
        {
            return false;
        }

        ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece + 1);
        if (cell2.estOccupe())
        {
            return false;
        }

        ICell cell3 = theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumCellPosRefPiece + 1);
        if (cell3.estOccupe())
        {
            return false;
        }

        // Liberation de 3 cellules.
        theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece).fixeLibre();
        theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece + 2).fixeLibre();
        theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece + 3).fixeLibre();

        // Remplissage de 3 cellules.
        theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumCellPosRefPiece + 1).setOccupe(thePiece.getColor());
        theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece + 1).setOccupe(thePiece.getColor());
        theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumCellPosRefPiece + 1).setOccupe(thePiece.getColor());

        // Deplacement du centre de la piece.
        thePiece.setIndexCellulePositionRef(indexNumCellPosRefPiece + 1);
        thePiece.setIndexLignePositionRef(indexNumLigPosRefPiece - 1);

        // Rotation de la piece.
        thePiece.rotation();

        return true;
    }

    public boolean afficherInitialPiece(ITable theGrille, Piece thePiece)
    {
        int indexCelPosRef = thePiece.getIndexCellulePositionRef();
        int indexLigPosRef = thePiece.getIndexLignePositionRef();

        boolean collision = this.affiche(theGrille, thePiece);
        if (collision)
        {
            theGrille.getCell(indexLigPosRef, indexCelPosRef).setOccupe(thePiece.getColor());
            theGrille.getCell(indexLigPosRef + 1, indexCelPosRef).setOccupe(thePiece.getColor());
            theGrille.getCell(indexLigPosRef + 2, indexCelPosRef).setOccupe(thePiece.getColor());
            theGrille.getCell(indexLigPosRef + 3, indexCelPosRef).setOccupe(thePiece.getColor());
        }
        return collision;
    }

    protected boolean affiche(ITable theGrille, Piece thePiece)
    {
        int indexCelPosRef = thePiece.getIndexCellulePositionRef();
        int indexLigPosRef = thePiece.getIndexLignePositionRef();

        if (theGrille.getCell(indexLigPosRef, indexCelPosRef).estOccupe())
        {
            return false;
        }

        if (theGrille.getCell(indexLigPosRef + 1, indexCelPosRef).estOccupe())
        {
            return false;
        }

        if (theGrille.getCell(indexLigPosRef + 2, indexCelPosRef).estOccupe())
        {
            return false;
        }

        if (theGrille.getCell(indexLigPosRef + 3, indexCelPosRef).estOccupe())
        {
            return false;
        }

        return true;

    }

}
