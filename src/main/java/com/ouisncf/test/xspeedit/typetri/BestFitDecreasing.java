package com.ouisncf.test.xspeedit.typetri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ouisncf.test.xspeedit.comparator.ArticlesComparator;
import com.ouisncf.test.xspeedit.exception.CartonSizeException;
import com.ouisncf.test.xspeedit.impl.Article;
import com.ouisncf.test.xspeedit.impl.Carton;
import com.ouisncf.test.xspeedit.impl.Robot;
import com.ouisncf.test.xspeedit.impl.TypeTri;
import com.ouisncf.test.xspeedit.util.TriUtil;

/**
 * Classe concrete représentant le tri par l'algorithme Best Fit decreasing Le
 * principe de cet algorithme est de chercher le carton le robot.
 * 
 * 
 * Fonctionnant en singleton, car l'on souhaite instancier une seule fois cette classe
 * @author crabiller
 *
 */
public class BestFitDecreasing implements TypeTri {

  private static BestFitDecreasing instance;
  
  private BestFitDecreasing() {
  
  // traitement du constructeur
  
  }
 
  public static synchronized BestFitDecreasing getlnstance() {
  
  if (instance == null) {
 
  instance = new BestFitDecreasing();
 
  }
 
  return instance;
  
  }

  public List<Carton> trier(List<Article> listeArticle, Robot robot)  {
  
    List<Article> listArticleTrie = new ArrayList<Article>();
    listArticleTrie.addAll(listeArticle);
    
    // on trie la liste des articles
    ArticlesComparator comparator = new ArticlesComparator();
    Collections.sort(listArticleTrie, comparator);

    // On créer la liste des cartons
    List<Carton> listeCarton = new ArrayList<Carton>();

    // On creer le premier carton
    Carton carton = robot.createCarton();

    // On ajoute le premier carton a la liste
    listeCarton.add(carton);

    // On boucle sur la liste des articles
    for (Article article : listArticleTrie) {
      if (TriUtil.notEmpty(article)) {
        if(article.getTaille()> carton.getTaille()){
          
          try {
            throw new CartonSizeException(article);
          } catch (CartonSizeException e) {
          //on affiche pas volontairement l'execption
          }
        
        }else{
        
       //Si on trouve un carton  eligible
        if (TriUtil.getBestEligibleCarton(listeCarton, article) != -1) {
        
          //On ajoute l'article au carton
          listeCarton.get(TriUtil.getBestEligibleCarton(listeCarton, article)).addArticle(article);
        
        } else {
           
          //On creer un nouveau carton
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
   return "Best Fit Decreasing";
  }
  
}