package com.piece.action.strategy;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.piece.aire.grille.ICell;
import com.piece.aire.grille.IRow;
import com.piece.aire.grille.ITable;
import com.piece.tetris.Piece;

public class CarreStrategy extends PieceStrategy
{
    
    private Log log = LogFactory.getLog(CarreStrategy.class);

    public boolean deplacerBasPosition1(ITable theGrille, Piece thePiece)
    {
        return this.deplacerBasCarre(theGrille, thePiece);
    }

    public boolean deplacerBasPosition2(ITable theGrille, Piece thePiece)
    {
        return this.deplacerBasCarre(theGrille, thePiece);
    }

    public boolean deplacerBasPosition3(ITable theGrille, Piece thePiece)
    {
        return this.deplacerBasCarre(theGrille, thePiece);
    }

    public boolean deplacerBasPosition4(ITable theGrille, Piece thePiece)
    {
        return this.deplacerBasCarre(theGrille, thePiece);
    }
    
    /**
     * Methode permettant de deplacer vers le bas cette piece.(Meme deplacement quelque soit la position).<br/>
     * @param theGrille Grille.<br/>
     * @param thePiece Piece.<br/>
     * @return Retourne vrai si on peut deplacer, faux sinon.<br/>
     */
    protected boolean deplacerBasCarre(ITable theGrille, Piece thePiece)
    {
        int nombreLignes = theGrille.getRowNumber();

        int indexNumeCellPosRefPiece = thePiece.getIndexCellulePositionRef();
        int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

        /**
         * On arrive au bout.
         */
        if (indexNumLigPosRefPiece + 2 >= nombreLignes)
        {
            thePiece.setBloque(true);
            return false;
        }

        ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumeCellPosRefPiece);
        if (cell1.estOccupe())
        {
            thePiece.setBloque(true);
            return false;
        }
        
        

        ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumeCellPosRefPiece + 1);
        if (cell2.estOccupe())
        {
            thePiece.setBloque(true);
            return false;
        }
        
       

        // Liberation de 2 cellules.
        theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece).fixeLibre();
        theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece + 1).fixeLibre();

        // Remplissage des 2 cellules.
        theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumeCellPosRefPiece).setOccupe(thePiece.getColor());
        theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumeCellPosRefPiece + 1).setOccupe(thePiece.getColor());

        // Deplacement de la piece.
        thePiece.setIndexLignePositionRef(thePiece.getIndexLignePositionRef()+1);
        
        return true;
    }

    public boolean deplacerDroitePosition1(ITable theGrille, Piece thePiece)
    {
        return this.deplacerDroiteCarre(theGrille, thePiece);
    }

    public boolean deplacerDroitePosition2(ITable theGrille, Piece thePiece)
    {
        return this.deplacerDroiteCarre(theGrille, thePiece);
    }

    public boolean deplacerDroitePosition3(ITable theGrille, Piece thePiece)
    {
        return this.deplacerDroiteCarre(theGrille, thePiece);
    }

    public boolean deplacerDroitePosition4(ITable theGrille, Piece thePiece)
    {
        return this.deplacerDroiteCarre(theGrille, thePiece);
    }
    
    /**
     * Methode permettant de deplacer a droite le carre.<br/>
     * @param theGrille La grille.<br/>
     * @param thePiece La piece.<br/>
     * @return Retourne vrai si on peut deplacer la piece, faux sinon.<br/>
     */
    protected boolean deplacerDroiteCarre(ITable theGrille, Piece thePiece){
        
        int indexNumeCellPosRefPiece = thePiece.getIndexCellulePositionRef();
        int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();
        
        IRow row = (IRow) theGrille.getRow(indexNumLigPosRefPiece);
        if (row != null){
            int nbCellule = row.getCellNumber();
            
            if ((indexNumeCellPosRefPiece + 2) < nbCellule ){
                ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece+2);
                ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece+1, indexNumeCellPosRefPiece+2);
                
                if ((cell1.estLibre()) && (cell2.estLibre())){
                    theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece).fixeLibre();
                    theGrille.getCell(indexNumLigPosRefPiece+1, indexNumeCellPosRefPiece).fixeLibre();
                    theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece+2).setOccupe(thePiece.getColor());
                    theGrille.getCell(indexNumLigPosRefPiece+1, indexNumeCellPosRefPiece+2).setOccupe(thePiece.getColor());
                    
                    //Deplacement de la piece.
                    thePiece.setIndexCellulePositionRef(thePiece.getIndexCellulePositionRef()+1);
                }
            }
        }
        
        
        
        return true;
        
    }

    public boolean deplacerGauchePosition1(ITable theGrille, Piece thePiece)
    {
        return this.deplacerGaucheCarre(theGrille,thePiece);
    }

    public boolean deplacerGauchePosition2(ITable theGrille, Piece thePiece)
    {
        return this.deplacerGaucheCarre(theGrille,thePiece);
    }

    public boolean deplacerGauchePosition3(ITable theGrille, Piece thePiece)
    {
        return this.deplacerGaucheCarre(theGrille,thePiece);
    }

    public boolean deplacerGauchePosition4(ITable theGrille, Piece thePiece)
    {
        return this.deplacerGaucheCarre(theGrille,thePiece);
    }
    
    protected boolean deplacerGaucheCarre(ITable theGrille, Piece thePiece){
        int indexNumeCellPosRefPiece = thePiece.getIndexCellulePositionRef();
        int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();
        
        //Si on est trop a gauche, one fait plusn rien.
        if (indexNumeCellPosRefPiece != 0){
            ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece-1);
            ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece+1, indexNumeCellPosRefPiece-1);
            
            if ((cell1.estLibre()) && (cell2.estLibre())){
                theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece+1).fixeLibre();
                theGrille.getCell(indexNumLigPosRefPiece+1, indexNumeCellPosRefPiece+1).fixeLibre();
                theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece-1).setOccupe(thePiece.getColor());
                theGrille.getCell(indexNumLigPosRefPiece+1, indexNumeCellPosRefPiece-1).setOccupe(thePiece.getColor());
                
                //Deplacement de la piece.
                thePiece.setIndexCellulePositionRef(thePiece.getIndexCellulePositionRef()-1);
            }
        }
        
        
        
        return true;
    }

    public boolean rotationPosition1(ITable theGrille, Piece thePiece)
    {
       return this.rotationCarre(theGrille,thePiece);
    }

    public boolean rotationPosition2(ITable theGrille, Piece thePiece)
    {
        return this.rotationCarre(theGrille,thePiece);
    }

    public boolean rotationPosition3(ITable theGrille, Piece thePiece)
    {
        return this.rotationCarre(theGrille,thePiece);
    }

    public boolean rotationPosition4(ITable theGrille, Piece thePiece)
    {
        return this.rotationCarre(theGrille,thePiece);
    }
    
    /**
     * Methode permettant de faire tourner le carre.<br/>
     * Le carre ne tourne pas.<br/>
     * @param theGrille La grille.<br/>
     * @param thePiece La piece.<br/>
     * @return Retourne vrai si le carre peut tourner, faux sinon.<br/>
     * Par convention, on retourne vrai dans ce cas.<br/>
     */
    protected boolean rotationCarre(ITable theGrille, Piece thePiece){
        thePiece.rotation();
        log.info(new StringBuffer().append("Position de la piece carre : ").append(thePiece.getPosition()).toString());
        return true;
    }
    

    public boolean afficherInitialPiece(ITable theGrille, Piece thePiece)
    {
        int indexCelPosRef = thePiece.getIndexCellulePositionRef();
        int indexLigPosRef = thePiece.getIndexLignePositionRef();
        
        
        boolean affiche = this.affiche(theGrille, thePiece);
        
        if (affiche){
            theGrille.getCell(indexLigPosRef, indexCelPosRef).setOccupe(thePiece.getColor());
            theGrille.getCell(indexLigPosRef+1, indexCelPosRef).setOccupe(thePiece.getColor());
            theGrille.getCell(indexLigPosRef, indexCelPosRef+1).setOccupe(thePiece.getColor());
            theGrille.getCell(indexLigPosRef+1, indexCelPosRef+1).setOccupe(thePiece.getColor());
        }
        
        return affiche;
    }
    
    protected boolean affiche(ITable theGrille, Piece thePiece){
        int indexCelPosRef = thePiece.getIndexCellulePositionRef();
        int indexLigPosRef = thePiece.getIndexLignePositionRef();
        
        if (theGrille.getCell(indexLigPosRef, indexCelPosRef).estOccupe()){
            return false;
        }
        
        if (theGrille.getCell(indexLigPosRef+1, indexCelPosRef).estOccupe()){
            return false;
        }
        
        if (theGrille.getCell(indexLigPosRef, indexCelPosRef+1).estOccupe()){
            return false;
        }
        
        if (theGrille.getCell(indexLigPosRef+1, indexCelPosRef+1).estOccupe()){
            return false;
        }
        
       
       return true;
    }

}
