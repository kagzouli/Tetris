package com.piece.action.strategy;

import com.piece.aire.grille.ITable;
import com.piece.tetris.Piece;

public interface IStrategyDeplacementPiece {
	
	
	/**
	 * Methode permettant de deplacer une piece.<br/>
	 * 
	 * @param table
	 * @param piece
	 */
	void deplacerPiece(ITable table,Piece piece);
	

}
