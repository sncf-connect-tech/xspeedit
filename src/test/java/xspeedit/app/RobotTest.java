package xspeedit.app;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import xspeedit.app.Robot;

/**
 * Test de la classe Robot
 * 
 * @author emmanuel
 *
 */
public class RobotTest {
	
	private final List<Integer> _ARTICLES = new ArrayList<Integer>(Arrays.asList(2,2,8,6,3,4,2));
	private final String _AVANTTRIE = "Chaîne d'articles emballés : -> 0 cartons utilisés";
	private final String _RESULTAT = "Chaîne d'articles emballés : 226/82/34 -> 3 cartons utilisés";
	
	/**
	 * Test du trie
	 */
	@Test
	public void myTest() {
		Robot robot = new Robot(_ARTICLES);
		assertEquals(_AVANTTRIE, robot.toString());
		robot.trier();
		assertEquals(_RESULTAT, robot.toString());
	}

}
