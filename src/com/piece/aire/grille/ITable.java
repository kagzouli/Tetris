package com.piece.aire.grille;

import java.awt.Graphics;
import java.util.Iterator;


public interface ITable
{
    
    /**
     * Methode permettant de creer une ligne dans le tableau.<br/>
     * @param row La ligne a creer.<br/>
     */
    public void addRow(IRow row);
    
    /**
     * Retourne le nombre de lignes du tableau.<br/>
     * @return Retourne le nombre de lignes du tableau.<br/>
     */
    public int getRowNumber();
    
    /**
     * Methode permettant de recuperer la ligne numero index
     * @param index Index.<br/>
     * @return Retourne la ligne numero index.<br/>
     */
    public IRow getRow(int index);
    
    /**
     * Methode permettant de recuperer l'iterateur.<br/>
     * @return Iterateur.<br/>
     */
    public Iterator iterator();
    
    /**
     * Methode permettant de tracer le tableau.<br/>
     * @param gc Graphics.<br/>
     */
    public void draw(Graphics gc);
    
    /**
     * Methode permettant de recuperer la cellule a l'index indexLigne et a la colonne indexColonne.<br/>
     * @param indexLigne Index ligne.<br/>
     * @param indexColonne Index colonne.<br/>
     * @return Retourne la cellule correspondant.<br/>
     */
    public ICell getCell(int indexLigne,int indexColonne);
    
    /**
     * Methode permettant de fixer la cellule a l'index indexLigne et a la colonne indexColonne.<br/>
     * @param indexLigne Index ligne.<br/>
     * @param indexColonne Index colonne.<br/>
     @ param cell La cellule.<br/>
     */
    public void setCell(int indexLigne,int indexColonne,ICell cell);
    
    /**
     * Methode permettant de supprimer les lignes pleines.<br/>
     * @return Retourne le nombre de lignes supprimees.<br/>
     */
    public int supprimeLignePleine();
    
    /**
     * Methode permettant de reinitialiser un tableau
     */
    public void reset();


}
