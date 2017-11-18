package com.piece.main;

import com.piece.aire.ConfigurationTetris;


public class Starter
{   
    public static void main(String[] args){
        try
        {
        	ConfigurationTetris configurationTetris = new ConfigurationTetris();
        	configurationTetris.display();
        } catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }

}
