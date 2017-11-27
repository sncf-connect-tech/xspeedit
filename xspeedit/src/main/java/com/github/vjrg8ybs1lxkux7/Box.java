package com.github.vjrg8ybs1lxkux7;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Box {

	private ArrayList<Integer> stuffs = new ArrayList<>();
	private int sum = 0;

	/**
	 * Cette méthode dit s'il reste de la place dans la boite.
	 * 
	 * @param stuff
	 * @return
	 */
	public boolean hasEnoughPlace(int stuff) {
		return sum + stuff <= 10;
	}

	/**
	 * Cette méthode pousse dans la boite le packet donné.
	 * 
	 * S'il n'y a plus de place une IndexOutOfBoundsException est throwée.
	 * 
	 * @param stuff
	 * @return
	 */
	public boolean fillWith(int stuff) {
		if (!hasEnoughPlace(stuff)) {
			throw new IndexOutOfBoundsException();
		}
		// On mets de côté pour éventuelle restitution.
		stuffs.add(stuff);
		sum += stuff; // on compte
		return true;
	}

	@Override
	public String toString() {
		return String.join("/", stuffs.stream().map(String::valueOf).collect(Collectors.toList()));
	}
}
