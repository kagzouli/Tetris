package com.piece.aire.grille;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.piece.exception.TechnicalException;

public class RowImpl implements IRow
{
    private transient List listCell;

    public RowImpl()
    {
        listCell = new ArrayList();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public void addCell(ICell cell)
    {
        listCell.add(cell);
    }

    /**
     * 
     * {@inheritDoc}
     */
    public int getCellNumber()
    {
        return listCell.size();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public ICell getCell(int index)
    {
        return (ICell) listCell.get(index);
    }

    /**
     * 
     * {@inheritDoc}
     */
    public Iterator iterator()
    {
        return (listCell != null) ? listCell.iterator() : null;
    }

    /**
     * 
    * {@inheritDoc}
     */
    public void draw(Graphics theGc)
    {
        if (this != null)
        {
            Iterator itCell = this.iterator();

            while (itCell.hasNext())
            {
                ICell cell = (ICell) itCell.next();
                cell.draw(theGc, cell.getPosX(), cell.getPosY(), cell.getLongueur(), cell.getLargeur());
            }
        }
    }

    public boolean supprimeLigne()
    {
        boolean supprimeLigne = false;
        List listCell = this.listCell;
        if ((listCell != null) && (!listCell.isEmpty())){
            Iterator itCell = listCell.iterator();
            supprimeLigne = true;
            while (itCell.hasNext()){
                ICell cell = (ICell) itCell.next();
                if (cell.estLibre()){
                    supprimeLigne = false;
                    break;
                }
            }
        }
        
        return supprimeLigne;
    }

    public void setCell(int theIndex, ICell theCell)
    {
        listCell.set(theIndex,theCell);
        
    }

}
