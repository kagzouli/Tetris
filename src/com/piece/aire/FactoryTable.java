package com.piece.aire;

import com.piece.aire.grille.CellImpl;
import com.piece.aire.grille.ICell;
import com.piece.aire.grille.IRow;
import com.piece.aire.grille.ITable;
import com.piece.aire.grille.RowImpl;
import com.piece.aire.grille.TableImpl;
import com.piece.exception.TechnicalException;

public final class FactoryTable
{
    
    private static final int TAILLE = 35;
    
   /**
    * 
   * {@inheritDoc}
    */
    public static ITable creerTable(int posIniX,int posInitY,int nbrLignes,int nbrCellules){
        ITable table = new TableImpl();
        
        int posX = posIniX;
        int posY = posInitY;
        for (int indxCol = 0;indxCol < nbrLignes;indxCol++){
            IRow row = createRow(posX,posY,nbrCellules);
            table.addRow(row);
            posY = posY + TAILLE;
        }
        
        
        return table;
    }
    
    /**
     * Factory permettant de creer les lignes.<br/>
     * @param posInitX Position initialeX
     * @param posInitY position initialeY.
     * @param nbrLignes Nbr cellules pour la ligne.<br/>
     * @return Retourne la ligne ainsi cree.<br/>
     */
    private static IRow createRow(int posInitX,int posInitY,int nbrCellules){
        IRow row = new RowImpl();
        
        int posX = posInitX;
        int posY = posInitY;
        for (int indxCell = 0;indxCell < nbrCellules;indxCell++){
            ICell cell = new CellImpl();
            
            //La cellule est vide.
            cell.fixeLibre();
            
            //Position de la cellule.
            cell.setPosX(posX);
            cell.setPosY(posY);
            cell.setLongueur(TAILLE);
            cell.setLargeur(TAILLE);
            
            row.addCell(cell);
            posX = posX + TAILLE;
        }
        
        return row;
    }

}
