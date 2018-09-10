package com.anthony.app.xspeedit.Util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.anthony.app.xspeedit.model.Box;
import com.anthony.app.xspeedit.model.Item;

public class FillingUtils {

	/**
	 * <p>
	 * Retourne vrai si il reste assez de place pour ajouter l'objet.
	 * 
	 * Si place restante - place objet inférieur à 0 
	 * 	retourner vrai
	 * sinon
	 * 	retourner faux
	 * 
	 * </p>
	 * @param <T>
	 */
	public static boolean isEnoughtPlace(Item item, Box box) {
		return box.getRemainingPlace() - item.getSize() > 0;
	}
		
	/**
	 * Programme de remplissage ancienne génération
	 * @param items
	 * @return
	 */
	public static List<Box> basicFilling(List<Item> items) {
		Iterator<Item> iterator = items.iterator();
		Box actualBoxToFill = new Box();

		List<Box> allbox= new ArrayList<Box>();	
		if (CollectionUtils.isNotEmpty(items)) {	
			while (iterator.hasNext()){
				Item item = (Item) iterator.next();    
				if(isEnoughtPlace(item,actualBoxToFill)) {
					actualBoxToFill.getItems().add(item);
					if(!iterator.hasNext()) {
						allbox.add(actualBoxToFill);
					}
				}else {
					allbox.add(actualBoxToFill);
					actualBoxToFill = new Box();
					actualBoxToFill.getItems().add(item);
				} 
			}	
		}	
		return allbox;
	}

}
