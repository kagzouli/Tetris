package com.piece.tetris;

import java.awt.Color;

public abstract class Piece
{
    /**
     * Position1.<br/>
     */
    public static final int POSITION_1 = 1;
    
    /**
     * Position2.<br/>
     */
    public static final int POSITION_2 = 2;
    
    /**
     * Position3.<br/>
     */
    public static final int POSITION_3 = 3;
    
    /**
     * Position4.<br/>
     */
    public static final int POSITION_4 = 4;
    
    /**
     * index ligne position reference.<br/>
     */
    protected int indexLignePositionRef;
    
    /**
     * Index cellule.<br/>
     */
    protected int indexCellulePositionRef;
    
    /**
     * Attribut pour savoir si on peut bouger la piece.<br/>
     */
    protected boolean bloque = false;
    
    /**
     * Position.<br/>
     */
    protected int position;
    
    /**
     * Index position ligne optimal du centre de la piece.<br/>
     */
    protected Integer indexPosLigneOptimal;
    
    
    /**
     * Index position colonne optimal du centre de la piece.<br/>
     */
    protected Integer indexPosCellOptimal;
    
    /** Position piece optimal **/
    protected Integer positionPieceOptimal;
    
    public int getPosition()
    {
        return position;
    }

    /**
     * Methode permettant de prendre une couleur pour la piece.<br/>
     * @return Retourne une couleur pour la piece.<br/>
     */
    public abstract Color getColor();


    public int getIndexCellulePositionRef()
    {
        return indexCellulePositionRef;
    }

    public void setIndexCellulePositionRef(int theIndexCellulePositionRef)
    {
        indexCellulePositionRef = theIndexCellulePositionRef;
    }

    public int getIndexLignePositionRef()
    {
        return indexLignePositionRef;
    }

    public void setIndexLignePositionRef(int theIndexLignePositionRef)
    {
        indexLignePositionRef = theIndexLignePositionRef;
    }

    public void setPosition(int thePosition)
    {
        position = thePosition;
    }
    
    /**
     * Methode permettant de mettre a jour la position de la piece.<br/>
     *
     */
    public void rotation(){
        int position = this.position;
        
        if (position == POSITION_1){
            this.position = POSITION_2;
        }
        
        if (position == POSITION_2){
            this.position = POSITION_3;
        }
        
        if (position == POSITION_3){
            this.position = POSITION_4;
        }
        
        if (position == POSITION_4){
            this.position = POSITION_1;
        }
    }

    public boolean isBloque()
    {
        return bloque;
    }

    public void setBloque(boolean theBloque)
    {
        bloque = theBloque;
    }
    
    public Integer getIndexPosLigneOptimal(){
    	return indexPosLigneOptimal;
    }
    
    public void setIndexPosLigneOptimal(final Integer indexPosLigneOptimal){
    	this.indexPosLigneOptimal = indexPosLigneOptimal;
    }

	public Integer getIndexPosCellOptimal() {
		return indexPosCellOptimal;
	}

	public void setIndexPosCellOptimal(Integer indexPosCellOptimal) {
		this.indexPosCellOptimal = indexPosCellOptimal;
	}

	public Integer getPositionPieceOptimal() {
		return positionPieceOptimal;
	}

	public void setPositionPieceOptimal(Integer positionPieceOptimal) {
		this.positionPieceOptimal = positionPieceOptimal;
	}
}
