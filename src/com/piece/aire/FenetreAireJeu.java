package com.piece.aire;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.piece.action.DispatchActionJoueurs;
import com.piece.constant.Constante;
import com.piece.exception.TechnicalException;
import com.piece.message.MessageRessources;

public class FenetreAireJeu implements ActionListener
{
    
  
    private transient Log log = LogFactory.getLog(FenetreAireJeu.class);

    /**
     * Frame.<br/>
     */
    protected transient JFrame frame;
    
    /**
     * Aire de jeu.<br/>
     */    
    protected transient AireJeu aireJeu;

    /**
     * Singleton representant l'aire de jeu.<br/>
     */
    protected static FenetreAireJeu fenetreAireJeu = new FenetreAireJeu();

   
    /**
     * Constructeur prive.
     *
     */
    protected FenetreAireJeu(){
        
    }

    /**
     * Methode permettant de retourner une aire de jeu.<br/>
     * 
     * @return retourne une aire de jeu.<br/>
     */
    public static FenetreAireJeu getInstance()
    {
        return fenetreAireJeu;
    }

    /**
     * Cette methode permet d'initialiser la fenetre.<br/>
     * 
     * @param isModeSolo Mode 1 joueur.<br/>
     * @throws TechnicalException Erreur technique.<br/>
     */
    public void start(final boolean isModeSolo) throws TechnicalException
    {
        log.info("DEBUT de la methode init de la classe "+this.getClass().getName());
 
        try
        {
            frame = new JFrame();        	
        	  
            Integer longueur = MessageRessources.getInstance(Constante.BUNDLE_NAME_AIREJEU).getMessageInteger(Constante.CLE_LONGUEUR);
            Integer largeur = MessageRessources.getInstance(Constante.BUNDLE_NAME_AIREJEU).getMessageInteger(Constante.CLE_LARGEUR);
            frame.setSize(longueur.intValue(), largeur.intValue());
            
            //Centre la fenetre.
            this.centrerFenetre();
            
            //Definit l'environnement graphique.
            this.definirEnvironnementGraphique();
            
            //Menu le menu
            frame.setJMenuBar(FactoryMenu.createMenu());
            frame.setBackground(Color.BLACK);
            
            
            // Recupere le panel de la frame.
            JPanel container = (JPanel) frame.getContentPane();
            container.setLayout(new BorderLayout());
            
            //Initialise l'aire de jeu.
            AireJeu.getInstance().init(isModeSolo);
            frame.setContentPane(AireJeu.getInstance());
            
            //Initialisation du listener du clavier
            frame.addKeyListener(new DispatchActionJoueurs(isModeSolo));
            
            //Active la suppression de la fenetre
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            //Rend la fenetre visible.
            frame.setVisible(true);

        } catch (Exception e)
        {
            log.error(e,e);
            throw new TechnicalException(e);
        }
        log.info("FIN de la methode init de la classe "+this.getClass().getName());
        

    }

    /**
     * Methode permettant de centrer la fenetre.<br/>
     * 
     */
    protected void centrerFenetre()
    {
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((screenSize.width - frame.getWidth()) / 2, (screenSize.height - frame.getHeight()) / 2);
    }

    /**
     * Methode permettant de definir l'environnement graphique.<br/>
     * @throws TechnicalException.  Erreur technique.<br/>
     */
    public void definirEnvironnementGraphique() throws TechnicalException
    {
        try
        {
            String sys = System.getProperty("os.name");

            // Pour linux, on utilise le systeme par default
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        }

        catch (Exception e)
        {
            log.error(e,e);
            throw new TechnicalException(e);
        }
    }

    public void actionPerformed(ActionEvent theEvent)
    {
        // TODO Auto-generated method stub

    }

}
