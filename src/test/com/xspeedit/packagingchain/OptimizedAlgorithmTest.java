package com.xspeedit.packagingchain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.xspeedit.packagingchain.exception.OptimizedAlgorithmException;
import com.xspeedit.packagingchain.service.OptimizedAlgorithmImpl;

public class OptimizedAlgorithmTest {
	
	/**
	 * test permet de valider le cas : Liste des articles null
	 * @throws OptimizedAlgorithmException
	 */
	@Test
	public void testOptimizedAlgorithm_itemsNull() throws OptimizedAlgorithmException{
		String items = null;
		OptimizedAlgorithmImpl algo = new OptimizedAlgorithmImpl();
		try{
			algo.optimize(items);
			fail();
		}
		catch(OptimizedAlgorithmException e){
			final String expected = "Erreur : la liste des articles est null.";
			assertEquals(e.getMessage(), expected);

		}
	}
	
	/**
	 * test permet de valider le cas : Liste des articles vide
	 * @throws OptimizedAlgorithmException
	 */
	@Test
	public void testOptimizedAlgorithm_itemsEmpty() throws OptimizedAlgorithmException {
		String items = "";
		OptimizedAlgorithmImpl algo = new OptimizedAlgorithmImpl();
		try {
			algo.optimize(items);
			fail();
		} catch (OptimizedAlgorithmException e) {
			final String expected = "Erreur : la liste des articles est vide.";
			assertEquals(e.getMessage(), expected);
		}
	}
	
	/**
	 * test permet de valider le cas : Liste des articles avec caractères non numérique
	 * @throws OptimizedAlgorithmException
	 */
	@Test
	public void testOptimizedAlgorithm_itemsNoNumeric() throws OptimizedAlgorithmException {
		String items = "12AA";
		OptimizedAlgorithmImpl algo = new OptimizedAlgorithmImpl();
		try {
			algo.optimize(items);
			fail();
		} catch (OptimizedAlgorithmException e) {
			final String expected = "Erreur : la liste des articles contient des caractères non numériques.";
			assertEquals(e.getMessage(), expected);
		}
	}
	
	/**
	 * test permet de valider le cas : taille article égale 0
	 * @throws OptimizedAlgorithmException
	 */
	@Test
	public void testOptimizedAlgorithm_itemsWithZero() throws OptimizedAlgorithmException {
		String items = "10";
		OptimizedAlgorithmImpl algo = new OptimizedAlgorithmImpl();
		try {
			algo.optimize(items);
			fail();
		} catch (OptimizedAlgorithmException e) {
			final String expected = "Erreur : Un article ne doit pas être de taille 0.";
			assertEquals(e.getMessage(), expected);
		}
	}
	/**
	 * test process qui permet de valider le retour OK du service d'optimisation
	 * @throws Exception 
	 */
	@Test
	public void testOptimizedAlgorithm_OK() throws OptimizedAlgorithmException {
		String items = "163841689525773";
		OptimizedAlgorithmImpl algo = new OptimizedAlgorithmImpl();
		String actual = algo.optimize(items);
		final String expected = "91/82/81/73/73/64/6/55";
		assertNotNull(actual);
		assertEquals(actual, expected);
	}
}
