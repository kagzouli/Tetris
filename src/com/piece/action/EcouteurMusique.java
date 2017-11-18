package com.piece.action;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URI;
import java.net.URL;

import javazoom.jl.player.jlp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Classe permettant de lancer la musique de fond.
 * 
 */
public final class EcouteurMusique implements Runnable {
	private transient Log log = LogFactory.getLog(EcouteurMusique.class);

	/**
	 * Emplacement de la musique sur le poste.<br/>
	 */
	private String musique;

	public String getMusique() {
		return musique;
	}

	public void setMusique(String theMusique) {
		musique = theMusique;
	}

	public void run() {
		try {
			File fileMusique = new File(musique);

			// Si le fichier existe, on lance le clip
			if (fileMusique.exists()) {
				// String[] listParams = new String[1];
				// listParams[0] = musique;
				// jlp player = jlp.createInstance(listParams);

				// player.play();

				URI uriMusique = fileMusique.toURI();
				URL urlMusique = uriMusique.toURL();

				AudioClip clip = Applet.newAudioClip(urlMusique);
				clip.loop();
			}
		} catch (Exception e) {
			log.fatal(e);
		}

		// TODO Auto-generated method stub

	}

}
