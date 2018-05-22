package sncf.oui.xspeedit.model;

import java.util.List;

public interface IRobot {

	/**
	 * permet de ranger les articles en entrée dans des cartons selon la méthode de First Fit 
	 * --> mettre l'article dans le premier carton o� il y'a assez d'espace
	 * @param articles
	 * @return
	 */
	List<ICarton> rangerArticles(List<IArticle> articles);

}
