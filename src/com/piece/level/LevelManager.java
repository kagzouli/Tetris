package com.piece.level;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.piece.constant.Constante;
import com.piece.exception.TechnicalException;
import com.piece.message.MessageRessources;

/**
 * Constante contenant l'ensemble des valeurs pour les levels.
 * 
 * @author x587368
 * 
 */
public class LevelManager
{
    /**
     * log.<br/>
     */
    private Log log = LogFactory.getLog(LevelManager.class);

    /**
     * Level 0.<br/>
     */
    public static final String LEVEL_0 = "LEVEL_0";

    /**
     * Level 1.<br/>
     */
    public static final String LEVEL_1 = "LEVEL_1";

    /**
     * Level 2.<br/>
     */
    public static final String LEVEL_2 = "LEVEL_2";

    /**
     * Level 3.<br/>
     */
    public static final String LEVEL_3 = "LEVEL_3";

    /**
     * Level 4.<br/>
     */
    public static final String LEVEL_4 = "LEVEL_4";

    /**
     * Level 5.<br/>
     */
    public static final String LEVEL_5 = "LEVEL_5";

    /**
     * Level 6.<br/>
     */
    public static final String LEVEL_6 = "LEVEL_6";

    /**
     * Level 7.<br/>
     */
    public static final String LEVEL_7 = "LEVEL_7";

    /**
     * Level 8.<br/>
     */
    public static final String LEVEL_8 = "LEVEL_8";

    /**
     * 
     */
    private static LevelManager leverManager = new LevelManager();

    /**
     * Map contenant les levels.
     */
    private Map mapLevel = null;

    protected LevelManager()
    {
        mapLevel = new HashMap();
    }

    /**
     * Recupere l'instance du leve.<br/>
     * 
     * @return Retourne l'instance du level.
     */
    public static LevelManager getInstance()
    {
        return leverManager;
    }

    /**
     * Methode permettant d'initialiser les levels.<br/>
     * 
     * @throws TechnicalException Erreur technique.<br/>
     */
    public void init() throws TechnicalException
    {

        log.info(new StringBuffer().append("DEBUT de la methode init de la classe ").append(this.getClass().getName()).toString());

        MessageRessources messages = MessageRessources.getInstance(Constante.BUNDLE_NAME_AIREJEU);

        // Recupere le level 0
        Integer timerLevel0 = messages.getMessageInteger(Constante.CLE_TEMPS_TIMER_LEVEL0);
        Integer nbPointLevel0 = messages.getMessageInteger(Constante.CLE_NBPOINT_TIMER_LEVEL0);
        Level level0 = new Level(Constante.LABEL_LEVEL0,timerLevel0, new Integer(0), nbPointLevel0);

        mapLevel.put(LevelManager.LEVEL_0, level0);
        log.info("Ajout du level 0");

        // Recupere le level 1
        Integer timerLevel1 = messages.getMessageInteger(Constante.CLE_TEMPS_TIMER_LEVEL1);
        Integer nbPointLevel1 = messages.getMessageInteger(Constante.CLE_NBPOINT_TIMER_LEVEL1);
        Level level1 = new Level(Constante.LABEL_LEVEL1,timerLevel1, nbPointLevel0, nbPointLevel1);
        mapLevel.put(LevelManager.LEVEL_1, level1);
        log.info("Ajout du level 1");

        // Recupere le level 2
        Integer timerLevel2 = messages.getMessageInteger(Constante.CLE_TEMPS_TIMER_LEVEL2);
        Integer nbPointLevel2 = messages.getMessageInteger(Constante.CLE_NBPOINT_TIMER_LEVEL2);
        Level level2 = new Level(Constante.LABEL_LEVEL2,timerLevel2, nbPointLevel1, nbPointLevel2);
        mapLevel.put(LevelManager.LEVEL_2, level2);
        log.info("Ajout du level 2");

        // Recupere le level 3
        Integer timerLevel3 = messages.getMessageInteger(Constante.CLE_TEMPS_TIMER_LEVEL3);
        Integer nbPointLevel3 = messages.getMessageInteger(Constante.CLE_NBPOINT_TIMER_LEVEL3);
        Level level3 = new Level(Constante.LABEL_LEVEL3,timerLevel3, nbPointLevel2, nbPointLevel3);
        mapLevel.put(LevelManager.LEVEL_3, level3);
        log.info("Ajout du level 3");

        // Recupere le level 4
        Integer timerLevel4 = messages.getMessageInteger(Constante.CLE_TEMPS_TIMER_LEVEL4);
        Integer nbPointLevel4 = messages.getMessageInteger(Constante.CLE_NBPOINT_TIMER_LEVEL4);
        Level level4 = new Level(Constante.LABEL_LEVEL4,timerLevel4, nbPointLevel3, nbPointLevel4);
        mapLevel.put(LevelManager.LEVEL_4, level4);
        log.info("Ajout du level 4");

        // Recupere le level 5
        Integer timerLevel5 = messages.getMessageInteger(Constante.CLE_TEMPS_TIMER_LEVEL5);
        Integer nbPointLevel5 = messages.getMessageInteger(Constante.CLE_NBPOINT_TIMER_LEVEL5);
        Level level5 = new Level(Constante.LABEL_LEVEL5,timerLevel5, nbPointLevel4, nbPointLevel5);
        mapLevel.put(LevelManager.LEVEL_5, level5);
        log.info("Ajout du level 5");

        // Recupere le level 6
        Integer timerLevel6 = messages.getMessageInteger(Constante.CLE_TEMPS_TIMER_LEVEL6);
        Integer nbPointLevel6 = messages.getMessageInteger(Constante.CLE_NBPOINT_TIMER_LEVEL6);
        Level level6 = new Level(Constante.LABEL_LEVEL6,timerLevel6, nbPointLevel5, nbPointLevel6);
        mapLevel.put(LevelManager.LEVEL_6, level6);
        log.info("Ajout du level 6");

        // Recupere le level 7
        Integer timerLevel7 = messages.getMessageInteger(Constante.CLE_TEMPS_TIMER_LEVEL7);
        Integer nbPointLevel7 = messages.getMessageInteger(Constante.CLE_NBPOINT_TIMER_LEVEL7);
        Level level7 = new Level(Constante.LABEL_LEVEL7,timerLevel7, nbPointLevel6, nbPointLevel7);
        mapLevel.put(LevelManager.LEVEL_7, level7);
        log.info("Ajout du level 7");

        // Recupere le level 8
        Integer timerLevel8 = messages.getMessageInteger(Constante.CLE_TEMPS_TIMER_LEVEL8);
        Integer nbPointLevel8 = messages.getMessageInteger(Constante.CLE_NBPOINT_TIMER_LEVEL8);
        Level level8 = new Level(Constante.LABEL_LEVEL8,timerLevel8, nbPointLevel7, nbPointLevel8);
        mapLevel.put(LevelManager.LEVEL_8, level8);
        log.info("Ajout du level 8");

        
        log.info(new StringBuffer().append("FIN de la methode init de la classe ").append(this.getClass().getName()).toString());
    }

    /**
     * Methode permettant de recuperer le level correspondant au score.<br/>
     * 
     * @param score Score.<br/>
     * @return Retourne le level.<br/>
     * @throws TechnicalException Erreur technique.<br/>
     */
    public Level getLevel(Integer score) throws TechnicalException
    {
        if ((mapLevel == null) || (mapLevel.isEmpty())){
            init();
        }
        
        Level levelCourant = null;
        if (score != null)
        {
            Set set = mapLevel.keySet();
            
            if (set != null){
                Iterator itSet = set.iterator();
                while (itSet.hasNext()){
                    String cleLevel = (String) itSet.next();
                    Level level = (Level) mapLevel.get(cleLevel);
                    Integer nbPointMin = level.getNbPointMin();
                    Integer nbPointMax = level.getNbPointMax();
                    if ((nbPointMin.compareTo(score) <= 0) && (nbPointMax.compareTo(score) > 0)){
                        levelCourant = level;
                        break;
                    }
                }
            }
        }
        
        return levelCourant;
    }

}
