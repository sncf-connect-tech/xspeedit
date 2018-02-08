package xspeedit.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Carton permettant de stocker des articles.
 * Le contenu maximal d'un carton est de 10.
 * 
 * @author emmanuel
 *
 */
public class Carton {
	final int _CONTENANCEMAX = 10;
	public List<Article> contenu;
	
	/**
	 * Constructeur de carton, initialise une liste vide d'article.
	 */
	public Carton() {
		contenu = new ArrayList<Article>();
	}
	
	/**
	 * Permet l'ajout d'article dans le carton.
	 * 
	 * @param article
	 * Article a ajouter dans le carton
	 * @return
	 * true si l'article a bien été ajouté, sinon false
	 */
	public boolean addArticle(Article article) {
		if(!isFull() && enoughRoom(article)){
			return contenu.add(article);
		}
		return false;
	}
	
	/**
	 * @return
	 * retourne la taille occupée dans le carton
	 */
	public int getContenance() {
		int somme = 0;
		for(Article article : contenu)
			somme += article.getSize();
		return somme;
	}
	
	/**
	 * @return
	 * retourne true si le carton est plein.
	 */
	public boolean isFull() {
		return getContenance() >= _CONTENANCEMAX;	
	}
	
	/**
	 * @param article
	 * l'article a ajouter
	 * @return
	 * retourne true si le carton a assez de place pour ajouter un article.
	 */
	public boolean enoughRoom(Article article) {
		return getContenance()+article.getSize() <= _CONTENANCEMAX;
	}
	
	public String toString() {
		String str = "";
		for(Article article : contenu)
			str += article.toString();
		return str;
	}
}
