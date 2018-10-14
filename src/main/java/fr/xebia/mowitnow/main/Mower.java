package fr.xebia.mowitnow.main;

public interface Mower {
	/**
	 * Methode pour tourner a droite
	 */	
	void pivoterADroite();
	
	/**
	 * Methode pour tourner a gauche
	 */
	void pivoterAGauche();
	
	/**
	 * Methode pour avancer d'une case
	 */
	void avancer();
}
