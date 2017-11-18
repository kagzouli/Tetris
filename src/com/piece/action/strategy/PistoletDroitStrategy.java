package com.piece.action.strategy;

import com.piece.aire.grille.ICell;
import com.piece.aire.grille.IRow;
import com.piece.aire.grille.ITable;
import com.piece.tetris.Piece;

public class PistoletDroitStrategy extends PieceStrategy {

	@Override
	public boolean afficherInitialPiece(ITable theGrille, Piece thePiece) {
		int indexCelPosRef = thePiece.getIndexCellulePositionRef();
		int indexLigPosRef = thePiece.getIndexLignePositionRef();

		boolean affiche = this.affiche(theGrille, thePiece);

		if (affiche) {
			theGrille.getCell(indexLigPosRef, indexCelPosRef - 1).setOccupe(thePiece.getColor());
			theGrille.getCell(indexLigPosRef, indexCelPosRef).setOccupe(thePiece.getColor());
			theGrille.getCell(indexLigPosRef, indexCelPosRef + 1).setOccupe(thePiece.getColor());
			theGrille.getCell(indexLigPosRef + 1, indexCelPosRef + 1).setOccupe(thePiece.getColor());
		}

		return affiche;
	}

	@Override
	public boolean deplacerBasPosition1(ITable theGrille, Piece thePiece) {
		int nombreLignes = theGrille.getRowNumber();

		int indexNumeCellPosRefPiece = thePiece.getIndexCellulePositionRef();
		int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

		/**
		 * On arrive au bout.
		 */
		if (indexNumLigPosRefPiece + 2 >= nombreLignes) {
			thePiece.setBloque(true);
			return false;
		}

		ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece - 1);
		if (cell1.estOccupe()) {
			thePiece.setBloque(true);
			return false;
		}

		ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece);
		if (cell2.estOccupe()) {
			thePiece.setBloque(true);
			return false;
		}

		ICell cell3 = theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumeCellPosRefPiece + 1);
		if (cell3.estOccupe()) {
			thePiece.setBloque(true);
			return false;
		}

		// Liberation de 3 cellules.
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece - 1).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece + 1).fixeLibre();

		// Remplissage de 3 cellules
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece - 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumeCellPosRefPiece + 1).setOccupe(thePiece.getColor());

		// Deplacement de la piece.
		thePiece.setIndexLignePositionRef(thePiece.getIndexLignePositionRef() + 1);

		return true;
	}

	@Override
	public boolean deplacerBasPosition2(ITable theGrille, Piece thePiece) {
		int nombreLignes = theGrille.getRowNumber();

		int indexNumeCellPosRefPiece = thePiece.getIndexCellulePositionRef();
		int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

		/**
		 * On arrive au bout.
		 */
		if (indexNumLigPosRefPiece + 2 >= nombreLignes) {
			thePiece.setBloque(true);
			return false;
		}

		ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumeCellPosRefPiece - 1);
		if (cell1.estOccupe()) {
			thePiece.setBloque(true);
			return false;
		}

		ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumeCellPosRefPiece);
		if (cell2.estOccupe()) {
			thePiece.setBloque(true);
			return false;
		}

		// Liberation de 2 cellules
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece - 1).fixeLibre();

		// Remplissage de 2 cellules
		theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumeCellPosRefPiece - 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumeCellPosRefPiece).setOccupe(thePiece.getColor());

		// Deplacement de la piece.
		thePiece.setIndexLignePositionRef(thePiece.getIndexLignePositionRef() + 1);
		return true;
	}

	@Override
	public boolean deplacerBasPosition3(ITable theGrille, Piece thePiece) {
		int nombreLignes = theGrille.getRowNumber();

		int indexNumeCellPosRefPiece = thePiece.getIndexCellulePositionRef();
		int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

		/**
		 * On arrive au bout.
		 */
		if (indexNumLigPosRefPiece + 1 >= nombreLignes) {
			thePiece.setBloque(true);
			return false;
		}

		ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece - 1);
		if (cell1.estOccupe()) {
			thePiece.setBloque(true);
			return false;
		}

		ICell cel2 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece);
		if (cel2.estOccupe()) {
			thePiece.setBloque(true);
			return false;
		}

		ICell cel3 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece + 1);
		if (cel3.estOccupe()) {
			thePiece.setBloque(true);
			return false;
		}

		// Liberation de 3 cellules
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece - 1).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece + 1).fixeLibre();

		// Remplissage de 3 cellules
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece - 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece + 1).setOccupe(thePiece.getColor());

		// Deplacement de la piece.
		thePiece.setIndexLignePositionRef(thePiece.getIndexLignePositionRef() + 1);

		return true;
	}

	@Override
	public boolean deplacerBasPosition4(ITable theGrille, Piece thePiece) {
		int nombreLignes = theGrille.getRowNumber();

		int indexNumeCellPosRefPiece = thePiece.getIndexCellulePositionRef();
		int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

		/**
		 * On arrive au bout.
		 */
		if (indexNumLigPosRefPiece + 2 >= nombreLignes) {
			thePiece.setBloque(true);
			return false;
		}

		ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece + 1);
		if (cell1.estOccupe()) {
			thePiece.setBloque(true);
			return false;
		}

		ICell cel2 = theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumeCellPosRefPiece);
		if (cel2.estOccupe()) {
			thePiece.setBloque(true);
			return false;
		}

		// Liberation de 2 cellules
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece + 1).fixeLibre();

		// Remplissage de 2 cellules
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece + 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumeCellPosRefPiece).setOccupe(thePiece.getColor());

		// Deplacement de la piece.
		thePiece.setIndexLignePositionRef(thePiece.getIndexLignePositionRef() + 1);

		return true;
	}

	@Override
	public boolean deplacerDroitePosition1(ITable theGrille, Piece thePiece) {

		int indexNumeCellPosRefPiece = thePiece.getIndexCellulePositionRef();
		int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

		IRow row = (IRow) theGrille.getRow(indexNumLigPosRefPiece);
		int nombreCellules = row.getCellNumber();

		/**
		 * On arrive au bout.
		 */
		if (indexNumeCellPosRefPiece + 2 >= nombreCellules) {
			return false;
		}

		ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece + 2);
		if (cell1.estOccupe()) {
			return false;
		}

		ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece + 2);
		if (cell2.estOccupe()) {
			return false;
		}

		// Liberation de 2 cellules
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece - 1).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece + 1).fixeLibre();

		// Remplissage de 2 cellules
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece + 2).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece + 2).setOccupe(thePiece.getColor());

		// Deplacement de la piece.
		thePiece.setIndexCellulePositionRef(thePiece.getIndexCellulePositionRef() + 1);

		return true;
	}

	@Override
	public boolean deplacerDroitePosition2(ITable theGrille, Piece thePiece) {
		int indexNumeCellPosRefPiece = thePiece.getIndexCellulePositionRef();
		int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

		IRow row = (IRow) theGrille.getRow(indexNumLigPosRefPiece);
		int nombreCellules = row.getCellNumber();

		if (indexNumeCellPosRefPiece + 1 >= nombreCellules) {
			return false;
		}

		ICell cel1 = theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece + 1);
		if (cel1.estOccupe()) {
			return false;
		}

		ICell cel2 = theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece + 1);
		if (cel2.estOccupe()) {
			return false;
		}

		ICell cel3 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece + 1);
		if (cel3.estOccupe()) {
			return false;
		}

		// Liberation de 3 cellules
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece - 1).fixeLibre();

		// Remplissage de 3 cellules
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece + 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece + 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece + 1).setOccupe(thePiece.getColor());

		// Deplacement de la piece.
		thePiece.setIndexCellulePositionRef(thePiece.getIndexCellulePositionRef() + 1);

		return true;
	}

	@Override
	public boolean deplacerDroitePosition3(ITable theGrille, Piece thePiece) {

		int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

		int indexNumeCellPosRefPiece = thePiece.getIndexCellulePositionRef();

		IRow row = (IRow) theGrille.getRow(indexNumLigPosRefPiece);
		int nombreCellules = row.getCellNumber();

		/**
		 * On arrive au bout.
		 */
		if (indexNumeCellPosRefPiece + 2 >= nombreCellules) {
			return false;
		}
		
		ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece + 2);
		if (cell1.estOccupe()) {
			return false;
		}

		ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece);
		if (cell2.estOccupe()) {
			return false;
		}

		// Liberation de 2 cellules
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece - 1).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece - 1).fixeLibre();

		// Remplissage de 2 cellules
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece + 2).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece).setOccupe(thePiece.getColor());

		// Deplacement de la piece.
		thePiece.setIndexCellulePositionRef(thePiece.getIndexCellulePositionRef() + 1);

		
		return true;
	}

	@Override
	public boolean deplacerDroitePosition4(ITable theGrille, Piece thePiece) {
		int indexNumeCellPosRefPiece = thePiece.getIndexCellulePositionRef();
		int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

		IRow row = (IRow) theGrille.getRow(indexNumLigPosRefPiece);
		int nombreCellules = row.getCellNumber();

		if (indexNumeCellPosRefPiece + 2 >= nombreCellules) {
			return false;
		}
		
		ICell cel1 = theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece + 2);
		if (cel1.estOccupe()) {
			return false;
		}
		
		ICell cel2 = theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece + 1);
		if (cel2.estOccupe()) {
			return false;
		}
		
		ICell cel3 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece + 1);
		if (cel3.estOccupe()) {
			return false;
		}

		
		// Liberation de 3 cellules
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece +1, indexNumeCellPosRefPiece).fixeLibre();

		
		// Remplissage de 3 cellules
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece + 2).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece + 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece +1, indexNumeCellPosRefPiece + 1).setOccupe(thePiece.getColor());

		// Deplacement de la piece.
		thePiece.setIndexCellulePositionRef(thePiece.getIndexCellulePositionRef() + 1);


		return true;
	}

	@Override
	public boolean deplacerGauchePosition1(ITable theGrille, Piece thePiece) {
		int indexNumeCellPosRefPiece = thePiece.getIndexCellulePositionRef();
		int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

		if (indexNumeCellPosRefPiece < 2) {
			return false;
		}

		ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece - 2);
		if (cell1.estOccupe()) {
			return false;
		}

		ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece);
		if (cell2.estOccupe()) {
			return false;
		}

		// Liberation de 2 cellules
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece + 1).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece + 1).fixeLibre();

		// Remplissage de 2 cellules
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece - 2).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece).setOccupe(thePiece.getColor());

		// Deplacement de la piece.
		thePiece.setIndexCellulePositionRef(thePiece.getIndexCellulePositionRef() - 1);

		return true;
	}

	@Override
	public boolean deplacerGauchePosition2(ITable theGrille, Piece thePiece) {
		int indexNumeCellPosRefPiece = thePiece.getIndexCellulePositionRef();
		int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

		if (indexNumeCellPosRefPiece < 2) {
			return false;
		}

		ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece - 1);
		if (cell1.estOccupe()) {
			return false;
		}

		ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece - 1);
		if (cell2.estOccupe()) {
			return false;
		}

		ICell cell3 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece - 2);
		if (cell3.estOccupe()) {
			return false;
		}

		// Liberation de 3 cellules
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece).fixeLibre();

		// Remplissage de 3 cellules
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece - 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece - 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece - 2).setOccupe(thePiece.getColor());

		// Deplacement de la piece.
		thePiece.setIndexCellulePositionRef(thePiece.getIndexCellulePositionRef() - 1);

		return true;
	}

	@Override
	public boolean deplacerGauchePosition3(ITable theGrille, Piece thePiece) {
		int indexNumeCellPosRefPiece = thePiece.getIndexCellulePositionRef();
		int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

		if (indexNumeCellPosRefPiece < 2) {
			return false;
		}

		ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece - 2);
		if (cell1.estOccupe()) {
			return false;
		}

		ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece - 2);
		if (cell2.estOccupe()) {
			return false;
		}

		// Liberation de 2 cellules
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece + 1).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece - 1).fixeLibre();

		// Remplissage de 2 cellules
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece - 2).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece - 2).setOccupe(thePiece.getColor());

		// Deplacement de la piece.
		thePiece.setIndexCellulePositionRef(thePiece.getIndexCellulePositionRef() - 1);
		return true;
	
	}

	@Override
	public boolean deplacerGauchePosition4(ITable theGrille, Piece thePiece) {
		int indexNumeCellPosRefPiece = thePiece.getIndexCellulePositionRef();
		int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

		if (indexNumeCellPosRefPiece < 1) {
			return false;
		}

		ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece - 1);
		if (cell1.estOccupe()) {
			return false;
		}

		ICell cel2 = theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece - 1);
		if (cel2.estOccupe()) {
			return false;
		}

		ICell cel3 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece - 1);
		if (cel3.estOccupe()) {
			return false;
		}

		// Liberation de 3 cellules
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece + 1).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece).fixeLibre();

		// Remplissage de 3 cellules
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece - 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece - 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece - 1).setOccupe(thePiece.getColor());

		// Deplacement de la piece.
		thePiece.setIndexCellulePositionRef(thePiece.getIndexCellulePositionRef() - 1);

		return true;

	}

	@Override
	public boolean rotationPosition1(ITable theGrille, Piece thePiece) {
		int indexNumCellPosRefPiece = thePiece.getIndexCellulePositionRef();
		int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

		if (indexNumLigPosRefPiece < 1) {
			return false;
		}

		ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumCellPosRefPiece);
		if (cell1.estOccupe()) {
			return false;
		}

		ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece);
		if (cell2.estOccupe()) {
			return false;
		}

		ICell cell3 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece - 1);
		if (cell3.estOccupe()) {
			return false;
		}

		// Liberation de 3 cellules.
		theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece - 1).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece + 1).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece + 1).fixeLibre();

		// Remplissage de 3 cellule.
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumCellPosRefPiece).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece - 1).setOccupe(thePiece.getColor());

		// Rotation de la piece.
		thePiece.rotation();

		return true;
	}

	@Override
	public boolean rotationPosition2(ITable theGrille, Piece thePiece) {
		int indexNumCellPosRefPiece = thePiece.getIndexCellulePositionRef();
		int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

		IRow row1 = theGrille.getRow(indexNumLigPosRefPiece);
		int nbCellule = row1.getCellNumber();

		if (indexNumCellPosRefPiece > nbCellule - 2) {
			return false;
		}

		ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece - 1);
		if (cell1.estOccupe()) {
			return false;
		}
		
		ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumCellPosRefPiece - 1);
		if (cell2.estOccupe()) {
			return false;
		}
		
		ICell cell3 = theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece + 1);
		if (cell3.estOccupe()) {
			return false;
		}

		// Liberation de 2 cellules.
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumCellPosRefPiece).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece - 1).fixeLibre();

		
		// Remplissage de 2 cellules.
		theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece - 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumCellPosRefPiece - 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece + 1).setOccupe(thePiece.getColor());

		// Rotation de la piece.
		thePiece.rotation();

		return true;
	}

	@Override
	public boolean rotationPosition3(ITable theGrille, Piece thePiece) {
		int indexNumCellPosRefPiece = thePiece.getIndexCellulePositionRef();
		int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

		int nombreLignes = theGrille.getRowNumber();

		if (indexNumLigPosRefPiece > nombreLignes - 2) {
			return false;
		}

		ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumCellPosRefPiece);
		if (cell1.estOccupe()) {
			return false;
		}
		
		ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece);
		if (cell2.estOccupe()) {
			return false;
		}
		
		ICell cell3 = theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumCellPosRefPiece + 1);
		if (cell3.estOccupe()) {
			return false;
		}

		// Liberation de 3 cellules.
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumCellPosRefPiece - 1).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece - 1).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece + 1).fixeLibre();

		// Remplissage de 3 cellule.
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumCellPosRefPiece).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumCellPosRefPiece + 1).setOccupe(thePiece.getColor());

		// Rotation de la piece.
		thePiece.rotation();

		return true;
	}

	@Override
	public boolean rotationPosition4(ITable theGrille, Piece thePiece) {
		int indexNumCellPosRefPiece = thePiece.getIndexCellulePositionRef();
		int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

		if (indexNumCellPosRefPiece < 1) {
			return false;
		}

		ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece - 1);
		if (cell1.estOccupe()) {
			return false;
		}
		
		ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece + 1);
		if (cell2.estOccupe()) {
			return false;
		}
		
		ICell cell3 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece + 1);
		if (cell3.estOccupe()) {
			return false;
		}

		// Liberation de 3 cellules.
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumCellPosRefPiece).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumCellPosRefPiece + 1).fixeLibre();

		// Remplissage de 3 cellule.
		theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece - 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece + 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece + 1).setOccupe(thePiece.getColor());

		// Rotation de la piece.
		thePiece.rotation();

		return true;
	}

	protected boolean affiche(ITable theGrille, Piece thePiece) {
		int indexCelPosRef = thePiece.getIndexCellulePositionRef();
		int indexLigPosRef = thePiece.getIndexLignePositionRef();

		if (theGrille.getCell(indexLigPosRef, indexCelPosRef - 1).estOccupe()) {
			return false;
		}

		if (theGrille.getCell(indexLigPosRef, indexCelPosRef).estOccupe()) {
			return false;
		}

		if (theGrille.getCell(indexLigPosRef, indexCelPosRef + 1).estOccupe()) {
			return false;
		}

		if (theGrille.getCell(indexLigPosRef + 1, indexCelPosRef + 1).estOccupe()) {
			return false;
		}

		return true;

	}

}
