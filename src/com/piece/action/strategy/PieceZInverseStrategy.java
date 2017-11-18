package com.piece.action.strategy;

import com.piece.aire.grille.ICell;
import com.piece.aire.grille.IRow;
import com.piece.aire.grille.ITable;
import com.piece.tetris.Piece;

public class PieceZInverseStrategy extends PieceStrategy {

	@Override
	public boolean afficherInitialPiece(ITable theGrille, Piece thePiece) {
		int indexCelPosRef = thePiece.getIndexCellulePositionRef();
		int indexLigPosRef = thePiece.getIndexLignePositionRef();

		boolean affiche = this.affiche(theGrille, thePiece);

		if (affiche) {
			theGrille.getCell(indexLigPosRef, indexCelPosRef + 1).setOccupe(thePiece.getColor());
			theGrille.getCell(indexLigPosRef, indexCelPosRef).setOccupe(thePiece.getColor());
			theGrille.getCell(indexLigPosRef + 1, indexCelPosRef).setOccupe(thePiece.getColor());
			theGrille.getCell(indexLigPosRef + 1, indexCelPosRef - 1).setOccupe(thePiece.getColor());
		}

		return affiche;
	}

	@Override
	public boolean deplacerBasPosition1(ITable theGrille, Piece thePiece) {
		return this.deplacerBasPos1Pos3(theGrille, thePiece);
	}

	@Override
	public boolean deplacerBasPosition2(ITable theGrille, Piece thePiece) {
		return this.deplacerBasPos2Pos4(theGrille,thePiece);
	}

	@Override
	public boolean deplacerBasPosition3(ITable theGrille, Piece thePiece) {
		return this.deplacerBasPos1Pos3(theGrille, thePiece);
	}

	@Override
	public boolean deplacerBasPosition4(ITable theGrille, Piece thePiece) {
		return this.deplacerBasPos2Pos4(theGrille,thePiece);
	}

	@Override
	public boolean deplacerDroitePosition1(ITable theGrille, Piece thePiece) {
		return this.deplacerDroitePos1Pos3(theGrille,thePiece);
	}

	@Override
	public boolean deplacerDroitePosition2(ITable theGrille, Piece thePiece) {
		return this.deplacerDroitePos2Pos4(theGrille, thePiece);
	}

	@Override
	public boolean deplacerDroitePosition3(ITable theGrille, Piece thePiece) {
		return this.deplacerDroitePos1Pos3(theGrille,thePiece);
	}

	@Override
	public boolean deplacerDroitePosition4(ITable theGrille, Piece thePiece) {
		return this.deplacerDroitePos2Pos4(theGrille, thePiece);
	}

	@Override
	public boolean deplacerGauchePosition1(ITable theGrille, Piece thePiece) {
		return this.deplacerGauchePos1Pos3(theGrille,thePiece);
	}

	@Override
	public boolean deplacerGauchePosition2(ITable theGrille, Piece thePiece) {
		return this.deplacerGauchePos2Pos4(theGrille,thePiece);
	}

	@Override
	public boolean deplacerGauchePosition3(ITable theGrille, Piece thePiece) {
		return this.deplacerGauchePos1Pos3(theGrille,thePiece);
}

	@Override
	public boolean deplacerGauchePosition4(ITable theGrille, Piece thePiece) {
		return this.deplacerGauchePos2Pos4(theGrille,thePiece);
	}

	@Override
	public boolean rotationPosition1(ITable theGrille, Piece thePiece) {
		return this.rotationPiecePos1Pos3(theGrille, thePiece);
	}

	@Override
	public boolean rotationPosition2(ITable theGrille, Piece thePiece) {
		return this.rotationPiecePos2Pos4(theGrille, thePiece);
	}

	@Override
	public boolean rotationPosition3(ITable theGrille, Piece thePiece) {
		return this.rotationPiecePos1Pos3(theGrille, thePiece);
	}

	@Override
	public boolean rotationPosition4(ITable theGrille, Piece thePiece) {
		return this.rotationPiecePos2Pos4(theGrille, thePiece);
	}

	/**
	 * Methode permettant de deplacer vers le bas pour la position1 et 3.<br/>
	 * 
	 * @param theGrille
	 *            La grille.<br/>
	 * @param thePiece
	 *            La piece.<br/>
	 * @return Retourne vrai si on peut deplacer la piece, faux sinon.<br/>
	 */
	protected boolean deplacerBasPos1Pos3(ITable theGrille, Piece thePiece) {
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

		ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece + 1);
		if (cell1.estOccupe()) {
			thePiece.setBloque(true);
			return false;
		}

		ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumeCellPosRefPiece - 1);
		if (cell2.estOccupe()) {
			thePiece.setBloque(true);
			return false;
		}

		ICell cell3 = theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumeCellPosRefPiece);
		if (cell3.estOccupe()) {
			thePiece.setBloque(true);
			return false;
		}

		// Liberation de 3 cellules.
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece + 1).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece - 1).fixeLibre();

		// Remplissage de 3 cellules
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece + 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumeCellPosRefPiece - 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumeCellPosRefPiece).setOccupe(thePiece.getColor());

		// Deplacement de la piece.
		thePiece.setIndexLignePositionRef(thePiece.getIndexLignePositionRef() + 1);
		return true;
	}
	
	 /**
     * Methode permettant de deplacer la pieceInverseZ dans la position 2 et position 4.<br/>
     * 
     * @param theGrille La grille.<br/>
     * @param thePiece La piece.<br/>
     * @return Retourne vrai si on peut deplacer la pieceInverseZ, faux sinon.<br/>
     */
	protected boolean deplacerBasPos2Pos4(ITable theGrille, Piece thePiece) {
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

		ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumeCellPosRefPiece);
		if (cell2.estOccupe()) {
			thePiece.setBloque(true);
			return false;
		}

		// Liberation de 2 cellules
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece - 1).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece).fixeLibre();

		// Remplissage de 2 cellules
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece - 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece + 2, indexNumeCellPosRefPiece).setOccupe(thePiece.getColor());

		// Deplacement de la piece.
		thePiece.setIndexLignePositionRef(thePiece.getIndexLignePositionRef() + 1);
		return true;
	}
	
	 /**
     * Methode permettant de deplacer la piece dans la position 1 et 3.<br/>
     * @param theGrille La grille.<br/>
     * @param thePiece La piece.<br/>
     * @return Retourne vrai si pas collision, faux sinon.<br/>
     */
	protected boolean deplacerGauchePos1Pos3(ITable theGrille, Piece thePiece) {
		int indexNumeCellPosRefPiece = thePiece.getIndexCellulePositionRef();
		int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

		if (indexNumeCellPosRefPiece < 2) {
			return false;
		}

		ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece - 2);
		if (cell1.estOccupe()) {
			return false;
		}

		ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece - 1);
		if (cell2.estOccupe()) {
			return false;
		}

		// Liberation de 2 cellules
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece + 1).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece).fixeLibre();

		// Remplissage de 2 cellules
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece - 2).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece - 1).setOccupe(thePiece.getColor());

		// Deplacement de la piece.
		thePiece.setIndexCellulePositionRef(thePiece.getIndexCellulePositionRef() - 1);

		return true;
	}
	
	 /**
     * Methode permettant de deplacer la piece dans la position 2 et 4.<br/>
     * @param theGrille La grille.<br/>
     * @param thePiece La piece.<br/>
     * @return Retourne vrai si pas collision, faux sinon.<br/>
     */
	protected boolean deplacerGauchePos2Pos4(ITable theGrille, Piece thePiece) {
		int indexNumeCellPosRefPiece = thePiece.getIndexCellulePositionRef();
		int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

		if (indexNumeCellPosRefPiece < 2) {
			return false;
		}

		ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece - 1);
		if (cell1.estOccupe()) {
			return false;
		}

		ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece , indexNumeCellPosRefPiece - 2);
		if (cell2.estOccupe()) {
			return false;
		}

		ICell cell3 = theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece - 2);
		if (cell3.estOccupe()) {
			thePiece.setBloque(true);
			return false;
		}

		// Liberation de 3 cellules
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece - 1).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece).fixeLibre();

		// Remplissage de 3 cellules
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece - 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece , indexNumeCellPosRefPiece - 2).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece - 2).setOccupe(thePiece.getColor());

		// Deplacement de la piece.
		thePiece.setIndexCellulePositionRef(thePiece.getIndexCellulePositionRef() - 1);

		return true;
	}
	
	/**
     * Methode permettant de deplacer la pieceInverseZ dans la position 1 et position 3.<br/>
     * 
     * @param theGrille La grille.<br/>
     * @param thePiece La piece.<br/>
     * @return Retourne vrai si on peut deplacer la barre, faux sinon.<br/>
     */
	protected boolean deplacerDroitePos1Pos3(ITable theGrille, Piece thePiece) {
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

		ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece + 1);
		if (cell1.estOccupe()) {
			return false;
		}

		ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece + 2);
		if (cell2.estOccupe()) {
			return false;
		}

		// Liberation de 2 cellules
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece - 1).fixeLibre();

		// Remplissage de 2 cellules
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece + 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece + 2).setOccupe(thePiece.getColor());

		// Deplacement de la piece.
		thePiece.setIndexCellulePositionRef(thePiece.getIndexCellulePositionRef() + 1);

		return true;
	}
	
	 /**
     * Methode permettant de deplacer la pieceZ dans la position 2 et position 4.<br/>
     * 
     * @param theGrille La grille.<br/>
     * @param thePiece La piece.<br/>
     * @return Retourne vrai si on peut deplacer la pieceZ, faux sinon.<br/>
     */
	protected boolean deplacerDroitePos2Pos4(ITable theGrille, Piece thePiece) {
		int indexNumeCellPosRefPiece = thePiece.getIndexCellulePositionRef();
		int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

		IRow row = (IRow) theGrille.getRow(indexNumLigPosRefPiece);
		int nombreCellules = row.getCellNumber();

		if (indexNumeCellPosRefPiece + 1 >= nombreCellules) {
			return false;
		}

		ICell cel1 = theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece);
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
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece - 1).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece - 1).fixeLibre();

		// Remplissage de 3 cellules
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumeCellPosRefPiece).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece, indexNumeCellPosRefPiece + 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumeCellPosRefPiece + 1).setOccupe(thePiece.getColor());

		// Deplacement de la piece.
		thePiece.setIndexCellulePositionRef(thePiece.getIndexCellulePositionRef() + 1);

		return true;
	}
	


	/**
	 * Methode permettant de faire la rotation pour les positions 1 et 3.<br/>
	 * 
	 * @param theGrille
	 *            La grille.<br/>
	 * @param thePiece
	 *            La piece.<br/>
	 * @return Retourne vrai s'il y'a pas eu collision, faux sinon.<br/>
	 */

	public boolean rotationPiecePos1Pos3(ITable theGrille, Piece thePiece) {
		int indexNumCellPosRefPiece = thePiece.getIndexCellulePositionRef();
		int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

		if (indexNumLigPosRefPiece < 1) {
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

		// Liberation de 1 cellules.
		theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece + 1).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece - 1).fixeLibre();

		// Remplissage de 1 cellule.
		theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece - 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumCellPosRefPiece - 1).setOccupe(thePiece.getColor());

		// Rotation de la piece.
		thePiece.rotation();

		return true;
	}

	/**
	 * Methode permettant de faire la rotation pour les positions 2 et 4.<br/>
	 * 
	 * @param theGrille
	 *            La grille.<br/>
	 * @param thePiece
	 *            La piece.<br/>
	 * @return Retourne vrai s'il y'a pas eu collision, faux sinon.<br/>
	 */

	public boolean rotationPiecePos2Pos4(ITable theGrille, Piece thePiece) {
		int indexNumCellPosRefPiece = thePiece.getIndexCellulePositionRef();
		int indexNumLigPosRefPiece = thePiece.getIndexLignePositionRef();

		if (indexNumCellPosRefPiece < 1) {
			return false;
		}

		ICell cell1 = theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece + 1);
		if (cell1.estOccupe()) {
			return false;
		}

		ICell cell2 = theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece - 1);
		if (cell2.estOccupe()) {
			return false;
		}

		// Liberation de 2 cellules.
		theGrille.getCell(indexNumLigPosRefPiece - 1, indexNumCellPosRefPiece - 1).fixeLibre();
		theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece - 1).fixeLibre();

		// Remplissage de 2 cellules.
		theGrille.getCell(indexNumLigPosRefPiece, indexNumCellPosRefPiece + 1).setOccupe(thePiece.getColor());
		theGrille.getCell(indexNumLigPosRefPiece + 1, indexNumCellPosRefPiece - 1).setOccupe(thePiece.getColor());

		// Rotation de la piece.
		thePiece.rotation();

		return true;
	}

	protected boolean affiche(ITable theGrille, Piece thePiece) {
		int indexCelPosRef = thePiece.getIndexCellulePositionRef();
		int indexLigPosRef = thePiece.getIndexLignePositionRef();

		if (theGrille.getCell(indexLigPosRef, indexCelPosRef + 1).estOccupe()) {
			return false;
		}

		if (theGrille.getCell(indexLigPosRef, indexCelPosRef).estOccupe()) {
			return false;
		}

		if (theGrille.getCell(indexLigPosRef + 1, indexCelPosRef).estOccupe()) {
			return false;
		}

		if (theGrille.getCell(indexLigPosRef + 1, indexCelPosRef - 1).estOccupe()) {
			return false;
		}

		return true;
	}

}
