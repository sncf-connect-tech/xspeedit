package com.xspeedit.packagingchain.process;

import com.xspeedit.packagingchain.exception.OptimizedAlgorithmException;

/**
 * 
 * @author A370276
 *
 */
public interface OptimizedAlgorithm {
	/**
	 * Service permet d'appliquer l'alogirthme  Best Fit Deacressing � BFD � (meilleur remplissage par ordre d�croissant) pour optimiser le repmlissage des cartons
	 * @param items
	 * @return Cartons optimis�
	 * @throws Exception
	 */
	String optimize(String items) throws OptimizedAlgorithmException;

}
