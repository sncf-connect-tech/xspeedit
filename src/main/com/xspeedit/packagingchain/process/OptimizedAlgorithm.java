package com.xspeedit.packagingchain.process;

import com.xspeedit.packagingchain.exception.OptimizedAlgorithmException;

/**
 * 
 * @author A370276
 *
 */
public interface OptimizedAlgorithm {
	/**
	 * Service permet d'appliquer l'alogirthme  Best Fit Deacressing  BFD  (meilleur remplissage par ordre décroissant) pour optimiser le repmlissage des cartons
	 * @param items
	 * @return Cartons optimisé
	 * @throws Exception
	 */
	String optimize(String items) throws OptimizedAlgorithmException;

}
