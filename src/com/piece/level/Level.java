package com.piece.level;

public class Level
{
    
    /**
     * Label level.<br/>
     */
    private String label;
    
    /**
     * Timer.<br/>
     */
    private Integer timer;
    
    /**
     * Nombre de points min.<br/>
     */
    private Integer nbPointMin;
    
    /**
     * Nombre de points max.<br/>
     */
    private Integer nbPointMax;
    
    public Level(){
        this.timer = new Integer(0);
        this.nbPointMin = new Integer(0);
    }

    public Level(String label,Integer theTimer,Integer theNbPointMin,Integer theNbPointMax){
        this.label = label;
        this.timer = theTimer;
        this.nbPointMin = theNbPointMin;
        this.nbPointMax = theNbPointMax;
    }
    
    public Integer getNbPointMin()
    {
        return nbPointMin;
    }

    public void setNbPointMin(Integer theNbPoint)
    {
        this.nbPointMin = theNbPoint;
    }

    public Integer getTimer()
    {
        return timer;
    }

    public void setTimer(Integer theTimer)
    {
        this.timer = theTimer;
    }

    public Integer getNbPointMax()
    {
        return nbPointMax;
    }

    public void setNbPointMax(Integer theNbPointMax)
    {
        nbPointMax = theNbPointMax;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String theLabel)
    {
        label = theLabel;
    }

}
