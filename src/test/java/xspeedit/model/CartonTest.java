package xspeedit.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import xspeedit.exception.InvalidSizeException;
import xspeedit.model.Article;
import xspeedit.model.Carton;

/**
 * Test de la classe Carton
 * 
 * @author emmanuel
 *
 */
public class CartonTest {

	private final int _SIZE = 5;
	
	@Test
	public void testCarton() {
		Carton carton = new Carton();
		try {
			carton.addArticle(new Article(_SIZE));
		} catch (InvalidSizeException e) {}
		assertEquals(_SIZE, carton.getContenance());
		
		try {
			carton.addArticle(new Article(_SIZE));
		} catch (InvalidSizeException e) {}
		assertEquals(_SIZE+_SIZE, carton.getContenance());	
		
		assertTrue(carton.isFull());
		try {
			assertFalse(carton.addArticle(new Article(_SIZE)));
		} catch (InvalidSizeException e) {}
	}

}
