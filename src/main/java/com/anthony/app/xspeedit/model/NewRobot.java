package com.anthony.app.xspeedit.model;

import java.util.List;

import com.anthony.app.xspeedit.Util.FillingUtils;

public class NewRobot extends Robot{
	
	public NewRobot(String reference) {
		super(reference);
	}
	
	/**
	 * Remplie un ou plusieurs cartons avec une liste d'objets.
	 */
	@Override
	 public List<Box> fillBox(List<Item> items) {
		return FillingUtils.optimisedFilling(items);
	}
		
	@Override
	 public String toString() {
	   return "robot " + this.reference + " de nouvelle génération";
	 }
}
