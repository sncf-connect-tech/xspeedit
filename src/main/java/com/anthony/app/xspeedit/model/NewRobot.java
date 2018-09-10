package com.anthony.app.xspeedit.model;

public class NewRobot extends Robot{
	
	public NewRobot(String reference) {
		super(reference);
	}
	
//	@Override
//	 public void fillBox() {
//        System.out.println("######## TRIE OPTI ########");
//	}
		
	@Override
	 public String toString() {
	   return "Robot de nouvelle génération, pouvant optimiser le nombre d'objets apr cartons";
	 }
}
