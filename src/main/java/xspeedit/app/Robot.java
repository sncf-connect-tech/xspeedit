package xspeedit.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import xspeedit.exception.InvalidSizeException;
import xspeedit.model.Article;
import xspeedit.model.Carton;

/**
 * Permet de creer des articles, et de les placer dans des cartons.
 * 
 * @author emmanuel
 *
 */
public class Robot {

	private List<Article> listeArticle;
	private List<Carton> listeCarton;

	public static void main(String[] args) {
		System.out.println("Saisissez les différentes tailles (1 à 9) de vos articles sans espaces svp.");
		System.out.println("Terminez votre saisie avec la touche entrée.");
		
		String str = new String();
		Scanner sc = new Scanner(System.in);
		//Tant que la saisie ne comprend pas que des chiffres entres 1 et 9 sans espace, on recommence la saisie.
		do {		
			System.out.print("-> ");
			str = sc.nextLine();
		}
		while(!str.matches("[1-9]*"));
		sc.close();
		System.out.println("Chaîne d'articles en entrée : "+ str);
		List<Integer> articles = new ArrayList<Integer>();
		//Remplissage de la liste des articles avec les données saisies
		for(String s : str.split("")) {
			articles.add(Integer.parseInt(s));
		}

		Robot robot = new Robot(articles);

		robot.trier();
		System.out.println(robot);
	}

	/**
	 * @param articles
	 *            taille des articles a creer et placer dans des cartons. Si la
	 *            taille n'est pas conforme, on passe au suivant sans l'ajouter.
	 */
	public Robot(List<Integer> articles) {
		this.listeArticle = new ArrayList<Article>();
		this.listeCarton = new ArrayList<Carton>();

		// on créé les articles et les ajoutes a une liste temporaire
		for (int i : articles) {
			try {
				this.listeArticle.add(new Article(i));
			} catch (InvalidSizeException e) {
			}
		}
	}

	/**
	 * Optimise le rangement d'articles dans les cartons.
	 */
	public void trier() {
		// initialisation du premier carton (vide)
		this.listeCarton.add(new Carton());

		// le premier article rentre directement dans le premier carton
		listeCarton.get(0).addArticle(listeArticle.remove(0));

		// boucle sur tous les articles pour les ranger dans un carton
		for (Article article : listeArticle) {
			int indiceCarton = 0;
			// Boucle tant que l'article n'a pas été ajouté au carton, si besoin creation
			// d'un nouveau carton
			while (!listeCarton.get(indiceCarton).addArticle(article)) {
				indiceCarton++;
				if (indiceCarton >= listeCarton.size()) {
					listeCarton.add(new Carton());
				}
			}
		}
	}

	public String toString() {
		String str = "Chaîne d'articles emballés : ";
		int compteurCarton = 0;

		for (Carton carton : listeCarton) {
			str += carton.toString() + "/";
			compteurCarton++;
		}
		// on retire le dernier '/' de trop
		str = str.substring(0, str.length() - 1);
		str += " -> " + compteurCarton + " cartons utilisés";
		return str;
	}
}
