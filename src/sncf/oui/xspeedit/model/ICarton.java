package sncf.oui.xspeedit.model;

import java.util.List;

public interface ICarton {

	/**
	 * teste si le carton a suffisament d'espace pour ranger l'article en entrée
	 * @param article
	 * @return
	 */
	boolean canAddArticle(IArticle article);
	
	/**
	 * getter de articles
	 * @return
	 */
	List<IArticle> getArticles();
	
	/**
	 * setter de articles
	 * @param articles
	 */
	void setArticles(List<IArticle> articles);
}
