package com.piece.aire.grille;


import java.awt.Color;
import java.awt.Graphics;

import com.piece.exception.TechnicalException;

public interface ICell
{
    
    public Color COLOR_CELL_AVAILABLE = Color.BLACK;
  
    /**
     * Determine si la case est occupe par le centre d'une piece.<br/>
     * @return Retourne vrai si la case est occupe.<br/>
     */
    public boolean estOccupe();
    
    /**
     * Determine si la case est libre.<br/>
     * @return Retourne vrai si la case est libre.<br/>
     */
    public boolean estLibre();
   
  

    /**
     * Methode permettant de mettre la colonne a occuper et d'indiquer la piece qui occupe cette colonne.
     * Si null, la colonne est consideree comme libre.<br/>
     * @param color couleur de la cellule.
     */
    public void setOccupe(Color color);
     
    
    /**
     * Methode permettant de recuperer la largeur de la cellule.<br/>
     * @return Retourne la largeur de la cellule.<br/>
     */
    public int getLargeur();
  

    /**
     * Methode permettant de fixer la largeur de la cellule.<br/>
     * @param theLargeur La largeur.<br/>
     */
    public void setLargeur(int theLargeur);
    

    /**
     * Methode permettant de recuperer la longueur de la cellule.<br/>
     * @return La longueur.<br/>
     */
    public int getLongueur();
    

    /**
     * Methode permettant de fixer la longueur de la cellule.<br/>
     * @param theLongueur La longueur.<br/>
     */
    public void setLongueur(int theLongueur);
   

    /**
     * Methode permettant de recuperer la positionX(En haut a gauche de la cellule).<br/>
     * @return Retourne la positionX(En haut a gauche de la cellule).<br/>
     */
    public int getPosX();
  

    /**
     * Methode permettant de fixer la positionX(En haut a gauche de la cellule).<br/>
     * @param thePosX La positionX.<br/>
     */
    public void setPosX(int thePosX);
    
    /**
     * Methode permettant de recuperer la positionY(En haut a gauche de la cellule).<br/>
     * @return Retourne la positionY(En haut a gauche de la cellule).<br/>
     */
    public int getPosY();

    /**
     * Methode permettant de fixer la positionY(En haut a gauche de la cellule).<br/>
     * @param thePosY La positionY.<br/>
     */
    public void setPosY(int thePosY);
    
    /**
     * Methode permettant de dessiner la cellule.<br/>
     * @param gc Graphics.<br/>
     * @param posIniX position initiale X.<br/>
     * @param posIniY position initiale Y.<br/>
     * @param longueur longueur Longueur.<br/>
     * @param largeur Largeur.<br/>
     */
    public void draw(Graphics gc,int posIniX,int posIniY,int longueur,int largeur);
  
    /**
     * Methode permettant d'indiquer que la cellule est libre.<br/>
     *
     */
    public void fixeLibre();
    
    /**
     * Methode permettant de recuperer la couleur occupee.<br/>
     * @return Retourne la couleur.<br/>
     */
    public Color getCouleurCellule();
    
}
