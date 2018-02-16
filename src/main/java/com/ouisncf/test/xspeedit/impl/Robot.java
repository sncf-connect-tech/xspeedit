package com.ouisncf.test.xspeedit.impl;

import java.util.List;

import com.ouisncf.test.xspeedit.exception.CartonSizeException;

/**
 * Classe abstraite représentant un Robot. Un robot peut trier des carton, en
 * "creer" des nouveaux. Dans notre cas, un robot peut trier une seule sorte de
 * carton à la fois. La méthode 'setTypeCarton' permet de changer le type de
 * carton trié par le robot.
 * 
 * @author crabiller
 *
 */
public abstract class Robot {



  // Type de carton trié par le robot
  protected Carton typeCarton;

  protected TypeTri typeTri;

  /**
   * Méthode permettant de retourner le type de tri du robot
   * 
   * @return ytype de tri
   */
  public TypeTri getTypeTri() {
    return typeTri;
  }

  /**
   * Methode permettant de trier
   * @param listeArticle
   * @return liste des cartons
   */
  public List<Carton> trier(List<Article> listeArticle) throws CartonSizeException {
    
    return typeTri.trier(listeArticle,this);
  }

  /**
   * Méthode abstraite de création de carton
   * 
   * @return le carton créer
   */
  public abstract Carton createCarton();

  
  /**
   * Méthode abstraite de création de carton avec un article
   * 
   * @return le carton créer
   */
  public abstract Carton createCarton(Article article);
  
  /**
   * Méthode to string
   * 
   * 
   */
  public abstract String toString();
  
  /**
   * Methode pour changer de type de tri
   * @param typeTri
   */
  public abstract void setTypeTri(TypeTri typeTri);
  
  /**
   * Methode pour changer de type de carton
   * @param typeCarton
   */
  public abstract void setTypeCarton(Carton typeCarton);
}