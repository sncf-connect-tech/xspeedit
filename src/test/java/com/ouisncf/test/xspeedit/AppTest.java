package com.ouisncf.test.xspeedit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ouisncf.test.xspeedit.exception.CartonSizeException;
import com.ouisncf.test.xspeedit.impl.Article;
import com.ouisncf.test.xspeedit.impl.Robot;
import com.ouisncf.test.xspeedit.impl.UsineFactory;
import com.ouisncf.test.xspeedit.typetri.BestFitDecreasing;
import com.ouisncf.test.xspeedit.typetri.FirstFitDecreasing;
import com.ouisncf.test.xspeedit.typetri.SimpleTri;
import com.ouisncf.test.xspeedit.typeusine.UsineRecente;
import com.ouisncf.test.xspeedit.util.TriUtil;

/**
 * Class de test jUnit
 * @author crabiller
 *
 */
public class AppTest {
	
  UsineFactory usine = new UsineRecente();
 
  List<Article> listeArticle = new ArrayList<Article>();
  String chaine ="5 3 7 8 9 6 7 8 5 4 2 4 5";
  Robot robot = usine.createRobot();

	

	/**
	 * Test de la methode  de tri BFD
	 * @throws CartonSizeException 
	 * @throws Exception 
	 */
	@Test
	public void testBestFitDecreasing() throws CartonSizeException {

  String retourAttendu = "9/8/8/72/73/64/55/54/";  
  
  
  robot.setTypeTri(BestFitDecreasing.getlnstance());
  listeArticle = TriUtil.createListeArticle(chaine);
  String retourReel = TriUtil.toString(robot.trier(listeArticle));

		assertNotNull(retourReel);
		assertEquals(retourReel, retourAttendu);
	}




/**
 * test de la methode de tri simple
 * @throws CartonSizeException 
 * @throws Exception Carton
 */
@Test
public void testSimpleTri() throws CartonSizeException {


 String retourAttendu = "53/7/8/9/6/7/8/54/24/5/";

 robot.setTypeTri(SimpleTri.getlnstance());
 
 listeArticle = TriUtil.createListeArticle(chaine);
 String retourReel = TriUtil.toString(robot.trier(listeArticle));

 assertNotNull(retourReel);
 assertEquals(retourReel, retourAttendu);
}



/**
 * test de la methode de tri simple
 * @throws CartonSizeException 
 * @throws Exception Carton
 */
@Test
public void testFirstFitDecreasing() throws CartonSizeException {


 String retourAttendu = "9/82/8/73/7/64/55/54/";
 
 robot.setTypeTri(FirstFitDecreasing.getlnstance());
 
 listeArticle = TriUtil.createListeArticle(chaine);
 String retourReel = TriUtil.toString(robot.trier(listeArticle));

 assertNotNull(retourReel);
 assertEquals(retourReel, retourAttendu);
}
}
