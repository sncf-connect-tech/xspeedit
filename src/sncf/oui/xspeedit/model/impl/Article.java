package sncf.oui.xspeedit.model.impl;

import sncf.oui.xspeedit.model.IArticle;

/**
 * 
 * @author Malik
 *
 */
public class Article implements IArticle {
	/**
	 * taille de l'article
	 */
	private int size ;

	public Article(int size) {
		super();
		this.size = size;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}
	
}
