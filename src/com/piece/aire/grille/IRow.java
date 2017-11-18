package com.piece.aire.grille;

import java.awt.Graphics;
import java.util.Iterator;

import com.piece.exception.TechnicalException;

public interface IRow 
{
    /**
     * Methode permettant de creer une cellule dans la ligne.<br/>
     * @param cell La cellule a creer.<br/>
     */
    public void addCell(ICell cell);
    
    /**
     * Retourne le nombre de cellules du tableau.<br/>
     * @return Retourne le nombre de cellules du tableau.<br/>
     */
    public int getCellNumber();
    
    /**
     * Methode permettant de recuperer la cellule numero index
     * @param index Index.<br/>
     * @return Retourne la cellule numero index.<br/>
     */
    public ICell getCell(int index);
    
    /**
     * Methode permettant de fixer une cellule a l'index index.<br/>
     * @param index Index.<br/>
     * @param cell La cellule.<br/>
     */
    public void setCell(int index,ICell cell);
    
    /**
     * Methode permettant de recuperer l'iterateur.<br/>
     * @return Iterateur.<br/>
     */
    public Iterator iterator();
    
    /**
     * Methode permettant de tracer une ligne.<br/>
     * @param gc Graphics.<br/>
     */
    public void draw(Graphics gc);
    
    /**
     * Methode permettant de supprimer une ligne et de determiner si la ligne a ete supprimee.<br/>
     * @return Retourne vrai si la ligne a ete su
     * 
     */
    public boolean supprimeLigne();

}
