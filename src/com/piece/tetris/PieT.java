package com.piece.tetris;

import java.awt.Color;

/**
 * 
 * Position 1 : 
 * ----------
 * 
 *      Point de reference(centre 2eme point barre bas)
 *      |
 *      |
 *      \/
 *     x xx
 *       x
 *     
 *     
 *  Position 2 : 
 * ----------
 * 
 *   Point de reference(2eme point bas)
 *     |
 *     |
 *     \/
 *     x 
 *    xx 
 *     x
 *     
 * Position 3 : 
 * ----------
 * 
 *   Point de reference(centre 2eme point barre bas)
 *     |
 *     |
 *     x
 *    xxx
 *     
 *     
 *  Position 4 : 
 * ----------
 * 
 *   Point de reference(2eme point bas)
 *     |
 *     |
 *     \/
 *     x 
 *     xx 
 *     x
 */

public class PieT extends Piece {

	public PieT() {
		this.indexLignePositionRef = 0;
		this.indexCellulePositionRef = 3;
		this.position = Piece.POSITION_1;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public Color getColor() {
		return new Color(230, 90, 255);
	}

}
