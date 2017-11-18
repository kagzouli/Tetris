package com.piece.action;

/**
 * Actions possibles des joueurs.
 *
 */
public interface ActionJoueurs
{
    /**
     * Methode permettant de deplacer une piece a gauche.<br/>
     *
     */
    public void deplacerGauche();
    
    /**
     * Methode permettant de deplacer une piece a droite.<br/>
     *
     */
    public void deplacerDroite();
    
    /**
     * Methode permettant de deplacer une piece en bas.<br/>
     *
     */
    public void deplacerBas();
    
    /**
     * Methode permettant de faire une rotation.<br/>
     *
     */
    public void rotation();
    
    /**
     * Code touche deplacement a gauche.<br/>
     * @return Retourne le code de la touche deplacant a gauche.<br/>
     */
    public int getCodeDeplacementGauche();
    
    /**
     * Code touche deplacement a droite.<br/>
     * @return Retourne le code de la touche deplacant a droite.<br/>
     */
    public int getCodeDeplacementDroite();
    
    /**
     * Code touche deplacement en bas.<br/>
     * @return Retourne le code de la touche deplacant en bas.<br/>
     */
    public int getCodeDeplacementBas();
    
    /**
     * Code touche deplacement en bas.<br/>
     * @return Retourne le code de la touche deplacant en bas.<br/>
     */
    public int getCodeRotation();
    
    
    
    

}
