package fr.xebia.mowitnow.main;

import java.io.File;
import java.io.IOException;

import fr.xebia.mowitnow.exceptions.MowItNowException;

public interface Orchestrator {
	/**
	 * Initialisatoin et execution en donnant un fihier contenant 
	 * les parametres d'initialisation en entrée
	 * @param file
	 * @throws IOException
	 * @throws MowItNowException 
	 */
	void executeFromFile(File file) throws IOException, MowItNowException;
	
	/**
	 * Initialisatoin et execution en donnant un texte contenant 
	 * les parametres d'initialisation en entrée
	 * @param message
	 * @throws MowItNowException 
	 */
	void executeFromText(String message) throws MowItNowException;
}
