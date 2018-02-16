package com.ouisncf.test.xspeedit.typerobot;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.ouisncf.test.xspeedit.exception.CartonSizeException;
import com.ouisncf.test.xspeedit.impl.Article;
import com.ouisncf.test.xspeedit.impl.Carton;
import com.ouisncf.test.xspeedit.impl.Robot;
import com.ouisncf.test.xspeedit.impl.TypeTri;
import com.ouisncf.test.xspeedit.typetri.SimpleTri;
/**
 * Classe concrete represenant un robot "Ancien"
 * Ce robot est un robot d'ancienne generation, sa vitesse d'initialisation est lente
 * et ce robot ne peut pas changer le type de carton qu'il trie
 * Ce robot utilise la méthode de tri simple
 * 
 * Pour aller plus loin on pourrait imaginer que le robot lent
 * prend plus de temps à creer un nouveau carton ect ..
 * Il suffirai donc juste de modifier ses méthodes de création
 * 
 * @author crabiller
 *
 */
public class RobotAncien extends Robot {
/**
 * Constructeur par defaut
 * @param typeCarton Type de carton trié par le robot
 */
	 public RobotAncien(Carton typeCarton){
		 	this.typeCarton = typeCarton;
		    this.typeTri= SimpleTri.getlnstance();
		  }   
	@Override
	/**
	 * Méthode de tri du robot
	 * @param La liste des articles a trier
	 */
	public List<Carton> trier(List<Article> listeArticle) throws CartonSizeException {
	  
	  return super.trier(listeArticle);
		
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
   return "Robot ancien : Algorithme utilisé pour le tri -> " + typeTri.toString() ;
 }
 
 
@Override
public void setTypeTri(TypeTri typeTri) {
 System.out.println("Je suis un vieux robot, je ne peux pas changer de méthode de tri");
  
}


@Override
public void setTypeCarton(Carton typeCarton) {
  System.out.println("Je suis un vieux robot, je ne peux pas changer de type de cartons");
}

 
}
