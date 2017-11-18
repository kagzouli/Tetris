package com.piece.action.strategy;

import com.piece.action.PieceFacade;
import com.piece.aire.grille.ITable;
import com.piece.tetris.BarreHorizontale;
import com.piece.tetris.Carre;
import com.piece.tetris.PieT;
import com.piece.tetris.Piece;
import com.piece.tetris.PieceInverseZ;
import com.piece.tetris.PieceZ;
import com.piece.tetris.PistoletDroit;
import com.piece.tetris.PistoletGauche;

public class StrategyComplexe implements IStrategyDeplacementPiece {

	private PieceFacade pieceFacade;

	public StrategyComplexe(PieceFacade pieceFacade) {
		this.pieceFacade = pieceFacade;
	}

	@Override
	public void deplacerPiece(ITable table, Piece piece) {

		if ((piece.getIndexPosCellOptimal() == null) && (piece.getIndexPosLigneOptimal() == null)) {
			if (piece instanceof Carre) {
				this.strategyComplexeCarre(table, (Carre) piece);
			} else if (piece instanceof BarreHorizontale) {
				this.strategyComplexeBarreHorizontale(table, (BarreHorizontale) piece);
			} else if (piece instanceof PieceInverseZ){
				this.strategyComplexePieceZInverse(table, (PieceInverseZ) piece);				
			}else if (piece instanceof PieceZ){
				this.strategyComplexePieceZInverse(table, (PieceZ) piece);
			}else if (piece instanceof PistoletDroit){
				this.strategyComplexePistoletDroit(table, (PistoletDroit) piece);				
			}else if (piece instanceof PistoletGauche){
				this.strategyComplexePistoletGauche(table, (PistoletGauche) piece);
			}else if (piece instanceof PieT){
				this.strategyComplexePieT(table,(PieT) piece);
			}
		}

		final int indexCellPosRef = piece.getIndexCellulePositionRef();
		final int positionPiece = piece.getPosition();
		if (piece.getIndexPosCellOptimal() == null) {
			StrategyAleatoire strategy = new StrategyAleatoire(this.pieceFacade);
			strategy.deplacerPiece(table, piece);
		} else {
			if (positionPiece != piece.getPositionPieceOptimal().intValue()) {
				pieceFacade.rotation(table, piece);
			}else if (indexCellPosRef - piece.getIndexPosCellOptimal() > 0) {
				pieceFacade.deplacerGauche(table, piece);
			} else if (indexCellPosRef - piece.getIndexPosCellOptimal() < 0) {
				pieceFacade.deplacerDroite(table, piece);
			}else{
				pieceFacade.deplacerBas(table, piece);
			}

		}

	}

	/**
	 * Strategie trouve pour le carre.<br/>
	 * 
	 * @param table
	 * @param piece
	 */
	public void strategyComplexeCarre(ITable table, Carre piece) {
		int numLigne = table.getRowNumber() - 1;

		while (numLigne >= 1) {

			int numCell = table.getRow(0).getCellNumber() - 1;

			while (numCell >= 1) {

				if ((table.getCell(numLigne, numCell).estLibre()) && (table.getCell(numLigne - 1, numCell).estLibre()) && (table.getCell(numLigne, numCell - 1).estLibre()) && (table.getCell(numLigne - 1, numCell - 1).estLibre())) {
					piece.setIndexPosCellOptimal(numCell - 1);
					piece.setIndexPosLigneOptimal(numLigne - 1);
					piece.setPositionPieceOptimal(Piece.POSITION_1);
					return;
				}

				numCell--;
			}
			numLigne--;
		}

	}

	/**
	 * Strategie IA pour la barre horizontale.<br/>
	 * 
	 * @param table
	 * @param piece
	 */
	public void strategyComplexeBarreHorizontale(ITable table, BarreHorizontale piece) {
		int numLigne = table.getRowNumber() - 1;

		while (numLigne >= 0) {

			int numCell = table.getRow(0).getCellNumber() - 1;

			while (numCell >= 0) {

				// Verifie barre horizontale en horizontale.
				if (numCell >= 3) {
					if ((table.getCell(numLigne, numCell).estLibre()) && (table.getCell(numLigne, numCell - 1).estLibre()) && (table.getCell(numLigne, numCell - 2).estLibre()) && (table.getCell(numLigne, numCell - 3).estLibre())) {
						piece.setIndexPosCellOptimal(numCell - 3);
						piece.setIndexPosLigneOptimal(numLigne);
						piece.setPositionPieceOptimal(Piece.POSITION_2);
						return;
					}
				}

				// Verifie barre horizontale en vertical.
				if (numLigne >= 3) {
					if ((table.getCell(numLigne, numCell).estLibre()) && (table.getCell(numLigne - 1, numCell).estLibre()) && (table.getCell(numLigne - 2, numCell).estLibre()) && (table.getCell(numLigne - 3, numCell).estLibre())) {
						piece.setIndexPosCellOptimal(numCell);
						piece.setIndexPosLigneOptimal(numLigne - 3);
						piece.setPositionPieceOptimal(Piece.POSITION_1);
						return;
					}
				}

				numCell--;
			}
			numLigne--;
		}

	}

	/**
	 * Strategie IA pour la piece Z inverse.<br/>
	 * 
	 * @param table
	 * @param piece
	 */

	public void strategyComplexePieceZInverse(final ITable table,PieceInverseZ piece){
		int numLigne = table.getRowNumber() - 1;

		while (numLigne >= 0) {

			int numCell = table.getRow(0).getCellNumber() - 1;

			while (numCell >= 0) {

				// Position 1 piece Z inverse.
				if ((numCell >= 2) && (numLigne >=1)) {
					if ((table.getCell(numLigne, numCell - 1).estLibre()) && (table.getCell(numLigne, numCell - 2).estLibre()) && (table.getCell(numLigne - 1, numCell).estLibre()) && (table.getCell(numLigne -1, numCell - 1).estLibre())) {
						piece.setIndexPosCellOptimal(numCell - 1);
						piece.setIndexPosLigneOptimal(numLigne - 1);
						piece.setPositionPieceOptimal(Piece.POSITION_1);
						return;
					}
				}

				// Position2 piece Z inverse
				if ((numLigne >= 2) && (numCell >= 1)) {
					if ((table.getCell(numLigne, numCell).estLibre()) && (table.getCell(numLigne - 1, numCell).estLibre()) && (table.getCell(numLigne - 1, numCell - 1).estLibre()) && (table.getCell(numLigne - 2, numCell -1).estLibre())) {
						piece.setIndexPosCellOptimal(numCell);
						piece.setIndexPosLigneOptimal(numLigne - 1);
						piece.setPositionPieceOptimal(Piece.POSITION_2);
						return;
					}
				}

				numCell--;
			}
			numLigne--;
		}		
	}

	/**
	 * Strategie IA pour la piece Z.<br/>
	 * 
	 * @param table
	 * @param piece
	 */

	public void strategyComplexePieceZInverse(ITable table,PieceZ piece){
		int numLigne = table.getRowNumber() - 1;

		while (numLigne >= 0) {

			int numCell = table.getRow(0).getCellNumber() - 1;

			while (numCell >= 0) {

				// Position 1 piece Z.
				if ((numCell >= 2) && (numLigne >=1)) {
					if ((table.getCell(numLigne, numCell).estLibre()) && (table.getCell(numLigne, numCell - 1).estLibre()) && (table.getCell(numLigne - 1, numCell - 1).estLibre()) && (table.getCell(numLigne -1, numCell - 2).estLibre())) {
						piece.setIndexPosCellOptimal(numCell - 1);
						piece.setIndexPosLigneOptimal(numLigne - 1);
						piece.setPositionPieceOptimal(Piece.POSITION_1);
						return;
					}
				}

				// Position2 piece Z
				if ((numLigne >= 2) && (numCell >= 1)) {
					if ((table.getCell(numLigne, numCell -1).estLibre()) && (table.getCell(numLigne - 1, numCell).estLibre()) && (table.getCell(numLigne - 1, numCell - 1).estLibre()) && (table.getCell(numLigne - 2, numCell).estLibre())) {
						piece.setIndexPosCellOptimal(numCell -1);
						piece.setIndexPosLigneOptimal(numLigne - 1);
						piece.setPositionPieceOptimal(Piece.POSITION_2);
						return;
					}
				}

				numCell--;
			}
			numLigne--;
		}		
		
	}
	
	/**
	 * Strategie IA pour le pistolet droit.<br/>
	 * 
	 * @param table
	 * @param piece
	 */
	public void strategyComplexePistoletDroit(ITable table, PistoletDroit piece){
		int numLigne = table.getRowNumber() - 1;

		while (numLigne >= 0) {

			int numCell = table.getRow(0).getCellNumber() - 1;

			while (numCell >= 0) {

				// Position 3 pistolet droit
				if ((numCell >= 2) && (numLigne >=1)) {
					if ((table.getCell(numLigne, numCell).estLibre()) && (table.getCell(numLigne, numCell - 1).estLibre()) && (table.getCell(numLigne, numCell - 2).estLibre()) && (table.getCell(numLigne -1, numCell - 2).estLibre())) {
						piece.setIndexPosCellOptimal(numCell - 1);
						piece.setIndexPosLigneOptimal(numLigne);
						piece.setPositionPieceOptimal(Piece.POSITION_3);
						return;
					}
				}
				
				// Position 2 pistolet droit
				if ((numCell >= 1) && (numLigne >=2)) {
					if ((table.getCell(numLigne, numCell).estLibre()) && (table.getCell(numLigne, numCell - 1).estLibre()) && (table.getCell(numLigne -1, numCell).estLibre()) && (table.getCell(numLigne -2, numCell).estLibre())) {
						piece.setIndexPosCellOptimal(numCell);
						piece.setIndexPosLigneOptimal(numLigne -2);
						piece.setPositionPieceOptimal(Piece.POSITION_2);
						return;
					}
				}


				// Position1 pistolet droit
				if ((numLigne >= 1) && (numCell >= 2)) {
					if ((table.getCell(numLigne, numCell).estLibre()) && (table.getCell(numLigne - 1, numCell).estLibre()) && (table.getCell(numLigne - 1, numCell - 1).estLibre()) && (table.getCell(numLigne - 1, numCell -2).estLibre())) {
						piece.setIndexPosCellOptimal(numCell -1);
						piece.setIndexPosLigneOptimal(numLigne - 1);
						piece.setPositionPieceOptimal(Piece.POSITION_1);
						return;
					}
				}

				// Position4 pistolet droit
				if ((numLigne >= 2) && (numCell >= 1)) {
					if ((table.getCell(numLigne, numCell - 1).estLibre()) && (table.getCell(numLigne - 1, numCell -1).estLibre()) && (table.getCell(numLigne - 2, numCell - 1).estLibre()) && (table.getCell(numLigne - 2, numCell).estLibre())) {
						piece.setIndexPosCellOptimal(numCell -1);
						piece.setIndexPosLigneOptimal(numLigne -2);
						piece.setPositionPieceOptimal(Piece.POSITION_4);
						return;
					}
				}

				
				numCell--;
			}
			numLigne--;
		}		
		
	}
	
	/**
	 * Strategie IA pour pistolet gauche.<br/>
	 * 
	 * @param table
	 * @param piece
	 */
	public void strategyComplexePistoletGauche(ITable table,PistoletGauche piece){
		int numLigne = table.getRowNumber() - 1;

		while (numLigne >= 0) {

			int numCell = table.getRow(0).getCellNumber() - 1;

			while (numCell >= 0) {

				// Position 3 pistolet gauche
				if ((numCell >= 2) && (numLigne >=1)) {
					if ((table.getCell(numLigne, numCell).estLibre()) && (table.getCell(numLigne, numCell - 1).estLibre()) && (table.getCell(numLigne, numCell - 2).estLibre()) && (table.getCell(numLigne -1, numCell).estLibre())) {
						piece.setIndexPosCellOptimal(numCell - 1);
						piece.setIndexPosLigneOptimal(numLigne);
						piece.setPositionPieceOptimal(Piece.POSITION_3);
						return;
					}
				}
				
				// Position 4 pistolet gauche
				if ((numCell >= 1) && (numLigne >=2)) {
					if ((table.getCell(numLigne, numCell).estLibre()) && (table.getCell(numLigne, numCell - 1).estLibre()) && (table.getCell(numLigne -1, numCell - 1).estLibre()) && (table.getCell(numLigne -2, numCell -1).estLibre())) {
						piece.setIndexPosCellOptimal(numCell -1);
						piece.setIndexPosLigneOptimal(numLigne -2);
						piece.setPositionPieceOptimal(Piece.POSITION_4);
						return;
					}
				}


				// Position1 pistolet gauche
				if ((numLigne >= 1) && (numCell >= 2)) {
					if ((table.getCell(numLigne - 1, numCell).estLibre()) && (table.getCell(numLigne - 1, numCell -1).estLibre()) && (table.getCell(numLigne - 1, numCell - 2).estLibre()) && (table.getCell(numLigne, numCell -2).estLibre())) {
						piece.setIndexPosCellOptimal(numCell -1);
						piece.setIndexPosLigneOptimal(numLigne - 1);
						piece.setPositionPieceOptimal(Piece.POSITION_1);
						return;
					}
				}

				// Position2 pistolet gauche
				if ((numLigne >= 2) && (numCell >= 1)) {
					if ((table.getCell(numLigne, numCell).estLibre()) && (table.getCell(numLigne - 1, numCell).estLibre()) && (table.getCell(numLigne - 2, numCell).estLibre()) && (table.getCell(numLigne - 2, numCell -1).estLibre())) {
						piece.setIndexPosCellOptimal(numCell);
						piece.setIndexPosLigneOptimal(numLigne -2);
						piece.setPositionPieceOptimal(Piece.POSITION_2);
						return;
					}
				}

				
				numCell--;
			}
			numLigne--;
		}		

	}
	
	/**
	 * Strategie IA pour pieT.<br/>
	 * 
	 * @param table
	 * @param piece
	 */
	public void strategyComplexePieT(ITable table,PieT piece){
		int numLigne = table.getRowNumber() - 1;

		while (numLigne >= 0) {

			int numCell = table.getRow(0).getCellNumber() - 1;

			while (numCell >= 0) {

				// Position 3 pieT
				if ((numCell >= 2) && (numLigne >=1)) {
					if ((table.getCell(numLigne, numCell).estLibre()) && (table.getCell(numLigne, numCell - 1).estLibre()) && (table.getCell(numLigne, numCell - 2).estLibre()) && (table.getCell(numLigne -1, numCell -1).estLibre())) {
						piece.setIndexPosCellOptimal(numCell - 1);
						piece.setIndexPosLigneOptimal(numLigne - 1);
						piece.setPositionPieceOptimal(Piece.POSITION_3);
						return;
					}
				}
								
				// Position 4 pieT
				if ((numCell >= 1) && (numLigne >=2)) {
					if ((table.getCell(numLigne - 1, numCell).estLibre()) && (table.getCell(numLigne, numCell - 1).estLibre()) && (table.getCell(numLigne -1, numCell - 1).estLibre()) && (table.getCell(numLigne -2, numCell -1).estLibre())) {
						piece.setIndexPosCellOptimal(numCell -1);
						piece.setIndexPosLigneOptimal(numLigne -2);
						piece.setPositionPieceOptimal(Piece.POSITION_4);
						return;
					}
				}


				// Position2 pieT
				if ((numLigne >= 2) && (numCell >= 1)) {
					if ((table.getCell(numLigne, numCell).estLibre()) && (table.getCell(numLigne - 1, numCell).estLibre()) && (table.getCell(numLigne - 2, numCell).estLibre()) && (table.getCell(numLigne -1, numCell -1).estLibre())) {
						piece.setIndexPosCellOptimal(numCell);
						piece.setIndexPosLigneOptimal(numLigne - 2);
						piece.setPositionPieceOptimal(Piece.POSITION_2);
						return;
					}
				}
				
				// Position1 pieT
				if ((numLigne >= 1) && (numCell >= 2)) {
					if ((table.getCell(numLigne -1, numCell).estLibre()) && (table.getCell(numLigne, numCell -1).estLibre()) && (table.getCell(numLigne - 1, numCell -1).estLibre()) && (table.getCell(numLigne - 1, numCell -2).estLibre())) {
						piece.setIndexPosCellOptimal(numCell - 1);
						piece.setIndexPosLigneOptimal(numLigne -1);
						piece.setPositionPieceOptimal(Piece.POSITION_1);
						return;
					}
				}

						
				numCell--;
			}
			numLigne--;
		}		

	}


}
