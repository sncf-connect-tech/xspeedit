package com.xspeedit.packagingchain.service;

import com.xspeedit.packagingchain.exception.OptimizedAlgorithmException;

public interface OptimizedAlgorithm {
	
	/**
	 * 
	 * Service permet d'appliquer l'alogirthme  Best Fit Deacressing � BFD � (meilleur remplissage par ordre d�croissant) pour optimiser le repmlissage des cartons
	 * 
	 * @param items
	 * @return Cartons optimis�
	 * @throws Exception
	 */
	String optimize(String items) throws OptimizedAlgorithmException;

}
