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
 *    xxx 
 *    x       
 *     
 *     
  * Position 2 : 
 * ----------
 * 
 *   Point de reference(2eme point en bas)
 *     |
 *     |
 *     \/
 *    xx
 *     x
 *     x
 *     
 * Position 3 : 
 * ----------
 * 
 *   Point de reference
 *     |
 *     |
 *     \x
 *    xxx   
 *       
 *     
 *     
  * Position 4 : 
 * ----------
 * 
 *   Point de reference(2eme point en bas)
 *     |
 *     |
 *     \/
 *     x 
 *     x
 *     xx
 *     
 *
 */

public class PistoletGauche extends Piece{

	public PistoletGauche(){
		this.indexLignePositionRef = 0;
		this.indexCellulePositionRef = 3;
		this.position = Piece.POSITION_1;
	}

	public Color getColor() {
		return new Color(255,255,51);
	}

}
