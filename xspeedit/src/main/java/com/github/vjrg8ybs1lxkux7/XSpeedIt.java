package com.github.vjrg8ybs1lxkux7;

import static java.util.Arrays.stream;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * XSpeedIT ou comment mettre en boite
 * 
 */
public class XSpeedIt {

	/**
	 * Args contient 2 paramètres, la liste des packets et un jeton (true ou autre
	 * chose) d'optimisation.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length < 2) {
			System.out.println("Cette application prend 2 paramètres :\n" //
					+ "   [La site des packets] une suite de chiffre représentant les packets. Les 0 seront ignorés.\n" //
					+ "   [tri de la liste?] \"true\" pour savoir s'il faut trier la liste des packets.  ");
		}

		List<Integer> assets = stream(args[0].split(""))//
				.map(Integer::valueOf).filter(i -> i > 0).collect(toList());

		if ("true".equals(args[1])) {
			// on tri pour des packets plus équilibrés en nombre de packets.
			// Dans certains cas l'algorythme donne de meilleurs résultats.
			// je suis tombé dessu par hasard, je le laiss pour proposition au PO.
			sort(assets, reverseOrder());
		}

		List<Box> dropbox = new ArrayList<>();// la drop zone des boites.
		while (!assets.isEmpty()) { // tant qu'il y a matière à déplier on le fait.
			Box box = new Box(); // On ouvre une nouvelle boite
			box.fillWith(assets.remove(0)); // Le premier packet y est mis "à la main"
			for (Iterator<Integer> it = assets.iterator(); it.hasNext();) {
				// On cherche dans la pile de packet, du plus grand au plus petit, celui qui
				// rentre dans la place restante.
				int stuff = it.next();
				if (box.hasEnoughPlace(stuff)) {
					// tant qu'il y a de la place on déplie et on rempli.
					box.fillWith(stuff);
					it.remove();
				}
			}
			dropbox.add(box);
		}
		System.out.println("################################");
		for (Box box : dropbox) {
			System.out.println(box);
		}
		System.out.println("################################");
		System.out.println(dropbox.size());
		System.out.println("################################");
	}
}
