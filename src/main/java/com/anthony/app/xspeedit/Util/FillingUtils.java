package com.anthony.app.xspeedit.Util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

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
	 * <p>
	 * Programme de remplissage ancienne génération
	 * </p>
	 * 
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
	
	/**
	 * Programme de remplissage nouvelle génération
	 * 
	 * On classe dans lordre croissant la liste 
	 * On classe dans lordre decroissant la liste 
	 * 
	 * On itere sur la liste croissante 
	 * Pour chaque element 
	 * 	on itere sur la liste decroissante 
	 *  si la somme est inferieur ou egale à la taille max
	 *  on ajoute au carton et on passe au suivant 
	 *  	sinon on laisse tel quel 
	 * 
	 * 
	 * @param items
	 * @return
	 */
	public static List<Box> optimisedFilling(List<Item> items) {	
		List<Box> allbox= new ArrayList<Box>();	
		if (CollectionUtils.isNotEmpty(items)) {	
		
			Box firstBox = new Box();
			
			// Les objets sont classés par ordre croissant
			items.sort((firstItem, secondItem) -> Integer.compare(firstItem.getSize(), secondItem.getSize()));
			
			firstBox.getItems().add(items.get(0));
			allbox.add(firstBox);
			
			for(ListIterator<Item> iter = items.listIterator(1); iter.hasNext();) {
				Item item = (Item) iter.next();		
				
				Box boxWithAnoughtPlace = searchBox(allbox, item);
				
				if (null == boxWithAnoughtPlace) {
					Box newBox = new Box();
					newBox.getItems().add(item);
					allbox.add(newBox);
				} else {
					boxWithAnoughtPlace.getItems().add(item);
				}
			}
			
		}	
		return allbox;
	}
	
	
	/**
	 * Retourne une boite exitante qui a assez de place pour contenir l'objet, sinon renvoie null
	 * @param allbox
	 * @param item
	 * @return
	 */
	private static Box searchBox(List<Box> allbox,Item item) {
		return allbox.stream()                // convert list to stream
        .filter(box -> item.getSize() + box.getRemainingPlace() < 0).findAny()
        .orElse(null);
	}

}
