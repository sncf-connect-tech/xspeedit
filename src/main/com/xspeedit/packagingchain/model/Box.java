package com.xspeedit.packagingchain.model;

import java.util.List;

/**
 * Un caton contien une liste d'articles.
 * La capacité de contenance est de 10.
 * 
 * @author A370276
 *
 */
public class Box {
	
	/**
	 * creer un carton avec articles
	 * @param items
	 */
	public Box(List<Integer> items) {
		super();
		this.items = items;
	}

	private List<Integer> items;

	public List<Integer> getItems() {
		return items;
	}

	public void setItems(List<Integer> items) {
		this.items = items;
	}
	
	
}
