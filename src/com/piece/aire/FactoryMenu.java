package com.piece.aire;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public final class FactoryMenu
{
    
    private static final String FILE_ITEM = "Fichier";
    
    private static final String FILE_NEW = "Nouveau";
    
    private static final String FILE_OPEN = "Ouvrir";
    
    private static final String FILE_SAVE = "Enregistrer";
    
    private static final String FILE_EXIT = "Quitter";
    
    private static final char MNEMONIC_FILE_ITEM = 'F';
    
    private static final String FILE_HELP = "Aide";
    
    private static final String FILE_WELCOME = "Bonjour"; 
    
    private static final char MNEMONIC_FILE_HELP = 'A';
    
    
    /**
     * Methode permettant de construire le menu.<br/>
     * 
     */
    public static JMenuBar createMenu(){
        
        JMenuBar menu = new JMenuBar();
        
        JMenu fichier = new JMenu(FILE_ITEM);
        JMenuItem nouveau = new JMenuItem(FILE_NEW);
        nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        fichier.add(nouveau);
        JMenuItem ouvrir = new JMenuItem(FILE_OPEN);
        ouvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        fichier.add(ouvrir);
        JMenuItem enregistrer = new JMenuItem(FILE_SAVE);
        enregistrer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        fichier.add(enregistrer);
        JMenuItem quitter = new JMenuItem(FILE_EXIT);
        fichier.add(quitter);
        fichier.setMnemonic(MNEMONIC_FILE_ITEM);
        menu.add(fichier);
        
        JMenu aide = new JMenu(FILE_HELP);
        JMenuItem welcome = new JMenuItem(FILE_WELCOME);
        aide.add(welcome);
        aide.setMnemonic(MNEMONIC_FILE_HELP);
        menu.add(aide);
        
        return menu;
       
    }

}
