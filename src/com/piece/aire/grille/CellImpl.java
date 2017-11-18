package com.piece.aire.grille;

import java.awt.Color;
import java.awt.Graphics;

import com.piece.exception.TechnicalException;



/**
 * 
 * (posX,posY)
 * ------------
 * |          |
 * |          | largeur
 * |          |
 * |----------|
 *  longueur
 * 
 * @author x587368
 *
 */
public class CellImpl implements ICell
{
    private int posX;
    
    private int posY;
    
    private int longueur;
    
    private int largeur;
    
    /**
     * Couleur des contours de la cellule.<br/>
     */
    private static final Color COLOR_CELL = Color.YELLOW;
    
    /**
     * Couleur de la cellule
     */
    private Color couleurCellule;
    
    public CellImpl(){
        this.couleurCellule = COLOR_CELL_AVAILABLE;
    }

    public int getLargeur()
    {
        return largeur;
    }

    public void setLargeur(int theLargeur)
    {
        largeur = theLargeur;
    }

    public int getLongueur()
    {
        return longueur;
    }

    public void setLongueur(int theLongueur)
    {
        longueur = theLongueur;
    }

    public int getPosX()
    {
        return posX;
    }

    public void setPosX(int thePosX)
    {
        posX = thePosX;
    }

    public int getPosY()
    {
        return posY;
    }

    public void setPosY(int thePosY)
    {
        posY = thePosY;
    }

/**
    * 
   * {@inheritDoc}
    */
    public boolean estOccupe()
    {
        return (!COLOR_CELL_AVAILABLE.equals(this.couleurCellule));
    }
    
    /**
     * Determine si la case est libre.<br/>
     * @return Retourne vrai si la case est libre.<br/>
     */
    public boolean estLibre(){
        return (COLOR_CELL_AVAILABLE.equals(this.couleurCellule));
    }

    /**
    
    /**
     * 
    * {@inheritDoc}
     */
    public void setOccupe(Color color){
        this.couleurCellule = color;
    }
    
    /**
     * Methode permettant de liberer la cellule
     *
     */
    public void fixeLibre(){
        this.couleurCellule = COLOR_CELL_AVAILABLE;
    }

    /**
     * 
    * {@inheritDoc}
     */
    public void draw(Graphics gc,int thePosIniX, int thePosIniY, int theLongueur, int theLargeur)
    {
        if (gc != null){
            
            //Fixe la couleur
            gc.setColor(COLOR_CELL);
            
            //Trace la bordure du haut.
            traceBordureHaut(gc,thePosIniX,thePosIniY,theLongueur,theLargeur);
           
            //Trace la bordure de gauche.
            traceBordureGauche(gc,thePosIniX,thePosIniY,theLongueur,theLargeur);
            
            //Trace la bordure de droite
            traceBordureDroite(gc,thePosIniX,thePosIniY,theLongueur,theLargeur);
            
            //Trace la bordure du bas
            traceBordureBas(gc,thePosIniX,thePosIniY,theLongueur,theLargeur);
            
            //Colorie la cellule
            if (this.estOccupe()){
                gc.setColor(couleurCellule);
                gc.fillRect(thePosIniX, thePosIniY, theLongueur, theLargeur);
            }
                        
            gc.setColor(COLOR_CELL);

        }   
         
    }
    
    /**
     * Methode permettant de tracer la bordure du haut.<br/>
     * @param gc Graphics.<br/>
     * @param thePosIniX Position Initiale X.<br/>
     * @param thePosIniY Position Initiale Y.<br/>
     * @param theLongueur Longueur.<br/>
     * @param theLargeur Largeur.<br/>
     */
    private void traceBordureHaut(Graphics gc,int thePosIniX, int thePosIniY, int theLongueur, int theLargeur){
        if (gc != null){
            int thePosFinX = thePosIniX + theLongueur;
            gc.drawLine(thePosIniX,thePosIniY,thePosFinX, thePosIniY);
        }
    }
    
    /**
     * Methode permettant de tracer la bordure de gauche.<br/>
     * @param gc Graphics.<br/>
     * @param thePosIniX Position Initiale X.<br/>
     * @param thePosIniY Position Initiale Y.<br/>
     * @param theLongueur Longueur.<br/>
     * @param theLargeur Largeur.<br/>
     */
    private void traceBordureGauche(Graphics gc,int thePosIniX, int thePosIniY, int theLongueur, int theLargeur){
        if (gc != null){
            int thePosFinY = thePosIniY + theLargeur;
            gc.drawLine(thePosIniX,thePosIniY,thePosIniX, thePosFinY);
        }
    }
    
    /**
     * Methode permettant de tracer la bordure de droite.<br/>
     * @param gc Graphics.<br/>
     * @param thePosIniX Position Initiale X.<br/>
     * @param thePosIniY Position Initiale Y.<br/>
     * @param theLongueur Longueur.<br/>
     * @param theLargeur Largeur.<br/>
     */
    private void traceBordureDroite(Graphics gc,int thePosIniX, int thePosIniY, int theLongueur, int theLargeur){
        if (gc != null){
            int thePosFinX = thePosIniX + theLongueur;
            int thePosFinY = thePosIniY + theLargeur;
            gc.drawLine(thePosFinX,thePosIniY,thePosFinX, thePosFinY);
        }
    }
    
    /**
     * Methode permettant de tracer la bordure du bas.<br/>
     * @param gc Graphics.<br/>
     * @param thePosIniX Position Initiale X.<br/>
     * @param thePosIniY Position Initiale Y.<br/>
     * @param theLongueur Longueur.<br/>
     * @param theLargeur Largeur.<br/>
     */
    private void traceBordureBas(Graphics gc,int thePosIniX, int thePosIniY, int theLongueur, int theLargeur){
        if (gc != null){
            int thePosFinX = thePosIniX + theLongueur;
            int thePosFinY = thePosIniY + theLargeur;
            gc.drawLine(thePosIniX,thePosFinY,thePosFinX, thePosFinY);
        }
    }

    public Color getCouleurCellule()
    {
        return this.couleurCellule;
    }

    public void setCouleurCellule(Color theCouleurCellule)
    {
        this.couleurCellule = theCouleurCellule;
    }

}
