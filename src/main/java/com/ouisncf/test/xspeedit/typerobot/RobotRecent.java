package com.ouisncf.test.xspeedit.typerobot;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.ouisncf.test.xspeedit.exception.CartonSizeException;
import com.ouisncf.test.xspeedit.impl.Article;
import com.ouisncf.test.xspeedit.impl.Carton;
import com.ouisncf.test.xspeedit.impl.Robot;
import com.ouisncf.test.xspeedit.impl.TypeTri;
import com.ouisncf.test.xspeedit.typetri.BestFitDecreasing;


/**
 * Classe concrete represenant un robot "Recent"
 * Ce robot est un robot nouvelle generation, sa vitesse d'initialisation est rapide
 * et ce robot peut changer le type de carton qu'il trie
 * Il utilise la méthode de tri Best fit decreasing par defaut
 * mais il peut changer de méthode de trie en cours de fonctionnement sans redemmarage (nouvelle instanciation) 
 * 
 * 
 * @author crabiller
 *
 */
public class RobotRecent extends Robot {

  /**
   * Constructeur par defaut
   * @param typeCarton Type de carton trié par le robot
   */
	 public RobotRecent(Carton typeCarton){
		 	this.typeCarton = typeCarton;
		    this.typeTri = BestFitDecreasing.getlnstance();
		  }   
		
	 /**
	  * Constructeur en choisissant le type de trie utilisé
	  * @param typeCarton Type de carton trié par le robot
	  * @param typeTri
	  */ 
  public RobotRecent(Carton typeCarton, TypeTri typeTri){
    this.typeCarton = typeCarton;
      this.typeTri = typeTri;
    }   
  
	@Override
	/**
	 * Méthode de tri du robot rapide
	 */
	
	public List<Carton> trier(List<Article> listeArticle) throws CartonSizeException {
	  
		return super.trier(listeArticle);

	}

	

 /**
  * Méthode permettant de changer le type de tri utilisé par le robot
  * @param typeTri
  */
 public void setTypeTri(TypeTri typeTri) {
  this.typeTri = typeTri;
 }
	
	/**
	 * Méthode permettant de changer le type de caron pris en charge par le robot
	 * @param typeCarton
	 */
	public void setTypeCarton(Carton typeCarton) {
		this.typeCarton = typeCarton;
	}

 @SuppressWarnings("null")
@Override
 /**
  * Methode permettant de creer un nouveau carton par reflectivité 
  * selon le type de carton que le robot est en train de trier
  */
 public Carton createCarton() {
   
   Class<?> clazz = null;
    try {
      clazz = Class.forName(typeCarton.getClass().getName());
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
   Constructor<?> ctor = null;
    try {
      ctor = clazz.getConstructor();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (SecurityException e) {
      e.printStackTrace();
    }
   Object object = null;
    try {
      object = ctor.newInstance();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  Carton carton = (Carton) object;
  return carton;
 }
 
	
 /**
  * Méthode pour creer un carton et y inserer un premier article
  * 
  * @param article
  * @return le carton
  */
	public Carton createCarton(Article article) {
		Carton carton = createCarton();
		carton.addArticle(article);
		return carton;
	}

@Override
public String toString() {
  return "Robot recent : Algorithme utilisé pour le tri -> " + typeTri.toString() ;
}


	
	
}
