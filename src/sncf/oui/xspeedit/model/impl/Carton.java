package sncf.oui.xspeedit.model.impl;

import java.util.ArrayList;
import java.util.List;

import sncf.oui.xspeedit.model.IArticle;
import sncf.oui.xspeedit.model.ICarton;

/**
 * 
 * @author Malik
 *
 */
public class Carton implements ICarton{
	public static final Integer MAX_CAPACITY = 10;
	

	/**
	 * liste des articles rangés dans ce carton
	 */
	private List<IArticle> articles;
	
	
	
	public Carton() {
		setArticles(new ArrayList<>());
	}

	/**
	 * Crée un carton en lui assignant un premier article
	 * @param firstArticle
	 */
	public Carton(IArticle firstArticle) {
		this();
		getArticles().add(firstArticle);
	}

	@Override
	public boolean canAddArticle(IArticle article) {
		return article.getSize()<=getEmptySpace();
	}
	
	/**
	 * renvoie l'espace libre du carton
	 * @return
	 */
	private int getEmptySpace() {
		return MAX_CAPACITY-getFilledSpace();
	}

	/**
	 * renvoie l'espace plein du carton
	 * @return
	 */
	private int getFilledSpace() {
		int filledSpace = 0;
		for(IArticle article : getArticles()) {
			filledSpace += article.getSize();
		}
		return filledSpace;
	}

	@Override
	public List<IArticle> getArticles() {
		return articles;
	}

	@Override
	public void setArticles(List<IArticle> articles) {
		this.articles = articles;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for(IArticle arc : getArticles()) {
			sb.append(arc.getSize());
		}
		return sb.toString();
	}
}
