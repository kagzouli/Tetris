package com.piece.aire.grille;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.piece.exception.TechnicalException;

public class TableImpl implements ITable
{
    private transient List listRow;
    
    public TableImpl(){
        listRow = new ArrayList();
    }
    
    /**
     * 
    * {@inheritDoc}
     */
    public void addRow(IRow row){
        listRow.add(row);
    }
    
    /**
     * *
    * {@inheritDoc}
     */
    public int getRowNumber(){
        return listRow.size();
    }
    
    public IRow getRow(int index){
        return (IRow) listRow.get(index);
    }

    public Iterator iterator() 
    {
        return (listRow != null) ? listRow.iterator() : null;
    }

    public void draw(Graphics theGc)
    {
        if (this != null){
            Iterator itRow = this.iterator();
            while (itRow.hasNext()){
                IRow row = (IRow) itRow.next();
                row.draw(theGc);
            }
            
        }
    }

    /**
     * 
    * {@inheritDoc}
     */
    public ICell getCell(int theIndexLigne, int theIndexColonne)
    {
        ICell cell = null;
        IRow row = this.getRow(theIndexLigne);
        if (row != null){
            cell =  row.getCell(theIndexColonne);
        }
        return cell;
    }
    
    

    public int supprimeLignePleine()
    {
        int nombreLigneSupprime = 0;
        List listRow = this.listRow;
        if ((listRow != null) && (!listRow.isEmpty())){
            Iterator itRow = listRow.iterator();
            while (itRow.hasNext()){
                IRow row = (IRow) itRow.next();
                boolean supprimeLigne =  row.supprimeLigne();
                if (supprimeLigne){
                    itRow.remove();
                    nombreLigneSupprime = nombreLigneSupprime + 1;
                }
            }
        }
        return nombreLigneSupprime;
    }

    public void setCell(int theIndexLigne, int theIndexColonne, ICell theCell)
    {
        ICell cell = null;
        IRow row = this.getRow(theIndexLigne);
        if (row != null){
            row.setCell(theIndexColonne,cell);
        }
    }
    
    public void reset(){
    	 if (this != null){
             Iterator itRow = this.iterator();
             while (itRow.hasNext()){
                 IRow row = (IRow) itRow.next();
                 if (row != null){
                	 Iterator itCell = row.iterator();
                	 while (itCell.hasNext()){
                		 ((ICell) itCell.next()).fixeLibre();
                	 }
                 }
             }
             
         }
    }
    
    

  
}
