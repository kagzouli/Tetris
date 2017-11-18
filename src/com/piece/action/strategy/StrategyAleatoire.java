package com.piece.action.strategy;

import java.util.Random;

import com.piece.action.PieceFacade;
import com.piece.aire.grille.ITable;
import com.piece.tetris.Piece;

/**
 * Strategie aleatoire de deplacement.<br/>
 * 
 * @author Karim
 * 
 */
public class StrategyAleatoire implements IStrategyDeplacementPiece {

	private PieceFacade pieceFacade;

	public StrategyAleatoire(PieceFacade pieceFacade) {
		this.pieceFacade = pieceFacade;
	}

	@Override
	public void deplacerPiece(ITable table, Piece piece) {

		Random random = new Random();
		int valueRandom = (random.nextInt(10) + 1);

		switch (valueRandom) {
		case 1:
			pieceFacade.deplacerBas(table, piece);
			break;
		case 2:
			pieceFacade.deplacerGauche(table, piece);
			break;
		case 3:
			pieceFacade.deplacerDroite(table, piece);
			break;
		case 4:
			pieceFacade.rotation(table, piece);
			break;
		case 5:
			pieceFacade.deplacerGauche(table, piece);
			break;
		case 6:
			pieceFacade.deplacerDroite(table, piece);
			break;
		case 7:
			pieceFacade.rotation(table, piece);
			break;
		case 8:
			pieceFacade.deplacerGauche(table, piece);
			break;
		case 9:
			pieceFacade.deplacerDroite(table, piece);
			break;
		case 10:
			pieceFacade.rotation(table, piece);
			break;

		}
	}

}
