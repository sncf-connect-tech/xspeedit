package com.ouisncf.test.xspeedit.impl;

import java.util.List;

import com.ouisncf.test.xspeedit.exception.CartonSizeException;

/**
 * Classe abstraite représentant les types de tri. 
 * 
 * @author crabiller
 *
 */
public interface TypeTri {

 
  /**
   * Méthode abstraite de tri 
   * 
   * @param listeArticle  la liste des articles
   * @param robot  robot effectuant le tri
   * @return La liste des cartons utilisés pour le tri
   * @throws CartonSizeException 
   */
  public abstract List<Carton> trier(List<Article> listeArticle, Robot robot) throws CartonSizeException;

  public abstract String toString();
  
}