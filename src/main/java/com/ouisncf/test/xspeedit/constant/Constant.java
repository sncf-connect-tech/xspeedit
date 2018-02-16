package com.ouisncf.test.xspeedit.constant;

/**
 * @author crabiller
 * Classe de constantes pour l'application de tri.
 */
public final class Constant {
	/**
	 * On interdit l'usage du constructeur par défaut.
	 */
	private Constant() {
	}
	
	//Taille des cartons
	public static final int TAILLE_CARTON_DEFAUT = 10;
	public static final int TAILLE_CARTON_PETIT = 5;
	public static final int TAILLE_CARTON_MOYENNE = 10;
	public static final int TAILLE_CARTON_GRANDE = 25 ;
	
	public static final String SEPARATION_CHAR ="/";
	
	public static final int TAILLE_MINI_ARTICLE=1;
	public static final int TAILLE_MAXI_ARTICLE=10;
	//Vitesse des robots
	public static final int TEMPS_INITIALISATION_ROBOT_RECENT = 1000;
	public static final int TEMPS_INITIALISATION_ROBOT_ANCIEN = 3000 ;
	
	public static final String MESSAGE_INIT_ROBOT = "Initialisation du robot pour le tri ... Veuillez patienter"; 
	public static final String UNITE_TEMPS = " ms"; 
	


}
