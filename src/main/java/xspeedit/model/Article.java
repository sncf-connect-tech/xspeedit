package xspeedit.model;

import xspeedit.exception.InvalidSizeException;

/**
 * La classe Article représente les articles a placer dans des cartons.
 * La taille d'un article varie entre 1 et 9.
 * 
 * @author emmanuel
 *
 */
public class Article {
	final int _SIZE_MIN = 1;
	final int _SIZE_MAX = 9;
	private int size;

	/**
	 * Constructeur d'article
	 * 
	 * @param size
	 * taille de l'article a creer
	 * @throws InvalidSizeException 
	 * Envoie une exception si la taille de l'article n'est pas conforme.
	 */ 
	public Article(int size) throws InvalidSizeException {
		if(size >= _SIZE_MIN && size <= _SIZE_MAX)
			this.size = size;
		else throw new InvalidSizeException();
	}
	
	/**
	 * @return
	 * Retourne la taille de l'article.
	 */
	public int getSize() {
		return size;
	}

	public String toString() {
		return ""+this.getSize();
	}
}
