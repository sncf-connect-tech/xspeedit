package xspeedit.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import xspeedit.exception.InvalidSizeException;
import xspeedit.model.Article;

/**
 * Test de la classe Article
 * 
 * @author emmanuel
 *
 */
public class ArticleTest {

	private final int _SIZE = 1;
	private final int _SIZE_MIN = 0;
	private final int _SIZE_MAX = 10;
	
	@Test
	public void testArticle() {
		Article a1 = null;
		try {
			a1 = new Article(_SIZE);
		} catch (InvalidSizeException e) {}
		assertNotNull(a1);
		assertEquals(_SIZE, a1.getSize());
		
		Article a2 = null;
		Article a3 = null;
		
		try {
			a2 = new Article(_SIZE_MIN);
		} catch (InvalidSizeException e) {
			assertNull(a2);
		}
		try {
			a3 = new Article(_SIZE_MAX);
		} catch (InvalidSizeException e) {
			assertNull(a3);
		}
	}
	
}
