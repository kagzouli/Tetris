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
 *    xx 
 *     xx
 *     
 *     
 *     
  * Position 2 : 
 * ----------
 * 
 *   Point de reference
 *     |
 *     |
 *     \x
 *     xx
 *     x
 *     
 * Position 3 : 
 * ----------
 * 
 *   Point de reference
 *     |
 *     |
 *     \/
 *    xx 
 *     xx
 x
 *     
 * Position 4 : 
 * ----------
 * 
*   Point de reference
 *     |
 *     |
 *     \x
 *     xx
 *     x
 *     
 */


public class PieceZ extends Piece{

	public PieceZ() {
		this.indexLignePositionRef = 0;
		this.indexCellulePositionRef = 3;
		this.position = Piece.POSITION_1;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public Color getColor() {
		return new Color(20, 20, 255);
	}

}
