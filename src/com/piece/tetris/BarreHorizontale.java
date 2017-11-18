package com.piece.tetris;

import java.awt.Color;

/**
 * /**
 * 
 * Position 1 : 
 * ----------
 * 
 *   Point de reference
 *     |
 *     |
 *     \/
 *     x 
 *     x 
 *     x
 *     x
 *     
  * Position 2 : 
 * ----------
 * 
 *   Point de reference
 *     |
 *     |
 *     \/
 *     x x x x
 *     
 * Position 3 : 
 * ----------
 * 
 *   Point de reference
 *     |
 *     |
 *     \/
 *     x 
 *     x 
 *     x
 *     x
 *     
  * Position 4 : 
 * ----------
 * 
 *   Point de reference
 *     |
 *     |
 *     \/
 *     x x x x
 *     
 *
 */
public class BarreHorizontale extends Piece
{
    public BarreHorizontale(){
        this.indexLignePositionRef = 0;
        this.indexCellulePositionRef = 3;
        this.position = Piece.POSITION_1;
    }
    
    
    /**
     * 
    * {@inheritDoc}
     */
    public Color getColor(){
        return Color.RED;
    }
}
