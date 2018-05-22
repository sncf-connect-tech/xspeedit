package sncf.oui.xspeedit.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sncf.oui.xspeedit.exception.ArticleSizeNotDefined;
import sncf.oui.xspeedit.exception.NoArticleFoundException;
import sncf.oui.xspeedit.model.IArticle;
import sncf.oui.xspeedit.model.ICarton;
import sncf.oui.xspeedit.model.IRobot;
import sncf.oui.xspeedit.model.impl.Article;
import sncf.oui.xspeedit.model.impl.Robot;

/**
 * cette classe définit l'entrepot ou sont mis les articles, le robot et les cartons pour le rangement
 * @author Malik
 *
 */
public class Entrepot {

	/**
	 * on va lire une chaine de caractère décrivant la liste des articles à ranger,
	 * on appelle le robot qui va nous mettre tous ces articles dans des cartons
	 * @param args
	 * @throws NoArticleFoundException 
	 * @throws ArticleSizeNotDefined 
	 */
	public static void main(String[] args) throws NoArticleFoundException, ArticleSizeNotDefined {
		//lecture de la chaine des tailles d'articles
		@SuppressWarnings("resource")
		String lArticlesString = new Scanner(System.in).nextLine();
		//si aucun article n'a été saisi, erreur
		if(lArticlesString.isEmpty()) {
			throw new NoArticleFoundException();
		}
		//création des objets articles
		List<IArticle> articles = new ArrayList<>();
		for(char tailleArticle : lArticlesString.toCharArray()) {
			int articleSize = Integer.parseInt(""+tailleArticle);
			//la taille d'un article ne peut pas être 0
			if(articleSize==0) {
				throw new ArticleSizeNotDefined();
			}
			articles.add(new Article(articleSize));
		}
		//Création du robot qui va ranger les cartons
		IRobot robot = new Robot();
		//on récupère la liste des cartons rangés par le robot
		List<ICarton> cartons = robot.rangerArticles(articles);
		
		//affichage du résultat
		System.out.println(afficherListeCartons(cartons));
	}

	/**
	 * crée et retourne une chaine de caractère qui définit la structure des cartons en entrée
	 * @param cartons : liste des cartons à afficher
	 * @return
	 */
	private static String afficherListeCartons(List<ICarton> cartons) {
		StringBuilder sb = new StringBuilder("");
		for(ICarton c : cartons) {
			if(cartons.indexOf(c) > 0) {
				sb.append("/");
			}
			sb.append(c.toString());
		}
		sb.append(" => ")
			.append(cartons.size())
			.append(" cartons.");
		return sb.toString();
	}

}
