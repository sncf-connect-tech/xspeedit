package com.ouisncf.test.xspeedit.typetri;

import java.util.ArrayList;
import java.util.List;

import com.ouisncf.test.xspeedit.exception.CartonSizeException;
import com.ouisncf.test.xspeedit.impl.Article;
import com.ouisncf.test.xspeedit.impl.Carton;
import com.ouisncf.test.xspeedit.impl.Robot;
import com.ouisncf.test.xspeedit.impl.TypeTri;
import com.ouisncf.test.xspeedit.util.TriUtil;

/**
 * Classe concrete représentant le tri simple
 * Si un colis ne rentre pas dans le carton,
 * on en ouvre un autre
 * 
 * 
 * Fonctionnant en singleton, car l'on souhaite instancier une seule fois cette classe
 * @author crabiller
 *
 */
public class SimpleTri implements TypeTri {

  private static SimpleTri instance;
  
  private SimpleTri() {
  
  // traitement du constructeur
  
  }
 
  public static synchronized SimpleTri getlnstance() {
  
  if (instance == null) {
 
  instance = new SimpleTri();
 
  }
 
  return instance;
  
  }
/**
 * Methode de tri simple
 * Si le carton ne contient pas assez de place pour l'article
 * on en ouvre un autre
 * 
 */
  public List<Carton> trier(List<Article> listeArticle, Robot robot)   {

    
    // On créer la liste des cartons
    List<Carton> listeCarton = new ArrayList<Carton>();

    // On creer le premier carton
    Carton carton = robot.createCarton();

    // On ajoute le premier carton a la liste
    listeCarton.add(carton);

    // On boucle sur la liste des articles
    for (Article article : listeArticle) {
 
      if (TriUtil.notEmpty(article)) {
        
        if(article.getTaille()> carton.getTaille()){
         
          try {
            throw new CartonSizeException(article);
          } catch (CartonSizeException e) {
           //on affiche pas volontairement l'execption
          }
        
        }else{
        
         
          if(carton.getPlaceLibre()>= article.getTaille()){
            carton.addArticle(article);
          }else{
            carton = robot.createCarton(article);
            listeCarton.add(carton);
          }
          
      }
    }
    }
    return listeCarton;
  }

  /**
   * to String
   */
  public  String toString(){
   return "Tri simple";
  }
  
}