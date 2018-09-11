package com.anthony.app.xspeedit.Util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections4.CollectionUtils;

import com.anthony.app.xspeedit.constant.Constant;
import com.anthony.app.xspeedit.model.Box;
import com.anthony.app.xspeedit.model.Item;

public class FillingUtils {

	/**
	 * <p>
	 * Retourne vrai si il reste assez de place pour ajouter l'objet.
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
				// Si il y a assez de place dans la boite actuelle on ajoute l'objet
				if(isEnoughtPlace(item,actualBoxToFill)) {
					actualBoxToFill.getItems().add(item);
					if(!iterator.hasNext()) {
						addBoxToChainBox(allbox,actualBoxToFill);
					}
				}else {
					// Sinon on ajoute la boite remplie à la liste des boites
					// On vide la boite et on y rajoute l'objet	
					
					addBoxToChainBox(allbox,actualBoxToFill);
					actualBoxToFill = new Box();
					actualBoxToFill.getItems().add(item);
					if(!iterator.hasNext()) {
						addBoxToChainBox(allbox,actualBoxToFill);
					}
				} 
			}	
		}	
		return allbox;
	}
	
	
	
	
	/**
	 * Programme de remplissage nouvelle génération
	 * 
	 * @param items
	 * @return
	 */
	public static List<Box> optimisedFilling(List<Item> items) {	
		List<Box> allbox= new ArrayList<Box>();	
		if (CollectionUtils.isNotEmpty(items)) {			
			Box firstBox = new Box();
			
			// Les objets sont classés par ordre croissant.
			items.sort((firstItem, secondItem) -> Integer.compare(firstItem.getSize(), secondItem.getSize()));
			
			// On met le premier objet dans la première boite.
			firstBox.getItems().add(items.get(0));
			allbox.add(firstBox);
			
			// On commence au deuxième indice car on a déja mis le premier objet dans une boite.
			for(ListIterator<Item> iter = items.listIterator(1); iter.hasNext();) {
				Item item = (Item) iter.next();		
				
				// On cherche une boite avec assez de place pour contenir l'objet
				// Vu que l'on peu en avoir plusieurs, on prend celle qui est la plus remplie.
				Box boxWithAnoughtPlace = searchBox(allbox, item);
				
				// Si aucune boite n'a assez de contenance, on en crée une et on met l'objet dedans.
				if (null == boxWithAnoughtPlace) {
					Box newBox = new Box();
					newBox.getItems().add(item);
					allbox.add(newBox);
				} else {
					// Sinon si il y a assez de place on met l'objet dans la boite.
					boxWithAnoughtPlace.getItems().add(item);
				}
			}
		}	
		return allbox;
	}
	
	
	/**<pre>
	 * Retourne une boite exitante qui a assez de place pour contenir l'objet
	 * sinon renvoie null
	 * 
	 * </pre>
	 * @param allbox
	 * @param item
	 * @return
	 */
	private static Box searchBox(List<Box> allbox,Item item) {
		// Comparateur qui permet de renvoyer la boite eligible la plus remplie 
		Comparator<Box> comparator = (firstBox, secondBox) -> Integer.compare(firstBox.getfilledPlace(),secondBox.getfilledPlace());
		
		// Le filtre retourne les boites dans lesquels peu ajouter l'objet, 
		// puis retourne celle qui est la plus remplie
		// Retourne null si pas de résultat
	
		
		return allbox.stream()
		.filter(box -> box.getRemainingPlace() - item.getSize() > 0)
		.max(comparator)
		.orElse(null);
	}
	
	/**<pre>
	 * 
	 * Ajoute la boite à la liste des boites et l'affiche dans la console.
	 * 
	 * </pre>
	 * @param allbox
	 * @param item
	 * @return
	 */
	private static void addBoxToChainBox(List<Box> allBox, Box box) {
		allBox.add(box);
		System.out.print(box);
	}
	
}
