package com.piece.tetris;

/**
 * Factory permettant de creer une piece
 * 
 */
public class FactoryPiece {
	private static final int NBR_PIECE = 7;

	private static FactoryPiece factoryPiece = new FactoryPiece();

	/**
	 * Constructeur.
	 * 
	 */
	protected FactoryPiece() {

	}

	/**
	 * Methode permettant de recuperer la factory pour creer une piece.<br/>
	 * 
	 * @return Retourne la factory permettant de recuperer une piece.<br/>
	 */
	public static FactoryPiece getInstance() {
		return factoryPiece;
	}

	public Piece createPiece() {
		Piece piece = null;
		double nombreAuHasard = Math.random();

		int identifiant = ((int) (nombreAuHasard * NBR_PIECE)) + 1;
		
		switch (identifiant) {
		case IdentifiantPiece.IDENTIFIANT_BARRE_HOR:
			piece = new BarreHorizontale();
			break;

		case IdentifiantPiece.IDENTIFIANT_CARRE:
			piece = new Carre();
			break;

		case IdentifiantPiece.IDENTIFIANT_PIET:
			piece = new PieT();
			break;
		
		case IdentifiantPiece.IDENTIFIANT_PISTOLET_DROIT :
			piece = new PistoletDroit();
			break;		
	
		case IdentifiantPiece.IDENTIFIANT_PISTOLET_GAUCHE :
			piece = new PistoletGauche();
			break;
		
		case IdentifiantPiece.IDENTIFIANT_PIECEZ : 
			piece = new PieceZ();
			break;
			
		case IdentifiantPiece.IDENTIFIANT_PIECEZINVERSE : 
			piece = new PieceInverseZ();
			break;
		}

		return piece;

	}

}
