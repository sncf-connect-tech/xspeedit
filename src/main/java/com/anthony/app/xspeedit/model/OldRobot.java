package com.anthony.app.xspeedit.model;

public class OldRobot extends Robot {

	// Utilise la méthode par défaut de l'interface logiciel 
		
	public OldRobot(String reference) {
		super(reference);
	}
		
	@Override
	 public String toString() {
	   return "robot " + this.reference + " de nouvelle génération";
	 }
	
}
