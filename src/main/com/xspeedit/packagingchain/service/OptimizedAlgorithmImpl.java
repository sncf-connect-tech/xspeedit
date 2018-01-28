package com.xspeedit.packagingchain.service;

import static com.xspeedit.packagingchain.constants.Constants.BOX_CAPACITY;
import static com.xspeedit.packagingchain.constants.Constants.SEPARATOR;
import static com.xspeedit.packagingchain.constants.Constants.ZERO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.xspeedit.packagingchain.exception.OptimizedAlgorithmException;
import com.xspeedit.packagingchain.model.Box;

/**
 * <p>
 * Le problème énoncé est un problème d’optimisation combinatoire <i>bin
 * packing</i> deux approches de solutions sont possibles pour résoudre ce
 * problème :
 * </p>
 * <br/>
 * <ul>
 * <li>exacte : permettant d’obtenir la solution optimale à chaque fois, mais le
 * temps de calcul peut être long si le problème est compliqué</li>
 * <li>approchée: permettant d’obtenir rapidement une solution approchée, pas
 * nécessairement optimale</li>
 * </ul>
 * <br/>
 * <p>
 * Dans mon cas, j'ai choisi la solution approché, cette solution permet
 * d’obtenir un bon compromis entre la qualité de la solution et le temps de
 * calcul. L’algorithme choisi s’appelle :<b>Le Best Fit Deacressing – BFD
 * – </b>(meilleur remplissage par ordre écroissant). Cet algorithme améliore
 * l’algorithme actuel en :
 * </p>
 * <ul>
 * <li>triant tous les articles par ordre décroissant de tailles ;</li>
 * <li>sélectionnant les objets un à un dans l’ordre du tri et en ajoutant
 * l’objet sélectionné dans le sac le plus rempli tel que la contrainte de taille
 * maximalle reste respectée.</li>
 * </ul>
 * 
 * @author Toufik H
 */
public class OptimizedAlgorithmImpl implements OptimizedAlgorithm {


	@Override
	public String optimize(String items) throws OptimizedAlgorithmException {

		// verifier la validité de l'input
		checkItems(items);

		// convertir la liste des articles de string à une liste d'entier
		List<Integer> itemsArray = string2Ints(items);

		// recuperer les cartons optimisés
		List<Box> box = pack(itemsArray);

		// formatter les articles en String
		String itemString = box2ItemString(box);

		return itemString;
	}

	/**
	 * si la liste des articles est null, vide, elle contient des zero ou  des caractères non numérique alors on lève une exception
	 *
	 * @param items
	 * @return
	 */
	private void checkItems(String items) throws OptimizedAlgorithmException{
		if (null == items) {
			throw new OptimizedAlgorithmException("Erreur : la liste des articles est null.");
		} else if (items.isEmpty()) {
			throw new OptimizedAlgorithmException("Erreur : la liste des articles est vide.");
		}
		else if(items.contains(ZERO)){
			throw new OptimizedAlgorithmException("Erreur : Un article ne doit pas être de taille 0.");
		}
		else if (!isNumeric(items)) {
			throw new OptimizedAlgorithmException("Erreur : la liste des articles contient des caractères non numériques.");
		}
	}

	/**
	 * 
	 * @param boxList
	 * @return string
	 */

	private String box2ItemString(List<Box> boxList) {
		StringBuilder itemsString = new StringBuilder();
		boxList.stream().forEach(c -> itemsString.append(format(c)).append(SEPARATOR));
		return itemsString.deleteCharAt(itemsString.length() - 1).toString();
	}

	/**
	 * 
	 * @param box
	 * @return string
	 */
	private StringBuilder format(Box box) {
		StringBuilder format = new StringBuilder();
		box.getItems().forEach(c -> format.append(String.valueOf(c)));
		return format;
	}

	private List<Box> pack(List<Integer> items) {
		/*
		 * Algorithme :
		 * <ul>
		 * <li>trier les articles par ordre décroissant de taille</li>
		 * <li>sélectionner les article un à un dans l’ordre du tri et en ajoutant l’article sélectionné dans le carton le plus rempli
		 * </ul>
		 */
		
		//tri
		List<Integer> itemsSort = items.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		
		// initiliser la liste des cartons
		List<Box> boxList = createBoxList(itemsSort.get(0));

		// mettre l'article dans le carton le moyen rempli
		for (int i = 1; i < itemsSort.size(); i++) {
			Box box = givenBoxMorePacked(boxList, itemsSort.get(i));
			// si un carton a été trouvé alors, on ajoute l'article à ce carton
			if (null != box) {
				List<Integer> itemsBox = box.getItems();
				itemsBox.add(itemsSort.get(i));
				box.setItems(itemsBox);
			} else {
				// si aucun carton n'est éligible de contenir l'article alors on crée un nouveau carton
				Box newBox = createBox(itemsSort.get(i));
				boxList.add(newBox);
			}
		}
		return boxList;
	}

	/**
	 * 
	 * @param boxList
	 * @param itemSize
	 * @return
	 */
	private Box givenBoxMorePacked(List<Box> boxList, Integer itemSize) {
		Comparator<Box> comparator = (c1, c2) -> Integer.compare(totalSize(c1.getItems()),
				totalSize(c2.getItems()));
		return boxList
				.stream()
				.filter(c -> totalSize(c.getItems()) + itemSize <= BOX_CAPACITY)
				.max(comparator)
				.orElse(null);
	}

	/**
	 * 
	 * @param items
	 * @return taille totale
	 */
	private Integer totalSize(List<Integer> items) {
		return items.stream().mapToInt(Integer::intValue).sum();
	}

	/**	 * 
	 * @param poind
	 * @return Liste de carton
	 */
	private List<Box> createBoxList(Integer size) {
		List<Box> box = new ArrayList<>();
		box.add(createBox(size));
		return box;
	}

	/**
	 * 
	 * @param size
	 * @return Carton
	 */
	private Box createBox(Integer size) {
		List<Integer> itemBox = new ArrayList<>();
		itemBox.add(size);
		Box box = new Box(itemBox);
		return box;
	}

	/**
	 * 
	 * convertir un string en liste d'entiers
	 * 
	 * @param articles
	 *            : la liste des articles en chaine de caractère
	 * @return Liste d'entiers
	 */
	private List<Integer> string2Ints(String articles) {
		List<Integer> articlesI = new ArrayList<>();
		char[] articleChar = articles.toCharArray();
		for (int i = 0; i < articleChar.length; i++) {
			articlesI.add(Character.getNumericValue(articleChar[i]));

		}
		return articlesI;
	}

	/**
	 * 
	 * @param str
	 * @return boolean
	 */
	private static boolean isNumeric(String str) {
		if (str == null) {
			return false;
		}
		int sz = str.length();
		for (int i = 0; i < sz; i++) {
			if (Character.isDigit(str.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

}
