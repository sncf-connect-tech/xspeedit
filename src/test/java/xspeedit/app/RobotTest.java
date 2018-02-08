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
	private final String _AVANTTRIE = "Cha�ne d'articles emball�s : -> 0 cartons utilis�s";
	private final String _RESULTAT = "Cha�ne d'articles emball�s : 226/82/34 -> 3 cartons utilis�s";
	
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
